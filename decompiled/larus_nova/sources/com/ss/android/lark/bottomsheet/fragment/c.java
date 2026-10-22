package com.ss.android.lark.bottomsheet.fragment;

import androidx.lifecycle.Observer;
import com.ss.android.lark.bottomsheet.view.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheetFrameFragment f410713a;

    public c(BottomSheetFrameFragment r100) {
        this.f410713a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Float r101 = (Float) r100;
        j r102 = this.f410713a.f410708h;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r102.d(r101.floatValue());
        return;
    }
}
