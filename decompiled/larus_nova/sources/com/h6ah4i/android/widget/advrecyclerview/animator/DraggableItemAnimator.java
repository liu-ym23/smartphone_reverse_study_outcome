package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public class DraggableItemAnimator extends RefactoredDefaultItemAnimator {
    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator, com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public void d() {
        super.d();
        super.setSupportsChangeAnimations(false);
    }

    public DraggableItemAnimator() {
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105) {
        if (r100 != r101) goto L8;
        if (r102 != r104) goto L8;
        if (r103 != r105) goto L8;
        dispatchChangeFinished(r100, true);
        return false;
    L8:
        return super.animateChange(r100, r101, r102, r103, r104, r105);
    }
}
