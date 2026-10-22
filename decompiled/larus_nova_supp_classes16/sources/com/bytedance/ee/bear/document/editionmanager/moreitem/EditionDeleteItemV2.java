package com.bytedance.ee.bear.document.editionmanager.moreitem;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.google.gson.JsonObject;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appcontext.applifecycle.v;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditionDeleteItemV2 extends BaseEditionItemV2 {
    private static final String EDITION_DELETE_ITEM_ID = "edition_delete_item";
    private static final float HEIGHT_PERCENT_45 = 0.45f;
    private static final int RETENTION_DAYS_30 = 30;
    private static final int RETENTION_DAYS_60 = 60;
    private v configurationChangedListener;
    private UDDialog deleteConfirmDialog;
    private final com.bytedance.ee.bear.document.editionmanager.executor.c mNetExecutor;

    public static /* synthetic */ void a(EditionDeleteItemV2 r0) {
        r0.lambda$buildAndShowDialog$3();
    }

    public static /* synthetic */ void b(EditionDeleteItemV2 r0, z05.g r1, String r2, DialogInterface r3, int r4) {
        r0.lambda$buildAndShowDialog$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void c(String r0, DialogInterface r1, int r2) {
        lambda$buildAndShowDialog$2(r0, r1, r2);
    }

    public static /* synthetic */ void d(EditionDeleteItemV2 r0, Configuration r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void e(EditionDeleteItemV2 r0, DialogInterface r1) {
        r0.lambda$buildAndShowDialog$4(r1);
    }

    public static /* synthetic */ void f(EditionDeleteItemV2 r0, com.ss.android.lark.compose.foundation.toast.b r1) {
        r0.lambda$forceSecretToast$5(r1);
    }

    public int getIcon() {
        return 2131254201;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return EDITION_DELETE_ITEM_ID;
    }

    private void forceSecretToast() {
        Activity r0 = this.mActivity;
        Intrinsics.checkNotNullParameter(r0, "context");
        FlowToast.a r1 = FlowToast.a(r0);
        r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
        r1.e(2131889918);
        UDToast.b r2 = new e(this);
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
        r1.a().show();
    }

    private int getRetentionDays() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
        return RETENTION_DAYS_60;
    L5:
        return 30;
    }

    private /* synthetic */ void lambda$buildAndShowDialog$3() {
        resetDialogWidth(cu5.c.e(this.mActivity));
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public String getSuccessText() {
        return this.mActivity.getString(2131889375);
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public void success() {
        BearUrl r0 = this.pluginHost.a().getBearUrl();
        String r1 = r0.b;
        String r2 = r0.n;
        Map<String, z05.g> r3 = z05.f.a;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.remove(z05.f.b(r1, r2));
        String r5 = com.bytedance.ee.bear.route.c.f(this.pluginHost.a().getOriginBearUrl());
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).D4(r5) == false) goto L5;
    L10:
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).j(null);
        return;
    L5:
        if (AppInfoUtils.f().booleanValue() == false) goto L9;
        com.bytedance.ee.bear.document.container.a r6 = (com.bytedance.ee.bear.document.container.a) this.pluginHost.getHostAbilityOrNull(com.bytedance.ee.bear.document.container.a.class);
        if (r6 == null) goto L10;
        r6.w();
        goto L10
    L9:
        this.mActivity.finish();
        goto L10
    }

    private boolean canDelete() {
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.k == true) goto L14;
        com.bytedance.ee.bear.k r1 = (com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class);
        if (r1.p(r0.c, r0.n, r0.k) == true) goto L10;
        return false;
    L10:
        return r1.f(this.pluginHost);
    L14:
        return false;
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

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public String getFailureText() {
        oj5.a r0 = getMoreInfo();
        if (r0 == null) goto L11;
        if (getCurrEditionMetadata() == null) goto L11;
        gj5.c r1 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_MOVE_RECYCLE_BIN", FileBizDomain.FileBizDomainCCM, r0.getType(), getCurrEditionMetadata().a);
        if (FileAuthResultFrom.COME_FROM_FILE_POLICY.equals(r1.b) == false) goto L11;
        return "";
    L11:
        return this.mActivity.getString(2131889360);
    }

    public String getTitle() {
        return getString(2131889361);
    }

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public boolean isEnable() {
        return canDelete();
    }

    public boolean isVisible() {
        return canDelete();
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
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L13;
        return;
    L13:
        String r1 = String.valueOf(r0.getType());
        buildAndShowDialog(getCurrEditionMetadata(), r1);
        int r2 = sbb.e.g(r1);
        com.bytedance.ee.bear.k r3 = (com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class);
        r3.q(r2, "delete_version", "none", null, null, null);
        r3.k(r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionDeleteItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(UDDialog r1) {
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

    private void lambda$buildAndShowDialog$4(DialogInterface r2) {
        Object r3 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.b(this.configurationChangedListener);
    }

    private void lambda$forceSecretToast$5(com.larksuite.component.universe_design.toast.c r9) {
        oj5.a r10 = getMoreInfo();
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.pluginHost.getActivity(), r10.c, com.bytedance.ee.bear.more.q.getType(r10), r10.g, com.bytedance.ee.bear.more.q.a(r10), "from_banner");
    }

    private /* synthetic */ void lambda$new$0(Configuration r2) {
        if (r2.orientation != 2) goto L5;
        boolean r3 = true;
    L6:
        resetDialogWidth(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    private void resetDialogWidth(boolean r4) {
        if (ku5.c.k(this.mActivity) == true) goto L16;
        UDDialog r0 = this.deleteConfirmDialog;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isShowing() == false) goto L18;
        Window r1 = this.deleteConfirmDialog.getWindow();
        if (r1 == null) goto L19;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r4 == false) goto L13;
        r2.width = (int) (com.bytedance.ee.util.ui.n.v() * HEIGHT_PERCENT_45);
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

    @Override // com.bytedance.ee.bear.document.editionmanager.moreitem.BaseEditionItemV2
    public void failed(int r2) {
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).j(null);
    }

    public EditionDeleteItemV2(Activity r1, DocumentPluginHost r2) {
        super(r1, r2);
        this.mNetExecutor = new com.bytedance.ee.bear.document.editionmanager.executor.c((NetService) org.koin.java.a.a(NetService.class));
        this.configurationChangedListener = new f(this);
    }

    private void buildAndShowDialog(final z05.g r7, final String r8) {
        HashMap r0 = new HashMap();
        r0.put("version_name", r7.b);
        String r1 = String.valueOf(getRetentionDays());
        fp5.a r2 = new fp5.a(this.mActivity).title(xo5.a.d(this.mActivity, 2131889362, r0)).titleSize(16).titleGravity(8388611).message(xo5.a.c(this.mActivity, 2131889363, "num", r1)).messageTextSize(14).messageGravity(8388611);
        r2.e = false;
        UDDialog r9 = r2.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131887736).onClickListener(new a(this, r7, r8))).addActionButton(2131391778, 2131887716, new b(r8)).build();
        this.deleteConfirmDialog = r9;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_editionmanager_moreitem_EditionDeleteItemV2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r9);
        if (this.mActivity.isFinishing() == true) goto L5;
        com.bytedance.ee.util.ui.j.c(new c(this));
    L5:
        Object r10 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.a(this.configurationChangedListener);
        this.deleteConfirmDialog.setOnDismissListener(new d(this));
    }

    private void deleteEdition(String r6, String r7, String r8) {
        com.bytedance.ee.bear.document.editionmanager.executor.c r0 = this.mNetExecutor;
        final c15.d r1 = this.mCallback;
        NetService.d r2 = r0.a.Vc(new com.bytedance.ee.bear.document.editionmanager.executor.c.a());
        NetService.e r3 = new NetService.f("/space/api/platform/version/delete/");
        r3.c = 1;
        JsonObject r4 = new JsonObject();
        r4.addProperty("token", r6);
        r4.addProperty("obj_type", r8);
        r3.j = r4.toString();
        HashMap r9 = new HashMap();
        r9.put("Content-Type", "application/json");
        r3.c(r9);
        r2.a(r3).subscribe(new com.bytedance.ee.bear.document.editionmanager.executor.a(r1), new com.bytedance.ee.bear.document.editionmanager.executor.b(r1));
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).j(r7);
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).o(sbb.e.g(r8), "delete");
    }

    private static /* synthetic */ void lambda$buildAndShowDialog$2(String r0, DialogInterface r1, int r2) {
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).o(sbb.e.g(r0), "cancel");
    }

    private void lambda$buildAndShowDialog$1(z05.g r1, String r2, DialogInterface r3, int r4) {
        deleteEdition(r1.a, r1.f, r2);
    }
}
