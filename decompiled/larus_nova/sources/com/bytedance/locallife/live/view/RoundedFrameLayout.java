package com.bytedance.locallife.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes21.dex */
public class RoundedFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f260810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f260811b;

    public RoundedFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
    }

    public void setRadius(int r100) {
        this.f260810a = r100;
        a(getMeasuredWidth(), getMeasuredHeight());
    }

    public RoundedFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        setClipToOutline(true);
        if (this.f260811b <= 0) goto L5;
        setOutlineProvider(new e(this.f260811b, r100, r101));
        return;
    L5:
        setOutlineProvider(new n(this.f260810a, r100, r101));
    }

    public RoundedFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f260810a = 0;
        this.f260811b = 0;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L6;
        this.f260810a = r103.getDimensionPixelOffset(1, 0);
    L8:
        r103.recycle();
        return;
    L6:
        if (r103.hasValue(0) == false) goto L8;
        this.f260811b = r103.getDimensionPixelOffset(0, 0);
        goto L8
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a(r100, r101);
    }
}
