package com.ss.android.lark.passportc.impl.v2.action.background;

import com.ss.android.lark.passportc.impl.v2.action.i;
import com.ss.android.lark.passportc.internal.t;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import l0c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends i<e0c.a> {
    public c(com.ss.android.lark.passportc.impl.v2.action.a r100, d r101, t r110, l0c.c r111) {
        Intrinsics.checkNotNullParameter(r100, "backgroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r101, "taskMonitor");
        Intrinsics.checkNotNullParameter(r110, "executors");
        Intrinsics.checkNotNullParameter(r111, "userFlowMonitor");
        super(r100, SetsKt.emptySet(), r101, r110, r111);
    }
}
