package com.bytedance.locallife.live.goodsshelves.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeShelfCardLynxView f260284a;

    public d(LiveLocalLifeShelfCardLynxView r100) {
        this.f260284a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        View.OnAttachStateChangeListener r101 = this.f260284a.getAttachStateListener();
        if (r101 == null) goto L6;
        r101.onViewAttachedToWindow(r100);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        View.OnAttachStateChangeListener r101 = this.f260284a.getAttachStateListener();
        if (r101 == null) goto L6;
        r101.onViewDetachedFromWindow(r100);
        return;
    }
}
