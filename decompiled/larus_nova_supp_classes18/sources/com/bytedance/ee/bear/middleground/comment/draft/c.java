package com.bytedance.ee.bear.middleground.comment.draft;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c() {
    }

    public static String c(String r1) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        return du5.b.g(r1) + "#Comment_Drafts";
    }

    public static String a(String r3, String r4, boolean r5) {
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        if (r5 == false) goto L12;
        return "new_comment_whole";
    L12:
        return "new_comment_part";
    L13:
        if (r4 != null) goto L15;
    L18:
        if (r0 == false) goto L21;
        return r3 + "#new_reply";
    L21:
        return r3 + '#' + r4;
    L15:
        if (r4.length() == 0) goto L18;
        r0 = false;
        goto L18
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ String b(String r2, String r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = false;
    L12:
        return a(r2, r3, r4);
    }
}
