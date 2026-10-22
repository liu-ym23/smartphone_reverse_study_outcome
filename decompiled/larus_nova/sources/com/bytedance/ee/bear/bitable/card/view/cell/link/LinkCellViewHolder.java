package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.enums.EItemViewSceneType;
import com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder;
import com.bytedance.ee.bear.bitable.card.view.cell.link.panel.LinkPanelAdapter;
import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.SafeFlexboxLayoutManager;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.FlowableEmitter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class LinkCellViewHolder extends BaseCellViewHolder<List<cp4.a>, List<cp4.a>> implements hp4.u, pp4.a, BitableLinkRecordsFetchManager.c, sa5.w, BitableLinkRecordCreateManager.a {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f207716k0 = 0;
    public final View F;
    public final InnerRecyclerView G;
    public final LinkRecordAdapter H;
    public final View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final AppCompatImageView f207717J;
    public final View K;
    public pp4.c L;
    public final jq4.k M;
    public final BitableLinkRecordsFetchManager N;
    public cp4.a O;
    public fp4.d P;
    public List<cp4.a> Q;
    public uu5.d<String> R;
    public uu5.n<Boolean> S;
    public final CompositeDisposable T;
    public final BitableLinkRecordCreateManager U;
    public final boolean V;
    public final boolean W;
    public final boolean X;
    public String Y;
    public Disposable Z;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean C4() {
        return true;
    }

    @Override // hp4.u
    public final boolean r2() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordsFetchManager.c
    public final void B1() {
        if (this.f207233e.f478254a.D == false) goto L5;
        R4();
        return;
    L5:
        T4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordCreateManager.a
    public final void L0() {
        this.F.requestFocus();
    }

    public final void Q4() {
        if (this.C == false) goto L5;
        a4();
    L6:
        this.f207229a.q0().v(BitableAnalytic.LinkSceneClickType.ADD_RECORD, this.P.f478257d);
        return;
    L5:
        this.F.requestFocus();
        goto L6
    }

    public final void R4() {
        tt5.a.h("LinkCellViewHolder", "fetchLinkRecordsWhenSearch");
        final fp4.d r100 = this.P;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.L == null) goto L9;
        this.N.fetchLinkRecords(r100, new ArrayList()).subscribe(new e0(this, r100), new f0(this));
        return;
    }

    public final void S4() {
        fp4.d r100 = this.P;
        final boolean r101 = false;
        if (r100 == null) goto L7;
        cp4.b r102 = r100.f478240n;
        if (r102 == null) goto L7;
        final boolean r103 = !hu5.a.d(r102.f464668l);
    L8:
        boolean r104 = this.N.hasMore();
        pp4.c r105 = this.L;
        if (r105 != null) goto L11;
    L16:
        tt5.a.h("LinkCellViewHolder", "fetchLinkTableDataInNative hasLinkTableRecord " + r103 + " has more " + r104);
        if (r103 == false) goto L27;
        if (r104 == true) goto L27;
        if (r101 == true) goto L32;
        fp4.d r106 = this.P;
        if (r106 == null) goto L33;
        pp4.c r107 = this.L;
        if (r107 == null) goto L34;
        r107.C(r106.f478240n, r106.f478256c);
        V4(true);
        this.L.M(this.N.hasMore());
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L27:
        if (this.P == null) goto L35;
        pp4.c r108 = this.L;
        if (r108 == null) goto L36;
        r108.L(AsyncFetchResult.EResultState.LOADING, null);
        this.T.add(this.N.fetchLinkRecordsInBaseAddInNative(this.P, !r103).subscribe(new c0(this, r103, r101), new d0(this)));
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (r105.f207786o == null) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L16;
        r101 = true;
        goto L16
    L13:
        r109 = false;
    L7:
        r103 = false;
        goto L8
    }

    public final void T4() {
        tt5.a.h("LinkCellViewHolder", "fetchLinkTableWhenShowing");
        fp4.d r100 = this.P;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.L == null) goto L9;
        this.N.fetchLinkTable(r100, new ArrayList()).subscribe(new b(this), new m(this));
        return;
    }

    public final void X4() {
        pp4.c r100 = this.L;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.s() == false) goto L9;
        this.L.E(R.drawable.ccm_empty_neutral_no_content, R.string.Bitable_Relation_LinkedTableWasDeleted);
        return;
    }

    public final void Y4() {
        if (this.f207229a.t() != EItemViewSceneType.FAST_ADD_RECORD) goto L5;
    L6:
        pp4.c r100 = this.L;
        if (r100 == null) goto L13;
        cp4.b r101 = r100.f207786o;
        if (r101 == null) goto L14;
        this.N.storeLinkRecord(r101.f464660d, r101.f464668l);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (this.W == true) goto L6;
    }

    public final void Z4() {
        boolean r100 = this.N.hasMore();
        tt5.a.h("LinkCellViewHolder", "updateLinkRecordsWhenSearchInNative " + r100);
        if (this.P != null) goto L5;
        return;
    L5:
        if (this.L != null) goto L7;
        return;
    L7:
        if (r100 == true) goto L11;
        this.N.updateSearchLinkRecordsInNative();
        pp4.c r101 = this.L;
        fp4.d r102 = this.P;
        r101.I(r102.f478240n, r102.f478256c);
        this.L.M(false);
        return;
    L11:
        if (this.N.hasRepeatRequest() == false) goto L13;
        return;
    L13:
        Disposable r103 = this.N.fetchLinkRecordsInBaseAddInNative(this.P, false).subscribe(new y(this), new z());
        this.Z = r103;
        this.T.add(r103);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void b0() {
        if (this.f207239k == false) goto L7;
        LinkRecordAdapter r100 = this.H;
        if ((r100 instanceof PageLinkRecordAdapter) == false) goto L9;
        ((PageLinkRecordAdapter) r100).f207729j = 6.5f;
        this.G.setOpenInnerScroll(true);
        return;
    L9:
        return;
    L7:
        this.G.t(260.0f);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final boolean u4() {
        if (this.X == false) goto L5;
        dp4.a r100 = this.f207232d;
        if (r100 == null) goto L32;
        V r101 = r100.f469598l;
        if (r101 == 0) goto L32;
        if ((r101 instanceof List) == false) goto L32;
        List r102 = (List) r101;
        cp4.a r103 = r100.f469588b;
        if (r103 == null) goto L19;
        cp4.b r104 = r103.f464634a;
        if (r104 == null) goto L19;
        if (r104.f464681y == false) goto L19;
        boolean r105 = false;
    L20:
        if (r105 == false) goto L22;
    L26:
        Iterator r106 = r102.iterator();
    L28:
        if (r106.hasNext() == false) goto L32;
        if (((cp4.a) r106.next()).f464643j == false) goto L28;
        return false;
    L22:
        if (this.V == false) goto L26;
        return hu5.a.d(r102);
    L19:
        r105 = true;
    L32:
        return true;
    L5:
        return super.u4();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void A() {
        super.A();
        if (this.f207239k == false) goto L5;
        return;
    L5:
        View r100 = this.F;
        boolean r101 = hu5.a.d(this.Q);
        if (r100 != null) goto L8;
        return;
    L8:
        if (y4() == false) goto L13;
        if (r101 == false) goto L14;
        r100.setBackgroundResource(R.drawable.bitable_card_field_attachment_bg);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void Z3() {
        super.Z3();
        boolean r100 = true;
        int r101 = 0;
        if (this.V == false) goto L9;
        fp4.d r102 = this.P;
        if (r102 == null) goto L9;
        if (r102.f478242p == true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        UDToast.show(this.F.getContext(), R.string.Bitable_AdvancedPermission_ContactOwnerBeforeLinkRecords_Toast, R.drawable.ud_icon_warning_outlined);
        this.F.clearFocus();
        return;
    L13:
        com.bytedance.ee.bear.bitable.statistic.m r104 = (com.bytedance.ee.bear.bitable.statistic.m) org.koin.java.a.a(com.bytedance.ee.bear.bitable.statistic.m.class);
        String r105 = r104.createNormalTrace(null);
        r104.addNormalConsumer(r105, new yu4.a("BASE_MOBILE_PERFORMANCE_LINK_PANEL"));
        this.Y = r105;
        HashMap r106 = new HashMap();
        r106.put("open_type", e4());
        Lazy r107 = yu4.b.f569223a;
        yu4.b.b(r105, System.currentTimeMillis(), r106);
        if (this.L != null) goto L16;
        pp4.c r108 = new pp4.c(this.itemView.getContext(), this.f207229a, this);
        this.L = r108;
        r108.f486402f = new j0(this);
        r108.f486406j = this.f207229a.o();
        pp4.c r109 = this.L;
        r109.f486401e = new b0(this);
        r109.f207789r.f210634f.setOnPositionChangeListener(new k0(this));
    L16:
        this.L.o(Boolean.valueOf(u4()));
        this.L.show();
        this.L.P(this.Q, this.P);
        this.M.d(this.F, this);
        fp4.d r110 = this.P;
        if (r110 != null) goto L19;
    L65:
        BitableAnalytic r111 = this.f207229a.q0();
        if (hu5.a.f(this.Q) == false) goto L71;
        String[] r112 = new String[this.Q.size()];
    L69:
        if (r101 >= this.Q.size()) goto L72;
        r112[r101] = ((cp4.a) ListProtector.get(this.Q, r101)).f464635b;
        r101 = r101 + 1;
    L72:
        int r113 = r112.length;
        FieldCompositeType r114 = this.P.f478257d;
        r111.getClass();
        HashMap r115 = new HashMap();
        r115.put("relation_count", Integer.valueOf(r113));
        r115.put("field_type", r114.getReportValue());
        r111.t("ccm_bitable_relation_field_modify_view", r115);
        return;
    L71:
        r112 = new String[0];
        goto L72
    L19:
        if (r110.f478242p == true) goto L24;
        tt5.a.h("LinkCellViewHolder", "enterEditMode()... linkTable has no permission");
        if (this.V == true) goto L23;
        this.L.E(R.drawable.ccm_empty_neutral_no_access, R.string.Bitable_Relation_NoPermissionToViewLinkedTable);
    L23:
        V4(false);
        goto L65
    L24:
        int r116 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r117 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.bitable.record.linkfield.opt") == false) goto L27;
        boolean r118 = this.P.f478247u;
    L34:
        if (r118 == false) goto L45;
        if (this.f207229a.t() == EItemViewSceneType.FAST_ADD_RECORD) goto L45;
        if (this.W == true) goto L45;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.android_fix_partial_link_panel_error") == true) goto L42;
    L43:
        tt5.a.h("LinkCellViewHolder", "enterEditMode()... linkTable has been deleted");
        X4();
        V4(false);
        goto L65
    L42:
        if (this.f207233e.f478254a.D == false) goto L43;
    L45:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.mobile.link_filter_field_deny_enable") == true) goto L47;
    L49:
        FilterInfo r119 = this.P.f478245s;
        if (r119 != null) goto L52;
    L56:
        boolean r120 = this.f207233e.f478254a.D;
        this.N.forwardLinkTable(this.P.f478240n, r120);
        if (this.f207229a.t() != EItemViewSceneType.FAST_ADD_RECORD) goto L59;
    L64:
        S4();
        goto L65
    L59:
        if (this.W == true) goto L64;
        this.N.registerLinkTableListener(this);
        if (r120 == false) goto L65;
        T4();
        goto L65
    L52:
        if (r119.getConditions() == null) goto L56;
        if (TextUtils.isEmpty(this.P.f478262i) == true) goto L56;
        tt5.a.h("LinkCellViewHolder", "enterEditMode()... exist field warning");
        this.L.F(R.drawable.ccm_empty_neutral_no_content, this.P.f478262i);
        V4(false);
        goto L65
    L47:
        if (this.P.f478244r == false) goto L49;
        tt5.a.h("LinkCellViewHolder", "enterEditMode()... isEnableLinkFilterFieldDeny");
        this.L.E(R.drawable.ccm_empty_neutral_no_access, R.string.Bitable_SingleOption_NoPermToAccessOptions);
        goto L65
    L27:
        Map<String, fp4.g> r121 = this.P.f478240n.f464665i;
        if (r121 != null) goto L30;
    L32:
        r100 = false;
    L33:
        r118 = r100;
        goto L34
    L30:
        if (r121.size() > 0) goto L32;
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void c4() {
        super.c4();
        fp4.d r100 = this.P;
        if (r100 == null) goto L5;
        this.N.backwardLinkTable(r100.f478240n);
        this.N.unregisterLinkTableListener(this);
    L5:
        pp4.c r101 = this.L;
        if (r101 != null) goto L8;
    L10:
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r103 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.editor.fix_link_panel_reuse") == false) goto L13;
        this.L = null;
    L13:
        Disposable r104 = this.Z;
        if (r104 != null) goto L16;
    L18:
        this.M.f(this.F, this);
        return;
    L16:
        if (r104.isDisposed() == true) goto L18;
        this.Z.dispose();
        goto L18
    L8:
        if (r101.s() == false) goto L10;
        Y4();
        this.L.dismiss();
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void s4() {
        super.s4();
        View r100 = this.F;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setOnFocusChangeListener(new g0(this));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void u() {
        super.u();
        this.f207229a.b(this);
        uu5.d<String> r100 = this.R;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        uu5.n<Boolean> r101 = this.S;
        if (r101 == null) goto L10;
        Disposable r102 = r101.f551760b;
        if (r102 == null) goto L10;
        r102.dispose();
    L10:
        this.T.clear();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final View getContentView() {
        return this.F;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void M2(boolean r100) {
        super.M2(r100);
        com.bytedance.ee.util.ui.j.f(new x(this));
    }

    public final void V4(boolean r100) {
        if (TextUtils.isEmpty(this.Y) == false) goto L7;
        tt5.a.b("LinkCellViewHolder", "reportLinkPanelShowEnd " + r100 + " traceId isEmpty");
        return;
    L7:
        if (r100 == false) goto L10;
        Lazy r101 = yu4.b.f569223a;
        yu4.b.d(this.Y, System.currentTimeMillis());
        this.Y = null;
        return;
    L10:
        Lazy r102 = yu4.b.f569223a;
        yu4.b.c(this.Y, System.currentTimeMillis());
        this.Y = null;
    }

    public final void W4(cp4.b r100) {
        if (this.L == null) goto L17;
        List<cp4.a> r101 = r100.f464668l;
        if (com.larksuite.framework.utils.q.a(r101) == true) goto L18;
        int r102 = ((cp4.a) ListProtector.get(r101, 0)).f464644k + 1;
        if (r102 < 0) goto L19;
        pp4.c r103 = this.L;
        LinkPanelAdapter r104 = r103.f207787p;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
        r104 = null;
    L12:
        if (r104.getItemCount() <= 0) goto L20;
        RecyclerView.LayoutManager r105 = r103.f207789r.f210646r.getLayoutManager();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r106 = ((LinearLayoutManager) r105).findFirstCompletelyVisibleItemPosition();
        tt5.a.b("LinkRecordPickerPanel", "scrollUp, firstVisiblePos = " + r106 + ", num = " + r102);
        if (r106 < r102) goto L21;
        r103.f207789r.f210646r.scrollToPosition(r106 - r102);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // hp4.u
    public final int getPanelHeight(Context r100) {
        pp4.c r101 = this.L;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.r();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, com.bytedance.ee.bear.bitable.card.view.cell.b
    public final void l2(dp4.a<List<cp4.a>> r110) {
        super.l2(r110);
        fp4.d r100 = this.P;
        cp4.a r101 = r110.f469588b;
        this.O = r101;
        fp4.g r102 = r110.f469587a;
        if ((r102 instanceof fp4.d) == false) goto L5;
        fp4.d r103 = (fp4.d) r102;
        this.P = r103;
        LinkRecordAdapter r104 = this.H;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "linkField");
        r104.f207719b = r103;
        r104.f207720c = r101;
    L5:
        List<cp4.a> r105 = this.Q;
        boolean r106 = false;
        if (r105 == null) goto L8;
        int r107 = r105.size();
    L9:
        List<cp4.a> r111 = r110.f469598l;
        if (r111 == null) goto L12;
        List<cp4.a> r112 = r111;
    L13:
        this.Q = r112;
        if (this.f207229a.t() == EItemViewSceneType.FAST_ADD_RECORD) goto L18;
        if (this.W == true) goto L18;
    L53:
        cp4.a r113 = this.O;
        if (r113 == null) goto L60;
        cp4.b r114 = r113.f464634a;
        if (r114 == null) goto L60;
        if (r114.f464681y == false) goto L60;
        boolean r115 = false;
    L61:
        if (r115 == false) goto L63;
    L64:
        int r116 = this.Q.size() - 1;
    L65:
        if (r116 < 0) goto L71;
        if (((cp4.a) ListProtector.get(this.Q, r116)).f464643j == true) goto L69;
        ListProtector.remove(this.Q, r116);
    L69:
        r116 = r116 - 1;
    L71:
        if (this.f207239k == false) goto L104;
        int r117 = l4();
        if (hu5.a.f(this.Q) == true) goto L75;
    L77:
        int r108 = j4();
        if (r117 >= r108) goto L94;
        LinkRecordAdapter r109 = this.H;
        if ((r109 instanceof PageLinkRecordAdapter) == false) goto L83;
        r108 = r108 + ((int) ((PageLinkRecordAdapter) r109).m1());
    L83:
        List<cp4.a> r118 = this.Q;
        if (r118 == null) goto L95;
        Iterator<cp4.a> r119 = r118.iterator();
    L87:
        if (r119.hasNext() == false) goto L95;
        cp4.a r120 = r119.next();
        LinkRecordAdapter r121 = this.H;
        if ((r121 instanceof PageLinkRecordAdapter) == false) goto L91;
        int r122 = (int) ((PageLinkRecordAdapter) r121).y2(r120);
    L92:
        r117 = r117 + r122;
        if (r117 < r108) goto L87;
    L91:
        r122 = 0;
    L95:
        boolean r123 = false;
    L96:
        LinkRecordAdapter r124 = this.H;
        if ((r124 instanceof PageLinkRecordAdapter) == false) goto L99;
        ((PageLinkRecordAdapter) r124).f207730k = r123;
    L99:
        ViewGroup.LayoutParams r125 = this.G.getLayoutParams();
        if (r123 == false) goto L102;
        int r126 = -1;
    L103:
        r125.width = r126;
        goto L104
    L102:
        r126 = -2;
    L94:
        r123 = true;
        goto L96
    L75:
        if (this.f207235g.f486413e == false) goto L77;
        r117 = r117 + com.bytedance.ee.util.ui.n.d(40);
    L104:
        LinkRecordAdapter r127 = this.H;
        List<cp4.a> r128 = this.Q;
        r127.getClass();
        Intrinsics.checkNotNullParameter(r128, "linkRecordList");
        r127.f207721d = r128;
        LinkRecordAdapter r129 = this.H;
        if (this.f207235g.f486409a == true) goto L107;
    L109:
        boolean r130 = false;
    L110:
        r129.f207723f = r130;
        r129.notifyDataSetChanged();
        com.bytedance.ee.util.ui.j.f(new x(this));
        if (this.f207234f == true) goto L113;
        return;
    L113:
        if (this.L == null) goto L150;
        if (r100 == null) goto L136;
        fp4.d r131 = this.P;
        if (r131 == null) goto L136;
        if (TextUtils.equals(r100.f478240n.f464660d, r131.f478240n.f464660d) == false) goto L136;
        FilterInfo r132 = r100.f478245s;
        FilterInfo r133 = this.P.f478245s;
        if (r132 != null) goto L123;
        if (r133 != null) goto L123;
    L129:
        if (r106 == true) goto L131;
    L133:
        this.L.P(this.Q, this.P);
        if (this.Q.size() == r107) goto L151;
        this.M.d(this.F, this);
        return;
    L151:
        return;
    L131:
        if (this.L.s() == false) goto L133;
        T4();
    L123:
        if (r132 == null) goto L128;
        if (r133 == null) goto L128;
        if (r132.equals(r133) == true) goto L129;
    L128:
        r106 = true;
    L136:
        tt5.a.h("LinkCellViewHolder", "close mLinkRecordPickerPanel when link table relationship has changed");
        c4();
        return;
    L150:
        return;
    L107:
        if ((this.f207233e instanceof com.bytedance.ee.bear.bitable.card.model.stmodel.field.b) == true) goto L109;
        r130 = true;
        goto L110
    L63:
        if (this.V == true) goto L71;
    L60:
        r115 = true;
    L18:
        if (this.Q == null) goto L44;
        fp4.d r134 = this.P;
        if (r134 == null) goto L44;
        if (this.L == null) goto L44;
        if (r100 != null) goto L25;
    L26:
        int r135 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r136 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.editor.fix_link_panel_reuse") == true) goto L44;
    L28:
        Y4();
        cp4.b r137 = this.L.f207786o;
        if (r137 != null) goto L32;
        if (r100 == null) goto L32;
        r137 = r100.f478240n;
    L32:
        if (r137 == null) goto L44;
        if (r137.f464668l == null) goto L44;
        if (TextUtils.equals(r137.f464660d, this.P.f478240n.f464660d) == false) goto L44;
        fp4.d r138 = this.P;
        cp4.b r139 = r138.f478240n;
        if (r139 != null) goto L41;
        r138.f478240n = r137;
        goto L44
    L41:
        if (r139.f464668l != null) goto L44;
        r138.f478240n = r137;
        goto L44
    L25:
        if (TextUtils.equals(r100.f478255b, r134.f478255b) == true) goto L28;
    L44:
        if (this.P == null) goto L53;
        List<cp4.a> r140 = this.Q;
        if (r140 == null) goto L53;
        Iterator<cp4.a> r141 = r140.iterator();
    L49:
        if (r141.hasNext() == false) goto L53;
        cp4.a r142 = r141.next();
        cp4.a r143 = this.N.findLinkRecord(this.P.f478240n.f464660d, r142.f464635b);
        if (r143 == null) goto L49;
        r142.f464637d = r143.f464637d;
        r142.f464643j = true;
        goto L49
    L12:
        r112 = new ArrayList();
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.link.BitableLinkRecordsFetchManager.c
    public final void p1(boolean r100) {
        tt5.a.h("LinkCellViewHolder", "onLinkTableChanged, isMetaChanged: " + r100);
        if (this.S != null) goto L5;
        this.S = new uu5.n(new a0(this));
    L5:
        uu5.n<Boolean> r101 = this.S;
        Boolean r102 = Boolean.valueOf(r100);
        FlowableEmitter<Boolean> r103 = r101.f551759a;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isCancelled() == true) goto L12;
        tt5.a.b("FlowableWrapper", "onNext: " + r102);
        r101.f551759a.onNext(r102);
        return;
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r100) {
        LinkRecordAdapter r101 = this.H;
        ActionMode r102 = r101.f207725h;
        if (r102 == null) goto L5;
        r102.finish();
    L5:
        r101.f207725h = null;
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [V, java.util.List<cp4.a>] */
    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final void I4(Object r310, String r311) {
        if ((r310 instanceof String[]) == false) goto L51;
        String[] r100 = (String[]) r310;
        if (this.Q != null) goto L7;
        this.Q = new ArrayList();
    L7:
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L39;
        String r110 = r100[r103];
        fp4.d r111 = this.P;
        if (r111 == null) goto L32;
        cp4.b r112 = r111.f478240n;
        if (r112 == null) goto L32;
        cp4.a r113 = r112.e(r110);
        if (r113 != null) goto L17;
        tt5.a.d("LinkCellViewHolder", "saveSubmitValue find linkRecord fail, " + r110);
    L37:
        r103 = r103 + 1;
        goto L9
    L17:
        if (TextUtils.equals("add", r311) == false) goto L20;
        this.Q.add(new cp4.a(r113.f464634a, r110, "", r113.f464637d, "", false, false, true, false, false, r113.f464644k, "", 0, r113.f464651r, r113.f464652s, r113.f464654u, r113.f464655v, r113.f464653t, new ArrayList()));
        goto L37
    L20:
        if (TextUtils.equals("delete", r311) == false) goto L30;
        Iterator<cp4.a> r104 = this.Q.iterator();
    L23:
        if (r104.hasNext() == false) goto L37;
        cp4.a r105 = r104.next();
        if (r105 == null) goto L23;
        if (TextUtils.equals(r110, r105.f464635b) == false) goto L23;
        r104.remove();
        goto L37
    L30:
        r101.add(new cp4.a(r113.f464634a, r110, "", r113.f464637d, "", false, false, true, false, false, r113.f464644k, "", 0, r113.f464651r, r113.f464652s, r113.f464654u, r113.f464655v, r113.f464653t, new ArrayList()));
    L32:
        StringBuilder r106 = new StringBuilder("saveSubmitValue mCurrentLinkField is null ");
        if (this.P != null) goto L35;
        boolean r107 = true;
    L36:
        r106.append(r107);
        tt5.a.d("LinkCellViewHolder", r106.toString());
        goto L37
    L35:
        r107 = false;
        goto L36
    L39:
        if (TextUtils.equals("add", r311) == false) goto L41;
    L43:
        ArrayList r108 = new ArrayList();
        Iterator<cp4.a> r109 = this.Q.iterator();
    L45:
        if (r109.hasNext() == false) goto L47;
        r108.add(r109.next().f464635b);
        goto L45
    L47:
        dp4.a<List<cp4.a>> r114 = this.f207232d;
        if (r114 == null) goto L50;
        r114.f469599m = r108;
        r114.f469598l = this.Q;
        l2(r114);
        return;
    L50:
        tt5.a.d("LinkCellViewHolder", "stCell is null");
        return;
    L41:
        if (TextUtils.equals("delete", r311) == true) goto L43;
        this.Q = r101;
        goto L43
    L51:
        tt5.a.d("LinkCellViewHolder", "saveSubmitValue object " + r310);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder
    public final /* bridge */ /* synthetic */ void N4(List<cp4.a> r100, String r101) {
    }

    public final void U4(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        tt5.a.b("LinkCellViewHolder", "onSelectedItemsChanged()... recordId = " + r100 + ", isChecked = " + r101);
        fp4.d r102 = this.P;
        String r103 = "delete";
        if (r102 != null) goto L8;
    L13:
        String[] r104 = {r100};
        if (r101 == false) goto L16;
        r103 = "add";
    L16:
        X3(r104, r103, this.Q);
    L17:
        this.f207229a.q0().l("relate_record", "none");
        this.f207229a.q0().p(r101, this.P.f478257d);
        return;
    L8:
        if (r102.f478241o == true) goto L13;
        String[] r105 = {r100};
        if (r101 == false) goto L12;
        r103 = "cover";
    L12:
        X3(r105, r103, this.Q);
        c4();
        goto L17
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder, ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        super.onKeyboardHeightChanged(r100, r101, r102);
        pp4.c r103 = this.L;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.s() == false) goto L12;
        pp4.c r104 = this.L;
        r104.f486405i = r101;
        if (r101 <= 0) goto L9;
        r104.f207789r.f210634f.m(true);
    L9:
        r104.p(r104.f207789r.f210648t);
        r104.p(r104.f207789r.f210635g);
        return;
    }

    public LinkCellViewHolder(View r100, aq4.a r101, gp4.h r102, jq4.j r103, boolean r104) {
        super(r100, r101, r102, r104);
        this.P = null;
        this.T = new CompositeDisposable();
        com.bytedance.ee.bear.appsetting.c r105 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.V = r105.h("ccm.bitable.mobile.support_remote_compute");
        boolean r106 = false;
        this.W = false;
        int r107 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("ccm.bitable.link.fix_empty_data", "key");
        this.X = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.link.fix_empty_data");
        this.Z = null;
        r102.c(this);
        this.M = r103;
        this.N = (BitableLinkRecordsFetchManager) com.bytedance.ee.bear.browser.plugin.q.a(r102.getFragment(), BitableLinkRecordsFetchManager.class);
        this.U = (BitableLinkRecordCreateManager) com.bytedance.ee.bear.browser.plugin.q.a(r102.getFragment(), BitableLinkRecordCreateManager.class);
        this.K = r100.findViewById(R.id.bottom_space_holder);
        InnerRecyclerView r108 = (InnerRecyclerView) r100.findViewById(R.id.link_field_recycler_view);
        this.G = r108;
        if (r104 == false) goto L5;
        this.F = this.f207244p;
        this.f207248t.setOnClickListener(new t(this));
        Context r109 = r100.getContext();
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        r108.setLayoutManager(new SafeFlexboxLayoutManager(r109));
        this.H = new PageLinkRecordAdapter(r102, r100.getContext());
    L6:
        LinkRecordAdapter r110 = this.H;
        u r111 = new u(this, r102);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "listener");
        r110.f207724g = r111;
        r108.setAdapter(this.H);
        View r112 = r100.findViewById(R.id.add_link_record_button_fl);
        this.I = r112;
        r112.setOnClickListener(new h0(this));
        this.f207717J = (AppCompatImageView) r100.findViewById(R.id.add_link_record_button);
        if (r102.N() == true) goto L9;
    L11:
        this.W = r106;
        r108.setOnClickListener(new i0(this));
        return;
    L9:
        if (r105.h("base.share_record_support_link_field_edit_disable") == true) goto L11;
        r106 = true;
        goto L11
    L5:
        this.F = r100.findViewById(R.id.container);
        r108.setLayoutManager(new LinearLayoutManager(r100.getContext()));
        this.H = new LinkRecordAdapter(r102);
        goto L6
    }
}
