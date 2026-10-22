package com.bytedance.crash.util;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("npth", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> npth");
        com.bytedance.librarian.a.c("npth");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> npth");
    }
}
