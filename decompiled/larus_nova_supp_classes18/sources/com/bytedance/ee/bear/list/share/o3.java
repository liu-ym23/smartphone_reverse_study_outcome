package com.bytedance.ee.bear.list.share;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.homepage.banner.BaseBannerModel;
import com.larksuite.framework.mvp.IModel;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class o3 extends com.bytedance.ee.bear.list.homepage.banner.a<com.bytedance.ee.bear.list.homepage.banner.f, com.bytedance.ee.bear.list.homepage.banner.g<com.bytedance.ee.bear.list.homepage.banner.g.a>, com.bytedance.ee.bear.list.homepage.banner.g.a> {
    public final ce5.a g;

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String J8() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String K8() {
        return "shared_folder";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public String L8() {
        return "SharedBannerPresenter";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String M8() {
        return "?from=tab_share_folder";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public void I8() {
        lc5.p r15 = new lc5.p("ccm_space_shared_page_click", "shared", "shared_folder", "all", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r15);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/list/share/activity").e();
    }

    public final IModel getModel() {
        return this.c;
    }

    public final IView getView() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public void O8(ArrayList<Document> r5) {
        tt5.a.h(L8(), "onListChanged, size= " + hu5.a.c(r5));
        this.c.C4(r5);
        ArrayList<Document> r0 = dd5.a.a(r5, this.e.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        if (hu5.a.c(r5) == hu5.a.c(r0)) goto L5;
        tt5.a.h(L8(), "ai_artifact_folder_display_filter, rawSize=" + hu5.a.c(r5) + ", visibleSize=" + hu5.a.c(r0));
    L5:
        V r6 = this.d;
        if (hu5.a.f(r0) == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        r6.l6(r1);
        this.d.j4(this.c.hasMore());
        this.d.l0(r0);
        return;
    L8:
        if (this.c.hasMore() == true) goto L11;
        r1 = false;
        goto L12
    }

    public final void setModel(IModel r2) {
        M r3 = (M) r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
    }

    public final void setView(IView r2) {
        V r3 = (V) r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.d = r3;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void N8(Document r13, int r14) {
        super.N8(r13, r14);
        if (r13 == null) goto L6;
        lc5.q r15 = new lc5.q("ccm_space_shared_page_click", "shared", "shared_folder", "", r13.d, r13.getType(), r13.F, FolderVersion.isShareFolder(r13.L1, r13.P1), false, 0, com.bytedance.ee.bear.list.t0.m(r13));
        ce5.a r16 = this.g;
        lc5.f.a r0 = lc5.f.a;
        lc5.f.a.K(r15, r16);
        return;
    }

    public o3(LifeCycleFragment r1, Context r2, BaseBannerModel r3, com.bytedance.ee.bear.list.homepage.banner.c r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
        this.g = r5;
    }
}
