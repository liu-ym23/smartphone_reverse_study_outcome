package com.larus.uaigc.chat.markdown.placeholder;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.larus.uaigc.impl.databinding.LarusWidgetMdCreationTextPlaceHolderBinding;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import gz9.b;
import gz9.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;
import we8.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014J\b\u0010%\u001a\u00020\u001eH\u0014J\b\u0010&\u001a\u00020\u001eH\u0014J\u0006\u0010'\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/uaigc/chat/markdown/placeholder/ShimmerTextPlaceHolderView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMdCreationTextPlaceHolderBinding;", SVGRenderEngine.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "dotAnim", "loadingText", "Landroid/widget/TextView;", "getLoadingText", "()Landroid/widget/TextView;", "needStartAnimation", "", "startShimmerAnimation", "", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShimmerTextPlaceHolderView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f371172j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetMdCreationTextPlaceHolderBinding f371173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearGradient f371174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f371175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f371176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f371177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f371178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f371179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f371180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f371181i;

    public ShimmerTextPlaceHolderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShimmerTextPlaceHolderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f371175c == null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L9;
        this.f371181i = true;
        return;
    L9:
        final TextView r100 = this.f371180h;
        float r101 = r100.getWidth() * 1.0f;
        int r102 = this.f371177e;
        this.f371174b = new LinearGradient(0.0f, 0.0f, r101, 0.0f, new int[]{r102, this.f371178f, r102}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        r100.getPaint().setShader(this.f371174b);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{-r100.getWidth(), r100.getWidth()});
        r103.setDuration(1500);
        r103.setRepeatCount(-1);
        r103.setInterpolator(new LinearInterpolator());
        r103.addUpdateListener(new b(this, r100));
        r103.start();
        this.f371175c = r103;
        boolean r104 = h.f552477a;
        if (h.a(null) == false) goto L12;
        this.f371173a.f373280b.setAlpha(1.0f);
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.1f});
    L13:
        r105.setStartDelay(580);
        r105.setInterpolator(new LinearInterpolator());
        r105.setDuration(750);
        r105.setRepeatCount(-1);
        r105.setRepeatMode(2);
        r105.addUpdateListener(new c(this));
        this.f371179g = r105;
        r105.start();
        return;
    L12:
        r105 = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f371181i == false) goto L6;
        a();
        this.f371181i = false;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f371175c;
        if (r100 == null) goto L8;
        r100.cancel();
        ValueAnimator r101 = this.f371179g;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        this.f371175c = null;
    L8:
        this.f371181i = false;
    }

    public final TextView getLoadingText() {
        return this.f371180h;
    }

    public ShimmerTextPlaceHolderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_md_creation_text_place_holder, this);
        int r103 = R.id.loading_dot;
        View r104 = ViewBindings.findChildViewById(this, R.id.loading_dot);
        if (r104 == null) goto L13;
        r103 = R.id.loading_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.loading_text);
        if (r105 == null) goto L13;
        this.f371173a = new LarusWidgetMdCreationTextPlaceHolderBinding(this, r104, r105);
        this.f371176d = new Matrix();
        this.f371177e = ColorProtector.parseColor("#CCCCCC");
        this.f371178f = ColorProtector.parseColor("#666666");
        this.f371180h = r105;
        float r106 = a.a(i5.t(), false);
        r105.setTextSize(0, r106);
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
        if (r107 == null) goto L11;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        float r109 = r106 / i5.t();
        int r110 = (int) (i5.r0() * r109);
        r108.width = r110;
        r108.height = r110;
        r108.topMargin = (int) (i5.z() * r109);
        r104.setLayoutParams(r108);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ ShimmerTextPlaceHolderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L13;
        ValueAnimator r105 = this.f371175c;
        if (r105 == null) goto L14;
        if (r105 == null) goto L11;
        r105.cancel();
        ValueAnimator r106 = this.f371179g;
        if (r106 == null) goto L10;
        r106.cancel();
    L10:
        this.f371175c = null;
    L11:
        this.f371181i = false;
        a();
        return;
    L14:
        return;
    }
}
