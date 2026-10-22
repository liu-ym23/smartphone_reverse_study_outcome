package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.bytedance.ee.bear.lark.dependency.d0;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public n(String r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((String) r4, "it");
        return ((d0) org.koin.java.a.c(d0.class, null, null, 6)).e(this.a, this.b, this.c);
    }
}
