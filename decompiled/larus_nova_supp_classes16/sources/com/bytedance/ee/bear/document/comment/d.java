package com.bytedance.ee.bear.document.comment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements e {
    public com.bytedance.ee.bear.middleground.comment.export.h a;
    public final List<l2> b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        com.bytedance.ee.bear.middleground.comment.export.h r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.O(true) != true) goto L11;
        return true;
    L11:
        return false;
    }

    public d() {
        this.a = null;
        this.b = new ArrayList();
    }

    public final void a(o2 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L8
        r0.addAll(this.b);     // Catch: Exception -> L8
        Iterator r1 = r0.iterator();     // Catch: Exception -> L8
    L5:
        if (r1.hasNext() == false) goto L15;
        ((l2) r1.next()).a(r4);     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        tt5.a.e("CommentEventDispatcher", "dispatchCommentEvent error", e, false);
    }

    public final void c(l2 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.b).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.b).add(r2);
    }
}
