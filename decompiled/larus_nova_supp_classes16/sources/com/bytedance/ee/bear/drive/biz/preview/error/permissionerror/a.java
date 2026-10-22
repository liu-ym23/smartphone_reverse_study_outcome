package com.bytedance.ee.bear.drive.biz.preview.error.permissionerror;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ DriveSpaceFilePermissionErrorPlugin a;
    public final /* synthetic */ DrivePluginHost b;

    public a(DriveSpaceFilePermissionErrorPlugin r1, DrivePluginHost r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (DriveSpaceFilePermissionErrorPlugin.access$isUIContainerDetached(this.a) == true) goto L10;
        DriveMGPermissionVM.fetchPermission$default((DriveMGPermissionVM) DriveSpaceFilePermissionErrorPlugin.access$viewModel(this.a, DriveMGPermissionVM.class), k75.a.d(this.a), null, 2, null);     // Catch: Throwable -> L7
        this.b.c().load();     // Catch: Throwable -> L7
        return;
    }
}
