package com.bytedance.dux.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.largefont.a;
import com.bytedance.dux.popover.PopoverLinearLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/dux/popover/view/LuckyPopoverView;", "Lcom/bytedance/dux/popover/PopoverLinearLayout;", "", "charSequence", "", "setTips", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose", "dux_release"}, k = 1, mv = {1, 7, 1})
public class LuckyPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f205487c;

    public LuckyPopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public LuckyPopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final ImageView getIvClose() {
        return this.f205487c;
    }

    public final void setTips(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f205486b.setText(r100);
    }

    public LuckyPopoverView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false);
        LinearLayout.inflate(r100, R.layout.dux_lucky_popover_view, this);
        setOrientation(0);
        float r103 = 8;
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        Resources r106 = Resources.getSystem();
        int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
        Resources r108 = Resources.getSystem();
        int r109 = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics())));
        Resources r110 = Resources.getSystem();
        setPadding(r105, r107, r109, MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()))));
        setBackground(ContextCompat.getDrawable(r100, R.drawable.dux_popover_view_bg));
        ImageView r111 = (ImageView) findViewById(R.id.iv_icon);
        TextView r112 = (TextView) findViewById(R.id.tv_tips);
        this.f205486b = r112;
        ImageView r113 = (ImageView) findViewById(R.id.iv_close);
        this.f205487c = r113;
        r112.setMaxLines(1);
        r112.setEllipsize(TextUtils.TruncateAt.END);
        a.c(r112, 14.0f);
        a.a(r111, 24, 24);
        a.a(r113, 12, 12);
    }
}
