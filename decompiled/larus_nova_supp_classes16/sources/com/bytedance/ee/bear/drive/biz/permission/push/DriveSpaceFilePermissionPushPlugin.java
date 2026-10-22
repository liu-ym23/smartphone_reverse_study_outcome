package com.bytedance.ee.bear.drive.biz.permission.push;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.space.sync.b;
import k75.a;
import kotlin.Metadata;
import sbb.e;
import v55.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/push/DriveSpaceFilePermissionPushPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mPermissionPush", "Lcom/bytedance/ee/bear/drive/biz/permission/push/DriveSpaceFilePermissionPush;", "onAttachPreview", "", "onDetachPreview", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFilePermissionPushPlugin extends AbsDrivePlugin {
    private c mPermissionPush;

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        c r0 = new c(a.d(this), (DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class));
        this.mPermissionPush = r0;
        String r1 = r0.a;
        v55.a r2 = new v55.a(r0);
        r0.c = r2;
        b r3 = (b) org.koin.java.a.c(b.class, null, null, 6);
        e r6 = e.l;
        r3.i4(r1, r6.b, r2);
        String r4 = r0.a;
        v55.b r5 = r0.d;
        if (r5 == null) goto L5;
        ((b) org.koin.java.a.c(b.class, null, null, 6)).n8(r5);
        r0.d = null;
    L5:
        v55.b r7 = new v55.b(r0);
        r0.d = r7;
        ((b) org.koin.java.a.c(b.class, null, null, 6)).u4(r4, r6.b, r7);
        r0.e = false;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        c r0 = this.mPermissionPush;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public DriveSpaceFilePermissionPushPlugin() {
    }
}
