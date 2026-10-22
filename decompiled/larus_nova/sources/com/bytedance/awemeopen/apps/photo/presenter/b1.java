package com.bytedance.awemeopen.apps.photo.presenter;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinchBasicPresenter f197943a;

    public /* synthetic */ b1(PinchBasicPresenter r100) {
        this.f197943a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PinchBasicPresenter r101 = this.f197943a;
        Intrinsics.checkNotNullParameter(r101, "this$0");
        if (r101.f197925n == true) goto L10;
        ViewGroup r102 = r101.f197920i;
        if (r102 == null) goto L11;
        r102.removeCallbacks(r101.f197927p);
        r102.postDelayed(r101.f197927p, ViewConfiguration.getDoubleTapTimeout());
        return;
    L11:
        return;
    }
}
