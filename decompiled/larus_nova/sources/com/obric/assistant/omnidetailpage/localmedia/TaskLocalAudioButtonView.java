package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J(\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J(\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioButtonView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "playPath", "Landroid/graphics/Path;", "progressBounds", "Landroid/graphics/RectF;", "playbackState", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalAudioPlaybackState;", ChameleonOpenTracker.Stage.RENDER, "", "state", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawIdleState", "centerX", "centerY", "radius", "drawPlayingState", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskLocalAudioButtonView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f390815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f390816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f390817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f390818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f390819e;

    public static final class a {
    }

    static {
    }

    public TaskLocalAudioButtonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskLocalAudioButtonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(q r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        float r101 = RangesKt.coerceIn(r100.f390842b, 0.0f, 1.0f);
        this.f390819e = new q(r100.f390841a, r101);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = Math.min(getWidth(), getHeight());
        float r111 = getWidth() / 2.0f;
        float r101 = getHeight() / 2.0f;
        float r112 = (r100 / 2.0f) - this.f390816b.getStrokeWidth();
        if (this.f390819e.f390841a == false) goto L5;
        this.f390815a.setColor(-1);
        r110.drawCircle(r111, r101, r112, this.f390815a);
        this.f390818d.set(r111 - r112, r101 - r112, r111 + r112, r101 + r112);
        this.f390816b.setColor(-2960686);
        r110.drawArc(this.f390818d, -90.0f, 360.0f, false, this.f390816b);
        this.f390816b.setColor(-16777216);
        r110.drawArc(this.f390818d, -90.0f, this.f390819e.f390842b * 360.0f, false, this.f390816b);
        this.f390815a.setColor(-16777216);
        float r113 = r112 * 0.17f;
        float r102 = 0.72f * r112;
        float r114 = r112 * 0.14f;
        float r103 = r111 - r114;
        float r104 = r102 / 2.0f;
        float r115 = r101 - r104;
        float r116 = r101 + r104;
        float r117 = r113 / 2.0f;
        r110.drawRoundRect(r103 - r113, r115, r103, r116, r117, r117, this.f390815a);
        float r105 = r111 + r114;
        r110.drawRoundRect(r105, r115, r105 + r113, r116, r117, r117, this.f390815a);
        return;
    L5:
        this.f390815a.setColor(-16777216);
        r110.drawCircle(r111, r101, r112, this.f390815a);
        float r106 = 0.42f * r112;
        float r107 = r111 - (0.2f * r112);
        this.f390817c.reset();
        this.f390817c.moveTo(r107, r101 - r106);
        this.f390817c.lineTo(r107, r106 + r101);
        this.f390817c.lineTo(r111 + (r112 * 0.48f), r101);
        this.f390817c.close();
        this.f390815a.setColor(-1);
        r110.drawPath(this.f390817c, this.f390815a);
    }

    public TaskLocalAudioButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        this.f390815a = r105;
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeCap(Paint.Cap.ROUND);
        r106.setStrokeWidth(r104 * 2.5f);
        this.f390816b = r106;
        this.f390817c = new Path();
        this.f390818d = new RectF();
        this.f390819e = new q(0);
    }

    public /* synthetic */ TaskLocalAudioButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
