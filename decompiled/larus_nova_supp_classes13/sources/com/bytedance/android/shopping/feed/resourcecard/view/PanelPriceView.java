package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelPriceView extends LinearLayout {
    public final PriceView a;
    public final PriceView b;
    public final ECDraweeView c;
    public final View d;

    public static final class a {
    }

    static {
    }

    public PanelPriceView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PanelPriceView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public PanelPriceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        View r6 = ShoppingAsyncCacheInflater.a.a(r2).aU(2131560793, this, true);
    L6:
        this.d = r6;
        this.a = findViewById(2131370815);
        this.b = findViewById(2131371210);
        this.c = findViewById(2131362181);
        return;
    L5:
        ShoppingAsyncInflater.e.getClass();
        r6 = ShoppingAsyncInflater.a.a(r2).aU(2131560793, this, true);
        goto L6
    }

    public /* synthetic */ PanelPriceView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void a(PanelPriceView r4, final long r5, final Long r7, ECUrlModel r8, final String r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r7 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r10 & 8) == 0) goto L11;
        r9 = null;
    L11:
        r4.a.C(new PanelPriceView$bind$1(r5));
        if (r7 != null) goto L14;
    L17:
        r4.b.setVisibility(8);
    L19:
        if (r8 != null) goto L21;
        r4.c.setVisibility(8);
        View r11 = r4.d;
        float r6 = 5;
        Resources r12 = Resources.getSystem();
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics())));
        Resources r0 = Resources.getSystem();
        r11.setPadding(r13, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r6, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()))), 0);
    L22:
        if (r9 == null) goto L25;
        PriceView r14 = r4.a;
        Resources r15 = Resources.getSystem();
        r14.setTextSize(MathKt.roundToInt(TypedValue.applyDimension(1, 15, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()))));
        r4.a.C(new PanelPriceView$bind$3(r9));
        return;
    L25:
        return;
    L21:
        View r16 = r4.d;
        Resources r1 = Resources.getSystem();
        r16.setPadding(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 5, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()))), 0);
        r4.c.setVisibility(0);
        y.a(r4.c, r8);
        goto L22
    L14:
        if (r7.longValue() == r5) goto L17;
        r4.b.setVisibility(0);
        r4.b.C(new PanelPriceView$bind$2(r7));
        goto L19
    }
}
