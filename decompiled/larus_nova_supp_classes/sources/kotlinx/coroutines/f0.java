package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface f0 {
    m0 invokeOnTimeout(long r1, Runnable r3, CoroutineContext r4);

    void scheduleResumeAfterDelay(long r1, i<? super Unit> r3);
}
