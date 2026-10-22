package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d2<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public d2(WikiTreeModel r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Boolean) r3, "it");
        return t1.e(this.a, this.b, this.c);
    }
}
