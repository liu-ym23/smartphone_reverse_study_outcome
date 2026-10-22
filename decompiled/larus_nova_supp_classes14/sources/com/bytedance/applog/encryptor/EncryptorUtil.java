package com.bytedance.applog.encryptor;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class EncryptorUtil {
    public EncryptorUtil() {
    }

    private static native byte[] ttEncrypt(byte[] r0, int r1);

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("EncryptorP", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> EncryptorP");
        a.c("EncryptorP");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> EncryptorP");
    }

    static {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
