package com.ss.bduploader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] HEX_DIGITS = null;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sDisableNativeCodeForTest;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = null;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* JADX INFO: renamed from: com.ss.bduploader.util.X509Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        public /* synthetic */ TrustStorageListener(AnonymousClass1 r100) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (Build.VERSION.SDK_INT < 26) goto L14;
            boolean r102 = true;
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r101.getAction()) == false) goto L7;
        L15:
            if (r102 == false) goto L21;
            X509Util.access$100();     // Catch: Throwable -> L18
            return;
        L22:
            return;
        L21:
            return;
        L7:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r101.getAction()) == true) goto L15;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r101.getAction()) == true) goto L11;
        L13:
            r102 = false;
            goto L15
        L11:
            if (r101.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L13;
        L14:
            r102 = "android.security.STORAGE_CHANGED".equals(r101.getAction());
            goto L15
        }
    }

    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager r100) {
            this.mTrustManager = r100;
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r100, String r101, String r102) throws CertificateException {
            this.mTrustManager.checkServerTrusted(r100, r101);
            return Collections.emptyList();
        }
    }

    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] r100, String r101, String r102) throws CertificateException;
    }

    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        public X509TrustManagerJellyBean(X509TrustManager r100) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(r100);
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r100, String r101, String r102) throws CertificateException {
            return this.mTrustManagerExtensions.checkServerTrusted(r100, r101, r102);
        }
    }

    static {
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private static void ensureInitialized() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Object r100 = sLock;
        monitor-enter(r100);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void ensureInitializedLocked() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (sCertificateFactory != null) goto L5;
        sCertificateFactory = CertificateFactory.getInstance("X.509");
    L5:
        AnonymousClass1 r100 = null;
        if (sDefaultTrustManager != null) goto L9;
        sDefaultTrustManager = createTrustManager(null);
    L9:
        if (sLoadedSystemKeyStore == true) goto L15;
        KeyStore r101 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L35
        sSystemKeyStore = r101;     // Catch: KeyStoreException -> L35
        r101.load(null);     // Catch: IOException -> L34 KeyStoreException -> L35
    L12:
        sSystemCertificateDirectory = new PolarisFileWrapper(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L35
    L13:
        sLoadedSystemKeyStore = true;
    L15:
        if (sSystemTrustAnchorCache != null) goto L18;
        sSystemTrustAnchorCache = new HashSet();
    L18:
        if (sTestKeyStore != null) goto L24;
        KeyStore r102 = KeyStore.getInstance(KeyStore.getDefaultType());
        sTestKeyStore = r102;
        r102.load(null);     // Catch: IOException -> L22
    L24:
        if (sTestTrustManager != null) goto L27;
        sTestTrustManager = createTrustManager(sTestKeyStore);
    L27:
        if (sTrustStorageListener != null) goto L42;
        sTrustStorageListener = new TrustStorageListener(r100);
        IntentFilter r103 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 26) goto L31;
        r103.addAction("android.security.action.KEYCHAIN_CHANGED");
        r103.addAction("android.security.action.KEY_ACCESS_CHANGED");
        r103.addAction("android.security.action.TRUST_STORE_CHANGED");
    L32:
        INVOKEVIRTUAL_com_ss_bduploader_util_X509Util_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(NetUtils.getApplicationContext(), sTrustStorageListener, r103);
        return;
    L31:
        r103.addAction("android.security.STORAGE_CHANGED");
        goto L32
    }

    private static void reloadDefaultTrustManager() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Object r100 = sLock;
        monitor-enter(r100);
        sDefaultTrustManager = null;     // Catch: Throwable -> L8
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L8
        ensureInitializedLocked();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void reloadTestTrustManager() throws KeyStoreException, NoSuchAlgorithmException {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        ensureInitialized();
        Object r100 = sLock;
        monitor-enter(r100);
        sTestKeyStore.load(null);     // Catch: Throwable -> L6 IOException -> L12
        reloadTestTrustManager();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L6
    }

    public X509Util() {
    }

    public static /* synthetic */ void access$100() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        reloadDefaultTrustManager();
    }

    public static void addTestRootCertificate(byte[] r100) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        X509Certificate r101 = createCertificateFromBytes(r100);
        Object r102 = sLock;
        monitor-enter(r102);
        sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), r101);     // Catch: Throwable -> L7
        reloadTestTrustManager();     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static X509Certificate createCertificateFromBytes(byte[] r100) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(r100));
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore r100) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory r101 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r101.init(r100);
        TrustManager[] r102 = r101.getTrustManagers();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        TrustManager r105 = r102[r104];
        if ((r105 instanceof X509TrustManager) == false) goto L10;
        return new X509TrustManagerJellyBean((X509TrustManager) r105);
    L8:
        e = move-exception;
        r105.getClass();
        e.toString();
    L10:
        r104 = r104 + 1;
        goto L3
    L11:
        return null;
    }

    private static String hashPrincipal(X500Principal r100) throws NoSuchAlgorithmException {
        byte[] r101 = MessageDigest.getInstance("MD5").digest(r100.getEncoded());
        char[] r102 = new char[8];
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L7;
        int r104 = r103 * 2;
        char[] r105 = HEX_DIGITS;
        byte r106 = r101[3 - r103];
        r102[r104] = r105[(r106 >> 4) & 15];
        r102[r104 + 1] = r105[r106 & 15];
        r103 = r103 + 1;
        goto L4
    L7:
        return new String(r102);
    }

    private static boolean isKnownRoot(X509Certificate r100) throws NoSuchAlgorithmException, KeyStoreException {
        if (sSystemKeyStore != null) goto L5;
        return false;
    L5:
        Pair<X500Principal, PublicKey> r101 = new Pair(r100.getSubjectX500Principal(), r100.getPublicKey());
        if (sSystemTrustAnchorCache.contains(r101) == false) goto L8;
        return true;
    L8:
        String r102 = hashPrincipal(r100.getSubjectX500Principal());
        int r103 = 0;
    L9:
        String r104 = r102 + '.' + r103;
        if (new PolarisFileWrapper(sSystemCertificateDirectory, r104).exists() == false) goto L11;
        Certificate r105 = sSystemKeyStore.getCertificate("system:" + r104);
        if (r105 == null) goto L23;
        if ((r105 instanceof X509Certificate) == false) goto L23;
        X509Certificate r106 = (X509Certificate) r105;
        if (r100.getSubjectX500Principal().equals(r106.getSubjectX500Principal()) == false) goto L23;
        if (r100.getPublicKey().equals(r106.getPublicKey()) == false) goto L23;
        sSystemTrustAnchorCache.add(r101);
        return true;
    L23:
        r103 = r103 + 1;
        goto L9
    L11:
        return false;
    }

    public static void setDisableNativeCodeForTest(boolean r100) {
        sDisableNativeCodeForTest = r100;
    }

    public static boolean verifyKeyUsage(X509Certificate r100) throws CertificateException {
        List<String> r101 = r100.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r101 != null) goto L7;
        return true;
    L7:
        Iterator<String> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        if (r103.equals(OID_TLS_SERVER_AUTH) == true) goto L19;
        if (r103.equals(OID_ANY_EKU) == true) goto L19;
        if (r103.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L19;
        if (r103.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L19:
        return true;
    L10:
        return false;
    L20:
        return false;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_bduploader_util_X509Util_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r100, String r101, String r102) throws KeyStoreException, NoSuchAlgorithmException {
        if (r100 == null) goto L58;
        if (r100.length == 0) goto L58;
        if (r100[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r103 = new ArrayList();
        r103.add(createCertificateFromBytes(r100[0]));     // Catch: CertificateException -> L53
        int r104 = 1;
    L13:
        if (r104 >= r100.length) goto L18;
        r103.add(createCertificateFromBytes(r100[r104]));     // Catch: CertificateException -> L16
    L17:
        r104 = r104 + 1;
        goto L13
    L18:
        X509Certificate[] r105 = (X509Certificate[]) r103.toArray(new X509Certificate[r103.size()]);
        r105[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r105[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r106 = sLock;
        monitor-enter(r106);
        X509TrustManagerImplementation r107 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r107 != null) goto L66;
        AndroidCertVerifyResult r108 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r106);     // Catch: Throwable -> L44
        return r108;
    L66:
        List<X509Certificate> r109 = r107.checkServerTrusted(r105, r101, r102);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r109.size() <= 0) goto L37;
        boolean r110 = isKnownRoot(r109.get(r109.size() - 1));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r111 = new AndroidCertVerifyResult(0, r110, r109);     // Catch: Throwable -> L44
        monitor-exit(r106);     // Catch: Throwable -> L44
        return r111;
    L37:
        r110 = false;
    L32:
        e = move-exception;
        r109 = sTestTrustManager.checkServerTrusted(r105, r101, r102);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        e.getMessage();     // Catch: Throwable -> L44
        return new AndroidCertVerifyResult(-2);
    L44:
        th = move-exception;
        throw th;
    L52:
        return new AndroidCertVerifyResult(-3);
    L50:
        return new AndroidCertVerifyResult(-4);
    L48:
        return new AndroidCertVerifyResult(-1);
    L54:
        return new AndroidCertVerifyResult(-5);
    L56:
        return new AndroidCertVerifyResult(-1);
    L58:
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(r100));
    }
}
