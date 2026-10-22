package com.bytedance.ee.bear.templates.horizontal;

import android.os.Bundle;
import android.os.IBinder;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.templates.preview.single.common.CustomTemplateCreator;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 B2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001BB_\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\u0004H\u0014J\b\u0010<\u001a\u000208H\u0016J\u0018\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020.H\u0016J\b\u0010@\u001a\u000208H\u0016J\u0010\u0010A\u001a\u0002082\u0006\u00105\u001a\u00020\u0006H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010#R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000606X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplatePresenter;", "Lcom/larksuite/framework/mvp/BasePresenter;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IModel;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView$IViewDelegate;", "Landroidx/lifecycle/Observer;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateModel;", "view", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "categoryId", "", "pageSize", "", EventConstant.Key.MODULE, "", "subModule", "parentToken", "isFolder", "isFromEmpty", "showSize", "<init>", "(Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateModel;Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView;Landroidx/fragment/app/Fragment;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getCategoryId", "()J", "getPageSize", "()I", "getModule", "()Ljava/lang/String;", "getSubModule", "getParentToken", "()Z", "getShowSize", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "hasData", "dataList", "", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "binderCallback", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "selectTemplateConfig", "Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "customTemplateCreator", "Lcom/bytedance/ee/bear/templates/preview/single/common/CustomTemplateCreator;", "previewActive", "Landroidx/lifecycle/MutableLiveData;", "create", "", "loadData", "observeNetwork", "createViewDelegate", "onMoreClicked", "onTemplateSelected", "position", ThumbGlideUrl.SOURCE_TEMPLATE, MapMonitorConst.EVENT_DESTROY, "onChanged", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalTemplatePresenter extends BasePresenter<com.bytedance.ee.bear.templates.horizontal.a, com.bytedance.ee.bear.templates.horizontal.b, com.bytedance.ee.bear.templates.horizontal.b.a> implements com.bytedance.ee.bear.templates.horizontal.b.a, Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f239094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f239095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f239096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f239097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f239098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<TemplateV4> f239099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BinderISelectTemplateCallback.Stub f239100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SelectTemplateConfig f239101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CustomTemplateCreator f239102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Boolean> f239103j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalTemplatePresenter f239104a;

        public b(HorizontalTemplatePresenter r100) {
            this.f239104a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            HorizontalTemplates r101 = (HorizontalTemplates) r100;
            if (r101.getSource() == 2) goto L5;
        L12:
            boolean r102 = true;
            this.f239104a.f239098e = !r101.getTemplates().isEmpty();
            this.f239104a.f239099f = r101.getTemplates();
            tt5.a.h("HorizontalTemplatePresenter", "start showTemplates hasData=" + this.f239104a.f239098e + " source=" + r101.getSource() + " size=" + r101.getTemplates().size() + " hasMore=" + r101.getHasMore());
            if (this.f239104a.f239098e == true) goto L20;
            if (r101.getSource() != 2) goto L20;
            BinderISelectTemplateCallback.Stub r103 = this.f239104a.f239100g;
            if (r103 == null) goto L20;
            r103.onError(1);
        L20:
            if (r101.getTemplates().size() <= this.f239104a.f239096c) goto L22;
            List<TemplateV4> r104 = r101.getTemplates().subList(0, this.f239104a.f239096c);
        L23:
            Intrinsics.checkNotNull(r104);
            this.f239104a.getView().F5(r104, r102);
            return;
        L22:
            r104 = r101.getTemplates();
            r102 = false;
            goto L23
        L5:
            if (r101.getErr() == null) goto L12;
            HorizontalTemplatePresenter r105 = this.f239104a;
            if (r105.f239098e == true) goto L25;
            BinderISelectTemplateCallback.Stub r106 = r105.f239100g;
            if (r106 == null) goto L11;
            r106.onError(-1);
        L11:
            this.f239104a.getView().E(r101.getErr());
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalTemplatePresenter f239105a;

        public c(HorizontalTemplatePresenter r100) {
            this.f239105a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            tt5.a.f("HorizontalTemplatePresenter", r101, false);
            BinderISelectTemplateCallback.Stub r102 = this.f239105a.f239100g;
            if (r102 == null) goto L5;
            r102.onError(-1);
        L5:
            this.f239105a.getView().E(r101);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    public final void H8() {
        ((CompositeDisposable) this.f239097d.getValue()).clear();
        Disposable r100 = getModel().K().subscribe(new b(this), new c(this));
        ((CompositeDisposable) this.f239097d.getValue()).add(r100);
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b.a
    public final void o() {
        RouteBean r100 = new RouteBean();
        r100.a(this.f239094a);
        PostCard r101 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r100).f("categoryId", this.f239095b).m(536870912).c("key_template_select_callback_bundle", this.f239094a.getArguments());
        SelectTemplateConfig r102 = this.f239101h;
        if (r102 == null) goto L5;
        String r103 = r102.f238865c;
    L6:
        PostCard r104 = r101.i("fromAppLink", r103);
        SelectTemplateConfig r105 = this.f239101h;
        if (r105 == null) goto L9;
        String r106 = r105.f238865c;
    L10:
        r104.i("template_source", r106).e();
        TemplateReportV2 r107 = TemplateReportV2.f238768a;
        TemplateReportV2.g("click_template_systemcenter", null);
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        Bundle r100 = this.f239094a.getArguments();
        SelectTemplateConfig r101 = null;
        if (r100 == null) goto L5;
        IBinder r102 = r100.getBinder("key_template_select_callback");
    L7:
        if ((r102 instanceof BinderISelectTemplateCallback.Stub) == false) goto L9;
        this.f239100g = (BinderISelectTemplateCallback.Stub) r102;
    L10:
        Bundle r103 = this.f239094a.getArguments();
        if (r103 == null) goto L13;
        r101 = (SelectTemplateConfig) r103.getParcelable("key_template_select_template_config");
    L13:
        this.f239101h = r101;
        this.f239102i = new CustomTemplateCreator(this.f239100g, this.f239101h);
        getView().d();
        H8();
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(this.f239094a, new f(this));
        this.f239103j.observe(this.f239094a, this);
        return;
    L9:
        tt5.a.k("HorizontalTemplatePresenter", "cb=" + r102);
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        if (((CompositeDisposable) this.f239097d.getValue()).isDisposed() == true) goto L5;
        ((CompositeDisposable) this.f239097d.getValue()).dispose();
    L5:
        this.f239103j.removeObservers(this.f239094a);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean r100) {
        tt5.a.h("HorizontalTemplatePresenter", "previewActive ret=" + r100.booleanValue());
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b.a
    public final void L(int r110, TemplateV4 r111) {
        Intrinsics.checkNotNullParameter(r111, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L6;
        tt5.a.h("HorizontalTemplatePresenter", "onTemplateSelected offline");
        Toast.showFailureText(this.f239094a.getContext(), R.string.Doc_List_NoInternetClickMoreToast);
        return;
    L6:
        SelectTemplateConfig r100 = this.f239101h;
        if (r100 == null) goto L11;
        boolean r101 = true;
        if (r100.f238866d != true) goto L11;
    L12:
        if (r101 == false) goto L21;
        tt5.a.h("HorizontalTemplatePresenter", "enablePreviewDetail true");
        ArrayList r112 = new ArrayList();
        if (hu5.a.d(this.f239099f) == true) goto L19;
        List<TemplateV4> r102 = this.f239099f;
        if (r102 != null) goto L18;
        return;
    L18:
        r112.add(new ao5.a(null, false, r102, 0, 123));
    L20:
        TemplateUtils r103 = TemplateUtils.f238776a;
        Bundle r104 = this.f239094a.getArguments();
        Function0<Boolean> r105 = new HorizontalTemplatePresenter$onTemplateSelected$1(this);
        r103.getClass();
        TemplateUtils.j(r111, r112, r104, r105);
        TemplateReportV2 r113 = TemplateReportV2.f238768a;
        TemplateReportV2.g("click_vc_template", r111);
        return;
    L19:
        tt5.a.d("HorizontalTemplatePresenter", "onTemplateSelected dataList is empty");
        goto L20
    L21:
        tt5.a.h("HorizontalTemplatePresenter", "enablePreviewDetail false, customTemplateCreator=" + this.f239102i);
        CustomTemplateCreator r106 = this.f239102i;
        if (r106 == null) goto L26;
        r106.a(new Item(r111.getObjToken(), r111.getName(), r111.getObjType(), 0, r110, r111.getId()), null, this.f239103j);
        return;
    L26:
        return;
    L11:
        r101 = false;
        goto L12
    }

    public HorizontalTemplatePresenter(HorizontalTemplateModel r100, g r101, Fragment r102, long r103, String r104, String r105, String r106, int r110) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "subModule");
        Intrinsics.checkNotNullParameter(r106, "parentToken");
        super(r100, r101);
        this.f239094a = r102;
        this.f239095b = r103;
        this.f239096c = r110;
        this.f239097d = LazyKt.lazy(HorizontalTemplatePresenter$compositeDisposable$2.INSTANCE);
        this.f239103j = new MutableLiveData();
    }
}
