package ny3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements p24.c {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void onFail(Exception r2) {
        ux3.b r3 = (ux3.b) this.a.b;
        if (r3 == null) goto L6;
        new RuntimeException();
        r3.f();
        return;
    }

    public final void onSuccess(Object r3) {
        o14.f r4 = (o14.f) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        this.a.a(r4, true);
        d r0 = this.a;
        List r5 = r4.g();
        boolean r1 = this.a.d;
        ux3.b r2 = (ux3.b) r0.b;
        if (r2 == null) goto L6;
        r2.C6(TypeIntrinsics.asMutableList(r5), r1);
        return;
    }
}
