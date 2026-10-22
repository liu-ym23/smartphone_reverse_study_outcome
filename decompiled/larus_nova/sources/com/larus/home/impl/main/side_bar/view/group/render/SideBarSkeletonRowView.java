package com.larus.home.impl.main.side_bar.view.group.render;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/render/SideBarSkeletonRowView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shimmerPaint", "Landroid/graphics/Paint;", "blockPath", "Landroid/graphics/Path;", "blockRect", "Landroid/graphics/RectF;", "shimmerColor", "animator", "Landroid/animation/ValueAnimator;", "shimmerOffset", "", "onAttachedToWindow", "", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawShimmer", "shimmerAlphaScaleOn", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "bandCenter", "scaleAlpha", "color", "scale", "startShimmer", "stopShimmer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarSkeletonRowView extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f345593g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f345594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f345595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f345596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f345597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f345598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f345599f;

    public static final class a {
    }

    static {
    }

    public SideBarSkeletonRowView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SideBarSkeletonRowView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ValueAnimator r100 = this.f345598e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f345598e = null;
        this.f345599f = 0.0f;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator r100 = this.f345598e;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isRunning() != true) goto L7;
    L8:
        if (r101 == true) goto L12;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new q0(this));
        r102.start();
        this.f345598e = r102;
        return;
    L12:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.dispatchDraw(r210);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L33;
        float r100 = getWidth() * 0.65f;
        float r101 = this.f345599f - r100;
        float r110 = 2.0f;
        float r111 = r101 + (r100 / 2.0f);
        int r112 = getChildCount();
        int r113 = 0;
        int r114 = 0;
    L8:
        if (r114 >= r112) goto L34;
        View r102 = getChildAt(r114);
        if (r102.getVisibility() != 0) goto L28;
        if (r102.getWidth() <= 0) goto L28;
        if (r102.getHeight() <= 0) goto L28;
        Intrinsics.checkNotNull(r102);
        float r103 = 1.0f;
        if (r102.getWidth() == r102.getHeight()) goto L21;
        r103 = RangesKt.coerceIn(1.0f - ((r111 - r102.getLeft()) / r102.getWidth()), 0.0f, 1.0f);
    L21:
        if (r103 <= 0.0f) goto L28;
        this.f345596c.set(r102.getLeft(), r102.getTop(), r102.getRight(), r102.getBottom());
        if (r102.getWidth() != r102.getHeight()) goto L25;
        float r104 = r102.getWidth() / r110;
    L26:
        this.f345595b.reset();
        this.f345595b.addRoundRect(this.f345596c, r104, r104, Path.Direction.CW);
        Paint r115 = this.f345594a;
        int[] r105 = new int[3];
        r105[r113] = r113;
        int r106 = this.f345597d;
        r105[1] = (r106 & 16777215) | (RangesKt.coerceIn((int) (Color.alpha(r106) * r103), r113, 255) << 24);
        r105[2] = r113;
        r115.setShader(new LinearGradient(r101, 0.0f, r101 + r100, 0.0f, r105, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        r210.save();
        r210.clipPath(this.f345595b);
        r210.drawRect(this.f345596c, this.f345594a);
        r210.restore();
        goto L28
    L25:
        r104 = i5.j0();
    L28:
        r114 = r114 + 1;
        r110 = 2.0f;
        r113 = 0;
        goto L8
    L34:
        return;
    }

    public SideBarSkeletonRowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f345594a = new Paint(1);
        this.f345595b = new Path();
        this.f345596c = new RectF();
        this.f345597d = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2_day));
    }

    public /* synthetic */ SideBarSkeletonRowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
