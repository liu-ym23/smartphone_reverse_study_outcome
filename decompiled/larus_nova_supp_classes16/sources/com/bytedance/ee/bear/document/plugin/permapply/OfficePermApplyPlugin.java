package com.bytedance.ee.bear.document.plugin.permapply;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.permission.PermissionData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyPermissionPageType;
import com.bytedance.ee.bear.middleground.permission.apply.NoPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 B2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002BCB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0011J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\u0016\u0010+\u001a\u00020\u00192\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u001c\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u00101\u001a\u00020\u0019J\u0006\u00102\u001a\u00020\u0011J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0011H\u0016J\u0010\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u00010\bJ\u0010\u00107\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u00010\bJ\u0012\u00108\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u00109\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010;\u001a\u00020\u00192\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010=\u001a\u00020\u0019H\u0002J\u0012\u0010>\u001a\u00020\u00112\b\b\u0002\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010A\u001a\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/permapply/OfficePermApplyPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/plugin/permapply/BasePermApplyPlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "()V", "showPermCallbacks", "", "Lcom/bytedance/ee/bear/document/plugin/permapply/OfficePermApplyPlugin$IShowPermCallback;", "noPermissionView", "Lcom/bytedance/ee/permission/view/INoPermissionView;", "passwordPermissionFragment", "Landroidx/fragment/app/Fragment;", "titleBarRightMenus", "", "Lcom/bytedance/ee/bear/browser/plugin/MenuItem;", "immersiveMode", "", "permissionApplyRootLayout", "Landroid/widget/FrameLayout;", "getPermissionApplyRootLayout", "()Landroid/widget/FrameLayout;", "permissionApplyRootLayout$delegate", "Lkotlin/Lazy;", "setImmersiveMode", "", "enabled", "isViewImmersive", "showNoPermission", "permissionData", "Lcom/bytedance/ee/bear/document/permission/PermissionData;", "showBitableProPermission", "ownerName", "", "ownerId", "showPasswordPermission", "onVerifiedCallback", "Ljava/lang/Runnable;", "isPasswordPermissionShow", "getViewPermCode", "", "setViewVisibleListener", "setBackClickListener", "setAssociatedNoPermMenus", "menus", "onDetachFromUIContainer", "host", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "removeAllPermissionView", "isPermissionShow", "updateTitleBarTipsExtra", "titleBarTipsShow", "addPermCallback", "permCallback", "removePermCallback", "onDetachFromHost", "showForbiddenFragment", "showNoPermissionFragment", "configurePermissionPageInsets", "fragment", "removePasswordPermissionFragment", "shouldShowBack", "isFromVc", "checkCacAsync", "ensurePermissionApplyRootLayoutAttached", "Companion", "IShowPermCallback", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePermApplyPlugin extends DocumentPluginV3 implements BasePermApplyPlugin<ChameleonPluginHost> {
    public static final a Companion = null;
    public static final String TAG = "PermApplyPlugin";
    private boolean immersiveMode;
    private au5.a noPermissionView;
    private Fragment passwordPermissionFragment;
    private final Lazy permissionApplyRootLayout$delegate;
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
        public final /* synthetic */ OfficePermApplyPlugin a;
        public final /* synthetic */ String b;

        public final void a(gj5.c r5) {
            Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
            String r0 = this.a.getDocumentMetadata().getToken();
            boolean r1 = OfficePermApplyPlugin.access$isUIContainerAttached(this.a);
            tt5.a.h("PermApplyPlugin", "checkCacAsync - onResult, docToken: " + this.b + ", currentDocToken: " + r0 + ", isAttached: " + r1);
            if (r1 == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r0, this.b) == false) goto L11;
            ValidateResult r6 = r5.c;
            if (r6 == null) goto L12;
            r6.handleAction();
            return;
        L12:
            return;
        }

        public c(OfficePermApplyPlugin r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ rz4.a a;
        public final /* synthetic */ OfficePermApplyPlugin b;

        public d(rz4.a r1, OfficePermApplyPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("PermApplyPlugin", "noPermissionView Back click");
            if (this.a.processContentEvent(new sz4.a()) == true) goto L6;
            OfficePermApplyPlugin.access$getActivity(this.b).onBackPressed();
            return;
        }
    }

    public static final class e implements au5.b {
        public final /* synthetic */ OfficePermApplyPlugin a;
        public final /* synthetic */ au5.a b;

        public e(OfficePermApplyPlugin r1, au5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r6) {
            tt5.a.h("PermApplyPlugin", "setViewVisibleListener callback " + r6);
            if (r6 == false) goto L25;
            List r7 = OfficePermApplyPlugin.access$getTitleBarRightMenus$p(this.a);
            if (r7 == null) goto L32;
            OfficePermApplyPlugin r0 = this.a;
            au5.a r2 = this.b;
            StringBuilder r3 = new StringBuilder("setViewVisibleListener callback menus: ");
            List r1 = OfficePermApplyPlugin.access$getTitleBarRightMenus$p(r0);
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
            int r11 = com.bytedance.ee.bear.document.plugin.permapply.b.a;
            Intrinsics.checkNotNullParameter(r10, "item");
            if (r10.getIcon() == null) goto L21;
            com.bytedance.ee.bear.document.plugin.permapply.a r12 = new com.bytedance.ee.bear.document.plugin.permapply.a(r10, r10.getIcon());
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

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final FrameLayout getPermissionApplyRootLayout() {
        return (FrameLayout) this.permissionApplyRootLayout$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removePasswordPermissionFragment() {
        Fragment r0 = this.passwordPermissionFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        this.passwordPermissionFragment = null;
        if (r0.isAdded() == true) goto L8;
        return;
    L8:
        if (r0.isRemoving() == true) goto L12;
        getFragmentManager().beginTransaction().remove(r0).commitAllowingStateLoss();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBackClickListener() {
        if (this.noPermissionView == null) goto L14;
        rz4.a r0 = (rz4.a) getHostAbilityOrNull(rz4.a.class);
        if (r0 != null) goto L7;
        return;
    L7:
        au5.a r1 = this.noPermissionView;
        if (r1 == null) goto L10;
        r1.setBackIcon(l.a(getContext(), r0.getLeftImageResource(), 2131101926));
    L10:
        au5.a r2 = this.noPermissionView;
        if (r2 == null) goto L15;
        r2.setBackListener(new d(r0, this));
        return;
    L15:
        return;
    }

    private final void setViewVisibleListener() {
        au5.a r0 = this.noPermissionView;
        if (r0 == null) goto L6;
        r0.mY(new e(this, r0));
        return;
    }

    public OfficePermApplyPlugin() {
        this.showPermCallbacks = new ArrayList();
        this.permissionApplyRootLayout$delegate = LazyKt.lazy(new OfficePermApplyPlugin$permissionApplyRootLayout$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void ensurePermissionApplyRootLayoutAttached() {
        if (getPermissionApplyRootLayout().getParent() != null) goto L6;
        getUIContainer().c(this).addView(getPermissionApplyRootLayout(), new ViewGroup.LayoutParams(-1, -1));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPasswordPermissionShow() {
        if (isUIContainerDetached() == false) goto L5;
        return false;
    L5:
        Fragment r0 = this.passwordPermissionFragment;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.isRemoving() == true) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPermissionShow() {
        if (isUIContainerDetached() == false) goto L5;
        return false;
    L5:
        t r0 = getUIContainer();
        if (r0 == null) goto L13;
        View r1 = r0.findView(2131382168);
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.getVisibility() != 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeAllPermissionView() {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        removePasswordPermissionFragment();
        FrameLayout r0 = getPermissionApplyRootLayout();
        r0.setVisibility(8);
        r0.removeAllViews();
        this.noPermissionView = null;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return this.immersiveMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentActivity access$getActivity(OfficePermApplyPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ Context access$getContext(OfficePermApplyPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ List access$getTitleBarRightMenus$p(OfficePermApplyPlugin r0) {
        return r0.titleBarRightMenus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean access$isUIContainerAttached(OfficePermApplyPlugin r0) {
        return r0.isUIContainerAttached();
    }

    private final void checkCacAsync(PermissionData r13) {
        ChameleonPluginHost r0 = getHost();
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

    private final void configurePermissionPageInsets(Fragment r2) {
        if (this.immersiveMode == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L8;
        f r3 = WindowInsetsUtils.b(r2);
        r3.c(true);
        r3.o(true);
        return;
    }

    private final int getViewPermCode(PermissionData r1) {
        if (r1.isViewBlockByAuditControl() == false) goto L6;
        return VersionPayLoadData.STATE_DELETE;
    L6:
        return -1;
    }

    private final boolean shouldShowBack(boolean r4) {
        if (this.immersiveMode == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r4 == true) goto L11;
        if (r0 == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (AppInfoUtils.f().booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        ensurePermissionApplyRootLayoutAttached();
        zt5.a r5 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
        FragmentManager r6 = getFragmentManager();
        int r7 = getPermissionApplyRootLayout().getId();
        boolean r11 = shouldShowBack(r16);
        String r12 = getDocumentMetadata().getToken();
        int r13 = getDocumentMetadata().getDocumentTypeValue();
        boolean r17 = getDocumentMetadata().isType(sbb.e.n);
        PermissionData.PublicPermissions r2 = r26.getPublicPermissions();
        if (r2 == null) goto L44;
        String r3 = r2.getReportJsonString();
        if (r3 == null) goto L44;
    L45:
        this.noPermissionView = r5.Q2(r6, r7, r8, r9, r10, r11, r12, r13, "", r16, r17, "", "forbidden", r3, r26.isPerceiveControl(), false, r22, getViewPermCode(r26));
        configurePermissionPageInsets$default(this, null, 1, null);
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

    /* JADX WARN: Multi-variable type inference failed */
    private final void showNoPermissionFragment(PermissionData r21) {
        OwnerInfo r0 = r21.getOwner();
        String r2 = "";
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
        if (r21.getOwner() != null) goto L48;
    L28:
        String r8 = "";
    L29:
        Iterator<T> r3 = this.showPermCallbacks.iterator();
    L31:
        if (r3.hasNext() == false) goto L33;
        ((b) r3.next()).b();
        goto L31
    L33:
        ensurePermissionApplyRootLayoutAttached();
        zt5.a r5 = (zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6);
        FragmentManager r6 = getFragmentManager();
        int r7 = getPermissionApplyRootLayout().getId();
        if (r4 == false) goto L36;
        String r9 = r21.getToken();
    L37:
        if (r4 == false) goto L39;
        String r10 = getDocumentMetadata().getOriginBearUrl().a;
    L40:
        sbb.e r11 = sbb.e.e(r10);
        boolean r13 = shouldShowBack(r12);
        boolean r14 = getDocumentMetadata().isType(sbb.e.n);
        PermissionData.PublicPermissions r17 = r21.getPublicPermissions();
        if (r17 == null) goto L46;
        String r19 = r17.getReportJsonString();
        if (r19 == null) goto L46;
        r2 = r19;
    L46:
        this.noPermissionView = r5.P7(r6, r7, r9, r11, r8, true, r13, "", r12, r14, r2, r16, false, getViewPermCode(r21), r18, getDocumentMetadata().getOriginBearUrl());
        configurePermissionPageInsets$default(this, null, 1, null);
        return;
    L39:
        r10 = getDocumentMetadata().getDocumentType();
        goto L40
    L36:
        r9 = getDocumentMetadata().getToken();
        goto L37
    L48:
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

    public void onDetachFromHost(ChameleonPluginHost r2) {
        this.showPermCallbacks.clear();
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
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

    public final void setImmersiveMode(boolean r1) {
        this.immersiveMode = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showNoPermission(PermissionData r7) {
        Intrinsics.checkNotNullParameter(r7, "permissionData");
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        getPermissionApplyRootLayout().setVisibility(0);
        getDocumentMetadata().isType(sbb.e.n);
        OwnerInfo r0 = r7.getOwner();
        String r2 = "";
        if (r0 == null) goto L9;
        String r3 = r0.getTenant_id();
        if (r3 == null) goto L9;
    L10:
        AccountService$Account r4 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r4 == null) goto L16;
        String r5 = r4.tenantId;
        if (r5 == null) goto L16;
        r2 = r5;
    L16:
        if (r3.length() <= 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L24;
        if (TextUtils.equals(r3, r2) == false) goto L24;
        r1 = true;
    L24:
        if (r7.getOwner() == null) goto L35;
        if (r7.getOwner().isCan_apply_perm() == false) goto L35;
        if (r7.getOwner().isAdmin_can_cross() == true) goto L31;
        if (r1 == false) goto L35;
    L31:
        if (r7.isConditionAccessControl() == true) goto L35;
        if (r7.isControlByDLPInnerControl() == true) goto L35;
    L39:
        showNoPermissionFragment(r7);
    L40:
        setViewVisibleListener();
        setBackClickListener();
        return;
    L35:
        if (r7.isViewBlockByAuditControl() == true) goto L39;
        showForbiddenFragment(r7);
        if (r7.isViewControlledByCAC() == false) goto L40;
        checkCacAsync(r7);
        goto L40
    L18:
        r6 = false;
    L9:
        r3 = "";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showPasswordPermission(Runnable r12) {
        Intrinsics.checkNotNullParameter(r12, "onVerifiedCallback");
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.showPermCallbacks.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((b) r0.next()).b();
        goto L7
    L9:
        ensurePermissionApplyRootLayoutAttached();
        getPermissionApplyRootLayout().setVisibility(0);
        y3 r1 = getDocumentMetadata();
        Fragment r13 = ((zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6)).d6(getFragmentManager(), r1.getToken(), r1.getDocumentTypeValue(), getPermissionApplyRootLayout().getId(), shouldShowBack$default(this, false, 1, null), r12);
        this.passwordPermissionFragment = r13;
        configurePermissionPageInsets(r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin
    public void updateTitleBarTipsExtra(boolean r2) {
        if (getDocumentMetadata().isEditionDoc() == false) goto L6;
        return;
    L6:
        if (isUIContainerDetached() == false) goto L9;
        return;
    L9:
        if (getUIContainer() != null) goto L11;
        return;
    L11:
        au5.a r0 = this.noPermissionView;
        if (r0 == null) goto L21;
        View r1 = r0.NW();
        if (r1 == null) goto L22;
        if (r2 == false) goto L18;
        int r3 = 0;
    L19:
        r1.setVisibility(r3);
        return;
    L18:
        r3 = 8;
        goto L19
    L22:
        return;
    }

    @Override // com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        removePasswordPermissionFragment();
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        this.titleBarRightMenus = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showBitableProPermission(String r26, String r27) {
        Intrinsics.checkNotNullParameter(r26, "ownerName");
        Intrinsics.checkNotNullParameter(r27, "ownerId");
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        Iterator<T> r3 = this.showPermCallbacks.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((b) r3.next()).b();
        goto L7
    L9:
        ensurePermissionApplyRootLayoutAttached();
        getPermissionApplyRootLayout().setVisibility(0);
        y3 r4 = getDocumentMetadata();
        ApplyPermissionPageType r7 = ApplyPermissionPageType.NORMAL;
        Intrinsics.checkNotNullParameter(r26, "ownerName");
        Intrinsics.checkNotNullParameter(r27, "ownerId");
        String r2 = r4.getToken();
        Intrinsics.checkNotNullParameter(r2, "token");
        sbb.e r1 = sbb.e.e(r4.getDocumentType());
        Intrinsics.checkNotNullParameter(r1, "documentType");
        String r8 = String.valueOf(r1.b);
        boolean r10 = shouldShowBack$default(this, false, 1, null);
        int r9 = getPermissionApplyRootLayout().getId();
        boolean r18 = r4.isType(sbb.e.n);
        if (r4.getOpenSource() != DocsOpenSource.base_instruction_docx) goto L12;
        boolean r21 = true;
    L13:
        ApplyPermissionPageType r5 = ApplyPermissionPageType.BITABLE_PRO;
        Intrinsics.checkNotNullParameter(r5, "applyPageType");
        NoPermission r11 = new NoPermission(r2, r8, false, "", r26, "", true, r9, r10, "", false, r18, "", "", "", false, r27, false, 0, r21, null, r5);
        this.noPermissionView = ((zt5.a) org.koin.java.a.c(zt5.a.class, null, null, 6)).Xd(getFragmentManager(), r11);
        configurePermissionPageInsets$default(this, null, 1, null);
        setViewVisibleListener();
        setBackClickListener();
        return;
    L12:
        r21 = false;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.plugin.permapply.BasePermApplyPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public static /* synthetic */ void configurePermissionPageInsets$default(OfficePermApplyPlugin r0, Fragment r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L8;
        au5.a r4 = r0.noPermissionView;
        if ((r4 instanceof Fragment) == false) goto L7;
        r1 = (Fragment) r4;
        goto L8
    L7:
        r1 = null;
    L8:
        r0.configurePermissionPageInsets(r1);
    }

    public static /* synthetic */ boolean shouldShowBack$default(OfficePermApplyPlugin r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.shouldShowBack(r1);
    }
}
