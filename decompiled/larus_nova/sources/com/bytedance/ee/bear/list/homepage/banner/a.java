package com.bytedance.ee.bear.list.homepage.banner;

import android.content.Context;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.homepage.banner.g;
import com.bytedance.ee.bear.list.homepage.banner.g.a;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import dd5.q1;
import dd5.s1;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a<M extends f, V extends g<VD>, VD extends g.a> extends BasePresenter<M, V, VD> implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifeCycleFragment f228276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f228277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public M f228278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f228279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ce5.a f228280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f228281f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.homepage.banner.a$a, reason: collision with other inner class name */
    public static final class C3263a {
    }

    public final class b implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<M, V, VD> f228282a;

        @Override // com.bytedance.ee.bear.list.homepage.banner.g.a
        public final void t6() {
            this.f228282a.I8();
            lc5.f.a r100 = lc5.f.f508440a;
            com.bytedance.ee.bear.contract.d r101 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            String r102 = this.f228282a.J8();
            Intrinsics.checkNotNullParameter(r101, "analyticService");
            Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
            HashMap r103 = new HashMap();
            r103.put(EventConstant.Key.MODULE, r102);
            if (qc5.a.h() == false) goto L5;
            String r104 = "new_format";
        L6:
            r103.put("space_version", r104);
            lc5.f.a.D(r101, "click_folder_all", r103);
            return;
        L5:
            r104 = "original";
            goto L6
        }

        public b(a r100) {
            this.f228282a = r100;
        }

        @Override // com.bytedance.ee.bear.list.homepage.banner.g.a
        public final void y1(Document r100, int r101) {
            this.f228282a.N8(r100, r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<M, V, VD> f228283a;

        public c(a<M, V, VD> r100) {
            this.f228283a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            this.f228283a.getView().l0(new ArrayList());
            this.f228283a.getModel().X().removeObservers(this.f228283a.f228276a);
            this.f228283a.getModel().d7();
            a.H8(this.f228283a);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<M, V, VD> f228284a;

        public d(a<M, V, VD> r100) {
            this.f228284a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = this.f228284a.L8();
            tt5.a.f(r101, (Throwable) r100, false);
        }
    }

    static {
    }

    public abstract void I8();

    public abstract String J8();

    public String K8() {
        return "none";
    }

    public String L8() {
        return "BaseBannerPresenter";
    }

    public abstract String M8();

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public void create() {
        super.create();
        s1.a.f468004a.a(this);
        getModel().X().observe(this.f228276a, new com.bytedance.ee.bear.list.homepage.banner.b(this));
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        super.destroy();
        this.f228281f.clear();
        s1.a.f468004a.h(this);
    }

    @Override // dd5.q1
    public final void r() {
        tt5.a.h(L8(), "onTenantChanged()...");
        this.f228281f.add(Flowable.just(Boolean.TRUE).observeOn(fo5.d.d()).subscribe(new c(this), new d(this)));
    }

    public final Context getContext() {
        return this.f228277b;
    }

    public static final void H8(a r100) {
        ((f) r100.getModel()).X().observe(r100.f228276a, new com.bytedance.ee.bear.list.homepage.banner.b(r100));
    }

    public void O8(ArrayList<Document> r100) {
        String r101 = L8();
        StringBuilder r102 = new StringBuilder("onListChange list = ");
        Integer r103 = null;
        if (r100 == null) goto L5;
        Integer r104 = Integer.valueOf(r100.size());
    L6:
        r102.append(r104);
        tt5.a.h(r101, r102.toString());
        getModel().C4(r100);
        ArrayList<Document> r105 = getModel().getList();
        ArrayList<Document> r106 = dd5.a.a(r105, this.f228280e.f23449d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        if (r105 == null) goto L9;
        Integer r107 = Integer.valueOf(r105.size());
    L10:
        if (r106 == null) goto L13;
        r103 = Integer.valueOf(r106.size());
    L13:
        if (Intrinsics.areEqual(r107, r103) == true) goto L24;
        String r108 = L8();
        StringBuilder r109 = new StringBuilder("ai_artifact_folder_display_filter, rawSize=");
        if (r105 == null) goto L17;
        int r110 = r105.size();
    L18:
        r109.append(r110);
        r109.append(", visibleSize=");
        if (r106 == null) goto L21;
        int r111 = r106.size();
    L22:
        r109.append(r111);
        tt5.a.h(r108, r109.toString());
        goto L24
    L21:
        r111 = 0;
        goto L22
    L17:
        r110 = 0;
    L24:
        if (r106 != null) goto L26;
    L29:
        boolean r112 = true;
    L30:
        if (r112 == false) goto L33;
        getView().l0(new ArrayList());
        getView().l6(false);
        return;
    L33:
        getView().l6(true);
        getView().j4(getModel().hasMore());
        getView().l0(r106);
        return;
    L26:
        if (r106.isEmpty() == true) goto L29;
        r112 = false;
        goto L30
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public void N8(Document r210, int r211) {
        if (r210 == null) goto L35;
        String r100 = r210.f227891p;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        return;
    L14:
        if (j.a.f217090a.getNetworkState().a() == false) goto L16;
    L19:
        h r110 = (h) org.koin.java.a.c(h.class, null, null, 6);
        String r111 = r210.f227891p + M8();
        Context r102 = this.f228277b;
        String r112 = J8();
        ArrayList r113 = new ArrayList();
        String r114 = K8();
        Context r103 = new e0(r102, r210, r112, r113, r114, "home").getContext();
        if (r210.getType() != sbb.e.f541295f.f541317b) goto L23;
        sd5.e r104 = new sd5.c(r103, r112, 1, "");
    L29:
        r110.m9(r111, r104.a(r210));
        lc5.f.a r105 = lc5.f.f508440a;
        com.bytedance.ee.bear.contract.d r106 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        String r107 = J8();
        Intrinsics.checkNotNullParameter(r106, "analyticService");
        Intrinsics.checkNotNullParameter(r107, EventConstant.Key.MODULE);
        HashMap r108 = new HashMap();
        String r109 = du5.b.g(r210.f227873d);
        r108.put(EventConstant.Key.MODULE, r107);
        Intrinsics.checkNotNull(r210);
        r108.put("file_type", sbb.e.c(r210.getType()));
        r108.put("file_id", r109);
        r108.put("location", String.valueOf(r211 + 1));
        r108.put("folder_level", "0");
        r108.put("sequence_num", String.valueOf(r211));
        if (qc5.a.h() == false) goto L32;
        String r115 = "new_format";
    L33:
        r108.put("space_version", r115);
        r106.v("click_list_item", r108);
        return;
    L32:
        r115 = "original";
        goto L33
    L23:
        if (r210.getType() != sbb.e.f541301l.f541317b) goto L26;
        r104 = new sd5.b(new e0(r103, r210, r112, r113, r114, "home"), "");
        goto L29
    L26:
        if (r210.getType() != sbb.e.f541303n.f541317b) goto L28;
        r104 = new sd5.g();
        goto L29
    L28:
        r104 = new sd5.a(r103);
        goto L29
    L16:
        if (t0.c(r210) == true) goto L19;
        tt5.a.h(L8(), "onItemClick()...can not open offline");
        Context r116 = this.f228277b;
        Toast.showText(r116, r116.getString(R.string.Doc_List_OfflineClickTips), 0);
        return;
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L11
    }

    public a(LifeCycleFragment r100, Context r101, BaseBannerModel r102, com.bytedance.ee.bear.list.homepage.banner.c r103, ce5.a r104) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "view");
        Intrinsics.checkNotNullParameter(r104, "userComponentAbility");
        super(r102, r103);
        this.f228276a = r100;
        this.f228277b = r101;
        this.f228278c = r102;
        this.f228279d = r103;
        this.f228280e = r104;
        this.f228281f = new CompositeDisposable();
    }
}
