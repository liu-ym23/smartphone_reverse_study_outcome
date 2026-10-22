package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ AsideInputComment a;

    public d(AsideInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.F0();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        DialogFragment r4 = this.a.N;
        boolean r0 = false;
        if (r4 == null) goto L9;
        Dialog r5 = r4.getDialog();
        if (r5 == null) goto L9;
        if (r5.isShowing() != true) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L13;
        AsideInputComment r6 = this.a;
        DialogFragment r1 = r6.N;
        if (r1 == null) goto L13;
        r6.J0(r1);
    L13:
        this.a.g0();
    }
}
