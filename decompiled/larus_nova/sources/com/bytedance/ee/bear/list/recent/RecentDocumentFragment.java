package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class RecentDocumentFragment extends a implements wc5.e, r0.c, d0c.c, ed5.d, ed5.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f229238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f229239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0 f229240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f229241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SmartRefreshLayout f229242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f229243l;

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // ed5.d
    public final boolean ZT() {
        r0 r100 = this.f229240i;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.F.f472208a == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        r0 r100 = this.f229240i;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.F.f472208a == false) goto L10;
        r100.j();
        return true;
    L10:
        return false;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("RecentDocumentFragment", "onPageSelected()...fragmentHash = " + System.identityHashCode(this) + ", presenterHash = " + System.identityHashCode(this.f229239h) + ", viewHash = " + System.identityHashCode(this.f229240i) + ", isAdded = " + isAdded() + ", isResumed = " + isResumed());
        j0 r100 = this.f229239h;
        if (r100 != null) goto L7;
        tt5.a.k("RecentDocumentFragment", "onPageSelected() before presenter ready, cache refresh for later.");
        this.f229243l = true;
        return;
    L7:
        if (r100.k9() == true) goto L10;
        this.f229239h.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void xk() {
        r0 r100 = this.f229240i;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public RecentDocumentFragment() {
        this.f229241j = true;
    }

    public final boolean V90() {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.containsKey("office_list_tab") == false) goto L7;
    L8:
        return true;
    L7:
        if (r100.containsKey("office_list_runtime_id") == false) goto L9;
        goto L8
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return ((d0c.c) getActivity()).e9();
    L7:
        return PassportcConvention.b(this);
    L9:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.list.recent.a, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("RecentDocumentFragment", "onDestroy()...");
        this.f229243l = false;
        j0 r100 = this.f229239h;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("RecentDocumentFragment", "onResume()...");
        j0 r100 = this.f229239h;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        tt5.a.h("RecentDocumentFragment", "onStop()...");
        r0 r100 = this.f229240i;
        if (r100 != null) goto L5;
    L7:
        j0 r101 = this.f229239h;
        if (r101 == null) goto L11;
        ((c) r101.getModel()).onStop();
        return;
    L11:
        return;
    L5:
        if (r100.F.f472208a == false) goto L7;
        r100.j();
        goto L7
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r100) {
        tt5.a.h("RecentDocumentFragment", "setRefreshLayout()...refreshLayout = " + r100 + ", refreshLayoutHash = " + System.identityHashCode(r100) + ", fragmentHash = " + System.identityHashCode(this) + ", viewHash = " + System.identityHashCode(this.f229240i));
        this.f229242k = r100;
        r0 r101 = this.f229240i;
        if (r101 == null) goto L5;
        r101.I3(r100);
        return;
    L5:
        tt5.a.h("RecentDocumentFragment", "setRefreshLayout()...view not ready, cache refresh layout.");
    }

    @Override // ed5.d
    public final void Dt(Document r100) {
        r0 r101 = this.f229240i;
        if (r101 == null) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r101.F.f472208a == false) goto L12;
        r101.G.f(r100);
        r101.B3();
        return;
    L12:
        return;
    }

    @Override // ed5.e
    public final void c10(int r100) {
        r0 r101 = this.f229240i;
        if ((r101 instanceof ed5.e) == false) goto L6;
        r101.c10(r100);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r100) {
        tt5.a.h("RecentDocumentFragment", "onRefresh()...source = refreshLayoutGesture, refreshLayoutHash = " + System.identityHashCode(r100) + ", fragmentHash = " + System.identityHashCode(this) + ", presenterHash = " + System.identityHashCode(this.f229239h) + ", isAdded = " + isAdded() + ", isResumed = " + isResumed());
        j0 r101 = this.f229239h;
        if (r101 == null) goto L6;
        r101.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void sT(Document r100) {
        r0 r101 = this.f229240i;
        if (r101 == null) goto L13;
        com.bytedance.ee.bear.list.list.d r102 = r101.f228583q;
        if ((r102 instanceof ed5.c) == false) goto L7;
        r101.G.b(r100);
        r101.B3();
        return;
    L7:
        if (r102 != null) goto L9;
        String r103 = "null";
    L10:
        tt5.a.k("RecentDocumentView", "enterSelectMode() ignored: adapter doesn't support multi-select, adapter=".concat(r103));
        return;
    L9:
        r103 = r102.getClass().getSimpleName();
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        tt5.a.h("RecentDocumentFragment", "setUserVisibleHint()...isVisibleToUser = " + r100);
        j0 r101 = this.f229239h;
        if (r101 == null) goto L6;
        r101.setUserVisibleHint(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        super.onViewCreated(r210, r211);
        tt5.a.h("RecentDocumentFragment", "onViewCreated()...");
        ce5.a r100 = new ce5.a(this);
        this.f229240i = new r0(getContext(), this.f229238g, this, this, r100);
        Bundle r101 = getArguments();
        if (r101 != null) goto L5;
    L8:
        Integer r110 = null;
    L10:
        if (qc5.a.h() == false) goto L12;
    L18:
        v r102 = new v(this, getContext(), new ce5.a(this));
        if (V90() == false) goto L39;
        if (r110 != null) goto L22;
    L24:
        r102.f229326n = true;
        r102.f229328p = OfficeRecentFilterViewModel.normalizeServerTabType(r110);
        r102.u0();
        if (r102.f229326n == false) goto L38;
        Fragment r103 = r102.f228526a;
        if (r103 == null) goto L38;
        if (r103.getActivity() == null) goto L38;
        OfficeRecentFilterViewModel r104 = (OfficeRecentFilterViewModel) new ViewModelProvider(r102.f228526a.getActivity()).get(OfficeRecentFilterViewModel.class);
        Integer r105 = r104.currentTabType();
        Integer r106 = r102.f229328p;
        if (r106 != null) goto L36;
        if (r105 == null) goto L38;
        r104.clearTabType();
        goto L38
    L36:
        if (r106.equals(r105) == true) goto L38;
        r104.updateTabType(r102.f229328p.intValue());
    L38:
        r102.x0();
        goto L39
    L22:
        if (r110.intValue() >= 0) goto L24;
        tt5.a.h("RecentDocumentModel", "ignore invalid office recent filter tab type: " + r110);
    L39:
        v r111 = r102;
        r0 r107 = this.f229240i;
        Context r108 = getContext();
        boolean r109 = V90();
        Bundle r112 = getArguments();
        if (r112 != null) goto L42;
        String r113 = null;
    L43:
        Bundle r114 = getArguments();
        if (r114 != null) goto L46;
        String r115 = null;
    L47:
        Bundle r116 = getArguments();
        long r117 = 0;
        if (r116 == null) goto L51;
        r117 = r116.getLong("office_click_start_ms", 0);
    L51:
        long r118 = r117;
        Bundle r119 = getArguments();
        if (r119 != null) goto L54;
        String r120 = null;
    L55:
        Bundle r121 = getArguments();
        if (r121 != null) goto L58;
        String r122 = "RECENT";
    L59:
        this.f229239h = new j0(r107, r111, r108, this, r100, r109, r113, r115, r118, r120, r122);
        tt5.a.h("RecentDocumentFragment", "initMVP()...officeWrapped = " + V90() + ", officeFilterTabType = " + r110 + ", fragmentHash = " + System.identityHashCode(this) + ", viewHash = " + System.identityHashCode(this.f229240i) + ", modelHash = " + System.identityHashCode(r111) + ", presenterHash = " + System.identityHashCode(this.f229239h) + ", pendingRefreshLayoutHash = " + System.identityHashCode(this.f229242k) + ", pendingPageSelected = " + this.f229243l);
        this.f229239h.create();
        if (this.f229242k == null) goto L63;
        tt5.a.h("RecentDocumentFragment", "initMVP()...apply pending refresh layout after view ready.");
        this.f229240i.I3(this.f229242k);
    L63:
        if (this.f229243l == false) goto L67;
        tt5.a.h("RecentDocumentFragment", "initMVP()...consume pending onPageSelected.");
        this.f229243l = false;
        if (this.f229239h.k9() == true) goto L67;
        this.f229239h.onRefresh();
    L67:
        lc5.x.c().h("init");
        return;
    L58:
        r122 = r121.getString("office_preload_tab", "RECENT");
        goto L59
    L54:
        r120 = r119.getString("office_preload_request_key_hash");
        goto L55
    L46:
        r115 = r114.getString("office_enter_method");
        goto L47
    L42:
        r113 = r112.getString("office_enter_trace_id");
        goto L43
    L12:
        if (V90() == true) goto L18;
        r102 = pd5.e.b(getContext()).f528681a;
        if (r102 != null) goto L17;
        r102 = new v(this, getContext(), r100);
        goto L39
    L17:
        tt5.a.h("RecentDocumentFragment", "initMVP()...model is preloaded.");
        r102.B0(this);
        goto L39
    L5:
        if (r101.containsKey("office_recent_filter_tab_type") == false) goto L8;
        r110 = Integer.valueOf(r101.getInt("office_recent_filter_tab_type"));
        goto L10
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r110, List<Document> r111, ed5.g r112) {
        if (hu5.a.d(r111) == false) goto L5;
        return false;
    L5:
        ListSelectPanelAction r100 = ListSelectPanelAction.REMOVE_RECENT;
        if (r110 == r100) goto L30;
        ListSelectPanelAction r101 = ListSelectPanelAction.DELETE_SOURCE;
        if (r110 == r101) goto L30;
        if ((this.f229240i instanceof com.bytedance.ee.bear.list.list.d.b) == true) goto L13;
    L29:
        return false;
    L13:
        if (r111.size() != 1) goto L29;
        Document r113 = (Document) ListProtector.get(r111, 0);
        if (r112.f472214a == false) goto L18;
        boolean r114 = true;
    L19:
        r0 r102 = this.f229240i;
        if (r110 != ListSelectPanelAction.SHARE) goto L23;
        r102.B0(this.f229238g, -1, r113, r114);
        return true;
    L23:
        if (r110 == r100) goto L27;
        if (r110 == r101) goto L27;
        return false;
    L27:
        r102.x0(this.f229238g, -1, r113, r114);
        return true;
    L18:
        r114 = false;
    L30:
        final j0 r115 = this.f229239h;
        if (r115 != null) goto L33;
        return false;
    L33:
        ArrayList r116 = new ArrayList(r111);
        if (hu5.a.d(r116) == true) goto L100;
        final ArrayList<Document> r117 = new ArrayList(r116);
        int r118 = r115.g9(r117);
        if (AppInfoUtils.f().booleanValue() == true) goto L39;
    L42:
        boolean r119 = false;
    L43:
        fp5.a r103 = new fp5.a(r115.f228537a);
        if (r119 == false) goto L46;
        String r104 = r115.f228537a.getResources().getQuantityString(R.plurals.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Title, r117.size(), new Object[]{Integer.valueOf(r117.size())});
    L54:
        fp5.a r105 = r103.title(r104).titleSize(16).titleGravity(GravityCompat.START);
        if (r119 == false) goto L58;
        String r106 = r115.f228537a.getString(R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Desc);
    L72:
        fp5.a r107 = r105.message(r106).messageTextSize(14).messageGravity(GravityCompat.START);
        r107.f478274e = false;
        UDBaseDialogBuilder.ActionBuilder r108 = new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).textColorRes(R.color.function_danger_fill_default);
        if (r119 == false) goto L76;
        int r109 = R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Button;
    L90:
        fp5.a r120 = r107.addActionButton(r108.text(r109).onClickListener(new e0(r115, r117)));
        if (r119 == false) goto L93;
        int r121 = R.string.LarkCCM_Common_Cancel_Button;
    L94:
        UDDialog r122 = r120.addActionButton(R.id.ud_dialog_btn_secondary, r121, null).build();
        if (DialogLancet.shouldBlockDialogShow(r122) == false) goto L102;
        DialogLancet.handleBlockedDialogShow(r122);
    L99:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r122);
        goto L100
    L102:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L101
    L98:
        DialogLancet.beforeDialogShow(r122);
        r122.show();
        DialogLancet.afterDialogShow(r122);
        goto L99
    L93:
        r121 = R.string.Doc_Facade_Cancel;
        goto L94
    L76:
        if (r115.A == false) goto L81;
        if (AppInfoUtils.f().booleanValue() == true) goto L84;
    L88:
        r109 = R.string.Doc_More_Remove;
    L84:
        r109 = R.string.LarkCCM_Doubao_Drive_Remove_Button;
        goto L90
    L81:
        if (AppInfoUtils.f().booleanValue() == false) goto L87;
        if (r115.g9(r117) == 2) goto L84;
        r109 = R.string.LarkCCM_Doubao_Drive_Delete_Button;
        goto L90
    L87:
        if (r115.g9(r117) == 2) goto L88;
        r109 = R.string.Doc_Facade_Delete;
        goto L90
    L58:
        if (r115.A == false) goto L60;
        r106 = r115.f228537a.getString(R.string.Doc_List_Remove_Recent_Dialog_Content);
        goto L72
    L60:
        int r123 = r115.g9(r117);
        if (r123 != 2) goto L64;
        r106 = r115.f228537a.getString(R.string.Doc_List_Remove_Recent_Dialog_Content);
        goto L72
    L64:
        if (r123 != 3) goto L66;
        boolean r124 = true;
    L67:
        String r125 = r115.f228537a.getString(R.string.LarkCCM_NewCM_Homepage_RecentList_DeletedContentGoToTrash_DayVar_Desc);
        String[] r126 = {"{{num}}", "{{OnlyRemoveFromList}}"};
        CharSequence[] r127 = new CharSequence[2];
        r127[0] = BDLocationException.ERROR_SDK_NO_PERMISSION;
        if (r124 == false) goto L70;
        String r128 = r115.f228537a.getString(R.string.LarkCCM_NewCM_Homepage_RecentList_DeleteContentOrOnlyRemoveIt_Desc);
    L71:
        r127[1] = r128;
        r106 = TextUtils.replace(r125, r126, r127).toString().trim();
        goto L72
    L70:
        r128 = "";
        goto L71
    L66:
        r124 = false;
        goto L67
    L46:
        Context r129 = r115.f228537a;
        if (r115.A == false) goto L50;
    L51:
        int r130 = R.string.Doc_List_Remove_Recent_Dialog_Title;
    L53:
        r104 = r129.getString(r130);
        goto L54
    L50:
        if (r115.g9(r117) == 2) goto L51;
        r130 = R.string.LarkCCM_NewCM_Homepage_RecentList_Notice_Title;
        goto L53
    L39:
        if (r115.A == true) goto L42;
        if (r118 == 2) goto L42;
        r119 = true;
    L100:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        tt5.a.h("RecentDocumentFragment", "onCreateView()...");
        if (this.f229241j == false) goto L5;
        lc5.x.c().a("inflate_recent_layout");
    L5:
        this.f229238g = pd5.d.a.f528679a.a(getActivity());
        if (this.f229241j == false) goto L9;
        lc5.x.c().g("inflate_recent_layout", 0, 0);
    L9:
        return this.f229238g;
    }
}
