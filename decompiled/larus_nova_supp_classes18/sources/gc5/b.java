package gc5;

import com.bytedance.ee.bear.list.ainote.AINoteFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements xc5.b.InterfaceC0330b {
    public final /* synthetic */ AINoteFragment a;

    public b(AINoteFragment r1) {
        this.a = r1;
    }

    @Override // xc5.b.InterfaceC0330b
    public final void a(int r11) {
        tt5.a.h("AINoteFragment", "onTabSelected()...index = " + r11);
        AINoteFragment r0 = this.a;
        if (r0.o != r11) goto L5;
        return;
    L5:
        HomeViewPager r1 = r0.n;
        if (r1 == null) goto L8;
        r1.setCurrentItem(r11, false);
    L8:
        AINoteFragment r2 = this.a;
        r2.o = r11;
        lc5.f.a r3 = lc5.f.a;
        lc5.p r9 = new lc5.p("ai_notes", "", "sub_tab", "", "", "ccm_space_ai_notes_click");
        if (r11 != 0) goto L11;
        String r12 = "mine";
    L15:
        r3.l(r9, "tab_name", r12, r2.p);
        return;
    L11:
        if (r11 == 1) goto L13;
        r12 = "share";
        goto L15
    L13:
        r12 = "participate";
        goto L15
    }
}
