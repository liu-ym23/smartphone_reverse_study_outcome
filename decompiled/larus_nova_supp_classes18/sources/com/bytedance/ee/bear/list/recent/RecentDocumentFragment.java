package com.bytedance.ee.bear.list.recent;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecentDocumentFragment extends a implements wc5.e, r0.c, d0c.c, ed5.d, ed5.e {
    public View g;
    public j0 h;
    public r0 i;
    public final boolean j;
    public SmartRefreshLayout k;
    public boolean l;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // ed5.d
    public final boolean ZT() {
        r0 r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.F.a == false) goto L7;
        return true;
    }

    public final boolean onBackPressed() {
        r0 r0 = this.i;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.F.a == false) goto L10;
        r0.j();
        return true;
    L10:
        return false;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("RecentDocumentFragment", "onPageSelected()...fragmentHash = " + System.identityHashCode(this) + ", presenterHash = " + System.identityHashCode(this.h) + ", viewHash = " + System.identityHashCode(this.i) + ", isAdded = " + isAdded() + ", isResumed = " + isResumed());
        j0 r0 = this.h;
        if (r0 != null) goto L7;
        tt5.a.k("RecentDocumentFragment", "onPageSelected() before presenter ready, cache refresh for later.");
        this.l = true;
        return;
    L7:
        if (r0.k9() == true) goto L10;
        this.h.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void xk() {
        r0 r0 = this.i;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public RecentDocumentFragment() {
        this.j = true;
    }

    public final boolean V90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.containsKey("office_list_tab") == false) goto L7;
    L8:
        return true;
    L7:
        if (r0.containsKey("office_list_runtime_id") == false) goto L9;
        goto L8
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.recent.a
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("RecentDocumentFragment", "onDestroy()...");
        this.l = false;
        j0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("RecentDocumentFragment", "onResume()...");
        j0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        tt5.a.h("RecentDocumentFragment", "onStop()...");
        r0 r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        j0 r1 = this.h;
        if (r1 == null) goto L11;
        ((c) r1.getModel()).onStop();
        return;
    L11:
        return;
    L5:
        if (r0.F.a == false) goto L7;
        r0.j();
        goto L7
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m35provideComponent() {
        return provideComponent();
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r3) {
        tt5.a.h("RecentDocumentFragment", "setRefreshLayout()...refreshLayout = " + r3 + ", refreshLayoutHash = " + System.identityHashCode(r3) + ", fragmentHash = " + System.identityHashCode(this) + ", viewHash = " + System.identityHashCode(this.i));
        this.k = r3;
        r0 r0 = this.i;
        if (r0 == null) goto L5;
        r0.I3(r3);
        return;
    L5:
        tt5.a.h("RecentDocumentFragment", "setRefreshLayout()...view not ready, cache refresh layout.");
    }

    @Override // ed5.d
    public final void Dt(Document r3) {
        r0 r0 = this.i;
        if (r0 == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r0.F.a == false) goto L12;
        r0.G.f(r3);
        r0.B3();
        return;
    L12:
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        r0 r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r3) {
        tt5.a.h("RecentDocumentFragment", "onRefresh()...source = refreshLayoutGesture, refreshLayoutHash = " + System.identityHashCode(r3) + ", fragmentHash = " + System.identityHashCode(this) + ", presenterHash = " + System.identityHashCode(this.h) + ", isAdded = " + isAdded() + ", isResumed = " + isResumed());
        j0 r4 = this.h;
        if (r4 == null) goto L6;
        r4.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void sT(Document r4) {
        r0 r0 = this.i;
        if (r0 == null) goto L13;
        com.bytedance.ee.bear.list.list.d r1 = r0.q;
        if ((r1 instanceof ed5.c) == false) goto L7;
        r0.G.b(r4);
        r0.B3();
        return;
    L7:
        if (r1 != null) goto L9;
        String r5 = "null";
    L10:
        tt5.a.k("RecentDocumentView", "enterSelectMode() ignored: adapter doesn't support multi-select, adapter=".concat(r5));
        return;
    L9:
        r5 = r1.getClass().getSimpleName();
        goto L10
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        tt5.a.h("RecentDocumentFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        j0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r3);
        return;
    }

    public final void onViewCreated(View r20, Bundle r21) {
        super.onViewCreated(r20, r21);
        tt5.a.h("RecentDocumentFragment", "onViewCreated()...");
        ce5.a r6 = new ce5.a(this);
        this.i = new r0(getContext(), this.g, this, this, r6);
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
    L8:
        Integer r15 = null;
    L10:
        if (qc5.a.h() == false) goto L12;
    L18:
        v r1 = new v(this, getContext(), new ce5.a(this));
        if (V90() == false) goto L39;
        if (r15 != null) goto L22;
    L24:
        r1.n = true;
        r1.p = OfficeRecentFilterViewModel.normalizeServerTabType(r15);
        r1.u0();
        if (r1.n == false) goto L38;
        Fragment r2 = r1.a;
        if (r2 == null) goto L38;
        if (r2.getActivity() == null) goto L38;
        OfficeRecentFilterViewModel r3 = (OfficeRecentFilterViewModel) new ViewModelProvider(r1.a.getActivity()).get(OfficeRecentFilterViewModel.class);
        Integer r4 = r3.currentTabType();
        Integer r5 = r1.p;
        if (r5 != null) goto L36;
        if (r4 == null) goto L38;
        r3.clearTabType();
        goto L38
    L36:
        if (r5.equals(r4) == true) goto L38;
        r3.updateTabType(r1.p.intValue());
    L38:
        r1.x0();
        goto L39
    L22:
        if (r15.intValue() >= 0) goto L24;
        tt5.a.h("RecentDocumentModel", "ignore invalid office recent filter tab type: " + r15);
    L39:
        v r16 = r1;
        r0 r7 = this.i;
        Context r8 = getContext();
        boolean r9 = V90();
        Bundle r10 = getArguments();
        if (r10 != null) goto L42;
        String r11 = null;
    L43:
        Bundle r12 = getArguments();
        if (r12 != null) goto L46;
        String r13 = null;
    L47:
        Bundle r14 = getArguments();
        long r17 = 0;
        if (r14 == null) goto L51;
        r17 = r14.getLong("office_click_start_ms", 0);
    L51:
        long r18 = r17;
        Bundle r19 = getArguments();
        if (r19 != null) goto L54;
        String r110 = null;
    L55:
        Bundle r22 = getArguments();
        if (r22 != null) goto L58;
        String r111 = "RECENT";
    L59:
        this.h = new j0(r7, r16, r8, this, r6, r9, r11, r13, r18, r110, r111);
        tt5.a.h("RecentDocumentFragment", "initMVP()...officeWrapped = " + V90() + ", officeFilterTabType = " + r15 + ", fragmentHash = " + System.identityHashCode(this) + ", viewHash = " + System.identityHashCode(this.i) + ", modelHash = " + System.identityHashCode(r16) + ", presenterHash = " + System.identityHashCode(this.h) + ", pendingRefreshLayoutHash = " + System.identityHashCode(this.k) + ", pendingPageSelected = " + this.l);
        this.h.create();
        if (this.k == null) goto L63;
        tt5.a.h("RecentDocumentFragment", "initMVP()...apply pending refresh layout after view ready.");
        this.i.I3(this.k);
    L63:
        if (this.l == false) goto L67;
        tt5.a.h("RecentDocumentFragment", "initMVP()...consume pending onPageSelected.");
        this.l = false;
        if (this.h.k9() == true) goto L67;
        this.h.onRefresh();
    L67:
        lc5.x.c().h("init");
        return;
    L58:
        r111 = r22.getString("office_preload_tab", "RECENT");
        goto L59
    L54:
        r110 = r19.getString("office_preload_request_key_hash");
        goto L55
    L46:
        r13 = r12.getString("office_enter_method");
        goto L47
    L42:
        r11 = r10.getString("office_enter_trace_id");
        goto L43
    L12:
        if (V90() == true) goto L18;
        r1 = pd5.e.b(getContext()).a;
        if (r1 != null) goto L17;
        r1 = new v(this, getContext(), r6);
        goto L39
    L17:
        tt5.a.h("RecentDocumentFragment", "initMVP()...model is preloaded.");
        r1.B0(this);
        goto L39
    L5:
        if (r0.containsKey("office_recent_filter_tab_type") == false) goto L8;
        r15 = Integer.valueOf(r0.getInt("office_recent_filter_tab_type"));
        goto L10
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r11, List<Document> r12, ed5.g r13) {
        if (hu5.a.d(r12) == false) goto L5;
        return false;
    L5:
        ListSelectPanelAction r0 = ListSelectPanelAction.REMOVE_RECENT;
        if (r11 == r0) goto L30;
        ListSelectPanelAction r3 = ListSelectPanelAction.DELETE_SOURCE;
        if (r11 == r3) goto L30;
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == true) goto L13;
    L29:
        return false;
    L13:
        if (r12.size() != 1) goto L29;
        Document r14 = (Document) ListProtector.get(r12, 0);
        if (r13.a == false) goto L18;
        boolean r15 = true;
    L19:
        r0 r4 = this.i;
        if (r11 != ListSelectPanelAction.SHARE) goto L23;
        r4.B0(this.g, -1, r14, r15);
        return true;
    L23:
        if (r11 == r0) goto L27;
        if (r11 == r3) goto L27;
        return false;
    L27:
        r4.x0(this.g, -1, r14, r15);
        return true;
    L18:
        r15 = false;
    L30:
        final j0 r16 = this.h;
        if (r16 != null) goto L33;
        return false;
    L33:
        ArrayList r17 = new ArrayList(r12);
        if (hu5.a.d(r17) == true) goto L100;
        final ArrayList<Document> r18 = new ArrayList(r17);
        int r19 = r16.g9(r18);
        if (AppInfoUtils.f().booleanValue() == true) goto L39;
    L42:
        boolean r110 = false;
    L43:
        fp5.a r1 = new fp5.a(r16.a);
        if (r110 == false) goto L46;
        String r5 = r16.a.getResources().getQuantityString(2131755035, r18.size(), new Object[]{Integer.valueOf(r18.size())});
    L54:
        fp5.a r2 = (fp5.a) ((fp5.a) ((fp5.a) r1.title(r5)).titleSize(16)).titleGravity(8388611);
        if (r110 == false) goto L58;
        String r6 = r16.a.getString(2131889414);
    L72:
        fp5.a r7 = (fp5.a) ((fp5.a) ((fp5.a) r2.message(r6)).messageTextSize(14)).messageGravity(8388611);
        r7.e = false;
        UDBaseDialogBuilder.ActionBuilder r8 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r110 == false) goto L76;
        int r9 = 2131889413;
    L90:
        fp5.a r111 = (fp5.a) r7.addActionButton(r8.text(r9).onClickListener(new e0(r16, r18)));
        if (r110 == false) goto L93;
        int r112 = 2131888904;
    L94:
        Dialog r113 = ((fp5.a) r111.addActionButton(2131391778, r112, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L102;
        DialogLancet.handleBlockedDialogShow(r113);
    L99:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r113);
        goto L100
    L102:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L101
    L98:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        goto L99
    L93:
        r112 = 2131887716;
        goto L94
    L76:
        if (r16.A == false) goto L81;
        if (AppInfoUtils.f().booleanValue() == true) goto L84;
    L88:
        r9 = 2131888026;
    L84:
        r9 = 2131889446;
        goto L90
    L81:
        if (AppInfoUtils.f().booleanValue() == false) goto L87;
        if (r16.g9(r18) == 2) goto L84;
        r9 = 2131889421;
        goto L90
    L87:
        if (r16.g9(r18) == 2) goto L88;
        r9 = 2131887736;
        goto L90
    L58:
        if (r16.A == false) goto L60;
        r6 = r16.a.getString(2131887965);
        goto L72
    L60:
        int r10 = r16.g9(r18);
        if (r10 != 2) goto L64;
        r6 = r16.a.getString(2131887965);
        goto L72
    L64:
        if (r10 != 3) goto L66;
        boolean r20 = true;
    L67:
        String r21 = r16.a.getString(2131889599);
        String[] r22 = {"{{num}}", "{{OnlyRemoveFromList}}"};
        CharSequence[] r23 = new CharSequence[2];
        r23[0] = "30";
        if (r20 == false) goto L70;
        String r24 = r16.a.getString(2131889597);
    L71:
        r23[1] = r24;
        r6 = TextUtils.replace(r21, r22, r23).toString().trim();
        goto L72
    L70:
        r24 = "";
        goto L71
    L66:
        r20 = false;
        goto L67
    L46:
        Context r25 = r16.a;
        if (r16.A == false) goto L50;
    L51:
        int r26 = 2131887966;
    L53:
        r5 = r25.getString(r26);
        goto L54
    L50:
        if (r16.g9(r18) == 2) goto L51;
        r26 = 2131889601;
        goto L53
    L39:
        if (r16.A == true) goto L42;
        if (r19 == 2) goto L42;
        r110 = true;
    L100:
        return true;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        tt5.a.h("RecentDocumentFragment", "onCreateView()...");
        if (this.j == false) goto L5;
        lc5.x.c().a("inflate_recent_layout");
    L5:
        this.g = pd5.d.a.a.a(getActivity());
        if (this.j == false) goto L9;
        lc5.x.c().g("inflate_recent_layout", 0, 0);
    L9:
        return this.g;
    }
}
