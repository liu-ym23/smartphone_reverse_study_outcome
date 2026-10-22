package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e2<T, R> implements Function {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ WikiTreeModel b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ String i;

    public e2(boolean r1, WikiTreeModel r2, String r3, String r4, String r5, String r6, String r7, boolean r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final Object apply(Object r14) {
        MoveNodePuller.Result r15 = (MoveNodePuller.Result) r14;
        Intrinsics.checkNotNullParameter(r15, "result");
        if (this.a == true) goto L6;
        t1.d(this.b, this.c, this.d);
    L10:
        return Boolean.TRUE;
    L6:
        if (this.b.isSameSpace(this.c) == true) goto L8;
        this.b.workspace.M(this.d, this.e);
    L8:
        WikiTreeModel r0 = this.b;
        String r1 = this.f;
        Intrinsics.checkNotNull(r1);
        t1.i(r0, r1, new f(this.d, this.g, r15.sort_id, this.h, this.i, null, null, this.e));
        goto L10
    }
}
