package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import dqa.b;

/* JADX INFO: loaded from: classes16.dex */
public class CircleRefreshHeader extends FrameLayout implements wa5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BearLottieView f226650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDProgress f226651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wa5.a f226652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f226653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f226654e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226655a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f226655a = r100;
            r100[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f226655a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f226655a[RefreshState.Refreshing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f226655a[RefreshState.RefreshReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f226655a[RefreshState.ReleaseToRefresh.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f226655a[RefreshState.Loading.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @Override // cqa.f
    public final boolean a() {
        return false;
    }

    @Override // cqa.f
    public final void d(float r100, int r101, int r102) {
    }

    @Override // cqa.f
    public final void f(h r100, int r101, int r102) {
    }

    @Override // cqa.f
    public View getView() {
        return this;
    }

    @Override // wa5.a
    public void setCustomText(String r100) {
    }

    @Override // cqa.f
    public void setPrimaryColors(int... r100) {
    }

    @Override // wa5.a
    public void setStartNumber(int r100) {
    }

    @Override // cqa.f
    public b getSpinnerStyle() {
        return b.f469717d;
    }

    public CircleRefreshHeader(Context r100) {
        super(r100);
        this.f226653d = 500;
        k(r100, null);
    }

    @Override // wa5.a
    public void setAssociatedHeader(wa5.a r100) {
        this.f226652c = r100;
    }

    public CircleRefreshHeader(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f226653d = 500;
        k(r100, r101);
    }

    @Override // cqa.f
    public final int j(SmartRefreshLayout r100, boolean r101) {
        this.f226650a.setVisibility(8);
        wa5.a r102 = this.f226652c;
        if (r102 == null) goto L6;
        r102.j(r100, r101);
    L6:
        return this.f226653d;
    }

    public final void k(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.facade_circle_refresh_header, this, true);
        this.f226650a = (BearLottieView) findViewById(R.id.home_page_lottie_view);
        this.f226651b = (UDProgress) findViewById(R.id.home_page_refresh_progress_bar);
    }

    public CircleRefreshHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226653d = 500;
        k(r100, r101);
    }

    @Override // gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        int r103 = a.f226655a[r102.ordinal()];
        if (r103 != 1) goto L5;
        tt5.a.h("CircleRefreshHeader", "refresh finish, hide mCircleProgressBar mBearLottieView");
        this.f226651b.setVisibility(8);
        this.f226650a.setVisibility(8);
    L14:
        wa5.a r104 = this.f226652c;
        if (r104 == null) goto L18;
        r104.e(r100, r101, r102);
        return;
    L18:
        return;
    L5:
        if (r103 != 2) goto L7;
        tt5.a.h("CircleRefreshHeader", "start pull down, set mCircleProgressBar visible");
        this.f226650a.setVisibility(8);
        this.f226651b.setVisibility(0);
        goto L14
    L7:
        if (r103 != 3) goto L9;
    L11:
        tt5.a.h("CircleRefreshHeader", "refresh releaseed, start play lottie animation");
        this.f226651b.setVisibility(8);
        this.f226650a.setVisibility(0);
        goto L14
    L9:
        if (r103 == 4) goto L11;
        goto L11
    }

    @Override // cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        wa5.a r103 = this.f226652c;
        if (r103 == null) goto L6;
        r103.g(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void i(h r100, int r101, int r102) {
        this.f226650a.setVisibility(0);
        this.f226650a.setAnimation(R.raw.facade_circle_refresh);
        this.f226650a.setRepeatCount(-1);
        this.f226650a.playAnimation();
        wa5.a r103 = this.f226652c;
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }

    @Override // cqa.f
    public final void b(boolean r100, float r110, int r111, int r112, int r113) {
        if (r100 == false) goto L10;
        float r101 = (r110 - 0.2f) * 100.0f;
        this.f226654e = r101;
        if (r101 <= 100.0f) goto L6;
        this.f226654e = 100.0f;
    L6:
        this.f226651b.setProgress((int) this.f226654e);
        wa5.a r102 = this.f226652c;
        if (r102 == null) goto L11;
        r102.b(r100, r110, r111, r112, r113);
        return;
    L11:
        return;
    }
}
