package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0<T, R> implements Function {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ String b;

    public j0(c0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Boolean) r2, "it");
        return this.a.e.getMoveToSpaceStatus(this.b);
    }
}
