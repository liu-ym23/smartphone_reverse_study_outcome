package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f230973a = 0;

    static {
    }

    public static boolean b(sbb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        if (Intrinsics.areEqual(r100, sbb.e.f541300k) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, sbb.e.f541297h) == true) goto L10;
        if (Intrinsics.areEqual(r100, sbb.e.f541301l) == true) goto L10;
        return false;
    }

    public static boolean c(List r100) {
        if (r100 != null) goto L29;
    L28:
        return false;
    L29:
        Iterator r101 = r100.iterator();     // Catch: Exception -> L26
    L5:
        if (r101.hasNext() == false) goto L28;
        List<CommentBean.CommentDetail> r102 = ((CommentBean) r101.next()).getComment_list();     // Catch: Exception -> L26
        if (r102 == null) goto L23;
        List<CommentBean.CommentDetail> r103 = r102;     // Catch: Exception -> L26
        if ((r103 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r104 = r103.iterator();     // Catch: Exception -> L26
    L16:
        if (r104.hasNext() == false) goto L20;
        if (((CommentBean.CommentDetail) r104.next()).isEditStatus() == false) goto L16;
        boolean r105 = true;
    L21:
        if (r105 != true) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L5;
        return true;
    L20:
        r105 = false;
        goto L21
    L12:
        if (r103.isEmpty() == false) goto L14;
    L23:
        r106 = false;
    L26:
        e = move-exception;
        tt5.a.f("CommentBeanUtils", e, false);
        goto L28
    }

    public static int a(int r100, List r101) {
        if (r101 != null) goto L22;
        return -2;
    L22:
        CommentBean r102 = (CommentBean) ListProtector.get(r101, r100);     // Catch: Exception -> L18
        if (r102 == null) goto L27;
        List<CommentBean.CommentDetail> r103 = r102.getComment_list();     // Catch: Exception -> L18
        if (r103 == null) goto L28;
        Iterator<T> r104 = r103.iterator();     // Catch: Exception -> L18
        int r105 = 0;
    L9:
        if (r104.hasNext() == false) goto L29;
        Object r106 = r104.next();     // Catch: Exception -> L18
        int r107 = r105 + 1;     // Catch: Exception -> L18
        if (r105 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L18
    L15:
        if (((CommentBean.CommentDetail) r106).isEditStatus() == true) goto L16;
        r105 = r107;
        goto L9
    L16:
        return r105;
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
