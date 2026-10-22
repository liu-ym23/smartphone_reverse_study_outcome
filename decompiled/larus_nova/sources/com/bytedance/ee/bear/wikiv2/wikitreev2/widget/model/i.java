package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f241908a = 0;

    public static final class a {
        @JvmStatic
        public static String a(e3 r100, c r101, ce5.a r102) {
            Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
            if (qc5.a.g(r102) == false) goto L6;
            if (r101 == null) goto L8;
            String r103 = r101.getSpaceId();
        L9:
            if (r103 != null) goto L12;
            return "";
        L12:
            return r103;
        L8:
            r103 = null;
            goto L9
        L6:
            if (r100 == null) goto L8;
            r103 = r100.o();
            goto L9
        }

        @JvmStatic
        public static String b(e3 r100, String r101, ce5.a r102) {
            Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
            if (qc5.a.g(r102) == true) goto L8;
            if (r100 == null) goto L7;
            r101 = r100.o();
            goto L8
        L7:
            r101 = null;
        L8:
            if (r101 != null) goto L11;
            return "";
        L11:
            return r101;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(e3 r100) {
        if (r100 == null) goto L5;
        String r101 = r100.o();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @JvmStatic
    public static final String b(e3 r100, String r101, ce5.a r102) {
        Intrinsics.checkNotNullParameter(r102, "userComponentAbility");
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (qc5.a.g(r102) == false) goto L12;
        TreeNode r103 = r100.m(r101);
        if (r103 == null) goto L11;
        String r104 = r103.space_id;
    L13:
        if (r104 == null) goto L14;
        return r104;
    L11:
        r104 = null;
        goto L13
    L12:
        r104 = r100.o();
    L14:
        return "";
    }
}
