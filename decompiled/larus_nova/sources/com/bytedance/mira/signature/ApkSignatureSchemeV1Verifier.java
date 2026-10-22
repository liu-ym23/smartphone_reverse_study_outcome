package com.bytedance.mira.signature;

import android.content.pm.Signature;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mira.util.ArrayUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes21.dex */
public class ApkSignatureSchemeV1Verifier {
    public static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    private static final AtomicReference<byte[]> sBuffer = null;

    public ApkSignatureSchemeV1Verifier() {
    }

    static {
        sBuffer = new AtomicReference();
    }

    private static void readFullyIgnoringContents(InputStream r100) throws IOException {
        byte[] r101 = sBuffer.getAndSet(null);
        if (r101 != null) goto L6;
        r101 = new byte[4096];
    L6:
        if (r100.read(r101, 0, r101.length) != (-1)) goto L6;
        sBuffer.set(r101);
    }

    private static Certificate[][] loadCertificates(JarFile r100, JarEntry r101) throws VerifyException {
        InputStream r102 = null;
        InputStream r103 = r100.getInputStream(r101);     // Catch: Throwable -> L10 RuntimeException -> L12 Throwable -> L14
        readFullyIgnoringContents(r103);     // Catch: Throwable -> L10 RuntimeException -> L12 Throwable -> L14
        Certificate[][] r104 = {r101.getCertificates()};     // Catch: Throwable -> L10 RuntimeException -> L12 Throwable -> L14
        if (r103 != null) goto L28;
    L9:
        return r104;
    L28:
        r103.close();     // Catch: RuntimeException -> L7 Exception -> L23
    L7:
        e = move-exception;
        throw e;
    L10:
        th = move-exception;
        if (0 != 0) goto L26;
    L22:
        throw th;
    L26:
        r102.close();     // Catch: RuntimeException -> L20 Exception -> L24
    L20:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        throw new VerifyException(5, "Failed reading " + r101.getName() + " in " + r100, e);     // Catch: Throwable -> L10
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0192: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:33554834), block:B:65:0x0192 */
    public static SigningDetails verify(String r210, boolean r211) throws VerifyException {
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1);
        JarFile r100 = null;
        JarFile r101 = new JarFile(r210);     // Catch: Throwable -> L52 RuntimeException -> L54 IOException -> L56 GeneralSecurityException -> L60
        ArrayList r102 = new ArrayList();     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        JarEntry r103 = r101.getJarEntry(ANDROID_MANIFEST_FILENAME);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        if (r103 == null) goto L44;
        Certificate[][] r104 = loadCertificates(r101, r103);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        if (ArrayUtils.isEmpty(r104) == true) goto L42;
        Signature[] r110 = ApkSignatureVerifier.convertToSignatures(r104);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        if (r211 == false) goto L39;
        Enumeration<JarEntry> r105 = r101.entries();     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L13:
        if (r105.hasMoreElements() == false) goto L27;
        JarEntry r106 = r105.nextElement();     // Catch: Throwable -> L25
        if (r106.isDirectory() == true) goto L13;
        String r111 = r106.getName();     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        if (r111.startsWith("META-INF/") == true) goto L13;
        if (r111.equals(ANDROID_MANIFEST_FILENAME) == true) goto L13;
        r102.add(r106);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L25:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "ApkSignatureSchemeV1Verifier entries.nextElement failed." + r101.getName(), th);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        PluginEventManager.getInstance().notifyPluginErrorEvent(PluginEventManager.InstallStatusCode.INSTALL_CHECK_ZIP_ENTRY_FAILED, null, 0, th, System.currentTimeMillis());     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        goto L13
    L27:
        Iterator r107 = r102.iterator();     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L29:
        if (r107.hasNext() == false) goto L39;
        JarEntry r108 = (JarEntry) r107.next();     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        Certificate[][] r109 = loadCertificates(r101, r108);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        if (ArrayUtils.isEmpty(r109) == true) goto L37;
        if (SigningDetails.areExactMatch(r110, ApkSignatureVerifier.convertToSignatures(r109)) == true) goto L29;
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_4, null, r108.getName());     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        throw new VerifyException(3, "Package " + r210 + " has mismatched certificates at entry " + r108.getName());     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L37:
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_3, null, r108.getName());     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        throw new VerifyException(4, "Package " + r210 + " has no certificates at entry " + r108.getName());     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L39:
        SigningDetails r112 = new SigningDetails(r110, 1, null, null, null);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        r101.close();     // Catch: Exception -> L69
    L41:
        return r112;
    L42:
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_2);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        throw new VerifyException(4, "Package " + r210 + " has no certificates at entry AndroidManifest.xml");     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L44:
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_1);     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
        throw new VerifyException(1, "Package " + r210 + " has no manifest");     // Catch: RuntimeException -> L46 IOException -> L48 GeneralSecurityException -> L50 Throwable -> L64
    L48:
        e = e;
    L58:
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_6, e, null);     // Catch: Throwable -> L64
        throw new VerifyException(4, "Failed to collect certificates from " + r210, e);     // Catch: Throwable -> L64
    L46:
        e = e;
    L50:
        e = e;
    L62:
        MiraMonitor.reportSignEvent(MiraMonitor.SCHEMA_V1_FAIL_5, e, null);     // Catch: Throwable -> L64
        throw new VerifyException(2, "Failed to collect certificates from " + r210, e);     // Catch: Throwable -> L64
    L64:
        th = th;
        r100 = r6;
    L66:
        if (r100 != null) goto L74;
    L68:
        throw th;
    L74:
        r100.close();     // Catch: Exception -> L70
    L56:
        e = e;
    L54:
        e = e;
    L60:
        e = e;
    L52:
        th = th;
        goto L66
    }
}
