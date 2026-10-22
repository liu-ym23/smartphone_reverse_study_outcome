package com.bytedance.frameworks.encryptor;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class EncryptorUtil {
    public EncryptorUtil() {
    }

    private static native byte[] ttEncrypt(byte[] r100, int r101);

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("Encryptor", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> Encryptor");
        a.c("Encryptor");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> Encryptor");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static byte[] b(byte[] r100, int r101) {
        if (r100 == null) goto L10;
        if (r101 <= 0) goto L10;
        if (r100.length != r101) goto L10;
        return ttEncrypt(r100, r101);
    L10:
        return null;
    }
}
