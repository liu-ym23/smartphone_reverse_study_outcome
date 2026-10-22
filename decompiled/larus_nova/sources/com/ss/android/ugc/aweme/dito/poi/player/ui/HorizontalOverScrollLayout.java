package com.ss.android.ugc.aweme.dito.poi.player.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0017J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/dito/poi/player/ui/HorizontalOverScrollLayout;", "Landroid/widget/RelativeLayout;", "Landroidx/core/view/NestedScrollingParent2;", "", "distance", "", "setMaxOverScrollDistance", "Lcom/ss/android/ugc/aweme/dito/poi/player/ui/OverScrollListener;", "h", "Lcom/ss/android/ugc/aweme/dito/poi/player/ui/OverScrollListener;", "getListener", "()Lcom/ss/android/ugc/aweme/dito/poi/player/ui/OverScrollListener;", "setListener", "(Lcom/ss/android/ugc/aweme/dito/poi/player/ui/OverScrollListener;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OverScrollerInterpolator", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3})
public final class HorizontalOverScrollLayout extends RelativeLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f450788i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f450789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingParentHelper f450790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OverScrollerInterpolator f450791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f450792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f450793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f450794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f450795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OverScrollListener f450796h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/dito/poi/player/ui/HorizontalOverScrollLayout$Companion;", "", "()V", "BOUNCE_BACK_DECELERATION", "", "SPRING_BACK_DURATION", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/dito/poi/player/ui/HorizontalOverScrollLayout$OverScrollerInterpolator;", "Landroid/view/animation/Interpolator;", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3})
    public final class OverScrollerInterpolator implements Interpolator {
        public OverScrollerInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return 1 - ((float) Math.pow(0.8f, r100 * 2));
        }
    }

    static {
        new Companion(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f450789a = null;
    }

    public final OverScrollListener getListener() {
        return this.f450796h;
    }

    public HorizontalOverScrollLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f450790b = new NestedScrollingParentHelper(this);
        this.f450791c = new OverScrollerInterpolator();
        this.f450793e = 500;
    }

    public final void b(int r100) {
        WeakReference<View> r101 = this.f450789a;
        if (r101 == null) goto L15;
        View r102 = r101.get();
        if (r102 == null) goto L17;
        int r103 = r102.getLeft();
        this.f450794f = r100;
        float r104 = this.f450791c.getInterpolation(Math.abs(r100 / this.f450793e));
        if (this.f450794f <= 0) goto L10;
        int r105 = -((int) (this.f450793e * r104));
    L11:
        ViewCompat.offsetLeftAndRight(r102, r105 - r103);
        OverScrollListener r106 = this.f450796h;
        if (r106 == null) goto L16;
        r106.b(r102.getLeft());
        return;
    L16:
        return;
    L10:
        r105 = (int) (this.f450793e * r104);
        goto L11
    L17:
        return;
    }

    public final void setListener(OverScrollListener r100) {
        this.f450796h = r100;
    }

    public final void setMaxOverScrollDistance(int r100) {
        this.f450793e = r100;
    }

    public HorizontalOverScrollLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f450790b = new NestedScrollingParentHelper(this);
        this.f450791c = new OverScrollerInterpolator();
        this.f450793e = 500;
    }

    public final void a(View r100, int r101) {
        float r102 = (r101 - r100.getLeft()) / this.f450793e;
        OverScrollerInterpolator r103 = this.f450791c;
        float r104 = Math.abs(r102);
        r103.getClass();
        int r105 = (int) (((((float) Math.log(1 - r104)) / ((float) Math.log(0.8f))) / 2) * this.f450793e);
        this.f450794f = r105;
        if (r102 >= 0) goto L5;
        r105 = -r105;
    L5:
        this.f450794f = r105;
        ViewCompat.offsetLeftAndRight(r100, -r101);
        OverScrollListener r106 = this.f450796h;
        if (r106 == null) goto L9;
        r106.b(r100.getLeft());
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f450790b.onStopNestedScroll(r100);
        if (this.f450794f == 0) goto L33;
        ValueAnimator r102 = this.f450795g;
        if (r102 == null) goto L7;
        r102.cancel();
    L7:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{this.f450794f, 0});
        this.f450795g = r103;
        if (r103 == null) goto L11;
        r103.setInterpolator(new DecelerateInterpolator());
    L11:
        ValueAnimator r104 = this.f450795g;
        if (r104 == null) goto L15;
        r104.setDuration(200);
    L15:
        ValueAnimator r105 = this.f450795g;
        if (r105 == null) goto L18;
        r105.addUpdateListener(new HorizontalOverScrollLayout$startScrollBackAnimator$1(this));
    L18:
        ValueAnimator r106 = this.f450795g;
        if (r106 == null) goto L21;
        r106.start();
    L21:
        WeakReference<View> r107 = this.f450789a;
        if (r107 == null) goto L34;
        View r108 = r107.get();
        if (r108 == null) goto L35;
        int r109 = r108.getLeft();
        if (r109 < 0) goto L28;
        return;
    L28:
        if (Math.abs(r109) <= (this.f450793e * 0.5f)) goto L37;
        OverScrollListener r110 = this.f450796h;
        if (r110 == null) goto L38;
        r110.a();
        return;
    L38:
        return;
    L37:
        return;
    L35:
        return;
    L34:
        return;
    }

    public HorizontalOverScrollLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f450790b = new NestedScrollingParentHelper(this);
        this.f450791c = new OverScrollerInterpolator();
        this.f450793e = 500;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f450790b.onNestedScrollAccepted(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f450789a = new WeakReference(r100);
        this.f450792d = r102;
        ValueAnimator r104 = this.f450795g;
        if (r104 == null) goto L6;
        r104.cancel();
    L6:
        return isEnabled();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        WeakReference<View> r105 = this.f450789a;
        if (r105 == null) goto L21;
        View r106 = r105.get();
        if (r106 == null) goto L27;
        int r107 = r106.getLeft();
        if (r107 <= 0) goto L14;
        if (r101 <= 0) goto L14;
        if ((r107 - r101) < 0) goto L13;
        r103[0] = r101;
        a(r106, r101);
        return;
    L13:
        r103[0] = r107;
        a(r106, r107);
        return;
    L14:
        if (r107 >= 0) goto L24;
        if (r101 < 0) goto L17;
        return;
    L17:
        if ((r107 - r101) > 0) goto L19;
        r103[0] = r101;
        a(r106, r101);
        return;
    L19:
        r103[0] = r107;
        a(r106, r107);
        return;
    L24:
        return;
    L27:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f450792d != 1) goto L8;
        if (r103 == 0) goto L9;
        if (r105 != 0) goto L10;
        b(this.f450794f + r103);
        return;
    L10:
        return;
    L9:
        return;
    }
}
