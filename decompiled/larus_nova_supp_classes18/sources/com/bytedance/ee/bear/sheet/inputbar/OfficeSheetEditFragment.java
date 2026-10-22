package com.bytedance.ee.bear.sheet.inputbar;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.v;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureHelpData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureView;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionsData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.OfficeToolbarItemAdapter;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ScrollLinearLayoutManager;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import ew4.g0;
import hn5.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import sbb.e;
import wm5.a0;
import wm5.c0;
import wm5.d0;
import wm5.e0;
import wm5.f;
import wm5.h;
import wm5.i;
import wm5.j;
import wm5.k;
import wm5.n;
import wm5.o;
import wm5.p;
import wm5.q;
import wm5.r;
import wm5.t;
import wm5.u;
import wm5.w;
import wm5.x;
import wm5.y;
import wm5.z;
import xu5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSheetEditFragment extends BaseFragment implements ocb.a {
    public static final /* synthetic */ int F = 0;
    public FormulaSignatureView A;
    public FormulaSuggestionsData B;
    public FormulaSuggestionsData C;
    public FormulaSignatureHelpData D;
    public FabViewModel E;
    public EditPanelsManager e;
    public OfficeSheetEditViewModel f;
    public final c g;
    public b.a h;
    public String i;
    public BearUrl j;
    public boolean k;
    public View l;
    public SheetEditorLayout m;
    public RecyclerView n;
    public OfficeToolbarItemAdapter o;
    public SheetInputData.SheetToolbarItem[] p;
    public boolean q;
    public View r;
    public Fragment s;
    public n t;
    public PluginHost u;
    public vz4.b.a v;
    public boolean w;
    public final v x;
    public boolean y;
    public com.bytedance.ee.bear.sheet.inputbar.formula.a z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileAuthResultFrom.values().length];
            a = r0;
            r0[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[FileAuthResultFrom.COME_FROM_UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final void W90() {
        n r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.l;
        if (r1 == null) goto L8;
        r1.removeCallbacks(r0);
    L8:
        this.t = null;
        tt5.a.h("SheetEditFragment", "cancelPendingShowKeyboard: canceled=true");
    }

    public final ToolbarItemEnum X90() {
        OfficeToolbarItemAdapter r0 = this.o;
        int r1 = r0.d;
        if (r1 >= 0) goto L5;
    L7:
        SheetInputData.SheetToolbarItem r2 = null;
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return ToolbarItemEnum.getToolbarItemEnumByName(r2.getId());
    L5:
        if (r1 >= ((ArrayList) r0.b).size()) goto L7;
        r2 = (SheetInputData.SheetToolbarItem) ListProtector.get(r0.b, r0.d);
        goto L8
    }

    public final boolean Y90() {
        return com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.mobile_formula_editor_enabled");
    }

    public final void ea0() {
        if (this.m != null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.sheet.inputbar.formula.a r0 = this.z;
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        FormulaSignatureView r3 = this.A;
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        SheetEditorLayout r5 = this.m;
        if (r2 == true) goto L22;
        if (r4 == true) goto L22;
        r1 = false;
    L22:
        r5.setFormulaAssistVisible(r1);
        return;
    L14:
        if (r3.getVisibility() != 0) goto L16;
        r4 = true;
        goto L17
    L8:
        if (r0.c() == false) goto L10;
        r2 = true;
        goto L11
    }

    public final void fa0() {
        if (this.o != null) goto L5;
        return;
    L5:
        boolean r0 = Y90();
        SheetEditorLayout r1 = this.m;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r0 == false) goto L14;
        if (r2 == false) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L27;
        SheetInputData.SheetToolbarItem[] r4 = this.p;
        if (r4 != null) goto L19;
        return;
    L19:
        if (r4.length <= 0) goto L41;
        OfficeToolbarItemAdapter r5 = this.o;
        if (r5.c == true) goto L42;
        r5.c = true;
        int r6 = r5.d;
        if (r6 < 0) goto L25;
        if (r6 > 1) goto L25;
    L26:
        r5.notifyDataSetChanged();
        return;
    L25:
        r5.d = 0;
        goto L26
    L42:
        return;
    L41:
        return;
    L27:
        OfficeToolbarItemAdapter r7 = this.o;
        if (r7.c == false) goto L35;
        SheetInputData.SheetToolbarItem[] r8 = this.p;
        if (r8 == null) goto L35;
        if (r8.length <= 0) goto L35;
        this.q = false;
        List r9 = Arrays.asList(r8);
        r7.c = false;
        ((ArrayList) r7.b).clear();
        ((ArrayList) r7.b).addAll(r9);
        r7.notifyDataSetChanged();
        return;
    L35:
        if (CollectionUtils.isEmpty(r7.b) == false) goto L45;
        SheetInputData.SheetToolbarItem[] r10 = this.p;
        if (r10 == null) goto L46;
        OfficeToolbarItemAdapter r11 = this.o;
        List r12 = Arrays.asList(r10);
        r11.c = false;
        ((ArrayList) r11.b).clear();
        ((ArrayList) r11.b).addAll(r12);
        r11.notifyDataSetChanged();
        return;
    L46:
        return;
    L45:
        return;
    L14:
        r3 = false;
        goto L15
    L8:
        if (r1.n() == false) goto L10;
        r2 = true;
        goto L11
    }

    public OfficeSheetEditFragment() {
        this.g = new c();
        this.w = false;
        this.x = new v();
        this.y = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Runnable, wm5.n] */
    public final void aa0() {
        W90();
        ?? r0 = new n(this);
        this.t = r0;
        tt5.a.h("SheetEditFragment", "scheduleShowKeyboard: posted=" + this.l.postDelayed(r0, 200));
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [wm5.o] */
    public final void da0() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        r0.height = this.f.getSheetKeyboardFixedHeight(getActivity());
        this.f.getCustomKeyboardHeight().setValue(Integer.valueOf(r0.height));
        this.r.setLayoutParams(r0);
        FragmentManager r1 = getChildFragmentManager();
        FragmentTransaction r2 = r1.beginTransaction();
        Fragment r3 = this.s;
        if (r3 == null) goto L8;
        r2.hide(r3);
    L8:
        ToolbarItemEnum r4 = X90();
        if (r4 != null) goto L11;
        return;
    L11:
        String r5 = r4.fragment;
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return;
    L14:
        Fragment r6 = r1.findFragmentByTag(r5);
        if (r6 == null) goto L17;
        r2.show(r6).commitAllowingStateLoss();
    L36:
        this.s = r6;
        return;
    L17:
        if (X90() != ToolbarItemEnum.insertImage) goto L29;
        PluginHost r7 = this.u;
        if (r7 != null) goto L21;
        tt5.a.k("SheetEditFragment", "pluginHost is null");
    L24:
        r6 = null;
    L26:
        if (r6 != null) goto L31;
        tt5.a.k("SheetEditFragment", "instantiateSelectMediaFragment == null");
        return;
    L31:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r5, 2131387540) == true) goto L34;
        r2 = r2.add(2131387540, r6, r5);
    L34:
        r2.commitAllowingStateLoss();
        goto L36
    L21:
        g0 r8 = (g0) r7.getUserComponent().a(g0.class);
        if (r8 != null) goto L25;
        tt5.a.k("SheetEditFragment", "sheetToolbarConfig is null");
        goto L24
    L25:
        r6 = r8.u1(this.u, this.f.getSheetKeyboardFixedHeight(getActivity()), new o(this));
        goto L26
    L29:
        Bundle r9 = new Bundle();
        r9.putBoolean("EnableExternalSelect", !this.k);
        PluginHost.writePluginHostToBundle(this, r9);
        r6 = Fragment.instantiate(getContext(), r5, r9);
        goto L31
    }

    public final void onDestroyView() {
        W90();
        this.E.cancelKeyboardHandoff();
        if (this.w == false) goto L5;
        c r0 = this.g;
        boolean r1 = this.m.B;
        r0.a.e("text", r1);
    L5:
        this.g.a.getClass();
        ((d) org.koin.java.a.a(d.class)).v("sheet_close_keyboard", new HashMap());
        com.bytedance.ee.bear.sheet.inputbar.formula.a r2 = this.z;
        if (r2 == null) goto L8;
        r2.a();
        this.z = null;
    L8:
        vz4.b.a r3 = this.v;
        if (r3 == null) goto L12;
        r3.close();
        this.v = null;
    L12:
        SheetEditorLayout r4 = this.m;
        if (r4.getVisibility() == 8) goto L15;
        r4.setVisibility(8);
        r4.i.setVisibility(8);
        r4.p();
        r4.B = false;
    L15:
        this.m.k();
        this.f.setEditable(null);
        rcb.c.c(getContext());
        pcb.a.a.b(getActivity()).a(this);
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        tt5.a.h("SheetEditFragment", "onPause");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        tt5.a.h("SheetEditFragment", "onResume ViewModel=" + System.identityHashCode(this.f));
    }

    static {
    }

    public final void V90(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        List<SheetInputData.SheetToolbarItem> r0 = this.o.b;
        int r1 = 0;
    L6:
        ArrayList r2 = (ArrayList) r0;
        if (r1 >= r2.size()) goto L12;
        if (TextUtils.equals(r5, ((SheetInputData.SheetToolbarItem) ListProtector.get(r2, r1)).getId()) == true) goto L13;
        r1 = r1 + 1;
    L13:
        if (r1 >= 0) goto L15;
        return;
    L15:
        this.o.y2(r1);
        this.n.scrollToPosition(r1);
        return;
    L12:
        r1 = -1;
        goto L13
    }

    public final void Z90(int r3) {
        if (this.y == true) goto L12;
        tt5.a.h("SheetEditFragment", "ToolbarFoldingService  resetSubPanelContainerHeight : " + r3);
        if (getHost() == null) goto L10;
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        Fragment r1 = this.s;
        if (r1 == null) goto L10;
        r0.hide(r1).commitAllowingStateLoss();
    L10:
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        r2.height = r3;
        this.r.setLayoutParams(r2);
        return;
    }

    public final void ba0(FormulaSuggestionsData r3) {
        SheetEditorLayout r0 = this.m;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.D == false) goto L16;
        this.B = r3;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r4 = this.z;
        if (r4 != null) goto L10;
    L12:
        ea0();
        SheetEditorLayout r5 = this.m;
        Runnable r1 = new p(this);
        if (r5.D == false) goto L15;
        r5.E = r1;
        return;
    L15:
        r1.run();
        return;
    L10:
        if (r4.c() == false) goto L12;
        this.z.a();
        goto L12
    L16:
        this.B = null;
        ca0(r3);
    }

    public final void ca0(FormulaSuggestionsData r8) {
        SheetEditorLayout r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.B == true) goto L30;
        if (r8 != null) goto L8;
        return;
    L8:
        if (CollectionUtils.isEmpty(r8.getItems()) == false) goto L11;
        return;
    L11:
        if (this.z != null) goto L14;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r1 = new com.bytedance.ee.bear.sheet.inputbar.formula.a(getContext());
        this.z = r1;
        r1.f = new q(this);
        r1.g = new r(this);
    L14:
        com.bytedance.ee.bear.sheet.inputbar.formula.a r2 = this.z;
        SheetEditorLayout r3 = this.m;
        OfficeSheetEditViewModel r4 = this.f;
        if (r4 == null) goto L17;
        Editable r5 = (Editable) r4.getEditable().getValue();
    L19:
        if (r5 == null) goto L26;
        FormulaSuggestionsData.Anchor r6 = r8.getAnchor();
        if (r6 == null) goto L26;
        int r7 = Math.max(0, Math.min(r6.getTokenStart(), r5.length()));
        String r9 = r5.subSequence(r7, Math.max(r7, Math.min(r6.getTokenEnd(), r5.length()))).toString();
        if (r9.startsWith("=") == false) goto L27;
        r9 = r9.substring(1);
    L27:
        Resources r10 = getResources();
        TypedValue.applyDimension(1, 220.0f, WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()));
        r2.e(r3, r8, r9);
        ea0();
        return;
    L26:
        r9 = "";
        goto L27
    L17:
        r5 = null;
        goto L19
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        PluginHost r1 = PluginHost.fromFragment(this);     // Catch: PluginInfoExtractException -> L11
        this.u = r1;     // Catch: PluginInfoExtractException -> L11
        y3 r2 = r1.getHostAbilityOrNull(y3.class);     // Catch: PluginInfoExtractException -> L11
        if (r2 == null) goto L13;
        this.i = r2.getToken();     // Catch: PluginInfoExtractException -> L11
        this.j = r2.getBearUrl();     // Catch: PluginInfoExtractException -> L11
        if (r2.getOpenSource() != DocsOpenSource.vc) goto L8;
        boolean r3 = true;
    L9:
        this.k = r3;     // Catch: PluginInfoExtractException -> L11
        goto L13
    L8:
        r3 = false;
    L13:
        this.f = com.bytedance.ee.bear.browser.plugin.q.a(this, OfficeSheetEditViewModel.class);
        this.E = (FabViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FabViewModel.class);
        tt5.a.h("SheetEditFragment", "onCreate ViewModel instance=" + System.identityHashCode(this.f));
        this.e = ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.g.a.a = this.j;
        this.h = b.a(getActivity());
        return;
    L11:
        e = move-exception;
        tt5.a.e("SheetEditFragment", "onCreate, get PluginHost failed, error: ", e, false);
        goto L13
    }

    public static void U90(OfficeSheetEditFragment r1, ToolbarItemEnum r2) {
        r1.f.notifyToolbarItemClicked(r2);
        if (r2 != ToolbarItemEnum.mention) goto L10;
        SheetEditorLayout r3 = r1.m;
        if (r3.B == false) goto L7;
        r3.j.J();
    L8:
        r1.V90(ToolbarItemEnum.text.name());
        return;
    L7:
        r3.m.J();
        goto L8
    }

    public final void onViewCreated(View r9, Bundle r10) {
        this.l = r9;
        TranslateAnimation r11 = (TranslateAnimation) AnimationUtils.loadAnimation(getActivity(), 2130772587);
        r11.setDuration(200);
        this.l.findViewById(2131386164).startAnimation(r11);
        SheetEditorLayout r12 = (SheetEditorLayout) this.l.findViewById(2131386159);
        this.m = r12;
        r12.setMobileFormulaEditorEnabled(Y90());
        this.m.setNeedShowKeyboard(false);
        SheetEditorLayout r13 = this.m;
        r13.getClass();
        Method r4 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L5
        r4.setAccessible(true);     // Catch: Exception -> L5
        SheetAtEditText r5 = r13.m;     // Catch: Exception -> L5
        Boolean r7 = Boolean.FALSE;     // Catch: Exception -> L5
        r4.invoke(r5, new Object[]{r7});     // Catch: Exception -> L5
        r4.invoke(r13.j, new Object[]{r7});     // Catch: Exception -> L5
    L29:
        Method r2 = EditText.class.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r2.setAccessible(true);     // Catch: Exception -> L9
        SheetAtEditText r6 = r13.m;     // Catch: Exception -> L9
        Boolean r8 = Boolean.FALSE;     // Catch: Exception -> L9
        r2.invoke(r6, new Object[]{r8});     // Catch: Exception -> L9
        r2.invoke(r13.j, new Object[]{r8});     // Catch: Exception -> L9
    L11:
        this.m.setAtIconVisibility(8);
        this.m.setDocumentUrl(this.j);
        this.m.setPermDelegate((DocViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class));
        this.m.setEditDelegate(this.f.getEditDelegate());
        this.m.setShowInputResultCallBack(new t(this));
        this.m.setHeightChangeListener(new u(this));
        this.m.setFullScreenCallback(new c0(this));
        this.m.setInputTextChangedListener(new wm5.v(this));
        this.m.setAtWindowShowCallback(new w(this));
        this.l.findViewById(2131386165).setVisibility(8);
        RecyclerView r14 = this.l.findViewById(2131389075);
        this.n = r14;
        r14.setLayoutManager(new ScrollLinearLayoutManager(getContext()));
        OfficeToolbarItemAdapter r15 = new OfficeToolbarItemAdapter();
        this.o = r15;
        this.n.setAdapter(r15);
        gj5.b r16 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r17 = FileBizDomain.FileBizDomainCCM;
        e r0 = e.l;
        gj5.c r18 = r16.g("CCM_ATTACHMENT_UPLOAD", r17, r0.b, "");
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r19 = jg5.e.a.a.g();
        PermissionResponse r1 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(new BaseEntity("", r0, BizDomain.FileBizDomainCCM, ""), "ATTACHMENT_UPLOAD"), null);
        ToolbarItemEnum r3 = ToolbarItemEnum.insertImage;
        if (r19 == false) goto L14;
        r3.adminLimit = !r1.getAllow();
        r3.alpha = !((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r1);
    L15:
        this.o.a = new d0(this, r19, r1, r18);
        this.l.findViewById(2131389082).setOnClickListener(new f(this));
        View r20 = this.l.findViewById(2131379535);
        RecyclerView.LayoutManager r110 = this.n.getLayoutManager();
        if ((r110 instanceof LinearLayoutManager) == false) goto L18;
        this.n.addOnScrollListener(new e0(this, r110, r20));
    L18:
        this.r = this.l.findViewById(2131387540);
        final FabView r21 = this.l.findViewById(2131386185);
        r21.setContentDescription(getString(2131889751));
        r21.setOnClickListener(new wm5.d(this));
        this.f.isHideFab().observe(this, new wm5.e(r21));
        pcb.a r22 = pcb.a.a.b(getActivity());
        r22.c(this);
        if (this.E.isWaitingForPreviousKeyboardDismiss() == true) goto L21;
    L23:
        r22.setDelayedDuration(10L);
        this.f.getToolbarItems().observe(this, new x(this));
        this.f.setExpand(Boolean.valueOf(this.m.B));
        this.f.getInputData().observe(this, new y(this));
        this.f.getFormat().observe(this, new z(this));
        this.f.getDateType().observe(this, new a0(this));
        this.f.getFormulaInputStyle().observe(this, new h(this));
        this.f.getFormulaSuggestions().observe(this, new i(this));
        this.f.getFormulaSignatureHelp().observe(this, new j(this));
        this.f.getFormulaHideAssist().observe(this, new k(this));
        final FragmentActivity r23 = getActivity();
        if (r23 == null) goto L31;
        this.x.b(r23, new wm5.c(this, r23));
        return;
    L31:
        return;
    L21:
        if (r22.isKeyboardShowing() == true) goto L23;
        this.E.markPreviousKeyboardDismissed();
        goto L23
    L14:
        boolean r24 = !r18.a;
        r3.adminLimit = r24;
        r3.alpha = r24;
    L9:
        e = move-exception;
        tt5.a.b("SheetEditorLayout", "disableShowSoftInput fail, error: " + e.toString());
    L5:
        e = move-exception;
        tt5.a.b("SheetEditorLayout", "disableShowSoftInput fail, error: " + e.toString());
        goto L29
    }

    public final Animation onCreateAnimation(int r3, boolean r4, int r5) {
        if (r4 == true) goto L8;
        if (ToolbarItemEnum.text.equals(X90()) == true) goto L8;
        return AnimationUtils.loadAnimation(getActivity(), 2130772588);
    L8:
        return super/*androidx.fragment.app.Fragment*/.onCreateAnimation(r3, r4, r5);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return LayoutInflater.from(getContext()).inflate(2131564117, r3, false);
    }

    public final void onKeyboardHeightChanged(pcb.a r3, int r4, int r5) {
        this.e.requestUpdateWebContentHeight();
        this.f.setSystemKeyboardHeight(r4);
        if (this.E.shouldIgnoreKeyboardDismiss(r4) == false) goto L11;
        if (r4 == 0) goto L6;
    L8:
        tt5.a.h("SheetEditFragment", "onKeyboardHeightChanged ignore previous picker keyboard dismiss");
        return;
    L6:
        if (ToolbarItemEnum.text.equals(X90()) == false) goto L8;
        aa0();
        goto L8
    L11:
        if (r4 == 0) goto L13;
    L25:
        if (r4 != 0) goto L32;
        if (rcb.f.b() == true) goto L32;
        if (ToolbarItemEnum.text.equals(X90()) == false) goto L32;
        this.f.setActive(false);
        tt5.a.h("SheetEditFragment", "onKeyboardHeightChanged mSheetEditViewModel setActive false");
        return;
    L32:
        if (ToolbarItemEnum.text.equals(X90()) == false) goto L36;
        Z90(r4);
        return;
    L36:
        return;
    L13:
        if (this.m == null) goto L25;
        if (Y90() == true) goto L17;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == true) goto L22;
    L24:
        this.q = false;
        goto L25
    L22:
        if (this.q == true) goto L24;
        this.m.q(false);
        goto L24
    L17:
        if (this.m.l() == false) goto L19;
        r0 = true;
        goto L20
    }
}
