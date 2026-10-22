package gc5;

import com.bytedance.ee.bear.list.ainote.AINoteFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements xc5.b.InterfaceC8214b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteFragment f480824a;

    public b(AINoteFragment r100) {
        this.f480824a = r100;
    }

    @Override // xc5.b.InterfaceC8214b
    public final void a(int r110) {
        tt5.a.h("AINoteFragment", "onTabSelected()...index = " + r110);
        AINoteFragment r100 = this.f480824a;
        if (r100.f227606o != r110) goto L5;
        return;
    L5:
        HomeViewPager r101 = r100.f227605n;
        if (r101 == null) goto L8;
        r101.setCurrentItem(r110, false);
    L8:
        AINoteFragment r102 = this.f480824a;
        r102.f227606o = r110;
        lc5.f.a r103 = lc5.f.f508440a;
        lc5.p r104 = new lc5.p("ai_notes", "", "sub_tab", "", "", "ccm_space_ai_notes_click");
        if (r110 != 0) goto L11;
        String r111 = "mine";
    L15:
        r103.l(r104, com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r111, r102.f227607p);
        return;
    L11:
        if (r110 == 1) goto L13;
        r111 = "share";
        goto L15
    L13:
        r111 = "participate";
        goto L15
    }
}
