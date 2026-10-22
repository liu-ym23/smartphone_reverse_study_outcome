package com.bytedance.scene.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes19.dex */
public class NavigationFrameLayout extends NoneTouchFrameLayout {
    public NavigationFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> r100) {
        dispatchThawSelfOnly(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> r100) {
        dispatchFreezeSelfOnly(r100);
    }

    public NavigationFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public NavigationFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
