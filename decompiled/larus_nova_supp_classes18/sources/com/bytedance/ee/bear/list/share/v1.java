package com.bytedance.ee.bear.list.share;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v1 extends o3 {
    @Override // com.bytedance.ee.bear.list.share.o3, com.bytedance.ee.bear.list.homepage.banner.a
    public final String L8() {
        return "NewSharedBannerPresenter";
    }

    @Override // com.bytedance.ee.bear.list.share.o3, com.bytedance.ee.bear.list.homepage.banner.a
    public final void I8() {
        lc5.p r15 = new lc5.p("ccm_space_shared_page_click", "shared", "shared_folder", "all", "ccm_space_header_filter_view", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        lc5.f.a.I(r15);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/list/share/activity").l("show_new_share_folders", true).e();
    }

    @Override // com.bytedance.ee.bear.list.share.o3, com.bytedance.ee.bear.list.homepage.banner.a
    public final void O8(ArrayList<Document> r2) {
        super.O8(r2);
        this.d.l6(true);
        this.d.j4(true);
    }

    public v1(LifeCycleFragment r1, Context r2, u1 r3, com.bytedance.ee.bear.list.homepage.banner.c r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
