package com.bytedance.ee.bear.list.share;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ y c;

    public w(y r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r26) {
        y r1 = this.c;
        r1.getClass();
        tt5.a.h("HistorySharedFolderView", "onMenuCreateClick()...");
        FragmentActivity r3 = r1.d.getActivity();
        if (r1.I != null) goto L6;
        r1.I = new com.bytedance.ee.bear.list.create.x0();
    L6:
        if (r1.I.a(r3) == false) goto L8;
        tt5.a.h("HistorySharedFolderView", "create menu is already showing");
        return;
    L8:
        iw4.h r2 = new iw4.h();
        r2.b = "shared";
        r2.c = "shared_folder";
        qc5.a.j();
        r2.g = true;
        if (r1.I != null) goto L11;
        r1.I = new com.bytedance.ee.bear.list.create.x0();
    L11:
        com.bytedance.ee.bear.list.create.x0 r5 = r1.I;
        boolean r6 = ((ww4.a) org.koin.java.a.a(ww4.a.class)).a().d().a;
        SelectCreationMenuConfig r7 = new SelectCreationMenuConfig();
        r7.l = com.bytedance.ee.bear.list.t0.s();
        r7.o = true;
        r7.p = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.docx_create_enable");
        r7.k = true;
        r7.n = r6;
        r7.d = false;
        r7.f = false;
        r7.g = false;
        r5.c(r3, r2, r7, null);
        lc5.p r4 = new lc5.p("ccm_space_folder_click", "shared", "shared_folder", "create", "ccm_space_create_new_view", "", sbb.e.f.b, "", "", true, true, false, 0, Boolean.valueOf(r1.C2()), "suspend_create", null);
        lc5.f.a.I(r4);
    }
}
