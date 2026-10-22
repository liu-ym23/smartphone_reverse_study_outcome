package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopPriceViewManager extends com.bytedance.android.ecom.arch.slice.render.elements.b<PriceView> {
    public static final /* synthetic */ int R3 = 0;
    public int H3;
    public String I3;
    public int J3;
    public int K3;
    public Integer L3;
    public String M3;
    public int N3;
    public final Lazy O3;
    public Float P3;
    public Integer Q3;

    public static final class a {
    }

    static {
    }

    public ShopPriceViewManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.K3 = 18;
        this.N3 = 1;
        this.O3 = LazyKt.lazy(ShopPriceViewManager$priceTypeface$2.INSTANCE);
    }

    public final void H0(final Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        l1().C(new ShopPriceViewManager$onUpdateProp$1(this, r3));
    }

    public final View n1(final Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        PriceView r0 = new PriceView(r5, null, 0, 14);
        r0.setLines(1);
        r0.setLineSpacing(SlcDimensExtensionsKt.a(2, ((BaseSlcViewManager) this).a.m()), 1.0f);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        final int r1 = ContextCompat.getColor(r5, 2131101807);
        r0.C(new ShopPriceViewManager$onCreateContentView$$inlined$apply$lambda$1(r1, this, r5));
        Unit r6 = Unit.INSTANCE;
        return r0;
    }

    public final long u0(float r4, YogaMeasureMode r5, float r6, YogaMeasureMode r7) {
        Intrinsics.checkNotNullParameter(r5, "widthMode");
        Intrinsics.checkNotNullParameter(r7, "heightMode");
        int r0 = Math.round(r6);
        int r1 = e.a[r7.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = Integer.MIN_VALUE;
    L9:
        int r3 = View.MeasureSpec.makeMeasureSpec(r0, r2);
        this.P3 = Float.valueOf(r4);
        this.Q3 = Integer.valueOf(r3);
        return super/*com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager*/.u0(r4, r5, r6, r7);
    L5:
        if (r1 == 2) goto L7;
        r2 = 0;
        goto L9
    L7:
        r2 = 1073741824;
        goto L9
    }
}
