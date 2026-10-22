package com.larus.common_ui.video.progress;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020'J\u0006\u0010+\u001a\u00020'R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/common_ui/video/progress/HorizontalProgressLayer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingBar1", "Landroid/view/View;", "getLoadingBar1", "()Landroid/view/View;", "loadingBar1$delegate", "Lkotlin/Lazy;", "loadingBar2", "getLoadingBar2", "loadingBar2$delegate", "loadingBar3", "getLoadingBar3", "loadingBar3$delegate", "loadingBars", "", "getLoadingBars", "()[Landroid/view/View;", "loadingBars$delegate", "animators", "Landroid/animation/ObjectAnimator;", "getAnimators", "()[Landroid/animation/ObjectAnimator;", "animators$delegate", "animationJob", "Lkotlinx/coroutines/Job;", "isAnimating", "", "buildFadeInOutAnimator", "view", "stopAllAnimators", "", "setLoadingLength", "length", "startLoadingAnimation", "stopLoadingAnimation", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalProgressLayer extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f328063g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f328064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f328065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f328066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f328067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f328068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f328069f;

    public static final class a {
    }

    static {
    }

    public HorizontalProgressLayer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalProgressLayer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ObjectAnimator[] getAnimators() {
        return (ObjectAnimator[]) this.f328068e.getValue();
    }

    private final View getLoadingBar1() {
        return (View) this.f328064a.getValue();
    }

    private final View getLoadingBar2() {
        return (View) this.f328065b.getValue();
    }

    private final View getLoadingBar3() {
        return (View) this.f328066c.getValue();
    }

    private final View[] getLoadingBars() {
        return (View[]) this.f328067d.getValue();
    }

    public final void e() {
        e1.q(this);
        ObjectAnimator[] r100 = getAnimators();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100[r102].cancel();
        r102 = r102 + 1;
        goto L3
    L5:
        Job r103 = this.f328069f;
        if (r103 == null) goto L8;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L8:
        this.f328069f = null;
    }

    public static ObjectAnimator[] a(HorizontalProgressLayer r100) {
        return new ObjectAnimator[]{d(r100.getLoadingBar1()), d(r100.getLoadingBar2()), d(r100.getLoadingBar3())};
    }

    public static View[] b(HorizontalProgressLayer r100) {
        return new View[]{r100.getLoadingBar1(), r100.getLoadingBar2(), r100.getLoadingBar3()};
    }

    public static final /* synthetic */ ObjectAnimator[] c(HorizontalProgressLayer r100) {
        return r100.getAnimators();
    }

    public static ObjectAnimator d(View r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f, 0.0f});
        r101.setDuration(1400);
        return r101;
    }

    public final void setLoadingLength(int r100) {
        View[] r101 = getLoadingBars();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        View r104 = r101[r103];
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.width = r100;
        r104.setLayoutParams(r105);
        r103 = r103 + 1;
        goto L3
    L5:
        invalidate();
    }

    public HorizontalProgressLayer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328064a = LazyKt.lazy(new com.larus.common_ui.video.progress.a(this));
        this.f328065b = LazyKt.lazy(new b(this));
        this.f328066c = LazyKt.lazy(new c(this));
        this.f328067d = LazyKt.lazy(new d(this));
        this.f328068e = LazyKt.lazy(new e(this));
    }

    public /* synthetic */ HorizontalProgressLayer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
