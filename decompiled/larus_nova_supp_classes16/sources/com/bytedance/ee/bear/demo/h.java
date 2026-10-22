package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements h75.b {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public h(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // h75.b
    public final void onError(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        this.a.C1("DriveFileInfoLoader error: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "DriveFileInfoLoader error", r4);
    }

    @Override // h75.b
    public final void onSuccess(FileInfoV1Puller.Result r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        StringBuilder r0 = new StringBuilder("DriveFileInfoLoader success\n");
        r0.append("name=" + r5.name + " size=" + r5.size + " type=" + r5.type + '\n');
        StringBuilder r1 = new StringBuilder("version=");
        r1.append(r5.version);
        r1.append(" dataVersion=");
        r1.append(r5.dataVersion);
        r1.append('\n');
        r0.append(r1.toString());
        r0.append("mimeType=" + r5.mimeType + " previewStatus=" + r5.previewStatus + '\n');
        this.a.C1(r0.toString());
    }
}
