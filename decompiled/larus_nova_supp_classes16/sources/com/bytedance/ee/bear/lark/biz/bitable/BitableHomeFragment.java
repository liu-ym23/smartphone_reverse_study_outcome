package com.bytedance.ee.bear.lark.biz.bitable;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.banner.bean.BannerScene;
import com.bytedance.ee.bear.bitable.homepage.j0;
import com.bytedance.ee.bear.bitable.homepage.l0;
import com.bytedance.ee.bear.bitable.homepage.list.BitableRecentFragment;
import com.bytedance.ee.bear.bitable.homepage.n0;
import com.bytedance.ee.bear.lark.DocTabFragment;
import com.bytedance.ee.bear.lark.header.m;
import com.bytedance.ee.bear.lark.header.p;
import com.bytedance.ee.bear.lark.header.t;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lc5.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u000256B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0006H\u0014J\b\u0010\u001f\u001a\u00020\u0006H\u0014J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\u0017\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\fH\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000104H\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/lark/biz/bitable/BitableHomeFragment;", "Lcom/bytedance/ee/bear/lark/DocTabFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/IListContainer;", "<init>", "()V", "hpFrom", "", "getHpFrom", "()Ljava/lang/String;", "setHpFrom", "(Ljava/lang/String;)V", "isFromWorkbench", "", "()Z", "setFromWorkbench", "(Z)V", "onMenuCreateClick", "", "view", "Landroid/view/View;", "openBitableTemplateCenter", "enterSource", "templateSource", "getCreateTemplateSource", "getModule", "getSubModule", "getHeaderConfig", "Lcom/bytedance/ee/bear/lark/header/IHeaderConfig;", "getHomeTabConfig", "Lcom/bytedance/ee/bear/list/homepage/tab/IHomeTabConfig;", "getHomePageViewEvent", "getHomePageClickEvent", "getContainerEnv", "getHomePageFrom", "onReleaseResource", "clickFrom", "isWorkBench", "getContainerScene", "getFrom", "onCoverViewClick", "isHideCreateBtn", "isHide", "(Ljava/lang/Boolean;)V", "isFullScreen", "setOnRefreshListener", "listener", "Lcom/bytedance/ee/bear/bitable/homepage/IRefreshListener;", "getTraceId", "getHomePageDelegate", "Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;", "initCreateBtn", "rootView", "Landroid/view/ViewGroup;", "BitableHeaderConfig", "BitableTabConfig", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableHomeFragment extends DocTabFragment implements l0 {
    public String E;
    public boolean F;

    public static final class a implements com.bytedance.ee.bear.lark.header.h {
        public final HashMap<com.bytedance.ee.bear.lark.header.i, Integer> a;

        @Override // com.bytedance.ee.bear.lark.header.h
        public final Map<com.bytedance.ee.bear.lark.header.i, Integer> getHeaders() {
            return this.a;
        }

        public a(DocTabFragment r5) {
            Intrinsics.checkNotNullParameter(r5, "homePageFragment");
            LinkedHashMap r6 = new LinkedHashMap();
            this.a = r6;
            r6.put(new com.bytedance.ee.bear.lark.header.b(), 0);
            r6.put(new m(true), 1);
            r6.put(new t(true, BannerScene.BITABLE_LANDING, "bitable"), 2);
            r6.put(new p(2131165446), 3);
        }
    }

    public static final class b implements ad5.f {
        public b() {
        }

        public final List<ad5.e> a(boolean r5) {
            ArrayList r6 = new ArrayList();
            r6.add(new ad5.e(HomeTabEnum.RECENT.id, 2131887956, BitableRecentFragment.class.getName()));
            return r6;
        }
    }

    public String Ba0() {
        return "bitable_ws_landing_create_new";
    }

    public final j0 F2() {
        return null;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public String W9() {
        return "workbench";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public String aa0() {
        return "ccm_bitable_workspace_landing_page_click";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public String da0() {
        return "ccm_bitable_workspace_landing_page_view";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final String fa0() {
        return "lark_workspace_bitable_landing";
    }

    public final String getTraceId() {
        return "";
    }

    public final boolean isFullScreen() {
        return true;
    }

    public final void o00() {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void oa0(Boolean r1) {
    }

    public final void pB(n0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public com.bytedance.ee.bear.lark.header.h Z90() {
        return new a(this);
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public String ba0() {
        String r0 = this.E;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public ad5.f ea0() {
        return new b();
    }

    public BitableHomeFragment() {
        this.A = false;
    }

    public final String Sv() {
        return W9();
    }

    public final String getFrom() {
        return ba0();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public String m6() {
        return super.m6();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void wa0() {
        x.c().b();
        pd5.e.b(getContext()).a();
    }

    public final boolean rl() {
        return this.F;
    }

    public final void Sz(String r2) {
        Intrinsics.checkNotNullParameter(r2, "clickFrom");
        onMenuCreateClick(null);
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ha0(ViewGroup r4) {
        super.ha0(r4);
        if (((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base") == true) goto L8;
        CommonCreateButton r5 = r4.findViewById(2131367552);
        if (r5 == null) goto L9;
        r5.setVisibility(8);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public void onMenuCreateClick(View r9) {
        Ca0("create_new", Ba0());
        lc5.f.a r10 = lc5.f.a;
        lc5.p r7 = new lc5.p("lark_workspace_bitable_landing", m6(), "create_new", "ccm_template_systemcenter_view", m6(), aa0());
        Intrinsics.checkNotNullParameter(r7, "param");
        r10.I(r7);
    }

    public final void Ca0(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "enterSource");
        Intrinsics.checkNotNullParameter(r8, "templateSource");
        RouteBean r1 = new RouteBean();
        r1.a(this);
        int r2 = com.bytedance.ee.bear.bitable.c.a;
        r1.u = !com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.template_center_forseti_enable");
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r1).j("objType", 8).i("enterSource", r7).i("template_source", r8).i("openTemplateCenter", "system").l("fixedFilter", true).l("key_folder_version", true).i("MODULE", "lark_workspace_bitable_landing").i("ROOT_TOKEN", "").d(getContext()).k(1).e();
    }
}
