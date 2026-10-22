package com.bytedance.ee.bear.wikiv2.more;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiMakeCopyPlugin;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020%H\u0016J\b\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0006H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/more/WikiMakeCopyItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "documentName", "", "fromDoc", "", "<init>", "(Lcom/bytedance/ee/bear/browser/plugin/PluginHost;Ljava/lang/String;Ljava/lang/Boolean;)V", "getPluginHost", "()Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "getDocumentName", "()Ljava/lang/String;", "getFromDoc", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "cacheResp", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "getId", "getTitle", "getIcon", "", "getIconTint", "isVisible", "isVisibleLegacy", "isEnable", "isPermEnable", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "getPermissionResponse", "docUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "getStateTips", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "onDisableClick", "isEditionDoc", "getRealToken", "logDecision", "visible", "enabled", "source", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMakeCopyItem extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String TAG = "WikiMakeCopyItem";
    private PermissionResponse cacheResp;
    private final String documentName;
    private final Boolean fromDoc;
    private final PluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ WikiMakeCopyItem a;

        public b(WikiMakeCopyItem r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r4) {
            WikiMakeCopyPlugin r5 = (WikiMakeCopyPlugin) r4;
            Intrinsics.checkNotNullParameter(r5, "plugin");
            r5.makeCopy(this.a.getDocumentName(), Intrinsics.areEqual(this.a.getFromDoc(), Boolean.TRUE));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254165;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ String getUnableTips() {
        return ITextMoreItem.CC.$default$getUnableTips(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    private final boolean isEditionDoc() {
        DocumentPluginHost r0 = this.pluginHost;
        if ((r0 instanceof DocumentPluginHost) == true) goto L7;
        return false;
    L7:
        return r0.a().isEditionDoc();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return com.bytedance.ee.bear.more.protocol3.f.m0.c.a;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.NO_ACTION;
        int r1 = d.a;
        String r2 = "";
        if (d.b(getId()) == true) goto L5;
    L30:
        oj5.c r3 = getMoreInfo();
        if (r3 == null) goto L33;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r4 = jg5.e.a.a.g();
        PermissionResponse r5 = getPermissionResponse(r3);
        if (r4 == false) goto L41;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r5) == false) goto L41;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L41:
        if (isItemDisabledByJSMsg() == false) goto L51;
        if (TextUtils.isEmpty(getItemDisableReasonByJSMsg()) == true) goto L51;
        String r6 = getItemDisableReasonByJSMsg();
        if (r6 == null) goto L49;
        r2 = r6;
    L49:
        return new MoreUiAction(r0, r2);
    L51:
        return new MoreUiAction(r0, "");
    L33:
        return new MoreUiAction(r0, "");
    L5:
        if (d.c() == true) goto L9;
        return new MoreUiAction(MoreUiAction.MoreAction.UNEAABLE_TIPS, d.a(this.pluginHost));
    L9:
        if (isItemDisabledByJSMsg() == false) goto L19;
        if (TextUtils.isEmpty(getItemDisableReasonByJSMsg()) == true) goto L19;
        String r7 = getItemDisableReasonByJSMsg();
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        return new MoreUiAction(r0, r2);
    L19:
        if (isEditionDoc() == true) goto L25;
        if (d.e(this.pluginHost) == false) goto L25;
        return new MoreUiAction(MoreUiAction.MoreAction.UNEAABLE_TIPS, getString(2131889881));
    L25:
        if (isEditionDoc() == true) goto L30;
        if (d.d(this.pluginHost) == true) goto L30;
        return new MoreUiAction(MoreUiAction.MoreAction.UNEAABLE_TIPS, getString(2131889881));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L13;
        if (isItemDisabledByJSMsg() == false) goto L7;
        return false;
    L7:
        oj5.c r1 = getMoreInfo();
        if (r1 != null) goto L10;
        return true;
    L10:
        return isPermEnable(r1);
    L13:
        if (d.c() == true) goto L17;
        logDecision(true, false, "network_unavailable");
        return false;
    L17:
        if (isItemDisabledByJSMsg() == false) goto L21;
        logDecision(true, false, "js_disabled");
        return false;
    L21:
        if (isEditionDoc() == true) goto L27;
        if (d.e(this.pluginHost) == false) goto L27;
        logDecision(true, false, "shortcut_origin_deleted");
        return false;
    L27:
        if (isEditionDoc() == false) goto L29;
    L32:
        oj5.c r2 = getMoreInfo();
        if (r2 == null) goto L36;
        boolean r3 = isPermEnable(r2);
        logDecision(true, r3, "permission_sdk_security");
        return r3;
    L36:
        return true;
    L29:
        if (d.d(this.pluginHost) == true) goto L32;
        logDecision(true, false, "origin_can_clone");
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        int r0 = d.a;
        if (d.b(getId()) == false) goto L5;
        boolean r1 = false;
        if (isItemInvisibleByBenefit() == false) goto L10;
        return false;
    L10:
        if (isItemInvisibleByJSMsg() == false) goto L12;
        return false;
    L12:
        oj5.c r2 = getMoreInfo();
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L21;
        return false;
    L21:
        if (com.bytedance.ee.bear.wikiv2.more.b.a(this.pluginHost) == false) goto L23;
        return false;
    L23:
        oj5.c r4 = getMoreInfo();
        if (r4 == null) goto L30;
        PermissionResponse.a r5 = PermissionResponse.Companion;
        PermissionResponse r6 = getPermissionResponse(r4, r4.c().a);
        r5.getClass();
        if (PermissionResponse.a.e(r6) == true) goto L30;
        logDecision(false, false, "permission_platform_visible");
        return false;
    L30:
        if (isEditionDoc() == false) goto L38;
        boolean r7 = yp5.c.b();
        if (r7 == true) goto L34;
    L36:
        logDecision(r7, r1, "edition_doc_fg");
        return r7;
    L34:
        if (isEnable() == false) goto L36;
        r1 = true;
        goto L36
    L38:
        WikiInfoPlugin r8 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r8 == null) goto L41;
        WikNodePerm r9 = r8.getWikiPerm();
    L42:
        if (r9 == null) goto L44;
        boolean r10 = true;
    L45:
        if (r10 == true) goto L47;
    L49:
        logDecision(r10, r1, "wiki_perm_loaded");
        return r10;
    L47:
        if (isEnable() == false) goto L49;
        r1 = true;
        goto L49
    L44:
        r10 = false;
        goto L45
    L41:
        r9 = null;
        goto L42
    L15:
        if (r2.m() != true) goto L17;
        r3 = true;
        goto L18
    L5:
        return isVisibleLegacy();
    }

    private final boolean isVisibleLegacy() {
        if (isItemInvisibleByBenefit() == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByJSMsg() == false) goto L8;
        return false;
    L8:
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L14;
        PermissionResponse.a r2 = PermissionResponse.Companion;
        PermissionResponse r1 = getPermissionResponse(r0, r0.c().a);
        r2.getClass();
        if (PermissionResponse.a.e(r1) == true) goto L14;
        return false;
    L14:
        if (isEditionDoc() == true) goto L16;
        WikiInfoPlugin r3 = this.pluginHost.findPlugin(WikiInfoPlugin.class);
        if (r3 == null) goto L23;
        WikNodePerm r4 = r3.getWikiPerm();
        if (r4 == null) goto L24;
        int r5 = d.a;
        return r4.getOriginCanClone(d.h(this.pluginHost));
    L24:
        return false;
    L23:
        return false;
    L16:
        return yp5.c.b();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889116);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        sj5.b r0 = getHost();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        PermissionResponse r1 = this.cacheResp;
        if (r1 == null) goto L15;
        ph5.e r2 = r1.getCallback();
        Context r3 = this.pluginHost.getContext();
        if (r3 != null) goto L10;
        r3 = eu5.b.a;
    L10:
        Intrinsics.checkNotNull(r3);
        r2.a(r3, r1);
        if (r1.getAllow() == true) goto L15;
        if (r1.getDenySource().getDenyType() == DenyType.USER_PERMISSION) goto L15;
        return;
    L15:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(this.pluginHost.getActivity());
        this.pluginHost.findPluginToDo(WikiMakeCopyPlugin.class, new b(this));
        if (isEditionDoc() == false) goto L23;
        oj5.c r4 = getMoreInfo();
        if (r4 == null) goto L20;
        int r5 = r4.getType();
    L21:
        ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).q(r5, "create_copy", "ccm_docs_page_view", null, null, null);
        return;
    L20:
        r5 = -1;
        goto L21
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L9;
        PermissionResponse r1 = getPermissionResponse(r0);
        r1.getCallback().a(this.pluginHost.getContext(), r1);
        return;
    L9:
        if (getAdminResult(r0).b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L13;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r0.i(), getRealToken(r0));
        return;
    }

    public final String getDocumentName() {
        return this.documentName;
    }

    public final Boolean getFromDoc() {
        return this.fromDoc;
    }

    public final PluginHost getPluginHost() {
        return this.pluginHost;
    }

    private final gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private final PermissionResponse getPermissionResponse(oj5.c r9) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).M(r9.getToken(), r9.getType(), r9.a(), r9.d(), BizDomain.FileBizDomainCCM, "CREATE_COPY");
    }

    private final String getRealToken(oj5.c r2) {
        String r3 = r2.getToken();
        if ((this.pluginHost instanceof DocumentPluginHost) == true) goto L6;
        return r3;
    L6:
        if (isEditionDoc() == false) goto L11;
        String r4 = this.pluginHost.a().getEditionToken();
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    L11:
        return r3;
    }

    private final boolean isPermEnable(oj5.c r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        PermissionResponse r5 = getPermissionResponse(r4);
        this.cacheResp = r5;
        return ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r5);
    L7:
        return getAdminResult(r4).a;
    }

    private final PermissionResponse getPermissionResponse(oj5.c r8, IDocUserPermission r9) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "CREATE_COPY", r9);
    }

    public WikiMakeCopyItem(PluginHost r2, String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
        this.documentName = r3;
        this.fromDoc = r4;
    }

    private final void logDecision(boolean r8, boolean r9, String r10) {
        int r0 = d.a;
        if (d.b(getId()) == true) goto L5;
        return;
    L5:
        d.i(this.pluginHost, getId(), r8, r9, ITextMoreItem.CC.$default$getUnableTips(this), r10);
    }

    public /* synthetic */ WikiMakeCopyItem(PluginHost r1, String r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Boolean.FALSE;
    L5:
        this(r1, r2, r3);
    }
}
