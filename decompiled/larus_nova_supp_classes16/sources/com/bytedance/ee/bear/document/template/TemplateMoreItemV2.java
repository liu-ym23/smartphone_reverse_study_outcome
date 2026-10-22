package com.bytedance.ee.bear.document.template;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.route.h;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0003J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/document/template/TemplateMoreItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "cacheResp", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "saveToCustomTemplate", "", "templateName", "", "newCustomFg", "newStyle", "", "showOldToast", "isVisible", "getStateTips", "onDisableClick", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "getPermissionResponse", "docUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "getUnableTips", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "getNoPermUnableTips", "getTitle", "getIcon", "", "getIconTint", "showNewDialog", "onClick", "getId", "isEnable", "needShowBadge", "reportSaveAsCustomTmpl", "onlyClick", "reportEnterCustomTmplCenter", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String TAG = "TemplateMoreItemV2";
    private PermissionResponse cacheResp;
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.templates.dto.d {
        public final /* synthetic */ TemplateMoreItemV2 a;
        public final /* synthetic */ boolean b;

        public b(TemplateMoreItemV2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(int r9, String r10) {
            FragmentActivity r2 = TemplateMoreItemV2.access$getPluginHost$p(this.a).getActivity();
            t r0 = (t) org.koin.java.a.c(t.class, null, null, 6);
            if (r9 != 11001) goto L5;
            r0.j(r2, FullQuotoConfig.SAVE_TO_TEMPLATE);
        L47:
            tt5.a.d(TemplateMoreItemV2.TAG, r10);
            return;
        L5:
            if (r9 != 4000080) goto L7;
            Toast.showFailureText(eu5.b.a, 2131887226);
            goto L47
        L7:
            if (r9 != 90001043) goto L9;
            r0.f(r2, SingleFileQuotaConfig.SAVE, 0L);
            goto L47
        L9:
            if (r0.k(r9) == false) goto L12;
            r0.c(r2, null, null, false, false, "");
            goto L47
        L12:
            if (r0.s(r9) == false) goto L14;
            r0.c(r2, null, null, false, true, "");
            goto L47
        L14:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            boolean r1 = e.a.a.g();
            if (r1 == false) goto L25;
            ph5.b r3 = (ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6);
            oj5.c r4 = TemplateMoreItemV2.access$getMoreInfo(this.a);
            if (r4 == null) goto L19;
            String r5 = r4.getToken();
        L20:
            oj5.c r6 = TemplateMoreItemV2.access$getMoreInfo(this.a);
            if (r6 == null) goto L23;
            Integer r7 = Integer.valueOf(r6.getType());
        L24:
            ErrorResponse r8 = r3.e(r5, r7, "CREATE_COPY", new NetService.ServerErrorException(r9, "", "", ""));
        L26:
            com.bytedance.ee.bear.middleground_permission_export.model.d r11 = (com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6);
            oj5.c r12 = TemplateMoreItemV2.access$getMoreInfo(this.a);
            if (r12 == null) goto L29;
            String r13 = r12.getToken();
        L30:
            String r14 = r11.f(r13, "CCM_CREATE_COPY", r9);
            if (r1 == false) goto L37;
            if (r8 == null) goto L37;
            if (r8.getHasHandledUiAction() == false) goto L37;
            r8.getCallback().a(eu5.b.a, r8);
            return;
        L37:
            if (r1 == true) goto L42;
            if (TextUtils.isEmpty(r14) == true) goto L42;
            Toast.showFailureText(eu5.b.a, r14);
        L42:
            if (((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).o(r9) == true) goto L47;
            Toast.showFailureText(eu5.b.a, TemplateMoreItemV2.access$getPluginHost$p(this.a).getActivity().getString(2131888415));
            goto L47
        L29:
            r13 = null;
            goto L30
        L23:
            r7 = null;
            goto L24
        L19:
            r5 = null;
            goto L20
        L25:
            r8 = null;
            goto L26
        }

        public final void onSuccess(int r1, String r2) {
            tt5.a.h(TemplateMoreItemV2.TAG, "saveToCustomTemplate success");
            TemplateMoreItemV2.access$reportSaveAsCustomTmpl(this.a, false);
            if (this.b == false) goto L5;
            Toast.showSuccessText(eu5.b.a, 2131887443);
            return;
        L5:
            TemplateMoreItemV2.access$showOldToast(this.a);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ TemplateMoreItemV2 a;

        public c(TemplateMoreItemV2 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            TemplateMoreItemV2 r0 = this.a;
            oj5.c r9 = TemplateMoreItemV2.access$getMoreInfo(r0);
            if (r9 == null) goto L6;
            String r10 = r9.getTitle();
            if (r10 == null) goto L6;
        L7:
            TemplateMoreItemV2.saveToCustomTemplate$default(r0, r10, null, false, 6, null);
            return;
        L6:
            r10 = "";
            goto L7
        }
    }

    public static final class d implements UDToast.b {
        public final /* synthetic */ TemplateMoreItemV2 a;

        public d(TemplateMoreItemV2 r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r4) {
            Intrinsics.checkNotNullParameter(r4, "toast");
            TemplateMoreItemV2.access$reportEnterCustomTmplCenter(this.a);
            ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/list/template4/activity").i("openTemplateCenter", "custom").f("templateCategory", 5).e();
        }
    }

    static {
        Companion = new a();
    }

    public int getIcon() {
        return 2131255983;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    private final void reportEnterCustomTmplCenter() {
        Map r0 = new JSONObject();
        r0.put("source", "from_saveas_customtempl");
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("enter_template_center", r0);
    }

    private final void showNewDialog() {
        new UDDialogBuilder(this.pluginHost.getActivity()).title(2131887446).message(2131887445).addActionButton(2131391777, 2131887818, new c(this)).addActionButton(2131391778, 2131887716, null).show();
    }

    private final void showOldToast() {
        UDToast.a r0 = UDToast.build(eu5.b.a);
        r0.b.e(2131887971);
        r0.d(2131238078);
        r0.b(2131887922, new d(this));
        r0.h();
    }

    public String getId() {
        return CommonMoreItemId.TEMPLATE.getId();
    }

    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r2 = e.a.a.g();
        gj5.c r5 = getAdminResult(r1);
        PermissionResponse r3 = getPermissionResponse(r1, null);
        this.cacheResp = r3;
        if (y.a() == false) goto L13;
        if (j.a.a.getNetworkState().a() == true) goto L13;
        return new MoreUiAction(r0, getString(2131887951));
    L13:
        if (isItemDisabledByJSMsg() == false) goto L23;
        oj5.c r6 = getMoreInfo();
        if (r6 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == false) goto L23;
        return new MoreUiAction(r0, getString(2131886202));
    L17:
        if (r6.getType() != 8) goto L19;
        r7 = true;
    L23:
        String r8 = "";
        if (r5.a == true) goto L34;
        if (r2 == true) goto L34;
        FileAuthResultFrom r4 = r5.b;
        if (r4 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L31;
        return new MoreUiAction(r0, "");
    L31:
        if (r4 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L50;
        return new MoreUiAction(r0, getString(2131887246));
    L50:
        return new MoreUiAction(r0, getNoPermUnableTips());
    L34:
        if (r2 == false) goto L40;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r3) == false) goto L40;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L40:
        if (isItemDisabledByJSMsg() == false) goto L50;
        if (TextUtils.isEmpty(getItemDisableReasonByJSMsg()) == true) goto L50;
        String r9 = getItemDisableReasonByJSMsg();
        if (r9 == null) goto L48;
        r8 = r9;
    L48:
        return new MoreUiAction(r0, r8);
    L5:
        return new MoreUiAction(r0, getNoPermUnableTips());
    }

    public boolean isVisible() {
        Set<Integer> r0 = com.bytedance.ee.bear.document.template.b.a;
        boolean r1 = false;
        if (com.bytedance.ee.bear.document.template.b.c(this.pluginHost) == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByJSMsg() == false) goto L9;
        return false;
    L9:
        if (isItemInvisibleByBenefit() == false) goto L11;
        return false;
    L11:
        oj5.a r2 = getMoreInfo();
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.m() == false) goto L18;
        return false;
    L18:
        if (com.bytedance.ee.bear.document.template.b.a(r2) == false) goto L20;
        return false;
    L20:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L27;
        PermissionResponse r3 = getPermissionResponse(r2, null);
        if (r3.getAllow() == true) goto L33;
        if (r3.getDenySource().getDenyType() != DenyType.ADMIN) goto L33;
        return false;
    L33:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("bitable.template.bitable_advanced_permission_mobile") == true) goto L41;
        if ((r2 instanceof oj5.a) == false) goto L41;
        if (r2.A == false) goto L41;
        tt5.a.h(TAG, "doc is pro, template op not");
        return false;
    L41:
        if (com.bytedance.ee.bear.document.template.b.b(this.pluginHost, getMoreInfo()) == true) goto L43;
    L45:
        y.b(TAG, getId(), r1, r1, "", "template_visible");
        return r1;
    L43:
        if (r2.o() == true) goto L45;
        r1 = true;
        goto L45
    L27:
        gj5.c r4 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r2.getType(), r2.getToken());
        if (r4.a == true) goto L33;
        if (r4.b != FileAuthResultFrom.COME_FROM_AUTHZ) goto L33;
        return false;
    }

    public void onClick() {
        new ml5.b(TAG).b(TAG, Boolean.FALSE);
        getHost().a();
        PermissionResponse r1 = this.cacheResp;
        if (r1 == null) goto L6;
        r1.getCallback().a(this.pluginHost.getActivity(), r1);
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L8;
        oj5.a r2 = getMoreInfo();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r3 = r2;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r3.c, r3.getType(), false, r3.b(), "save_as_template", "ccm_space_save_customize_template_view", "", "", r3 instanceof f, r3.k, r3.r, r3.isOwner(), r3.L()));
    L8:
        showNewDialog();
    }

    private final String getNoPermUnableTips() {
        return getString(2131889697);
    }

    public String getTitle() {
        return getString(2131887970);
    }

    public boolean isEnable() {
        oj5.c r0 = getMoreInfo();
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (isItemDisabledByJSMsg() == false) goto L9;
        return false;
    L9:
        if (y.a() == true) goto L12;
        y.c(TAG, getId());
    L15:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L19;
        PermissionResponse r2 = getPermissionResponse(r0, r0.c().a);
        r1 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r2);
    L23:
        String r3 = getId();
        if (r1 == false) goto L26;
        String r4 = "";
    L27:
        boolean r5 = r1;
        y.b(TAG, r3, true, r5, r4, "copy_permission");
        return r1;
    L26:
        r4 = "copy_permission";
        goto L27
    L19:
        if (getAdminResult(r0).a == false) goto L23;
        if (r0.q() == false) goto L23;
        r1 = true;
        goto L23
    L12:
        if (j.a.a.getNetworkState().a() == true) goto L15;
        y.b(TAG, getId(), true, false, "network", "network");
        return false;
    }

    public boolean needShowBadge() {
        if (shouldShowBadgeByBusiness() == false) goto L7;
        Intrinsics.checkNotNullParameter(TAG, "name");
        com.ss.android.lark.storage.kv.repo.a r1 = ay4.b.b(TAG, true, ay4.b.a(TAG));
        Intrinsics.checkNotNullParameter(r1, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter(TAG, "key");
        if (r1.getBoolean(TAG, true) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return;
    L6:
        if (y.a() == true) goto L8;
    L11:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L14;
        PermissionResponse r1 = getPermissionResponse(r0, null);
        r1.getCallback().a(this.pluginHost.getActivity(), r1);
        return;
    L14:
        gj5.c r2 = getAdminResult(r0);
        if (r2.a == false) goto L17;
        return;
    L17:
        if (r2.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L22;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L22:
        return;
    L8:
        if (j.a.a.getNetworkState().a() == true) goto L11;
        Toast.showFailureText(eu5.b.a, 2131887951);
        tt5.a.h(TAG, "onDisableClick, itemId=" + getId() + ", source=network");
    }

    public TemplateMoreItemV2(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    public static final /* synthetic */ oj5.c access$getMoreInfo(TemplateMoreItemV2 r0) {
        return r0.getMoreInfo();
    }

    public static final /* synthetic */ DocumentPluginHost access$getPluginHost$p(TemplateMoreItemV2 r0) {
        return r0.pluginHost;
    }

    public static final /* synthetic */ void access$reportEnterCustomTmplCenter(TemplateMoreItemV2 r0) {
        r0.reportEnterCustomTmplCenter();
    }

    public static final /* synthetic */ void access$showOldToast(TemplateMoreItemV2 r0) {
        r0.showOldToast();
    }

    private final gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private final void reportSaveAsCustomTmpl(boolean r4) {
        Map r0 = new JSONObject();
        if (r4 == false) goto L5;
        String r5 = "click_save_as";
    L6:
        r0.put(JSEventListener.ACTION, r5);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).v("management_template_by_user", r0);
        return;
    L5:
        r5 = "save";
        goto L6
    }

    public static final /* synthetic */ void access$reportSaveAsCustomTmpl(TemplateMoreItemV2 r0, boolean r1) {
        r0.reportSaveAsCustomTmpl(r1);
    }

    private final PermissionResponse getPermissionResponse(oj5.c r14, IDocUserPermission r16) {
        UniBaseEntity r12 = new UniBaseEntity(r14.getToken(), sbb.e.d(r14.i()), BizDomain.FileBizDomainCCM, r14.a(), r14.d(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r12, "CREATE_COPY"), new UserPermissionEntity(r16, null));
    }

    private final void saveToCustomTemplate(String r8, String r9, boolean r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        reportSaveAsCustomTmpl(true);
        yn5.e r0 = new yn5.e(this.pluginHost.a().getDocumentTypeValue(), this.pluginHost.a().getToken(), r8, r10, r9);
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).a(this.pluginHost.getActivity(), r0, new b(this, r10));
    }

    public static /* synthetic */ void saveToCustomTemplate$default(TemplateMoreItemV2 r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = DiagramData$RESULT.SUCCESS;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = true;
    L8:
        r0.saveToCustomTemplate(r1, r2, r3);
    }
}
