package com.larus.common_ui.widget.roundlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u000e\u0010\u0014\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0017H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/common_ui/widget/roundlayout/CircleFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "rectF", "Landroid/graphics/RectF;", "path", "Landroid/graphics/Path;", "cornerRadius", "", "enableCircle", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "enable", "resetPath", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f328717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f328718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f328719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f328720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328721e;

    public final void b() {
        if (this.f328718b != null) goto L6;
        return;
    L6:
        if (this.f328721e == false) goto L8;
        float r100 = this.f328720d;
    L9:
        this.f328719c.reset();
        Path r101 = this.f328719c;
        RectF r102 = this.f328718b;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rectF");
        r102 = null;
    L12:
        r101.addRoundRect(r102, r100, r100, Path.Direction.CW);
        this.f328719c.close();
        return;
    L8:
        r100 = 0.0f;
        goto L9
    }

    public CircleFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(boolean r100) {
        this.f328721e = r100;
        b();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = r100.save();     // Catch: Throwable -> L5
        r100.clipPath(this.f328719c);     // Catch: Throwable -> L5
        super.dispatchDraw(r100);     // Catch: Throwable -> L5
        r100.restoreToCount(r102);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.i(this.f328717a, r104.toString());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        int r102 = r100.save();     // Catch: Throwable -> L5
        r100.clipPath(this.f328719c);     // Catch: Throwable -> L5
        super.draw(r100);     // Catch: Throwable -> L5
        r100.restoreToCount(r102);     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.i(this.f328717a, r104.toString());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public CircleFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public CircleFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328717a = "CircleFrameLayout";
        this.f328719c = new Path();
        this.f328721e = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = r100;
        this.f328718b = new RectF(0.0f, 0.0f, r104, r101);
        this.f328720d = r104 / 2;
        b();
    }
}
