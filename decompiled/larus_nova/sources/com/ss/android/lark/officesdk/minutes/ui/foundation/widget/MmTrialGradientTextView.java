package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmTrialGradientTextView;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/LineHeightTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "lastWidth", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmTrialGradientTextView extends LineHeightTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f435723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f435724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f435725g;

    public MmTrialGradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmTrialGradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f435723e != 0) goto L5;
    L14:
        getPaint().setShader(null);
    L15:
        super.onDraw(r110);
        return;
    L5:
        if (this.f435724f == 0) goto L14;
        float r100 = getPaint().measureText(getText().toString());
        if (r100 <= 0.0f) goto L15;
        if (r100 != this.f435725g) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == true) goto L15;
        this.f435725g = r100;
        getPaint().setShader(new LinearGradient(r100, 0.0f, 0.0f, 0.0f, new int[]{this.f435723e, this.f435724f}, null, Shader.TileMode.CLAMP));
        goto L15
    L11:
        r101 = false;
        goto L12
    }

    public MmTrialGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setText(r100.getString(R.string.View_Common_Trial_Tag));
        this.f435723e = ContextCompat.getColor(r100, R.color.office_sdk_mm_gradient_ai_text_start_color);
        this.f435724f = ContextCompat.getColor(r100, R.color.office_sdk_mm_gradient_ai_text_end_color);
        setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r100).q(r100));
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public /* synthetic */ MmTrialGradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
