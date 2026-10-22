package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final b0 a = null;

    static {
        a = new b0("CLOSED");
    }

    public static final <S extends y<S>> Object a(S r5, long r6, Function2<? super Long, ? super S, ? extends S> r8) {
    L3:
        if (r5.c >= r6) goto L5;
    L8:
        AtomicReferenceFieldUpdater r0 = e.a;
        Object r1 = r0.get(r5);
        b0 r2 = a;
        if (r1 == r2) goto L10;
        S r3 = (S) ((e) r1);
        if (r3 != null) goto L13;
        r3 = r8.invoke(Long.valueOf(r5.c + 1), r5);
    L16:
        if (r0.compareAndSet(r5, null, r3) == true) goto L17;
        if (r0.get(r5) == null) goto L16;
        boolean r4 = false;
    L21:
        if (r4 == false) goto L3;
        if (r5.d() == false) goto L13;
        r5.e();
        goto L13
    L17:
        r4 = true;
    L13:
        r5 = (Object) r3;
        goto L3
    L10:
        return r2;
    L5:
        if (r5.d() == true) goto L8;
        return r5;
    }
}
