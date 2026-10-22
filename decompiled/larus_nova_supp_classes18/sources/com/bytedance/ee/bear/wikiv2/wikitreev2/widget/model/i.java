package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static String a(e3 r1, c r2, ce5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            if (qc5.a.g(r3) == false) goto L6;
            if (r2 == null) goto L8;
            String r4 = r2.getSpaceId();
        L9:
            if (r4 != null) goto L12;
            return "";
        L12:
            return r4;
        L8:
            r4 = null;
            goto L9
        L6:
            if (r1 == null) goto L8;
            r4 = r1.o();
            goto L9
        }

        @JvmStatic
        public static String b(e3 r1, String r2, ce5.a r3) {
            Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
            if (qc5.a.g(r3) == true) goto L8;
            if (r1 == null) goto L7;
            r2 = r1.o();
            goto L8
        L7:
            r2 = null;
        L8:
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(e3 r0) {
        if (r0 == null) goto L5;
        String r1 = r0.o();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return "";
    }

    @JvmStatic
    public static final String b(e3 r1, String r2, ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        if (r1 == null) goto L14;
        if (r2 == null) goto L14;
        if (qc5.a.g(r3) == false) goto L12;
        TreeNode r4 = r1.m(r2);
        if (r4 == null) goto L11;
        String r5 = r4.space_id;
    L13:
        if (r5 == null) goto L14;
        return r5;
    L11:
        r5 = null;
        goto L13
    L12:
        r5 = r1.o();
    L14:
        return "";
    }
}
