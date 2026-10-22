package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface l<T> extends Flow<T> {
    Flow<T> a(CoroutineContext r1, int r2, BufferOverflow r3);
}
