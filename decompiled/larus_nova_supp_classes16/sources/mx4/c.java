package mx4;

import android.app.Activity;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        tt5.a.h("DocAutoTestImpl2", "openDoc timeout, next. ");
        a r3 = this.a;
        r3.c.e(r3);
        Activity r4 = this.a.b.getCurrentActivity();
        if (r4 == null) goto L5;
        r4.onBackPressed();
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
