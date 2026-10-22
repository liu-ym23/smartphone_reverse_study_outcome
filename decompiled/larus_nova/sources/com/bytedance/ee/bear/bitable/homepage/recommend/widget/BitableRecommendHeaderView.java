package com.bytedance.ee.bear.bitable.homepage.recommend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import cqa.e;
import cqa.h;
import dqa.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u00020\u00182\n\u0010&\u001a\u00020'\"\u00020\bH\u0016J \u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0016J \u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0016J \u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001aH\u0016J\b\u00106\u001a\u00020\u001aH\u0016J0\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0016J \u0010<\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/widget/BitableRecommendHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/scwang/smartrefresh/layout/api/RefreshHeader;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingDrawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "getLoadingDrawable", "()Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "loadingDrawable$delegate", "Lkotlin/Lazy;", "loadingContainer", "Landroid/view/View;", "ivLoading", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvLoading", "()Landroidx/appcompat/widget/AppCompatImageView;", DyPayConstant.KEY_SHOW_LOADING, "", "anim", "", "hideLoading", "onStateChanged", "refreshLayout", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "oldState", "Lcom/scwang/smartrefresh/layout/constant/RefreshState;", "newState", "getView", "getSpinnerStyle", "Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;", "setPrimaryColors", "colors", "", "onInitialized", "kernel", "Lcom/scwang/smartrefresh/layout/api/RefreshKernel;", "height", "extendHeight", "onHorizontalDrag", "percentX", "", "offsetX", "offsetMax", "onStartAnimator", "layout", "onFinish", "success", "isSupportHorizontalDrag", "onMoving", "isDragging", "percent", "offset", "maxDragHeight", "onReleased", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendHeaderView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f213072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f213073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f213074c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f213075a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RefreshState.RefreshReleased.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f213075a = r100;
        }
    }

    public BitableRecommendHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableRecommendHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r101, int r102, int r103, int r104) {
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "kernel");
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        return 0;
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
    }

    private final CircularProgressDrawable getLoadingDrawable() {
        return (CircularProgressDrawable) this.f213072a.getValue();
    }

    public final AppCompatImageView getIvLoading() {
        return this.f213074c;
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return b.f469717d;
    }

    public final void k(boolean r100) {
        this.f213073b.setVisibility(0);
        if (r100 == true) goto L5;
        getLoadingDrawable().setStartEndTrim(0.0f, 0.75f);
        return;
    L5:
        if (getLoadingDrawable().isRunning() == true) goto L9;
        getLoadingDrawable().start();
        return;
    }

    public BitableRecommendHeaderView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213072a = LazyKt.lazy(new BitableRecommendHeaderView$loadingDrawable$2(r100));
        LayoutInflater.from(r100).inflate(R.layout.bitable_recommend_header, this, true);
        View r103 = findViewById(R.id.loading_container);
        this.f213073b = r103;
        AppCompatImageView r104 = (AppCompatImageView) findViewById(R.id.iv_loading);
        this.f213074c = r104;
        r104.setImageDrawable(getLoadingDrawable());
        r103.setVisibility(4);
        if (getLoadingDrawable().isRunning() == false) goto L6;
        getLoadingDrawable().stop();
        return;
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "refreshLayout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        int r103 = a.f213075a[r102.ordinal()];
        if (r103 != 1) goto L5;
        this.f213073b.setVisibility(4);
        if (getLoadingDrawable().isRunning() == false) goto L17;
        getLoadingDrawable().stop();
        return;
    L17:
        return;
    L5:
        if (r103 != 2) goto L7;
        k(false);
        return;
    L7:
        if (r103 != 3) goto L18;
        k(true);
        return;
    }

    public /* synthetic */ BitableRecommendHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
