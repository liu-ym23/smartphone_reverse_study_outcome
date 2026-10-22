package com.volcengine.zeus.signature;

import android.content.pm.Signature;
import android.os.Build;
import com.bytedance.mira.signature.ApkSignatureSchemeV1Verifier;
import com.volcengine.zeus.log.ZeusLogger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static Signature[] a(Certificate[][] r110) throws CertificateEncodingException {
        Signature[] r100 = new Signature[r110.length];
        int r101 = 0;
    L4:
        if (r101 >= r110.length) goto L35;
        if (Build.VERSION.SDK_INT > 28) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L33;
        Class[] r103 = {Certificate[].class};
        Method r104 = aqc.a.f15992c;
        if (r104 != null) goto L36;
    L16:
        Constructor r105 = null;
    L17:
        if (r105 != null) goto L20;
        r105 = zpc.a.a(Signature.class, r103);
    L20:
        if (r105 == null) goto L22;
        r105.setAccessible(true);
    L22:
        if (r105 == null) goto L34;
        if (r105.isAccessible() == false) goto L34;
        r100[r101] = (Signature) r105.newInstance(new Object[]{r110[r101]});     // Catch: InvocationTargetException -> L27 IllegalAccessException -> L29 InstantiationException -> L31
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L34:
        r101 = r101 + 1;
        goto L4
    L36:
        r105 = (Constructor) r104.invoke(Signature.class, new Object[]{r103});     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getConstructor %s<init>%s failed !!!", new Object[]{Signature.class.getName(), 1}), th);
        goto L16
    L33:
        r100[r101] = new Signature(r110[r101][0].getEncoded());
        goto L34
    L8:
        r102 = false;
        goto L9
    L35:
        return r100;
    }

    public static SigningDetails b(String r210) throws VerifyException {
        RandomAccessFile r100 = null;
        RandomAccessFile r101 = new RandomAccessFile(r210, "r");     // Catch: Throwable -> L92 Exception -> L94
        goto L95
    L114:
        g.c(r210, r101, new int[]{-262969152, 1896449818});     // Catch: Throwable -> L86 Exception -> L88
    L124:
        ApkSignatureSchemeV3Verifier.b r102 = ApkSignatureSchemeV3Verifier.a(r101, r210);     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        Signature[] r110 = a(new Certificate[][]{r102.f462887a});     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        ApkSignatureSchemeV3Verifier.a r111 = r102.f462888b;     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        if (r111 == null) goto L12;
        int r112 = r111.f462885a.size();     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        Signature[] r113 = new Signature[r112];     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        int[] r114 = new int[r102.f462888b.f462886b.size()];     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        int r115 = 0;
    L10:
        if (r115 >= r112) goto L13;
        r113[r115] = new Signature(r102.f462888b.f462885a.get(r115).getEncoded());     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        r114[r115] = r102.f462888b.f462886b.get(r115).intValue();     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        r115 = r115 + 1;     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
    L13:
        SigningDetails r103 = new SigningDetails(r110, 3, r113, r114);     // Catch: Exception -> L16 SignatureNotFoundException -> L19 Throwable -> L86
        r101.close();     // Catch: Exception -> L99
    L15:
        return r103;
    L12:
        r113 = null;
        r114 = null;
    L19:
        SigningDetails r104 = new SigningDetails(a(b.a(r101, r210)), 2, null, null);     // Catch: Exception -> L22 SignatureNotFoundException -> L25 Throwable -> L86
        r101.close();     // Catch: Exception -> L100
    L21:
        return r104;
    L16:
        e = move-exception;
        throw new VerifyException(4, "Failed to collect certificates from " + r210 + " using APK Signature Scheme v3", e);     // Catch: Throwable -> L86
    L25:
        a.f462895a.put(r210, new AtomicReference());     // Catch: Throwable -> L86
        JarFile r105 = new JarFile(r210);     // Catch: Throwable -> L72 RuntimeException -> L74 IOException -> L76 GeneralSecurityException -> L79
    L126:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        JarEntry r116 = r105.getJarEntry(ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME);     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        if (r116 == null) goto L63;
        Signature[] r117 = a(a.a(r210, r105, r116));     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        Enumeration<JarEntry> r118 = r105.entries();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
    L32:
        if (r118.hasMoreElements() == false) goto L43;
        JarEntry r119 = r118.nextElement();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        if (r119.isDirectory() == true) goto L32;
        String r120 = r119.getName();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        if (r120.startsWith("META-INF/") == true) goto L32;
        if (r120.equals(ApkSignatureSchemeV1Verifier.ANDROID_MANIFEST_FILENAME) == true) goto L32;
        r106.add(r119);     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        goto L32
    L43:
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
    L45:
        if (r107.hasNext() == false) goto L58;
        JarEntry r108 = (JarEntry) r107.next();     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        Signature[] r121 = a(a.a(r210, r105, r108));     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        int r122 = SigningDetails.f462889f;     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        if (r117.length == r121.length) goto L49;
    L53:
        boolean r123 = false;
    L54:
        if (r123 == true) goto L45;
        throw new VerifyException(3, "Package " + r210 + " has mismatched certificates at entry " + r108.getName());     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
    L49:
        if (mqc.c.a(r117, r121) == false) goto L53;
        if (mqc.c.a(r121, r117) == false) goto L53;
        r123 = true;
        goto L54
    L58:
        SigningDetails r109 = new SigningDetails(r117, 1, null, null, null);     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
        r105.close();     // Catch: Exception -> L101 Throwable -> L86
    L121:
        r101.close();     // Catch: Exception -> L102
    L61:
        return r109;
    L63:
        throw new VerifyException(1, "Package " + r210 + " has no manifest");     // Catch: Throwable -> L64 RuntimeException -> L66 IOException -> L68 GeneralSecurityException -> L70
    L68:
        e = e;
    L78:
        throw new VerifyException(4, "Failed to collect certificates from " + r210, e);     // Catch: Throwable -> L72
    L66:
        e = e;
    L70:
        e = e;
    L81:
        throw new VerifyException(2, "Failed to collect certificates from " + r210, e);     // Catch: Throwable -> L72
    L64:
        th = th;
    L83:
        if (r105 != null) goto L117;
    L85:
        throw th;     // Catch: Throwable -> L86
    L117:
        r105.close();     // Catch: Exception -> L103 Throwable -> L86
    L72:
        th = th;
        r105 = null;
    L76:
        e = e;
    L74:
        e = e;
    L79:
        e = e;
    L22:
        e = move-exception;
        throw new VerifyException(4, "Failed to collect certificates from " + r210 + " using APK Signature Scheme v2", e);     // Catch: Throwable -> L86
    L88:
        e = move-exception;
        throw new VerifyException(4, "Failed to collect certificates from " + r210 + " when findSignatureInfo at once", e);     // Catch: Throwable -> L86
    L86:
        th = th;
        r100 = r101;
    L96:
        if (r100 != null) goto L105;
    L98:
        throw th;
    L105:
        r100.close();     // Catch: Exception -> L104
    L92:
        th = th;
    L95:
        throw new VerifyException(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : " + r210);     // Catch: Throwable -> L92
    }
}
