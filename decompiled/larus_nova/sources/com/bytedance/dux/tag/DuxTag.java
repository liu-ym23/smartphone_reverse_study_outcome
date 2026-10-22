package com.bytedance.dux.tag;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Deprecated(message = "use DuxTagNew")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/dux/tag/DuxTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxTag extends AppCompatTextView {
    public DuxTag(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxTag(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    public static DisplayMetrics x(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public DuxTag(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.bgGradientEndColor, R.attr.bgGradientStartColor, R.attr.borderColor, R.attr.bordered, R.attr.size}, 0, 0);
        int r104 = r103.getInteger(4, 0);     // Catch: Throwable -> L17
        r103.getBoolean(3, false);     // Catch: Throwable -> L17
        r103.getColor(2, 0);     // Catch: Throwable -> L17
        int r105 = r103.getColor(1, 0);     // Catch: Throwable -> L17
        int r106 = r103.getColor(0, 0);     // Catch: Throwable -> L17
        r103.recycle();
        if (r104 == 0) goto L9;
        if (r104 == 2) goto L8;
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, x(Resources.getSystem())));
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, x(Resources.getSystem())));
    L10:
        setPadding(r108, r107, r108, r107);
        if (r105 == 0) goto L14;
        if (r106 == 0) goto L14;
        GradientDrawable r109 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{r105, r106});
    L15:
        r109.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 2, x(Resources.getSystem()))));
        setBackground(r109);
        return;
    L14:
        r109 = new GradientDrawable();
        goto L15
    L8:
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 2, x(Resources.getSystem())));
        r108 = MathKt.roundToInt(TypedValue.applyDimension(1, 4, x(Resources.getSystem())));
        goto L10
    L9:
        r108 = MathKt.roundToInt(TypedValue.applyDimension(1, 3, x(Resources.getSystem())));
        r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, x(Resources.getSystem())));
    L17:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public /* synthetic */ DuxTag(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
