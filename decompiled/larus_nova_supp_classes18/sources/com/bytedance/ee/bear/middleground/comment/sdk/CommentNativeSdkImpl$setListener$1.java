package com.bytedance.ee.bear.middleground.comment.sdk;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.middleground.comment.export.n;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", WikiFolderPushPlugin.DATA, "", "action", "Lcom/bytedance/ee/bear/middleground/comment/export/Action;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CommentNativeSdkImpl$setListener$1 extends Lambda implements Function2<String, Action, Unit> {
    final /* synthetic */ a this$0;

    public CommentNativeSdkImpl$setListener$1(a r1) {
        super(2);
    }

    public final void invoke(String r8, Action r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        r8.getClass();
        ((n) org.koin.java.a.c(n.class, null, null, 6)).a().getClass();
        int r1 = com.bytedance.ee.bear.middleground.comment.uitls.n.a;
        Intrinsics.checkNotNullParameter(r8, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r9, "action");
        DataEntity r10 = (DataEntity) JSON.parseObject(r8, DataEntity.class);     // Catch: Throwable -> L30
        r10.getData().getBody().getCode();     // Catch: Throwable -> L30
        r10.getData().getBody().getMsg();     // Catch: Throwable -> L30
        if (r10.getData().getBody().getCode() == 0) goto L6;
        throw null;
    L6:
        if (r9 != Action.CHANGE) goto L15;
        DataEntity.Entity.BodyEntity.ResultEntity r11 = (DataEntity.Entity.BodyEntity.ResultEntity) JSON.parseObject(r10.getData().getBody().getData(), DataEntity.Entity.BodyEntity.ResultEntity.class);     // Catch: Throwable -> L30
        r11.getDiffComments();     // Catch: Throwable -> L30
        List<CommentBean> r12 = r11.getAllComments().getComments();     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L30
        Iterator<T> r2 = r12.iterator();     // Catch: Throwable -> L30
    L9:
        if (r2.hasNext() == false) goto L28;
        CommentBean r3 = (CommentBean) r2.next();     // Catch: Throwable -> L30
        Iterator<T> r4 = r3.getComment_list().iterator();     // Catch: Throwable -> L30
    L12:
        if (r4.hasNext() == false) goto L9;
        ((CommentBean.CommentDetail) r4.next()).setComment_id(r3.getComment_id());     // Catch: Throwable -> L30
    L28:
        com.bytedance.ee.bear.middleground.comment.uitls.n.e(r12);     // Catch: Throwable -> L30
        throw null;
    L15:
        if (r9 != Action.FETCH) goto L23;
        r12 = ((DataEntity.Entity.BodyEntity.ResultEntity.Comments) JSON.parseObject(r10.getData().getBody().getData(), DataEntity.Entity.BodyEntity.ResultEntity.Comments.class)).getComments();     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L30
        Iterator<T> r5 = r12.iterator();     // Catch: Throwable -> L30
    L18:
        if (r5.hasNext() == false) goto L28;
        CommentBean r6 = (CommentBean) r5.next();     // Catch: Throwable -> L30
        Iterator<T> r7 = r6.getComment_list().iterator();     // Catch: Throwable -> L30
    L21:
        if (r7.hasNext() == false) goto L18;
        ((CommentBean.CommentDetail) r7.next()).setComment_id(r6.getComment_id());     // Catch: Throwable -> L30
        goto L21
    L23:
        CommentBean[] r13 = new CommentBean[1];     // Catch: Throwable -> L30
        CommentBean r14 = ((DataEntity.Entity.BodyEntity.ResultEntity) JSON.parseObject(r10.getData().getBody().getData(), DataEntity.Entity.BodyEntity.ResultEntity.class)).getComment();     // Catch: Throwable -> L30
        Iterator<T> r15 = r14.getComment_list().iterator();     // Catch: Throwable -> L30
    L25:
        if (r15.hasNext() == false) goto L27;
        ((CommentBean.CommentDetail) r15.next()).setComment_id(r14.getComment_id());     // Catch: Throwable -> L30
        goto L25
    L27:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r13[0] = r14;     // Catch: Throwable -> L30
        r12 = CollectionsKt.mutableListOf(r13);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        tt5.a.e("CommentTo", "dataToRemoteCommentData: action = " + r9 + ", err = ", th, false);
        th.getMessage();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (Action) r2);
        return Unit.INSTANCE;
    }
}
