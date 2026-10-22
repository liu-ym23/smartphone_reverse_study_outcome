package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageConfigHandler;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.list.homepage.banner.BannerCardInfo;
import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.list.homepage.banner.RecommendView;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecommendView f227400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BitableBannerConfig f227402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f227403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f227404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f227405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f227406g;

    public static final class a {
    }

    public static final class b implements BitableHomePageConfigHandler.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f227407a;

        public b(n r100) {
            this.f227407a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.homepage.BitableHomePageConfigHandler.b
        public final void a(BitableBannerConfig r100) {
            n r101 = this.f227407a;
            r101.f227402c = r100;
            Intrinsics.checkNotNullParameter("", "defaultLeftTitle");
            Intrinsics.checkNotNullParameter("", "defaultRightTitle");
            com.bytedance.ee.util.ui.j.f(new o(r101, "", ""));
        }
    }

    public static final class c implements RecommendView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f227408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f227409b;

        @Override // com.bytedance.ee.bear.list.homepage.banner.RecommendView.c
        public final void o() {
            if (this.f227408a.f227404e == false) goto L5;
            String r100 = "workbench";
        L6:
            String r101 = r100;
            RouteBean r102 = new RouteBean();
            Fragment r103 = this.f227408a.f227406g;
            if (r103 == null) goto L9;
            r102.a(r103);
        L9:
            int r104 = com.bytedance.ee.bear.bitable.c.f207079a;
            r102.f236656u = !com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.template_center_forseti_enable");
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r102).j("objType", 8).i("enterSource", r101).i("template_source", r101).i("openTemplateCenter", CameraParam.TYPE_SYSTEM_CAMERA).l("fixedFilter", true).l("key_folder_version", true).i("MODULE", "lark_workspace_bitable_landing").i("ROOT_TOKEN", "").d(this.f227409b).k(1).e();
            lc5.f.f508440a.n("open_all", null, null, null, r101, this.f227408a.f227405f);
            return;
        L5:
            r100 = "larktab_bitable";
            goto L6
        }

        public c(n r100, Context r101) {
            this.f227408a = r100;
            this.f227409b = r101;
        }

        @Override // com.bytedance.ee.bear.list.homepage.banner.RecommendView.c
        public final void p(BannerCardInfo r110, int r111) {
            if (r110 == null) goto L9;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r110.getRedirectUrl());
            lc5.f.a r100 = lc5.f.f508440a;
            String r101 = r110.getRedirectUrl();
            String r102 = r110.getTitle();
            Integer r103 = Integer.valueOf(r111);
            n r112 = this.f227408a;
            if (r112.f227404e == false) goto L6;
            String r113 = "workbench";
        L7:
            r100.n("preview_click", r101, r102, r103, r113, r112.f227405f);
            return;
        L6:
            r113 = "larktab_bitable";
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("RecommendHeader", MapMonitorConst.EVENT_DESTROY);
        this.f227400a = null;
        this.f227406g = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227401b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r100) {
        tt5.a.h("RecommendHeader", "onNetworkStateChanged " + r100);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = true;
        this.f227401b = true;
        this.f227402c = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        StringBuilder r102 = new StringBuilder("initData config null ");
        if (this.f227402c == null) goto L6;
        r101 = false;
    L6:
        r102.append(r101);
        tt5.a.h("RecommendHeader", r102.toString());
        String r103 = r100.getString(R.string.Bitable_Workspace_Recommended_Title);
        String r104 = r100.getString(R.string.Bitable_Workspace_ViewAll_Button);
        Intrinsics.checkNotNullParameter(r103, "defaultLeftTitle");
        Intrinsics.checkNotNullParameter(r104, "defaultRightTitle");
        com.bytedance.ee.util.ui.j.f(new o(this, r103, r104));
        BitableHomePageConfigHandler r105 = BitableHomePageConfigHandler.f212174i;
        b r106 = this.f227403d;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "listener");
        BitableHomePageConfigHandler.f212175j = r106;
        lc5.f.a r107 = lc5.f.f508440a;
        if (this.f227404e == false) goto L9;
        String r108 = "workbench";
    L10:
        r107.A("ccm_base_homepage_banner_view", null, r108, this.f227405f);
        return;
    L9:
        r108 = "larktab_bitable";
        goto L10
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        RecommendView r101 = new RecommendView(r100, this.f227404e, this.f227405f);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f227400a = r101;
        r101.setViewDelegate(new c(this, r100));
        return this.f227400a;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
        tt5.a.h("RecommendHeader", "setUserVisibleHint " + r100);
    }

    public n(boolean r100, String r101, Fragment r102) {
        Intrinsics.checkNotNullParameter(r101, "hpFrom");
        Intrinsics.checkNotNullParameter(r102, "mSourceFragment");
        this.f227403d = new b(this);
        this.f227405f = "";
        this.f227404e = r100;
        this.f227405f = r101;
        this.f227406g = r102;
    }
}
