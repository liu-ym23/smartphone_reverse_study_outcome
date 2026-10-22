package bw3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ f0 b;
    public final /* synthetic */ double c;

    public /* synthetic */ z(e0 r1, f0 r2, double r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r8) {
        final e0 r6 = this.a;
        final f0 r2 = this.b;
        final double r4 = this.c;
        final boolean r3 = ((Boolean) r8).booleanValue();
        Function0 r9 = new b0(r6, r2, r3, r4);
        r6.getClass();
        e0.g(r9);
        return Unit.INSTANCE;
    }
}
