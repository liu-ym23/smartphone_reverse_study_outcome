package toa;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyProtection;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.privacy.azerothprivacy.crypto.KeyAgeementException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.json.JSONException;
import org.json.JSONObject;
import uoa.g;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static KeyStore f546980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Key> f546981c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Key> f546982d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Key> f546983e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f546984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f546985g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f546986h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Object, Future<Boolean>> f546987a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f546988a = null;

        static {
            f546988a = new d();
        }
    }

    static {
        f546981c = new ConcurrentHashMap();
        f546982d = new ConcurrentHashMap();
        f546983e = new ConcurrentHashMap();
        f546985g = new AtomicInteger(0);
        f546986h = a.f546988a;
    }

    public d() {
        this.f546987a = new ConcurrentHashMap();
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L5
        f546980b = r100;     // Catch: Exception -> L5
        r100.load(null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        f546980b = null;
        f546984f = true;
        apa.a.c("AzerothKeystore", "failed to get AndroidKeyStore instance", e);
        xoa.a.a(e, "failed to load android key store", null);
    }

    public static uoa.b a(final Context r100) throws InvalidKeyException {
        final String r101 = AzerothPrivacy.getAppInfo().f530146e;
        long r102 = toa.a.c(AzerothPrivacy.getAppContext(), r101);     // Catch: KeyAgeementException -> L10
        Key r103 = h(r100, r101, Long.valueOf(r102));
        if (r103 == null) goto L9;
        return new uoa.b(r102, r103);
    L9:
        throw new InvalidKeyException("null key returned");
    L11:
        if (f546985g.compareAndSet(0, 1) == false) goto L14;
        ThreadMethodProxy.start(new PthreadThreadV2(new c(r100, r101), "AzerothKeystore"));
    L14:
        throw new InvalidKeyException("zero key version returned");
    }

    public static void f(g r110) throws KeyStoreException {
        int r100 = 1;
    L4:
        if (r100 > 3) goto L17;
        SecretKeySpec r101 = new SecretKeySpec(r110.f550974c, CryptoConst.ALGORITHM_AES);     // Catch: KeyStoreException -> L7
        f546980b.setEntry(r110.a("aes_key"), new KeyStore.SecretKeyEntry(r101), new KeyProtection.Builder(3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());     // Catch: KeyStoreException -> L7
        f546980b.deleteEntry(j("aes_key", r110.f550973b));     // Catch: KeyStoreException -> L7
        SecretKeySpec r102 = new SecretKeySpec(r110.f550974c, "HmacSHA256");     // Catch: KeyStoreException -> L7
        f546980b.setEntry(r110.a("hmacsha256_key"), new KeyStore.SecretKeyEntry(r102), new KeyProtection.Builder(4).setDigests(new String[]{"SHA-256"}).build());     // Catch: KeyStoreException -> L7
        f546980b.deleteEntry(j("hmacsha256_key", r110.f550973b));     // Catch: KeyStoreException -> L7
        return;
    L7:
        e = move-exception;
        String r103 = e.toString();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        r104.put("AzerothKeystore", r103);     // Catch: JSONException -> L11
        r105.put("failed_count", r100);     // Catch: JSONException -> L11
    L13:
        bpa.a.b("crypto", r104, r105, null);
        if (r100 == 3) goto L16;
        r100 = r100 + 1;
        goto L4
    L16:
        throw e;
    L11:
        e = move-exception;
        xoa.a.a(e, "key store error event reporter Json exception", null);
        goto L13
    }

    public static Key b(Context r100, long r101) throws Exception {
        String r102 = AzerothPrivacy.getAppInfo().f530146e;
        String r103 = i("sub_aes_key", r102, Long.valueOf(r101));
        Key r104 = (Key) ((ConcurrentHashMap) f546983e).get(r103);
        if (r104 != null) goto L9;
        Key r105 = h(r100, r102, Long.valueOf(r101));
        if (r105 == null) goto L8;
        r104 = l(r102, new uoa.b(r101, r105));
        goto L9
    L8:
        throw new KeyStoreException("null root key returned");
    L9:
        if (r104 == null) goto L12;
        return r104;
    L12:
        throw new KeyStoreException("null sub key returned");
    }

    public static void d(g r100, Context r101) {
        epa.a r102 = epa.a.b(r101);
        String r103 = Base64.encodeToString(r100.f550974c, 2);
        String r104 = r100.a("aes_key");
        r102.getClass();
        epa.a.e(r104, r103);
        String r105 = j("aes_key", r100.f550973b);
        epa.a.f473441c.remove(r105);
        epa.a.f473441c.commit();
    }

    public static void e(g r100, Context r110) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, KeyStoreException {
        epa.a r101 = epa.a.b(r110);
        GregorianCalendar r102 = new GregorianCalendar();
        GregorianCalendar r103 = new GregorianCalendar();
        r103.add(1, 1);
        KeyPairGeneratorSpec r104 = new KeyPairGeneratorSpec.Builder(r110).setAlias(r100.a("rsa_private_key")).setSubject(new X500Principal("CN=" + r100.a("rsa_private_key"))).setSerialNumber(new BigInteger(63, new SecureRandom())).setStartDate(r102.getTime()).setEndDate(r103.getTime()).build();
        KeyPairGenerator r105 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a, "AndroidKeyStore");
        r105.initialize(r104);
        PublicKey r106 = r105.generateKeyPair().getPublic();
        Cipher r107 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r107.init(1, r106);
        String r108 = Base64.encodeToString(r107.doFinal(r100.f550974c), 2);
        String r109 = r100.a("aes_key");
        r101.getClass();
        epa.a.e(r109, r108);
        epa.a.f473441c.remove(j("aes_key", r100.f550973b));
        epa.a.f473441c.commit();
        f546980b.deleteEntry(j("rsa_private_key", r100.f550973b));
    }

    public static String j(String r100, String r101) {
        String r102 = toa.a.f546969a;
        monitor-enter(toa.a.class);
        Long r103 = (Long) ((ConcurrentHashMap) toa.a.f546973e).get(r101);     // Catch: Throwable -> L8
        monitor-exit(toa.a.class);
        return r100 + r101 + String.valueOf(r103);
    L8:
        th = move-exception;
        throw th;
    }

    public static Key l(String r100, uoa.b r101) {
        long r102 = CastLongProtector.parseLong(r100);     // Catch: Exception -> L4
        ByteBuffer r103 = ByteBuffer.allocate(8);     // Catch: Exception -> L4
        r103.order(ByteOrder.LITTLE_ENDIAN).putLong(r102);     // Catch: Exception -> L4
        byte[] r104 = r103.array();     // Catch: Exception -> L4
        Key r105 = r101.f550961b;     // Catch: Exception -> L4
        Cipher r106 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L4
        byte[] r107 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};     // Catch: Exception -> L4
        r106.init(1, r105, new GCMParameterSpec(128, r107));     // Catch: Exception -> L4
        ByteBuffer r108 = ByteBuffer.allocate(r106.doFinal(r104).length + 12);     // Catch: Exception -> L4
        r108.put(r107);     // Catch: Exception -> L4
        SecretKeySpec r109 = new SecretKeySpec(r108.array(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L4
        String r110 = i("sub_aes_key", r100, Long.valueOf(r101.f550960a));     // Catch: Exception -> L4
        ((ConcurrentHashMap) f546983e).put(r110, r109);     // Catch: Exception -> L4
        return r109;
    L4:
        e = move-exception;
        HashMap r111 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r111.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "sub key initial exception", r111);
        return null;
    }

    public final void c(final Context r110, final String r111) {
        if (NetworkUtils.isNetworkAvailable(AzerothPrivacy.getAppContext()) == false) goto L68;
        if (dpa.d.a().cryptoSetting.disable_crypto == true) goto L68;
        long r100 = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        int r102 = 0;
        Future<Boolean> r103 = null;
        r101.put("AzerothKeystore", "GetSharedSecret");     // Catch: Throwable -> L40 Exception -> L43
        d r112 = f546986h;     // Catch: Throwable -> L40 Exception -> L43
        Future<Boolean> r113 = r112.f546987a.get("initKeys");     // Catch: Throwable -> L40 Exception -> L43
        if (r113 == null) goto L85;
        r103 = r113;
    L72:
        boolean r104 = r103.get(3, TimeUnit.SECONDS).booleanValue();     // Catch: Throwable -> L36 Exception -> L38
        if (r104 == true) goto L76;
        toa.a.f(r111);     // Catch: Exception -> L38 Throwable -> L57
        r102 = 3;
    L76:
        apa.a.a("CRYPTO", "InitialKey result is " + r104);     // Catch: Throwable -> L34 Exception -> L38
        r112.f546987a.remove("initKeys", r103);     // Catch: Throwable -> L34 Exception -> L38
    L86:
        long r105 = toa.a.c(r110, r111);     // Catch: Exception -> L30
    L91:
        long r106 = toa.a.b(r110, r111);     // Catch: Exception -> L33
        int r114 = r102;
    L52:
        long r107 = r106;
        int r108 = r114;
        long r109 = r105;
    L55:
        bpa.a.e(r100, r108, r109, r107, r101);
        return;
    L33:
        r108 = r102;
    L54:
        r109 = r105;
        r107 = 0;
    L30:
        r105 = 0;
    L34:
        th = th;
        int r115 = r102;
    L74:
        long r116 = toa.a.c(r110, r111);     // Catch: Exception -> L61
    L83:
        long r117 = toa.a.b(r110, r111);     // Catch: Exception -> L64
    L65:
        bpa.a.e(r100, r115, r116, r117, r101);
        throw th;
    L64:
        r117 = 0;
    L61:
        r116 = 0;
    L36:
        th = th;
    L42:
        r115 = 0;
    L38:
        e = e;
    L45:
        r113 = r103;
    L46:
        toa.a.f(r111);     // Catch: Throwable -> L57
        HashMap r118 = new HashMap();     // Catch: Throwable -> L57
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();     // Catch: Throwable -> L57
        r118.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L57
        xoa.a.a(e, "key initial remote exception", r118);     // Catch: Throwable -> L57
        f546986h.f546987a.remove("initKeys", r113);     // Catch: Throwable -> L57
        r105 = toa.a.c(r110, r111);     // Catch: Exception -> L49
    L88:
        r106 = toa.a.b(r110, r111);     // Catch: Exception -> L53
        r114 = 3;
    L53:
        r108 = 3;
    L49:
        r105 = 0;
        goto L88
    L85:
    L79:
        FutureTask r119 = new FutureTask(new b(this, r110, r111));     // Catch: Exception -> L18 Throwable -> L36
        r103 = r112.f546987a.putIfAbsent("initKeys", r119);     // Catch: Exception -> L18 Throwable -> L36
        if (r103 != null) goto L72;
        r119.run();     // Catch: Exception -> L16 Throwable -> L36
        r103 = r119;
    L16:
        e = e;
        r113 = r119;
    L18:
        e = e;
    L20:
        e = e;
    L57:
        th = th;
        r115 = 3;
    L43:
        e = e;
    L40:
        th = th;
    }

    public static Key g(Context r100, String r101, Long r102) {
        if (f546984f == true) goto L12;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        return f546980b.getKey(i("hmacsha256_key", r101, r102), null);
    L9:
        e = move-exception;
        apa.a.b("CRYPTO", "GetHmacSHA256Key exceptions:" + e);
        HashMap r103 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r103.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "retrieve hmac key exception", r103);
        return null;
    L12:
        return h(r100, r101, r102);
    }

    public static Key h(Context r110, String r111, Long r112) {
        epa.a r113 = epa.a.b(r110);
        String r100 = i("aes_key", r111, r112);     // Catch: KeyAgeementException -> L36
        apa.a.a("CRYPTO", "start get key:" + r100);
        if (f546984f == false) goto L37;
        Map<String, Key> r114 = f546982d;
        Key r115 = (Key) ((ConcurrentHashMap) r114).get(r100);
        if (r115 != null) goto L17;
        r113.getClass();
        String r116 = epa.a.f473440b.getString(r100, "");
        if (TextUtils.isEmpty(r116) == true) goto L17;
        byte[] r117 = Base64.decode(r116, 0);     // Catch: Exception -> L15
        if (r117.length != 32) goto L13;
        ((ConcurrentHashMap) r114).put(r100, new SecretKeySpec(r117, CryptoConst.ALGORITHM_AES));     // Catch: Exception -> L15
        r115 = (Key) ((ConcurrentHashMap) r114).get(r100);     // Catch: Exception -> L15
    L38:
        goto L17
    L13:
        epa.a.e(r100, "");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        apa.a.b("CRYPTO", "GetKey exceptions:" + e);
        HashMap r118 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r118.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "plane B retrieve key exception", r118);
        epa.a.e(r100, "");
    L17:
        return r115;
    L37:
    L33:
        e = move-exception;
        apa.a.b("CRYPTO", "GetKey exceptions:" + e);
        HashMap r119 = new HashMap();
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();
        r119.put("shared_preference", epa.a.a().toString());
        xoa.a.a(e, "retrieve key exception", r119);
        goto L35
    L19:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        Map<String, Key> r101 = f546981c;     // Catch: Exception -> L33
        Key r120 = (Key) ((ConcurrentHashMap) r101).get(r100);     // Catch: Exception -> L33
        if (r120 != null) goto L32;
        PrivateKey r121 = (PrivateKey) f546980b.getKey(i("rsa_private_key", r111, r112), null);     // Catch: Exception -> L33
        r113.getClass();     // Catch: Exception -> L33
        String r122 = epa.a.f473440b.getString(r100, "");     // Catch: Exception -> L33
        if (r121 == null) goto L32;
        if (TextUtils.isEmpty(r122) == true) goto L32;
        Cipher r123 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L33
        r123.init(2, r121);     // Catch: Exception -> L33
        byte[] r124 = r123.doFinal(Base64.decode(r122, 0));     // Catch: Exception -> L33
        if (r124.length != 32) goto L31;
        r120 = new SecretKeySpec(r124, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L33
    L31:
        ((ConcurrentHashMap) r101).put(r100, r120);     // Catch: Exception -> L33
    L32:
        return r120;
    L21:
        return f546980b.getKey(r100, null);
    L35:
        return null;
    }

    public static String i(String r100, String r101, Long r102) throws KeyAgeementException {
        if (r102 != null) goto L5;
        r102 = Long.valueOf(toa.a.c(AzerothPrivacy.getAppContext(), r101));
    L5:
        return r100 + r101 + r102;
    }

    public static void k(Context r100, String r101, Key r102) {
        l(r101, new uoa.b(toa.a.c(r100, r101), r102));
        return;
    L5:
        e = move-exception;
        xoa.b r103 = xoa.a.f564690a;
        xoa.b r104 = xoa.a.f564690a;
        xoa.a.a(e, "init subkey failed", null);
    }
}
