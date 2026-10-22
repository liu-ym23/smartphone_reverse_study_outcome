package od5;

import android.content.Context;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.i0;
import com.bytedance.ee.bear.list.n0;
import com.bytedance.ee.bear.list.o0;
import com.bytedance.ee.bear.list.p0;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.route.RouteBean;
import dd5.h1;
import io.reactivex.Flowable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class e extends com.bytedance.ee.bear.list.list.b<com.bytedance.ee.bear.list.list.e, b, b.a> implements b.a, h1 {
    @Override // com.bytedance.ee.bear.list.list.b
    public String J8() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "quick_access";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "PinDocumentPresenter";
    }

    public String e9() {
        return "ccm_space_home_page_click";
    }

    public String f9() {
        return "";
    }

    public String g9() {
        return "";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public String K8() {
        return AnalyticConstant.OpenType.HOME_CREATE_PIN.getType();
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        tt5.a.h("PinDocumentPresenter", "create()...");
    }

    @Override // od5.b.a
    public final void L2(final Document r9) {
        tt5.a.h("PinDocumentPresenter", "onPinClick()...");
        String r4 = getSource();
        lc5.f.a(new lc5.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r4, "quick_access", "pin", r9));
        Flowable.just("").subscribeOn(fo5.d.b()).map(new n0()).map(new o0(r9)).subscribe(new i0(), new p0());
    }

    public RouteBean d9(Document r17) {
        e0 r7 = new e0(this.a, r17, J8(), I8(), "quick_access", "");
        Context r10 = r7.getContext();
        Document r0 = r7.b;
        String r12 = r7.c;
        List r13 = r7.d;
        String r14 = r7.e;
        String r15 = r7.f;
        if (r0.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r10, r12, 1, "");
    L13:
        return r1.a(r0);
    L6:
        if (r0.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new e0(r10, r0, r12, r13, r14, r15), "");
        goto L13
    L9:
        if (r0.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L13
    L11:
        r1 = new sd5.a(r10);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r14) {
        super.u8(r14);
        lc5.f.j(new lc5.p(J8(), "quick_access", "share", "ccm_permission_share_view", "quick_access", r14.d, r14.getType(), r14.F, Boolean.valueOf(hu5.a.d(((b) getView()).G())), "suspend_create", "ccm_space_home_page_click"));
    }

    @Override // dd5.h1
    public final void X2(String r1, String r2) {
        tt5.a.h("PinDocumentPresenter", "onListItemMoved()...");
        onRefresh();
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public void h3(Document r30, int r31, boolean r32) {
        tt5.a.h("PinDocumentPresenter", "onItemClick()...doc = " + r30.toString());
        t0.r(new v0(this.b.getActivity(), r30, Q8(), d9(r30), J8(), "quick_access", K8(), r31, r32, 0), this.x);
        lc5.q r1 = new lc5.q(e9(), J8(), "quick_access", "quick_access", "", r30.d, r30.getType(), r30.F, FolderVersion.isShareFolder(r30.L1, r30.P1), false, 0, t0.m(r30), f9(), g9());
        ce5.a r2 = this.x;
        lc5.f.a r3 = lc5.f.a;
        lc5.f.a.K(r1, r2);
    }

    public e(m r1, d r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
    }
}
