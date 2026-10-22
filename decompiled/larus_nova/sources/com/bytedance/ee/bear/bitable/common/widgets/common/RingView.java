package com.bytedance.ee.bear.bitable.common.widgets.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0014J\u001a\u0010#\u001a\u00020\u001a2\b\b\u0001\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0012\u001a\u00020\nJ\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\nH\u0007R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/common/RingView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "outerPercent", "", "innerPercent", "outerColor", "innerColor", "flat", "", "flatDotSizePx", "outerPaint", "Landroid/graphics/Paint;", "innerPaint", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setColor", "setFlat", "dotSizePx", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f209891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f209892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f209893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f209894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f209895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f209896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f209897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f209898h;

    public static final class a {
    }

    static {
    }

    public RingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f209891a = 1.0f;
        this.f209892b = 0.75f;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        r101.setStyle(Paint.Style.FILL);
        this.f209897g = r101;
        Paint r102 = new Paint();
        r102.setAntiAlias(true);
        r102.setStyle(Paint.Style.FILL);
        this.f209898h = r102;
        this.f209893c = -65536;
        this.f209894d = -1;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = 2;
        float r102 = RangesKt.coerceAtMost(getWidth(), getHeight()) / r101;
        float r103 = getWidth() / r101;
        float r104 = getHeight() / r101;
        if (this.f209895e == false) goto L10;
        this.f209898h.setColor(this.f209894d);
        int r105 = this.f209896f;
        if (r105 <= 0) goto L7;
        float r106 = r105 / 2.0f;
    L8:
        r100.drawCircle(r103, r104, r106, this.f209898h);
        return;
    L7:
        r106 = r102 * this.f209891a;
        goto L8
    L10:
        float r107 = this.f209891a * r102;
        this.f209897g.setColor(this.f209893c);
        r100.drawCircle(r103, r104, r107, this.f209897g);
        float r108 = r102 * this.f209892b;
        this.f209898h.setColor(this.f209894d);
        r100.drawCircle(r103, r104, r108, this.f209898h);
    }

    public final void setFlat(boolean r100) {
        if (this.f209895e == r100) goto L5;
    L6:
        this.f209895e = r100;
        this.f209896f = 0;
        invalidate();
        return;
    L5:
        if (this.f209896f != 0) goto L6;
    }

    public RingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final void a(int r100, int r101) {
        this.f209893c = r100;
        this.f209894d = r101;
        invalidate();
    }

    public RingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f209891a = 1.0f;
        this.f209892b = 0.75f;
        Paint r103 = new Paint();
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        this.f209897g = r103;
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setStyle(Paint.Style.FILL);
        this.f209898h = r104;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.innerColor, R.attr.outerColor});
        this.f209893c = r105.getColor(1, -65536);
        this.f209894d = r105.getColor(0, -1);
        r105.recycle();
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
