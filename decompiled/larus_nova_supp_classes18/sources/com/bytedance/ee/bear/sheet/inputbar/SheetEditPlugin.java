package com.bytedance.ee.bear.sheet.inputbar;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.sheet.fab.FabViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.EmbedImageSegment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetUpdateData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaCatalogData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaFunctionPickData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaHideAssistData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaPickerFragment;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaShowPickerData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureHelpData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionPickData;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSuggestionsData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;
import com.bytedance.ee.bear.sheet.panel.oppanel.FabPanelViewModel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import tb5.i;
import tb5.m;
import wm5.m1;
import wm5.n1;
import wm5.o1;
import wm5.p1;
import wm5.q1;
import wm5.r1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetEditPlugin extends DocumentPlugin implements p {
    private static final String FRAGMENT_FORMULA_PICKER = "formula_picker_fragment";
    private static final String SHEET_HIDE_ASSIST = "biz.sheet.hideAssist";
    private static final String SHEET_ON_FORMULA_FUNCTION_PICK = null;
    private static final String SHEET_ON_SUGGESTION_PICK = null;
    private static final String SHEET_ON_TOOLBAR_CLICK = "javascript:lark.biz.sheet.onToolbarClick";
    private static final String SHEET_ON_UPDATE_EDIT = "javascript:lark.biz.sheet.onUpdateEdit";
    private static final String SHEET_SET_FORMULA_CATALOG = "biz.sheet.setFormulaCatalog";
    private static final String SHEET_SHOW_FORMULA_PICKER = "biz.sheet.showFormulaPicker";
    private static final String SHEET_SHOW_INPUT = "biz.sheet.showInput";
    private static final String SHEET_SHOW_SIGNATURE_HELP = "biz.sheet.showSignatureHelp";
    private static final String SHEET_SHOW_SUGGESTIONS = "biz.sheet.showSuggestions";
    private static final String SHEET_UPDATE_INPUT_STYLE = "biz.sheet.updateInputStyle";
    private static final String TAG = "SheetEditPlugin";
    private Observer<Boolean> mObserver;
    private SheetEditViewModel mViewModel;

    public class a implements wm5.a {
        public final /* synthetic */ SheetEditPlugin a;

        public a(SheetEditPlugin r1) {
            this.a = r1;
        }

        @Override // wm5.a
        public final void updateSheetEdit(int r9, List<BaseSegment> r10, String r11, String r12, String r13) {
            if (SheetEditPlugin.access$700(this.a, r10) == false) goto L5;
            r10 = SheetEditPlugin.access$800(this.a).getSegment();
        L6:
            List<BaseSegment> r4 = r10;
            SheetEditPlugin.access$900(this.a, SheetEditPlugin.SHEET_ON_UPDATE_EDIT, new SheetUpdateData(r9, r4, r11, r12, r13));
            return;
        L5:
            SheetEditPlugin.access$800(this.a).setSegment(null);
            goto L6
        }

        @Override // wm5.a
        public final void updateSheetEditWithFormulaMeta(int r15, List<BaseSegment> r16, String r17, String r18, String r19, Integer r20, Integer r21, String r22, Boolean r23) {
            if (SheetEditPlugin.access$700(this.a, r16) == false) goto L5;
            List<BaseSegment> r6 = SheetEditPlugin.access$800(this.a).getSegment();
        L6:
            SheetEditPlugin.access$1000(this.a, SheetEditPlugin.SHEET_ON_UPDATE_EDIT, new SheetUpdateData(r15, r6, r17, r18, r19, r20, r21, r22, r23));
            return;
        L5:
            SheetEditPlugin.access$800(this.a).setSegment(null);
            r6 = r16;
            goto L6
        }
    }

    public class b implements i<SheetInputData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            SheetInputData r5 = (SheetInputData) r3;
            tt5.a.h(SheetEditPlugin.TAG, "handle: inputData = " + r5);
            if (r5 != null) goto L5;
        L8:
            SheetEditPlugin.access$800(this.a).setActive(false);
            tt5.a.h(SheetEditPlugin.TAG, "handle: inputData or getData null!!!");
            return;
        L5:
            if (r5.getData() == null) goto L8;
            SheetEditPlugin.access$1100(this.a, false);
            SheetInputData.InputData r6 = r5.getData();
            r6.setSegments(ym5.b.a(r6.getValue()));
            SheetEditPlugin.access$800(this.a).setSegment(r6.getSegments());
            SheetEditPlugin.access$800(this.a).setActive(true);
            SheetEditPlugin.access$800(this.a).setToolbarItems(r5.getToolbarItems());
            SheetEditPlugin.access$800(this.a).updateInput(r5.getData());
            SheetEditPlugin.access$800(this.a).setHideFab(Boolean.valueOf(r5.isHideFAB()));
        }
    }

    public class c implements i<FormulaHideAssistData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            FormulaHideAssistData r3 = (FormulaHideAssistData) r1;
            if (SheetEditPlugin.access$1200(this.a) == false) goto L7;
            SheetEditPlugin.access$800(this.a).hideFormulaAssist(r3);
            return;
        }
    }

    public class d implements i<FormulaCatalogData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public d(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            FormulaCatalogData r5 = (FormulaCatalogData) r3;
            if (SheetEditPlugin.access$1200(this.a) == true) goto L5;
            tt5.a.k(SheetEditPlugin.TAG, "SetFormulaCatalog disabled, clear catalog");
            SheetEditPlugin.access$800(this.a).setFormulaCatalog(null);
            return;
        L5:
            StringBuilder r6 = new StringBuilder("SetFormulaCatalog catalog=");
            if (r5 != null) goto L8;
            Object r1 = "null";
        L9:
            r6.append(r1);
            tt5.a.h(SheetEditPlugin.TAG, r6.toString());
            SheetEditPlugin.access$800(this.a).setFormulaCatalog(r5);
            return;
        L8:
            r1 = r5.getCatalog();
            goto L9
        }
    }

    public class e implements i<FormulaShowPickerData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public e(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            FormulaShowPickerData r5 = (FormulaShowPickerData) r3;
            if (SheetEditPlugin.access$1200(this.a) == true) goto L5;
            tt5.a.k(SheetEditPlugin.TAG, "ShowFormulaPicker disabled, skip");
            return;
        L5:
            FormulaCatalogData r6 = SheetEditPlugin.access$800(this.a).getFormulaCatalog();
            if (r6 != null) goto L8;
        L19:
            tt5.a.k(SheetEditPlugin.TAG, "ShowFormulaPicker catalog is null, skip. catalog=" + r6);
            return;
        L8:
            if (r6.getCatalog() == null) goto L19;
            FabPanelViewModel r7 = q.c(this.a.getHost(), FabPanelViewModel.class, null);
            if (r7 != null) goto L13;
        L15:
            boolean r0 = false;
        L16:
            if (r0 == false) goto L18;
            Bundle r1 = new Bundle();
            r1.putSerializable("arg_catalog", r6.getCatalog());
            r7.openChildFragment(FormulaPickerFragment.class, r1);
            return;
        L18:
            SheetEditPlugin.access$1300(this.a, r6.getCatalog());
            return;
        L13:
            if (Boolean.TRUE.equals(r7.getActive().getValue()) == false) goto L15;
            r0 = true;
            goto L16
        }
    }

    public class f implements i<FormulaSignatureHelpData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public f(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            FormulaSignatureHelpData r3 = (FormulaSignatureHelpData) r1;
            if (SheetEditPlugin.access$1200(this.a) == false) goto L7;
            SheetEditPlugin.access$800(this.a).showFormulaSignatureHelp(r3);
            return;
        }
    }

    public class g implements i<FormulaSuggestionsData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public g(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            FormulaSuggestionsData r3 = (FormulaSuggestionsData) r1;
            if (SheetEditPlugin.access$1200(this.a) == false) goto L7;
            SheetEditPlugin.access$800(this.a).showFormulaSuggestions(r3);
            return;
        }
    }

    public class h implements i<FormulaInputStyleData> {
        public final /* synthetic */ SheetEditPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public h(SheetEditPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            FormulaInputStyleData r3 = (FormulaInputStyleData) r1;
            if (SheetEditPlugin.access$1200(this.a) == false) goto L7;
            SheetEditPlugin.access$800(this.a).updateFormulaInputStyle(r3);
            return;
        }
    }

    public static /* synthetic */ void c(SheetEditPlugin r0) {
        r0.lambda$showFormulaPickerStandalone$5();
    }

    public static /* synthetic */ void d(SheetEditPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void e(SheetEditPlugin r0, FormulaFunctionPickData r1) {
        r0.lambda$onAttachToUIContainer$3(r1);
    }

    public static /* synthetic */ void f(SheetEditPlugin r0, String r1, boolean r2) {
        r0.lambda$showFormulaPickerStandalone$4(r1, r2);
    }

    public static /* synthetic */ void g(SheetEditPlugin r0, FormulaSuggestionPickData r1) {
        r0.lambda$onAttachToUIContainer$2(r1);
    }

    public static /* synthetic */ void h(SheetEditPlugin r0, ToolbarItemEnum r1) {
        r0.lambda$onAttachToUIContainer$1(r1);
    }

    private void resetFormulaAssistState() {
        resetFormulaAssistState(true);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        SHEET_ON_SUGGESTION_PICK = SHEET_ON_UPDATE_EDIT.replace("onUpdateEdit", "onSuggestionPick");
        SHEET_ON_FORMULA_FUNCTION_PICK = SHEET_ON_UPDATE_EDIT.replace("onUpdateEdit", "onFormulaFunctionPick");
    }

    private void clearBadges() {
        String[] r0 = this.mViewModel.getBadges();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length <= 0) goto L9;
        JSONObject r1 = new JSONObject();
        r1.put("panelName", "toolbar");
        r1.put("badges", r0);
        execJS("javascript:window.lark.biz.sheet.clearBadges", r1);
        return;
    }

    private boolean isMobileFormulaEditorEnabled() {
        return com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.sheet.mobile_formula_editor_enabled");
    }

    private void removeFormulaPicker() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "removeFormulaPicker activity is null, skip");
        return;
    L6:
        FragmentManager r1 = r0.getSupportFragmentManager();
        Fragment r2 = r1.findFragmentByTag(FRAGMENT_FORMULA_PICKER);
        if (r2 == null) goto L10;
        r1.beginTransaction().setCustomAnimations(0, 2130772114).remove(r2).commitAllowingStateLoss();
        return;
    }

    public boolean shouldDisableLandscape() {
        return !ku5.c.k(getContext());
    }

    public SheetEditPlugin() {
    }

    private /* synthetic */ void lambda$showFormulaPickerStandalone$5() {
        removeFormulaPicker();
    }

    public static /* synthetic */ boolean access$1200(SheetEditPlugin r0) {
        return r0.isMobileFormulaEditorEnabled();
    }

    public static /* synthetic */ SheetEditViewModel access$800(SheetEditPlugin r0) {
        return r0.mViewModel;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r3) {
        tt5.a.b(TAG, "observe active = " + r3);
        notifyOrientationSupportPanelState(r3);
        if (Boolean.TRUE.equals(r3) == false) goto L5;
        addOrReplaceFragment(SheetEditFragment.class);
        return;
    L5:
        removeFragment();
        clearBadges();
        resetFormulaAssistState();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$1(ToolbarItemEnum r3) {
        JSONObject r0 = new JSONObject();
        r0.put(ResourceData.KEY_ID, r3.name());
        execJS(SHEET_ON_TOOLBAR_CLICK, r0);
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$2(FormulaSuggestionPickData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        execJS(SHEET_ON_SUGGESTION_PICK, r2);
    }

    private void lambda$onAttachToUIContainer$3(FormulaFunctionPickData r4) {
        if (r4 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L6
        r0.put("funcName", r4.getFuncName());     // Catch: Throwable -> L6
        execJS(SHEET_ON_FORMULA_FUNCTION_PICK, r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        tt5.a.e(TAG, "onFormulaFunctionPick execJS failed", th, false);
    }

    private void notifyOrientationSupportPanelState(Boolean r3) {
        BaseUnspecifiedOrientationPlugin r0 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (Boolean.TRUE.equals(r3) == false) goto L8;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L8:
        r0.onOrientationSupportPanelDismiss(this);
    }

    private void resetFormulaAssistState(boolean r3) {
        SheetEditViewModel r0 = this.mViewModel;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 == false) goto L8;
        r0.updateFormulaInputStyle(null);
        this.mViewModel.showFormulaSignatureHelp(null);
    L8:
        this.mViewModel.showFormulaSuggestions(null);
        this.mViewModel.setShowFormulaPicker(false);
    }

    private boolean shouldHandleEmbedImageSegment(List<BaseSegment> r2) {
        List<BaseSegment> r0 = this.mViewModel.getSegment();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r2.isEmpty() == false) goto L18;
        Iterator<BaseSegment> r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        if ((r3.next() instanceof EmbedImageSegment) == false) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showFormulaPickerStandalone(FormulaCatalogData.Catalog r5) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "showFormulaPickerStandalone activity is null, skip");
        return;
    L6:
        rcb.c.c(r0);
        FormulaPickerFragment r1 = new FormulaPickerFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("arg_catalog", r5);
        r1.setArguments(r2);
        r1.f = new q1(this);
        r1.g = new r1(this);
        FragmentManager r6 = r0.getSupportFragmentManager();
        Fragment r3 = r6.findFragmentByTag(FRAGMENT_FORMULA_PICKER);
        if (r3 == null) goto L9;
        r6.beginTransaction().remove(r3).commitAllowingStateLoss();
    L9:
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_inputbar_SheetEditPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r6.beginTransaction().setCustomAnimations(2130772113, 2130772114), R.id.content, r1, FRAGMENT_FORMULA_PICKER).commitAllowingStateLoss();
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        com.bytedance.ee.bear.document.at.m.a();
        this.mViewModel = q.c(r3, SheetEditViewModel.class, null);
        tt5.a.h(TAG, "onAttachToHost ViewModel instance=" + System.identityHashCode(this.mViewModel));
        this.mObserver = new p1(this);
        DocViewModel r4 = getDocViewModel();
        SheetEditViewModel r0 = this.mViewModel;
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        r0.setAtVc(r5);
        return;
    L5:
        if (r4.getOpenSource() != DocsOpenSource.vc) goto L7;
        r5 = true;
        goto L8
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ void access$1100(SheetEditPlugin r0, boolean r1) {
        r0.resetFormulaAssistState(r1);
    }

    public static /* synthetic */ void access$1300(SheetEditPlugin r0, FormulaCatalogData.Catalog r1) {
        r0.showFormulaPickerStandalone(r1);
    }

    public static /* synthetic */ boolean access$700(SheetEditPlugin r0, List r1) {
        return r0.shouldHandleEmbedImageSegment(r1);
    }

    private void lambda$showFormulaPickerStandalone$4(String r4, boolean r5) {
        ((FabViewModel) q.c(getHost(), FabViewModel.class, null)).startKeyboardHandoff(r5);
        this.mViewModel.notifyFormulaFunctionPicked(r4);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        bindBridgeHandlerAutoUnbind(SHEET_SHOW_INPUT, new b(this));
        bindBridgeHandlerAutoUnbind(SHEET_SET_FORMULA_CATALOG, new d(this));
        bindBridgeHandlerAutoUnbind(SHEET_SHOW_FORMULA_PICKER, new e(this));
        bindBridgeHandlerAutoUnbind(SHEET_UPDATE_INPUT_STYLE, new h(this));
        bindBridgeHandlerAutoUnbind(SHEET_SHOW_SUGGESTIONS, new g(this));
        bindBridgeHandlerAutoUnbind(SHEET_SHOW_SIGNATURE_HELP, new f(this));
        bindBridgeHandlerAutoUnbind(SHEET_HIDE_ASSIST, new c(this));
        r2.b().registerEditPanel(getLifecycleOwner(), this.mViewModel);
        this.mViewModel.getActive().observe(getLifecycleOwner(), this.mObserver);
        this.mViewModel.setEditDelegate(new a(this));
        this.mViewModel.onToolbarItemClicked().observe(getLifecycleOwner(), new m1(this));
        this.mViewModel.getFormulaSuggestionPick().observe(getLifecycleOwner(), new n1(this));
        this.mViewModel.getFormulaFunctionPick().observe(getLifecycleOwner(), new o1(this));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        this.mViewModel.setEditDelegate(null);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public static /* synthetic */ void access$1000(SheetEditPlugin r0, String r1, NonProguard r2) {
        r0.execJS(r1, r2);
    }

    public static /* synthetic */ void access$900(SheetEditPlugin r0, String r1, NonProguard r2) {
        r0.execJS(r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_inputbar_SheetEditPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }
}
