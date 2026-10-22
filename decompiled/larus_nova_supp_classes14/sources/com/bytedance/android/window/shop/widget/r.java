package com.bytedance.android.window.shop.widget;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ ToolBarView a;

    public r(ToolBarView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((Boolean) r3).booleanValue() == true) goto L13;
        LifecycleOwner r4 = this.a.getLifecycleOwner();
        if (r4 == null) goto L12;
        ConstraintLayout r0 = this.a.g;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");
    L10:
        r0.post(new q(r4, this));
        return;
    L12:
        return;
    }
}
