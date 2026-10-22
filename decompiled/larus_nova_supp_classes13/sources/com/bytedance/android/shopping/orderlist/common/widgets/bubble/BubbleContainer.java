package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleContainer extends FrameLayout {
    public final ViewGroup a;
    public final View b;
    public final View c;
    public final ViewGroup d;
    public final BubbleShadowLayout e;

    public BubbleContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BubbleContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static void a(final View r5, final b r6) {
        if (r6.a != BubbleOrientation.BOTTOM) goto L5;
        Point r0 = r6.a();
    L6:
        final int r1 = r0.x;
        final int r2 = r6.c.x;
        int r3 = (r1 - r2) - r6.m;
        int r4 = r6.k;
        r5.setTranslationX(RangesKt.coerceIn(r3 - (r4 / 2), 0.0f, RangesKt.coerceAtLeast(r6.h - r4, 0)));
        Lazy r7 = OrderCommonLog.a;
        OrderCommonLog.a("BubbleContainer", new BubbleContainer$handleTrianglePosition$1(r1, r2, r5, r6));
        return;
    L5:
        r0 = r6.b();
        goto L6
    }

    public BubbleContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564140, this, true);
        this.a = (ViewGroup) findViewById(2131379925);
        this.b = findViewById(2131364934);
        this.c = findViewById(2131364902);
        ViewGroup r5 = (ViewGroup) findViewById(2131379903);
        this.d = r5;
        Drawable r6 = r5.getBackground();
        if ((r6 instanceof BackgroundDrawable) == true) goto L5;
        r6 = null;
    L5:
        BackgroundDrawable r7 = (BackgroundDrawable) r6;
        if (r7 == null) goto L8;
        r7.setBgColor(-1);
        r7.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(8));
        r7.invalidate();
    L8:
        this.e = (BubbleShadowLayout) findViewById(2131392473);
    }

    public /* synthetic */ BubbleContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
