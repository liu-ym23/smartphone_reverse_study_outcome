package com.bytedance.ee.bear.bitable.app.chameleon;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.app.titlebar.BitableAppTitleBar;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.larus.nova.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements yx4.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f206918i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<FrameLayout, com.bytedance.ee.bear.document.loading.d> f206919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LoadingLayoutScope f206920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f206921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f206922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableAppTitleBar f206923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.document.loading.d f206924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f206925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f206926h;

    public static final class a {
        public a() {
        }
    }

    static {
        f206918i = new a();
    }

    @Override // yx4.d
    public final void detachLoadingView() {
        FrameLayout r100 = this.f206921c;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        if (this.f206925g == false) goto L10;
        com.bytedance.ee.bear.document.loading.d r101 = this.f206924f;
        if (r101 == null) goto L10;
        r101.hide();
    L10:
        com.bytedance.ee.bear.document.loading.d r102 = this.f206924f;
        if (r102 == null) goto L13;
        r102.reset();
    L13:
        BitableAppTitleBar r103 = this.f206923e;
        if (r103 == null) goto L16;
        r103.setLoadingBg(false);
    L16:
        View r104 = this.f206922d;
        if (r104 == null) goto L21;
        FrameLayout r105 = this.f206921c;
        if (r105 == null) goto L21;
        r105.removeView(r104);
    L21:
        this.f206921c = null;
        this.f206922d = null;
        this.f206923e = null;
        this.f206924f = null;
        this.f206925g = false;
        this.f206926h = false;
    }

    @Override // yx4.d
    public final void hideLoading() {
        FrameLayout r100 = this.f206921c;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
    L6:
        if (this.f206925g == true) goto L8;
        return;
    L8:
        com.bytedance.ee.bear.document.loading.d r101 = this.f206924f;
        if (r101 == null) goto L11;
        r101.hide();
    L11:
        this.f206925g = false;
        this.f206926h = true;
    }

    @Override // yx4.d
    public final void showLoading() {
        if (this.f206925g == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.document.loading.d r100 = this.f206924f;
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.f206926h == false) goto L11;
        r100.reset();
        this.f206926h = false;
    L11:
        FrameLayout r101 = this.f206921c;
        if (r101 == null) goto L14;
        r101.setVisibility(0);
    L14:
        r100.b();
        this.f206925g = true;
    }

    @Override // yx4.d
    public final LoadingLayoutScope getScope() {
        return this.f206920b;
    }

    public h(int r100) {
        OfficeBaseAppLoadingLayout$1 r101 = new OfficeBaseAppLoadingLayout$1(f206918i);
        Intrinsics.checkNotNullParameter(r101, "wrapperFactory");
        this.f206919a = r101;
        this.f206920b = LoadingLayoutScope.FULL_CONTAINER;
    }

    @Override // yx4.d
    public final void attachLoadingView(FrameLayout r110) {
        Intrinsics.checkNotNullParameter(r110, "frameLayout");
        detachLoadingView();
        this.f206921c = r110;
        r110.removeAllViews();
        r110.setVisibility(8);
        LinearLayout r100 = new LinearLayout(r110.getContext());
        r100.setOrientation(1);
        r100.setBackgroundColor(r100.getContext().getColor(R.color.bg_body));
        BitableAppTitleBar r101 = new BitableAppTitleBar(r110.getContext(), null, 0, false, 14);
        r101.setLoadingBg(true);
        FrameLayout r102 = new FrameLayout(r110.getContext());
        r100.addView(r101, new LinearLayout.LayoutParams(-1, -2));
        r100.addView(r102, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r110.addView(r100, new FrameLayout.LayoutParams(-1, -1));
        this.f206922d = r100;
        this.f206923e = r101;
        this.f206924f = this.f206919a.invoke(r102);
        this.f206925g = false;
        this.f206926h = false;
    }
}
