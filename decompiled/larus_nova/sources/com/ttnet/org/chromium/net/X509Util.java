package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
@MainDex
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] HEX_DIGITS = null;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerExtensions sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = null;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerExtensions sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.X509Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface Natives {
        void notifyKeyChainChanged();
    }

    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        public /* synthetic */ TrustStorageListener(AnonymousClass1 r100) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            boolean r102 = "android.security.STORAGE_CHANGED".equals(r101.getAction());
        L17:
            if (r102 == false) goto L29;
            X509Util.access$000();     // Catch: NoSuchAlgorithmException -> L20 KeyStoreException -> L22 CertificateException -> L24
        L32:
            return;
        L22:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L20:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L24:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L29:
            return;
        L5:
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r101.getAction()) == false) goto L7;
        L15:
            r102 = true;
            goto L17
        L7:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r101.getAction()) == true) goto L15;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r101.getAction()) == true) goto L12;
        L14:
            r102 = false;
            goto L17
        L12:
            if (r101.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L14;
            goto L14
        }
    }

    public X509Util() {
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
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), sTrustStorageListener, r103);
        return;
    L31:
        r103.addAction("android.security.STORAGE_CHANGED");
        goto L32
    }

    private static void reloadDefaultTrustManager() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Object r100 = sLock;
        monitor-enter(r100);
        sDefaultTrustManager = null;     // Catch: Throwable -> L9
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L9
        ensureInitializedLocked();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        X509UtilJni.get().notifyKeyChainChanged();
        return;
    L9:
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

    public static /* synthetic */ void access$000() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
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

    private static X509TrustManagerExtensions createTrustManager(KeyStore r100) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory r101 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r101.init(r100);
        TrustManager[] r102 = r101.getTrustManagers();     // Catch: RuntimeException -> L15
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        TrustManager r105 = r102[r104];
        if ((r105 instanceof X509TrustManager) == false) goto L12;
        return new X509TrustManagerExtensions((X509TrustManager) r105);
    L10:
        e = move-exception;
        Log.e(TAG, "Error creating trust manager (" + r105.getClass().getName() + "): " + e, new Object[0]);
    L12:
        r104 = r104 + 1;
        goto L5
    L13:
        Log.e(TAG, "Could not find suitable trust manager", new Object[0]);
        return null;
    L15:
        e = move-exception;
        Log.e(TAG, "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", new Object[]{e});
        throw new KeyStoreException(e);
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
        if (r105 == null) goto L24;
        if ((r105 instanceof X509Certificate) == true) goto L18;
        Log.e(TAG, "Anchor " + r104 + " not an X509Certificate: " + r105.getClass().getName(), new Object[0]);
        goto L24
    L18:
        X509Certificate r106 = (X509Certificate) r105;
        if (r100.getSubjectX500Principal().equals(r106.getSubjectX500Principal()) == false) goto L24;
        if (r100.getPublicKey().equals(r106.getPublicKey()) == false) goto L24;
        sSystemTrustAnchorCache.add(r101);
        return true;
    L24:
        r103 = r103 + 1;
        goto L9
    L11:
        return false;
    }

    public static boolean verifyKeyUsage(X509Certificate r100) throws CertificateException {
        List<String> r101 = r100.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r101 != null) goto L7;
        return true;
    L7:
        Iterator<String> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        String r103 = r102.next();
        if (r103.equals(OID_TLS_SERVER_AUTH) == true) goto L18;
        if (r103.equals(OID_ANY_EKU) == true) goto L18;
        if (r103.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L18;
        if (r103.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r100, String r101, String r110) throws KeyStoreException, NoSuchAlgorithmException {
        if (r100 == null) goto L58;
        if (r100.length == 0) goto L58;
        if (r100[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r102 = new ArrayList();
        r102.add(createCertificateFromBytes(r100[0]));     // Catch: CertificateException -> L53
        int r103 = 1;
    L13:
        if (r103 >= r100.length) goto L18;
        r102.add(createCertificateFromBytes(r100[r103]));     // Catch: CertificateException -> L16
    L17:
        r103 = r103 + 1;
    L16:
        Log.w(TAG, "intermediate " + r103 + " failed parsing", new Object[0]);
        goto L17
    L18:
        X509Certificate[] r104 = (X509Certificate[]) r102.toArray(new X509Certificate[r102.size()]);
        r104[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r104[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r105 = sLock;
        monitor-enter(r105);
        X509TrustManagerExtensions r106 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r106 != null) goto L59;
        AndroidCertVerifyResult r107 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r105);     // Catch: Throwable -> L44
        return r107;
    L59:
        List<X509Certificate> r108 = checkServerTrustedIgnoringRuntimeException(r106, r104, r101, r110);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r108.size() <= 0) goto L37;
        boolean r109 = isKnownRoot(r108.get(r108.size() - 1));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r111 = new AndroidCertVerifyResult(0, r109, r108);     // Catch: Throwable -> L44
        monitor-exit(r105);     // Catch: Throwable -> L44
        return r111;
    L37:
        r109 = false;
    L32:
        e = move-exception;
        r108 = checkServerTrustedIgnoringRuntimeException(sTestTrustManager, r104, r101, r110);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        Log.i(TAG, "Failed to validate the certificate chain, error: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L44
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

    private static List<X509Certificate> checkServerTrustedIgnoringRuntimeException(X509TrustManagerExtensions r100, X509Certificate[] r101, String r102, String r103) throws CertificateException {
        return r100.checkServerTrusted(r101, r102, r103);
    L4:
        e = move-exception;
        Log.e(TAG, "checkServerTrusted() unexpectedly threw: %s", new Object[]{e});
        throw new CertificateException(e);
    }
}
