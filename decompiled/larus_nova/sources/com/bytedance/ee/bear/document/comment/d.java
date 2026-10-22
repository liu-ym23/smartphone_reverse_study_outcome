package com.bytedance.ee.bear.document.comment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.export.h f219291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l2> f219292b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        com.bytedance.ee.bear.middleground.comment.export.h r100 = this.f219291a;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.O(true) != true) goto L11;
        return true;
    L11:
        return false;
    }

    public d() {
        this.f219291a = null;
        this.f219292b = new ArrayList();
    }

    public final void a(o2 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L8
        r101.addAll(this.f219292b);     // Catch: Exception -> L8
        Iterator r102 = r101.iterator();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L15;
        ((l2) r102.next()).a(r100);     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        tt5.a.e("CommentEventDispatcher", "dispatchCommentEvent error", e, false);
    }

    public final void c(l2 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f219292b).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f219292b).add(r100);
    }
}
