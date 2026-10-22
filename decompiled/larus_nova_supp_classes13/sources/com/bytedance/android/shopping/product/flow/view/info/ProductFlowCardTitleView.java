package com.bytedance.android.shopping.product.flow.view.info;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/info/ProductFlowCardTitleView;", "Landroid/widget/FrameLayout;", "", "visible", "", "setArrowStyleVisible", "", "maxLine", "setMaxLine", "lines", "setLines", "isBold", "setTextStyle", "iconMarginRight", "setIconMarginRight", "", "textAndIconSizeDP", "setTextAndIconSizeDP", "extra", "setLineSpacingExtra", "Landroid/widget/TextView;", "getTextview", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFlowCardTitleView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final TextView a;
    public final View b;
    public Disposable c;

    public static final class a {
    }

    static {
    }

    public ProductFlowCardTitleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardTitleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setIconMarginRight(int r1) {
    }

    public final TextView getTextview() {
        return this.a;
    }

    public final void setArrowStyleVisible(boolean r2) {
        if (r2 == false) goto L4;
        this.b.setVisibility(0);
        return;
    L4:
        this.b.setVisibility(8);
    }

    public final void setLineSpacingExtra(float r3) {
        this.a.setLineSpacing(r3, 1.0f);
    }

    public final void setLines(int r2) {
        this.a.setLines(r2);
    }

    public final void setMaxLine(int r2) {
        this.a.setMaxLines(r2);
    }

    public final void setTextAndIconSizeDP(float r3) {
        this.a.setTextSize(1, r3);
    }

    public final void setTextStyle(boolean r2) {
        if (r2 == false) goto L4;
        this.a.setTypeface(Typeface.defaultFromStyle(1));
        return;
    L4:
        this.a.setTypeface(Typeface.defaultFromStyle(0));
    }

    public ProductFlowCardTitleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 3, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
        if (ld3.b.a() == false) goto L5;
        Map r6 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560809, this, true);
    L6:
        TextView r7 = (TextView) findViewById(2131383165);
        this.a = r7;
        this.b = findViewById(2131383166);
        int r8 = g1.a;
        r7.setTextColor(g1.a.a(r2, 2131100046));
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560809, this, true);
        goto L6
    }

    public final void a(String r7, ECUrlModel r8, ECUrlModel r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L5;
        r0.add(r9);
    L5:
        if (r8 == null) goto L7;
        r0.add(r8);
    L7:
        int r10 = 14;
        if (r8 == null) goto L10;
        int r11 = r8.getHeight();
    L11:
        if (r11 <= 0) goto L14;
        r10 = r11;
    L14:
        p1 r12 = p1.d;
        TextView r4 = this.a;
        Float r5 = Float.valueOf(4.0f);
        r12.getClass();
        Disposable r13 = p1.a(r0, r7, 4.0f, r10, r4, r5);
        if (r13 == null) goto L18;
        this.c = r13;
        return;
    L18:
        return;
    L10:
        r11 = 14;
        goto L11
    }

    public /* synthetic */ ProductFlowCardTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
