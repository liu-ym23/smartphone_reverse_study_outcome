package od5;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.pinview.PinDocumentListStyleAdapter;
import com.bytedance.ee.bear.list.star.FavoriteItemDiffCallback;
import dd5.m1;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class m extends com.bytedance.ee.bear.list.list.c<b.a> implements b, m1 {
    public AnimatorSet E;

    public String B3() {
        return "ccm_space_home_page_click";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean H2(Document r1) {
        return false;
    }

    @Override // dd5.m1
    public final void Jl() {
        d2(null);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public String S1() {
        return "home";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return null;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String h2() {
        return "quick_access";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "PinView";
    }

    public com.bytedance.ee.bear.list.list.d F3() {
        if (this.f == false) goto L6;
        return new GridStyleAdapter("quick_access", this.D);
    L6:
        return new PinDocumentListStyleAdapter(this.z, this.p, this.D);
    }

    public void I3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1(), "quick_access", null, null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "quick_access");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        tt5.a.h("PinView", "getAdapter()...");
        this.q = null;
        com.bytedance.ee.bear.list.list.d r0 = F3();
        U2(r0);
        s2(r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.PIN);
        this.k.e(new l(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public void B2() {
        super.B2();
        if ((this.d.getParentFragment() instanceof wc5.c) == false) goto L5;
        this.j = this.d.getParentFragment().xZ();
    L5:
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void destroy() {
        super.destroy();
        tt5.a.h("PinView", "destroy()...");
        AnimatorSet r0 = this.E;
        if (r0 == null) goto L6;
        r0.cancel();
        this.E = null;
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h("PinView", "setUserVisibleHint()...isVisibleToUser = " + r3);
        if (r3 == true) goto L5;
        return;
    L5:
        if ((this.d.getParentFragment() instanceof wc5.c) == false) goto L7;
        this.j = this.d.getParentFragment().xZ();
    L7:
        z2();
        I3();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FavoriteItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r2, int r3) {
        com.bytedance.ee.bear.list.list.c.q2();
        if ((this.d.getParentFragment() instanceof wc5.d) == false) goto L6;
        this.d.getParentFragment().t(r2, r3);
        return;
    }

    public final void onItemDragEnd(RecyclerView.ViewHolder r1, int r2) {
        tt5.a.h("PinView", "onItemDragEnd()...");
    }

    public final void onItemDragStart(RecyclerView.ViewHolder r1, int r2) {
        tt5.a.h("PinView", "onItemDragStart()...");
    }

    public m(Context r1, View r2, LifeCycleFragment r3, ce5.a r4) {
        super(r1, r2, r3, r4);
        this.E = new AnimatorSet();
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r14, int r15, Document r16, boolean r17) {
        super.Y(r14, r15, r16, r17);
        lc5.f.j(new lc5.p(S1(), "quick_access", "more", "ccm_space_right_click_menu_view", "quick_access", r16.d, r16.getType(), r16.F, Boolean.valueOf(C2()), "suspend_create", B3()));
    }

    public final void onItemDragMoving(RecyclerView.ViewHolder r1, int r2, RecyclerView.ViewHolder r3, int r4) {
        tt5.a.h("PinView", "onItemDragMoving()...");
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r16, int r17, Document r18, boolean r19) {
        tt5.a.h("PinView", "onRightSlideMenuClick()...position = " + r17);
        ((b.a) this.e).L2(r18);
        String r4 = S1();
        if (r18.L == false) goto L5;
        String r3 = "remove_from_quickaccess";
    L6:
        lc5.f.j(new lc5.p(r4, "quick_access", r3, "none", "quick_access", r18.d, r18.getType(), r18.F, Boolean.valueOf(C2()), "suspend_create", "ccm_space_home_page_click"));
        return;
    L5:
        r3 = "add_to_quickaccess";
        goto L6
    }
}
