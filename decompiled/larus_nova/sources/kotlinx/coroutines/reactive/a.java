package kotlinx.coroutines.reactive;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.j;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes42.dex */
public final class a {
    public static Object a(final Mode r100, ContinuationImpl r101) {
        final j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        r102.getContext();
        b[] r103 = e.f505032a;
        int r104 = r103.length;
        final Object r105 = null;
        int r106 = 0;
        Publisher r107 = null;
    L3:
        if (r106 >= r104) goto L5;
        r107 = r103[r106].a();
        r106 = r106 + 1;
        goto L3
    L5:
        r107.subscribe(new AwaitKt$awaitOne$2$1(r102, r100, r105));
        Object r108 = r102.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L8:
        return r108;
    }
}
