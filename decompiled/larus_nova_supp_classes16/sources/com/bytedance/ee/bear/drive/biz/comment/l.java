package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements Runnable {
    public final /* synthetic */ DriveCommentPlugin a;
    public final /* synthetic */ CommentRectF b;

    public l(DriveCommentPlugin r1, CommentRectF r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a1 r0 = DriveCommentPlugin.access$getMCommentWrapper$p(this.a);     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        DriveCommentPlugin.access$releaseCommentPanelAiBottomSuppression(this.a);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        r0.A(this.b, false, r0.e());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }
}
