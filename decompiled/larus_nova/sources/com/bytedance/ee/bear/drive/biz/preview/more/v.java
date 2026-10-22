package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.ss.android.lark.permission.StoragePermissionUtils;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements com.ss.android.lark.utils.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f223653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseMoreMenuAction f223654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f223655c;

    public v(CompositeDisposable r100, BaseMoreMenuAction r101, a r102) {
        this.f223653a = r100;
        this.f223654b = r101;
        this.f223655c = r102;
    }

    @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
    public final void b(StoragePermissionUtils.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        tt5.a.h("DriveComponent", "DriveSdkTitleBarPlugin#checkRequestedPermissions : isGrant=" + r100.f438547d);
        if (r100.f438547d == false) goto L5;
        int r101 = w.f223656a;
        w.a.b(this.f223653a, this.f223654b, this.f223655c);
        return;
    L5:
        tt5.a.k("DriveComponent", "executeDownloadMenuWithPermissionCheck() isGrant=false");
    }
}
