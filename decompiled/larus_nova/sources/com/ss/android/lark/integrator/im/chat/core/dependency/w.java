package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w4b.e0;

/* JADX INFO: loaded from: classes36.dex */
public final class w implements e0 {
    public w() {
    }

    @Override // w4b.e0
    public final void a(Context r100, String r101, e0.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "topicGroupId");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // w4b.e0
    public final void b(Context r100, l1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        whb.d.a(r100, r101);
    }
}
