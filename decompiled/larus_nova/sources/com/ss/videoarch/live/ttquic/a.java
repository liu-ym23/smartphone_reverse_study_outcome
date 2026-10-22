package com.ss.videoarch.live.ttquic;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public a() {
    }

    static {
    }

    public static void a(String r100) throws Exception {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
        return;
    L7:
        throw new Exception("Invalid library name.");
    }
}
