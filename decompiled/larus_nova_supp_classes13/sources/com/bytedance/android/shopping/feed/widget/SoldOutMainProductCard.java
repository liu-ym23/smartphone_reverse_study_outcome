package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/SoldOutMainProductCard;", "Lcom/bytedance/android/ec/core/widget/RoundedFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SoldOutMainProductCard extends RoundedFrameLayout {
    public FlowTinyProductView b;

    public static DisplayMetrics y(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SoldOutMainProductCard(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        float r9 = 8;
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r9, y(Resources.getSystem()))));
        FlowTinyProductView r10 = new FlowTinyProductView(r6, null, 6, 0);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 110, y(Resources.getSystem())))));
        float r11 = 6;
        r10.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r11, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r9, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r11, y(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r9, y(Resources.getSystem()))));
        r10.setStyle(4);
        Unit r12 = Unit.INSTANCE;
        this.b = r10;
        addView(r10);
        setBackgroundColor(-1);
    }
}
