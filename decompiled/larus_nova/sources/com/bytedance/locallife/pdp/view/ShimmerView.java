package com.bytedance.locallife.pdp.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/pdp/view/ShimmerView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class ShimmerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f261900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f261901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f261902c;

    public ShimmerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f261902c;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.translate(this.f261901b, 0.0f);
        r100.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f261900a);
    }

    public ShimmerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f261900a = new Paint();
    }

    public /* synthetic */ ShimmerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        ValueAnimator r101 = this.f261902c;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        if (getWidth() <= 0) goto L8;
        this.f261900a.setShader(new LinearGradient(0.0f, 0.0f, 900.0f, 60.0f, new int[]{0, -1, 0}, new float[]{0.2f, 0.5f, 0.8f}, Shader.TileMode.CLAMP));
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{-getWidth(), getWidth()});
        r102.setDuration(1000);
        r102.setRepeatCount(-1);
        r102.addUpdateListener(new q0(this));
        this.f261902c = r102;
    L8:
        ValueAnimator r103 = this.f261902c;
        if (r103 == null) goto L12;
        r103.start();
        return;
    }
}
