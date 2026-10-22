package cg3;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public final e a;
    public final f b;
    public final String c;
    public final String d;
    public final Object e;
    public final Function2<Boolean, String, Unit> f;

    /* JADX WARN: Multi-variable type inference failed */
    public k(e r2, f r3, String r4, String r5, Object r6, Function2<? super Boolean, ? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "onFinished");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
