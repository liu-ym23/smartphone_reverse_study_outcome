package com.bytedance.ee.bear.drive.biz.comment;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$Response;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$ResponseData;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class m {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$ResponseData] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$Response, java.lang.Object] */
    public static void a(String r100, int r101, String r102, List<String> r103, List<String> r104) {
        ?? r105 = new CommentMentionAuthorize$ResponseData();
        if (r103 != null) goto L5;
        int r106 = 0;
    L6:
        r105.setSuccess_count(r106);
        if (r104 == null) goto L9;
        r105.setFail_count(r104.size());
        r105.setFail_owners(r104);
    L9:
        ?? r107 = new CommentMentionAuthorize$Response();
        r107.setCode(r101);
        r107.setMsg(r102);
        r107.setData(r105);
        Message r108 = new Message();
        if (r100 != null) goto L12;
        r100 = "";
    L12:
        r108.f227151b = r100;
        String r109 = JSON.toJSONString(r107);     // Catch: Exception -> L15
    L16:
        r108.f227152c = r109;
        tt5.a.h("DriveCommentRnHelper", "setupAuthorizeListener - AuthorizeObserver - callbackResponse, response: " + r107 + ", responseMessage: " + r108);
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).l(r108);
        return;
    L15:
        r109 = null;
        goto L16
    L5:
        r106 = r103.size();
        goto L6
    }
}
