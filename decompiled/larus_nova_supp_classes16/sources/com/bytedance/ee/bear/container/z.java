package com.bytedance.ee.bear.container;

import io.reactivex.functions.Action;
import kotlin.Result;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z implements Action {
    public final /* synthetic */ Ref.ObjectRef<WikiInitNode.b> a;
    public final /* synthetic */ bk5.a b;
    public final /* synthetic */ kotlinx.coroutines.i<WikiInitNode.b> c;

    public z(Ref.ObjectRef r1, bk5.a r2, kotlinx.coroutines.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        if (this.a.element != null) goto L6;
        tt5.a.d("MockWikiInitNode", this.b.getTAG() + ", pull wiki info complete without valid data");
    L6:
        if (this.c.isActive() == false) goto L9;
        kotlinx.coroutines.i<WikiInitNode.b> r0 = this.c;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(this.a.element));
        return;
    }
}
