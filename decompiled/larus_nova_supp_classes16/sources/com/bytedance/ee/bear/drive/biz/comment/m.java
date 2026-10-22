package com.bytedance.ee.bear.drive.biz.comment;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public static void a(String r1, int r2, String r3, List<String> r4, List<String> r5) {
        CommentMentionAuthorize.ResponseData r0 = new CommentMentionAuthorize.ResponseData();
        if (r4 != null) goto L5;
        int r6 = 0;
    L6:
        r0.setSuccess_count(r6);
        if (r5 == null) goto L9;
        r0.setFail_count(r5.size());
        r0.setFail_owners(r5);
    L9:
        CommentMentionAuthorize.Response r7 = new CommentMentionAuthorize.Response();
        r7.setCode(r2);
        r7.setMsg(r3);
        r7.setData(r0);
        Message r8 = new Message();
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        r8.b = r1;
        String r9 = JSON.toJSONString(r7);     // Catch: Exception -> L15
    L16:
        r8.c = r9;
        tt5.a.h("DriveCommentRnHelper", "setupAuthorizeListener - AuthorizeObserver - callbackResponse, response: " + r7 + ", responseMessage: " + r8);
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).l(r8);
        return;
    L15:
        r9 = null;
        goto L16
    L5:
        r6 = r4.size();
        goto L6
    }
}
