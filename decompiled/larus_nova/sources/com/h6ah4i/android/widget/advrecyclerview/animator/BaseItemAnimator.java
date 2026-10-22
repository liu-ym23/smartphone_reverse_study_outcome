package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseItemAnimator extends SimpleItemAnimator {
    public void a() {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onAddFinished(RecyclerView.ViewHolder r100) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onAddStarting(RecyclerView.ViewHolder r100) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onChangeFinished(RecyclerView.ViewHolder r100, boolean r101) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onChangeStarting(RecyclerView.ViewHolder r100, boolean r101) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onMoveFinished(RecyclerView.ViewHolder r100) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onMoveStarting(RecyclerView.ViewHolder r100) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onRemoveFinished(RecyclerView.ViewHolder r100) {
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onRemoveStarting(RecyclerView.ViewHolder r100) {
    }

    public boolean b() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return true;
    L6:
        return false;
    }

    public BaseItemAnimator() {
    }
}
