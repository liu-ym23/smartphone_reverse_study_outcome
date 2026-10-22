package bl3;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public a(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        cl3.b r3 = (cl3.b) r2;
        Function1 r0 = this.a;
        if (r0 == null) goto L13;
        Integer r4 = r3.a();
        if (r4 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        Unit r6 = (Unit) r0.invoke(Boolean.valueOf(r5));
        return;
    L8:
        if (r4.intValue() != 0) goto L10;
        r5 = true;
        goto L11
    }
}
