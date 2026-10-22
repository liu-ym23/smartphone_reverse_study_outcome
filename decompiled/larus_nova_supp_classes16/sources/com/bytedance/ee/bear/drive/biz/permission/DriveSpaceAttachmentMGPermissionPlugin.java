package com.bytedance.ee.bear.drive.biz.permission;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveSpaceAttachmentMGPermissionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "dlpContext", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMOpenFileSceneContext;", "isDlpMigrate", "", "metaInfoObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DriveMetaInfo;", "handleDlpCopyAction", "", "handleSecretEditAction", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceAttachmentMGPermissionPlugin extends AbsDrivePlugin {
    private com.ss.android.lark.security.compliance.api.model.filepolicy.c dlpContext;
    private boolean isDlpMigrate;
    private final Observer<u55.a> metaInfoObserver;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionPlugin a;

        public a(DriveSpaceAttachmentMGPermissionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Intrinsics.checkNotNullParameter((u55.a) r2, "it");
            DriveSpaceAttachmentMGPermissionPlugin.access$handleDlpCopyAction(this.a);
            DriveSpaceAttachmentMGPermissionPlugin.access$handleSecretEditAction(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionVM a;
        public final /* synthetic */ DrivePluginHost b;

        public b(DriveSpaceAttachmentMGPermissionVM r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
            if (r4 == null) goto L7;
            boolean r1 = true;
            if (r4.a() != true) goto L7;
        L8:
            if (r1 == true) goto L10;
        L12:
            if (r4 != null) goto L14;
            return;
        L14:
            if (r4.a() == true) goto L25;
            DriveSpaceAttachmentMGPermissionVM r5 = this.a;
            DriveViewModel r0 = this.b.c;
            if (r0 == null) goto L20;
            BaseOpenEntity r2 = r0.getOpenEntity();
            if (r2 == null) goto L20;
            String r6 = r2.getFileId();
        L21:
            r5.postOfflinePerm(r6);
            return;
        L20:
            r6 = null;
            goto L21
        L25:
            return;
        L10:
            if (this.a.livePerm().getValue() != null) goto L12;
            this.a.fetchPermission(this.b.c.getOpenEntity().getFileId(), "");
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePermissionViewModel b;
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionVM c;
        public final /* synthetic */ DriveSpaceAttachmentMGPermissionPlugin d;

        public c(DrivePluginHost r1, DrivePermissionViewModel r2, DriveSpaceAttachmentMGPermissionVM r3, DriveSpaceAttachmentMGPermissionPlugin r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onChanged(Object r5) {
            u55.b r6 = (u55.b) r5;
            MutableLiveData<Boolean> r0 = k75.a.i(this.a).liveOuterExportVisible();
            boolean r1 = false;
            if (r6 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            r0.postValue(Boolean.valueOf(r3));
            this.b.getLiveCopyEscape().postValue(this.c.liveCopyEscape().getValue());
            MutableLiveData<Boolean> r2 = this.b.getLiveOuterRawCopyable();
            if (r6 != null) goto L11;
        L13:
            boolean r4 = false;
        L14:
            r2.postValue(Boolean.valueOf(r4));
            MutableLiveData<Boolean> r7 = this.b.getLiveOuterEditable();
            if (r6 != null) goto L17;
        L19:
            r7.postValue(Boolean.valueOf(r1));
            DriveSpaceAttachmentMGPermissionPlugin.access$handleDlpCopyAction(this.d);
            DriveSpaceAttachmentMGPermissionPlugin.access$handleSecretEditAction(this.d);
            return;
        L17:
            if (r6.c() != true) goto L19;
            r1 = true;
            goto L19
        L11:
            if (r6.b() != true) goto L13;
            r4 = true;
            goto L14
        L5:
            if (r6.d() != true) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DrivePermissionViewModel a;

        public d(DrivePermissionViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<Boolean> r0 = this.a.getLiveCopyEscape();
            r0.postValue((Boolean) r2);
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handleDlpCopyAction() {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
        u55.b r1 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        boolean r2 = false;
        if (r0 == null) goto L23;
        if (r1 == null) goto L23;
        if (r0.b == null) goto L23;
        if (r1.b == null) goto L23;
        int r4 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (getHost().c.getBizType() != 1) goto L13;
        r2 = true;
    L13:
        if (r2 == true) goto L32;
        String r3 = r0.b.getCreatorTenantId();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L21;
        MutableLiveData<String> r5 = ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getTenantId();
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        r5.postValue(r3);
        return;
    L21:
        int r6 = ll5.a.a;
        int r7 = ll5.a.a(r0.b.getCreatorTenantId(), r1.a);
        k75.a.i(getHost()).getLiveOuterDlpCode().postValue(Integer.valueOf(r7));
        return;
    L32:
        return;
    L23:
        StringBuilder r8 = new StringBuilder("meta is null?");
        if (r0 != null) goto L26;
        boolean r9 = true;
    L27:
        r8.append(r9);
        r8.append(", permission is null?");
        if (r1 != null) goto L30;
        r2 = true;
    L30:
        r8.append(r2);
        tt5.a.b("DriveMGPermissionPlugin", r8.toString());
        return;
    L26:
        r9 = false;
        goto L27
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

    public DriveSpaceAttachmentMGPermissionPlugin() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isDlpMigrate = jg5.e.a.a.g();
        this.metaInfoObserver = new a(this);
    }

    public static final /* synthetic */ void access$handleDlpCopyAction(DriveSpaceAttachmentMGPermissionPlugin r0) {
        r0.handleDlpCopyAction();
    }

    public static final /* synthetic */ void access$handleSecretEditAction(DriveSpaceAttachmentMGPermissionPlugin r0) {
        r0.handleSecretEditAction();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super.onAttachToHost(r10);
        final DriveSpaceAttachmentMGPermissionVM r0 = (DriveSpaceAttachmentMGPermissionVM) viewModel(DriveSpaceAttachmentMGPermissionVM.class);
        DrivePermissionViewModel r1 = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        if (this.isDlpMigrate == false) goto L11;
        DriveViewModel r2 = r10.c;
        if (r2 == null) goto L11;
        if (r2.getOpenEntity() == null) goto L11;
        String r3 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).c(12);
        this.dlpContext = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(r10.c.getFileId(), r3, 12, new AnonymousClass1(r0, this));
        BizDomain r4 = pw4.b.a(r10.c.getOpenEntity().getMountPoint());
        FileBizDomain r5 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).a(r4);
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r6 = this.dlpContext;
        if (r6 == null) goto L11;
        r6.a(r5, null, null);
    L11:
        k75.a.h(this, new b(r0, r10));
        r0.livePerm().observe(getLifecycleOwner(), new c(r10, r1, r0, this));
        r0.liveCopyEscape().observe(getLifecycleOwner(), new d(r1));
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().observe(getLifecycleOwner(), this.metaInfoObserver);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        ((DriveMetaInfoVM) viewModel(DriveMetaInfoVM.class)).getLiveMetaInfo().removeObserver(this.metaInfoObserver);
        if (this.isDlpMigrate == false) goto L8;
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r3 = this.dlpContext;
        if (r3 == null) goto L9;
        r3.c();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceAttachmentMGPermissionPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
