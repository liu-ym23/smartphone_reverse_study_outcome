package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowFeedDialogBuilder f423401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnLayoutChangeListener f423402b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f423401a.f423381a.removeOnLayoutChangeListener(this.f423402b);
        r100.removeOnAttachStateChangeListener(this);
    }

    public a(FlowFeedDialogBuilder r100, b r101) {
        this.f423401a = r100;
        this.f423402b = r101;
    }
}
