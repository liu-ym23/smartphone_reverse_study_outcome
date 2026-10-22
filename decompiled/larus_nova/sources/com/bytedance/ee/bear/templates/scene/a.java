package com.bytedance.ee.bear.templates.scene;

import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BasePresenter<com.bytedance.ee.bear.templates.scene.c, d, d.a> implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f239312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.templates.scene.c f239313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f239314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f239315d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.scene.a$a, reason: collision with other inner class name */
    public static final class C3436a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f239316a;

        public b(a r100) {
            this.f239316a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            TopicDataResult r101 = (TopicDataResult) r100;
            d r102 = this.f239316a.f239314c;
            Intrinsics.checkNotNull(r101);
            r102.a7(r101);
            ArrayList<TemplateV4> r103 = ((TopicData) r101.data).getTemplates();     // Catch: Throwable -> L7
            if (r103 == null) goto L10;
            r103.isEmpty();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f239317a;

        public c(a r100) {
            this.f239317a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("SearchListPresenter", "loadData err:", r101, false);
            d r102 = this.f239317a.f239314c;
            Intrinsics.checkNotNull(r101);
            r102.m(r101);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void onLoadFailed() {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        if (this.f239315d.isDisposed() == true) goto L6;
        this.f239315d.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void v0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "topicID");
        this.f239314c.d();
        if (StringsKt.isBlank(r100) == false) goto L5;
    L12:
        this.f239314c.m(new RuntimeException("topic is empty"));
        return;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        Disposable r102 = this.f239313b.v0(r100).subscribe(new b(this), new c(this));
        this.f239315d.add(r102);
        return;
    L7:
        r101 = false;
        goto L8
    }

    public a(Fragment r100, com.bytedance.ee.bear.templates.scene.c r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "view");
        super(r101, r102);
        this.f239312a = r100;
        this.f239313b = r101;
        this.f239314c = r102;
        this.f239315d = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("SearchListPresenter", "onTemplateSelected()...template = " + r101);
        ConnectionService.NetworkState r103 = j.a.f217090a.getNetworkState();
        boolean r104 = r103.a() ^ true;
        if (r101.getEnable() == true) goto L7;
        if (r104 == false) goto L7;
        tt5.a.h("SearchListPresenter", "create template offline, state:" + r103 + ", template enable: " + r101.getEnable());
        Toast.showFailureText(this.f239312a.getContext(), R.string.Doc_List_NoInternetClickMoreToast);
        return;
    L7:
        this.f239313b.b4(r101);
        TemplateReportV2 r105 = TemplateReportV2.f238768a;
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        JSONObject r106 = new JSONObject();
        r106.put2("click_type", "use_click");
        r106.put2("template_token", r101.getReportToken());
        r106.put2("template_name", r101.getReportName());
        r106.put2("use_source", "image");
        r106.put2("position_index", Integer.valueOf(r100 + 1));
        if (r102 == null) goto L10;
        r106.put2("sub_template_sort", r102);
    L10:
        r106.put2("create_file_type", sbb.e.c(r101.getObjType()));
        r106.put2(PickerReporterConstants.KEY.TARGET, "ccm_docs_page_view");
        r106.put2("template_source", TemplateReportV2.f238770c);
        r106.put2("template_type", TemplateReportV2.b(r101));
        TemplateReportV2.a().o("ccm_template_banner_view_click", r106, r101.checkToken());
    }
}
