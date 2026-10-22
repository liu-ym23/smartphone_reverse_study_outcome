package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.drive.biz.feed.DriveFeedVM;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements Runnable {
    public final /* synthetic */ DriveCommentPlugin a;
    public final /* synthetic */ CommentRectF b;

    public k(DriveCommentPlugin r1, CommentRectF r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);     // Catch: Throwable -> L13
        if (r0 != null) goto L5;
        DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.a);     // Catch: Throwable -> L13
    L18:
        return;
    L5:
        r0.A(this.b, true, r0.e());     // Catch: Throwable -> L13
        if (DriveCommentPlugin.access$isPdfMarkCommentEnabled(this.a) == false) goto L18;
        DriveFeedVM r1 = (DriveFeedVM) DriveCommentPlugin.access$viewModel(this.a, DriveFeedVM.class);     // Catch: Throwable -> L13
        if (r1 == null) goto L18;
        com.bytedance.ee.bear.drive.biz.feed.c r2 = r1.getDriveFeedManager();     // Catch: Throwable -> L13
        if (r2 == null) goto L18;
        r2.f();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
