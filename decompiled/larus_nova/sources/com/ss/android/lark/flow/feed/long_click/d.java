package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowFeedDialogBuilder f423407a;

    public d(FlowFeedDialogBuilder r100) {
        this.f423407a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f423407a.f423386f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r101 = null;
    L5:
        r101.invoke();
    }
}
