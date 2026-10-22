package com.bytedance.ee.bear.list.mine;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.c;
import com.bytedance.ee.bear.list.list.d;
import com.bytedance.ee.bear.list.list.f;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.loadstateview.h;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import dd5.d1;
import java.util.List;
import jd5.k;
import jd5.r0;
import lc5.p;
import sbb.e;
import wc5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends c<f.a> implements k {
    public final b E;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.mine.a$a, reason: collision with other inner class name */
    public class C0021a implements LoadStateView.a {
        public final /* synthetic */ a a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            b r0 = this.a.E;
            if (r0 == null) goto L15;
            MyDocumentFragment r1 = (MyDocumentFragment) r0;
            if (r1.getParentFragment() == null) goto L12;
            if (r1.getParentFragment().getParentFragment() == null) goto L12;
            if ((r1.getParentFragment().getParentFragment() instanceof g) == false) goto L12;
            r1.getParentFragment().getParentFragment().onMenuCreateClick(null);
        L12:
            if ((r1.getActivity() instanceof g) == false) goto L16;
            r1.getActivity().onMenuCreateClick(null);
            return;
        L16:
            return;
        }

        public C0021a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
            d();
        }
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        return WikiSpaceType.PERSONAL;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return "mine";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String h2() {
        return "belongtome";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "MyDocumentView";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final d n1() {
        this.q = null;
        d r0 = d1.a("belongtome", this.f, this.d, this.D);
        if (r0 == null) goto L7;
        U2(r0);
        s2(r0);
        return r0;
    L7:
        if (this.f == false) goto L9;
        d r1 = new GridStyleAdapter("belongtome", this.D);
    L10:
        U2(r1);
        s2(r1);
        return r1;
    L9:
        r1 = new MyDocumentListStyleAdapter(this.z, this.p, this.D);
        goto L10
    }

    public final void B3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), WikiSpaceType.PERSONAL, "belongtome", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), "belongtome");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        h r1 = new h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.MY_SPACE_NORMAL);
        this.k.e(new r0(this));
        this.k.d(new C0021a(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void create() {
        super.create();
        B3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void onResume() {
        super.onResume();
        lc5.f.a.M("ccm_space_personal_page_view", WikiSpaceType.PERSONAL, "belongtome", "");
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r2) {
        super.P2(r2);
        if (r2.getType() == FilterType.ALL.getType()) goto L5;
        this.k.f(EmptyCategory.MY_SPACE_FILTER);
        return;
    L5:
        this.k.f(EmptyCategory.MY_SPACE_NORMAL);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r2) {
        super.d2(r2);
        b r3 = this.E;
        if (r3 == null) goto L8;
        MyDocumentFragment r4 = (MyDocumentFragment) r3;
        if ((r4.getParentFragment() instanceof wc5.d) == false) goto L9;
        r4.getParentFragment().Cu();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L6;
        B3();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new MyDocumentItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r3, int r4) {
        c.q2();
        b r0 = this.E;
        if (r0 == null) goto L8;
        MyDocumentFragment r1 = (MyDocumentFragment) r0;
        if ((r1.getParentFragment() instanceof wc5.d) == false) goto L9;
        r1.getParentFragment().t(r3, r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k1(int r1, boolean r2) {
        super.k1(r1, r2);
        if (this.D.d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L5;
        return;
    L5:
        if (hu5.a.d(G()) == false) goto L9;
        this.k.g();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r6 = r22.d;
        int r7 = r22.getType();
        String r8 = r22.F;
        if (r22.getType() != e.f.b) goto L5;
        boolean r10 = true;
    L6:
        boolean r11 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        Boolean r14 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r16 = "middle";
    L10:
        p r15 = new p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "belongtome", "more", "ccm_space_right_click_menu_view", r6, r7, r8, "", r10, r11, false, 0, r14, r16, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r16 = "suspend_create";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r6 = r22.d;
        int r7 = r22.getType();
        String r8 = r22.F;
        if (r22.getType() != e.f.b) goto L5;
        boolean r10 = true;
    L6:
        boolean r11 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        Boolean r14 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r16 = "middle";
    L10:
        p r15 = new p("ccm_space_personal_page_click", WikiSpaceType.PERSONAL, "belongtome", "delete", "ccm_space_delete_view", r6, r7, r8, "", r10, r11, false, 0, r14, r16, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r16 = "suspend_create";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public a(Context r1, View r2, LifeCycleFragment r3, b r4, ce5.a r5) {
        super(r1, r2, r3, r5);
        this.E = r4;
    }
}
