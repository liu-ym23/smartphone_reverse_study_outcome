package toa;

import android.content.Context;
import android.util.Base64;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.crypto.KeyAgeementException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    static {
    }

    public static String a(String r100, String r101, String r102) throws InvalidKeyException, JSONException, NoSuchAlgorithmException {
        d r103 = d.f546986h;
        Context r104 = AzerothPrivacy.getAppContext();
        r103.getClass();
        String r105 = AzerothPrivacy.getAppInfo().f530146e;
        long r106 = a.c(AzerothPrivacy.getAppContext(), r105);     // Catch: KeyAgeementException -> L10
        Key r107 = d.g(r104, r105, Long.valueOf(r106));
        if (r107 == null) goto L9;
        JSONObject r108 = new JSONObject();
        r108.put("typ", "JWT");
        r108.put("alg", "HS256");
        JSONObject r109 = new JSONObject();
        r109.put("uid", AzerothPrivacy.getAppInfo().f530146e);
        r109.put("logId", r100);
        r109.put("sctId", r101);
        r109.put(RemoteMessageConst.MSGID, r102);
        r109.put("ts", System.currentTimeMillis() / 1000);
        r109.put("dkv", String.valueOf(r106));
        String r110 = Base64.encodeToString(r108.toString().getBytes(StandardCharsets.UTF_8), 11);
        String r111 = Base64.encodeToString(r109.toString().getBytes(StandardCharsets.UTF_8), 11);
        Mac r112 = Mac.getInstance("HmacSHA256");
        r112.init(r107);
        return r110 + "." + r111 + "." + Base64.encodeToString(r112.doFinal((r110 + "." + r111).getBytes(StandardCharsets.UTF_8)), 11);
    L9:
        throw new InvalidKeyException("null key returned");
    L10:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    public static String b(String r100, String r101, String r102) throws JSONException, NoSuchAlgorithmException {
        JSONObject r103 = new JSONObject();
        r103.put("typ", "JWT");
        r103.put("alg", "Sha256");
        JSONObject r104 = new JSONObject();
        r104.put("uid", AzerothPrivacy.getAppInfo().f530146e);
        r104.put("logId", r100);
        r104.put("sctId", r101);
        r104.put(RemoteMessageConst.MSGID, r102);
        r104.put("ts", System.currentTimeMillis() / 1000);
        r104.put("dkv", "0");
        MessageDigest r105 = MessageDigest.getInstance("SHA-256");
        String r106 = Base64.encodeToString(r103.toString().getBytes(StandardCharsets.UTF_8), 11);
        String r107 = Base64.encodeToString(r104.toString().getBytes(StandardCharsets.UTF_8), 11);
        return r106 + "." + r107 + "." + Base64.encodeToString(r105.digest((r106 + "." + r107).getBytes(StandardCharsets.UTF_8)), 11);
    }
}
