package com.bytedance.ee.bear.list.star;

import ae5.d;
import ae5.e;
import ae5.m;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.e0;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.office.preload.f;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.v0;
import com.bytedance.ee.bear.route.RouteBean;
import dd5.h1;
import dd5.o1;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import lc5.p;
import lc5.q;
import sd5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends com.bytedance.ee.bear.list.list.b<m, c, c.a> implements o1, h1, c.a {
    public final String A;
    public final String B;
    public final f C;
    public boolean D;
    public SortAndFilterViewModel y;
    public Disposable z;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.star.a$a, reason: collision with other inner class name */
    public class C0036a implements f.a {
        public final /* synthetic */ a a;

        public C0036a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.office.preload.f.a
        public final void a(ArrayList<Document> r3) {
            a r0 = this.a;
            r0.D = true;
            r0.c9(r3);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return "favorites";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "FavoritePresenter";
    }

    public String g9() {
        return "ccm_space_favorites_page_click";
    }

    public String h9() {
        return "";
    }

    public String i9() {
        return "";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public String K8() {
        return AnalyticConstant.OpenType.FAVORITES.getType();
    }

    @Override // dd5.o1
    public final void Z2() {
        tt5.a.h("FavoritePresenter", "onStarItemSuccess()...");
        onRefresh();
    }

    public final void f9() {
        if (this.b.getActivity() != null) goto L6;
        tt5.a.d("FavoritePresenter", "observeSortAndFilter()...activity is null");
    L9:
        tt5.a.h("FavoritePresenter", "create()...");
        return;
    L6:
        if (this.y != null) goto L8;
        this.y = (SortAndFilterViewModel) ViewModelProviders.of(this.b.getActivity()).get(SortAndFilterViewModel.class);
    L8:
        this.y.getSortStrategyLiveData().observe(this.b, new e(this));
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        H8();
        if (this.C.a(this.A, this.B, new C0036a(this)) == false) goto L6;
        f9();
        return;
    L6:
        b9();
        f9();
    }

    public static void d9(a r2) {
        r2.getClass();
        tt5.a.h("FavoritePresenter", "office_space_preload_visible_refresh tab=" + r2.B + " reason=after_cache_first_draw");
        ((m) r2.getModel()).r2();
    }

    @Override // com.bytedance.ee.bear.list.star.c.a
    public final void D(Document r4) {
        tt5.a.h("FavoritePresenter", "onStarClick()...");
        t0.z(this.b.getActivity(), r4, "favorites", getSource());
    }

    public RouteBean e9(Document r17) {
        e0 r7 = new e0(this.a, r17, "favorites", I8(), "none", "home");
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
        r1 = new g();
        goto L13
    L11:
        r1 = new sd5.a(r10);
        goto L13
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r2 = g9();
        String r7 = r20.d;
        int r8 = r20.getType();
        String r9 = r20.F;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        p r12 = new p(r2, "favorites", "none", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // dd5.h1
    public final void X2(String r1, String r2) {
        tt5.a.h("FavoritePresenter", "onListItemMoved()...");
        onRefresh();
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public void h3(Document r30, int r31, boolean r32) {
        tt5.a.h("FavoritePresenter", "onItemClick()...doc = " + r30.toString());
        FragmentActivity r2 = this.b.getActivity();
        boolean r4 = Q8();
        RouteBean r5 = e9(r30);
        r5.a(this.b);
        t0.r(new v0(r2, r30, r4, r5, "favorites", "none", K8(), r31, r32, 0), this.x);
        q r1 = new q(g9(), "favorites", "none", "", "", r30.d, r30.getType(), r30.F, FolderVersion.isShareFolder(r30.L1, r30.P1), false, 0, t0.m(r30), h9(), i9());
        ce5.a r3 = this.x;
        lc5.f.a r6 = lc5.f.a;
        lc5.f.a.K(r1, r3);
    }

    public a(c r1, d r2, Context r3, LifeCycleFragment r4, ce5.a r5, String r6, String r7) {
        super(r1, r2, r3, r4, r5);
        this.C = new f();
        this.A = r6;
        if (TextUtils.isEmpty(r7) == false) goto L5;
        r7 = "FAVORITE";
    L5:
        this.B = r7;
    }
}
