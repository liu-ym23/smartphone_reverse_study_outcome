package com.bytedance.ee.bear.middleground.comment.draft;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f231298a = 0;

    static {
    }

    public c() {
    }

    public static String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return du5.b.g(r100) + "#Comment_Drafts";
    }

    public static String a(String r100, String r101, boolean r102) {
        boolean r103 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L13;
        if (r102 == false) goto L12;
        return "new_comment_whole";
    L12:
        return "new_comment_part";
    L13:
        if (r101 != null) goto L15;
    L18:
        if (r103 == false) goto L21;
        return r100 + "#new_reply";
    L21:
        return r100 + '#' + r101;
    L15:
        if (r101.length() == 0) goto L18;
        r103 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static /* synthetic */ String b(String r100, String r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = false;
    L12:
        return a(r100, r101, r102);
    }
}
