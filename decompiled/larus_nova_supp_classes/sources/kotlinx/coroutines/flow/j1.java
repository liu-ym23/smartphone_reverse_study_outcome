package kotlinx.coroutines.flow;

import android.Manifest;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.internal.o;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j1 {
    public static final b0 a = null;
    public static final b0 b = null;

    static {
        a = new b0("NONE");
        b = new b0("PENDING");
    }

    public static final StateFlowImpl a(Object r1) {
        if (r1 != null) goto L6;
        r1 = o.a;
    L6:
        return new StateFlowImpl(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(z0<T> r2, Function1<? super T, ? extends T> r3) {
    L2:
        Manifest.permission_group r0 = (Object) r2.getValue();
        if (r2.compareAndSet(r0, r3.invoke(r0)) == false) goto L2;
    }
}
