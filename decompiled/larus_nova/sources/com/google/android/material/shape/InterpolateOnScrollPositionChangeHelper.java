package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes23.dex */
public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public void updateInterpolationForScreenPosition() {
        ScrollView r100 = this.containingScrollView;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getChildCount() == 0) goto L18;
        this.containingScrollView.getLocationInWindow(this.scrollLocation);
        this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
        int r101 = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
        int r102 = this.shapedView.getHeight();
        int r103 = this.containingScrollView.getHeight();
        if (r101 >= 0) goto L10;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (r101 / r102) + 1.0f)));
        this.shapedView.invalidate();
        return;
    L10:
        int r104 = r101 + r102;
        if (r104 <= r103) goto L14;
        this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r104 - r103) / r102))));
        this.shapedView.invalidate();
        return;
    L14:
        if (this.materialShapeDrawable.getInterpolation() == 1.0f) goto L21;
        this.materialShapeDrawable.setInterpolation(1.0f);
        this.shapedView.invalidate();
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }

    public void setContainingScrollView(ScrollView r100) {
        this.containingScrollView = r100;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable r100) {
        this.materialShapeDrawable = r100;
    }

    public void startListeningForScrollChanges(ViewTreeObserver r100) {
        r100.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(ViewTreeObserver r100) {
        r100.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public InterpolateOnScrollPositionChangeHelper(View r100, MaterialShapeDrawable r101, ScrollView r102) {
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new AnonymousClass1(this);
        this.shapedView = r100;
        this.materialShapeDrawable = r101;
        this.containingScrollView = r102;
    }
}
