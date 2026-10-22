package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes42.dex */
public interface c<E> extends CoroutineScope, ReceiveChannel<E> {
    Channel<E> getChannel();
}
