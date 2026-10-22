package com.larus.common_ui.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q19.b;
import q19.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/common_ui/refresh/RefreshHeaderLayout;", "Lcom/larus/common_ui/refresh/AbsRefreshHeaderLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "progressBar", "Landroid/widget/ProgressBar;", "fakeRefreshingAnimator", "Landroid/animation/ValueAnimator;", "fakeFinishAnimator", "init", "", "resetState", "dispatchTopAndBottomOffset", "refreshLayout", "Lcom/larus/common_ui/refresh/SuperSwipeRefreshLayout;", "offset", "dispatchRefreshing", "listener", "Landroid/animation/Animator$AnimatorListener;", "dispatchRefreshCancel", "setHeaderViewScale", "scale", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RefreshHeaderLayout extends AbsRefreshHeaderLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f327774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f327775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f327776c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void d() {
        setHeaderViewScale(0.0f);
    }

    public RefreshHeaderLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        e(r100);
    }

    private final void setHeaderViewScale(float r100) {
        if (r100 > 0.0f) goto L6;
        r100 = 0.0f;
    L8:
        ProgressBar r101 = this.f327774a;
        if (r101 == null) goto L11;
        r101.setScaleX(r100);
    L11:
        ProgressBar r102 = this.f327774a;
        if (r102 == null) goto L15;
        r102.setScaleY(r100);
        return;
    L15:
        return;
    L6:
        if (r100 < 1.0f) goto L8;
        r100 = 1.0f;
        goto L8
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void b(SuperSwipeRefreshLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        FLogger.f375446a.d("RefreshHeaderLayout", "dispatchRefreshing...");
        ProgressBar r101 = this.f327774a;
        if (r101 == null) goto L5;
        e1.x(r101);
    L5:
        ValueAnimator r102 = this.f327775b;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        ValueAnimator r103 = this.f327776c;
        if (r103 == null) goto L11;
        r103.cancel();
    L11:
        setHeaderViewScale(1.0f);
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r104.addListener(new b());
        r104.setInterpolator(new LinearInterpolator());
        r104.setDuration(200);
        r104.start();
        this.f327775b = r104;
    }

    public final void e(Context r100) {
        FrameLayout.inflate(r100, R.layout.larus_refresh_header_layout, this);
        this.f327774a = (ProgressBar) findViewById(R.id.progress_view);
    }

    public RefreshHeaderLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        e(r100);
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void a(SuperSwipeRefreshLayout r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        FLogger.f375446a.d("RefreshHeaderLayout", "dispatchRefreshCancel...");
        ProgressBar r102 = this.f327774a;
        if (r102 == null) goto L5;
        e1.o(r102);
    L5:
        ValueAnimator r103 = this.f327775b;
        if (r103 == null) goto L8;
        r103.cancel();
    L8:
        ValueAnimator r104 = this.f327776c;
        if (r104 == null) goto L11;
        r104.cancel();
    L11:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r105.addListener(new q19.a());
        r105.setInterpolator(new LinearInterpolator());
        r105.addListener(r101);
        r105.setDuration(200);
        r105.start();
        this.f327776c = r105;
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void c(SuperSwipeRefreshLayout r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        FLogger.f375446a.d("RefreshHeaderLayout", "dispatchTopAndBottomOffset...");
        ViewCompat.offsetTopAndBottom(this, r101);
        int r102 = getBottom();
        int r103 = getMeasuredHeight();
        ValueAnimator r104 = this.f327775b;
        boolean r105 = true;
        if (r104 != null) goto L5;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L33;
        ValueAnimator r107 = r100.f327799v;
        if (r107 != null) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L28;
        ValueAnimator r109 = r100.f327800w;
        if (r109 != null) goto L22;
    L24:
        boolean r110 = false;
    L25:
        if (r110 == true) goto L28;
        boolean r111 = false;
    L29:
        if (r111 == true) goto L33;
        setHeaderViewScale(1.0f);
        return;
    L22:
        if (r109.isRunning() == false) goto L24;
        r110 = true;
    L28:
        r111 = true;
        goto L29
    L15:
        if (r107.isRunning() == false) goto L17;
        r108 = true;
    L33:
        ValueAnimator r112 = r100.f327800w;
        if (r112 != null) goto L36;
    L38:
        r105 = false;
    L39:
        if (r105 == false) goto L46;
        float r113 = r103 * 0.5f;
        float r114 = (r102 - r113) / r113;
        if (r114 >= 0.0f) goto L44;
        r114 = 0.0f;
    L44:
        setHeaderViewScale(r114);
        return;
    L46:
        return;
    L36:
        if (r112.isRunning() == false) goto L38;
    L5:
        if (r104.isRunning() != true) goto L7;
        boolean r115 = true;
    L8:
        if (r115 == false) goto L10;
        r106 = true;
        goto L11
    L7:
        r115 = false;
        goto L8
    }

    public RefreshHeaderLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        e(r100);
    }
}
