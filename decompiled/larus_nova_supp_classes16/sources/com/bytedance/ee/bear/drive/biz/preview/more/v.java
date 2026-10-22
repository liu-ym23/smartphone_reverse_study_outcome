package com.bytedance.ee.bear.drive.biz.preview.more;

import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.ss.android.lark.permission.StoragePermissionUtils;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements com.ss.android.lark.utils.h.c {
    public final /* synthetic */ CompositeDisposable a;
    public final /* synthetic */ BaseMoreMenuAction b;
    public final /* synthetic */ a c;

    public v(CompositeDisposable r1, BaseMoreMenuAction r2, a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void b(StoragePermissionUtils.c r3) {
        Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
        tt5.a.h("DriveComponent", "DriveSdkTitleBarPlugin#checkRequestedPermissions : isGrant=" + r3.d);
        if (r3.d == false) goto L5;
        int r4 = w.a;
        w.a.b(this.a, this.b, this.c);
        return;
    L5:
        tt5.a.k("DriveComponent", "executeDownloadMenuWithPermissionCheck() isGrant=false");
    }
}
