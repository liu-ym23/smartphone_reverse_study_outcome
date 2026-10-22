package com.bytedance.ee.bear.list.share;

import android.view.View;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ y c;

    public x(y r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r21) {
        y r1 = this.c;
        r1.getClass();
        tt5.a.h("HistorySharedFolderView", "onSearchClick()...");
        com.bytedance.ee.bear.list.t0.B(r1.E.getTitleSnapshot());
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/search/space_search/activity").j("KEY_SEARCH_BAR_DY", r1.E.getTitleBarHeight()).j("KEY_SEARCH_PAGE_TYPE", 1).i("KEY_FOLDER_TOKEN", "").g(2130772285, 2130772285).i("module", "shared").e();
        lc5.p r2 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", ThumbGlideUrl.SOURCE_SEARCH, "search_main_view", "", sbb.e.f.b, "", "", true, true, false, 0, Boolean.valueOf(r1.C2()), "suspend_create", null);
        lc5.f.a.I(r2);
    }
}
