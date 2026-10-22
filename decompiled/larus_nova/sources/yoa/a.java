package yoa;

import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import fpa.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
import xoa.b;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: yoa.a$a, reason: collision with other inner class name */
    public static class C8368a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f568684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f568685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f568686c;

        public C8368a() {
        }
    }

    public static byte[] d(InputStream r100, C8368a r101) throws IOException {
        byte[] r102 = new byte[16];
        r101.f568686c += 16;
        if (e.a(r100, r102, 16) < 16) goto L6;
        return r102;
    L6:
        throw new IllegalArgumentException("iv is too short");
    }

    public static void b(byte[] r110, InputStream r111, OutputStream r112) throws IOException, IllegalArgumentException, GeneralSecurityException {
        long r100 = System.currentTimeMillis();
        C8368a r101 = new C8368a();
        String r102 = null;
        c(r110, r111, r112, r101);     // Catch: Throwable -> L11 Exception -> L13 GeneralSecurityException -> L20 IllegalArgumentException -> L22 IOException -> L24
        JSONObject r103 = new JSONObject();
        JSONObject r113 = new JSONObject();
        JSONObject r114 = new JSONObject();
        r103.put("duration", System.currentTimeMillis() - r100);     // Catch: JSONException -> L7
        r103.put("size", r101.f568686c);     // Catch: JSONException -> L7
    L9:
        bpa.a.c("file_decrypt", 1, r114, r103, r113);
        return;
    L7:
        e = move-exception;
        apa.a.c("ImageXFileDecrypter", "json", e);
        goto L9
    L11:
        th = move-exception;
        String r115 = null;
        Throwable r104 = th;
        String r105 = null;
    L31:
        JSONObject r116 = new JSONObject();
        JSONObject r117 = new JSONObject();
        JSONObject r118 = new JSONObject();
        r116.put("duration", System.currentTimeMillis() - r100);     // Catch: JSONException -> L34
        r116.put("size", r101.f568686c);     // Catch: JSONException -> L34
        r118.put("exceptionType", r115);     // Catch: JSONException -> L34
        r118.put("magic", r101.f568684a);     // Catch: JSONException -> L34
        r118.put("dynamic", r101.f568685b);     // Catch: JSONException -> L34
        r117.put("errInfo", r105);     // Catch: JSONException -> L34
    L36:
        bpa.a.c("file_decrypt", 2, r118, r116, r117);
        throw r104;
    L34:
        e = move-exception;
        apa.a.c("ImageXFileDecrypter", "json", e);
    L24:
        e = e;
    L25:
        r115 = e.getClass().getName();     // Catch: Throwable -> L11
        r102 = e.getMessage();     // Catch: Throwable -> L28
        throw e;     // Catch: Throwable -> L28
    L28:
        th = th;
    L29:
        String r119 = r102;
        r104 = th;
        r105 = r119;
    L22:
        e = e;
    L20:
        e = e;
    L13:
        e = move-exception;
        b r106 = xoa.a.f564690a;     // Catch: Throwable -> L11
        b r107 = xoa.a.f564690a;     // Catch: Throwable -> L11
        xoa.a.a(e, "decryptImageXFile", null);     // Catch: Throwable -> L11
        String r120 = e.getClass().getName();     // Catch: Throwable -> L11
        r102 = e.getMessage();     // Catch: Throwable -> L18
        throw new IllegalArgumentException();     // Catch: Throwable -> L18
    L18:
        th = th;
        r115 = r120;
        goto L29
    }

    public static void c(byte[] r110, InputStream r111, OutputStream r112, C8368a r113) throws IOException, IllegalArgumentException, GeneralSecurityException {
        byte[] r100 = new byte[16];
        int r101 = e.a(r111, r100, 16);
        r113.f568686c += (long) r101;
        if (r101 < 16) goto L39;
        if (Arrays.equals("aes256cfb-direct".getBytes(), r100) == false) goto L8;
        r113.f568684a = "aes256cfb-direct";
        a(r110, d(r111, r113), r111, Long.MAX_VALUE, r112, r113);
        return;
    L8:
        if (Arrays.equals("aes-256-cfb-part".getBytes(), r100) == false) goto L36;
        r113.f568684a = "aes-256-cfb-part";
        byte[] r102 = new byte[20];
        int r103 = e.a(r111, r102, 20);
        r113.f568686c += (long) r103;
        if (r103 < 20) goto L35;
        ByteBuffer r104 = ByteBuffer.wrap(r102);
        ByteOrder r105 = ByteOrder.LITTLE_ENDIAN;
        ByteBuffer r106 = r104.order(r105);
        if (r106.getShort() != 0) goto L33;
        short r107 = r106.getShort();
        r113.f568685b = r107;
        if (r107 != 0) goto L16;
        long r108 = r106.getLong();
    L29:
        if (a(r110, d(r111, r113), r111, r108, r112, r113) == false) goto L29;
        return;
    L16:
        if (r107 != 1) goto L26;
        r106.getLong();
        long r109 = r106.getLong();
        int r114 = (int) (8 * r109);
        byte[] r115 = new byte[r114];
        if (e.a(r111, r115, r114) < r114) goto L24;
        ByteBuffer r116 = ByteBuffer.wrap(r115).order(r105);
        byte[] r117 = d(r111, r113);
        long r118 = 0;
    L21:
        if (r118 >= r109) goto L43;
        a(r110, r117, r111, r116.getLong(), r112, r113);
        r118 = r118 + 1;
        goto L21
    L43:
        return;
    L24:
        throw new IllegalArgumentException("info is too short");
    L26:
        throw new IllegalArgumentException("unsupported dynamic");
    L33:
        throw new IllegalArgumentException("unsupported version");
    L35:
        throw new IllegalArgumentException("too short");
    L36:
        r113.f568684a = Base64.encodeToString(r100, 2);
        throw new IllegalArgumentException("unsupported magic");
    L39:
        throw new IllegalArgumentException("too short");
    }

    public static boolean a(byte[] r100, byte[] r101, InputStream r102, long r110, OutputStream r111, C8368a r112) throws GeneralSecurityException, IOException {
        Cipher r103 = Cipher.getInstance("AES/CFB/NoPadding");
        r103.init(2, new SecretKeySpec(r100, CryptoConst.ALGORITHM_AES), new IvParameterSpec(r101));
        byte[] r104 = new byte[1024];
        int r105 = 0;
    L3:
        long r106 = r105;
        if (r106 >= r110) goto L10;
        int r107 = e.a(r102, r104, (int) Math.min(r110 - r106, 1024));
        if (r107 <= 0) goto L10;
        r112.f568686c += (long) r107;
        r105 = r105 + r107;
        int r108 = r103.update(r104, 0, r107, r104);
        if (r108 <= 0) goto L3;
        r111.write(r104, 0, r108);
    L10:
        r111.write(r104, 0, r103.doFinal(r104, 0));
        if (r106 >= r110) goto L20;
        return true;
    L20:
        return false;
    }
}
