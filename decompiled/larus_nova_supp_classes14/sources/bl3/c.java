package bl3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Function1 r0 = this.a;
        Long r7 = ((cl3.a) r6).a();
        if (r7 != null) goto L6;
    L8:
        boolean r8 = false;
    L9:
        r0.invoke(Boolean.valueOf(r8));
        return;
    L6:
        if (r7.longValue() != 1) goto L8;
        r8 = true;
        goto L9
    }
}
