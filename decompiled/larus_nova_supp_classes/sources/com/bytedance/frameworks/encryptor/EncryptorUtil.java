package com.bytedance.frameworks.encryptor;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class EncryptorUtil {
    public EncryptorUtil() {
    }

    private static native byte[] ttEncrypt(byte[] r0, int r1);

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("Encryptor", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> Encryptor");
        a.c("Encryptor");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> Encryptor");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static byte[] b(byte[] r2, int r3) {
        if (r2 == null) goto L10;
        if (r3 <= 0) goto L10;
        if (r2.length != r3) goto L10;
        return ttEncrypt(r2, r3);
    L10:
        return null;
    }
}
