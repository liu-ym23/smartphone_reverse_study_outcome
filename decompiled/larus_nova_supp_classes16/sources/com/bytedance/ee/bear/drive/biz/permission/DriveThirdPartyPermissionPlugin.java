package com.bytedance.ee.bear.drive.biz.permission;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderPermissionCallback;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v55.g;
import v55.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0019\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/DriveThirdPartyPermissionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/middleground/permission/model/drive/DocPermissionChange;", "<init>", "()V", "dlpContext", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/CCMOpenFileSceneContext;", "isDlpMigrate", "", "parentDocToken", "", "parentDocType", "", "permissionPush", "Lcom/bytedance/ee/bear/drive/biz/permission/push/DriveThirdPartyAttachmentPermissionPush;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "onDetachFromHost", "isParentTokenValid", "isParentPermissionValid", "permissionChange", "refreshParentCopyEscape", "refreshParentCopyPermission", "refreshAttachmentPermission", "updateOuterRawCopyable", "permissionVM", "Lcom/bytedance/ee/bear/drive/biz/permission/DriveThirdPartyPermissionVM;", "permissionOuterVM", "Lcom/bytedance/ee/bear/drive/biz/permission/DrivePermissionViewModel;", "getAttachmentRawCopy", "permission", "Lcom/bytedance/ee/bear/drive/biz/permission/model/ThirdPartyAttachmentPermission;", "(Lcom/bytedance/ee/bear/drive/biz/permission/model/ThirdPartyAttachmentPermission;)Ljava/lang/Boolean;", "resolveParentDocType", "entity", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/SpaceThirdPartyOpenEntity;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveThirdPartyPermissionPlugin extends AbsDrivePlugin implements vh5.a {
    private com.ss.android.lark.security.compliance.api.model.filepolicy.c dlpContext;
    private boolean isDlpMigrate;
    private String parentDocToken;
    private int parentDocType;
    private h permissionPush;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveThirdPartyPermissionVM a;
        public final /* synthetic */ DriveThirdPartyPermissionPlugin b;
        public final /* synthetic */ DrivePluginHost c;

        public a(DriveThirdPartyPermissionVM r1, DriveThirdPartyPermissionPlugin r2, DrivePluginHost r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
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
            DriveThirdPartyPermissionVM r5 = this.a;
            DriveViewModel r0 = this.c.c;
            if (r0 == null) goto L20;
            BaseOpenEntity r2 = r0.getOpenEntity();
            if (r2 == null) goto L20;
            String r6 = r2.getFileId();
        L21:
            r5.postOfflinePerm(r6);
            this.b.permissionChange();
            return;
        L20:
            r6 = null;
            goto L21
        L25:
            return;
        L10:
            if (this.a.livePerm().getValue() != null) goto L12;
            this.b.permissionChange();
            return;
        L7:
            r1 = false;
            goto L8
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePermissionViewModel a;

        public b(DrivePermissionViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            MutableLiveData<Boolean> r0 = this.a.getLiveCopyEscape();
            r0.postValue((Boolean) r2);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePermissionViewModel b;
        public final /* synthetic */ DriveThirdPartyPermissionVM c;
        public final /* synthetic */ DriveThirdPartyPermissionPlugin d;

        public c(DrivePluginHost r1, DrivePermissionViewModel r2, DriveThirdPartyPermissionVM r3, DriveThirdPartyPermissionPlugin r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onChanged(Object r8) {
            ThirdPartyAttachmentPermission r9 = (ThirdPartyAttachmentPermission) r8;
            MutableLiveData<Boolean> r0 = k75.a.i(this.a).liveOuterExportVisible();
            boolean r1 = false;
            if (r9 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            r0.postValue(Boolean.valueOf(r3));
            this.b.getLiveCopyEscape().postValue(this.c.liveCopyEscape().getValue());
            DriveThirdPartyPermissionPlugin r2 = this.d;
            DriveThirdPartyPermissionVM r4 = this.c;
            Intrinsics.checkNotNull(r4);
            DrivePermissionViewModel r5 = this.b;
            Intrinsics.checkNotNull(r5);
            DriveThirdPartyPermissionPlugin.access$updateOuterRawCopyable(r2, r4, r5);
            MutableLiveData<Boolean> r6 = this.b.getLiveOuterEditable();
            if (r9 != null) goto L11;
        L13:
            boolean r7 = false;
        L14:
            r6.postValue(Boolean.valueOf(r7));
            DriveViewModel r10 = this.a.c;
            if (r10 != null) goto L17;
        L21:
            if (r9 == null) goto L33;
            String r11 = r9.getPermV2Json();
            if (r11 != null) goto L25;
        L26:
            r1 = true;
        L27:
            if (r1 == true) goto L33;
            BaseOpenEntity r12 = this.a.c.getOpenEntity();
            if (r12 == null) goto L33;
            BinderPermissionCallback r13 = r12.getPermissionCallback();
            if (r13 == null) goto L33;
            r13.handlePermission(r9.getPermV2Json());
            goto L33
        L25:
            if (r11.length() != 0) goto L27;
        L33:
            DriveViewModel r14 = this.a.c;
            if (r14 != null) goto L36;
            return;
        L36:
            if (r14.getOpenEntity() == null) goto L43;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == true) goto L44;
            int r16 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).b(this.a.c.getOpenEntity().getFileId());
            k75.a.i(this.a).getLiveOuterDlpCode().postValue(Integer.valueOf(r16));
            return;
        L44:
            return;
        L43:
            return;
        L17:
            if (r10.getOpenEntity() == null) goto L21;
            if (DriveThirdPartyPermissionPlugin.access$isDlpMigrate$p(this.d) == true) goto L21;
            ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).c(this.a.c.getOpenEntity().getFileId(), 12);
            goto L21
        L11:
            if (r9.getEdit() != 1) goto L13;
            r7 = true;
            goto L14
        L5:
            if (r9.getExport() != 1) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveThirdPartyPermissionPlugin a;
        public final /* synthetic */ DriveThirdPartyPermissionVM b;
        public final /* synthetic */ DrivePermissionViewModel c;

        public d(DriveThirdPartyPermissionPlugin r1, DriveThirdPartyPermissionVM r2, DrivePermissionViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            DriveThirdPartyPermissionPlugin r5 = this.a;
            DriveThirdPartyPermissionVM r0 = this.b;
            Intrinsics.checkNotNull(r0);
            DrivePermissionViewModel r1 = this.c;
            Intrinsics.checkNotNull(r1);
            DriveThirdPartyPermissionPlugin.access$updateOuterRawCopyable(r5, r0, r1);
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean isParentTokenValid() {
        String r0 = this.parentDocToken;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L7;
        return true;
    }

    private final void refreshAttachmentPermission() {
        if (j.a.a.getNetworkState().a() == true) goto L5;
        return;
    L5:
        BaseOpenEntity r0 = getHost().c.getOpenEntity();
        if ((r0 instanceof SpaceThirdPartyOpenEntity) == true) goto L8;
        return;
    L8:
        SpaceThirdPartyOpenEntity r1 = (SpaceThirdPartyOpenEntity) r0;
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).fetchPermission(r1.getFileId(), r1.getApiExtra(), r1.getMountPoint());
    }

    private final void refreshParentCopyEscape() {
        jg5.j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r1 = this.parentDocToken;
        r0.getClass();
        Boolean r2 = (Boolean) ((HashMap) jg5.j.g).get(r1);
        if (r2 != null) goto L5;
        boolean r3 = false;
    L6:
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).liveCopyEscape().postValue(Boolean.valueOf(r3));
        return;
    L5:
        r3 = r2.booleanValue();
        goto L6
    }

    public DriveThirdPartyPermissionPlugin() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        this.isDlpMigrate = jg5.e.a.a.g();
        this.parentDocType = -1;
    }

    private final boolean isParentPermissionValid() {
        if (isParentTokenValid() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.parentDocType <= 0) goto L7;
        return true;
    }

    private final void refreshParentCopyPermission() {
        if (isParentPermissionValid() == true) goto L5;
        return;
    L5:
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).fetchParentCopyPermission(this.parentDocToken, this.parentDocType);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        h r0 = this.permissionPush;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.permissionPush = null;
        if (isParentTokenValid() == false) goto L8;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().p(this.parentDocToken, this);
    L8:
        this.parentDocToken = null;
        this.parentDocType = -1;
        DriveThirdPartyPermissionVM r9 = (DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class);
        r9.resetParentCopyPermission();
        BaseOpenEntity r1 = getHost().c.getOpenEntity();
        if ((r1 instanceof SpaceThirdPartyOpenEntity) == false) goto L37;
        SpaceThirdPartyOpenEntity r2 = (SpaceThirdPartyOpenEntity) r1;
        this.parentDocToken = r2.getDocToken();
        this.parentDocType = resolveParentDocType(r2);
        String r4 = r2.getFileId();
        String r5 = r2.getApiExtra();
        String r6 = r2.getMountPoint();
        String r7 = r2.getDocToken();
        int r8 = this.parentDocType;
        Intrinsics.checkNotNull(r9);
        h r10 = new h(r4, r5, r6, r7, r8, r9);
        this.permissionPush = r10;
        r10.k = false;
        if (TextUtils.isEmpty(r10.a) == true) goto L15;
        v55.e r3 = new v55.e(r10);
        r10.g = r3;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).i4(r10.a, sbb.e.l.b, r3);
    L15:
        if (TextUtils.isEmpty(r10.a) == true) goto L18;
        v55.d r11 = new v55.d(r10);
        r10.h = r11;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).u4(r10.a, sbb.e.l.b, r11);
    L18:
        String r12 = r10.d;
        if (TextUtils.isEmpty(r12) == false) goto L21;
    L23:
        r12 = null;
    L24:
        if (r12 == null) goto L27;
        g r13 = new g(r10);
        r10.i = r13;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).i4(r12, r10.e, r13);
    L27:
        String r14 = r10.d;
        if (TextUtils.isEmpty(r14) == false) goto L30;
    L32:
        r14 = null;
    L33:
        if (r14 == null) goto L37;
        v55.f r16 = new v55.f(r10);
        r10.j = r16;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).u4(r14, r10.e, r16);
        goto L37
    L30:
        if (r10.e <= 0) goto L32;
    L21:
        if (r10.e <= 0) goto L23;
    L37:
        if (isParentTokenValid() == false) goto L46;
        jg5.j r17 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r18 = this.parentDocToken;
        r17.getClass();
        HashMap r19 = (HashMap) jg5.j.h;
        ArrayList r20 = (ArrayList) r19.get(r18);
        if (r20 != null) goto L42;
        r20 = new ArrayList();
        r19.put(r18, r20);
    L42:
        if (r20.contains(this) == true) goto L44;
        r20.add(this);
    L44:
        refreshParentCopyEscape();
        refreshParentCopyPermission();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        if (isParentTokenValid() == false) goto L5;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().p(this.parentDocToken, this);
    L5:
        this.parentDocToken = null;
        this.parentDocType = -1;
        h r0 = this.permissionPush;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        this.permissionPush = null;
    }

    public void permissionChange() {
        if (isParentTokenValid() == false) goto L5;
        refreshParentCopyEscape();
        refreshParentCopyPermission();
    L5:
        refreshAttachmentPermission();
    }

    public static final /* synthetic */ boolean access$isDlpMigrate$p(DriveThirdPartyPermissionPlugin r0) {
        return r0.isDlpMigrate;
    }

    private final Boolean getAttachmentRawCopy(ThirdPartyAttachmentPermission r5) {
        if (r5 == null) goto L17;
        boolean r2 = true;
        if (r5.getPermV2() == null) goto L12;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.e() == false) goto L12;
        if (r5.getPermV2().getCopy() == 1) goto L16;
    L14:
        r2 = false;
    L16:
        return Boolean.valueOf(r2);
    L12:
        if (r5.getCopy() != 1) goto L14;
    L17:
        return null;
    }

    private final int resolveParentDocType(SpaceThirdPartyOpenEntity r2) {
        if (r2.getHostType() <= 0) goto L7;
        return r2.getHostType();
    L7:
        if (TextUtils.isEmpty(r2.getDocToken()) == false) goto L9;
    L11:
        return -1;
    L9:
        if (Intrinsics.areEqual(r2.getMountPoint(), "docx_file") == false) goto L11;
        return 22;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r10) {
        Intrinsics.checkNotNullParameter(r10, "host");
        super.onAttachToHost(r10);
        final DriveThirdPartyPermissionVM r0 = (DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class);
        DrivePermissionViewModel r1 = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        if (this.isDlpMigrate == true) goto L5;
    L9:
        k75.a.h(this, new a(r0, this, r10));
        r0.liveCopyEscape().observe(getLifecycleOwner(), new b(r1));
        r0.livePerm().observe(getLifecycleOwner(), new c(r10, r1, r0, this));
        r0.liveParentCopyable().observe(getLifecycleOwner(), new d(this, r0, r1));
        return;
    L5:
        if (r10.c == null) goto L9;
        String r2 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).c(12);
        this.dlpContext = new com.ss.android.lark.security.compliance.api.model.filepolicy.c(r10.c.getFileId(), r2, 12, new AnonymousClass1(r0, this));
        BizDomain r3 = pw4.b.a(r10.c.getOpenEntity().getMountPoint());
        FileBizDomain r4 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).a(r3);
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r5 = this.dlpContext;
        if (r5 == null) goto L9;
        r5.a(r4, null, null);
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onDetachFromHost(r3);
        if (this.isDlpMigrate == false) goto L8;
        com.ss.android.lark.security.compliance.api.model.filepolicy.c r4 = this.dlpContext;
        if (r4 == null) goto L8;
        r4.c();
    L8:
        if (isParentTokenValid() == false) goto L10;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().p(this.parentDocToken, this);
    L10:
        h r5 = this.permissionPush;
        if (r5 == null) goto L13;
        r5.a();
    L13:
        this.permissionPush = null;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveThirdPartyPermissionPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void updateOuterRawCopyable(DriveThirdPartyPermissionVM r3, DrivePermissionViewModel r4) {
        Boolean r0 = getAttachmentRawCopy((ThirdPartyAttachmentPermission) r3.livePerm().getValue());
        Boolean r5 = (Boolean) r3.liveParentCopyable().getValue();
        if (isParentPermissionValid() == false) goto L15;
        if (r0 != null) goto L6;
        r0 = null;
        goto L15
    L6:
        if (r5 != null) goto L9;
        r0 = Boolean.FALSE;
        goto L15
    L9:
        if (r0.booleanValue() == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        r0 = Boolean.valueOf(r6);
        goto L15
    L11:
        if (r5.booleanValue() == false) goto L13;
        r6 = true;
    L15:
        r4.getLiveOuterRawCopyable().postValue(r0);
    }

    public static final /* synthetic */ void access$updateOuterRawCopyable(DriveThirdPartyPermissionPlugin r0, DriveThirdPartyPermissionVM r1, DrivePermissionViewModel r2) {
        r0.updateOuterRawCopyable(r1, r2);
    }
}
