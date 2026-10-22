package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveVideoPreviewResponse;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveVideoPreviewException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements h75.d {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public t(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // h75.d
    public final void a(DriveVideoPreviewResponse r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        StringBuilder r0 = new StringBuilder("transcode success\n");
        r0.append("urls=" + r5.getTranscodeUrls() + '\n');
        r0.append("originUrl=" + r5.getOriginUrl() + '\n');
        r0.append("statusCode=" + r5.getStatusCode() + '\n');
        CCMFolderDemoActivity r6 = this.a;
        r0.append(DocViewModel.ENTER_CHAR);
        r6.C1(r0.toString());
    }

    @Override // h75.d
    public final void b(DriveVideoPreviewException r4, DriveVideoPreviewResponse r5) {
        Intrinsics.checkNotNullParameter(r4, "e");
        Intrinsics.checkNotNullParameter(r5, "info");
        StringBuilder r0 = new StringBuilder();
        r0.append("transcode error: " + r4.getLocalizedMessage() + '\n');
        r0.append("originUrl=" + r5.getOriginUrl() + '\n');
        r0.append("statusCode=" + r5.getStatusCode() + '\n');
        CCMFolderDemoActivity r6 = this.a;
        r0.append(DocViewModel.ENTER_CHAR);
        r6.C1(r0.toString());
    }
}
