package com.bytedance.ee.bear.document.export.more;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.export.ExportPlugin;
import com.bytedance.ee.bear.document.export.e;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.l;
import com.bytedance.ee.bear.more.m;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import gj5.b;
import java.util.HashMap;
import java.util.Map;
import oj5.c;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ExportMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String HAS_PERCEIVE_CONTRAL = "has_perceive_control";
    private static final String ID = "export";
    private static final String TAG = "ExportMoreItemV2";
    private boolean adminCanExport;
    private PermissionResponse cacheRes;
    private boolean isFromList;
    private final FragmentActivity mActivity;
    private h15.a mExportReporter;
    private final PluginHost mPluginHost;
    private boolean ownerCanExport;

    public class a implements e.d {
        public final /* synthetic */ c a;
        public final /* synthetic */ ExportMoreItemV2 b;

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void a(String r3) {
            ExportMoreItemV2.access$200(this.b, "ccm_docs_export_as_set_view", r3);
            ExportMoreItemV2.access$300(this.b, r3);
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void b(String r5) {
            h15.a r0 = ExportMoreItemV2.access$600(this.b);
            c r1 = this.a;
            if (ExportMoreItemV2.access$500(this.b) != null) goto L5;
            boolean r2 = true;
        L6:
            r0.a(r1, r2, r5, "success");
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void c(String r5) {
            h15.a r0 = ExportMoreItemV2.access$600(this.b);
            c r1 = this.a;
            if (ExportMoreItemV2.access$500(this.b) != null) goto L5;
            boolean r2 = true;
        L6:
            r0.a(r1, r2, r5, "failed");
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void d(String r5) {
            h15.a r0 = ExportMoreItemV2.access$600(this.b);
            c r1 = this.a;
            if (ExportMoreItemV2.access$500(this.b) != null) goto L5;
            boolean r2 = true;
        L6:
            r0.a(r1, r2, r5, "canceled");
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void f(String r2) {
            ExportMoreItemV2.access$000(this.b, r2);
            ExportMoreItemV2.access$100(this.b, r2);
        }

        public a(ExportMoreItemV2 r1, c r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // com.bytedance.ee.bear.document.export.e.d
        public final void e(String r2, String r3, String r4) {
            ExportMoreItemV2.access$400(this.b, r2, r3, r4);
        }
    }

    public int getIcon() {
        return 2131254269;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID;
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    private gj5.c getAdminResult() {
        return ((b) org.koin.java.a.a(b.class)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, getMoreInfo().getType(), getRealToken(getMoreInfo()));
    }

    private boolean isVersion() {
        PluginHost r0 = this.mPluginHost;
        if ((r0 instanceof DocumentPluginHost) == true) goto L5;
        return false;
    L5:
        return ((DocumentPluginHost) r0).a().isEditionDoc();
    }

    private void reportExportView() {
        reportMoreSubMenuView("ccm_space_export_as_view", null);
    }

    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        if (j.a.a.getNetworkState().a() == false) goto L5;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r1 = jg5.e.a.a.g();
        if (this.adminCanExport == true) goto L17;
        if (r1 == true) goto L17;
        if (getMoreInfo() == null) goto L16;
        if (getAdminResult().b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L16;
        return new MoreUiAction(r0, "");
    L16:
        return new MoreUiAction(r0, this.mActivity.getString(2131887246));
    L17:
        if (r1 == false) goto L25;
        if (getMoreInfo() == null) goto L25;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(getPermissionResponse(getMoreInfo().c().a)) == false) goto L25;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L25:
        if (this.ownerCanExport == true) goto L35;
        if (getMoreInfo() == null) goto L33;
        if (getMoreInfo().E() == false) goto L33;
        return new MoreUiAction(r0, this.mActivity.getString(2131889882));
    L33:
        return new MoreUiAction(r0, this.mActivity.getString(2131887706));
    L35:
        if (isItemDisabledByJSMsg() == false) goto L41;
        if (TextUtils.isEmpty(getItemDisableReasonByJSMsg()) == true) goto L41;
        return new MoreUiAction(r0, getItemDisableReasonByJSMsg());
    L41:
        return new MoreUiAction(r0, this.mActivity.getString(2131887710));
    L5:
        return new MoreUiAction(r0, getString(2131887951));
    }

    public boolean isEnable() {
        boolean r1 = false;
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L55;
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L11;
        return false;
    L11:
        if (r0.p == true) goto L13;
    L15:
        this.adminCanExport = getAdminResult().a;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        jg5.e r2 = jg5.e.a.a;
        if (r2.g() == false) goto L18;
        this.ownerCanExport = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).v(r0, r0.i.a, "EXPORT").booleanValue();
    L20:
        if (this.adminCanExport == true) goto L22;
    L24:
        boolean r3 = false;
    L25:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (r2.g() == false) goto L28;
        r3 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(getPermissionResponse(r0.i.a));
    L28:
        tt5.a.h(TAG, "adminCanExport:" + this.adminCanExport + ", ownerCanExport:" + this.ownerCanExport);
        boolean r4 = y.a();
        if (r4 == true) goto L32;
        y.c(TAG, getId());
    L32:
        if (r0.i() != 3) goto L34;
        boolean r5 = true;
    L35:
        String r6 = "";
        if (r4 == true) goto L39;
        if (r5 == true) goto L39;
    L49:
        String r7 = getId();
        if (r3 == false) goto L52;
        String r9 = "";
    L53:
        y.b(TAG, r7, true, r3, r9, "permission_platform_or_security,adminCanExport=" + this.adminCanExport + ",ownerCanExport=" + this.ownerCanExport);
        return r3;
    L52:
        r9 = "permission_platform_or_security";
    L39:
        if (this.isFromList == true) goto L49;
        boolean r8 = isItemDisabledByJSMsg();
        if (r3 == false) goto L44;
        if (r8 == true) goto L44;
        r1 = true;
    L44:
        String r10 = getId();
        if (r8 == false) goto L47;
        r6 = "frontend_disabled";
    L47:
        y.b(TAG, r10, true, r1, r6, "frontend_disable,useAllType=" + r4 + ",isSheet=" + r5);
        return r1;
    L34:
        r5 = false;
        goto L35
    L22:
        if (this.ownerCanExport == false) goto L24;
        r3 = true;
        goto L25
    L18:
        this.ownerCanExport = r0.p();
        goto L20
    L13:
        if (r0.q == false) goto L15;
        return false;
    L55:
        return false;
    }

    private void reportDownloadEntryClick() {
        c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), getRealToken(r0), r0.getType(), r0.isShareFolder(), r0.b(), "download", "none", "", "", r0 instanceof f, r0.m(), r0.H(), r0.isOwner(), r0.L()));
        tt5.a.h(TAG, "reportDownloadEntryClick");
        return;
    }

    public String getTitle() {
        return getString(2131889049);
    }

    public boolean isVisible() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mPluginHost != null) goto L7;
        boolean r2 = true;
    L9:
        if (isExportTypeVisible(r0, r2) == true) goto L11;
        return false;
    L11:
        PermissionResponse r1 = getPermissionResponse(r0.c().a);
        PermissionResponse.Companion.getClass();
        boolean r3 = PermissionResponse.a.e(r1);
        if (y.a() == true) goto L15;
        y.c(TAG, getId());
        return r3;
    L15:
        y.b(TAG, getId(), true, true, "", "permission_platform_visible=" + r3);
        return true;
    L7:
        r2 = false;
        goto L9
    }

    public boolean needShowBadge() {
        if (shouldShowBadgeByBusiness() == true) goto L5;
        return false;
    L5:
        boolean r0 = shouldShowBadgeByJSMsg();
        if (r0 == false) goto L13;
        PluginHost r3 = this.mPluginHost;
        if (r3 == null) goto L13;
        ExportPlugin r4 = (ExportPlugin) r3.findPlugin(ExportPlugin.class);
        if (r4 == null) goto L13;
        r4.onShowExportBadges("more_panel", ID);
    L13:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).l(ID) == true) goto L15;
        if (r0 == true) goto L15;
        return false;
    L15:
        return true;
    }

    public void onClick() {
        c r0 = getMoreInfo();
        if (r0 == null) goto L22;
        PermissionResponse r1 = this.cacheRes;
        if (r1 != null) goto L7;
    L9:
        getHost().a();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).b(ID);
        PluginHost r2 = this.mPluginHost;
        if (r2 == null) goto L15;
        ExportPlugin r3 = (ExportPlugin) r2.findPlugin(ExportPlugin.class);
        if (r3 == null) goto L15;
        r3.onClickExport();
    L15:
        if ((r0 instanceof oj5.a) == false) goto L18;
        reportMoreItemClick("ccm_space_export_as_view", "");
        reportDownloadEntryClick();
    L18:
        if (new e(this.mActivity, buildExportDocumentInfo(r0), this.mPluginHost, buildExportActionReporter(r0)).p() == false) goto L24;
        reportExportView();
        if (isVersion() == false) goto L25;
        reportMoreMenuClick(r0);
        return;
    L25:
        return;
    L24:
        return;
    L7:
        if (this.mActivity == null) goto L9;
        r1.getCallback().a(this.mActivity, this.cacheRes);
        goto L9
    L22:
        tt5.a.d(TAG, "onItemClick fail, moreInfo is null");
    }

    public void onDisableClick() {
        if (getMoreInfo() == null) goto L12;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L10;
        PermissionResponse r0 = getPermissionResponse(getMoreInfo().c().a);
        if (r0.getCallback() != null) goto L9;
        return;
    L9:
        r0.getCallback().a(this.mActivity, r0);
        return;
    L10:
        ((b) org.koin.java.a.a(b.class)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, getMoreInfo().getType(), getRealToken(getMoreInfo()));
        return;
    }

    public ExportMoreItemV2(FragmentActivity r2) {
        this(r2, true);
    }

    public static /* synthetic */ PluginHost access$500(ExportMoreItemV2 r0) {
        return r0.mPluginHost;
    }

    public static /* synthetic */ h15.a access$600(ExportMoreItemV2 r0) {
        return r0.mExportReporter;
    }

    private e.d buildExportActionReporter(c r2) {
        return new a(this, r2);
    }

    private e.a buildExportDocumentInfo(c r3) {
        e.a.C0073a r0 = new e.a.C0073a();
        r0.a = r3.getType();
        r0.b = r3.i();
        r0.c = r3.getToken();
        r0.d = getRealToken(r3);
        r0.e = r3.getTitle();
        r0.f = r3.t();
        r0.g = r3.a();
        r0.h = r3.d();
        boolean r1 = r3 instanceof f;
        r0.i = r1;
        if (r1 == false) goto L5;
        String r2 = ((f) r3).O;
    L6:
        r0.j = r2;
        r0.k = r3.m();
        r0.l = r3.h();
        r0.m = r3.s();
        r0.n = r3.N();
        if (r3.c() == null) goto L9;
        IDocUserPermission r4 = r3.c().a;
    L10:
        r0.o = r4;
        return new e.a(r0);
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = "";
        goto L6
    }

    private PermissionResponse getPermissionResponse(IDocUserPermission r8) {
        PermissionResponse.Companion.getClass();
        PermissionResponse r0 = PermissionResponse.a.a();
        c r3 = getMoreInfo();
        if (r3 == null) goto L5;
        r0 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r3.getToken(), r3, BizDomain.FileBizDomainCCM, "EXPORT", r8);
    L5:
        this.cacheRes = r0;
        return r0;
    }

    private String getRealToken(c r2) {
        String r3 = r2.getToken();
        if (isVersion() == true) goto L5;
        return r3;
    L5:
        return ((DocumentPluginHost) this.mPluginHost).a().getEditionToken();
    }

    private boolean isDownloadSubClick(String r2) {
        if (TextUtils.equals("pptx", r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.equals("pdf", r2) == true) goto L8;
        return false;
    }

    private void reportDownloadSubClick(String r4) {
        if (isDownloadSubClick(r4) == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("sub_click", r4);
        reportMoreSubMenuClick("ccm_space_docs_more_menu_click", "download", r0);
        tt5.a.h(TAG, "reportDownloadSubClick, subClick = " + r4);
    }

    private void reportExportAsSetView(String r3) {
        HashMap r0 = new HashMap();
        r0.put("export_type", r3);
        reportMoreSubMenuView("ccm_docs_export_as_set_view", r0);
    }

    private void reportMoreMenuClick(c r9) {
        ((k) org.koin.java.a.a(k.class)).q(r9.getType(), "export_as", "ccm_space_export_as_view", "", "", "");
    }

    private void reportMoreSubMenuClick(String r3) {
        reportMoreSubMenuClick("ccm_space_export_as_click", r3, null);
    }

    public ExportMoreItemV2(FragmentActivity r2, boolean r3) {
        this(r2, null, r3);
    }

    public static /* synthetic */ void access$000(ExportMoreItemV2 r0, String r1) {
        r0.reportMoreSubMenuClick(r1);
    }

    public static /* synthetic */ void access$100(ExportMoreItemV2 r0, String r1) {
        r0.reportDownloadSubClick(r1);
    }

    public static /* synthetic */ void access$300(ExportMoreItemV2 r0, String r1) {
        r0.reportExportAsSetView(r1);
    }

    private boolean isExportTypeVisible(c r5, boolean r6) {
        boolean r0 = Boolean.TRUE.equals(AppInfoUtils.f());
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.j("ccm.mobile.slides_editor_enable");
        if (r5.getType() != 2) goto L5;
    L17:
        return true;
    L5:
        if (r5.getType() == 3) goto L17;
        if (r5.getType() != 30) goto L11;
        if (r0 == true) goto L17;
        if (r1 == true) goto L17;
    L11:
        if (r5.getType() == 22) goto L17;
        if (r5.getType() != 16) goto L16;
        if (r6 == false) goto L17;
    L16:
        return false;
    }

    private void reportMoreItemClick(String r20, String r21) {
        c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), getRealToken(r0), r0.getType(), r0.isShareFolder(), r0.b(), "export_as", r20, r21, "", r0 instanceof f, r0.m(), r0.H(), r0.isOwner(), r0.L()));
        return;
    }

    private void reportMoreSubMenuView(String r17, Map<String, Object> r18) {
        c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).I(new l(r17, getHost().getHostFragment().getArguments(), getRealToken(r0), r0.getType(), r0.b(), r0 instanceof f, r0.m(), r0.isOwner(), isVersion(), r0.L(), r18));
        return;
    }

    public ExportMoreItemV2(FragmentActivity r2, PluginHost r3, boolean r4) {
        this.cacheRes = null;
        this.adminCanExport = true;
        this.ownerCanExport = true;
        this.mActivity = r2;
        this.mPluginHost = r3;
        this.mExportReporter = new h15.a();
        this.isFromList = r4;
    }

    public static /* synthetic */ void access$200(ExportMoreItemV2 r0, String r1, String r2) {
        r0.reportMoreItemClick(r1, r2);
    }

    private void reportExportAsSetClick(String r3, String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("export_type", r4);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0.put("export_content", r5);
    L5:
        reportMoreSubMenuClick("ccm_docs_export_as_set_click", r3, r0);
    }

    private void reportMoreSubMenuClick(String r19, String r20, Map<String, Object> r21) {
        oj5.a r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).E(new m(r19, getHost().getHostFragment().getArguments(), getRealToken(r0), r0.getType(), r0.b(), r0 instanceof f, r0.k, r20, "none", "", r0.isOwner(), isVersion(), r0.L(), r21));
        return;
    }

    public static /* synthetic */ void access$400(ExportMoreItemV2 r0, String r1, String r2, String r3) {
        r0.reportExportAsSetClick(r1, r2, r3);
    }
}
