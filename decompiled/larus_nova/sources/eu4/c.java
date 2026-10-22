package eu4;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableLoadingContainer;
import com.bytedance.ee.bear.bitable.loading.ELoadingType;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.larus.nova.R;
import com.ss.android.lark.utils.Contexts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c implements yx4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ELoadingType f474065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final du4.d f474066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LoadingLayoutScope f474067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f474068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableLoadingContainer f474069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f474070f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLoadingContainer f474071a;

        public a(BitableLoadingContainer r100) {
            this.f474071a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Activity r101 = Contexts.findActivity(this.f474071a.getContext());
            if (r101 == null) goto L6;
            r101.onBackPressed();
            return;
        }
    }

    @Override // yx4.d
    public final void hideLoading() {
        FrameLayout r100 = this.f474068d;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        BitableLoadingContainer r101 = this.f474069e;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        if (this.f474070f == false) goto L15;
        BitableLoadingContainer r102 = this.f474069e;
        if (r102 == null) goto L13;
        du4.a.a(r102);
    L13:
        this.f474070f = false;
        return;
    }

    @Override // yx4.d
    public final void showLoading() {
        BitableLoadingContainer r100 = this.f474069e;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f474070f == true) goto L8;
        r100.TQ(this.f474066b.a(r100.getContext()));
        this.f474070f = true;
    L8:
        FrameLayout r101 = this.f474068d;
        if (r101 == null) goto L11;
        r101.setVisibility(0);
    L11:
        r100.setVisibility(0);
    }

    @Override // yx4.d
    public final void detachLoadingView() {
        hideLoading();
        BitableLoadingContainer r100 = this.f474069e;
        if (r100 == null) goto L5;
        r100.setBackClickListener(null);
    L5:
        BitableLoadingContainer r101 = this.f474069e;
        if (r101 == null) goto L10;
        FrameLayout r102 = this.f474068d;
        if (r102 == null) goto L10;
        r102.removeView(r101);
    L10:
        this.f474069e = null;
        this.f474068d = null;
    }

    @Override // yx4.d
    public final LoadingLayoutScope getScope() {
        return this.f474067c;
    }

    @Override // yx4.d
    public final void attachLoadingView(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        detachLoadingView();
        BitableLoadingContainer r101 = new BitableLoadingContainer(r100.getContext(), null, 6, 0);
        r101.setLoadingType(this.f474065a);
        r101.setBackgroundColor(r101.getContext().getColor(R.color.bg_body));
        r101.setHeaderDecorationVisible(false);
        r101.setShimmerColor(r101.getContext().getColor(R.color.bg_body));
        r101.setBackClickListener(new a(r101));
        r101.setVisibility(8);
        r100.removeAllViews();
        r100.addView(r101, new FrameLayout.LayoutParams(-1, -1));
        this.f474068d = r100;
        this.f474069e = r101;
    }

    public c(ELoadingType r100, du4.d r101) {
        Intrinsics.checkNotNullParameter(r100, "loadingType");
        Intrinsics.checkNotNullParameter(r101, "loadingFactory");
        this.f474065a = r100;
        this.f474066b = r101;
        this.f474067c = LoadingLayoutScope.FULL_CONTAINER;
    }
}
