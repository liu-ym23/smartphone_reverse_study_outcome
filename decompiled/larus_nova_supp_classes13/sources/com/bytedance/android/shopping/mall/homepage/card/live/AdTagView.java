package com.bytedance.android.shopping.mall.homepage.card.live;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/AdTagView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdTagView extends AppCompatTextView {
    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        GradientDrawable r0 = new GradientDrawable();
        float r5 = 4;
        r0.setCornerRadii(new float[]{0.0f, 0.0f, TypedValue.applyDimension(1, r5, x(Resources.getSystem())), TypedValue.applyDimension(1, r5, x(Resources.getSystem())), 0.0f, 0.0f, TypedValue.applyDimension(1, r5, x(Resources.getSystem())), TypedValue.applyDimension(1, r5, x(Resources.getSystem()))});
        r0.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r1 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdTagView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r0.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r6 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r0);
    }

    public static DisplayMetrics x(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdTagView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r6 = new GradientDrawable();
        r6.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r6.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r7 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdTagView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        setText("广告");
        setTextSize(8.0f);
        setTextColor(ColorProtector.parseColor("#BFFFFFFF"));
        setPadding(b0.c(1), b0.c(1), b0.c(1), b0.c(1));
        GradientDrawable r6 = new GradientDrawable();
        r6.setCornerRadius(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r6.setColor(ColorProtector.parseColor("#1F161823"));
        Unit r7 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(this, "$this$setBackgroundCompat");
        setBackground(r6);
    }
}
