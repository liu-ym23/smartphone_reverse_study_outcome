package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes42.dex */
public final class a1 {
    public static Object a(Function0 r100, Continuation r101) {
        return BuildersKt.withContext(EmptyCoroutineContext.INSTANCE, new InterruptibleKt$runInterruptible$2(r100, null), r101);
    }
}
