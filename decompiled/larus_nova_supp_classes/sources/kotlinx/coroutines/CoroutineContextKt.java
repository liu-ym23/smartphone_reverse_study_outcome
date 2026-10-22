package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class CoroutineContextKt {
    public static final CoroutineContext b(CoroutineContext r2, CoroutineContext r3) {
        if (((Boolean) r3.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue() == true) goto L7;
        return r2.plus(r3);
    L7:
        return a(r2, r3, false);
    }

    public static final CoroutineContext c(CoroutineScope r1, CoroutineContext r2) {
        CoroutineContext r3 = a(r1.getCoroutineContext(), r2, true);
        if (r3 != Dispatchers.getDefault()) goto L5;
        return r3;
    L5:
        if (r3.get(ContinuationInterceptor.Key) == null) goto L7;
        return r3;
    L7:
        return r3.plus(Dispatchers.getDefault());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext r3, CoroutineContext r4, boolean r5) {
        Boolean r0 = Boolean.FALSE;
        CoroutineContextKt$hasCopyableElements$1 r1 = CoroutineContextKt$hasCopyableElements$1.INSTANCE;
        boolean r2 = ((Boolean) r3.fold(r0, r1)).booleanValue();
        boolean r6 = ((Boolean) r4.fold(r0, r1)).booleanValue();
        if (r2 == true) goto L7;
        if (r6 == true) goto L7;
        return r3.plus(r4);
    L7:
        Ref$ObjectRef r7 = new Ref$ObjectRef();
        r7.element = r4;
        EmptyCoroutineContext r8 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r9 = (CoroutineContext) r3.fold(r8, new foldCopies.folded.1(r7, r5));
        if (r6 == false) goto L11;
        r7.element = ((CoroutineContext) r7.element).fold(r8, foldCopies.1.INSTANCE);
    L11:
        return r9.plus((CoroutineContext) r7.element);
    }

    public static final b2<?> d(Continuation<?> r2, CoroutineContext r3, Object r4) {
        b2<?> r1 = null;
        if ((r2 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r3.get(c2.a) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        CoroutineStackFrame r5 = (CoroutineStackFrame) r2;
    L13:
        if ((r5 instanceof h0) == true) goto L21;
        r5 = r5.getCallerFrame();
        if (r5 == null) goto L21;
        if ((r5 instanceof b2) == false) goto L13;
        r1 = (b2) r5;
    L21:
        if (r1 == null) goto L23;
        r1.q0(r3, r4);
    L23:
        return r1;
    L8:
        r0 = false;
        goto L9
    }
}
