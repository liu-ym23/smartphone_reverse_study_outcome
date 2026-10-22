package com.volcengine.zeus.signature;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, AtomicReference<byte[]>> f462895a = null;

    static {
        f462895a = new HashMap();
    }

    public static void b(String r100, InputStream r101) throws IOException {
        byte[] r102 = f462895a.get(r100).getAndSet(null);
        if (r102 != null) goto L6;
        r102 = new byte[4096];
    L6:
        if (r101.read(r102, 0, r102.length) != (-1)) goto L6;
        f462895a.get(r100).set(r102);
    }

    public static Certificate[][] a(String r100, JarFile r101, JarEntry r102) throws VerifyException {
        InputStream r103 = null;
        InputStream r104 = r101.getInputStream(r102);     // Catch: Throwable -> L8 RuntimeException -> L10 Throwable -> L12
        b(r100, r104);     // Catch: Throwable -> L8 RuntimeException -> L10 Throwable -> L12
        Certificate[][] r105 = {r102.getCertificates()};     // Catch: Throwable -> L8 RuntimeException -> L10 Throwable -> L12
        r104.close();     // Catch: Exception -> L21 RuntimeException -> L6
    L6:
        e = move-exception;
        throw e;
    L5:
        return r105;
    L8:
        th = move-exception;
        if (0 != 0) goto L26;
    L20:
        throw th;
    L26:
        r103.close();     // Catch: RuntimeException -> L18 Exception -> L22
    L18:
        e = move-exception;
        throw e;
    L12:
        e = move-exception;
        throw new VerifyException(5, "Failed reading " + r102.getName() + " in " + r101, e);     // Catch: Throwable -> L8
    }
}
