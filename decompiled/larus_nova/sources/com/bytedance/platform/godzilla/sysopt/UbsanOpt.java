package com.bytedance.platform.godzilla.sysopt;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class UbsanOpt {
    public static native void end();

    public static native void start();

    static {
        Intrinsics.checkNotNullParameter("godzilla-sysopt", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> godzilla-sysopt");
        a.c("godzilla-sysopt");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> godzilla-sysopt");
    }

    public UbsanOpt() {
    }
}
