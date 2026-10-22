package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.price.PriceView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InFlowPriceViewV2;", "Lcom/bytedance/android/shopping/feed/widget/BasePriceViewV2;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowPriceViewV2 extends BasePriceViewV2 {
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    public InFlowPriceViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowPriceViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.widget.BasePriceViewV2
    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ld3.b.a() == false) goto L5;
        Map r0 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r4).aU(2131560743, this, true);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560743, this, true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);     // Catch: Exception -> L4
    L6:
        int r1 = com.bytedance.android.shopping.extensions.b.b(12);
        int r2 = (k1.m(getContext()) - r1) - com.bytedance.android.shopping.extensions.b.b(12);
        measureChild(getMainPriceView(), r5, r6);
        measureChild(getSubPriceView(), r5, r6);
        PriceView r7 = getMainPriceView();
        if (r7 == null) goto L9;
        int r8 = r7.getMeasuredWidth();
    L10:
        PriceView r0 = getSubPriceView();
        if (r0 == null) goto L13;
        int r3 = r0.getMeasuredWidth();
    L14:
        int r9 = r8 + r3;
        PriceView r4 = getMainPriceView();
        ViewGroup.LayoutParams r10 = null;
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r11 = r4.getLayoutParams();
    L19:
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r11 = null;
    L21:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        PriceView r13 = getMainPriceView();
        if (r13 == null) goto L24;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L26:
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r14 = null;
    L28:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        PriceView r16 = getSubPriceView();
        if (r16 == null) goto L31;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L33:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r17 = null;
    L35:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        PriceView r19 = getSubPriceView();
        if (r19 == null) goto L38;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L40:
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        r10 = r20;
    L43:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r10;
        if (r9 <= r2) goto L51;
        PriceView r22 = getSubPriceView();
        if (r22 == null) goto L52;
        wg.a.h(r22, false);
        return;
    L52:
        return;
    L51:
        return;
    L38:
        r20 = null;
        goto L40
    L31:
        r17 = null;
        goto L33
    L24:
        r14 = null;
        goto L26
    L17:
        r11 = null;
        goto L19
    L13:
        r3 = 0;
        goto L14
    L9:
        r8 = 0;
    L4:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L6
    }

    public InFlowPriceViewV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ InFlowPriceViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
