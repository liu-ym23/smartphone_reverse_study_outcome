package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ BaseInputComment a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public e0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.e().setCursorVisible(false);
        this.a.e().setCursorVisible(true);
    }
}
