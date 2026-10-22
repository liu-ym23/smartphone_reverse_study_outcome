package jd5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.IModel;
import com.larksuite.framework.mvp.IView;
import dd5.g1;
import dd5.s1;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.list.homepage.banner.a<com.bytedance.ee.bear.list.homepage.banner.f, com.bytedance.ee.bear.list.homepage.banner.g<com.bytedance.ee.bear.list.homepage.banner.g.a>, com.bytedance.ee.bear.list.homepage.banner.g.a> implements g1 {
    public final ce5.a g;

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String J8() {
        return WikiSpaceType.PERSONAL;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String K8() {
        return "personal_folder";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final String M8() {
        return "";
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void I8() {
        lc5.p r15 = new lc5.p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "personal_folder", "all", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r15);
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/list/folder/activity");
        r0.i("current_module", "personal_folder");
        r0.i(ResourceData.KEY_TOKEN, "");
        r0.i("title", getContext().getString(2131887934));
        r0.i(ResourceData.KEY_TYPE, String.valueOf(sbb.e.f.b));
        r0.l("is_personal_folder", true);
        r0.e();
    }

    @Override // dd5.g1
    public final void Q2() {
        ((com.bytedance.ee.bear.list.homepage.banner.f) getModel()).m5();
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void create() {
        super.create();
        s1.a.a.a(this);
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void destroy() {
        super.destroy();
        s1.a.a.h(this);
    }

    public final IModel getModel() {
        return this.c;
    }

    public final IView getView() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.list.homepage.banner.a
    public final void O8(ArrayList<Document> r3) {
        super.O8(r3);
        ArrayList<Document> r4 = dd5.a.a(r3, this.e.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        V r0 = this.d;
        if (hu5.a.d(r4) == true) goto L7;
        boolean r1 = true;
        if (r4.size() <= 1) goto L7;
    L8:
        r0.j4(r1);
        return;
    L7:
        r1 = false;
        goto L8
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
        lc5.q r15 = new lc5.q("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "personal_folder", "", r13.d, r13.getType(), r13.F, FolderVersion.isShareFolder(r13.L1, r13.P1), false, 0, t0.m(r13));
        ce5.a r16 = this.g;
        lc5.f.a r0 = lc5.f.a;
        lc5.f.a.K(r15, r16);
        return;
    }

    public d(LifeCycleFragment r1, Context r2, c r3, com.bytedance.ee.bear.list.homepage.banner.c r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
        this.g = r5;
    }
}
