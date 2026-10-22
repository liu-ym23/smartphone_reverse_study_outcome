package com.bytedance.android.shopping.product.flow.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "", "count", "", "setUpViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultBannerIndicatorView extends LinearLayout implements c {
    public final ArrayList<ImageView> a;
    public final int b;
    public final int c;
    public final int d;

    public DefaultBannerIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DefaultBannerIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerView");
    }

    private final void setUpViews(int r7) {
        if (r7 > 1) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        Iterator<T> r2 = this.a.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((ImageView) r2.next()).setVisibility(8);
        goto L8
    L10:
        int r1 = 0;
    L11:
        if (r1 >= r7) goto L19;
        ImageView r3 = (ImageView) CollectionsKt.getOrNull(this.a, r1);
        if (r3 != null) goto L18;
        r3 = new ImageView(getContext());
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (r1 == 0) goto L17;
        r4.leftMargin = this.d;
    L17:
        addView(r3, r4);
        this.a.add(r3);
    L18:
        r3.setVisibility(0);
        r1 = r1 + 1;
        goto L11
    }

    @Override // yg3.c
    public final void a(int r1, int r2) {
        c(r1, r2);
    }

    public final void c(int r11, int r12) {
        setUpViews(r12);
        if (r12 > 1) goto L5;
        return;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r12) goto L31;
        if (r12 <= 5) goto L10;
        int r3 = r11 % r12;
        if (r3 != r2) goto L17;
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.b);
    L30:
        r2 = r2 + 1;
        goto L6
    L17:
        if (r11 >= 4) goto L21;
        if (r3 == r2) goto L20;
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.c);
    L20:
        ((ImageView) ListProtector.get(this.a, r12 - 2)).setBackgroundResource(2131233437);
        ((ImageView) ListProtector.get(this.a, r12 - 1)).setBackgroundResource(2131233436);
        goto L30
    L21:
        int r7 = r12 - 2;
        if (r11 >= r7) goto L27;
        if (r11 < 4) goto L27;
        if (r3 == r2) goto L26;
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.c);
    L26:
        ((ImageView) ListProtector.get(this.a, 0)).setBackgroundResource(2131233424);
        ((ImageView) ListProtector.get(this.a, 1)).setBackgroundResource(2131233425);
        ((ImageView) ListProtector.get(this.a, r7)).setBackgroundResource(2131233437);
        ((ImageView) ListProtector.get(this.a, r12 - 1)).setBackgroundResource(2131233436);
    L27:
        if (r3 == r2) goto L29;
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.c);
    L29:
        ((ImageView) ListProtector.get(this.a, 0)).setBackgroundResource(2131233424);
        ((ImageView) ListProtector.get(this.a, 1)).setBackgroundResource(2131233425);
        goto L30
    L10:
        if ((r11 % r12) != r2) goto L12;
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.b);
        goto L30
    L12:
        ((ImageView) ListProtector.get(this.a, r2)).setBackgroundResource(this.c);
        goto L30
    }

    public DefaultBannerIndicatorView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new ArrayList();
        this.b = 2131233442;
        this.c = 2131233443;
        Resources r8 = Resources.getSystem();
        this.d = MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics())));
        setGravity(17);
        setBackgroundResource(2131247913);
        float r9 = 8;
        Resources r10 = Resources.getSystem();
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, r9, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics())));
        float r0 = (float) 7.5d;
        Resources r1 = Resources.getSystem();
        int r2 = MathKt.roundToInt(TypedValue.applyDimension(1, r0, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        Resources r3 = Resources.getSystem();
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, r9, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        Resources r4 = Resources.getSystem();
        setPadding(r11, r2, r12, MathKt.roundToInt(TypedValue.applyDimension(1, r0, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()))));
    }

    public /* synthetic */ DefaultBannerIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
