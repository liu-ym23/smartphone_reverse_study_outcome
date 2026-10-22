package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements h75.b {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public i(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // h75.b
    public final void onError(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        this.a.C1("getDriveImagePreviewUrl error: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "getDriveImagePreviewUrl error", r4);
    }

    @Override // h75.b
    public final void onSuccess(FileInfoV1Puller.Result r3) {
        Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
        String r4 = r3.dataVersion;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.a.C1("getDriveImagePreviewUrl success: dataVersion=".concat(r4));
    }
}
