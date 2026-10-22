package com.bytedance.applog.priority;

import com.bytedance.applog.log.b;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PriorityWrapper$a extends b<Boolean> {
    public PriorityWrapper$a() {
    }

    public final Object a(Object[] r4) {
        Intrinsics.checkNotNullParameter("applog_rust", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> applog_rust");
        a.c("applog_rust");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> applog_rust");
        return Boolean.TRUE;
    }
}
