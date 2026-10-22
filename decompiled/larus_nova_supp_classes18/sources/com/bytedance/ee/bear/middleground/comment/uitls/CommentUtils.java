package com.bytedance.ee.bear.middleground.comment.uitls;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(CommentUtils$docxAreaCommentFg$2.INSTANCE);
        b = LazyKt.lazy(CommentUtils$sheetAreaCommentFg$2.INSTANCE);
        c = LazyKt.lazy(CommentUtils$slidesAreaCommentFg$2.INSTANCE);
    }

    public static boolean b(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (com.bytedance.ee.util.ui.n.C(r2) == true) goto L8;
        return false;
    L8:
        if (ku5.c.k(r2) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static Pair a(int r4, boolean r5) {
        boolean r1 = false;
        if (r4 != sbb.e.o.b) goto L6;
        boolean r0 = ((Boolean) a.getValue()).booleanValue();
    L12:
        if (r0 == false) goto L15;
        if (r5 == false) goto L15;
        r1 = true;
    L15:
        tt5.a.h("CommentUtils", "pageType:" + r4 + ", per:" + r5 + ", canShowAreaMark:" + r0 + ", canAreaMark:" + r1);
        return TuplesKt.to(Boolean.valueOf(r0), Boolean.valueOf(r1));
    L6:
        if (r4 != sbb.e.h.b) goto L9;
        r0 = ((Boolean) b.getValue()).booleanValue();
        goto L12
    L9:
        if (r4 != sbb.e.m.b) goto L11;
        r0 = ((Boolean) c.getValue()).booleanValue();
        goto L12
    L11:
        r0 = false;
        goto L12
    }
}
