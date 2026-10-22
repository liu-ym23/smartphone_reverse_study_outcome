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
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.v;
import com.bytedance.ee.bear.fabview.FabView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.d;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureHelpData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureView;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionsData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ScrollLinearLayoutManager;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemAdapter;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import rcb.f;
import sbb.e;
import wm5.a1;
import wm5.b1;
import wm5.c1;
import wm5.d1;
import wm5.e1;
import wm5.f1;
import wm5.g1;
import wm5.h1;
import wm5.j1;
import wm5.k1;
import wm5.l0;
import wm5.l1;
import wm5.m0;
import wm5.n0;
import wm5.o0;
import wm5.p0;
import wm5.q0;
import wm5.r0;
import wm5.s0;
import wm5.v0;
import wm5.w0;
import wm5.y0;
import wm5.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetEditFragment extends BaseFragment implements ocb.a {
    public static final /* synthetic */ int F = 0;
    public boolean A;
    public SelectMediaViewModel B;
    public final a C;
    public final v D;
    public boolean E;
    public EditPanelsManager e;
    public SheetEditViewModel f;
    public qm5.a g;
    public xu5.b.a h;
    public String i;
    public BearUrl j;
    public boolean k;
    public View l;
    public SheetEditorLayout m;
    public com.bytedance.ee.bear.sheet.inputbar.formula.a n;
    public FormulaSignatureView o;
    public FormulaSuggestionsData p;
    public FormulaSuggestionsData q;
    public FormulaSignatureHelpData r;
    public FabViewModel s;
    public RecyclerView t;
    public ToolbarItemAdapter u;
    public SheetInputData.SheetToolbarItem[] v;
    public boolean w;
    public View x;
    public Fragment y;
    public w0 z;

    public class a implements SelectMediaViewModel.c {
        public final /* synthetic */ SheetEditFragment a;

        public final void a() {
            SheetEditViewModel r0 = this.a.f;
            if (r0 != null) goto L5;
            return;
        L5:
            if (Boolean.TRUE.equals(r0.getActive().getValue()) == false) goto L9;
            tt5.a.h("SheetEditFragment", "select media overflow");
            this.a.f.setActive(false);
            return;
        }

        public a(SheetEditFragment r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class b {
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
        w0 r0 = this.z;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.l;
        if (r1 == null) goto L8;
        r1.removeCallbacks(r0);
    L8:
        this.z = null;
        tt5.a.h("SheetEditFragment", "cancelPendingShowKeyboard: canceled=true");
    }

    public final ToolbarItemEnum X90() {
        ToolbarItemAdapter r0 = this.u;
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
        return c.a.a.g("ccm.sheet.mobile_formula_editor_enabled");
    }

    public final void ea0() {
        if (this.m != null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.sheet.inputbar.formula.a r0 = this.n;
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        FormulaSignatureView r3 = this.o;
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
        if (this.u != null) goto L6;
        tt5.a.h("SheetEditFragment", "updateFormulaShortcutToolbar adapter null");
        return;
    L6:
        boolean r0 = Y90();
        SheetEditorLayout r2 = this.m;
        boolean r3 = true;
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r0 == false) goto L15;
        if (r4 == false) goto L15;
        boolean r1 = true;
    L16:
        SheetInputData.SheetToolbarItem[] r5 = this.v;
        if (r5 != null) goto L19;
        int r6 = -1;
    L20:
        StringBuilder r7 = new StringBuilder("updateFormulaShortcutToolbar before, formulaEditing = ");
        r7.append(r1);
        r7.append(", regularToolbarItemsNull = ");
        if (this.v != null) goto L23;
        boolean r8 = true;
    L24:
        r7.append(r8);
        r7.append(", regularCount = ");
        r7.append(r6);
        r7.append(", formulaShortcutMode = ");
        r7.append(this.u.c);
        r7.append(", adapterItemCount = ");
        r7.append(this.u.getItemCount());
        r7.append(", itemListSize = ");
        r7.append(((ArrayList) this.u.b).size());
        tt5.a.h("SheetEditFragment", r7.toString());
        if (r1 == false) goto L37;
        SheetInputData.SheetToolbarItem[] r9 = this.v;
        if (r9 != null) goto L29;
    L53:
        tt5.a.h("SheetEditFragment", "updateFormulaShortcutToolbar after, formulaShortcutMode = " + this.u.c + ", adapterItemCount = " + this.u.getItemCount() + ", itemListSize = " + ((ArrayList) this.u.b).size());
        return;
    L29:
        if (r9.length <= 0) goto L53;
        if (this.u.c == true) goto L53;
        tt5.a.h("SheetEditFragment", "updateFormulaShortcutToolbar switch to formula shortcut");
        ToolbarItemAdapter r10 = this.u;
        r10.c = true;
        int r11 = r10.d;
        if (r11 < 0) goto L35;
        if (r11 > 1) goto L35;
    L36:
        r10.notifyDataSetChanged();
    L35:
        r10.d = 0;
        goto L36
    L37:
        ToolbarItemAdapter r12 = this.u;
        if (r12.c == false) goto L49;
        SheetInputData.SheetToolbarItem[] r13 = this.v;
        if (r13 == null) goto L49;
        if (r13.length <= 0) goto L49;
        this.w = false;
        StringBuilder r14 = new StringBuilder("updateFormulaShortcutToolbar restore regular toolbar, regularToolbarItemsNull = ");
        if (this.v == null) goto L47;
        r3 = false;
    L47:
        r14.append(r3);
        r14.append(", regularCount = ");
        r14.append(r6);
        tt5.a.h("SheetEditFragment", r14.toString());
        ToolbarItemAdapter r15 = this.u;
        List r16 = Arrays.asList(this.v);
        r15.c = false;
        ((ArrayList) r15.b).clear();
        ((ArrayList) r15.b).addAll(r16);
        r15.notifyDataSetChanged();
    L49:
        if (CollectionUtils.isEmpty(r12.b) == false) goto L53;
        if (this.v == null) goto L53;
        tt5.a.h("SheetEditFragment", "updateFormulaShortcutToolbar refill empty regular toolbar, regularCount = " + r6);
        ToolbarItemAdapter r17 = this.u;
        List r18 = Arrays.asList(this.v);
        r17.c = false;
        ((ArrayList) r17.b).clear();
        ((ArrayList) r17.b).addAll(r18);
        r17.notifyDataSetChanged();
        goto L53
    L23:
        r8 = false;
        goto L24
    L19:
        r6 = r5.length;
    L15:
        r1 = false;
        goto L16
    L9:
        if (r2.n() == false) goto L11;
        r4 = true;
        goto L12
    }

    public SheetEditFragment() {
        this.A = false;
        this.C = new a(this);
        this.D = new v();
        this.E = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Runnable, wm5.w0] */
    public final void aa0() {
        W90();
        ?? r0 = new w0(this);
        this.z = r0;
        tt5.a.h("SheetEditFragment", "scheduleShowKeyboard: posted=" + this.l.postDelayed(r0, 200));
    }

    public final void da0() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        r0.height = this.f.getSheetKeyboardFixedHeight(getActivity());
        this.f.getCustomKeyboardHeight().setValue(Integer.valueOf(r0.height));
        this.x.setLayoutParams(r0);
        FragmentManager r1 = getChildFragmentManager();
        FragmentTransaction r2 = r1.beginTransaction();
        Fragment r3 = this.y;
        if (r3 == null) goto L8;
        r2.hide(r3);
    L8:
        String r4 = X90().fragment;
        if (TextUtils.isEmpty(r4) == false) goto L11;
        return;
    L11:
        FileSelectFragment r5 = r1.findFragmentByTag(r4);
        if (r5 == null) goto L14;
        r2.show(r5).commitAllowingStateLoss();
    L23:
        this.y = r5;
        return;
    L14:
        if (X90() != ToolbarItemEnum.insertImage) goto L16;
        FileSelectConfig.e r6 = this.B.getDefaultBuilder(getActivity(), false);
        ((FileSelectConfig.c) r6).a.adjustHeightByKeyboard = false;
        int r7 = this.f.getSheetKeyboardFixedHeight(getActivity());
        FileSelectConfig r8 = ((FileSelectConfig.c) r6).a;
        r8.ccmPickViewHeight = r7;
        r8.maxSelectImageNum = 1;
        r8.showGif = false;
        r8.actionType = 1;
        FragmentActivity r9 = getActivity();
        FileSelectConfig r10 = r6.a();
        int r11 = d.a;
        r5 = d.a.b(r9, r10);
    L18:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 2131387540) == true) goto L21;
        r2 = r2.add(2131387540, r5, r4);
    L21:
        r2.commitAllowingStateLoss();
        goto L23
    L16:
        Bundle r12 = new Bundle();
        r12.putBoolean("EnableExternalSelect", !this.k);
        PluginHost.writePluginHostToBundle(this, r12);
        r5 = Fragment.instantiate(getContext(), r4, r12);
        goto L18
    }

    public final void onDestroyView() {
        W90();
        this.s.cancelKeyboardHandoff();
        if (this.A == false) goto L5;
        this.g.g("text", this.m.E);
    L5:
        this.g.getClass();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("sheet_close_keyboard", new HashMap());
        com.bytedance.ee.bear.sheet.inputbar.formula.a r0 = this.n;
        if (r0 == null) goto L8;
        r0.a();
        this.n = null;
    L8:
        SheetEditorLayout r1 = this.m;
        if (r1.getVisibility() == 8) goto L11;
        r1.setVisibility(8);
        r1.i.setVisibility(8);
        r1.p();
        r1.E = false;
    L11:
        this.m.k();
        this.f.setEditable(null);
        rcb.c.c(getContext());
        pcb.a.a.b(getActivity()).a(this);
        this.B.clearSelectMediaListener(this.C);
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
        List<SheetInputData.SheetToolbarItem> r0 = this.u.b;
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
        this.u.y2(r1);
        this.t.scrollToPosition(r1);
        return;
    L12:
        r1 = -1;
        goto L13
    }

    public final void Z90(int r3) {
        if (this.E == true) goto L12;
        tt5.a.h("SheetEditFragment", "ToolbarFoldingService  resetSubPanelContainerHeight : " + r3);
        if (getHost() == null) goto L10;
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        Fragment r1 = this.y;
        if (r1 == null) goto L10;
        r0.hide(r1).commitAllowingStateLoss();
    L10:
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        r2.height = r3;
        this.x.setLayoutParams(r2);
        return;
    }

    public final void ba0(FormulaSuggestionsData r3) {
        SheetEditorLayout r0 = this.m;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.G == false) goto L16;
        this.p = r3;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r4 = this.n;
        if (r4 != null) goto L10;
    L12:
        ea0();
        SheetEditorLayout r5 = this.m;
        Runnable r1 = new v0(this);
        if (r5.G == false) goto L15;
        r5.H = r1;
        return;
    L15:
        r1.run();
        return;
    L10:
        if (r4.c() == false) goto L12;
        this.n.a();
        goto L12
    L16:
        this.p = null;
        ca0(r3);
    }

    public final void ca0(FormulaSuggestionsData r8) {
        SheetEditorLayout r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.E == true) goto L30;
        if (r8 != null) goto L8;
        return;
    L8:
        if (CollectionUtils.isEmpty(r8.getItems()) == false) goto L11;
        return;
    L11:
        if (this.n != null) goto L14;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r1 = new com.bytedance.ee.bear.sheet.inputbar.formula.a(getContext());
        this.n = r1;
        r1.f = new y0(this);
        r1.g = new z0(this);
    L14:
        com.bytedance.ee.bear.sheet.inputbar.formula.a r2 = this.n;
        SheetEditorLayout r3 = this.m;
        SheetEditViewModel r4 = this.f;
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

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        DocViewModel r3 = q.a(this, DocViewModel.class);
        this.i = r3.getToken();
        this.j = r3.getBearUrl();
        if (r3.getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r4 = true;
    L6:
        this.k = r4;
        this.B = ViewModelProviders.of(getActivity()).get(SelectMediaViewModel.class);
        this.f = q.a(this, SheetEditViewModel.class);
        this.s = (FabViewModel) q.a(this, FabViewModel.class);
        tt5.a.h("SheetEditFragment", "onCreate ViewModel instance=" + System.identityHashCode(this.f));
        this.e = ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        qm5.a r5 = new qm5.a();
        this.g = r5;
        r5.a = this.j;
        this.h = xu5.b.a(getActivity());
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void U90(SheetEditFragment r1, ToolbarItemEnum r2) {
        r1.f.notifyToolbarItemClicked(r2);
        if (r2 != ToolbarItemEnum.mention) goto L10;
        SheetEditorLayout r3 = r1.m;
        if (r3.E == false) goto L7;
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
        this.m.setPermDelegate((DocViewModel) q.a(this, DocViewModel.class));
        this.m.setEditDelegate(this.f.getEditDelegate());
        this.m.setShowInputResultCallBack(new a1(this));
        this.m.setHeightChangeListener(new b1(this));
        this.m.setFullScreenCallback(new j1(this));
        this.m.setInputTextChangedListener(new c1(this));
        this.m.setAtWindowShowCallback(new d1(this));
        this.l.findViewById(2131386165).setVisibility(8);
        RecyclerView r14 = this.l.findViewById(2131389075);
        this.t = r14;
        r14.setLayoutManager(new ScrollLinearLayoutManager(getContext()));
        ToolbarItemAdapter r15 = new ToolbarItemAdapter();
        this.u = r15;
        this.t.setAdapter(r15);
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
        this.u.a = new k1(this, r19, r1, r18);
        this.l.findViewById(2131389082).setOnClickListener(new g1(this));
        View r20 = this.l.findViewById(2131379535);
        RecyclerView.LayoutManager r110 = this.t.getLayoutManager();
        if ((r110 instanceof LinearLayoutManager) == false) goto L18;
        this.t.addOnScrollListener(new l1(this, r110, r20));
    L18:
        this.x = this.l.findViewById(2131387540);
        final FabView r21 = this.l.findViewById(2131386185);
        r21.setOnClickListener(new e1(this));
        this.f.isHideFab().observe(this, new f1(r21));
        pcb.a r22 = pcb.a.a.b(getActivity());
        r22.c(this);
        if (this.s.isWaitingForPreviousKeyboardDismiss() == true) goto L21;
    L23:
        r22.setDelayedDuration(10L);
        this.f.getToolbarItems().observe(this, new h1(this));
        this.f.setExpand(Boolean.valueOf(this.m.E));
        this.f.getInputData().observe(this, new m0(this));
        this.f.getFormat().observe(this, new n0(this));
        this.f.getDateType().observe(this, new o0(this));
        this.f.getFormulaInputStyle().observe(this, new p0(this));
        this.f.getFormulaSuggestions().observe(this, new q0(this));
        this.f.getFormulaSignatureHelp().observe(this, new r0(this));
        this.f.getFormulaHideAssist().observe(this, new s0(this));
        final FragmentActivity r23 = getActivity();
        if (r23 == null) goto L31;
        this.D.b(r23, new l0(this, r23));
        return;
    L31:
        return;
    L21:
        if (r22.isKeyboardShowing() == true) goto L23;
        this.s.markPreviousKeyboardDismissed();
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
        this.B.setSelectMediaListener(this.C);
        return LayoutInflater.from(getContext()).inflate(2131564544, r3, false);
    }

    public final void onKeyboardHeightChanged(pcb.a r3, int r4, int r5) {
        this.e.requestUpdateWebContentHeight();
        this.f.setSystemKeyboardHeight(r4);
        if (this.s.shouldIgnoreKeyboardDismiss(r4) == false) goto L11;
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
        if (f.b() == true) goto L32;
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
        this.w = false;
        goto L25
    L22:
        if (this.w == true) goto L24;
        this.m.q(false);
        goto L24
    L17:
        if (this.m.l() == false) goto L19;
        r0 = true;
        goto L20
    }
}
