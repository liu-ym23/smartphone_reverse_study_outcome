package com.getkeepsafe.relinker;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c implements ReLinker.b {
    public c() {
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public final String b(String r100) {
        if (r100.startsWith("lib") == false) goto L8;
        if (r100.endsWith(".so") == false) goto L8;
        return r100;
    L8:
        return System.mapLibraryName(r100);
    }
}
