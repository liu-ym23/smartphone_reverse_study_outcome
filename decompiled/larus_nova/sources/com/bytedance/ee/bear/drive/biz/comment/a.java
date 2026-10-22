package com.bytedance.ee.bear.drive.biz.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Comparator<CommentBean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, CommentRectF> f222668a;

    public a(Map<String, CommentRectF> r100) {
        this.f222668a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(CommentBean r100, CommentBean r110) {
        CommentBean r101 = r100;
        CommentBean r111 = r110;
        Map<String, CommentRectF> r102 = this.f222668a;
        CommentRectF r103 = null;
        if (r102 != null) goto L5;
        CommentRectF r104 = null;
    L6:
        Map<String, CommentRectF> r105 = this.f222668a;
        if (r105 == null) goto L11;
        r103 = r105.get(r111.getComment_id());
    L11:
        return f.a(r104, f.b(r101), r103, f.b(r111));
    L5:
        r104 = r102.get(r101.getComment_id());
        goto L6
    }
}
