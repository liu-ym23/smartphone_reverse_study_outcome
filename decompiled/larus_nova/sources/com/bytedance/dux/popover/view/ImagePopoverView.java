package com.bytedance.dux.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.dux.largefont.a;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/dux/popover/view/ImagePopoverView;", "Lcom/bytedance/dux/popover/view/LinkPopoverView;", "", "show", "", "setShowArrow", "Landroid/view/View$OnClickListener;", "listener", "setImageClickListener", "", "resId", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class ImagePopoverView extends LinkPopoverView {
    public ImagePopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public ImagePopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public static DisplayMetrics b(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setImageClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getIvIcon().setOnClickListener(r100);
    }

    @Override // com.bytedance.dux.popover.view.LinkPopoverView
    public void setLeftIcon(int r100) {
        float r101 = 8;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 10, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))));
        super.setLeftIcon(r100);
    }

    public final void setShowArrow(boolean r100) {
        ImageView r101 = getIvArrow();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // com.bytedance.dux.popover.view.LinkPopoverView
    public void setLeftIcon(Drawable r100) {
        float r101 = 8;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 10, b(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, b(Resources.getSystem()))));
        super.setLeftIcon(r100);
    }

    public ImagePopoverView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false);
        ImageView r103 = getIvIcon();
        ViewGroup.LayoutParams r104 = getIvIcon().getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        float r106 = 24;
        r105.height = MathKt.roundToInt(TypedValue.applyDimension(2, r106, b(Resources.getSystem())));
        r105.width = MathKt.roundToInt(TypedValue.applyDimension(2, r106, b(Resources.getSystem())));
        r105.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 6, b(Resources.getSystem()))));
        r103.setLayoutParams(r105);
        getIvIcon().setImageTintList(null);
        if (getLimitLargeFontScale() == false) goto L10;
        a.a(getIvIcon(), 24, 24);
        return;
    }
}
