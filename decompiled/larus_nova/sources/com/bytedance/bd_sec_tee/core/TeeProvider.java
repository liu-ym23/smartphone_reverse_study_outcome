package com.bytedance.bd_sec_tee.core;

import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.bd_sec_tee.core.model.TeeResult;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class TeeProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, KeyPair> f199564g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile byte[] f199565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, TeeResult<String>> f199566i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f199567j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap<String, SecretKey> f199568k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f199569l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h74.a f199570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f199572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f199573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i74.a f199574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Random f199575f;

    public static final enum TeeStage extends Enum<TeeStage> {
        public static final TeeStage DERIVE_LOAD_SECRET = null;
        public static final TeeStage DERIVE_SIGN = null;
        public static final TeeStage LOAD_KEYPAIR = null;
        public static final TeeStage PUBLIC_COMPARE = null;
        public static final TeeStage SIGN = null;
        public static final TeeStage SIGN_COMPARE = null;
        public static final TeeStage VERIFY_COMPARE = null;
        public static final TeeStage VERIFY_SIGN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TeeStage[] f199576a = null;
        public final String value;

        static {
            TeeStage r100 = new TeeStage("LOAD_KEYPAIR", 0, "load_keypair");
            LOAD_KEYPAIR = r100;
            TeeStage r101 = new TeeStage("SIGN", 1, "sign");
            SIGN = r101;
            TeeStage r102 = new TeeStage("SIGN_COMPARE", 2, "sign_compare");
            SIGN_COMPARE = r102;
            TeeStage r103 = new TeeStage("PUBLIC_COMPARE", 3, "public_compare");
            PUBLIC_COMPARE = r103;
            TeeStage r104 = new TeeStage("DERIVE_SIGN", 4, "derive_sign");
            DERIVE_SIGN = r104;
            TeeStage r105 = new TeeStage("DERIVE_LOAD_SECRET", 5, "derive_load_secret");
            DERIVE_LOAD_SECRET = r105;
            TeeStage r110 = new TeeStage("VERIFY_SIGN", 6, "verify_sign");
            VERIFY_SIGN = r110;
            TeeStage r111 = new TeeStage("VERIFY_COMPARE", 7, "verify_compare");
            VERIFY_COMPARE = r111;
            f199576a = new TeeStage[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static TeeStage[] values() {
            return (TeeStage[]) f199576a.clone();
        }

        public static TeeStage valueOf(String r100) {
            return (TeeStage) r27.a.a(TeeStage.class, r100);
        }

        public TeeStage(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void d(String r100);

        void e(String r100, Throwable r101);

        void i();

        void w(String r100);
    }

    public interface b {
        void onEvent(JSONObject r100);
    }

    static {
        f199564g = new ConcurrentHashMap();
        f199565h = null;
        f199566i = new ConcurrentHashMap();
        f199567j = new Object();
        new ConcurrentHashMap();
        f199568k = new ConcurrentHashMap();
        f199569l = new Object();
    }

    public final KeyPair b() throws Exception {
        this.f199570a.getClass();
        this.f199570a.getClass();
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "AndroidKeyStore");
        r100.initialize(new KeyGenParameterSpec.Builder("sec_tee_key_v1", 4).setDigests(new String[]{"SHA-256"}).build());
        a r101 = this.f199570a.f483982a;
        if (r101 == null) goto L6;
        r101.d("getOrCreateKeyPair: generating new key alias");
    L6:
        return r100.generateKeyPair();
    }

    public final KeyPair c() throws Exception {
        this.f199570a.getClass();
        this.f199570a.getClass();
        this.f199570a.getClass();
        KeyPairGenerator r100 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "AndroidKeyStore");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.f199570a.getClass();
        KeyGenParameterSpec.Builder r101 = new KeyGenParameterSpec.Builder("sec_tee_key_v1", 4).setDigests(new String[]{"SHA-256"});
        this.f199570a.getClass();
        r101.setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1"));
        this.f199570a.getClass();
        r100.initialize(r101.build());
    L5:
        this.f199570a.getClass();
        a r102 = this.f199570a.f483982a;
        if (r102 == null) goto L9;
        r102.i();
    L9:
        return r100.generateKeyPair();
    }

    public final TeeResult<KeyPair> d() {
        long r100 = System.currentTimeMillis();
        ConcurrentHashMap<String, KeyPair> r101 = f199564g;
        this.f199570a.getClass();
        KeyPair r102 = r101.get("sec_tee_key_v1");
        if (r102 == null) goto L7;
        TeeStage r103 = TeeStage.LOAD_KEYPAIR;
        long r104 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.d(r103, r102, r104, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_SUCCESS, TeeResult.KeySource.MEMORY);
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        a r105 = this.f199570a.f483982a;
        if (r105 == null) goto L11;
        r105.w("TEE requires Android M (23+)");
    L11:
        boolean r106 = false;
    L13:
        if (r106 == true) goto L16;
        TeeStage r107 = TeeStage.LOAD_KEYPAIR;
        long r110 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.a(r107, -1000, "TEE requires Android M (23+)", r110, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_ERROR);
    L16:
        this.f199570a.getClass();
        KeyPair r111 = r101.get("sec_tee_key_v1");
        if (r111 == null) goto L20;
        TeeStage r108 = TeeStage.LOAD_KEYPAIR;
        long r112 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.d(r108, r111, r112, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_SUCCESS, TeeResult.KeySource.MEMORY);
    L20:
        this.f199570a.getClass();
        int r109 = Math.max(1, 3);
        Exception e100 = null;
        int r113 = 0;
    L22:
        if (r113 > r109) goto L52;
        this.f199570a.getClass();     // Catch: Exception -> L48
        KeyStore r114 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L48
        r114.load(null);     // Catch: Exception -> L48
        this.f199570a.getClass();     // Catch: Exception -> L48
        if (r114.containsAlias("sec_tee_key_v1") == true) goto L26;
        this.f199570a.getClass();     // Catch: Exception -> L48
        KeyPair r115 = b();     // Catch: Exception -> L48
        TeeResult.KeySource r116 = TeeResult.KeySource.SYSTAM;     // Catch: Exception -> L48
    L27:
        if (r115 != null) goto L36;
        this.f199570a.getClass();     // Catch: Exception -> L48
        KeyStore.PrivateKeyEntry r117 = (KeyStore.PrivateKeyEntry) r114.getEntry("sec_tee_key_v1", null);     // Catch: Exception -> L48
        if (r117 == null) goto L34;
        a r118 = this.f199570a.f483982a;     // Catch: Exception -> L48
        if (r118 == null) goto L33;
        r118.d("getOrCreateKeyPair: use existing key alias");     // Catch: Exception -> L48
    L33:
        r115 = new KeyPair(r117.getCertificate().getPublicKey(), r117.getPrivateKey());     // Catch: Exception -> L48
    L35:
        r116 = TeeResult.KeySource.ANDROID_KEYSTORE;     // Catch: Exception -> L48
        goto L36
    L34:
        r115 = null;
    L36:
        if (r115 != null) goto L38;
        this.f199570a.getClass();     // Catch: Exception -> L48
        KeyPair r119 = b();     // Catch: Exception -> L48
        TeeResult.KeySource r120 = TeeResult.KeySource.SYSTAM_AGAIN;     // Catch: Exception -> L48
    L64:
        if (r119 == null) goto L44;
        this.f199572c = 0;     // Catch: Exception -> L48
        this.f199573d = 0;     // Catch: Exception -> L48
        ConcurrentHashMap<String, KeyPair> r121 = f199564g;     // Catch: Exception -> L48
        this.f199570a.getClass();     // Catch: Exception -> L48
        r121.put("sec_tee_key_v1", r119);     // Catch: Exception -> L48
        i(r119.getPublic());     // Catch: Exception -> L48
        TeeStage r122 = TeeStage.LOAD_KEYPAIR;     // Catch: Exception -> L48
        long r123 = System.currentTimeMillis() - r100;     // Catch: Exception -> L48
        this.f199570a.getClass();     // Catch: Exception -> L48
        return TeeResult.c(r122, r119, r123, TeeResult.ResultType.KEYPAIR_NEW, r113, r120);
    L44:
        TeeStage r124 = TeeStage.LOAD_KEYPAIR;     // Catch: Exception -> L46
        long r125 = System.currentTimeMillis() - r100;     // Catch: Exception -> L46
        this.f199570a.getClass();     // Catch: Exception -> L46
        return TeeResult.b(r124, -1002, "keyPair is null", r125, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_NEW, r113, r120);
    L46:
        e100 = e;
    L50:
        ConcurrentHashMap<String, KeyPair> r126 = f199564g;
        this.f199570a.getClass();
        r126.remove("sec_tee_key_v1");
        e("getKeyPair load attempt error", e100);
        k();
        r113 = r19 + 1;
        goto L22
    L38:
        r119 = r115;
        r120 = r116;
        goto L64
    L26:
        r115 = null;
        r116 = null;
    L48:
        e100 = e;
        int r127 = r113;
        goto L50
    L52:
        if (this.f199573d != 0) goto L54;
        this.f199573d = System.currentTimeMillis();
    L54:
        this.f199572c++;
        this.f199570a.getClass();
        int r128 = this.f199572c;
        this.f199570a.getClass();
        if (r128 < Math.max(1, 3)) goto L62;
        int r129 = 0;
    L57:
        if (r129 > r109) goto L62;
        KeyPair r130 = c();     // Catch: Exception -> L60
        this.f199572c = 0;     // Catch: Exception -> L60
        this.f199573d = 0;     // Catch: Exception -> L60
        ConcurrentHashMap<String, KeyPair> r131 = f199564g;     // Catch: Exception -> L60
        this.f199570a.getClass();     // Catch: Exception -> L60
        r131.put("sec_tee_key_v1", r130);     // Catch: Exception -> L60
        i(r130.getPublic());     // Catch: Exception -> L60
        TeeStage r132 = TeeStage.LOAD_KEYPAIR;     // Catch: Exception -> L60
        long r133 = System.currentTimeMillis() - r100;     // Catch: Exception -> L60
        this.f199570a.getClass();     // Catch: Exception -> L60
        return TeeResult.c(r132, r130, r133, TeeResult.ResultType.KEYPAIR_NEW, r129, TeeResult.KeySource.SYSTAM_SELF);
    L60:
        e100 = e;
        ConcurrentHashMap<String, KeyPair> r134 = f199564g;
        this.f199570a.getClass();
        r134.remove("sec_tee_key_v1");
        e("generateKeyPair attempt error", e100);
        k();
        r129 = r129 + 1;
    L62:
        TeeStage r135 = TeeStage.LOAD_KEYPAIR;
        String r136 = "getKeyPair failed: " + e100;
        long r137 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.a(r135, -1001, r136, r137, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_ERROR);
    L12:
        r106 = true;
        goto L13
    }

    public final TeeResult f() {
        long r100 = System.currentTimeMillis();
        this.f199570a.getClass();
        if (TextUtils.isEmpty("badger_mac_key_v1") == true) goto L64;
        this.f199570a.getClass();
        if (TextUtils.isEmpty("HmacSHA256") == true) goto L64;
        this.f199570a.getClass();
        if (TextUtils.isEmpty("AndroidKeyStore") == true) goto L64;
        ConcurrentHashMap<String, SecretKey> r101 = f199568k;
        this.f199570a.getClass();
        SecretKey r102 = r101.get("badger_mac_key_v1");
        if (r102 == null) goto L13;
        TeeStage r103 = TeeStage.DERIVE_LOAD_SECRET;
        long r104 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.d(r103, r102, r104, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_SUCCESS, TeeResult.KeySource.MEMORY);
    L13:
        int r105 = Build.VERSION.SDK_INT;
        if (r105 >= 23) goto L19;
        a r106 = this.f199570a.f483982a;
        if (r106 == null) goto L18;
        r106.w("TEE requires Android M (23+)");
    L18:
        boolean r107 = false;
    L20:
        if (r107 == true) goto L23;
        TeeStage r108 = TeeStage.DERIVE_LOAD_SECRET;
        long r110 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.a(r108, -1000, "TEE requires Android M (23+)", r110, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL);
    L23:
        Object r109 = f199569l;
        monitor-enter(r109);
        this.f199570a.getClass();     // Catch: Throwable -> L57
        SecretKey r111 = r101.get("badger_mac_key_v1");     // Catch: Throwable -> L57
        if (r111 == null) goto L30;
        TeeStage r112 = TeeStage.DERIVE_LOAD_SECRET;     // Catch: Throwable -> L57
        long r113 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        TeeResult r114 = TeeResult.d(r112, r111, r113, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_SUCCESS, TeeResult.KeySource.MEMORY);     // Catch: Throwable -> L57
        monitor-exit(r109);     // Catch: Throwable -> L61
        return r114;
    L30:
        this.f199570a.getClass();     // Catch: Throwable -> L57
        KeyStore r115 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L57
        r115.load(null);     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        if (r115.containsAlias("badger_mac_key_v1") == false) goto L42;
        this.f199570a.getClass();     // Catch: Throwable -> L57
        KeyStore.Entry r116 = r115.getEntry("badger_mac_key_v1", null);     // Catch: Throwable -> L57
        if ((r116 instanceof KeyStore.SecretKeyEntry) == false) goto L39;
        SecretKey r117 = ((KeyStore.SecretKeyEntry) r116).getSecretKey();     // Catch: Throwable -> L57
        if (r117 == null) goto L39;
        this.f199570a.getClass();     // Catch: Throwable -> L57
        r101.put("badger_mac_key_v1", r117);     // Catch: Throwable -> L57
        TeeStage r118 = TeeStage.DERIVE_LOAD_SECRET;     // Catch: Throwable -> L57
        long r119 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        TeeResult r120 = TeeResult.d(r118, r117, r119, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_SUCCESS, TeeResult.KeySource.ANDROID_KEYSTORE);     // Catch: Throwable -> L57
        monitor-exit(r109);     // Catch: Throwable -> L61
        return r120;
    L39:
        a r121 = this.f199570a.f483982a;     // Catch: Throwable -> L57
        if (r121 == null) goto L42;
        r121.w("obtainHmacKey: alias exists but not SecretKey, re-generating...");     // Catch: Throwable -> L57
    L42:
        this.f199570a.getClass();     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        KeyGenerator r122 = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");     // Catch: Throwable -> L57
        if (r105 < 23) goto L45;
        this.f199570a.getClass();     // Catch: Throwable -> L57
        r122.init(new KeyGenParameterSpec.Builder("badger_mac_key_v1", 12).setKeySize(256).setDigests(new String[]{"SHA-256"}).build());     // Catch: Throwable -> L57
    L45:
        SecretKey r123 = r122.generateKey();     // Catch: Throwable -> L57
        if (r123 != null) goto L51;
        TeeStage r124 = TeeStage.DERIVE_LOAD_SECRET;     // Catch: Throwable -> L57
        long r125 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        TeeResult r126 = TeeResult.a(r124, -1007, "hmac key not found", r125, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL);     // Catch: Throwable -> L57
        monitor-exit(r109);     // Catch: Throwable -> L61
        return r126;
    L51:
        if ((r123 instanceof SecretKey) == true) goto L53;
        byte[] r127 = r123.getEncoded();     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        SecretKey r128 = new SecretKeySpec(r127, "HmacSHA256");     // Catch: Throwable -> L57
    L54:
        this.f199570a.getClass();     // Catch: Throwable -> L57
        r101.put("badger_mac_key_v1", r128);     // Catch: Throwable -> L57
        TeeStage r129 = TeeStage.DERIVE_LOAD_SECRET;     // Catch: Throwable -> L57
        long r130 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L57
        this.f199570a.getClass();     // Catch: Throwable -> L57
        TeeResult r131 = TeeResult.d(r129, r128, r130, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_SUCCESS, TeeResult.KeySource.SYSTAM);     // Catch: Throwable -> L57
        monitor-exit(r109);     // Catch: Throwable -> L61
        return r131;
    L53:
        r128 = r123;
    L61:
        th = move-exception;
        throw th;
    L57:
        th = move-exception;
        ConcurrentHashMap<String, SecretKey> r132 = f199568k;     // Catch: Throwable -> L61
        this.f199570a.getClass();     // Catch: Throwable -> L61
        r132.remove("badger_mac_key_v1");     // Catch: Throwable -> L61
        TeeStage r133 = TeeStage.DERIVE_LOAD_SECRET;     // Catch: Throwable -> L61
        String r134 = "obtainHmacKey error: " + Log.getStackTraceString(th);     // Catch: Throwable -> L61
        long r135 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L61
        this.f199570a.getClass();     // Catch: Throwable -> L61
        return TeeResult.a(r133, -1001, r134, r135, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL);
    L19:
        r107 = true;
    L64:
        TeeStage r136 = TeeStage.DERIVE_LOAD_SECRET;
        long r137 = System.currentTimeMillis() - r100;
        this.f199570a.getClass();
        return TeeResult.a(r136, -1001, "derivation# error, hmacKeyAlias or hmacAlgorithm null.", r137, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL);
    }

    public final void k() {
        this.f199570a.getClass();
        long r100 = Math.max(0, 50);
        if (r100 <= 0) goto L9;
        Thread.sleep(r100);     // Catch: InterruptedException -> L6
        return;
    L10:
        return;
    }

    public TeeProvider(h74.a r100) {
        this.f199572c = 0;
        this.f199573d = 0;
        this.f199575f = new Random();
        this.f199570a = r100;
        this.f199574e = new i74.a();
        this.f199571b = "sec_tee_key_v1_pub";
    }

    public final void i(PublicKey r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f199570a.f483984c == null) goto L18;
        byte[] r101 = r100.getEncoded();     // Catch: Exception -> L12
        if (r101 != null) goto L9;
        String r102 = null;
    L10:
        this.f199570a.f483984c.edit().putString(this.f199571b, r102).apply();     // Catch: Exception -> L12
        return;
    L9:
        r102 = Base64.encodeToString(r101, 0);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e("savePublicKeyToSp error", e);
        return;
    }

    public final TeeResult j(byte[] r210) {
        long r100 = System.currentTimeMillis();
        TeeResult r101 = f();     // Catch: Throwable -> L24
        g("secretDerivationAndSign", r101);     // Catch: Throwable -> L24
        int r102 = r101.f199579c;     // Catch: Throwable -> L24
        if (r102 != 0) goto L21;
        T r103 = r101.f199578b;     // Catch: Throwable -> L24
        if (r103 == 0) goto L21;
        SecretKey r104 = (SecretKey) r103;     // Catch: Throwable -> L24
        this.f199570a.getClass();     // Catch: Throwable -> L24
        int r105 = Math.max(1, 3);     // Catch: Throwable -> L24
        Exception e100 = null;
        int r110 = 0;
    L10:
        if (r110 > r105) goto L20;
        this.f199570a.getClass();     // Catch: Exception -> L17 Throwable -> L24
        Mac r106 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L17 Throwable -> L24
        r106.init(r104);     // Catch: Exception -> L17 Throwable -> L24
        byte[] r111 = r106.doFinal(r210);     // Catch: Exception -> L17 Throwable -> L24
        TeeStage r112 = TeeStage.DERIVE_SIGN;     // Catch: Exception -> L17 Throwable -> L24
        long r113 = System.currentTimeMillis() - r100;     // Catch: Exception -> L17 Throwable -> L24
        this.f199570a.getClass();     // Catch: Exception -> L17 Throwable -> L24
        int r211 = r110;
        TeeResult<?> r114 = new TeeResult(r112, r111, 0, "", r113, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_SUCCESS, r211, null);     // Catch: Exception -> L15 Throwable -> L24
        g("secretDerivationAndSign", r114);     // Catch: Exception -> L15 Throwable -> L24
        h("secretDerivationAndSign", "badger_derivate", true);
        return r114;
    L15:
        e100 = e;
    L19:
        e("hmac error attempt", e100);     // Catch: Throwable -> L24
        k();     // Catch: Throwable -> L24
        r110 = r211 + 1;     // Catch: Throwable -> L24
    L17:
        e100 = e;
        r211 = r110;
        goto L19
    L20:
        long r212 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L24
        this.f199570a.getClass();     // Catch: Throwable -> L24
        TeeResult<?> r107 = TeeResult.a(TeeStage.DERIVE_SIGN, -1006, "hmac error: " + e100, r212, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL);     // Catch: Throwable -> L24
        g("secretDerivationAndSign", r107);     // Catch: Throwable -> L24
    L22:
        TeeResult<?> r115 = r107;
        h("secretDerivationAndSign", "badger_derivate", true);
        return r115;
    L21:
        TeeStage r108 = r101.f199577a;     // Catch: Throwable -> L24
        String r109 = r101.f199580d;     // Catch: Throwable -> L24
        long r116 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L24
        this.f199570a.getClass();     // Catch: Throwable -> L24
        r107 = TeeResult.b(r108, r102, r109, r116, "badger_mac_key_v1", TeeResult.ResultType.SECRET_DERIVE_FAIL, r101.f199584h, r101.f199585i);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        h("secretDerivationAndSign", "badger_derivate", true);
        throw th;
    }

    public final TeeResult<String> a(String r210, PublicKey r211) {
        if (r211 == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L10;
        ConcurrentHashMap<String, TeeResult<String>> r101 = f199566i;
        this.f199570a.getClass();
        TeeResult<String> r102 = r101.get("sec_tee_key_v1");
        if (r102 == null) goto L10;
        return r102;
    L10:
        Object r103 = f199567j;
        monitor-enter(r103);
        if (r100 == false) goto L102;
    L17:
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L98
        if (f199565h != null) goto L30;
        SharedPreferences r105 = this.f199570a.f483984c;     // Catch: Throwable -> L98
        if (r105 != null) goto L103;
    L28:
        byte[] r106 = null;
    L29:
        f199565h = r106;     // Catch: Throwable -> L98
        goto L30
    L103:
        String r107 = r105.getString(this.f199571b, null);     // Catch: Exception -> L26 Throwable -> L98
        if (r107 == null) goto L28;
        r106 = Base64.decode(r107, 0);     // Catch: Exception -> L26 Throwable -> L98
    L26:
        e = move-exception;
        e("getPublicKeyFromSp error", e);     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        throw th;
    L30:
        if (r211 == null) goto L32;
        f199565h = r211.getEncoded();     // Catch: Throwable -> L98
    L32:
        if (r211 == null) goto L35;
        TeeResult.KeySource r108 = TeeResult.KeySource.EXTERNAL;     // Catch: Throwable -> L98
    L101:
    L69:
        th = move-exception;
        h("comparePublicKeyWithLocal", r210, false);     // Catch: Throwable -> L98
        throw th;     // Catch: Throwable -> L98
    L71:
        e = move-exception;
        e("isCurrentPublicKeySameAs error", e);     // Catch: Throwable -> L69
        long r110 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69
        this.f199570a.getClass();     // Catch: Throwable -> L69
        TeeResult<String> r109 = TeeResult.a(TeeStage.PUBLIC_COMPARE, -1001, "isCurrentPublicKeySameAs error: " + e, r110, "sec_tee_key_v1", TeeResult.ResultType.PUB_COMPARE_NOT_EQUAL);     // Catch: Throwable -> L69
        g("comparePublicKeyWithLocal", r109);     // Catch: Throwable -> L69
        h("comparePublicKeyWithLocal", r210, false);     // Catch: Throwable -> L98
        return r109;
    L40:
        if (f199565h != null) goto L42;
    L77:
        TeeResult<KeyPair> r111 = d();     // Catch: Throwable -> L69 Exception -> L71
        g("comparePublicKeyWithLocal", r111);     // Catch: Throwable -> L69 Exception -> L71
        if (r111.f199579c != 0) goto L88;
        KeyPair r112 = r111.f199578b;     // Catch: Throwable -> L69 Exception -> L71
        if (r112 == null) goto L88;
        if (r112.getPublic() == null) goto L88;
        byte[] r113 = r111.f199578b.getPublic().getEncoded();     // Catch: Throwable -> L69 Exception -> L71
        if (r113 != null) goto L86;
        String r114 = null;
    L87:
        TeeStage r115 = r111.f199577a;     // Catch: Throwable -> L69 Exception -> L71
        long r116 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        TeeResult<String> r117 = TeeResult.c(r115, r114, r116, r111.f199583g, r111.f199584h, r111.f199585i);     // Catch: Throwable -> L69 Exception -> L71
    L89:
        h("comparePublicKeyWithLocal", r210, false);     // Catch: Throwable -> L98
        monitor-exit(r103);     // Catch: Throwable -> L98
        return r117;
    L86:
        r114 = Base64.encodeToString(r113, 0);     // Catch: Throwable -> L69 Exception -> L71
    L88:
        TeeStage r118 = r111.f199577a;     // Catch: Throwable -> L69 Exception -> L71
        int r119 = r111.f199579c;     // Catch: Throwable -> L69 Exception -> L71
        String r120 = r111.f199580d;     // Catch: Throwable -> L69 Exception -> L71
        long r121 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        r117 = TeeResult.b(r118, r119, r120, r121, "sec_tee_key_v1", r111.f199583g, r111.f199584h, r111.f199585i);     // Catch: Throwable -> L69 Exception -> L71
        goto L89
    L42:
        if (f199565h.length == 0) goto L77;
        TeeStage r122 = TeeStage.LOAD_KEYPAIR;     // Catch: Throwable -> L69 Exception -> L71
        byte[] r123 = f199565h;     // Catch: Throwable -> L69 Exception -> L71
        if (r123 != null) goto L47;
        String r124 = null;
    L48:
        long r125 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        g("comparePublicKeyWithLocal", TeeResult.d(r122, r124, r125, "sec_tee_key_v1", TeeResult.ResultType.KEYPAIR_SUCCESS, r108));     // Catch: Throwable -> L69 Exception -> L71
        TeeResult<KeyPair> r126 = d();     // Catch: Throwable -> L69 Exception -> L71
        if (r126.f199579c != 0) goto L73;
        KeyPair r127 = r126.f199578b;     // Catch: Throwable -> L69 Exception -> L71
        if (r127 == null) goto L73;
        if (r127.getPublic() == null) goto L73;
        byte[] r128 = r126.f199578b.getPublic().getEncoded();     // Catch: Throwable -> L69 Exception -> L71
        boolean r129 = Arrays.equals(r128, f199565h);     // Catch: Throwable -> L69 Exception -> L71
        if (r128 != null) goto L58;
        String r130 = null;
    L59:
        if (r129 == true) goto L61;
        TeeStage r131 = TeeStage.PUBLIC_COMPARE;     // Catch: Throwable -> L69 Exception -> L71
        long r132 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        TeeResult<String> r133 = TeeResult.c(r131, r130, r132, TeeResult.ResultType.PUB_COMPARE_NOT_EQUAL, r126.f199584h, r108);     // Catch: Throwable -> L69 Exception -> L71
    L62:
        g("comparePublicKeyWithLocal", r133);     // Catch: Throwable -> L69 Exception -> L71
        if (r100 == true) goto L66;
        if (r129 == false) goto L66;
        ConcurrentHashMap<String, TeeResult<String>> r134 = f199566i;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        r134.put("sec_tee_key_v1", r133);     // Catch: Throwable -> L69 Exception -> L71
    L66:
        h("comparePublicKeyWithLocal", r210, false);     // Catch: Throwable -> L98
        monitor-exit(r103);     // Catch: Throwable -> L98
        return r133;
    L61:
        TeeStage r135 = TeeStage.PUBLIC_COMPARE;     // Catch: Throwable -> L69 Exception -> L71
        long r136 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        r133 = TeeResult.c(r135, r130, r136, TeeResult.ResultType.PUB_COMPARE_EQUAL, r126.f199584h, r108);     // Catch: Throwable -> L69 Exception -> L71
        goto L62
    L58:
        r130 = Base64.encodeToString(r128, 0);     // Catch: Throwable -> L69 Exception -> L71
    L73:
        TeeStage r137 = TeeStage.PUBLIC_COMPARE;     // Catch: Throwable -> L69 Exception -> L71
        int r138 = r126.f199579c;     // Catch: Throwable -> L69 Exception -> L71
        String r139 = r126.f199580d;     // Catch: Throwable -> L69 Exception -> L71
        long r140 = System.currentTimeMillis() - r104;     // Catch: Throwable -> L69 Exception -> L71
        this.f199570a.getClass();     // Catch: Throwable -> L69 Exception -> L71
        TeeResult<String> r141 = TeeResult.b(r137, r138, r139, r140, "sec_tee_key_v1", r126.f199583g, r126.f199584h, r126.f199585i);     // Catch: Throwable -> L69 Exception -> L71
        g("comparePublicKeyWithLocal", r126);     // Catch: Throwable -> L69 Exception -> L71
        h("comparePublicKeyWithLocal", r210, false);     // Catch: Throwable -> L98
        monitor-exit(r103);     // Catch: Throwable -> L98
        return r141;
    L47:
        r124 = Base64.encodeToString(r123, 0);     // Catch: Throwable -> L69 Exception -> L71
        goto L48
    L35:
        if (f199565h == null) goto L38;
        r108 = TeeResult.KeySource.DISK;     // Catch: Throwable -> L98
        goto L101
    L38:
        r108 = null;
        goto L101
    L102:
        ConcurrentHashMap<String, TeeResult<String>> r142 = f199566i;     // Catch: Throwable -> L98
        this.f199570a.getClass();     // Catch: Throwable -> L98
        TeeResult<String> r143 = r142.get("sec_tee_key_v1");     // Catch: Throwable -> L98
        if (r143 == null) goto L17;
        monitor-exit(r103);     // Catch: Throwable -> L98
        return r143;
    L5:
        r100 = false;
        goto L6
    }

    public final void e(String r100, Throwable r101) {
        a r102 = this.f199570a.f483982a;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public final void g(String r100, TeeResult<?> r101) {
        if (this.f199570a.f483983b != null) goto L5;
        return;
    L5:
        i74.a r102 = this.f199574e;
        r102.getClass();
        ArrayList<TeeResult<?>> r103 = r102.f488460a.get(r100);
        if (r103 != null) goto L10;
        r103 = new ArrayList();
        ArrayList<TeeResult<?>> r104 = r102.f488460a.putIfAbsent(r100, r103);
        if (r104 == null) goto L10;
        r103 = r104;
    L10:
        monitor-enter(r103);
        r103.add(r101);     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void h(String r100, String r101, boolean r102) {
        if (this.f199570a.f483983b != null) goto L5;
        return;
    L5:
        if (r102 == false) goto L15;
        int r103 = this.f199575f.nextInt(100);
        this.f199570a.getClass();
        boolean r104 = true;
        if (r103 < 1) goto L10;
        r104 = false;
    L10:
        if (r104 == true) goto L15;
        return;
    L15:
        b r105 = this.f199570a.f483983b;     // Catch: Throwable -> L14
        this.f199574e.getClass();     // Catch: Throwable -> L14
        i74.a r106 = this.f199574e;     // Catch: Throwable -> L14
        this.f199570a.getClass();     // Catch: Throwable -> L14
        r105.onEvent(r106.a(r101, r100));     // Catch: Throwable -> L14
        this.f199574e.f488460a.remove(r100);     // Catch: Throwable -> L14
        return;
    }
}
