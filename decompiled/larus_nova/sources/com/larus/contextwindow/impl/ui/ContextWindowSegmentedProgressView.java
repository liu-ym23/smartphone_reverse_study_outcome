package com.larus.contextwindow.impl.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0014\u0010\"\u001a\u00020\u0007*\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/contextwindow/impl/ui/ContextWindowSegmentedProgressView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "bounds", "Landroid/graphics/RectF;", "primary50", "segmentColors", "", "trackColor", "parts", "", "total", "", "setUsageParts", "", "segmentColorAt", "index", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resolveColor", SlcElement.KEY_ATTR, "fallback", "withAlpha", "fraction", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowSegmentedProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f330428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f330429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f330430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f330431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f330432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long[] f330433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f330434g;

    public static final class a {
    }

    static {
    }

    public ContextWindowSegmentedProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ContextWindowSegmentedProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int a(int r100) {
        int[] r101 = this.f330431d;
        return r101[RangesKt.coerceIn(r100, 0, ArraysKt.getLastIndex(r101))];
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L24;
        this.f330430c.set(0.0f, 0.0f, getWidth(), getHeight());
        float r100 = getHeight() / 2.0f;
        this.f330429b.reset();
        this.f330429b.addRoundRect(this.f330430c, r100, r100, Path.Direction.CW);
        int r101 = r110.save();
        r110.clipPath(this.f330429b);
        this.f330428a.setColor(this.f330432e);
        r110.drawRect(this.f330430c, this.f330428a);
        if (this.f330434g <= 0) goto L17;
        long[] r111 = this.f330433f;
        int r112 = r111.length;
        int r102 = 0;
        float r103 = 0.0f;
        int r113 = 0;
    L10:
        if (r113 >= r112) goto L17;
        long r104 = r111[r113];
        int r114 = r102 + 1;
        if (r103 >= getWidth()) goto L16;
        float r105 = RangesKt.coerceAtLeast(Math.min(getWidth() - r103, (float) ((RangesKt.coerceAtLeast(r104, 0) / this.f330434g) * ((double) getWidth()))), 0.0f);
        if (r105 <= 0.0f) goto L16;
        this.f330428a.setColor(this.f330431d[r102]);
        float r115 = r103 + r105;
        r110.drawRect(r103, 0.0f, r115, getHeight(), this.f330428a);
        r103 = r115;
    L16:
        r113 = r113 + 1;
        r102 = r114;
    L17:
        r110.restoreToCount(r101);
        return;
    }

    public ContextWindowSegmentedProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f330428a = new Paint(1);
        this.f330429b = new Path();
        this.f330430c = new RectF();
        int r103 = v19.c.a(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50);
        float r104 = 255;
        this.f330431d = new int[]{v19.c.a(R.attr.larus_primary_70, getContext(), R.color.larus_primary_70), r103, ColorUtils.setAlphaComponent(r103, MathKt.roundToInt(0.7f * r104)), ColorUtils.setAlphaComponent(r103, MathKt.roundToInt(r104 * 0.4f))};
        this.f330432e = v19.c.a(R.attr.larus_neutral_transparent_1, getContext(), R.color.larus_neutral_transparent_1);
        this.f330433f = new long[0];
    }

    public /* synthetic */ ContextWindowSegmentedProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
