package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/TabIndicatorScrollView;", "Landroid/widget/HorizontalScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabIndicatorScrollView extends HorizontalScrollView {
    public static final /* synthetic */ int f = 0;
    public View a;
    public EdgeGradientFrameLayout b;
    public boolean c;
    public boolean d;
    public final int e;

    public TabIndicatorScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TabIndicatorScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getMeasuredWidth();
        int r2 = getWidth();
        if (r1 <= 0) goto L14;
        if (r2 > 0) goto L10;
        return;
    L10:
        if (r1 > r2) goto L12;
        int[] r5 = new int[2];
        int[] r4 = new int[2];
        getLocationOnScreen(r5);
        getRootView().getLocationOnScreen(r4);
        r0.setTranslationX(RangesKt.coerceIn(((r4[0] + (getRootView().getWidth() / 2.0f)) - r5[0]) - (r1 / 2.0f), 0.0f, r2 - r1));
        scrollTo(0, 0);
        return;
    L12:
        r0.setTranslationX(0.0f);
        return;
    }

    public final void b() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceAtLeast(r0.getMeasuredWidth() - getWidth(), 0);
        boolean r2 = true;
        if (r1 > 0) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r1 > 0) goto L13;
    L15:
        r2 = false;
    L17:
        if (this.c == r3) goto L19;
    L20:
        this.c = r3;
        this.d = r2;
        EdgeGradientFrameLayout r4 = this.b;
        if (r4 == null) goto L31;
        if (r3 == false) goto L24;
        int r5 = this.e;
    L25:
        if (r2 == false) goto L27;
        int r6 = this.e;
    L28:
        r4.b(r5, 0, r6, 0);
        return;
    L27:
        r6 = 0;
        goto L28
    L24:
        r5 = 0;
        goto L25
    L31:
        return;
    L19:
        if (this.d != r2) goto L20;
        return;
    L13:
        if (getScrollX() >= r1) goto L15;
    L8:
        if (getScrollX() <= 0) goto L10;
        r3 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if ((r0 instanceof EdgeGradientFrameLayout) == true) goto L5;
        r0 = null;
    L5:
        this.b = (EdgeGradientFrameLayout) r0;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = findViewById(2131390776);
    }

    public TabIndicatorScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = com.bytedance.android.shopping.extensions.b.a(20);
    }

    public /* synthetic */ TabIndicatorScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        b();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        a();
        b();
    }
}
