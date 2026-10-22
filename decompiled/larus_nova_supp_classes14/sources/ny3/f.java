package ny3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements p24.c {
    public final /* synthetic */ h.a a;

    public f(h.a r1) {
        this.a = r1;
    }

    public final void onFail(Exception r3) {
        h.a r4 = this.a;
        r4.b.O1(r4.a, 0);
    }

    public final void onSuccess(Object r3) {
        o14.f r4 = (o14.f) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.a.a(r4, false);
    }
}
