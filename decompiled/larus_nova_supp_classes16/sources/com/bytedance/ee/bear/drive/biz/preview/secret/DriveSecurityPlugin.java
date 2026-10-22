package com.bytedance.ee.bear.drive.biz.preview.secret;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/secret/DriveSecurityPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "driveViewModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "permissionViewModel", "Lcom/bytedance/ee/bear/drive/biz/permission/DrivePermissionViewModel;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "updateCopyPermission", "checkSinglePasteEncrypt", "onStart", "getEncryptId", "", "checkEncryptEnable", "", "isSinglePasteCanCopy", "updateEncryptId", "encryptId", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSecurityPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveSecurityPlugin";
    private DriveViewModel driveViewModel;
    private DrivePermissionViewModel permissionViewModel;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveSecurityPlugin a;

        public b(DriveSecurityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSecurityPlugin.access$updateCopyPermission(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveSecurityPlugin a;

        public c(DriveSecurityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSecurityPlugin.access$updateCopyPermission(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveSecurityPlugin a;

        public d(DriveSecurityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveSecurityPlugin.access$updateCopyPermission(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean checkEncryptEnable() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.common.copy_security_enable") == true) goto L7;
        tt5.a.h(TAG, "checkEncryptEnable fg == false");
        return false;
    L7:
        if (AppInfoUtils.f().booleanValue() == false) goto L10;
        tt5.a.h(TAG, "checkEncryptEnable blocked by OfficeSDK host");
        return false;
    L10:
        DrivePermissionViewModel r0 = this.permissionViewModel;
        DrivePermissionViewModel r3 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r0 = null;
    L13:
        Object r1 = r0.getLiveOuterEditable().getValue();
        Boolean r5 = Boolean.TRUE;
        boolean r2 = Intrinsics.areEqual(r1, r5);
        DrivePermissionViewModel r6 = this.permissionViewModel;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r6 = null;
    L16:
        boolean r7 = Intrinsics.areEqual(r6.getLiveOuterRawCopyable().getValue(), r5);
        DrivePermissionViewModel r8 = this.permissionViewModel;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
    L20:
        boolean r4 = Intrinsics.areEqual(r3.getLiveCopyEscape().getValue(), r5);
        tt5.a.h(TAG, "checkEncryptEnable canEdit = " + r2 + " canRawCopy = " + r7 + " canCopyEscape = " + r4);
        if (r2 == false) goto L26;
        if (r7 == true) goto L27;
        if (r4 == true) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L19:
        r3 = r8;
        goto L20
    }

    private final void checkSinglePasteEncrypt() {
        DriveViewModel r0 = this.driveViewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
        r0 = null;
    L5:
        boolean r1 = r0.fromBlockPreview();
        boolean r2 = isSinglePasteCanCopy();
        tt5.a.h(TAG, "handleUpdateEncryptId, isBlockPreview: " + r1 + ", isSinglePasteCanCopy: " + r2);
        if (r2 == true) goto L8;
        return;
    L8:
        if (r1 == true) goto L11;
        updateEncryptId();
        return;
    }

    private final void updateCopyPermission() {
        DrivePermissionViewModel r0 = this.permissionViewModel;
        DrivePermissionViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r0 = null;
    L5:
        Object r1 = r0.getLiveCopyEscape().getValue();
        Boolean r3 = Boolean.TRUE;
        boolean r4 = Intrinsics.areEqual(r1, r3);
        DrivePermissionViewModel r5 = this.permissionViewModel;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r5 = null;
    L8:
        boolean r6 = Intrinsics.areEqual(r5.getLiveOuterRawCopyable().getValue(), r3);
        DrivePermissionViewModel r7 = this.permissionViewModel;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r7 = null;
    L11:
        boolean r8 = Intrinsics.areEqual(r7.getLiveOuterEditable().getValue(), r3);
        DriveViewModel r9 = this.driveViewModel;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
        r9 = null;
    L15:
        if (r9.fromBlockPreview() == true) goto L18;
        updateEncryptId();
    L18:
        if (r4 == false) goto L20;
        PointValue r10 = new PointValue(true, 210001);
    L31:
        tt5.a.h(TAG, "updateCopyPermission: canCopyEscape=" + r4 + ", canRawCopy=" + r6 + ", canEdit=" + r8 + "，finalCopyPermission=" + r10.getAllow());
        DrivePermissionViewModel r11 = this.permissionViewModel;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
    L35:
        r2.getLiveOuterCopyable().setValue(r10);
        return;
    L34:
        r2 = r11;
        goto L35
    L20:
        if (r6 == false) goto L23;
        r10 = new PointValue(true, 1);
        goto L31
    L23:
        if (r6 == true) goto L29;
        if (r8 == false) goto L29;
        if (AppInfoUtils.f().booleanValue() == false) goto L28;
        tt5.a.h(TAG, "Single document protection blocked by OfficeSDK host");
        PointValue r12 = new PointValue(false, 0);
    L30:
        r10 = r12;
        goto L31
    L28:
        tt5.a.h(TAG, "Single document protection activated");
        checkSinglePasteEncrypt();
        r10 = new PointValue(true, 1);
    L29:
        r12 = new PointValue(false, 0);
        goto L30
    }

    private final String getEncryptId() {
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        tt5.a.h(TAG, "getEncryptId blocked by OfficeSDK host");
        return "";
    L6:
        DriveViewModel r0 = this.driveViewModel;
        DriveViewModel r3 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
        r0 = null;
    L9:
        BaseOpenEntity r1 = r0.getOpenEntity();
        if (r1 == null) goto L13;
        String r2 = r1.getEncryptId();
        if (r2 == null) goto L13;
    L15:
        if (r2.length() <= 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L22;
        tt5.a.h(TAG, "getEncryptId use parent EncryptId");
        return r2;
    L22:
        if (checkEncryptEnable() == false) goto L29;
        tt5.a.h(TAG, "getEncryptId use child EncryptId");
        DriveViewModel r4 = this.driveViewModel;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
    L28:
        return r3.getFileId();
    L26:
        r3 = r4;
        goto L28
    L29:
        return "";
    L17:
        r5 = false;
    L13:
        r2 = "";
        goto L15
    }

    private final boolean isSinglePasteCanCopy() {
        if (getEncryptId().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        DrivePermissionViewModel r1 = this.permissionViewModel;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r1 = null;
    L10:
        PointValue r2 = (PointValue) r1.getLiveOuterCopyable().getValue();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L18;
        return true;
    L13:
        if (r2.getAllow() == true) goto L15;
        r3 = true;
    L18:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private final void updateEncryptId() {
        String r0 = getEncryptId();
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L6;
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).a(r0);
        return;
    L6:
        MutableLiveData<EncryptData> r1 = k75.a.i(getHost()).liveOuterEncryptId();
        EncryptData r4 = new EncryptData();
        r4.setEncryptId(r0);
        DriveViewModel r5 = this.driveViewModel;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
        r5 = null;
    L9:
        BaseOpenEntity r6 = r5.getOpenEntity();
        boolean r7 = false;
        if (r6 == null) goto L12;
        boolean r8 = r6.isInBlock();
    L13:
        r4.setBlock(r8);
        r1.setValue(r4);
        DriveViewModel r2 = this.driveViewModel;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("driveViewModel");
        r2 = null;
    L16:
        BaseOpenEntity r3 = r2.getOpenEntity();
        if (r3 != null) goto L19;
    L21:
        if (r7 == false) goto L24;
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).a(r0);
        return;
    L24:
        return;
    L19:
        if (r3.isInBlock() == true) goto L21;
        r7 = true;
        goto L21
    L12:
        r8 = false;
        goto L13
    }

    public DriveSecurityPlugin() {
    }

    public static final /* synthetic */ void access$updateCopyPermission(DriveSecurityPlugin r0) {
        r0.updateCopyPermission();
    }

    private final void updateEncryptId(String r4) {
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).a(r4);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r6) {
        Intrinsics.checkNotNullParameter(r6, "host");
        super.onAttachToHost(r6);
        this.driveViewModel = r6.c;
        DrivePermissionViewModel r0 = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        this.permissionViewModel = r0;
        DrivePermissionViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r0 = null;
    L5:
        r0.getLiveCopyEscape().observe(r6.getLifecycleOwner(), new b(this));
        DrivePermissionViewModel r2 = this.permissionViewModel;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
        r2 = null;
    L8:
        r2.getLiveOuterRawCopyable().observe(r6.getLifecycleOwner(), new c(this));
        DrivePermissionViewModel r3 = this.permissionViewModel;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("permissionViewModel");
    L12:
        r1.getLiveOuterEditable().observe(r6.getLifecycleOwner(), new d(this));
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public void onStart(DrivePluginHost r1) {
        super.onStart(r1);
        updateEncryptId();
        checkSinglePasteEncrypt();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((DrivePluginHost) r1);
    }
}
