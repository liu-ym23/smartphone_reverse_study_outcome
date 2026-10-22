package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes.dex */
public interface f0 {
    m0 invokeOnTimeout(long r100, Runnable r101, CoroutineContext r102);

    void scheduleResumeAfterDelay(long r100, i<? super Unit> r101);
}
