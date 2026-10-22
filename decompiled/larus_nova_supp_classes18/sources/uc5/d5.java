package uc5;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d5 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ com.bytedance.ee.bear.list.folder.i c;

    public d5(com.bytedance.ee.bear.list.folder.i r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r22) {
        com.bytedance.ee.bear.list.folder.i r1 = this.c;
        r1.getClass();
        tt5.a.h("SubFolderView", "onSearchClick()...");
        if (TextUtils.isEmpty(r1.M) == false) goto L5;
        int r2 = 1;
    L6:
        com.bytedance.ee.bear.list.t0.B(r1.G.getTitleSnapshot());
        String r5 = r1.M;
        String r6 = r1.N;
        Document r7 = r1.V;
        if (r7 == null) goto L9;
        boolean r8 = FolderVersion.isShareFolder(r7.L1, r7.P1);
    L10:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/search/space_search/activity").j("KEY_SEARCH_BAR_DY", r1.G.getTitleBarHeight()).j("KEY_SEARCH_PAGE_TYPE", r2).i("KEY_FOLDER_TOKEN", r1.M).i("KEY_FOLDER_INFO", GsonProtectorUtils.toJson(new Gson(), new com.bytedance.ee.bear.search.a(r5, r6, r8))).g(2130772285, 2130772285).i("module", r1.S1()).e();
        String r9 = r1.S1();
        String r13 = r1.M;
        int r11 = sbb.e.f.b;
        boolean r15 = !r1.Q;
        boolean r16 = !TextUtils.isEmpty(r13);
        int r3 = r1.T;
        Boolean r18 = Boolean.valueOf(r1.C2());
        if (r1.C2() == false) goto L13;
        String r4 = "middle";
    L14:
        lc5.f.a.I(new lc5.p("ccm_space_folder_click", r9, "none", ThumbGlideUrl.SOURCE_SEARCH, "search_main_view", r13, r11, "", r13, true, r15, r16, r3, r18, r4, null));
        return;
    L13:
        r4 = "suspend_create";
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }
}
