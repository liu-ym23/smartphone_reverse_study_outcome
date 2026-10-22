package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutineContextKt {
    public static final CoroutineContext b(CoroutineContext r100, CoroutineContext r101) {
        if (((Boolean) r101.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue() == true) goto L7;
        return r100.plus(r101);
    L7:
        return a(r100, r101, false);
    }

    public static final CoroutineContext c(CoroutineScope r100, CoroutineContext r101) {
        CoroutineContext r102 = a(r100.getCoroutineContext(), r101, true);
        if (r102 != Dispatchers.getDefault()) goto L5;
        return r102;
    L5:
        if (r102.get(ContinuationInterceptor.Key) == null) goto L7;
        return r102;
    L7:
        return r102.plus(Dispatchers.getDefault());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext r100, CoroutineContext r101, final boolean r102) {
        Boolean r103 = Boolean.FALSE;
        CoroutineContextKt$hasCopyableElements$1 r104 = CoroutineContextKt$hasCopyableElements$1.INSTANCE;
        boolean r105 = ((Boolean) r100.fold(r103, r104)).booleanValue();
        boolean r106 = ((Boolean) r101.fold(r103, r104)).booleanValue();
        if (r105 == true) goto L7;
        if (r106 == true) goto L7;
        return r100.plus(r101);
    L7:
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = r101;
        EmptyCoroutineContext r108 = EmptyCoroutineContext.INSTANCE;
        CoroutineContext r109 = (CoroutineContext) r100.fold(r108, new CoroutineContextKt$foldCopies$folded$1(r107, r102));
        if (r106 == false) goto L11;
        r107.element = ((CoroutineContext) r107.element).fold(r108, CoroutineContextKt$foldCopies$1.INSTANCE);
    L11:
        return r109.plus((CoroutineContext) r107.element);
    }

    public static final b2<?> d(Continuation<?> r100, CoroutineContext r101, Object r102) {
        b2<?> r103 = null;
        if ((r100 instanceof CoroutineStackFrame) == true) goto L6;
        return null;
    L6:
        if (r101.get(c2.f504644a) == null) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        return null;
    L11:
        CoroutineStackFrame r105 = (CoroutineStackFrame) r100;
    L13:
        if ((r105 instanceof h0) == true) goto L21;
        r105 = r105.getCallerFrame();
        if (r105 == null) goto L21;
        if ((r105 instanceof b2) == false) goto L13;
        r103 = (b2) r105;
    L21:
        if (r103 == null) goto L23;
        r103.q0(r101, r102);
    L23:
        return r103;
    L8:
        r104 = false;
        goto L9
    }
}
