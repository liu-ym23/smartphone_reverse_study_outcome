package y74;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.security.Sword.Sword;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.UByte;
import m74.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f566592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f566593b = null;

    public static class a extends e<SharedPreferences> {
        public a() {
        }

        @Override // m74.e
        public final SharedPreferences a(Object[] r100) {
            return ((Context) r100[0]).getSharedPreferences("dtrait_sp", 0);
        }
    }

    public d() {
    }

    static {
        f566592a = new a();
        f566593b = "0123456789ABCDEF".toCharArray();
    }

    public static String a(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = f566593b;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public static String b(JSONObject r100) {
        byte[] r101 = r100.toString().getBytes("UTF-8");     // Catch: Exception -> L8
        if (r101.length != 0) goto L6;
        return "";
    L6:
        return Sword.clientPackedBase64(r101, r101.length);
    L8:
        e = move-exception;
        m74.a.b("parseEncrypt#parse error: " + e.getMessage());
        return "";
    }

    public static String c(byte[] r110, String r111) throws Exception {
        if (TextUtils.isEmpty(r111) == false) goto L6;
        m74.a.b("encryptByRSA# error: publicKey is empty");
        return "";
    L6:
        String r112 = new String(Base64.decode(r111, 0)).replaceAll("\\n", "");
        if (r112.startsWith("-----BEGIN PUBLIC KEY-----") == false) goto L12;
        if (r112.endsWith("-----END PUBLIC KEY-----") == false) goto L12;
        PublicKey r113 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode(r112.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0)));
    L19:
        Cipher r100 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r100.init(1, r113);
        return Base64.encodeToString(r100.doFinal(r110), 2);
    L12:
        if (r112.startsWith("-----BEGIN RSA PUBLIC KEY-----") == false) goto L22;
        if (r112.endsWith("-----END RSA PUBLIC KEY-----") == false) goto L22;
        byte[] r114 = Base64.decode(r112.replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", ""), 0);
        int r101 = r114.length + 1;
        int r102 = r101 + 19;
        int[] r103 = {48, 130, (r102 >> 8) & 255, r102 & 255, 48, 13, 6, 9, 42, 134, 72, 134, 247, 13, 1, 1, 1, 5, 0, 3, 130, (r101 >> 8) & 255, r101 & 255, 0};
        byte[] r104 = new byte[24];
        int r105 = 0;
    L16:
        if (r105 >= 24) goto L18;
        r104[r105] = (byte) r103[r105];
        r105 = r105 + 1;
        goto L16
    L18:
        byte[] r106 = new byte[r114.length + 24];
        System.arraycopy(r104, 0, r106, 0, 24);
        System.arraycopy(r114, 0, r106, 24, r114.length);
        r113 = KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(new X509EncodedKeySpec(r106));
    L22:
        throw new InvalidKeyException();
    }
}
