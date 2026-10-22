package com.larus.profile.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ#\u0010\u0018\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0000¢\u0006\u0002\b\u001aJ\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0014J0\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0014J!\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010*R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/profile/impl/view/ProfileEditPerfRootLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onFirstDispatchDrawEnd", "Lkotlin/Function1;", "Lcom/larus/profile/impl/view/ProfileEditFirstFrameTiming;", "", "firstMeasureStartNs", "", "Ljava/lang/Long;", "lastMeasureEndNs", "firstLayoutStartNs", "lastLayoutEndNs", "hasFinishedFirstFrame", "", "setOnFirstDispatchDrawEndListener", "listener", "setOnFirstDispatchDrawEndListener$impl_mainlandRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "durationNs", "startNs", "endNs", "(Ljava/lang/Long;Ljava/lang/Long;)J", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileEditPerfRootLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super i, Unit> f366883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f366884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f366885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f366886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f366887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f366888f;

    public ProfileEditPerfRootLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        if (this.f366888f == false) goto L5;
        return;
    L5:
        this.f366888f = true;
        Function1<? super i, Unit> r101 = this.f366883a;
        if (r101 != null) goto L8;
        return;
    L8:
        this.f366883a = null;
        r101.invoke(new i(System.currentTimeMillis(), R5(this.f366884b, this.f366885c), R5(this.f366886d, this.f366887e)));
    }

    public final void setOnFirstDispatchDrawEndListener$impl_mainlandRelease(Function1<? super i, Unit> r100) {
        this.f366883a = r100;
    }

    public ProfileEditPerfRootLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public static long R5(Long r100, Long r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        if (r101.longValue() < r100.longValue()) goto L7;
        return r101.longValue() - r100.longValue();
    L7:
        return 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f366888f == false) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        long r102 = SystemClock.elapsedRealtimeNanos();
        if (this.f366884b != null) goto L9;
        this.f366884b = Long.valueOf(r102);
    L9:
        super.onMeasure(r100, r101);
        this.f366885c = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    }

    public ProfileEditPerfRootLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f366888f == false) goto L6;
        super.onLayout(r100, r101, r102, r103, r104);
        return;
    L6:
        long r105 = SystemClock.elapsedRealtimeNanos();
        if (this.f366886d != null) goto L9;
        this.f366886d = Long.valueOf(r105);
    L9:
        super.onLayout(r100, r101, r102, r103, r104);
        this.f366887e = Long.valueOf(SystemClock.elapsedRealtimeNanos());
    }
}
