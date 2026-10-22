package jg5;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyAuditEscapePanel;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyPermissionPanel;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.BitableProInviteMemberFragment;
import com.bytedance.ee.bear.middleground.permission.custompassword.CustomPasswordSettingFragment;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.secret.InputReasonFragment;
import com.bytedance.ee.bear.middleground.permission.secret.ReSubmitApplyDialog;
import com.bytedance.ee.bear.middleground.permission.secret.ReSubmitApplyDialogFragment;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.secret.SecretLevelFragment;
import com.bytedance.ee.bear.middleground.permission.secret.SecretReviewModel;
import com.bytedance.ee.bear.middleground.permission.setting.appsetting.RealNameConfig;
import com.bytedance.ee.bear.middleground.permission.setting.bitable.BitableProView;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.DocumentLinkShareView;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.FolderLinkShareView;
import com.bytedance.ee.bear.middleground.permission.setting.permselect.SelectPermTypeFragment;
import com.bytedance.ee.bear.middleground.permission.setting.sharepermset.ShareFolderPermSetView;
import com.bytedance.ee.bear.middleground.permission.setting.sharepermset.SharePermSetView;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground.permission.share.provider.DocShareProvider;
import com.bytedance.ee.bear.middleground.permission.share.provider.FolderShareProvider;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.utils.l0;
import com.larus.office.base.share.OfficeSdkSharePanelProvider;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.ContextsKt;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import hi5.x;
import hi5.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements cj5.c {
    public boolean a;
    public com.bytedance.ee.bear.share.export.o b;
    public final Set<com.bytedance.ee.bear.share.export.l> c;

    @Inject
    public q() {
        this.b = new t();
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final com.bytedance.ee.bear.share.export.o getProvider() {
        return this.b;
    }

    public static void a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        tt5.a.h("ShareUIService", "setHasShowLeaderAutoAuthDialog()...context is null or objToken is empty.");
        return;
    L6:
        ay4.b.d("platform", 6).putBoolean(du5.b.g(r2), true);
    }

    @Override // cj5.c, com.bytedance.ee.bear.share.export.j
    public final DialogFragment E0(ShareParams r3) {
        tt5.a.h("ShareUIService", "showShareFragment stage=dispatch type=" + r3.getType());
    L9:
        e = move-exception;
        tt5.a.d("ShareUIService", "showShareFragment stage=dispatch result=failed reason=runtime_exception");
        throw e;
    L4:
        if (r3.getType() != 0) goto L8;
        return fa(r3);
    L8:
        return N2(r3, null, null, null);
    }

    @Override // cj5.c
    public final void Ee(th5.b r8) {
        HashMap r2 = new HashMap();
        r2.put(ResourceData.KEY_TOKEN, r8.b);
        r2.put(ResourceData.KEY_TYPE, Integer.valueOf(r8.getType()));
        r2.put("isWiki", Boolean.valueOf(r8.d));
        r2.put("sceneType", Integer.valueOf(r8.e.getValue()));
        EntityType r0 = r8.f;
        if (r0 == null) goto L5;
        r2.put("entityType", Integer.valueOf(r0.getValue()));
    L5:
        r2.put("shareExternalReason", Integer.valueOf(r8.g));
        r2.put("sharePartnerTenantReason", Integer.valueOf(r8.h));
        HashMap<String, Serializable> r1 = r8.i;
        if (r1 == null) goto L8;
        r2.put("statisticParams", r1);
    L8:
        Integer r3 = r8.j;
        if (r3 == null) goto L12;
        r2.put("updatePermissionType", r3);
    L12:
        if (TextUtils.isEmpty(r8.k) == true) goto L14;
        r2.put("updatePermissionInfo", r8.k);
    L14:
        Bundle r4 = new Bundle();
        de5.a r6 = new de5.a(l0.a().toString(), r2, new HashMap(), r4, null);
        ((CCMLynxPageRouter) org.koin.java.a.a(CCMLynxPageRouter.class)).c(r8.getContext(), CCMLynxPageRouter.PageType.ADJUST_SETTINGS_PANEL, r6);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void I5(OfficeSdkSharePanelProvider r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void R5(com.bytedance.ee.bear.share.export.l r2) {
        this.c.remove(r2);
    }

    @Override // cj5.c
    public final DialogFragment fa(ShareParams r4) {
        FolderShareProvider r1 = new FolderShareProvider(new ni5.a(r4, new ShareFolderInfo()));
        return ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ha(r4, null, r1);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void ob(com.bytedance.ee.bear.share.export.l r2) {
        this.c.add(r2);
    }

    @Override // cj5.c
    public final void B7(FragmentActivity r3, String r4) {
        int r0 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "json");
        List r5 = JSON.parseArray(r4, NotNotifyUserEntity.class);     // Catch: Exception -> L10
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r3, "activity");     // Catch: Exception -> L10
        String r6 = ui5.a.a(r5);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r6) == true) goto L16;
        Toast.showSuccessText(r3, xo5.a.c(r3, 2131888101, "users", r6));     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        tt5.a.f("NotNotifyOperator", e, false);
    }

    @Override // cj5.c
    public final View g2(Context r2, ShareParams r3) {
        ShareFolderPermSetView r0 = new ShareFolderPermSetView(r2);
        r0.setShareParams(r3);
        return r0;
    }

    @Override // cj5.c
    public final DialogFragment id(ShareParams r2, Bundle r3) {
        return N2(r2, r3, null, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.bytedance.ee.bear.middleground.permission.setting.bitable.BitableProView] */
    @Override // cj5.c
    public final View n6(Context r2, boolean r3) {
        ?? r0 = new BitableProView(r2);
        r0.setIsFa(r3);
        return r0;
    }

    @Override // cj5.c
    public final UDDialog nc(Context r14, final String r15) {
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r3 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r4 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r2, r3, r4, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_automatic_perm_finish_view", r1);
        int r5 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r6 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permission.leader_perm_tips_dialog");
        tt5.a.h("PermFGUtils", "isLeaderAutoAuthTipsDialogEnable()...enable = " + r6);
        if (r6 == true) goto L10;
        tt5.a.h("ShareUIService", "isLeaderAutoAuthTipsDialogEnable()...fg close.");
        return null;
    L10:
        if (r14 != null) goto L14;
        tt5.a.h("ShareUIService", "showLeaderAutoAuthDialog()...context is null.");
        return null;
    L14:
        if (TextUtils.isEmpty(r15) == false) goto L18;
        tt5.a.h("ShareUIService", "showLeaderAutoAuthDialog()...objToken is empty.");
        return null;
    L18:
        if (TextUtils.isEmpty(r15) == false) goto L20;
        boolean r7 = false;
    L21:
        if (r7 == false) goto L25;
        tt5.a.h("ShareUIService", "showLeaderAutoAuthDialog()...document has show, return.");
        return null;
    L25:
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("ccm_permission_leader_auto_auth") == false) goto L28;
        tt5.a.h("ShareUIService", "showLeaderAutoAuthDialog()...not notify.");
        return null;
    L28:
        BearUDDialogBuilder r8 = new BearUDDialogBuilder(r14);
        r8.a.message(2131888803);
        r8.a.cancelable(false);
        BearUDDialogBuilder.a r16 = new BearUDDialogBuilder.a();
        r16.a = 2131391777;
        r16.b = 2131887759;
        r16.d = 2131105548;
        r16.f = new m(this, r15);
        r8.d(r16);
        BearUDDialogBuilder.a r17 = new BearUDDialogBuilder.a();
        r17.a = 2131391778;
        r17.b = 2131888802;
        r17.d = 2131106622;
        r17.f = new n(this, r15);
        r8.d(r17);
        UDDialog r18 = r8.e();
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r18);
    L33:
        this.a = true;
        r18.setOnDismissListener(new o(this));
        r18.setOnCancelListener(new p(this));
        JSONObject r19 = new JSONObject();
        String r9 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r10 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L36;
        String r11 = ThumbGlideUrl.SOURCE_VC;
    L37:
        com.bytedance.ee.bear.middleground.permission.c.a(r19, r9, r10, r11, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r19.put("toast_source", "superior_management_set");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_automatic_perm_view", r19);
        return r18;
    L36:
        r11 = "none";
        goto L37
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L32:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L33
    L20:
        r7 = ay4.b.d("platform", 6).getBoolean(du5.b.g(r15), false);
        goto L21
    L5:
        r4 = "none";
        goto L6
    }

    @Override // cj5.c
    public final View s7(Context r2, ShareParams r3) {
        SharePermSetView r0 = new SharePermSetView(r2);
        r0.setShareParams(r3);
        return r0;
    }

    @Override // cj5.c
    public final void H9(com.bytedance.ee.bear.share.export.i r3, SharePanelState r4, km5.a r5) {
        Iterator<com.bytedance.ee.bear.share.export.l> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onSharePanelChanged(r3, r4, r5);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.FolderLinkShareView] */
    @Override // cj5.c
    public final View T8(Context r2, boolean r3, String r4) {
        ?? r0 = new FolderLinkShareView(r2);
        Intrinsics.checkNotNullParameter(r4, "module");
        r0.f = r3;
        r0.g = r4;
        return r0;
    }

    @Override // cj5.c
    public final DialogFragment Xe(FragmentActivity r4, boolean r5, int r6) {
        int r0 = hj5.a.a;
        boolean r1 = true;
        if (r6 == 0) goto L7;
        if (r6 == 1) goto L7;
        r1 = false;
    L7:
        int r7 = SelectPermTypeFragment.q;
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter("permission_set", "location");
        Bundle r2 = new Bundle();
        r2.putBoolean("extra_will_lock", r5);
        r2.putString("extra_location", "permission_set");
        r2.putBoolean("extra_is_container_selected", r1);
        String r8 = SelectPermTypeFragment.class.getName();
        Fragment r9 = Fragment.instantiate(r4, r8, r2);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        Fragment r10 = (DialogFragment) r9;
        FragmentManager r11 = r4.getSupportFragmentManager();
        if ((r10 instanceof Fragment) == false) goto L10;
        Fragment r3 = r10;
    L11:
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, r8, r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r3, r12) == false) goto L18;
    L16:
        return r10;
    L18:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r10.show(r11, r8);
        goto L16
    L10:
        r3 = null;
        goto L11
    }

    @Override // cj5.c
    public final void G8(Context r17, final String r18, final int r19, int r20) {
        int r4 = x.a;
        RealNameConfig r5 = (RealNameConfig) SettingManager.getInstance().get(RealNameConfig.class);
        final String r6 = r5.getFeishuAuth();
        final String r7 = r5.getUserRealNameAuth();
        final HashMap r8 = new HashMap();
        r8.put("from", "public_doc_control");
        if (2502 != r20) goto L10;
        Intrinsics.checkNotNullParameter(r17, "context");
        UDDialogBuilder r3 = new UDDialogBuilder(r17);
        r3.autoDismiss(true);
        r3.title(2131889304);
        String r0 = r17.getString(2131889303);
        Intrinsics.checkNotNullParameter(r0, "value");
        r3.message(r0);
        r3.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r1 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r1, "value");
        if (r1 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L7;
        UDBaseDialogBuilder.ActionBottomOrientation r2 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L8:
        r3.actionButtonOrientation(r2);
        DialogInterface.OnClickListener r9 = new hi5.e(r8, r7, r18, r19);
        r3.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131889310).textColorRes(2131101111).onClickListener(r9));
        r3.addActionButton(2131391778, 2131889307, new hi5.i());
        x.a(r3.build());
        com.bytedance.ee.bear.middleground.permission.c.x(r18, r19, "tenant_member");
        return;
    L7:
        r2 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L8
    L10:
        if (2501 != r20) goto L22;
        String r10 = r17.getString(2131889309);
        Intrinsics.checkNotNullParameter(r17, "context");
        UDDialogBuilder r11 = new UDDialogBuilder(r17);
        r11.autoDismiss(true);
        r11.title(2131889304);
        Intrinsics.checkNotNullParameter(r10, "value");
        r11.message(r10);
        r11.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r12 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r12, "value");
        if (r12 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L14;
        UDBaseDialogBuilder.ActionBottomOrientation r13 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L15:
        r11.actionButtonOrientation(r13);
        DialogInterface.OnClickListener r14 = new hi5.j(r8, r6, r18, r19);
        r11.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131889305).textColorRes(2131101111).onClickListener(r14));
        r11.addActionButton(2131391778, 2131889308, new hi5.k(r18, r19));
        UDDialog r15 = r11.build();
        x.a(r15);
        TextView r16 = (TextView) r15.findViewById(2131391794);
        hi5.t r21 = new hi5.t(r8, r7, r18, r19);
        String r22 = r17.getString(2131889310);     // Catch: Throwable -> L18
        int r23 = r22.length();     // Catch: Throwable -> L18
        String r24 = r10.replace("{{real_name}}", r22);     // Catch: Throwable -> L18
        int r25 = r24.indexOf(r22);     // Catch: Throwable -> L18
        SpannableString r26 = new SpannableString(r24);     // Catch: Throwable -> L18
        r26.setSpan(new y(r17, new hi5.s(r21, r15)), r25, r23 + r25, 33);     // Catch: Throwable -> L18
        r16.setText(r26);     // Catch: Throwable -> L18
        r16.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L18
        r16.setHighlightColor(0);     // Catch: Throwable -> L18
    L20:
        com.bytedance.ee.bear.middleground.permission.c.x(r18, r19, "admin");
        return;
    L18:
        th = move-exception;
        tt5.a.d("LinkShareUtils", th.getMessage());
        goto L20
    L14:
        r13 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L15
    L22:
        if (2503 != r20) goto L32;
        if (r19 != 0) goto L25;
        String r27 = r17.getString(2131889306);
    L26:
        Intrinsics.checkNotNullParameter(r17, "context");
        UDDialogBuilder r28 = new UDDialogBuilder(r17);
        r28.autoDismiss(true);
        r28.title(2131889304);
        Intrinsics.checkNotNullParameter(r27, "value");
        r28.message(r27);
        r28.messageGravity(8388611);
        r28.addActionButton(2131391777, 2131889307, new hi5.l());
        x.a(r28.build());
        com.bytedance.ee.bear.middleground.permission.c.x(r18, r19, "non_owner");
        return;
    L25:
        r27 = r17.getString(2131889302);
        goto L26
    }

    @Override // cj5.c
    public final DialogFragment N2(ShareParams r2, Bundle r3, com.bytedance.ee.bear.document.share.a.a r4, ShareDocInfo r5) {
        if (r5 != null) goto L6;
        r5 = new ShareDocInfo();
    L6:
        DocShareProvider r6 = new DocShareProvider(r4, new mi5.a(r2, r5));
        return ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ha(r2, r3, r6);
    }

    @Override // cj5.c
    public final void rb(Context r10, cj5.c.b r11, HashMap<String, Serializable> r12, Fragment r13) {
        if (r10 != null) goto L5;
        tt5.a.d("ShareUIService", "showLinkShareSettingsView()...context is null.");
        return;
    L5:
        HashMap r2 = new HashMap();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r1 = false;
        if (e.a.a.a() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        String r4 = r11.a;
        int r5 = r11.c;
        int r6 = r11.e;
        if (TextUtils.isEmpty(r4) == false) goto L14;
    L19:
        r2.put(ResourceData.KEY_URL, r4);
        r2.put(ResourceData.KEY_TOKEN, r11.b);
        r2.put(ResourceData.KEY_TYPE, Integer.valueOf(r11.c));
        r2.put("realToken", r11.d);
        r2.put("realType", Integer.valueOf(r11.e));
        r2.put("isWiki", Boolean.valueOf(r11.f));
        r2.put("isContainerFA", Boolean.valueOf(r11.g));
        r2.put("isSpaceV2", Boolean.valueOf(r11.h));
        AccountService.Account r7 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).c() == false) goto L22;
    L23:
        r1 = true;
    L24:
        r2.put("isUserToC", Boolean.valueOf(r1));
        r2.put("isOversea", Boolean.valueOf(!((b0) org.koin.java.a.a(b0.class)).isChinaMainlandGeo()));
        Boolean r3 = Boolean.TRUE;
        r2.put("secretFGEnable", r3);
        r2.put("searchFGEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.k()));
        boolean r8 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("com.permission.new_link_share_optimize");
        tt5.a.h("PermFGUtils", "isNewLinkShareOptimizeEnable()...enable = " + r8);
        r2.put("newLinkShareOptimizeEnable", Boolean.valueOf(r8));
        r2.put("shareExternalSettingEnable", r3);
        r2.put("customPasswordEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.b()));
        r2.put("docPasswordEnable", Boolean.valueOf(ui5.b.a()));
        r2.put("folderPasswordEnable", Boolean.valueOf(r11.j));
        r2.put("openPasswordShare", Boolean.valueOf(r11.i));
        r2.put("appDisplayName", r10.getString(2131890277));
        r2.put("statisticParams", r12);
        r2.put("tenantName", r11.l);
        r2.put("linkShareOptimizeFGEnable", Boolean.valueOf(r0));
        r2.put("isMempopeApp", AppInfoUtils.e());
        if (TextUtils.isEmpty(r11.k) == true) goto L27;
        r2.put("tips", r11.k);
    L27:
        ((CCMLynxPageRouter) org.koin.java.a.a(CCMLynxPageRouter.class)).c(r10, CCMLynxPageRouter.PageType.LINK_SHARE_PERM_SET, new de5.a(l0.a().toString(), r2, null, new Bundle(), null, r13, false));
        return;
    L22:
        if (ui5.c.b(r7) == false) goto L24;
    L14:
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L19;
        if (r6 <= 0) goto L18;
        r5 = r6;
    L18:
        qi5.a r9 = qi5.a.a;
        Integer r14 = Integer.valueOf(r5);
        r9.getClass();
        r4 = qi5.a.a(r4, r14);
        goto L19
    L8:
        if (r11.c == 28) goto L10;
        r0 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cj5.c
    public final void wb(Context r9, TransferApplyInfo r10, Fragment r11, boolean r12) {
        int r0 = TransferApplyFragment.q;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "info");
        TransferApplyFragment r1 = new TransferApplyFragment();
        FragmentActivity r13 = ContextsKt.findActivity(r9);
        Bundle r2 = new Bundle();
        r2.putSerializable("extra_info", r10);
        r1.setArguments(r2);
        if ((r13 instanceof FragmentActivity) == true) goto L5;
        return;
    L5:
        if (ForsetiHelper.s(r11) == true) goto L7;
    L8:
        FragmentManager r14 = r13.getSupportFragmentManager();
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "TransferApplyFragment", r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r1, r15) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        r1.show(r14, "TransferApplyFragment");
        return;
    L19:
        return;
    L7:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r1, r11, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r12, 0, false, 56) == false) goto L8;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset.DocumentLinkShareView] */
    @Override // cj5.c
    public final View S7(Context r1, ShareParams r2, boolean r3, boolean r4, boolean r5) {
        ?? r6 = new DocumentLinkShareView(r1);
        r6.i = r2;
        r6.j = r4;
        r6.k = r5;
        return r6;
    }

    @Override // cj5.c
    public final void c5(Context r15, String r16, int r17, String r18, Fragment r19) {
        int r2 = CustomPasswordSettingFragment.D;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, WikiFolderPushPlugin.DATA);
        CustomPasswordSettingFragment r12 = new CustomPasswordSettingFragment();
        Bundle r5 = new Bundle();
        r5.putInt(ResourceData.KEY_TYPE, r17);
        r5.putString(WikiFolderPushPlugin.DATA, r18);
        r5.putString(ResourceData.KEY_TOKEN, r16);
        r12.setArguments(r5);
        FragmentActivity r0 = ContextsKt.findActivity(r15);
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        tt5.a.d("CustomPasswordSettingFragment", "show");
        return;
    L5:
        if (ForsetiHelper.s(r19) == true) goto L7;
    L8:
        FragmentManager r1 = r0.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "CustomPasswordSettingFragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r12, r3) == false) goto L21;
    L13:
        String r4 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r16, ResourceData.KEY_TOKEN);
        JSONObject r10 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L16;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L17:
        com.bytedance.ee.bear.middleground.permission.c.a(r10, r16, r17, r6, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, "", com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_change_password_view", r10);
        return;
    L16:
        r6 = "none";
        goto L17
    L21:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L12:
        r12.show(r1, "CustomPasswordSettingFragment");
        goto L13
    L7:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r12, r19, null, false, 0, ForsetiHelper.m(), 30) == true) goto L13;
        goto L8
    }

    @Override // cj5.c
    public final void o6(FragmentActivity r3, String r4, int r5, String r6, String r7) {
        int r0 = ApplyAuditEscapePanel.m;
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r6, "ownerName");
        Bundle r1 = new Bundle();
        r1.putString("extra_token", r4);
        r1.putInt("extra_type", r5);
        r1.putString("extra_module", r7);
        r1.putString("extra_owner_name", r6);
        Fragment r8 = Fragment.instantiate(r3, ApplyAuditEscapePanel.class.getName(), r1);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        Fragment r9 = (DialogFragment) r8;
        FragmentManager r10 = r3.getSupportFragmentManager();
        String r11 = ApplyAuditEscapePanel.class.getName();
        if ((r9 instanceof Fragment) == false) goto L5;
        Fragment r12 = r9;
    L6:
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, r11, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r12, r13) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r9.show(r10, r11);
        return;
    L15:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // cj5.c
    public final void F0(FragmentActivity r2, String r3, int r4, String r5, String r6, String r7) {
        int r0 = ApplyPermissionPanel.p;
        ApplyPermissionPanel.a.a(r2, r3, r4, r5, r6, r7);
    }

    @Override // cj5.c
    public final DialogFragment r3(FragmentActivity r11, String r12, int r13, DocMetaInfo r14, String r15, String r16) {
        return k6(r11, r12, r13, r14, r15, r16, true, null, false);
    }

    @Override // cj5.c
    public final void O0(FragmentActivity r12, String r13, String r14, String r15, String r16, boolean r17, ArrayList<UserInfo> r18, ArrayList<UserInfo> r19) {
        BitableProInviteMemberFragment.ia0(r12, null, r13, r15, r14, r16, r17, r18, r19, null, null);
    }

    @Override // cj5.c
    public final void hb(Fragment r3, int r4, qe5.e.c r5, qe5.e.b r6, SecretApprovalInstanceModel r7, SecretApprovalDefModel r8, SecretLevel r9, SecretLevel r10) {
        NonProguard r11 = com.bytedance.ee.bear.middleground.permission.secret.b0.e(r7, r9, r8, r10);
        if (r7.getMy_instance() == null) goto L5;
        boolean r12 = true;
    L6:
        int r13 = ReSubmitApplyDialog.a;
        Intrinsics.checkNotNullParameter(r3, "sourceFragment");
        Intrinsics.checkNotNullParameter(r5, "confirmListener");
        if (r3.getChildFragmentManager().findFragmentByTag("ReSubmitApplyDialogFragment") != null) goto L18;
        ReSubmitApplyDialogFragment r14 = new ReSubmitApplyDialogFragment();
        Bundle r0 = new Bundle();
        r0.putSerializable("extra_data", r11);
        r0.putBoolean("extra_has_me", r12);
        r0.putInt("extra_type", r4);
        r14.setArguments(r0);
        r14.h = r5;
        r14.i = r6;
        FragmentManager r15 = r3.getChildFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "ReSubmitApplyDialogFragment", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r14, r16) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r14.show(r15, "ReSubmitApplyDialogFragment");
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // cj5.c
    public final void l5(FragmentActivity r7, int r8, qe5.e.c r9, qe5.e.b r10, SecretApprovalInstanceModel r11, SecretApprovalDefModel r12, SecretLevel r13, SecretLevel r14) {
        SecretReviewModel r3 = com.bytedance.ee.bear.middleground.permission.secret.b0.e(r11, r13, r12, r14);
        if (r11.getMy_instance() == null) goto L5;
        boolean r4 = true;
    L6:
        int r15 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.c(r7, r9, r10, r3, r4, r8);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // cj5.c
    public final void xe(FragmentActivity r12, Fragment r13, String r14, String r15, ArrayList r16, ArrayList r17, ArrayList r18, com.bytedance.ee.bear.bitable.lynx.pro.d r19) {
        BitableProInviteMemberFragment.ia0(r12, r13, "", r14, "", r15, false, r16, r17, r18, r19);
    }

    @Override // cj5.c
    public final View I7(FragmentActivity r12, int r13, String r14, String r15, String r16, FolderVersion r17, boolean r18, boolean r19, Fragment r20) {
        return new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.f(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // cj5.c
    public final DialogFragment k6(FragmentActivity r15, String r16, int r17, DocMetaInfo r18, String r19, String r20, boolean r21, Fragment r22, boolean r23) {
        if (this.a == false) goto L8;
        int r4 = com.bytedance.ee.bear.middleground.permission.b.a;
        boolean r5 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.permission.leader_auto_auth");
        tt5.a.h("PermFGUtils", "isLeaderAutoAuthEnable()...enable = " + r5);
        if (r5 == false) goto L8;
        tt5.a.h("ShareUIService", "showSecretFragment()...is showing LeaderAuthDialog, return.");
        return null;
    L8:
        String r6 = r19 + "";
        int r7 = SecretLevelFragment.v;
        Intrinsics.checkNotNullParameter(r15, "activity");
        Intrinsics.checkNotNullParameter(r16, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "meta");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r20, "from");
        SecretLevelFragment r8 = new SecretLevelFragment();
        Bundle r9 = new Bundle();
        r9.putString("extra_token", r16);
        r9.putInt("extra_type", r17);
        r9.putSerializable("extra_meta", r18);
        r9.putString("extra_wiki_token", r6);
        r9.putString("extra_from", r20);
        r9.putBoolean("extra_canModifyLevel", r21);
        r8.setArguments(r9);
        if (ForsetiHelper.s(r22) == true) goto L11;
    L12:
        FragmentManager r0 = r15.getSupportFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "SecretFragment", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r8, r1) == false) goto L19;
    L17:
        return r8;
    L19:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L16:
        r8.show(r0, "SecretFragment");
        goto L17
    L11:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r8, r22, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r23, 0, false, 56) == true) goto L17;
        goto L12
    }

    @Override // cj5.c
    public final void le(Context r12, int r13, String r14, String r15, boolean r16, boolean r17, String r18, DialogInterface.OnClickListener r19, DialogInterface.OnClickListener r20, Integer r21, String r22) {
        x.i(r12, r13, r14, r15, r16, r18, r17, r19, r20, r21, r22);
    }

    @Override // cj5.c
    public final void w4(Fragment r14, String r15, int r16, String r17, String r18, int r19, String r20, SecretLevel r21, SecretApprovalDefModel r22, Map r23, SecretLevel r24) {
        if (r23 != null) goto L5;
    L9:
        boolean r10 = false;
    L10:
        int r0 = InputReasonFragment.B;
        Intrinsics.checkNotNullParameter(r14, "sourceFragment");
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "secLabelId");
        Intrinsics.checkNotNullParameter(r18, "name");
        Intrinsics.checkNotNullParameter("", "applyTips");
        Intrinsics.checkNotNullParameter(r20, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r21, "oldSerretLevel");
        InputReasonFragment.a.b(r14.getChildFragmentManager(), r15, r16, r17, r18, r19, "", r20, r21, r22, r10, r23, r24);
        return;
    L5:
        if (r23.containsKey("is_need_edit") == false) goto L9;
        Object r1 = r23.get("is_need_edit");
        if ((r1 instanceof Boolean) == false) goto L9;
        r10 = ((Boolean) r1).booleanValue();
        goto L10
    }

    @Override // cj5.c
    public final void C8(final Context r18, final int r19, String r20, boolean r21, boolean r22, boolean r23, boolean r24, final boolean r25, final com.bytedance.ee.bear.middleground_permission_export.model.a r26, final String r27, final boolean r28, final boolean r29) {
        if (r20 != null) goto L5;
        String r11 = "";
    L6:
        int r3 = x.a;
        StringBuilder r4 = new StringBuilder("type:");
        r4.append(r19);
        r4.append(", adminCanCross:");
        r4.append(r23);
        r4.append(", externalAccess:");
        r4.append(r24);
        r4.append(", isLinkShareAnyone:");
        boolean r5 = r21;
        r4.append(r5);
        tt5.a.h("LinkShareUtils", r4.toString());
        if (r23 == false) goto L11;
        if (r24 == false) goto L11;
        if (r19 == sbb.e.r.b) goto L11;
    L12:
        if (r5 == false) goto L15;
        tt5.a.h("LinkShareUtils", "showExternalShareTips(), need not show tips");
        r26.onComplete();
        return;
    L15:
        if (r19 != sbb.e.f.b) goto L17;
        boolean r0 = true;
    L19:
        if (r22 == false) goto L29;
        if (r0 == false) goto L22;
        String r1 = r18.getString(2131887219);
    L23:
        Intrinsics.checkNotNullParameter(r18, "context");
        UDDialogBuilder r8 = new UDDialogBuilder(r18);
        r8.autoDismiss(true);
        r8.title(2131888216);
        Intrinsics.checkNotNullParameter(r1, "value");
        r8.message(r1);
        r8.messageGravity(8388611);
        final String r6 = r11;
        r8.addActionButton(2131391777, 2131887840, new hi5.o(r18, r19, r6, r27, r28, r25, r29, r26));
        final String r210 = r11;
        r8.addActionButton(2131391778, 2131887787, new hi5.p(r26, r210, r19, r27, r28));
        r8.autoDismiss(false);
        UDDialog r12 = r8.build();
        String r2 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        JSONObject r13 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L26;
        String r7 = ThumbGlideUrl.SOURCE_VC;
    L27:
        String r9 = r11;
        com.bytedance.ee.bear.middleground.permission.c.a(r13, r9, r19, r7, r27, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r28);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_public_access_view", r13);
    L37:
        x.a(r12);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r11, r19, r12);
        return;
    L26:
        r7 = "none";
        goto L27
    L22:
        u4.a.getClass();
        r1 = xo5.a.c(r18, 2131888215, "doc_type", u4.a(r18, r19));
        goto L23
    L29:
        if (r0 == false) goto L31;
        String r10 = r18.getString(2131887218);
    L32:
        Intrinsics.checkNotNullParameter(r18, "context");
        UDDialogBuilder r14 = new UDDialogBuilder(r18);
        r14.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r10, "value");
        r14.message(r10);
        r14.messageGravity(8388611);
        final String r211 = r11;
        r14.addActionButton(2131391777, 2131887759, new hi5.q(r26, r211, r19, r27, r28));
        r12 = r14.build();
        String r15 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        JSONObject r16 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L35;
        String r17 = ThumbGlideUrl.SOURCE_VC;
    L36:
        String r30 = r11;
        com.bytedance.ee.bear.middleground.permission.c.a(r16, r30, r19, r17, r27, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r28);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_owner_turned_off_prompt_view", r16);
        goto L37
    L35:
        r17 = "none";
        goto L36
    L31:
        u4.a.getClass();
        r10 = xo5.a.c(r18, 2131888212, "doc_type", u4.a(r18, r19));
        goto L32
    L17:
        r0 = false;
    L11:
        r5 = true;
        goto L12
    L5:
        r11 = r20;
        goto L6
    }

    @Override // cj5.c
    public final void ad(FragmentActivity r14, String r15, int r16, String r17, String r18, int r19, String r20, String r21, SecretLevel r22, SecretApprovalDefModel r23, Map<String, Serializable> r24, SecretLevel r25) {
        if (r24 != null) goto L5;
    L9:
        boolean r10 = false;
    L10:
        int r0 = InputReasonFragment.B;
        InputReasonFragment.a.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r10, r24, r25);
        return;
    L5:
        if (r24.containsKey("is_need_edit") == false) goto L9;
        Serializable r1 = r24.get("is_need_edit");
        if ((r1 instanceof Boolean) == false) goto L9;
        r10 = ((Boolean) r1).booleanValue();
        goto L10
    }

    @Override // cj5.c
    public final View i2(FragmentActivity r16, Fragment r17, int r18, String r19, String r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, ArrayList r28) {
        return new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e(r16, r17, r18, r19, r20, r21, r22, r23, r24, Boolean.valueOf(r25), Boolean.valueOf(r26), Boolean.valueOf(r27), r28);
    }
}
