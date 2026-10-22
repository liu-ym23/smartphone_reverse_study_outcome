package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
public interface d1<T> extends Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    Object collect(FlowCollector<? super T> r100, Continuation<?> r101);

    List<T> getReplayCache();
}
