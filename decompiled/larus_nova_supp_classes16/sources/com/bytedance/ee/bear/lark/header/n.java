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
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements i {
    public RecommendView a;
    public boolean b;
    public BitableBannerConfig c;
    public final b d;
    public final boolean e;
    public final String f;
    public Fragment g;

    public static final class a {
    }

    public static final class b implements BitableHomePageConfigHandler.b {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        public final void a(BitableBannerConfig r3) {
            n r0 = this.a;
            r0.c = r3;
            Intrinsics.checkNotNullParameter("", "defaultLeftTitle");
            Intrinsics.checkNotNullParameter("", "defaultRightTitle");
            com.bytedance.ee.util.ui.j.f(new o(r0, "", ""));
        }
    }

    public static final class c implements RecommendView.c {
        public final /* synthetic */ n a;
        public final /* synthetic */ Context b;

        public final void o() {
            if (this.a.e == false) goto L5;
            String r0 = "workbench";
        L6:
            String r6 = r0;
            RouteBean r1 = new RouteBean();
            Fragment r2 = this.a.g;
            if (r2 == null) goto L9;
            r1.a(r2);
        L9:
            int r3 = com.bytedance.ee.bear.bitable.c.a;
            r1.u = !com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.template_center_forseti_enable");
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r1).j("objType", 8).i("enterSource", r6).i("template_source", r6).i("openTemplateCenter", "system").l("fixedFilter", true).l("key_folder_version", true).i("MODULE", "lark_workspace_bitable_landing").i("ROOT_TOKEN", "").d(this.b).k(1).e();
            lc5.f.a.n("open_all", null, null, null, r6, this.a.f);
            return;
        L5:
            r0 = "larktab_bitable";
            goto L6
        }

        public c(n r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void p(BannerCardInfo r10, int r11) {
            if (r10 == null) goto L9;
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r10.getRedirectUrl());
            lc5.f.a r2 = lc5.f.a;
            String r4 = r10.getRedirectUrl();
            String r5 = r10.getTitle();
            Integer r6 = Integer.valueOf(r11);
            n r12 = this.a;
            if (r12.e == false) goto L6;
            String r13 = "workbench";
        L7:
            r2.n("preview_click", r4, r5, r6, r13, r12.f);
            return;
        L6:
            r13 = "larktab_bitable";
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
        tt5.a.h("RecommendHeader", "destroy");
        this.a = null;
        this.g = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r3) {
        tt5.a.h("RecommendHeader", "onNetworkStateChanged " + r3);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        boolean r0 = true;
        this.b = true;
        this.c = (BitableBannerConfig) SettingManager.getInstance().get(BitableBannerConfig.class);
        StringBuilder r1 = new StringBuilder("initData config null ");
        if (this.c == null) goto L6;
        r0 = false;
    L6:
        r1.append(r0);
        tt5.a.h("RecommendHeader", r1.toString());
        String r2 = r5.getString(2131886926);
        String r6 = r5.getString(2131886929);
        Intrinsics.checkNotNullParameter(r2, "defaultLeftTitle");
        Intrinsics.checkNotNullParameter(r6, "defaultRightTitle");
        com.bytedance.ee.util.ui.j.f(new o(this, r2, r6));
        BitableHomePageConfigHandler r7 = BitableHomePageConfigHandler.i;
        b r3 = this.d;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        BitableHomePageConfigHandler.j = r3;
        lc5.f.a r8 = lc5.f.a;
        if (this.e == false) goto L9;
        String r4 = "workbench";
    L10:
        r8.A("ccm_base_homepage_banner_view", null, r4, this.f);
        return;
    L9:
        r4 = "larktab_bitable";
        goto L10
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        RecommendView r0 = new RecommendView(r5, this.e, this.f);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.a = r0;
        r0.setViewDelegate(new c(this, r5));
        return this.a;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r3) {
        tt5.a.h("RecommendHeader", "setUserVisibleHint " + r3);
    }

    public n(boolean r2, String r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r3, "hpFrom");
        Intrinsics.checkNotNullParameter(r4, "mSourceFragment");
        this.d = new b(this);
        this.f = "";
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }
}
