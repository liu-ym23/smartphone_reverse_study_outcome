package com.bytedance.ee.bear.document.comment;

import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(com.bytedance.ee.bear.middleground.comment.export.i r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, DocRedirectToDocxPlugin.FROM);
        af5.b r4 = r2.a();
        if (r4 == null) goto L8;
        com.bytedance.ee.bear.middleground.comment.performance.b r5 = r4.c();
        if (r5 == null) goto L9;
        r5.d(System.currentTimeMillis(), r3);
        return;
    L9:
        return;
    }
}
