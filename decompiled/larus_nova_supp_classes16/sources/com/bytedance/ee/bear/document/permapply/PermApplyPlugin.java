package com.bytedance.ee.bear.document.permapply;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002*+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0016\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u001c\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u000fJ\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\bJ\u0010\u0010%\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\bJ\u0012\u0010&\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/document/permapply/PermApplyPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/plugin/permapply/BasePermApplyPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "<init>", "()V", "showPermCallbacks", "", "Lcom/bytedance/ee/bear/document/permapply/PermApplyPlugin$IShowPermCallback;", "noPermissionView", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "titleBarRightMenus", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "showNoPermission", "", "permissionData", "Lcom/bytedance/ee/bear/document/permission/PermissionData;", "getViewPermCode", "", "setViewVisibleListener", "setBackClickListener", "setAssociatedNoPermMenus", "menus", "onDetachFromUIContainer", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "getContainerId", "show", "", "removeAllPermissionView", "isPermissionShow", "updateTitleBarTipsExtra", "titleBarTipsShow", "addPermCallback", "permCallback", "removePermCallback", "onDetachFromHost", "showForbiddenFragment", "showNoPermissionFragment", "checkCacAsync", "Companion", "IShowPermCallback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermApplyPlugin extends DocumentPluginV2 implements BasePermApplyPlugin<PluginHost> {
    public static final a Companion = null;
    public static final String TAG = "PermApplyPlugin";
    private au5.a noPermissionView;
    private final List<b> showPermCallbacks;
    private List<? extends MenuItem> titleBarRightMenus;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements gj5.a {
        public final /* synthetic */ PermApplyPlugin a;
        public final /* synthetic */ String b;

        public final void a(gj5.c r5) {
            Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
            DocViewModel r0 = PermApplyPlugin.access$getDocViewModel(this.a);
            if (r0 == null) goto L5;
            String r1 = r0.getToken();
        L6:
            boolean r2 = PermApplyPlugin.access$isUIContainerAttached(this.a);
            tt5.a.h("PermApplyPlugin", "checkCacAsync - onResult, isAttached: " + r2);
            if (r2 == true) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r1, this.b) == false) goto L15;
            ValidateResult r6 = r5.c;
            if (r6 == null) goto L16;
            r6.handleAction();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public c(PermApplyPlugin r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ rz4.a a;
        public final /* synthetic */ PermApplyPlugin b;

        public d(rz4.a r1, PermApplyPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("PermApplyPlugin", "noPermissionView Back click");
            if (this.a.processContentEvent(new sz4.a()) == true) goto L6;
            PermApplyPlugin.access$getActivity(this.b).onBackPressed();
            return;
        }
    }

    public static final class e implements au5.b {
        public final /* synthetic */ PermApplyPlugin a;
        public final /* synthetic */ au5.a b;

        public e(PermApplyPlugin r1, au5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r6) {
            tt5.a.h("PermApplyPlugin", "setViewVisibleListener callback " + r6);
            if (r6 == false) goto L25;
            List r7 = PermApplyPlugin.access$getTitleBarRightMenus$p(this.a);
            if (r7 == null) goto L32;
            PermApplyPlugin r0 = this.a;
            au5.a r2 = this.b;
            StringBuilder r3 = new StringBuilder("setViewVisibleListener callback menus: ");
            List r1 = PermApplyPlugin.access$getTitleBarRightMenus$p(r0);
            if (r1 == null) goto L9;
            Integer r4 = Integer.valueOf(r1.size());
        L10:
            r3.append(r4);
            tt5.a.h("PermApplyPlugin", r3.toString());
            BaseTitleBar r5 = r2.getTitleBar();
            if ((r5 instanceof BaseTitleBar) == false) goto L13;
            BaseTitleBar r8 = r5;
        L14:
            if (r8 == null) goto L33;
            Iterator r9 = r7.iterator();
        L17:
            if (r9.hasNext() == false) goto L34;
            MenuItem r10 = (MenuItem) r9.next();
            int r11 = com.bytedance.ee.bear.document.permapply.b.a;
            Intrinsics.checkNotNullParameter(r10, "item");
            if (r10.getIcon() == null) goto L21;
            com.bytedance.ee.bear.document.permapply.a r12 = new com.bytedance.ee.bear.document.permapply.a(r10, r10.getIcon());
        L22:
            if (r12 == null) goto L23;
            ((BaseTitleBar.b) r12).a = r10.getId();
            ((BaseTitleBar.b) r12).d = r10.isEnable();
            ((BaseTitleBar.b) r12).b = r10.getBadgeStyle();
            ((BaseTitleBar.b) r12).c = r10.getBadgeNum();
            r8.a(r12, true);
            goto L17
        L23:
            tt5.a.d("NoPermMoreItemCreator", "Bad menu:" + r10);
            goto L17
        L21:
            r12 = null;
            goto L22
        L34:
            return;
        L33:
            return;
        L13:
            r8 = null;
            goto L14
        L9:
            r4 = null;
            goto L10
        L32:
            return;
        }
    }

    static {
        Companion = new a();
    }

    public final int getContainerId(boolean r1) {
        return 2131382161;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void setBackClickListener() {
        if (this.noPermissionView == null) goto L13;
        rz4.a r0 = (rz4.a) getHostAbilityOrNull(rz4.a.class);
        if (r0 == null) goto L14;
        au5.a r1 = this.noPermissionView;
        if (r1 == null) goto L9;
        r1.setBackIcon(l.a(getContext(), r0.getLeftImageResource(), 2131101926));
    L9:
        au5.a r2 = this.noPermissionView;
        if (r2 == null) goto L15;
        r2.setBackListener(new d(r0, this));
        return;
    L15:
        return;
    L14:
        return;
    }

    private final void setViewVisibleListener() {
        au5.a r0 = this.noPermissionView;
        if (r0 == null) goto L6;
        r0.mY(new e(this, r0));
        return;
    }

    public PermApplyPlugin() {
        this.showPermCallbacks = new ArrayList();
    }

    public final boolean isPermissionShow() {
        if (isUIContainerDetached() == false) goto L5;
        return false;
    L5:
        bn4.a r0 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
        if (r0.a(getHost()) == true) goto L8;
        t r1 = getUIContainer();
        if (r1 == null) goto L17;
        View r2 = r1.findView(2131382168);
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.getVisibility() != 0) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    L8:
        return r0.l(getUIContainer());
    }

    public final void removeAllPermissionView() {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        ViewGroup r1 = null;
        bn4.a r0 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
        if (r0.a(getHost()) == false) goto L9;
        r0.h(getUIContainer());
        return;
    L9:
        t r2 = getUIContainer();
        if (r2 == null) goto L19;
        View r3 = r2.findView(2131382161);
        if (r3 == null) goto L20;
        r3.setVisibility(8);
        if ((r3 instanceof ViewGroup) == false) goto L16;
        r1 = (ViewGroup) r3;
    L16:
        if (r1 == null) goto L21;
        r1.removeAllViews();
        return;
    L21:
        return;
    L20:
        return;
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(PermApplyPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(PermApplyPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ List access$getTitleBarRightMenus$p(PermApplyPlugin r0) {
        return r0.titleBarRightMenus;
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(PermApplyPlugin r0) {
        return r0.isUIContainerAttached();
    }

    private final void checkCacAsync(PermissionData r13) {
        PluginHost r0 = getHost();
        if (r0 == null) goto L11;
        vo5.a r1 = r0.getUserComponent();
        if (r1 == null) goto L11;
        dn4.a r2 = (dn4.a) r1.a(dn4.a.class);
        if (r2 == null) goto L11;
        g r3 = r2.a();
        if (r3 == null) goto L11;
        boolean r4 = r3.isEnable("ccm.doc.cac_check_device");
    L13:
        if (r4 == true) goto L16;
        tt5.a.h("PermApplyPlugin", "checkCacAsync, disabled by FG.");
        return;
    L16:
        String r6 = r13.getToken();
        int r5 = r13.getType();
        int r7 = r13.getType();
        if (r7 != 0) goto L19;
    L38:
        String r8 = "CCM_CONTENT_PREVIEW";
    L39:
        String r9 = r8;
    L40:
        tt5.a.h("PermApplyPlugin", "checkCacAsync, docToken: " + du5.b.i(r6) + ", type: " + r13.getType() + ", operateKey: " + r9);
        if (r6 != null) goto L43;
        return;
    L43:
        if (r9 != null) goto L45;
        return;
    L45:
        gj5.b r10 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        FileBizDomain r11 = FileBizDomain.FileBizDomainCCM;
        OwnerInfo r12 = r13.getOwner();
        if (r12 == null) goto L48;
        String r14 = r12.getId();
    L49:
        OwnerInfo r16 = r13.getOwner();
        if (r16 == null) goto L53;
        String r17 = r16.getTenant_id();
        if (r17 == null) goto L53;
    L54:
        r10.a(r9, r11, r5, r6, -1L, r14, r17, CheckPriority.RemoteFirst, new c(this, r6));
        return;
    L53:
        r17 = "";
        goto L54
    L48:
        r14 = null;
        goto L49
    L19:
        if (r7 == 8) goto L38;
        if (r7 == 16) goto L38;
        if (r7 == 22) goto L38;
        if (r7 == 30) goto L38;
        if (r7 != 998) goto L29;
    L37:
        r8 = "CCM_FILE_PREVIEW";
        goto L39
    L29:
        if (r7 == 2) goto L38;
        if (r7 == 3) goto L38;
        if (r7 == 11) goto L38;
        if (r7 == 12) goto L37;
        r9 = null;
    L11:
        r4 = false;
        goto L13
    }

    private final int getViewPermCode(PermissionData r1) {
        if (r1.isViewBlockByAuditControl() == false) goto L6;
        return VersionPayLoadData.STATE_DELETE;
    L6:
        return -1;
    }

    private final void showForbiddenFragment(PermissionData r26) {
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r16 = true;
    L7:
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.base_instruction_docx) goto L9;
        boolean r22 = true;
    L11:
        if (r26.isPerceiveControl() == true) goto L13;
    L18:
        boolean r9 = true;
    L20:
        if (r26.isPerceiveControl() == false) goto L23;
        int r8 = 2131887222;
    L30:
        if (r26.isConditionAccessControl() == false) goto L33;
        int r10 = 2131889845;
    L36:
        Iterator<T> r1 = this.showPermCallbacks.iterator();
    L38:
        if (r1.hasNext() == false) goto L40;
        ((b) r1.next()).a();
        goto L38
    L40:
        zt5.a r5 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
        FragmentManager r6 = getFragmentManager();
        boolean r11 = !r16;
        String r12 = getDocumentMetadata().getToken();
        int r13 = getDocumentMetadata().getDocumentTypeValue();
        boolean r17 = getDocumentMetadata().isType(sbb.e.n);
        PermissionData.PublicPermissions r2 = r26.getPublicPermissions();
        if (r2 == null) goto L44;
        String r3 = r2.getReportJsonString();
        if (r3 == null) goto L44;
    L45:
        this.noPermissionView = r5.Q2(r6, 2131382161, r8, r9, r10, r11, r12, r13, "", r16, r17, "", "forbidden", r3, r26.isPerceiveControl(), false, r22, getViewPermCode(r26));
        return;
    L44:
        r3 = "";
        goto L45
    L33:
        if (r26.isControlByDLPInnerControl() == false) goto L35;
        r10 = 2131888965;
        goto L36
    L35:
        r10 = -1;
        goto L36
    L23:
        if (r26.isConditionAccessControl() == false) goto L25;
    L28:
        r8 = 2131889846;
        goto L30
    L25:
        if (r26.isControlByDLPInnerControl() == true) goto L28;
        r8 = 2131888048;
        goto L30
    L13:
        if (r26.isConditionAccessControl() == true) goto L18;
        if (r26.isControlByDLPInnerControl() == true) goto L18;
        r9 = false;
        goto L20
    L9:
        r22 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    private final void showNoPermissionFragment(PermissionData r21) {
        OwnerInfo r0 = r21.getOwner();
        if (r0 == null) goto L8;
        String r1 = r0.getId();
        if (r1 == null) goto L8;
        String r16 = r1;
    L9:
        boolean r4 = false;
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L12;
        boolean r12 = true;
    L14:
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.base_instruction_docx) goto L16;
        boolean r18 = true;
    L18:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.synced_block.permission.authorise") == false) goto L23;
        if (getDocumentMetadata().isSyncBlock() == false) goto L23;
        r4 = true;
    L23:
        if (r21.getOwner() != null) goto L49;
    L28:
        String r8 = "";
    L29:
        Iterator<T> r2 = this.showPermCallbacks.iterator();
    L31:
        if (r2.hasNext() == false) goto L33;
        ((b) r2.next()).b();
        goto L31
    L33:
        zt5.a r3 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
        FragmentManager r5 = getFragmentManager();
        if (r4 == false) goto L36;
        String r6 = r21.getToken();
    L37:
        if (r4 == false) goto L39;
        String r7 = getDocumentMetadata().getOriginBearUrl().a;
    L40:
        sbb.e r9 = sbb.e.e(r7);
        boolean r10 = !r12;
        boolean r13 = getDocumentMetadata().isType(sbb.e.n);
        PermissionData.PublicPermissions r11 = r21.getPublicPermissions();
        if (r11 == null) goto L46;
        String r14 = r11.getReportJsonString();
        if (r14 == null) goto L46;
        String r17 = r14;
    L47:
        this.noPermissionView = r3.P7(r5, 2131382161, r6, r9, r8, true, r10, "", r12, r13, r17, r16, false, getViewPermCode(r21), r18, getDocumentMetadata().getOriginBearUrl());
        return;
    L46:
        r17 = "";
        goto L47
    L39:
        r7 = getDocumentMetadata().getDocumentType();
        goto L40
    L36:
        r6 = getDocumentMetadata().getToken();
        goto L37
    L49:
        r8 = ou5.a.d(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a(), r21.getOwner().getDisplay_name(), r21.getOwner().getName(), r21.getOwner().getEn_name());     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        tt5.a.d("PermApplyPlugin", "showNoPermission " + th.getMessage());
        goto L28
    L16:
        r18 = false;
        goto L18
    L12:
        r12 = false;
    L8:
        r16 = "";
        goto L9
    }

    public final void addPermCallback(b r3) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.disable_permission_not_allowed_view_callback") == true) goto L7;
        if (r3 == null) goto L8;
        this.showPermCallbacks.add(r3);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        this.showPermCallbacks.clear();
        super.onDetachFromHost(r2);
    }

    public final void removePermCallback(b r2) {
        if (r2 == null) goto L5;
        this.showPermCallbacks.remove(r2);
        return;
    }

    public final void setAssociatedNoPermMenus(List<? extends MenuItem> r3) {
        this.titleBarRightMenus = r3;
        StringBuilder r0 = new StringBuilder("setAssociatedNoPermMenus menus size ");
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.size());
    L6:
        r0.append(r4);
        tt5.a.h("PermApplyPlugin", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void showNoPermission(PermissionData r10) {
        Intrinsics.checkNotNullParameter(r10, "permissionData");
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        getHost().getContainer(ContainerType.Content.getValue()).setVisibility(4);
        View r0 = getUIContainer().findView(2131382161);
        boolean r1 = false;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
    L8:
        getDocumentMetadata().isType(sbb.e.n);
        OwnerInfo r2 = r10.getOwner();
        String r3 = "";
        if (r2 == null) goto L12;
        String r4 = r2.getTenant_id();
        if (r4 == null) goto L12;
    L13:
        AccountService$Account r5 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r5 == null) goto L19;
        String r6 = r5.tenantId;
        if (r6 == null) goto L19;
        r3 = r6;
    L19:
        if (r4.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L24;
    L26:
        boolean r8 = false;
    L27:
        OwnerInfo r9 = r10.getOwner();
        if (r9 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r8 == true) goto L43;
        OwnerInfo r12 = r10.getOwner();
        if (r12 != null) goto L37;
    L39:
        boolean r13 = false;
    L40:
        if (r13 == true) goto L43;
        boolean r14 = false;
    L44:
        boolean r16 = r10.isConditionAccessControl();
        boolean r17 = r10.isControlByDLPInnerControl();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r18 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.e() == true) goto L47;
    L49:
        if (r1 == true) goto L58;
        if (r11 == false) goto L55;
        if (r14 == false) goto L55;
        if (r16 == true) goto L55;
        if (r17 == false) goto L58;
    L55:
        showForbiddenFragment(r10);
        if (r10.isViewControlledByCAC() == false) goto L63;
        checkCacAsync(r10);
    L63:
        setViewVisibleListener();
        setBackClickListener();
        return;
    L58:
        bn4.a r19 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
        if (r19.a(getHost()) == false) goto L62;
        r19.j(getUIContainer());
        return;
    L62:
        showNoPermissionFragment(r10);
        goto L63
    L47:
        if (r10.isViewBlockByAuditControl() == false) goto L49;
        r1 = true;
        goto L49
    L37:
        if (r12.isAdmin_can_cross() != true) goto L39;
        r13 = true;
    L43:
        r14 = true;
        goto L44
    L30:
        if (r9.isCan_apply_perm() != true) goto L32;
        r11 = true;
        goto L33
    L24:
        if (TextUtils.equals(r4, r3) == false) goto L26;
        r8 = true;
        goto L27
    L21:
        r7 = false;
    L12:
        r4 = "";
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin
    public void updateTitleBarTipsExtra(boolean r3) {
        if (getDocumentMetadata().isEditionDoc() == false) goto L6;
        return;
    L6:
        if (isUIContainerDetached() == false) goto L9;
        return;
    L9:
        if (getUIContainer() != null) goto L11;
        return;
    L11:
        View r0 = getUIContainer().findView(2131382168);
        if (r0 != null) goto L14;
        return;
    L14:
        View r1 = r0.findViewById(2131382174);
        if (r1 != null) goto L17;
        return;
    L17:
        if (r3 == false) goto L19;
        int r4 = 0;
    L20:
        r1.setVisibility(r4);
        return;
    L19:
        r4 = 8;
        goto L20
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.titleBarRightMenus = null;
    }
}
