package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.editionmanager.executor.EditionRenameNetExecutor;
import com.bytedance.ee.bear.document.editionmanager.plugin.EditionListPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.google.gson.JsonObject;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appcontext.applifecycle.v;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionRenameItemV2 extends BaseEditionItemV2 {
    private static final String EDITION_RENAME_ITEM_ID = "edition_rename_item";
    private static final String TAG = "EditionRenameItemV2";
    private v configurationChangedListener;
    private Dialog dialog;
    private UDEditText editText;
    private boolean isReportTextChanged;
    private com.bytedance.ee.bear.document.editionmanager.executor.k mEditionNetExecutor;
    private final EditionRenameNetExecutor mNetExecutor;
    private z05.g metadata;
    private List<String> names;
    private String newEditionName;
    private UDButton primaryAction;

    public class a implements c15.c {
        public final /* synthetic */ EditionRenameItemV2 a;

        public a(EditionRenameItemV2 r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void a(EditionRenameItemV2 r0) {
        r0.lambda$showDialog$6();
    }

    public static /* synthetic */ void b(EditionRenameItemV2 r0, com.ss.android.lark.compose.foundation.toast.b r1) {
        r0.lambda$forceSecretToast$7(r1);
    }

    public static /* synthetic */ void c(EditionRenameItemV2 r0, TextView r1, CharSequence r2, SpaceEditText r3) {
        r0.lambda$buildAndShowDialog$2(r1, r2, r3);
    }

    public static /* synthetic */ void d(EditionRenameItemV2 r0, String r1) {
        r0.lambda$buildAndShowDialog$4(r1);
    }

    public static /* synthetic */ void e(EditionRenameItemV2 r0, z05.g r1, String r2) {
        r0.lambda$buildAndShowDialog$3(r1, r2);
    }

    public static /* synthetic */ void f(EditionRenameItemV2 r0, Configuration r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void g(EditionRenameItemV2 r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void h(EditionRenameItemV2 r0, DialogInterface r1) {
        r0.lambda$buildAndShowDialog$5(r1);
    }

    public int getIcon() {
        return 2131254065;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return EDITION_RENAME_ITEM_ID;
    }

    private void forceSecretToast() {
        Activity r0 = this.mActivity;
        Intrinsics.checkNotNullParameter(r0, "context");
        FlowToast.a r1 = FlowToast.a(r0);
        r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
        r1.e(2131889918);
        UDToast.b r2 = new o(this);
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
        r1.a().show();
    }

    private void getEditionList() {
        BearUrl r0 = this.pluginHost.a().getBearUrl();
        com.bytedance.ee.bear.document.editionmanager.executor.k r1 = this.mEditionNetExecutor;
        r1.getClass();
        iu5.f.a(new com.bytedance.ee.bear.document.editionmanager.executor.f(r1, r0, sbb.e.e(r0.a)));
    }

    private TextView getTipsView() {
        TextView r0 = new TextView(this.mActivity);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.setTextSize(this.mActivity.getResources().getDimension(2131168291));
        r0.setTextColor(this.mActivity.getResources().getColor(2131102093));
        r0.setText(getString(2131889370));
        r0.setVisibility(8);
        return r0;
    }

    private /* synthetic */ void lambda$new$0() {
        UDEditText r0 = this.editText;
        if (r0 == null) goto L6;
        ((InputMethodManager) r0.getContext().getSystemService("input_method")).restartInput(this.editText);
        return;
    }

    private /* synthetic */ void lambda$showDialog$6() {
        resetDialogWidth(cu5.c.e(this.mActivity));
    }

    private void showDialog() {
        Object r0 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.a(this.configurationChangedListener);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.dialog);
        if (this.dialog.getWindow() == null) goto L8;
        if (INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.dialog.getWindow()) == null) goto L8;
        this.primaryAction = INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.dialog.getWindow()).findViewById(2131391777);
        this.editText = INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.dialog.getWindow()).findViewById(2131391787);
        setPrimaryActionButton(false);
    L8:
        if (this.mActivity.isFinishing() == true) goto L11;
        com.bytedance.ee.util.ui.j.c(new j(this));
        return;
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public String getFailureText() {
        return this.mActivity.getString(2131889368);
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public String getSuccessText() {
        return this.mActivity.getString(2131889381);
    }

    private boolean canRename() {
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.k == true) goto L14;
        com.bytedance.ee.bear.k r1 = (com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class);
        if (r1.p(r0.c, r0.n, r0.k) == true) goto L10;
        return false;
    L10:
        return r1.u(this.pluginHost);
    L14:
        return false;
    }

    private int getDocumentType() {
        if (getMoreInfo() != null) goto L7;
        return -1;
    L7:
        return getMoreInfo().getType();
    }

    private boolean isForceSecret() {
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.k == false) goto L8;
        return false;
    L8:
        return fj5.a.d(r0.g, r0.i.a);
    }

    public String getTitle() {
        return getString(2131889369);
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public boolean isEnable() {
        return canRename();
    }

    public boolean isVisible() {
        return canRename();
    }

    public void onClick() {
        if (isForceSecret() == false) goto L6;
        forceSecretToast();
        return;
    L6:
        getHost().a();
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L10;
        Toast.showFailureText(this.mActivity, getString(2131887951), 0);
        return;
    L10:
        oj5.c r0 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r0);
        if (r0 == null) goto L13;
        this.metadata = getCurrEditionMetadata();
        getEditionList();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r0.getToken(), r0.getType(), buildAndShowDialog(this.metadata));
    L13:
        com.bytedance.ee.bear.k r1 = (com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class);
        r1.q(getDocumentType(), "rename_version", "ccm_doc_rename_version_view", null, null, null);
        r1.n(getDocumentType());
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public void success() {
        z05.g r0 = getCurrEditionMetadata();
        r0.b = this.newEditionName;
        this.pluginHost.a().setEditionName(this.newEditionName);
        EditionListPlugin r1 = (EditionListPlugin) this.pluginHost.findPlugin(EditionListPlugin.class);
        if (r1 == null) goto L6;
        r1.updateTitle(this.newEditionName);
        return;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionRenameItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private Dialog buildAndShowDialog(final z05.g r6) {
        final TextView r0 = getTipsView();
        if (getMoreInfo() == null) goto L5;
        String r1 = getMoreInfo().getTitle();
    L6:
        HashMap r2 = new HashMap();
        r2.put("docname", r1);
        gp5.a r3 = new gp5.a(this.mActivity).title(getTitle());
        String r4 = xo5.a.d(this.mActivity, 2131889371, r2);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        r3.j = r4;
        r3.e(r6.b);
        r3.i = 2131234968;
        r3.l = r0;
        r3.q = new k(this, r0);
        r3.a(2131887719);
        gp5.a.a r5 = new l(this, r6);
        Intrinsics.checkNotNullParameter(r5, "value");
        r3.r = r5;
        r3.c();
        gp5.a.a r7 = new m(this);
        Intrinsics.checkNotNullParameter(r7, "value");
        r3.s = r7;
        UDDialog r8 = r3.build();
        this.dialog = r8;
        r8.setOnDismissListener(new n(this));
        showDialog();
        return this.dialog;
    L5:
        r1 = "";
        goto L6
    }

    private /* synthetic */ void lambda$buildAndShowDialog$4(String r1) {
        report("cancel");
        this.isReportTextChanged = false;
    }

    private void lambda$buildAndShowDialog$5(DialogInterface r2) {
        Object r3 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.b(this.configurationChangedListener);
    }

    private void lambda$forceSecretToast$7(com.larksuite.component.universe_design.toast.c r9) {
        oj5.a r10 = getMoreInfo();
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.pluginHost.getActivity(), r10.c, com.bytedance.ee.bear.more.q.getType(r10), r10.g, com.bytedance.ee.bear.more.q.a(r10), "from_banner");
    }

    private /* synthetic */ void lambda$new$1(Configuration r3) {
        if (r3.orientation != 2) goto L5;
        boolean r4 = true;
    L6:
        resetDialogWidth(r4);
        if (r4 == true) goto L9;
        return;
    L9:
        if (this.mActivity.isFinishing() == true) goto L13;
        com.bytedance.ee.util.ui.j.d(new q(this), 100);
        return;
    L13:
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void report(String r3) {
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).h(getDocumentType(), r3);
    }

    private void resetDialogWidth(boolean r7) {
        if (ku5.c.k(this.mActivity) == true) goto L16;
        Dialog r0 = this.dialog;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isShowing() == false) goto L18;
        Window r1 = this.dialog.getWindow();
        if (r1 == null) goto L19;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r1.setSoftInputMode(48);
        if (r7 == false) goto L13;
        r2.width = (int) (((double) com.bytedance.ee.util.ui.n.v()) * 0.45d);
    L14:
        r1.setAttributes(r2);
        return;
    L13:
        r2.width = -1;
        goto L14
    L19:
        return;
    L18:
        return;
    }

    private void setPrimaryActionButton(boolean r3) {
        UDButton r0 = this.primaryAction;
        if (r0 == null) goto L10;
        r0.setEnabled(r3);
        this.primaryAction.setClickable(r3);
        UDButton r1 = this.primaryAction;
        Resources r2 = this.mActivity.getResources();
        if (r3 == false) goto L7;
        int r4 = 2131105548;
    L8:
        r1.setTextColor(r2.getColor(r4));
        return;
    L7:
        r4 = 2131106610;
        goto L8
    }

    public EditionRenameItemV2(Activity r2, DocumentPluginHost r3) {
        super(r2, r3);
        this.isReportTextChanged = false;
        this.mNetExecutor = new EditionRenameNetExecutor((NetService) org.koin.java.a.a(NetService.class));
        this.mEditionNetExecutor = new com.bytedance.ee.bear.document.editionmanager.executor.k((NetService) org.koin.java.a.a(NetService.class));
        z05.g r4 = getCurrEditionMetadata();
        if (r4 == null) goto L5;
        getEditionListName(r4, String.valueOf(sbb.e.e(r3.a().getBearUrl().a).b));
    L5:
        this.configurationChangedListener = new p(this);
    }

    public static /* synthetic */ List access$002(EditionRenameItemV2 r0, List r1) {
        r0.names = r1;
        return r1;
    }

    private void getEditionListName(z05.g r5, String r6) {
        EditionRenameNetExecutor r0 = this.mNetExecutor;
        String r7 = r5.g;
        final a r1 = new a(this);
        NetService.d r2 = r0.a.Vc(new EditionRenameNetExecutor.a());
        NetService.e r3 = new NetService.f("/space/api/platform/version/name_list/");
        r3.c = 2;
        r3.b(DocViewModel.EXTRA_PARENT_TOKEN, r7);
        r3.b("obj_type", r6);
        HashMap r8 = new HashMap();
        r8.put("Content-Type", "application/x-www-form-urlencoded");
        r3.c(r8);
        r2.a(r3).subscribe(new com.bytedance.ee.bear.document.editionmanager.executor.n(r1), new com.bytedance.ee.bear.document.editionmanager.executor.o(r1));
    }

    private void lambda$buildAndShowDialog$3(z05.g r3, String r4) {
        if (TextUtils.equals(r3.b, r4) == false) goto L5;
        tt5.a.h(TAG, "onClick Positive: title doesn't changed, so dismiss dialog");
    L6:
        report(TipCallBackData.CONFIRM);
        this.isReportTextChanged = false;
        return;
    L5:
        renameEdition(r3.a, r4.replace(DocViewModel.ENTER_CHAR, ""));
        goto L6
    }

    private void renameEdition(String r7, String r8) {
        sbb.e r0 = sbb.e.e(this.pluginHost.a().getBearUrl().a);
        this.newEditionName = r8;
        EditionRenameNetExecutor r1 = this.mNetExecutor;
        int r2 = r0.b;
        final c15.d r3 = this.mCallback;
        NetService.d r4 = r1.a.Vc(new EditionRenameNetExecutor.b());
        String r5 = String.valueOf(r2);
        NetService.e r6 = new NetService.f("/space/api/platform/version/rename/");
        r6.c = 1;
        JsonObject r9 = new JsonObject();
        r9.addProperty("token", r7);
        r9.addProperty("obj_type", r5);
        r9.addProperty("name", r8);
        r6.j = r9.toString();
        HashMap r10 = new HashMap();
        r10.put("Content-Type", "application/json");
        r6.c(r10);
        r4.a(r6).subscribe(new com.bytedance.ee.bear.document.editionmanager.executor.l(r3), new com.bytedance.ee.bear.document.editionmanager.executor.m(r3));
    }

    private void checkName(CharSequence r5, UDEditText r6, TextView r7) {
        boolean r2 = false;
        if (this.names != null) goto L5;
    L12:
        if (r6 == null) goto L14;
        r6.setBackground(AppCompatResources.getDrawable(this.mActivity, 2131234968));
    L14:
        r7.setVisibility(8);
        if (r5 != null) goto L17;
    L19:
        setPrimaryActionButton(r2);
    L21:
        if (this.isReportTextChanged == true) goto L23;
        report("version_name_input_box");
    L23:
        this.isReportTextChanged = true;
        return;
    L17:
        if (TextUtils.isEmpty(r5.toString()) == true) goto L19;
        r2 = true;
        goto L19
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L12;
        if (this.names.contains(r5.toString()) == false) goto L12;
        r7.setVisibility(0);
        if (r6 == null) goto L11;
        r6.setBackground(AppCompatResources.getDrawable(this.mActivity, 2131234969));
    L11:
        setPrimaryActionButton(false);
        goto L21
    }

    private /* synthetic */ void lambda$buildAndShowDialog$2(TextView r1, CharSequence r2, UDEditText r3) {
        checkName(r2, r3, r1);
    }
}
