package com.larus.bmhome.chat.standarduikit.fileblock.view;

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
import vl8.g;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010 \u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J0\u0010\"\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H\u0002J(\u0010$\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J(\u0010%\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileAudioButtonView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "playPath", "Landroid/graphics/Path;", "progressBounds", "Landroid/graphics/RectF;", "playbackState", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFilePlaybackState;", "loadingRotation", ChameleonOpenTracker.Stage.RENDER, "", "state", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawLoadingState", "centerX", "centerY", "radius", "drawIdleState", "drawPausedState", "drawPlayIcon", "color", "drawPlayingState", "drawProgressRing", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileAudioButtonView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f309068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f309069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f309070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f309071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f309072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f309073f;

    public static final class a {
    }

    static {
    }

    public FileAudioButtonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FileAudioButtonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void c(g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        float r101 = RangesKt.coerceIn(r100.f555704d, 0.0f, 1.0f);
        boolean r102 = r100.f555701a;
        boolean r103 = r100.f555702b;
        this.f309072e = new g(r102, r103, r100.f555703c, r101);
        if (r103 == true) goto L5;
        this.f309073f = 0.0f;
    L5:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = Math.min(getWidth(), getHeight());
        float r101 = getWidth() / 2.0f;
        float r102 = getHeight() / 2.0f;
        float r103 = (r100 / 2.0f) - this.f309069b.getStrokeWidth();
        g r104 = this.f309072e;
        if (r104.f555702b == false) goto L6;
        this.f309068a.setColor(-1);
        r110.drawCircle(r101, r102, r103, this.f309068a);
        this.f309071d.set(r101 - r103, r102 - r103, r101 + r103, r102 + r103);
        this.f309069b.setColor(-2960686);
        r110.drawArc(this.f309071d, -90.0f, 360.0f, false, this.f309069b);
        this.f309069b.setColor(-16777216);
        r110.drawArc(this.f309071d, this.f309073f - 90.0f, 100.0f, false, this.f309069b);
        this.f309073f = (this.f309073f + 12.0f) % 360.0f;
        postInvalidateDelayed(16);
        return;
    L6:
        if (r104.f555701a == false) goto L9;
        this.f309068a.setColor(-1);
        r110.drawCircle(r101, r102, r103, this.f309068a);
        b(r110, r101, r102, r103);
        this.f309068a.setColor(-16777216);
        float r105 = 0.17f * r103;
        float r106 = 0.72f * r103;
        float r107 = r103 * 0.14f;
        float r111 = r101 - r107;
        float r108 = r106 / 2.0f;
        float r112 = r102 - r108;
        float r109 = r108 + r102;
        float r113 = r105 / 2.0f;
        r110.drawRoundRect(r111 - r105, r112, r111, r109, r113, r113, this.f309068a);
        float r114 = r101 + r107;
        r110.drawRoundRect(r114, r112, r114 + r105, r109, r113, r113, this.f309068a);
        return;
    L9:
        if (r104.f555703c == false) goto L11;
        this.f309068a.setColor(-1);
        r110.drawCircle(r101, r102, r103, this.f309068a);
        b(r110, r101, r102, r103);
        a(r110, r101, r102, r103, -16777216);
        return;
    L11:
        this.f309068a.setColor(-16777216);
        r110.drawCircle(r101, r102, r103, this.f309068a);
        a(r110, r101, r102, r103, -1);
    }

    public FileAudioButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        Paint r105 = new Paint(1);
        r105.setStyle(Paint.Style.FILL);
        this.f309068a = r105;
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeCap(Paint.Cap.ROUND);
        r106.setStrokeWidth(r104 * 2.5f);
        this.f309069b = r106;
        this.f309070c = new Path();
        this.f309071d = new RectF();
        this.f309072e = new g(false, false, false, 0.0f, 15);
    }

    public /* synthetic */ FileAudioButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(Canvas r100, float r101, float r102, float r110) {
        this.f309071d.set(r101 - r110, r102 - r110, r101 + r110, r102 + r110);
        this.f309069b.setColor(-2960686);
        r100.drawArc(this.f309071d, -90.0f, 360.0f, false, this.f309069b);
        this.f309069b.setColor(-16777216);
        r100.drawArc(this.f309071d, -90.0f, this.f309072e.f555704d * 360.0f, false, this.f309069b);
    }

    public final void a(Canvas r100, float r101, float r102, float r103, int r104) {
        float r105 = 0.42f * r103;
        float r106 = r101 - (0.2f * r103);
        this.f309070c.reset();
        this.f309070c.moveTo(r106, r102 - r105);
        this.f309070c.lineTo(r106, r105 + r102);
        this.f309070c.lineTo(r101 + (r103 * 0.48f), r102);
        this.f309070c.close();
        this.f309068a.setColor(r104);
        r100.drawPath(this.f309070c, this.f309068a);
    }
}
