package com.bytedance.ee.bear.sheet.tab;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.sheet.actionsheet.ActionSheetFragment;
import com.bytedance.ee.bear.sheet.actionsheet.ActionSheetViewModel;
import com.bytedance.ee.bear.sheet.actionsheet.f;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetModalPanelData;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabData;
import com.bytedance.ee.bear.sheet.tab.jsdata.SheetTabItem;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import jg5.e;
import mn5.j;
import tb5.m;
import vv4.k;
import w05.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabPlugin extends DocumentPlugin implements p {
    private static final String BIZ_SHEET_SET_SHEET_MODEL = "biz.sheet.setSheetModal";
    private static final String BIZ_SHEET_SET_TABS = "biz.sheet.setSheetTabs";
    private static final String JS_ON_SWITCH_SHEET = "window.lark.biz.sheet.onSwitchSheet";
    private static final String TAG = "SheetTabPlugin";
    private ActionSheetViewModel actionSheetViewModel;
    private boolean isDraggingTab;
    private jn5.c.a listener;
    private BaseUnspecifiedOrientationPlugin orientationPlugin;
    private i provider;
    private c setSheetModalHandler;
    private d setSheetTabHandler;
    private ln5.a sheetTabPresenter;

    public class a implements ActionSheetViewModel.b {
        public final /* synthetic */ SheetTabPlugin a;

        @Override // com.bytedance.ee.bear.sheet.actionsheet.ActionSheetViewModel.b
        public final void onCancel() {
            tt5.a.b(SheetTabPlugin.TAG, "SheetsActionSheetViewModel.onCancel");
            if (SheetTabPlugin.access$200(this.a) == null) goto L6;
            SheetTabPlugin.access$200(this.a).a("exit", "", "");
            return;
        }

        public a(SheetTabPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.sheet.actionsheet.ActionSheetViewModel.b
        public final void a(com.bytedance.ee.bear.sheet.actionsheet.c r4) {
            tt5.a.b(SheetTabPlugin.TAG, "SheetsActionSheetViewModel.onClickItem: " + r4);
            if (SheetTabPlugin.access$200(this.a) == null) goto L6;
            c r0 = SheetTabPlugin.access$200(this.a);
            r0.getClass();
            SheetModalPanelData.ModalItem r5 = (SheetModalPanelData.ModalItem) r4.a;
            r0.a(r5.getId(), r5.getTableId(), "");
            return;
        }

        @Override // com.bytedance.ee.bear.sheet.actionsheet.ActionSheetViewModel.b
        public final void b(com.bytedance.ee.bear.sheet.actionsheet.c r3, f r4) {
            tt5.a.b(SheetTabPlugin.TAG, "SheetsActionSheetViewModel.onClickItemRightIcon: " + r3);
            if (SheetTabPlugin.access$200(this.a) == null) goto L6;
            c r0 = SheetTabPlugin.access$200(this.a);
            r0.getClass();
            SheetModalPanelData.ModalItem r5 = (SheetModalPanelData.ModalItem) r3.a;
            String r1 = r5.getId();
            String r6 = r5.getTableId();
            r4.getClass();
            r0.a(r1, r6, null);
            return;
        }
    }

    public class b implements jn5.c.a {
        public final /* synthetic */ SheetTabPlugin a;

        @Override // jn5.c.a
        public final void b() {
            tt5.a.b(SheetTabPlugin.TAG, "onClickAddView.");
            if (SheetTabPlugin.access$300(this.a) == null) goto L6;
            SheetTabPlugin.access$300(this.a).a("add", "", null, null);
            return;
        }

        @Override // jn5.c.a
        public final void c() {
            if (SheetTabPlugin.access$500(this.a) == null) goto L6;
            SheetTabPlugin.access$500(this.a).setAnalyticSource("exit_landscape_btn");
            SheetTabPlugin.access$500(this.a).forcePortrait();
            return;
        }

        public b(SheetTabPlugin r1) {
            this.a = r1;
        }

        @Override // jn5.a
        public final void d(SheetTabItem r4) {
            tt5.a.b(SheetTabPlugin.TAG, "onClickTabItem : " + r4);
            if (SheetTabPlugin.access$300(this.a) == null) goto L6;
            d r0 = SheetTabPlugin.access$300(this.a);
            r0.getClass();
            JSONObject r1 = new JSONObject();
            r1.put("sheetId", r4.getId());
            SheetTabPlugin.access$900(r0.b).j(SheetTabPlugin.JS_ON_SWITCH_SHEET, r1);
            return;
        }

        @Override // jn5.a
        public final void e(SheetTabItem r4) {
            tt5.a.b(SheetTabPlugin.TAG, "onDoubleClickTabItem : " + r4);
            if (SheetTabPlugin.access$300(this.a) == null) goto L6;
            SheetTabPlugin.access$300(this.a).a("operate", r4.getId(), null, null);
            return;
        }

        @Override // jn5.c.a
        public final void f(boolean r2) {
            SheetTabPlugin.access$402(this.a, r2);
        }

        @Override // jn5.c.a
        public final void a(int r3, SheetTabItem r4, int r5) {
            tt5.a.b(SheetTabPlugin.TAG, "onMoveTabItem: srcPos=" + r3 + ", destPos=" + r5 + ", sheetId=" + r4.getId());
            if (SheetTabPlugin.access$300(this.a) == null) goto L6;
            SheetTabPlugin.access$300(this.a).a("reorder", r4.getId(), Integer.valueOf(r3), Integer.valueOf(r5));
            return;
        }
    }

    public class c implements tb5.i<SheetModalPanelData> {
        public m a;
        public final /* synthetic */ SheetTabPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c(SheetTabPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r3, m r4) {
            SheetModalPanelData r5 = (SheetModalPanelData) r3;
            tt5.a.b(SheetTabPlugin.TAG, "SetSheetModelHandler receives SheetModalPanelData: " + r5);
            this.a = r4;
            if (SheetModalPanelData.isValid(r5) == false) goto L5;
            SheetTabPlugin.access$1000(this.b).getSheetsActionSheetModel().setValue(kn5.a.a(r5));
            SheetTabPlugin.access$1000(this.b).setActive(true);
            return;
        L5:
            SheetTabPlugin.access$1000(this.b).setActive(false);
        }

        public final void a(String r4, String r5, String r6) {
            m r0 = this.a;
            if (r0 == null) goto L6;
            JSONObject r1 = new JSONObject();
            r1.put("itemId", r4);
            r1.put("tableId", r5);
            r1.put("iconId", r6);
            r0.b(r1);
            return;
        }
    }

    public class d implements tb5.i<SheetTabData> {
        public m a;
        public final /* synthetic */ SheetTabPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public d(SheetTabPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r6, m r7) {
            SheetTabData r8 = (SheetTabData) r6;
            this.a = r7;
            tt5.a.b(SheetTabPlugin.TAG, "SetSheetTabHandler receives sheetTabData: " + r8);
            if (r8 != null) goto L5;
        L30:
            SheetTabPlugin.access$600(this.b).a.c();
            return;
        L5:
            if (r8.getData() == null) goto L30;
            if (r8.getData().isEmpty() == true) goto L30;
            SheetTabPlugin.access$600(this.b).a.g();
            if (SheetTabPlugin.access$700(this.b) != null) goto L11;
        L13:
            SheetTabPlugin.access$600(this.b).b(r8.canEdit());
        L14:
            ln5.a r9 = SheetTabPlugin.access$600(this.b);
            boolean r0 = r8.isDraggable();
            r9.g = r0;
            jn5.c r1 = r9.a;
            boolean r3 = true;
            if (r9.c == false) goto L17;
        L20:
            boolean r10 = false;
        L21:
            r1.setDraggable(r10);
            if (SheetTabPlugin.access$400(this.b) == true) goto L32;
            ln5.a r11 = SheetTabPlugin.access$600(this.b);
            r11.b = r8;
            r11.a.d(r8.getSheetTabData());
            if (r8.canEdit() == true) goto L26;
        L28:
            r3 = false;
        L29:
            r11.a.f(r3);
            r11.a.a(r3);
            return;
        L26:
            if (r11.c == true) goto L28;
        L32:
            return;
        L17:
            if (r9.d == false) goto L20;
            if (r0 == false) goto L20;
            r10 = true;
            goto L21
        L11:
            if (SheetTabPlugin.access$700(this.b).g().getValue() == null) goto L13;
            ln5.a r12 = SheetTabPlugin.access$600(this.b);
            SheetTabPlugin r2 = this.b;
            r12.b(SheetTabPlugin.access$800(r2, (DocumentInfo) SheetTabPlugin.access$700(r2).g().getValue()));
            goto L14
        }

        public final void a(String r4, String r5, Integer r6, Integer r7) {
            m r0 = this.a;
            if (r0 == null) goto L6;
            JSONObject r1 = new JSONObject();
            r1.put("eventId", r4);
            r1.put("sheetId", r5);
            r1.put("sourceIndex", r6);
            r1.put("targetIndex", r7);
            r0.b(r1);
            return;
        }
    }

    public static /* synthetic */ void c(SheetTabPlugin r0, Boolean r1) {
        r0.lambda$registerObserver$1(r1);
    }

    public static /* synthetic */ void d(SheetTabPlugin r0, DocumentInfo r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return false;
    }

    private void dismissActionSheet() {
        this.actionSheetViewModel.setActive(false);
    }

    private void initListenerAndPresenter() {
        if (this.listener != null) goto L6;
        this.listener = new b(this);
    L6:
        if (this.sheetTabPresenter != null) goto L13;
        boolean r0 = ku5.c.k(getContext());
        if (getResources().getConfiguration().orientation != 2) goto L11;
        if (r0 == true) goto L11;
        boolean r1 = true;
    L12:
        this.sheetTabPresenter = new ln5.a(new j(), r1, r0, isVCFollow());
    L11:
        r1 = false;
    L13:
        ln5.a r2 = this.sheetTabPresenter;
        View r3 = getUIContainer().findView(2131386193);
        r2.a.b(r3);
        ln5.a r4 = this.sheetTabPresenter;
        jn5.c.a r5 = this.listener;
        r4.a.e(r5);
    }

    private void registerObserver() {
        this.actionSheetViewModel.getActive().observe(getLifecycleOwner(), new in5.d(this));
    }

    public SheetTabPlugin() {
        this.isDraggingTab = false;
        this.provider = null;
    }

    private ActionSheetFragment getActionSheetFragment() {
        FragmentManager r0 = getFragmentManager();
        int r1 = ActionSheetFragment.n;
        ActionSheetFragment r2 = r0.findFragmentByTag("ActionSheetFragment");
        if ((r2 instanceof ActionSheetFragment) == true) goto L5;
        return null;
    L5:
        return r2;
    }

    private void hideActionSheetFragment() {
        ActionSheetFragment r0 = getActionSheetFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_tab_SheetTabPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private void showActionSheetFragment() {
        if (getActionSheetFragment() != null) goto L5;
        DialogFragment r0 = instantiateFragment(ActionSheetFragment.class);
        FragmentManager r1 = getFragmentManager();
        int r2 = ActionSheetFragment.n;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_tab_SheetTabPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, r1, "ActionSheetFragment");
        iu5.f.a(new in5.c());
        return;
    L5:
        tt5.a.k(TAG, "showActionSheetFragment, fragment exist");
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_tab_SheetTabPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ActionSheetFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ ActionSheetViewModel access$1000(SheetTabPlugin r0) {
        return r0.actionSheetViewModel;
    }

    public static /* synthetic */ c access$200(SheetTabPlugin r0) {
        return r0.setSheetModalHandler;
    }

    public static /* synthetic */ d access$300(SheetTabPlugin r0) {
        return r0.setSheetTabHandler;
    }

    public static /* synthetic */ boolean access$400(SheetTabPlugin r0) {
        return r0.isDraggingTab;
    }

    public static /* synthetic */ BaseUnspecifiedOrientationPlugin access$500(SheetTabPlugin r0) {
        return r0.orientationPlugin;
    }

    public static /* synthetic */ ln5.a access$600(SheetTabPlugin r0) {
        return r0.sheetTabPresenter;
    }

    public static /* synthetic */ i access$700(SheetTabPlugin r0) {
        return r0.provider;
    }

    public static /* synthetic */ k access$900(SheetTabPlugin r0) {
        return r0.getWeb();
    }

    private boolean canEdit(DocumentInfo r6) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        BaseEntity r0 = new BaseEntity(r6.getObjToken(), sbb.e.d(r6.getType()), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r0, "EDIT"), new UserPermissionEntity(r6.getDocPermission().a, null)).getAllow();
    L7:
        return r6.canEdit();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(DocumentInfo r2) {
        ln5.a r0 = this.sheetTabPresenter;
        if (r0 == null) goto L6;
        r0.b(canEdit(r2));
        return;
    }

    private /* synthetic */ void lambda$registerObserver$1(Boolean r2) {
        if (getFragmentManager() == null) goto L8;
        if (getFragmentManager().isStateSaved() == false) goto L8;
        return;
    L8:
        if (Boolean.TRUE.equals(r2) == false) goto L10;
        showActionSheetFragment();
        return;
    L10:
        hideActionSheetFragment();
    }

    private void updateSheetTab(Configuration r2) {
        this.sheetTabPresenter.a(r2);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        d r0 = new d(this);
        this.setSheetTabHandler = r0;
        r3.put(BIZ_SHEET_SET_TABS, r0);
        c r1 = new c(this);
        this.setSheetModalHandler = r1;
        r3.put(BIZ_SHEET_SET_SHEET_MODEL, r1);
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        ActionSheetViewModel r4 = (ActionSheetViewModel) viewModel(ActionSheetViewModel.class);
        this.actionSheetViewModel = r4;
        r4.setDelegate(new a(this));
        i r5 = getHost().getHostAbility(w05.b.class).getDocumentInfoProvider();
        this.provider = r5;
        r5.j().observe(getLifecycleOwner(), new in5.e(this));
        registerObserver();
    }

    public void onConfigurationChanged(Configuration r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r1);
        dismissActionSheet();
        updateSheetTab(r1);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$402(SheetTabPlugin r0, boolean r1) {
        r0.isDraggingTab = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$800(SheetTabPlugin r0, DocumentInfo r1) {
        return r0.canEdit(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        View.inflate(getContext(), 2131564587, (ViewGroup) r3.findView(2131388779));
        this.orientationPlugin = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        initListenerAndPresenter();
        updateSheetTab(getResources().getConfiguration());
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        dismissActionSheet();
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

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_tab_SheetTabPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DialogFragment r0 = r2;
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
}
