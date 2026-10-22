package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/OverScrolledViewPager;", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "Lcom/bytedance/android/shopping/commentfeed/widget/OverScrolledViewPager$a;", "listener", "", "setOnRefreshListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrolledViewPager extends VerticalViewPager {
    public boolean P0;
    public boolean V0;
    public final Rect b1;
    public a g1;
    public float h1;
    public int k1;
    public final int p1;

    public interface a {
        void a();

        void onLoadMore();

        void onRefresh();
    }

    public OverScrolledViewPager(Context r1) {
        super(r1);
        this.P0 = true;
        this.b1 = new Rect();
        this.p1 = vf4.a.b(30);
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        int r0 = r6.getAction();
        if (r0 == 1) goto L25;
        if (r0 != 2) goto L40;
        if (this.h1 != 0.0f) goto L10;
        this.h1 = r6.getY();
    L10:
        int r1 = ((int) (this.h1 - r6.getY())) / 2;
        this.k1 = r1;
        if (this.P0 == false) goto L14;
        if (r1 > 0) goto L14;
    L16:
        Rect r7 = this.b1;
        layout(r7.left, -r1, r7.right, r7.bottom - r1);
        if (this.V0 == true) goto L19;
    L23:
        return true;
    L19:
        if (Math.abs(this.k1) <= this.p1) goto L23;
        a r8 = this.g1;
        if (r8 == null) goto L23;
        r8.a();
    L14:
        if (this.V0 == false) goto L40;
        if (r1 >= 0) goto L16;
    L40:
        return super.onTouchEvent(r6);
    L25:
        if (this.P0 == false) goto L27;
    L28:
        int r2 = this.k1;
        int r3 = this.p1;
        if (r2 <= r3) goto L34;
        a r4 = this.g1;
        if (r4 == null) goto L38;
        r4.onLoadMore();
    L38:
        this.h1 = 0.0f;
        TranslateAnimation r5 = new TranslateAnimation(0.0f, 0.0f, getY(), this.b1.top);
        r5.setDuration(200);
        startAnimation(r5);
        Rect r9 = this.b1;
        layout(r9.left, r9.top, r9.right, r9.bottom);
        goto L40
    L34:
        if (r2 >= (-r3)) goto L38;
        a r10 = this.g1;
        if (r10 == null) goto L38;
        r10.onRefresh();
        goto L38
    L27:
        if (this.V0 == false) goto L40;
        goto L28
    }

    public final void setOnRefreshListener(a r1) {
        this.g1 = r1;
    }

    public OverScrolledViewPager(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.P0 = true;
        this.b1 = new Rect();
        this.p1 = vf4.a.b(30);
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager
    public final void m(int r6, float r7, int r8) {
        if (getAdapter() != null) goto L5;
    L20:
        this.P0 = false;
        this.V0 = false;
    L22:
        if (this.b1.isEmpty() == true) goto L25;
        Rect r0 = this.b1;
        if ((r0.left - r0.right) == 0) goto L25;
    L26:
        super.m(r6, r7, r8);
        return;
    L25:
        this.b1.set(getLeft(), getTop(), getRight(), getBottom());
        goto L26
    L5:
        if (getAdapter().getCount() == 0) goto L20;
        if (r6 != 0) goto L14;
        if (r7 != 0.0f) goto L14;
        if (r8 != 0) goto L14;
        this.P0 = true;
    L14:
        if (r6 == (getAdapter().getCount() - 1)) goto L16;
    L19:
        this.P0 = false;
        this.V0 = false;
        goto L22
    L16:
        if (r7 != 0.0f) goto L19;
        if (r8 != 0) goto L19;
        this.V0 = true;
        goto L22
    }
}
