package com.bytedance.ee.bear.bitable.core.nested;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0016J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/nested/ElasticAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "disableNestedScroll", "", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "setTempDisableScroll", "", "tempDisableScroll", "Behavior", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ElasticAppBarLayout extends AppBarLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f210574a;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J@\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J(\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/nested/ElasticAppBarLayout$Behavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "<init>", "(Lcom/bytedance/ee/bear/bitable/core/nested/ElasticAppBarLayout;)V", "elasticScale", "", "animatorDuration", "", "animator", "Landroid/animation/ValueAnimator;", "onNestedScroll", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/google/android/material/appbar/AppBarLayout;", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "dxConsumed", "", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "consumed", "", "onNestedPreScroll", "dx", "dy", "isElasticScrollDown", "", "isElasticScrollUp", "onStopNestedScroll", "abl", "recoveryOffset", "ensureStopAnimator", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Behavior extends AppBarLayout.Behavior {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f210575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f210576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ValueAnimator f210577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ElasticAppBarLayout f210578d;

        public Behavior(ElasticAppBarLayout r100) {
            this.f210578d = r100;
            this.f210575a = 0.4f;
            this.f210576b = 200;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r101, "abl");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (r101.getTop() <= 0) goto L10;
            ValueAnimator r104 = this.f210577c;
            if (r104 != null) goto L7;
        L9:
            ValueAnimator r105 = ValueAnimator.ofInt(new int[]{0, r101.getTop()});
            r105.setDuration(this.f210576b);
            r105.addUpdateListener(new a(r101));
            r105.start();
            this.f210577c = r105;
            goto L10
        L7:
            if (r104.isRunning() == false) goto L9;
            r104.cancel();
        L10:
            super.onStopNestedScroll(r100, r101, r102, r103);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
            onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public final void onNestedPreScroll(CoordinatorLayout r110, AppBarLayout r111, View r112, int r113, int r114, int[] r115, int r116) {
            Intrinsics.checkNotNullParameter(r110, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r115, "consumed");
            if (this.f210578d.f210574a == false) goto L6;
            return;
        L6:
            if (r114 > 0) goto L8;
        L10:
            boolean r100 = false;
        L11:
            if (r100 == false) goto L16;
            int r101 = r111.getBottom() - r111.getMeasuredHeight();
            int r102 = (int) (r114 * this.f210575a);
            if (r101 >= r102) goto L15;
            ViewCompat.offsetTopAndBottom(r111, -r101);
            int r117 = r101 * 2;
            super.onNestedPreScroll(r110, r111, r112, r113, r114 - r117, r115, r116);
            r115[1] = r115[1] + Math.abs(r117);
            return;
        L15:
            ViewCompat.offsetTopAndBottom(r111, -r102);
            r115[1] = Math.abs(r114);
            return;
        L16:
            super.onNestedPreScroll(r110, r111, r112, r113, r114, r115, r116);
            return;
        L8:
            if (r111.getBottom() <= r111.getMeasuredHeight()) goto L10;
            r100 = true;
            goto L11
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int[] r105, int r106) {
            onNestedPreScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r110, View r111, View r112, int r113, int r114, int r115, int r210, int r211, int[] r212) {
            AppBarLayout r116 = (AppBarLayout) r111;
            Intrinsics.checkNotNullParameter(r110, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r116, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r212, "consumed");
            if (this.f210578d.f210574a == true) goto L15;
            super.onNestedScroll(r110, r116, r112, r113, r114, r115, r210, r211, r212);
            int r100 = r210 + r212[1];
            if (r100 < 0) goto L8;
        L10:
            boolean r101 = false;
        L11:
            if (r101 == false) goto L14;
            int r102 = (int) (r100 * this.f210575a);
            ViewCompat.offsetTopAndBottom(r116, -r102);
            r212[1] = r212[1] + Math.abs(r102);
            return;
        L14:
            return;
        L8:
            if (r116.getBottom() < r116.getMeasuredHeight()) goto L10;
            r101 = true;
            goto L11
        }
    }

    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior(this);
    }

    public ElasticAppBarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setTempDisableScroll(boolean r100) {
        this.f210574a = r100;
    }

    public ElasticAppBarLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
