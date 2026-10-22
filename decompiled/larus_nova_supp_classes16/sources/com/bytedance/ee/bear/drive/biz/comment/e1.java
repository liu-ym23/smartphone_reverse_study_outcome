package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e1 implements com.bytedance.ee.bear.middleground_permission_export.model.e {
    public final /* synthetic */ List a;
    public final /* synthetic */ CommentMentionAuthorize.Request b;
    public final /* synthetic */ f1 c;

    public final void a(InviteResult r4) {
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteCollaborators - onFinished, requestUserIds: " + this.a + ", inviteResult: " + r4);
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.c.a.c;
        if (r0 == null) goto L5;
        r0.j(this.a);
    L5:
        j.c(this.c.a.b, this.a, r4, this.b.getCallbackId());
    }

    public final void onError(Throwable r4) {
        InviteResult r0 = j.d(r4);
        if (r0 == null) goto L9;
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteResultData - onError, but it's a failure data, failureResult: " + r0);
        com.bytedance.ee.bear.middleground.comment.export.h r5 = this.c.a.c;
        if (r5 == null) goto L7;
        r5.j(this.a);
    L7:
        j.c(this.c.a.b, this.a, r0, this.b.getCallbackId());
        return;
    L9:
        tt5.a.e("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteResultData - onError, error: ", r4, false);
        m.a(this.b.getCallbackId(), -1, "Error", null, null);
    }

    public e1(f1 r1, List r2, CommentMentionAuthorize.Request r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
