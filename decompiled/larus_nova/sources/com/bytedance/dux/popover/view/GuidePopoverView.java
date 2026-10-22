package com.bytedance.dux.popover.view;

import android.content.Context;
import android.content.res.Resources;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/dux/popover/view/GuidePopoverView;", "Lcom/bytedance/dux/popover/PopoverLinearLayout;", "", "charSequence", "", "setStatusText", "setGuideText", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTvStatus", "()Landroid/widget/TextView;", "tvStatus", "c", "getTvGuide", "tvGuide", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getIvGuide", "()Landroid/widget/ImageView;", "ivGuide", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class GuidePopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f205482d;

    public GuidePopoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public GuidePopoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final ImageView getIvGuide() {
        return this.f205482d;
    }

    public final TextView getTvGuide() {
        return this.f205481c;
    }

    public final TextView getTvStatus() {
        return this.f205480b;
    }

    public final void setGuideText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f205481c.setText(r100);
    }

    public final void setStatusText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "charSequence");
        this.f205480b.setText(r100);
    }

    public GuidePopoverView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, false);
        LinearLayout.inflate(r100, R.layout.dux_popover_guide_view, this);
        setOrientation(0);
        float r103 = 12;
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        float r106 = 10;
        Resources r107 = Resources.getSystem();
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        Resources r109 = Resources.getSystem();
        int r110 = MathKt.roundToInt(TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
        Resources r111 = Resources.getSystem();
        setPadding(r105, r108, r110, MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()))));
        setBackground(ContextCompat.getDrawable(r100, R.drawable.dux_popover_view_bg));
        TextView r112 = (TextView) findViewById(R.id.tv_status_text);
        this.f205480b = r112;
        TextView r113 = (TextView) findViewById(R.id.tv_guide_text);
        this.f205481c = r113;
        ImageView r114 = (ImageView) findViewById(R.id.iv_guide_arrow);
        this.f205482d = r114;
        if (getLimitLargeFontScale() == false) goto L10;
        a.c(r112, 14.0f);
        a.c(r113, 14.0f);
        a.a(r114, 12, 12);
        return;
    }
}
