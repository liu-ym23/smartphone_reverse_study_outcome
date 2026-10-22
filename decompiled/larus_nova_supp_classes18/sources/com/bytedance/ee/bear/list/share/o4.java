package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.route.RouteBean;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o4 extends com.bytedance.ee.bear.list.list.b<o0, p0, p0.a> implements p0.a {
    public final String A;
    public final String B;
    public final com.bytedance.ee.bear.list.office.preload.f C;
    public boolean D;
    public SortAndFilterViewModel y;
    public Disposable z;

    public class a implements com.bytedance.ee.bear.list.office.preload.f.a {
        public final /* synthetic */ o4 a;

        public a(o4 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.office.preload.f.a
        public final void a(ArrayList<Document> r3) {
            o4 r0 = this.a;
            r0.D = true;
            r0.c9(r3);
        }
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String J8() {
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String L8() {
        return "sharetome";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "SharedPresenter";
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final String K8() {
        return AnalyticConstant.OpenType.SHARED_SHARE_TOME.getType();
    }

    public final void e9() {
        if (this.b.getActivity() != null) goto L6;
        tt5.a.d("SharedPresenter", "observeSortAndFilter()...activity is null");
    L9:
        Disposable r0 = ((o0) getModel()).R().subscribe(new k4(this), new l4());
        this.t.add(r0);
        tt5.a.h("SharedPresenter", "create()...");
        return;
    L6:
        if (this.y != null) goto L8;
        this.y = (SortAndFilterViewModel) ViewModelProviders.of(this.b.getActivity()).get(SortAndFilterViewModel.class);
    L8:
        this.y.getSortStrategyLiveData().observe(this.b, new j4(this));
        goto L9
    }

    @Override // com.bytedance.ee.bear.list.list.b
    public final void create() {
        H8();
        if (this.C.a(this.A, this.B, new a(this)) == false) goto L6;
        e9();
        return;
    L6:
        b9();
        e9();
    }

    public static void d9(o4 r2) {
        r2.getClass();
        tt5.a.h("SharedPresenter", "office_space_preload_visible_refresh tab=" + r2.B + " reason=after_cache_first_draw");
        ((o0) r2.getModel()).r2();
    }

    @Override // com.bytedance.ee.bear.list.share.p0.a
    public final void D(Document r4) {
        com.bytedance.ee.bear.list.t0.z(this.b.getActivity(), r4, "shared", getSource());
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.f.a
    public final void u8(Document r20) {
        super.u8(r20);
        String r7 = r20.d;
        int r8 = r20.getType();
        String r9 = r20.F;
        if (r20.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_shared_page_click", "shared", "sharetome", "share", "ccm_permission_share_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r20.L1, r20.P1), false, 0, Boolean.valueOf(O8()), "suspend_create", com.bytedance.ee.bear.list.t0.m(r20));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.f.a
    public final void h3(Document r27, int r28, boolean r29) {
        tt5.a.h("SharedPresenter", "onItemClick()...doc = " + r27.toString());
        FragmentActivity r8 = this.b.getActivity();
        boolean r9 = Q8();
        Context r2 = this.a;
        List<Document> r14 = I8();
        Context r3 = new com.bytedance.ee.bear.contract.e0(r2, r27, "shared", r14, "sharetome", "home").getContext();
        if (r27.getType() != sbb.e.f.b) goto L6;
        sd5.e r1 = new sd5.c(r3, "shared", 1, "");
    L12:
        RouteBean r5 = r1.a(r27);
        r5.a(this.b);
        com.bytedance.ee.bear.list.t0.r(new com.bytedance.ee.bear.list.v0(r8, r27, r9, r5, "shared", "sharetome", K8(), r28, r29, 0), this.x);
        lc5.q r4 = new lc5.q("ccm_space_shared_page_click", "shared", "sharetome", "", r27.d, r27.getType(), r27.F, FolderVersion.isShareFolder(r27.L1, r27.P1), false, 0, com.bytedance.ee.bear.list.t0.m(r27));
        ce5.a r6 = this.x;
        lc5.f.a r7 = lc5.f.a;
        lc5.f.a.K(r4, r6);
        return;
    L6:
        if (r27.getType() != sbb.e.l.b) goto L9;
        r1 = new sd5.b(new com.bytedance.ee.bear.contract.e0(r3, r27, "shared", r14, "sharetome", "home"), "");
        goto L12
    L9:
        if (r27.getType() != sbb.e.n.b) goto L11;
        r1 = new sd5.g();
        goto L12
    L11:
        r1 = new sd5.a(r3);
        goto L12
    }

    public o4(p0 r1, i4 r2, Context r3, LifeCycleFragment r4, ce5.a r5, String r6, String r7) {
        super(r1, r2, r3, r4, r5);
        this.C = new com.bytedance.ee.bear.list.office.preload.f();
        this.A = r6;
        if (TextUtils.isEmpty(r7) == false) goto L5;
        r7 = "SHARED";
    L5:
        this.B = r7;
    }
}
