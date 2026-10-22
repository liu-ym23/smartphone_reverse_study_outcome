package com.bytedance.android.shopping.product.flow.view.bottom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.extensions.f;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardAbilityBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductFlowCardAbilityBarView extends LinearLayout {
    public ProductFlowCardAbilityBarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductFlowCardAbilityBarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static void a(ProductFlowCardAbilityBarView r1, ProductFlowCardSimpleAbilityView r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "abilityView");
        f.c(r1, r2, null);
    }

    public ProductFlowCardAbilityBarView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        setOrientation(0);
        ShapeDrawable r6 = new ShapeDrawable();
        Resources r0 = Resources.getSystem();
        r6.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()))));
        r6.getPaint().setColor(0);
        Unit r7 = Unit.INSTANCE;
        setDividerDrawable(r6);
        setShowDividers(2);
    }

    public /* synthetic */ ProductFlowCardAbilityBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
