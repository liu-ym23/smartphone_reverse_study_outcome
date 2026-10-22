package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.h;
import dqa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CircleRefreshHeader extends FrameLayout implements wa5.a {
    public BearLottieView a;
    public UDProgress b;
    public wa5.a c;
    public final int d;
    public float e;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[RefreshState.Refreshing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[RefreshState.RefreshReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[RefreshState.ReleaseToRefresh.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[RefreshState.Loading.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void f(h r1, int r2, int r3) {
    }

    public View getView() {
        return this;
    }

    @Override // wa5.a
    public void setCustomText(String r1) {
    }

    public void setPrimaryColors(int... r1) {
    }

    @Override // wa5.a
    public void setStartNumber(int r1) {
    }

    public b getSpinnerStyle() {
        return b.d;
    }

    public CircleRefreshHeader(Context r2) {
        super(r2);
        this.d = 500;
        k(r2, null);
    }

    @Override // wa5.a
    public void setAssociatedHeader(wa5.a r1) {
        this.c = r1;
    }

    public CircleRefreshHeader(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.d = 500;
        k(r2, r3);
    }

    public final int j(SmartRefreshLayout r3, boolean r4) {
        this.a.setVisibility(8);
        wa5.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.j(r3, r4);
    L6:
        return this.d;
    }

    public final void k(Context r2, AttributeSet r3) {
        LayoutInflater.from(r2).inflate(2131561086, this, true);
        this.a = (BearLottieView) findViewById(2131374460);
        this.b = findViewById(2131374461);
    }

    public CircleRefreshHeader(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = 500;
        k(r1, r2);
    }

    public final void e(h r6, RefreshState r7, RefreshState r8) {
        int r0 = a.a[r8.ordinal()];
        if (r0 != 1) goto L5;
        tt5.a.h("CircleRefreshHeader", "refresh finish, hide mCircleProgressBar mBearLottieView");
        this.b.setVisibility(8);
        this.a.setVisibility(8);
    L14:
        wa5.a r1 = this.c;
        if (r1 == null) goto L18;
        r1.e(r6, r7, r8);
        return;
    L18:
        return;
    L5:
        if (r0 != 2) goto L7;
        tt5.a.h("CircleRefreshHeader", "start pull down, set mCircleProgressBar visible");
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        goto L14
    L7:
        if (r0 != 3) goto L9;
    L11:
        tt5.a.h("CircleRefreshHeader", "refresh releaseed, start play lottie animation");
        this.b.setVisibility(8);
        this.a.setVisibility(0);
        goto L14
    L9:
        if (r0 == 4) goto L11;
        goto L11
    }

    public final void g(SmartRefreshLayout.j r2, int r3, int r4) {
        wa5.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.g(r2, r3, r4);
        return;
    }

    public final void i(h r3, int r4, int r5) {
        this.a.setVisibility(0);
        this.a.setAnimation(2131820565);
        this.a.setRepeatCount(-1);
        this.a.playAnimation();
        wa5.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.i(r3, r4, r5);
        return;
    }

    public final void b(boolean r9, float r10, int r11, int r12, int r13) {
        if (r9 == false) goto L10;
        float r0 = (r10 - 0.2f) * 100.0f;
        this.e = r0;
        if (r0 <= 100.0f) goto L6;
        this.e = 100.0f;
    L6:
        this.b.setProgress((int) this.e);
        wa5.a r2 = this.c;
        if (r2 == null) goto L11;
        r2.b(r9, r10, r11, r12, r13);
        return;
    L11:
        return;
    }
}
