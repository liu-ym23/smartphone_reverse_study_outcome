package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class b1 implements View.OnClickListener {
    public final /* synthetic */ PinchBasicPresenter a;

    public /* synthetic */ b1(PinchBasicPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        PinchBasicPresenter r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.n == true) goto L10;
        ViewGroup r0 = r5.i;
        if (r0 == null) goto L11;
        r0.removeCallbacks(r5.p);
        r0.postDelayed(r5.p, ViewConfiguration.getDoubleTapTimeout());
        return;
    L11:
        return;
    }
}
