package com.bytedance.ee.bear.middleground.comment.uitls;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f232185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f232186b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f232187c = null;

    static {
        f232185a = LazyKt.lazy(CommentUtils$docxAreaCommentFg$2.INSTANCE);
        f232186b = LazyKt.lazy(CommentUtils$sheetAreaCommentFg$2.INSTANCE);
        f232187c = LazyKt.lazy(CommentUtils$slidesAreaCommentFg$2.INSTANCE);
    }

    public static boolean b(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (com.bytedance.ee.util.ui.n.C(r100) == true) goto L8;
        return false;
    L8:
        if (ku5.c.k(r100) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static Pair a(int r100, boolean r101) {
        boolean r102 = false;
        if (r100 != sbb.e.f541304o.f541317b) goto L6;
        boolean r103 = ((Boolean) f232185a.getValue()).booleanValue();
    L12:
        if (r103 == false) goto L15;
        if (r101 == false) goto L15;
        r102 = true;
    L15:
        tt5.a.h("CommentUtils", "pageType:" + r100 + ", per:" + r101 + ", canShowAreaMark:" + r103 + ", canAreaMark:" + r102);
        return TuplesKt.to(Boolean.valueOf(r103), Boolean.valueOf(r102));
    L6:
        if (r100 != sbb.e.f541297h.f541317b) goto L9;
        r103 = ((Boolean) f232186b.getValue()).booleanValue();
        goto L12
    L9:
        if (r100 != sbb.e.f541302m.f541317b) goto L11;
        r103 = ((Boolean) f232187c.getValue()).booleanValue();
        goto L12
    L11:
        r103 = false;
        goto L12
    }
}
