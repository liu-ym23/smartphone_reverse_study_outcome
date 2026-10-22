package wj2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public int a;
    public boolean b;
    public int c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;

    public i(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onScrollStart");
        Intrinsics.checkNotNullParameter(r3, "onScrollEnd");
        this.d = r2;
        this.e = r3;
        this.a = -1;
        this.c = -1;
    }
}
