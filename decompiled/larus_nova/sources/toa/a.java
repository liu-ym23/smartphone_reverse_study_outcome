package toa;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.alarm.receiver.KeyAgreementUpdater;
import com.privacy.azerothprivacy.crypto.KeyAgeementException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import uoa.f;
import uoa.g;
import uoa.h;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f546969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static byte[] f546970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f546971c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Long> f546972d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Long> f546973e = null;

    /* JADX INFO: renamed from: toa.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class C7755a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f546974a = null;

        static {
            int[] r100 = new int[EllipticCurveType.values().length];
            f546974a = r100;
            r100[EllipticCurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f546974a[EllipticCurveType.CURVE25519.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        f546969a = AzerothPrivacy.getSdkConfig().f530152b.f530153a;
        f546970b = new byte[0];
        f546971c = new ConcurrentHashMap();
        f546972d = new ConcurrentHashMap();
        f546973e = new ConcurrentHashMap();
    }

    public static synchronized void f(String r100) {
        monitor-enter(a.class);
        ((ConcurrentHashMap) f546971c).remove(r100);     // Catch: Throwable -> L6 Exception -> L11
        ((ConcurrentHashMap) f546972d).remove(r100);     // Catch: Throwable -> L6 Exception -> L11
        ((ConcurrentHashMap) f546973e).remove(r100);     // Catch: Throwable -> L6 Exception -> L11
    L6:
        th = move-exception;
        throw th;
    L9:
        monitor-exit(a.class);
    }

    public static int h(EllipticCurveType r100) throws GeneralSecurityException {
        int r101 = C7755a.f546974a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 20241022;
    L5:
        if (r101 != 2) goto L9;
        return 20240308;
    L9:
        throw new GeneralSecurityException("Unable to parse EllipticCurveType: " + r100.getNumber());
    }

    public static g a(Context r100, String r101) {
        g r102 = new g(r101, 0, new byte[0]);
        r102 = d(r100, r101);     // Catch: Exception -> L17
        byte[] r103 = r102.f550974c;     // Catch: Exception -> L17
        if (r103 == null) goto L20;
        if (r103.length != 0) goto L20;
        ((ConcurrentHashMap) f546971c).remove(r101);     // Catch: Exception -> L17
    L14:
        apa.a.a("CRYPTO", "key hash is " + Arrays.toString(r102.f550974c));     // Catch: Exception -> L17
    L19:
        return r102;
    L20:
        boolean r104 = MessageDigest.isEqual(MessageDigest.getInstance("SHA-256").digest(r103), f546970b);     // Catch: NoSuchAlgorithmException -> L12 Exception -> L17
    L13:
        if (r104 == true) goto L14;
        apa.a.a("CRYPTO", "两者的密钥不相同");     // Catch: Exception -> L17
        ((ConcurrentHashMap) f546971c).remove(r101);     // Catch: Exception -> L17
        r102.f550974c = new byte[0];     // Catch: Exception -> L17
        throw new KeyAgeementException("hash is different with remote hash");     // Catch: Exception -> L17
    L12:
        r104 = false;
    L17:
        e = move-exception;
        xoa.a.a(e, "GetSharedSecret exception", null);
        goto L19
    }

    public static synchronized long b(Context r100, String r101) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r101 == null) goto L20;
        Map<String, Long> r102 = f546972d;     // Catch: Throwable -> L10
        if (((ConcurrentHashMap) r102).get(r101) != null) goto L12;
        epa.a r103 = epa.a.b(r100);     // Catch: Throwable -> L10
        String r104 = "AES_KEY_PRE_VERSION".concat(r101);     // Catch: Throwable -> L10
        r103.getClass();     // Catch: Throwable -> L10
        long r105 = epa.a.c(r104);     // Catch: Throwable -> L10
        if (r105 == 0) goto L14;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r102;     // Catch: Throwable -> L10
        r106.put(r101, Long.valueOf(r105));     // Catch: Throwable -> L10
    L14:
        if (r105 == 0) goto L18;
        monitor-exit(a.class);
        return r105;
    L18:
        throw new KeyAgeementException("key version is not exist");     // Catch: Throwable -> L10
    L12:
        r105 = ((Long) ((ConcurrentHashMap) r102).get(r101)).longValue();     // Catch: Throwable -> L10
        goto L14
    L20:
        throw new KeyAgeementException("input null uid");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized long c(Context r100, String r110) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r110 == null) goto L21;
        Map<String, Long> r101 = f546971c;     // Catch: Exception -> L17 Throwable -> L22
        if (((ConcurrentHashMap) r101).get(r110) != null) goto L10;
        epa.a r102 = epa.a.b(r100);     // Catch: Exception -> L17 Throwable -> L22
        String r103 = "AES_KEY_VERSION".concat(r110);     // Catch: Exception -> L17 Throwable -> L22
        r102.getClass();     // Catch: Exception -> L17 Throwable -> L22
        long r104 = epa.a.c(r103);     // Catch: Exception -> L17 Throwable -> L22
        if (r104 == 0) goto L12;
        ((ConcurrentHashMap) r101).put(r110, Long.valueOf(r104));     // Catch: Exception -> L17 Throwable -> L22
    L12:
        if (r104 == 0) goto L16;
        monitor-exit(a.class);
        return r104;
    L16:
        throw new KeyAgeementException("key version is not exist");     // Catch: Throwable -> L22
    L10:
        r104 = ((Long) ((ConcurrentHashMap) r101).get(r110)).longValue();     // Catch: Exception -> L17 Throwable -> L22
    L17:
        e = move-exception;
        throw new KeyAgeementException("getAzerothKeyVersionInternal exception" + e);     // Catch: Throwable -> L22
    L21:
        throw new KeyAgeementException("input null uid");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public static g d(Context r110, String r111) throws Exception {
        r111 = r111;
        uoa.e r100 = new h();     // Catch: Exception -> L5
    L7:
        EllipticCurveType r101 = r100.c();
        byte[] r102 = r100.a();
        String r103 = "key_version";
        JSONObject r112 = new JSONObject();
        String r104 = Base64.encodeToString(r102, 2);     // Catch: GeneralSecurityException -> L145 KeyAgeementException -> L149 IOException -> L151 JSONException -> L153 CommonHttpException -> L157
        long r113 = uoa.c.a(r110).getSerialNumber().longValue();     // Catch: KeyAgeementException -> L135 IOException -> L137 JSONException -> L139 CommonHttpException -> L142 GeneralSecurityException -> L145
        uoa.e r114 = r100;
        String r105 = AzerothPrivacy.getAppInfo().f530145d;     // Catch: GeneralSecurityException -> L121 KeyAgeementException -> L124 IOException -> L128 JSONException -> L130 CommonHttpException -> L132
        Object r115 = "shared_preference";
        r112.put("UID", CastLongProtector.parseLong(r111));     // Catch: CommonHttpException -> L96 GeneralSecurityException -> L98 KeyAgeementException -> L100 IOException -> L102 JSONException -> L104
        r103 = "key_version";
        r112.put("DeviceID", CastLongProtector.parseLong(r105));     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r112.put("ProtoVersion", h(r101));     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r112.put("ClientPK", r104);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r112.put("RequestType", 0);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r112.put("PriorCertVersion", r113);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", "req body is " + r112);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        StringBuilder r106 = new StringBuilder("req url is ");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        String r107 = f546969a;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r106.append(r107);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", r106.toString());     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        HashMap r108 = new HashMap();     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r108.put("Content-Type", "application/json");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        if (cpa.a.f464730a != null) goto L175;
        Pair r109 = null;
    L21:
        if (r109 != null) goto L178;
    L35:
        NetworkClient.ReqContext r116 = new NetworkClient.ReqContext();     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r116.addCommonParams = true;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        NetworkClient r117 = fpa.d.f478391a;     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        if (r117 != null) goto L39;
        r117 = NetworkClient.getDefault();     // Catch: GeneralSecurityException -> L75 KeyAgeementException -> L78 IOException -> L81 JSONException -> L83 CommonHttpException -> L96
    L78:
        e = e;
    L80:
        Throwable r118 = e;
        long r119 = 0;
    L107:
        Object r120 = r115;
    L156:
        HashMap r121 = new HashMap();
        r121.put(r103, String.valueOf(r119));
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r121.put(r120, epa.a.a().toString());
        xoa.a.a(r118, "KeyExchange Json exception", r121);
        g r122 = new g(r111, r119, new byte[0]);
    L162:
        return new g(r111, r122.f550972a, r114.b(r122.f550974c));
    L81:
        e = e;
    L75:
        e = e;
        r111 = r111;
    L77:
        GeneralSecurityException r123 = e;
        r119 = 0;
    L148:
        HashMap r124 = new HashMap();
        r124.put(r103, String.valueOf(r119));
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r124.put(r115, epa.a.a().toString());
        xoa.a.a(r123, "KeyExchange general security exception", r124);
        r122 = new g(r111, r119, new byte[0]);
    L83:
        e = e;
    L39:
        String r125 = r117.post(r107, r112.toString().getBytes(StandardCharsets.UTF_8), r108, r116);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        apa.a.a("CRYPTO", "resbody is " + r125);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        JSONObject r126 = new JSONObject(r125);     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
        r119 = JSONObjectProtectorUtils.getLong(r126, "KeyVersion");     // Catch: GeneralSecurityException -> L86 KeyAgeementException -> L89 IOException -> L92 JSONException -> L94 CommonHttpException -> L96
    L180:
        long r127 = JSONObjectProtectorUtils.getLong(r126, "ExpectExpiryTime");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r128 = (String) r126.get("SharedKeyHash");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r129 = (String) r126.get("ServerPK");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        String r130 = (String) r126.get("ServerCert");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111 = (String) r126.get("Signature");     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        if (r119 == 0) goto L54;
        if (uoa.c.b(r130) == false) goto L52;
        ByteArrayOutputStream r131 = new ByteArrayOutputStream();     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r131.write(Base64.decode(r130, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r131.write(Base64.decode(r129, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r131.write(Base64.decode(r128, 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        ByteBuffer r132 = ByteBuffer.allocate(8);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r132.order(ByteOrder.LITTLE_ENDIAN);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r132.putLong(r119);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r131.write(r132.array());     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r132.clear();     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r132.putLong(r127);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r131.write(r132.array());     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        apa.a.a("crypto", Base64.encodeToString(r131.toByteArray(), 0));     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        if (uoa.c.c(r111, r131.toByteArray()) == false) goto L50;
        f546970b = Base64.decode(r128, 0);     // Catch: GeneralSecurityException -> L65 KeyAgeementException -> L67 IOException -> L69 JSONException -> L71 CommonHttpException -> L73
        r111 = r111;
        g(r110, r119, r111, false);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        e(r110, r127, r111);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        r122 = new g(r111, r119, Base64.decode(r129, 0));     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
        goto L162
    L50:
        throw new GeneralSecurityException("body signature verification failed");     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L52:
        throw new GeneralSecurityException("server cert verification failed");     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L54:
        throw new GeneralSecurityException("invalid key version returned" + r119);     // Catch: GeneralSecurityException -> L55 KeyAgeementException -> L57 IOException -> L59 JSONException -> L61 CommonHttpException -> L63
    L63:
        e = e;
    L64:
        CommonHttpException r133 = e;
    L109:
        Object r134 = r115;
    L160:
        HashMap r135 = new HashMap();
        r135.put("exception_status_code", String.valueOf(r133.getResponseCode()));
        r135.put("http_request_body", r112.toString());
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r135.put(r134, epa.a.a().toString());
        r135.put("errMsg", r133.toString());
        bpa.a.g(r135);
        r122 = new g(r111, r119, new byte[0]);
    L57:
        e = e;
    L58:
        r118 = e;
    L59:
        e = e;
    L55:
        e = e;
    L56:
        r123 = e;
    L61:
        e = e;
    L73:
        e = e;
        r111 = r111;
    L67:
        e = e;
    L68:
        r111 = r111;
    L69:
        e = e;
    L65:
        e = e;
        r111 = r111;
    L71:
        e = e;
        goto L68
    L178:
        r108.put(r109.first, r109.second);     // Catch: GeneralSecurityException -> L24 KeyAgeementException -> L26 IOException -> L28 JSONException -> L30 CommonHttpException -> L33
    L33:
        e = move-exception;
        r133 = e;
        r111 = r111;
        r134 = r115;
        r119 = 0;
    L26:
        e = e;
    L27:
        r118 = e;
        r111 = r111;
        r120 = r115;
        r119 = 0;
    L28:
        e = e;
    L24:
        e = move-exception;
        r123 = e;
        r111 = r111;
        r119 = 0;
    L30:
        e = e;
        goto L27
    L175:
        r109 = cpa.a.f464730a.getRequestTagHeader();     // Catch: GeneralSecurityException -> L75 KeyAgeementException -> L78 IOException -> L81 JSONException -> L83 CommonHttpException -> L96
    L89:
        e = e;
    L92:
        e = e;
    L86:
        e = e;
        r111 = r111;
    L94:
        e = e;
        goto L80
    L96:
        e = move-exception;
        r111 = r111;
        r133 = e;
        r119 = 0;
    L100:
        e = e;
    L101:
        r103 = "key_version";
    L102:
        e = e;
    L98:
        e = e;
        r111 = r111;
        r103 = "key_version";
    L104:
        e = e;
        goto L101
    L132:
        e = e;
    L134:
        long r136 = 0;
        r133 = e;
        r134 = "shared_preference";
    L159:
        r119 = r136;
    L124:
        e = e;
    L126:
        long r137 = 0;
        r118 = e;
        r120 = "shared_preference";
    L155:
        r119 = r137;
    L128:
        e = e;
    L121:
        e = e;
    L123:
        r103 = "key_version";
        r115 = "shared_preference";
    L130:
        e = e;
        goto L126
    L142:
        e = e;
        r114 = r100;
    L135:
        e = e;
    L136:
        r114 = r100;
    L137:
        e = e;
    L139:
        e = e;
        goto L136
    L145:
        e = e;
        r114 = r100;
    L157:
        e = move-exception;
        r111 = r111;
        r114 = r100;
        r134 = "shared_preference";
        r136 = 0;
        r133 = e;
    L149:
        e = e;
    L154:
        r111 = r111;
        r114 = r100;
        r120 = "shared_preference";
        r137 = 0;
        r118 = e;
    L151:
        e = e;
    L153:
        e = e;
    L5:
        e = move-exception;
        apa.a.a("CRYPTO", "x25519 initialize failed " + e);
        r100 = new f();
        goto L7
    }

    public static void e(Context r100, long r101, String r102) {
        epa.a.b(r100).getClass();
        epa.a.d("KeyExpireTimeInUnixSeconds" + r102, r101);
        qoa.b.b(r100, new KeyAgreementUpdater());
    }

    public static synchronized void g(Context r100, long r101, String r102, boolean r110) throws KeyAgeementException {
        monitor-enter(a.class);
        if (r101 != 0) goto L30;
        monitor-exit(a.class);
        return;
    L30:
        if (r110 == false) goto L26;
        epa.a.b(r100).getClass();     // Catch: Throwable -> L15
        epa.a.d("AES_KEY_VERSION" + r102, r101);     // Catch: Throwable -> L15
        Long r103 = (Long) ((ConcurrentHashMap) f546972d).get(r102);     // Catch: Throwable -> L15
        if (r103 != null) goto L13;
        monitor-exit(a.class);
        return;
    L13:
        epa.a.d("AES_KEY_PRE_VERSION" + r102, r103.longValue());     // Catch: Throwable -> L15
    L20:
        monitor-exit(a.class);
        return;
    L26:
        ((ConcurrentHashMap) f546973e).put(r102, Long.valueOf(b(r100, r102)));     // Catch: Throwable -> L15 Exception -> L24
    L28:
        ((ConcurrentHashMap) f546972d).put(r102, Long.valueOf(c(r100, r102)));     // Catch: Throwable -> L15 Exception -> L25
    L19:
        ((ConcurrentHashMap) f546971c).put(r102, Long.valueOf(r101));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
