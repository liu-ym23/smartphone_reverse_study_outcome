package gc5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderDetailItemDiffCallback;
import com.bytedance.ee.bear.list.folder.MyRootFolderListStyleAdapter;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.loadstateview.EmptyCategory;
import com.bytedance.ee.bear.list.loadstateview.LoadStateView;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.t0;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends com.bytedance.ee.bear.list.list.c<com.bytedance.ee.bear.list.folder.d.a> implements com.bytedance.ee.bear.list.folder.d {
    public final c E;
    public final String F;
    public final String G;

    public class a extends MyRootFolderListStyleAdapter {
        public final /* synthetic */ v o;

        @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
        public final void B2(ListStyleViewHolder r1, int r2, Document r3) {
            super.B2(r1, r2, r3);
            if (r1.j != null) goto L5;
            return;
        L5:
            if (TextUtils.equals(this.o.F, "owned_by_me") == true) goto L9;
            r1.j.setVisibility(8);
            return;
        }

        public a(v r7, String r8, String r9, DocsLinearLayoutManager r10, ce5.a r11, LifeCycleFragment r12) {
            this.o = r7;
            super(r8, r9, r10, r11, r12);
        }
    }

    public class b implements LoadStateView.a {
        public final /* synthetic */ v a;

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void c() {
        }

        public final void d() {
            tt5.a.h("AINotesListView", "onMasterButtonTouchEvent()...");
            if (t.a(this.a.g) != FilterType.AI_NOTE_RECORD_NOTE) goto L5;
            v.B3(this.a, "start_record");
            tt5.a.h("AINotesListView", "onMasterButtonTouchEvent()...click record");
            StringBuilder r1 = new StringBuilder(jcb.b.c().a("applink") + "/minutes/newaudiorecord");
            r1.append("?fromsource=ccm_ai_note");
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r1.toString());
            return;
        L5:
            tt5.a.h("AINotesListView", "onMasterButtonTouchEvent()...click video chat");
            v.B3(this.a, "start_meeting");
            StringBuilder r2 = new StringBuilder(jcb.b.c().a("applink") + "/client/videochat/open");
            r2.append("?source=ccm_ai_note");
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r2.toString());
        }

        public b(v r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.a
        public final void b(View r1) {
            d();
        }
    }

    public interface c {
        void onRefresh();

        void t(int r1, int r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String i2() {
        return "AINotesListView";
    }

    @Override // com.bytedance.ee.bear.list.folder.d
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final com.bytedance.ee.bear.list.list.d n1() {
        this.q = null;
        if (this.f == false) goto L5;
        com.bytedance.ee.bear.list.list.d r0 = new GridStyleAdapter(S1(), this.D);
    L6:
        U2(r0);
        s2(r0);
        return r0;
    L5:
        r0 = new a(this, S1(), this.z, this.p, this.D, this.d);
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.folder.d
    public final boolean x() {
        return false;
    }

    public final void F3() {
        lc5.f.r((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1(), "none", "home", null);
        lc5.f.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), S1());
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String S1() {
        if (TextUtils.equals(this.F, "owned_by_me") == false) goto L6;
        return "ai_note_owned_by_me";
    L6:
        if (TextUtils.equals(this.F, "my_involved") == false) goto L10;
        return "ai_note_my_involved";
    L10:
        if (TextUtils.equals(this.F, "ai_share_with_me") == false) goto L13;
        return "ai_note_share_with_me";
    L13:
        return "ai_note_owned_by_me";
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void x2() {
        com.bytedance.ee.bear.list.loadstateview.h r1 = new com.bytedance.ee.bear.list.loadstateview.h((LoadStateView) this.c.findViewById(2131378179));
        this.k = r1;
        r1.a(EmptyCategory.AI_MEETING_NOTE);
        I3(this.g);
        this.k.e(new u(this));
        this.k.d(new b(this));
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final boolean E2() {
        if (ForsetiHelper.n() == false) goto L13;
        LifeCycleFragment r0 = this.d;
        if (r0 == null) goto L13;
        if (r0.getParentFragment() == null) goto L13;
        if (this.d.getParentFragment().getParentFragment() == null) goto L13;
        if ((this.d.getParentFragment().getParentFragment() instanceof wc5.h) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void create() {
        super.create();
        F3();
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void j0() {
        super.j0();
        d2(null);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final String Z1() {
        return this.F;
    }

    public final void I3(FolderSortStrategy r2) {
        FilterType r3 = t.a(r2);
        if (r3 != FilterType.AI_NOTE_MEETING_NOTE) goto L6;
        this.k.f(EmptyCategory.AI_MEETING_NOTE);
        return;
    L6:
        if (r3 != FilterType.AI_NOTE_MONTHLY_SUMMARY) goto L9;
        this.k.f(EmptyCategory.AI_MONTHLY);
        return;
    L9:
        if (r3 != FilterType.AI_NOTE_WEEKLY_RECAP) goto L12;
        this.k.f(EmptyCategory.AI_WEEKLY);
        return;
    L12:
        if (r3 != FilterType.AI_NOTE_RECORD_NOTE) goto L14;
        this.k.f(EmptyCategory.AI_RECORD_NOTE);
        return;
    L14:
        this.k.f(EmptyCategory.AI_MEETING_NOTE);
    }

    public final void J3(SmartRefreshLayout r3) {
        tt5.a.h("AINotesListView", "setRefreshLayout()...refreshLayout = " + r3);
        this.j = r3;
        z2();
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void P2(FolderSortStrategy r1) {
        super.P2(r1);
        I3(r1);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final void d2(cqa.h r1) {
        super.d2(r1);
        c r2 = this.E;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, pc5.i.c
    public final void k(rf5.d r2) {
        ((com.bytedance.ee.bear.list.folder.d.a) this.e).k(r2);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == false) goto L6;
        F3();
        return;
    }

    public static void B3(v r18, String r19) {
        r18.getClass();
        lc5.p r15 = new lc5.p("ccm_space_ai_notes_click", r18.S1(), "none", r19, "", "", sbb.e.o.b, "", "", false, false, false, 0, null, "", null);
        String r0 = r18.G;
        lc5.f.a.l(r15, null, null, r0);
    }

    @Override // com.bytedance.ee.bear.list.list.c
    public final DiffUtil.Callback Q1(List<Document> r2, List<Document> r3) {
        return new FolderDetailItemDiffCallback(r2, r3);
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.widgets.BaseRecyclerView.a
    public final void T(int r2, int r3) {
        com.bytedance.ee.bear.list.list.c.q2();
        c r0 = this.E;
        if (r0 == null) goto L6;
        r0.t(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.f
    public final void k1(int r1, boolean r2) {
        super.k1(r1, r2);
        if (this.D.d.isCurrentEnable("ccm.mobile.space_loading_after_db") == false) goto L5;
        return;
    L5:
        if (hu5.a.d(G()) == false) goto L9;
        I3(this.g);
        this.k.g();
        return;
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void P(View r20, int r21, Document r22) {
        super.P(r20, r21, r22);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_ai_notes_click", r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r20, int r21, Document r22, boolean r23) {
        super.Y(r20, r21, r22, r23);
        String r3 = S1();
        String r7 = r22.d;
        int r8 = r22.getType();
        String r9 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r18 = true;
    L6:
        boolean r11 = r18;
        lc5.p r12 = new lc5.p("ccm_space_ai_notes_click", r3, "none", "more", "ccm_space_right_click_menu_view", r7, r8, r9, "", r11, FolderVersion.isShareFolder(r22.L1, r22.P1), false, 0, Boolean.valueOf(C2()), "suspend_create", t0.m(r22));
        lc5.f.a.I(r12);
        return;
    L5:
        r18 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.list.list.c, com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r20, int r21, Document r22, boolean r23) {
        super.x0(r20, r21, r22, r23);
        String r2 = S1();
        String r6 = r22.d;
        int r7 = r22.getType();
        String r8 = r22.F;
        if (r22.getType() != sbb.e.f.b) goto L5;
        boolean r10 = true;
    L6:
        boolean r11 = FolderVersion.isShareFolder(r22.L1, r22.P1);
        Boolean r14 = Boolean.valueOf(C2());
        if (C2() == false) goto L9;
        String r16 = "middle";
    L10:
        lc5.p r15 = new lc5.p("ccm_space_ai_notes_click", r2, "none", "delete", "ccm_space_delete_view", r6, r7, r8, "", r10, r11, false, 0, r14, r16, t0.m(r22));
        lc5.f.a.I(r15);
        return;
    L9:
        r16 = "suspend_create";
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public v(Context r1, View r2, LifeCycleFragment r3, c r4, ce5.a r5, String r6, String r7) {
        super(r1, r2, r3, r5);
        this.E = r4;
        this.F = r6;
        this.G = r7;
    }
}
