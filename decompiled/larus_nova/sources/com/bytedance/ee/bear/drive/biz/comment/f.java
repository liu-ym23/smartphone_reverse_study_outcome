package com.bytedance.ee.bear.drive.biz.comment;

import android.graphics.RectF;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class f {
    public static long b(CommentBean r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.getComment_list() != null) goto L6;
        return 0;
    L6:
        if (r100.getComment_list().isEmpty() == false) goto L9;
        return 0;
    L9:
        return ((CommentBean.CommentDetail) ListProtector.get(r100.getComment_list(), 0)).getCreate_timestamp();
    }

    public static int a(CommentRectF r100, long r101, CommentRectF r102, long r103) {
        int r104 = 0;
        if (r100 != null) goto L5;
        int r105 = 0;
    L6:
        if (r102 != null) goto L8;
        int r106 = 0;
    L9:
        int r107 = Integer.compare(r105, r106);
        if (r107 == 0) goto L13;
        return r107;
    L13:
        if (r100 != null) goto L15;
    L20:
        int r108 = 0;
    L21:
        if (r102 != null) goto L23;
    L28:
        int r109 = Integer.compare(r108, r104);
        if (r109 == 0) goto L31;
        return r109;
    L31:
        float r110 = 0.0f;
        if (r100 != null) goto L34;
        float r111 = 0.0f;
    L35:
        if (r102 != null) goto L37;
        float r112 = 0.0f;
    L38:
        int r113 = Float.compare(r111, r112);
        if (r113 == 0) goto L41;
        return r113;
    L41:
        if (r100 != null) goto L43;
        float r114 = 0.0f;
    L44:
        if (r102 == null) goto L47;
        r110 = ((RectF) r102).left;
    L47:
        int r115 = Float.compare(r114, r110);
        if (r115 == 0) goto L50;
        return r115;
    L50:
        if (r100 == null) goto L53;
        r101 = r100.f236777d;
    L53:
        if (r102 == null) goto L57;
        r103 = r102.f236777d;
    L57:
        return Long.compare(r101, r103);
    L43:
        r114 = ((RectF) r100).left;
        goto L44
    L37:
        r112 = ((RectF) r102).top;
        goto L38
    L34:
        r111 = ((RectF) r100).top;
        goto L35
    L23:
        if (r102.getType() == 1) goto L28;
        if (r102.getType() == 4) goto L28;
        r104 = 1;
        goto L28
    L15:
        if (r100.getType() == 1) goto L20;
        if (r100.getType() == 4) goto L20;
        r108 = 1;
        goto L21
    L8:
        r106 = r102.f236778e;
        goto L9
    L5:
        r105 = r100.f236778e;
        goto L6
    }
}
