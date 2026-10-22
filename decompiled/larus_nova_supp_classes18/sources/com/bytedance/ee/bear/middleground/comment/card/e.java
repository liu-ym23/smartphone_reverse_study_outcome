package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(sbb.e r1) {
        Intrinsics.checkNotNullParameter(r1, "pageType");
        if (Intrinsics.areEqual(r1, sbb.e.k) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, sbb.e.h) == true) goto L10;
        if (Intrinsics.areEqual(r1, sbb.e.l) == true) goto L10;
        return false;
    }

    public static boolean c(List r4) {
        if (r4 != null) goto L29;
    L28:
        return false;
    L29:
        Iterator r5 = r4.iterator();     // Catch: Exception -> L26
    L5:
        if (r5.hasNext() == false) goto L28;
        List<CommentBean.CommentDetail> r1 = ((CommentBean) r5.next()).getComment_list();     // Catch: Exception -> L26
        if (r1 == null) goto L23;
        List<CommentBean.CommentDetail> r2 = r1;     // Catch: Exception -> L26
        if ((r2 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r3 = r2.iterator();     // Catch: Exception -> L26
    L16:
        if (r3.hasNext() == false) goto L20;
        if (((CommentBean.CommentDetail) r3.next()).isEditStatus() == false) goto L16;
        boolean r6 = true;
    L21:
        if (r6 != true) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L5;
        return true;
    L20:
        r6 = false;
        goto L21
    L12:
        if (r2.isEmpty() == false) goto L14;
    L23:
        r7 = false;
    L26:
        e = move-exception;
        tt5.a.f("CommentBeanUtils", e, false);
        goto L28
    }

    public static int a(int r3, List r4) {
        if (r4 != null) goto L22;
        return -2;
    L22:
        CommentBean r5 = (CommentBean) ListProtector.get(r4, r3);     // Catch: Exception -> L18
        if (r5 == null) goto L27;
        List<CommentBean.CommentDetail> r6 = r5.getComment_list();     // Catch: Exception -> L18
        if (r6 == null) goto L28;
        Iterator<T> r7 = r6.iterator();     // Catch: Exception -> L18
        int r8 = 0;
    L9:
        if (r7.hasNext() == false) goto L29;
        Object r1 = r7.next();     // Catch: Exception -> L18
        int r2 = r8 + 1;     // Catch: Exception -> L18
        if (r8 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L18
    L15:
        if (((CommentBean.CommentDetail) r1).isEditStatus() == true) goto L16;
        r8 = r2;
        goto L9
    L16:
        return r8;
    L29:
        return -2;
    L28:
        return -2;
    L27:
        return -2;
    L18:
        e = move-exception;
        tt5.a.f("CommentBeanUtils", e, false);
        return -2;
    }
}
