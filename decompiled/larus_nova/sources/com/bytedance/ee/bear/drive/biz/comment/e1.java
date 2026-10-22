package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$Request;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class e1 implements com.bytedance.ee.bear.middleground_permission_export.model.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f222768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentMentionAuthorize$Request f222769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f1 f222770c;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void a(InviteResult r100) {
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteCollaborators - onFinished, requestUserIds: " + this.f222768a + ", inviteResult: " + r100);
        com.bytedance.ee.bear.middleground.comment.export.h r101 = this.f222770c.f222772a.f222674c;
        if (r101 == null) goto L5;
        r101.j(this.f222768a);
    L5:
        j.c(this.f222770c.f222772a.f222673b, this.f222768a, r100, this.f222769b.getCallbackId());
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void onError(Throwable r100) {
        InviteResult r101 = j.d(r100);
        if (r101 == null) goto L9;
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteResultData - onError, but it's a failure data, failureResult: " + r101);
        com.bytedance.ee.bear.middleground.comment.export.h r102 = this.f222770c.f222772a.f222674c;
        if (r102 == null) goto L7;
        r102.j(this.f222768a);
    L7:
        j.c(this.f222770c.f222772a.f222673b, this.f222768a, r101, this.f222769b.getCallbackId());
        return;
    L9:
        tt5.a.e("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver - inviteResultData - onError, error: ", r100, false);
        m.a(this.f222769b.getCallbackId(), -1, "Error", null, null);
    }

    public e1(f1 r100, List r101, CommentMentionAuthorize$Request r102) {
        this.f222770c = r100;
        this.f222768a = r101;
        this.f222769b = r102;
    }
}
