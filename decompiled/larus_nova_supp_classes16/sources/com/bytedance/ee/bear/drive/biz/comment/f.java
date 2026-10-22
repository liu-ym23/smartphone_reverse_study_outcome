package com.bytedance.ee.bear.drive.biz.comment;

import android.graphics.RectF;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static long b(CommentBean r2) {
        if (r2 != null) goto L4;
        return 0;
    L4:
        if (r2.getComment_list() != null) goto L6;
        return 0;
    L6:
        if (r2.getComment_list().isEmpty() == false) goto L9;
        return 0;
    L9:
        return ((CommentBean.CommentDetail) ListProtector.get(r2.getComment_list(), 0)).getCreate_timestamp();
    }

    public static int a(CommentRectF r5, long r6, CommentRectF r8, long r9) {
        int r0 = 0;
        if (r5 != null) goto L5;
        int r1 = 0;
    L6:
        if (r8 != null) goto L8;
        int r2 = 0;
    L9:
        int r3 = Integer.compare(r1, r2);
        if (r3 == 0) goto L13;
        return r3;
    L13:
        if (r5 != null) goto L15;
    L20:
        int r4 = 0;
    L21:
        if (r8 != null) goto L23;
    L28:
        int r7 = Integer.compare(r4, r0);
        if (r7 == 0) goto L31;
        return r7;
    L31:
        float r10 = 0.0f;
        if (r5 != null) goto L34;
        float r11 = 0.0f;
    L35:
        if (r8 != null) goto L37;
        float r12 = 0.0f;
    L38:
        int r13 = Float.compare(r11, r12);
        if (r13 == 0) goto L41;
        return r13;
    L41:
        if (r5 != null) goto L43;
        float r14 = 0.0f;
    L44:
        if (r8 == null) goto L47;
        r10 = ((RectF) r8).left;
    L47:
        int r16 = Float.compare(r14, r10);
        if (r16 == 0) goto L50;
        return r16;
    L50:
        if (r5 == null) goto L53;
        r6 = r5.d;
    L53:
        if (r8 == null) goto L57;
        r9 = r8.d;
    L57:
        return Long.compare(r6, r9);
    L43:
        r14 = ((RectF) r5).left;
        goto L44
    L37:
        r12 = ((RectF) r8).top;
        goto L38
    L34:
        r11 = ((RectF) r5).top;
        goto L35
    L23:
        if (r8.getType() == 1) goto L28;
        if (r8.getType() == 4) goto L28;
        r0 = 1;
        goto L28
    L15:
        if (r5.getType() == 1) goto L20;
        if (r5.getType() == 4) goto L20;
        r4 = 1;
        goto L21
    L8:
        r2 = r8.e;
        goto L9
    L5:
        r1 = r5.e;
        goto L6
    }
}
