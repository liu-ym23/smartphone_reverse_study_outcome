package com.larus.common_ui.toast;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J5\u0010\u0015\u001a\u00020\u000f2\u001b\b\u0002\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00192\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ$\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ)\u0010\u0015\u001a\u00020\u000f2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001fJ?\u0010 \u001a\u00020\u000f2\b\b\u0001\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0#H\u0000¢\u0006\u0002\b$J\u0012\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/common_ui/toast/ToastLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/text/TextPaint;", "setYOffsetPx", "", "yOffsetPx", "(Ljava/lang/Integer;)V", "updateText", "text", "", "setContent", "config", "Lkotlin/Function1;", "Lcom/lynx/lottieadapter/LottieAdapterView;", "Lkotlin/ExtensionFunctionType;", "isForceDarkMode", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconResId", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Z)V", "setActionContent", "actionText", "onActionClick", "Lkotlin/Function0;", "setActionContent$common_ui_mainlandRelease", "adapterContentDarkMode", "shouldUseMultiLine", "hasImage", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f327823a;

    public ToastLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        TextPaint r101 = new TextPaint();
        r101.setTextSize(i5.x0(c.b(R.attr.larus_sp_15, null, R.dimen.larus_sp_15)));
        this.f327823a = r101;
    }

    public final void R5(boolean r100) {
        if (r100 == false) goto L5;
        ((LinearLayout) findViewById(R.id.layout_toast_container)).setBackgroundResource(R.drawable.larus_toast_background_night);
        ((TextView) findViewById(R.id.textView)).setTextColor(ContextCompat.getColor(getContext(), R.color.larus_static_white));
        return;
    }

    public final void setYOffsetPx(Integer r100) {
        LinearLayout r101 = (LinearLayout) findViewById(R.id.layout_toast_container);
        if (r101 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        int r104 = getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_72, null, R.dimen.larus_dp_72));
        if (r100 == null) goto L14;
        int r105 = r100.intValue();
    L15:
        r103.topMargin = r104 + r105;
        r101.setLayoutParams(r103);
        return;
    L14:
        r105 = 0;
        goto L15
    L8:
        r103 = null;
        goto L9
    }

    public ToastLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TextPaint r102 = new TextPaint();
        r102.setTextSize(i5.x0(c.b(R.attr.larus_sp_15, null, R.dimen.larus_sp_15)));
        this.f327823a = r102;
    }

    public final boolean T5(boolean r100, CharSequence r101) {
        Resources r102 = getContext().getResources();
        int r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).widthPixels;
        float r104 = 0.0f;
        if (r100 == false) goto L5;
        float r105 = i5.x0(c.b(R.attr.larus_dp_24, null, R.dimen.larus_dp_24));
    L6:
        if (r100 == false) goto L8;
        r104 = i5.x0(c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
    L8:
        float r106 = 2;
        if (this.f327823a.measureText(r101, 0, r101.length()) <= ((((r103 - (i5.x0(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16)) * r106)) - (r106 * i5.x0(c.b(R.attr.larus_dp_20, null, R.dimen.larus_dp_20)))) - r105) - r104)) goto L12;
        return true;
    L12:
        return false;
    L5:
        r105 = 0.0f;
        goto L6
    }

    public ToastLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextPaint r103 = new TextPaint();
        r103.setTextSize(i5.x0(c.b(R.attr.larus_sp_15, null, R.dimen.larus_sp_15)));
        this.f327823a = r103;
    }

    public final void S5(Integer r100, CharSequence r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r100 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (T5(r103, r101) == false) goto L11;
        ViewGroup.inflate(getContext(), R.layout.larus_layout_toast_multi_line, this);
    L12:
        R5(r102);
        TextView r104 = (TextView) findViewById(R.id.textView);
        LottieAdapterView r105 = (LottieAdapterView) findViewById(R.id.lottieAdapterView);
        if (r100 != null) goto L15;
    L18:
        r105.setVisibility(8);
    L19:
        r104.setText(r101);
        return;
    L15:
        if (r100.intValue() == 0) goto L18;
        r105.setImageResource(r100.intValue());
        goto L19
    L11:
        ViewGroup.inflate(getContext(), R.layout.larus_layout_toast_flow, this);
        goto L12
    L5:
        if (r100.intValue() == 0) goto L7;
        r103 = true;
        goto L9
    }
}
