package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface d1<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object collect(FlowCollector<? super T> r1, Continuation<?> r2);

    List<T> getReplayCache();
}
