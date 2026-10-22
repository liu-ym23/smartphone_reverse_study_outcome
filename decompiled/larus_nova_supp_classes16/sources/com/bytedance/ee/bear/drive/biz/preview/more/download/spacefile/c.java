package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.preview.more.DriveSpaceThirdPartyAttachmentMoreMenuPlugin;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements SpaceFileDownloadManager.b {
    public final AtomicBoolean a;
    public final /* synthetic */ SpaceFileDownloadManager.b b;

    public c(DriveSpaceThirdPartyAttachmentMoreMenuPlugin.b.a r2) {
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager.b
    public final void a(SpaceFileDownloadManager.EResult r4) {
        Intrinsics.checkNotNullParameter(r4, TipCallBackData.RESULT);
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.b.a(r4);
        return;
    }
}
