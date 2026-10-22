package com.larus.bmhome.chat.layout.widget;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0016J0\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0018H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0014J\b\u0010#\u001a\u00020\u0018H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", SVGRenderEngine.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "needStartAnimation", "", "useAlphaCenterColor", "setTextColorInfo", "", "(ILjava/lang/Integer;)V", "startShimmerAnimation", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShimmerTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f304901h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearGradient f304902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f304903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f304904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f304905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f304906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f304907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f304908g;

    public ShimmerTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void x() {
        ValueAnimator r100 = this.f304903b;
        if (r100 == null) goto L7;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        this.f304903b = null;
        getPaint().setShader(null);
        invalidate();
    L7:
        this.f304907f = false;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f304907f == false) goto L6;
        z(this.f304908g);
        this.f304907f = false;
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x();
    }

    public final void z(boolean r110) {
        this.f304908g = r110;
        if (this.f304903b == null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L10;
        this.f304907f = true;
        return;
    L10:
        if (r110 == false) goto L12;
        int r100 = this.f304905d;
        int[] r111 = {r100, this.f304906e, r100};
    L13:
        this.f304902a = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r111, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(this.f304902a);
        ValueAnimator r112 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(MapBundleKey.MapObjKey.OBJ_TEXT, new Keyframe[]{Keyframe.ofFloat(0.0f, -getWidth()), Keyframe.ofFloat(0.8f, getWidth()), Keyframe.ofFloat(1.0f, getWidth())})});
        r112.setDuration(1000);
        r112.setRepeatCount(-1);
        r112.setInterpolator(new LinearInterpolator());
        r112.addUpdateListener(new h1(this));
        r112.start();
        this.f304903b = r112;
        return;
    L12:
        int r101 = this.f304906e;
        r111 = new int[]{r101, this.f304905d, r101};
        goto L13
    }

    public static void y(ShimmerTextView r100, int r101) {
        r100.f304905d = r101;
        r100.f304906e = ftc.a.a(r101, 68);
    }

    public ShimmerTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f304904c = new Matrix();
        int r103 = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_70, r100, R.color.larus_neutral_70));
        this.f304905d = r103;
        this.f304906e = ftc.a.a(r103, 68);
    }

    public /* synthetic */ ShimmerTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f304903b == null) goto L9;
        x();
        z(this.f304908g);
        return;
    }
}
