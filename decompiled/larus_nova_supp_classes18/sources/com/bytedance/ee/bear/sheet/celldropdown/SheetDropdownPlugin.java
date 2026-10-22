package com.bytedance.ee.bear.sheet.celldropdown;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import pm5.h;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetDropdownPlugin extends DocumentPlugin implements p {
    private static final String JS_ON_CANCEL = "window.lark.biz.sheet.dropdown.onCancel";
    private static final String JS_ON_SWITCH_KEYBOARD = "window.lark.biz.sheet.dropdown.onSwitchToKeyboard";
    private static final String SHEET_HIDE_DROPDOWN = "biz.sheet.hideDropdown";
    private static final String SHEET_SHOW_DROPDOWN = "biz.sheet.showDropdown";
    private static final String TAG = "SheetDropdownPlugin";
    private DropdownViewModel.a delegate;
    private Observer<Boolean> observer;
    private c showDropdownHandler;
    private DropdownViewModel viewModel;

    public class a implements DropdownViewModel.a {
        public final /* synthetic */ SheetDropdownPlugin a;

        @Override // com.bytedance.ee.bear.sheet.celldropdown.DropdownViewModel.a
        public final void a() {
            tt5.a.b(SheetDropdownPlugin.TAG, "click keyboard icon...");
            SheetDropdownPlugin.access$500(this.a).setShowDropdown(false);
            SheetDropdownPlugin.access$600(this.a, SheetDropdownPlugin.JS_ON_SWITCH_KEYBOARD, new JSONObject());
        }

        @Override // com.bytedance.ee.bear.sheet.celldropdown.DropdownViewModel.a
        public final void onCancel() {
            tt5.a.b(SheetDropdownPlugin.TAG, "cancel dropdown...");
            SheetDropdownPlugin.access$400(this.a, SheetDropdownPlugin.JS_ON_CANCEL, new JSONObject());
        }

        public a(SheetDropdownPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.celldropdown.DropdownViewModel.a
        public final void b(String r3) {
            JSONObject r0 = new JSONObject();
            r0.put("val", r3);
            tt5.a.b(SheetDropdownPlugin.TAG, "click dropdown item : " + r0.toString());
            if (SheetDropdownPlugin.access$200(this.a).a == null) goto L6;
            SheetDropdownPlugin.access$200(this.a).a.b(r0);
            return;
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ SheetDropdownPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SheetDropdownPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            tt5.a.h(SheetDropdownPlugin.TAG, "hide dropdown...");
            SheetDropdownPlugin.access$500(this.a).setShowDropdown(false);
        }
    }

    public class c implements i<DropdownData> {
        public m a;
        public final /* synthetic */ SheetDropdownPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SheetDropdownPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r3, m r4) {
            DropdownData r5 = (DropdownData) r3;
            tt5.a.h(SheetDropdownPlugin.TAG, "show dropdown, dropdown data.");
            if (r5 == null) goto L7;
            DropdownData.a[] r0 = r5.parseToDropdownArray();
            this.a = r4;
            SheetDropdownPlugin.access$500(this.b).setShowDropdown(true);
            SheetDropdownPlugin.access$500(this.b).setTextColor(r5.getTextColor());
            SheetDropdownPlugin.access$500(this.b).setData(r0);
            SheetDropdownPlugin.access$500(this.b).setIsMultiple(r5.isMulti());
            return;
        }
    }

    public static /* synthetic */ void c(SheetDropdownPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return false;
    }

    private DropdownPopupFragment getDropdownFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag("DropdownPopupFragment");
    }

    private void hideDropDown() {
        DropdownPopupFragment r0 = getDropdownFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_celldropdown_SheetDropdownPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private void showDropdown() {
        if (getDropdownFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_celldropdown_SheetDropdownPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateFragment(DropdownPopupFragment.class), getActivity().getSupportFragmentManager(), "DropdownPopupFragment");
        return;
    }

    public SheetDropdownPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_celldropdown_SheetDropdownPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DropdownPopupFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ c access$200(SheetDropdownPlugin r0) {
        return r0.showDropdownHandler;
    }

    public static /* synthetic */ DropdownViewModel access$500(SheetDropdownPlugin r0) {
        return r0.viewModel;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L7;
        showDropdown();
        BaseUnspecifiedOrientationPlugin r3 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r3 == null) goto L11;
        r3.onOrientationSupportPanelShowing(this);
        return;
    L11:
        return;
    L7:
        hideDropDown();
        BaseUnspecifiedOrientationPlugin r4 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r4 == null) goto L13;
        r4.onOrientationSupportPanelDismiss(this);
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        c r0 = new c(this);
        this.showDropdownHandler = r0;
        r3.put(SHEET_SHOW_DROPDOWN, r0);
        r3.put(SHEET_HIDE_DROPDOWN, new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.viewModel = (DropdownViewModel) viewModel(DropdownViewModel.class);
        this.delegate = new a(this);
        this.observer = new h(this);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        this.viewModel.setDelegate(this.delegate);
        this.viewModel.getShowDropdown().observe(getLifecycleOwner(), this.observer);
        r3.b().registerEditPanel(getLifecycleOwner(), this.viewModel);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        this.viewModel.getShowDropdown().removeObserver(this.observer);
        this.viewModel.setDelegate(null);
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

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_celldropdown_SheetDropdownPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DropdownPopupFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DropdownPopupFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static /* synthetic */ void access$400(SheetDropdownPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }

    public static /* synthetic */ void access$600(SheetDropdownPlugin r0, String r1, JSONObject r2) {
        r0.execJS(r1, r2);
    }
}
