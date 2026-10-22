package eo5;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.search.base.BasePresenter;
import com.bytedance.ee.bear.templates.search.base.BaseView;
import com.bytedance.ee.bear.templates.search.base.e;
import com.bytedance.ee.bear.templates.search.base.f;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends BasePresenter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f473318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f473319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BaseView f473320n;

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter, com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        ((TemplateCenterViewModel) this.f239351i.getValue()).getDeleteToken().observe(this.f473318l, new b(this));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final Fragment H8() {
        return this.f473318l;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final e I8() {
        return this.f473319m;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final f J8() {
        return this.f473320n;
    }

    public c(Fragment r100, a r101, BaseView r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "view");
        super(r100, r101, r102);
        this.f473318l = r100;
        this.f473319m = r101;
        this.f473320n = r102;
    }
}
