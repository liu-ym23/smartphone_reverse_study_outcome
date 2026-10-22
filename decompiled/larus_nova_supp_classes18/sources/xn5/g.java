package xn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.banner.adapter.BannerAdapter;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;
import com.bytedance.ee.bear.bizwidget.banner.indicator.RectangleIndicator;
import com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserverAdapter;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements b {
    public final FragmentActivity a;
    public final View b;
    public final LifecycleOwner c;
    public Banner<Void, TemplateBannerAdapter> d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
    }

    public final void create() {
        Banner<Void, TemplateBannerAdapter> r0 = this.b.findViewById(2131363912);
        LifecycleOwner r1 = this.c;
        r0.getClass();
        if (r1 == null) goto L5;
        r1.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(r1, r0));
    L5:
        RectangleIndicator r2 = new RectangleIndicator(this.a);
        qv4.a r3 = r0.d;
        if (r3 == null) goto L8;
        r0.removeView(r3.getIndicatorView());
    L8:
        r2.getIndicatorConfig().l = true;
        r0.d = r2;
        r0.a();
        r0.i = 5000;
        this.d = r0;
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    @Override // xn5.b
    public final void e8(ArrayList<BannerData> r5) {
        Intrinsics.checkNotNullParameter(r5, "banners");
        f8(true);
        Banner<Void, TemplateBannerAdapter> r1 = this.d;
        if (r1 == null) goto L9;
        RecyclerView.Adapter r2 = new TemplateBannerAdapter(r5);
        r1.c = r2;
        if (r1.g == true) goto L7;
        ((BannerAdapter) r2).b = 0;
    L7:
        r2.registerAdapterDataObserver(r1.G);
        r1.a.setAdapter(r2);
        int r6 = r1.k;
        r1.getViewPager2().setCurrentItem(r6, false);
        r1.a();
    L9:
        if (this.e == true) goto L13;
        this.e = true;
        ViewModelProvider.NewInstanceFactory r7 = ForsetiViewModelProvider.c;
        TemplateCenterViewModel r8 = (TemplateCenterViewModel) ForsetiViewModelProvider.a.a(this.a).get(TemplateCenterViewModel.class);
        r8.getSystemFilterLiveData().observe(this.c, new h(this));
        r8.getCategoryIndex().observe(this.c, new i(r8, this));
        return;
    }

    @Override // xn5.b
    public final void f8(boolean r2) {
        Banner<Void, TemplateBannerAdapter> r0 = this.d;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        b.a r2 = (b.a) r1;
    }

    public g(FragmentActivity r2, View r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "root");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
