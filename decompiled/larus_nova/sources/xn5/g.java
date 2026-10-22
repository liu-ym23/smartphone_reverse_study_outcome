package xn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;
import com.bytedance.ee.bear.bizwidget.banner.indicator.RectangleIndicator;
import com.bytedance.ee.bear.bizwidget.banner.util.BannerLifecycleObserverAdapter;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.templates.banner.BannerData;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f564623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f564624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f564625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Banner<Void, TemplateBannerAdapter> f564626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f564627e;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        Banner<Void, TemplateBannerAdapter> r100 = (Banner) this.f564624b.findViewById(R.id.banner);
        LifecycleOwner r101 = this.f564625c;
        r100.getClass();
        if (r101 == null) goto L5;
        r101.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(r101, r100));
    L5:
        RectangleIndicator r102 = new RectangleIndicator(this.f564623a);
        qv4.a r103 = r100.f216312d;
        if (r103 == null) goto L8;
        r100.removeView(r103.getIndicatorView());
    L8:
        r102.getIndicatorConfig().f216351l = true;
        r100.f216312d = r102;
        r100.a();
        r100.f216317i = 5000;
        this.f564626d = r100;
    }

    public final FragmentActivity getActivity() {
        return this.f564623a;
    }

    @Override // xn5.b
    public final void e8(ArrayList<BannerData> r100) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.BANNERS);
        f8(true);
        Banner<Void, TemplateBannerAdapter> r101 = this.f564626d;
        if (r101 == null) goto L9;
        TemplateBannerAdapter r102 = new TemplateBannerAdapter(r100);
        r101.f216311c = r102;
        if (r101.f216315g == true) goto L7;
        r102.f216308b = 0;
    L7:
        r102.registerAdapterDataObserver(r101.G);
        r101.f216309a.setAdapter(r102);
        int r103 = r101.f216319k;
        r101.getViewPager2().setCurrentItem(r103, false);
        r101.a();
    L9:
        if (this.f564627e == true) goto L13;
        this.f564627e = true;
        ViewModelProvider.NewInstanceFactory r104 = ForsetiViewModelProvider.f216459c;
        TemplateCenterViewModel r105 = (TemplateCenterViewModel) ForsetiViewModelProvider.a.a(this.f564623a).get(TemplateCenterViewModel.class);
        r105.getSystemFilterLiveData().observe(this.f564625c, new h(this));
        r105.getCategoryIndex().observe(this.f564625c, new i(r105, this));
        return;
    }

    @Override // xn5.b
    public final void f8(boolean r100) {
        Banner<Void, TemplateBannerAdapter> r101 = this.f564626d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        b.a r101 = (b.a) r100;
    }

    public g(FragmentActivity r100, View r101, LifecycleOwner r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f564623a = r100;
        this.f564624b = r101;
        this.f564625c = r102;
    }
}
