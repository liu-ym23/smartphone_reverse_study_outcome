package com.bytedance.anniex.bd.foundation.impl;

import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public i() {
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        mr3.a.a.getClass();
        ALog.d(r2, r3);
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ALog.e(r2, r3);
    }

    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        mr3.a.a.getClass();
        ALog.i(r2, r3);
    }
}
