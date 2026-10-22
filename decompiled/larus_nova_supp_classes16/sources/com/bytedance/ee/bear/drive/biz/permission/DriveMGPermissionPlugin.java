package com.bytedance.ee.bear.drive.biz.permission;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import b95.l;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMLocalFileContent;
import com.ss.android.lark.security.compliance.api.model.filepolicy.RefreshContext;
import java.util.Set;
import jg5.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveMGPermissionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mLeaderAuthTipsDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "mLastViewAuthByLeader", "", "metaInfoObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "cacRefreshContext", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/RefreshContext;", "handleDlpCopyAction", "", "handleSecretEditAction", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "showLeaderAutoAuthDialog", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "objToken", "", "onDetachFromHost", "initCacRefreshListener", "destroyCacRefreshListener", "startCacRefreshListener", "stopCacRefreshListener", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMGPermissionPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveMGPermissionPlugin";
    private RefreshContext cacRefreshContext;
    private boolean mLastViewAuthByLeader;
    private UDDialog mLeaderAuthTipsDialog;
    private final Observer<u55.a> metaInfoObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements RefreshContext.a {
        public final /* synthetic */ DriveMGPermissionPlugin a;
        public final /* synthetic */ String b;

        public b(DriveMGPermissionPlugin r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r6, Set<String> r7) {
            Intrinsics.checkNotNullParameter(r6, "traceId");
            Intrinsics.checkNotNullParameter(r7, "policyKeySet");
            DrivePluginHost r8 = this.a.getHost();
            if (r8 == null) goto L9;
            DriveViewModel r9 = r8.c;
            if (r9 == null) goto L9;
            BaseOpenEntity r10 = r9.getOpenEntity();
            if (r10 == null) goto L9;
            String r11 = r10.getFileId();
        L10:
            boolean r1 = DriveMGPermissionPlugin.access$isUIContainerAttached(this.a);
            DriveMGPermissionVM r2 = (DriveMGPermissionVM) DriveMGPermissionPlugin.access$viewModel(this.a, DriveMGPermissionVM.class);
            tt5.a.h(DriveMGPermissionPlugin.TAG, "initCacRefreshListener - needRefresh, traceId: " + r6 + ", fileId: " + du5.b.i(this.b) + ", currentFileId: " + du5.b.i(r11) + ", isAttached: " + r1 + ", permissionVM: " + r2);
            if (r1 == true) goto L13;
            return;
        L13:
            if (Intrinsics.areEqual(r11, this.b) == false) goto L18;
            if (r2 == null) goto L19;
            DriveMGPermissionVM.fetchPermission$default(r2, this.b, null, 2, null);
            return;
        L19:
            return;
        L18:
            return;
        L9:
            r11 = null;
            goto L10
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveMGPermissionPlugin a;

        public c(DriveMGPermissionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((u55.a) r2, "it");
            DriveMGPermissionPlugin.access$handleDlpCopyAction(this.a);
            DriveMGPermissionPlugin.access$handleSecretEditAction(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveMGPermissionVM a;
        public final /* synthetic */ DrivePluginHost b;

        public d(DriveMGPermissionVM r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            ConnectionService.NetworkState r5 = (ConnectionService.NetworkState) r4;
            if (r5 == null) goto L7;
            boolean r1 = true;
            if (r5.a() != true) goto L7;
        L8:
            String r0 = null;
            if (r1 == true) goto L11;
        L13:
            if (r5 != null) goto L15;
            return;
        L15:
            if (r5.a() == true) goto L25;
            DriveMGPermissionVM r6 = this.a;
            DriveViewModel r2 = this.b.c;
            if (r2 == null) goto L21;
            BaseOpenEntity r3 = r2.getOpenEntity();
            if (r3 == null) goto L21;
            r0 = r3.getFileId();
        L21:
            r6.postOfflinePerm(r0);
            return;
        L25:
            return;
        L11:
            if (this.a.livePerm().getValue() != null) goto L13;
            DriveMGPermissionVM.fetchPermission$default(this.a, this.b.c.getOpenEntity().getFileId(), null, 2, null);
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePermissionViewModel b;
        public final /* synthetic */ DriveMGPermissionVM c;
        public final /* synthetic */ DriveMGPermissionPlugin d;

        public e(DrivePluginHost r1, DrivePermissionViewModel r2, DriveMGPermissionVM r3, DriveMGPermissionPlugin r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onChanged(Object r18) {
            u55.b r1 = (u55.b) r18;
            MutableLiveData<Boolean> r2 = k75.a.i(this.a).liveOuterExportVisible();
            boolean r3 = false;
            if (r1 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            r2.postValue(Boolean.valueOf(r5));
            this.b.getLiveCopyEscape().postValue(this.c.getLiveCopyEscape().getValue());
            MutableLiveData<Boolean> r4 = this.b.getLiveOuterRawCopyable();
            if (r1 != null) goto L11;
        L13:
            boolean r6 = false;
        L14:
            r4.postValue(Boolean.valueOf(r6));
            MutableLiveData<Boolean> r7 = this.b.getLiveOuterEditable();
            if (r1 != null) goto L17;
        L19:
            boolean r8 = false;
        L20:
            r7.postValue(Boolean.valueOf(r8));
            DriveMGPermissionPlugin.access$handleDlpCopyAction(this.d);
            DriveMGPermissionPlugin.access$handleSecretEditAction(this.d);
            if (r1 == null) goto L46;
            DrivePluginHost r9 = this.a;
            DriveMGPermissionPlugin r10 = this.d;
            tt5.a.h("DriveComponent", "DriveMGPermissionPlugin#onChanged()... token= " + du5.b.g(r1.a) + ", selfPermission = " + r1.b.a.getPermissions() + ", previewStatusCode = " + r1.f());
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
            k r11 = k.a.a;
            String r12 = r1.a;
            int r13 = sbb.e.l.b;
            String r14 = com.bytedance.ee.util.io.a.c(r9.c.getFileName());
            boolean r16 = r9.c.isTypeWiki();
            DocPermission r17 = r1.b;
            if (r17 == null) goto L28;
            IDocUserPermission r19 = r17.a;
            if (r19 == null) goto L28;
            String r20 = r19.getReportJson();
            if (r20 == null) goto L28;
        L29:
            DocPermission r110 = r1.b;
            if (r110 == null) goto L35;
            IDocPublicPermission r111 = r110.b;
            if (r111 == null) goto L35;
            String r112 = r111.getReportJson();
            if (r112 == null) goto L35;
        L36:
            r11.e(r12, r13, r14, r16, r20, r112, r9.c.isVCFollowMode(), "", "");
            DocPermission r21 = r1.b;
            if (r21 == null) goto L43;
            IDocUserPermission r22 = r21.a;
            if (r22 == null) goto L43;
            if (r22.isViewAuthByLeader() != true) goto L43;
            r3 = true;
        L43:
            if (r3 == false) goto L47;
            DriveMGPermissionPlugin.access$showLeaderAutoAuthDialog(r10, r1.b, r1.a);
            return;
        L47:
            return;
        L35:
            r112 = "";
        L28:
            r20 = "";
            goto L29
        L46:
            return;
        L17:
            if (r1.c() != true) goto L19;
            r8 = true;
            goto L20
        L11:
            if (r1.b() != true) goto L13;
            r6 = true;
            goto L14
        L5:
            if (r1.d() != true) goto L7;
            r5 = true;
            goto L8
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DrivePermissionViewModel a;

        public f(DrivePermissionViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<Boolean> r0 = this.a.getLiveCopyEscape();
            r0.postValue((Boolean) r2);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveMGPermissionPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public g(DriveMGPermissionPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r7) {
            Boolean r8 = (Boolean) r7;
            tt5.a.k("DriveComponent", "liveTooManyRequestTips receive v=" + r8);
            if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L15;
            l r0 = o75.b.a().H7();
            FragmentActivity r1 = DriveMGPermissionPlugin.access$getActivity(this.a);
            String r3 = DriveMGPermissionPlugin.access$getResources(this.a).getString(2131888430);
            com.bytedance.ee.bear.drive.biz.permission.a r5 = new com.bytedance.ee.bear.drive.biz.permission.a(this.b);
            r0.getClass();
            UDDialog r9 = r0.b(r1, null, r3, r1.getString(2131888375), r5);
            if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r9);
            return;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r9);
            r9.show();
            DialogLancet.afterDialogShow(r9);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void destroyCacRefreshListener() {
        RefreshContext r0 = this.cacRefreshContext;
        if (r0 == null) goto L6;
        this.cacRefreshContext = null;
        r0.unregisterObserver();
        tt5.a.h(TAG, "destroyCacRefreshListener");
        return;
    }

    private final void handleDlpCopyAction() {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r1 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        boolean r2 = false;
        if (r0 == null) goto L21;
        if (r1 == null) goto L21;
        if (r0.b == null) goto L21;
        int r4 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (getHost().c.getBizType() != 1) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L30;
        String r3 = r0.b.getCreatorTenantId();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L19;
        MutableLiveData<String> r5 = ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getTenantId();
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        r5.postValue(r3);
        return;
    L19:
        int r6 = ll5.a.a;
        int r7 = ll5.a.a(r0.b.getCreatorTenantId(), r1.a);
        k75.a.i(getHost()).getLiveOuterDlpCode().postValue(Integer.valueOf(r7));
        return;
    L30:
        return;
    L21:
        StringBuilder r8 = new StringBuilder("meta is null?");
        if (r0 != null) goto L24;
        boolean r9 = true;
    L25:
        r8.append(r9);
        r8.append(", permission is null?");
        if (r1 != null) goto L28;
        r2 = true;
    L28:
        r8.append(r2);
        tt5.a.b(TAG, r8.toString());
        return;
    L24:
        r9 = false;
        goto L25
    }

    private final void handleSecretEditAction() {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r1 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        IDocUserPermission r2 = null;
        if (r0 == null) goto L5;
        DocMetaInfo r3 = r0.b;
    L6:
        if (r1 == null) goto L10;
        DocPermission r4 = r1.b;
        if (r4 == null) goto L10;
        r2 = r4.a;
    L10:
        k75.a.i(getHost()).liveOuterEditableFromSecret().postValue(Boolean.valueOf(fj5.a.d(r3, r2)));
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void startCacRefreshListener() {
        RefreshContext r0 = this.cacRefreshContext;
        if (r0 == null) goto L6;
        r0.registerObserver();
        Unit r1 = Unit.INSTANCE;
        tt5.a.h(TAG, "startCacRefreshListener");
        return;
    }

    private final void stopCacRefreshListener() {
        RefreshContext r0 = this.cacRefreshContext;
        if (r0 == null) goto L6;
        r0.unregisterObserver();
        Unit r1 = Unit.INSTANCE;
        tt5.a.h(TAG, "stopCacRefreshListener");
        return;
    }

    public DriveMGPermissionPlugin() {
        this.metaInfoObserver = new c(this);
    }

    private final void initCacRefreshListener() {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L11;
        vo5.a r1 = r0.getUserComponent();
        if (r1 == null) goto L11;
        dn4.a r2 = (dn4.a) r1.a(dn4.a.class);
        if (r2 == null) goto L11;
        jdb.g r3 = r2.a();
        if (r3 == null) goto L11;
        boolean r4 = r3.isEnable("ccm.doc.cac_check_device");
    L13:
        if (r4 == true) goto L16;
        tt5.a.h(TAG, "initCacRefreshListener, disabled by FG.");
        return;
    L16:
        DrivePluginHost r5 = getHost();
        if (r5 == null) goto L23;
        DriveViewModel r6 = r5.c;
        if (r6 == null) goto L23;
        BaseOpenEntity r7 = r6.getOpenEntity();
        if (r7 == null) goto L23;
        String r8 = r7.getFileId();
    L24:
        String r9 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).c(12);
        tt5.a.h(TAG, "initCacRefreshListener, fileId: " + du5.b.i(r8) + ", fileEntityType: " + r9);
        if (r8 != null) goto L28;
        return;
    L28:
        if (this.cacRefreshContext != null) goto L31;
        this.cacRefreshContext = new RefreshContext(new CCMLocalFileContent(r8, r9), new b(this, r8));
        return;
    L31:
        return;
    L23:
        r8 = null;
    L11:
        r4 = false;
        goto L13
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveMGPermissionPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Resources access$getResources(DriveMGPermissionPlugin r0) {
        return r0.getResources();
    }

    public static final /* synthetic */ void access$handleDlpCopyAction(DriveMGPermissionPlugin r0) {
        r0.handleDlpCopyAction();
    }

    public static final /* synthetic */ void access$handleSecretEditAction(DriveMGPermissionPlugin r0) {
        r0.handleSecretEditAction();
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DriveMGPermissionPlugin r0) {
        return r0.isUIContainerAttached();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onAttachToHost(r6);
        DriveMGPermissionVM r0 = (DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class);
        DrivePermissionViewModel r1 = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        k75.a.h(this, new d(r0, r6));
        r0.livePerm().observe(getLifecycleOwner(), new e(r6, r1, r0, this));
        r0.getLiveCopyEscape().observe(getLifecycleOwner(), new f(r1));
        r0.getLiveTooManyRequestTips().observe(getLifecycleOwner(), new g(this, r6));
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), this.metaInfoObserver);
        initCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().removeObserver(this.metaInfoObserver);
        destroyCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveMGPermissionPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void showLeaderAutoAuthDialog(DocPermission r5, String r6) {
        if (this.mLastViewAuthByLeader == false) goto L6;
        tt5.a.h(TAG, "showLeaderAutoAuthDialog()...mLastViewAuthByLeader is true.");
        return;
    L6:
        UDDialog r0 = this.mLeaderAuthTipsDialog;
        boolean r2 = false;
        if (r0 == null) goto L11;
        boolean r3 = true;
        if (r0.isShowing() != true) goto L11;
    L12:
        if (r3 == false) goto L15;
        tt5.a.h(TAG, "showLeaderAutoAuthDialog()...already showing.");
        return;
    L15:
        this.mLeaderAuthTipsDialog = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).nc(getContext(), r6);
        if (r5 == null) goto L20;
        IDocUserPermission r7 = r5.a;
        if (r7 == null) goto L20;
        r2 = r7.isViewAuthByLeader();
    L20:
        this.mLastViewAuthByLeader = r2;
        return;
    L11:
        r3 = false;
        goto L12
    }

    public void onAttachToUIContainer(DrivePluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        startCacRefreshListener();
    }

    public void onDetachFromUIContainer(DrivePluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        stopCacRefreshListener();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    public static final /* synthetic */ void access$showLeaderAutoAuthDialog(DriveMGPermissionPlugin r0, DocPermission r1, String r2) {
        r0.showLeaderAutoAuthDialog(r1, r2);
    }
}
