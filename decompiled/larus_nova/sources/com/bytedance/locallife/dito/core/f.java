package com.bytedance.locallife.dito.core;

import android.app.Dialog;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f257913a;

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        f0 r101 = this.f257913a;
        if (r101 == null) goto L6;
        r101.C2(r100);
        return;
    }

    public f(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
