package com.ss.android.tecommonenvinitializer.diagnosis;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "libs");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        Intrinsics.checkNotNullParameter(r102, "libName");
        FLogger r103 = FLogger.f375446a;
        r103.i("Librarian_loadLib", "loadLibrary start libName -> " + r102);
        com.bytedance.librarian.a.c(r102);
        r103.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r102);
        goto L4
    }
}
