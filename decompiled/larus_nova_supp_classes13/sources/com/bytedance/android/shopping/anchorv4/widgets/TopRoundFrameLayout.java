package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.anchorv4.components.TopGuideGaussComponent;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class TopRoundFrameLayout extends UserInteractFrameLayout {
    public int c;
    public d d;

    public class a extends ViewOutlineProvider {
        public final /* synthetic */ TopRoundFrameLayout a;

        public a(TopRoundFrameLayout r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            r8.setRoundRect(0, 0, this.a.getWidth(), this.a.getHeight(), this.a.c);
        }
    }

    public float getRadius() {
        return this.c;
    }

    public TopRoundFrameLayout(Context r2) {
        this(r2, null);
    }

    public final void dispatchDraw(Canvas r2) {
        int r0 = this.c;
        super.dispatchDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderRadius(int r2) {
        this.c = r2;
        a(getWidth(), getHeight());
        invalidate();
    }

    public TopRoundFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(int r3, int r4) {
        Lazy r0 = TopGuideGaussComponent.e;
        if (TopGuideGaussComponent.a.a() == false) goto L6;
        setOutlineProvider(new a(this));
        setClipToOutline(true);
    L9:
        d r1 = this.d;
        if (r1 == null) goto L13;
        r1.update(this.c, r3, r4);
        return;
    L13:
        return;
    L6:
        if (this.d != null) goto L8;
        this.d = new d();
    L8:
        setClipToOutline(true);
        this.d.update(this.c, r3, r4);
        setOutlineProvider(this.d);
        goto L9
    }

    public TopRoundFrameLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.c = 0;
        this.d = null;
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, new int[]{2130972522, 2130973851}, r5, 0);
        if (r6.hasValue(1) == false) goto L5;
        this.c = r6.getDimensionPixelOffset(1, 0);
    L5:
        r6.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.FrameLayout*/.onSizeChanged(r1, r2, r3, r4);
        int r5 = this.c;
        a(r1, r2);
    }
}
