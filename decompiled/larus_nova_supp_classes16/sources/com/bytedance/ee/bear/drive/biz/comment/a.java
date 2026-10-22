package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Comparator<CommentBean> {
    public final Map<String, CommentRectF> a;

    public a(Map<String, CommentRectF> r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(CommentBean r9, CommentBean r10) {
        CommentBean r11 = r9;
        CommentBean r12 = r10;
        Map<String, CommentRectF> r0 = this.a;
        CommentRectF r1 = null;
        if (r0 != null) goto L5;
        CommentRectF r2 = null;
    L6:
        Map<String, CommentRectF> r3 = this.a;
        if (r3 == null) goto L11;
        r1 = r3.get(r12.getComment_id());
    L11:
        return f.a(r2, f.b(r11), r1, f.b(r12));
    L5:
        r2 = r0.get(r11.getComment_id());
        goto L6
    }
}
