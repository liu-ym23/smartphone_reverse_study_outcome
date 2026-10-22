package kotlinx.coroutines.flow;

import android.util.EventsUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH'J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", XmlPullParser.NO_NAMESPACE, "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "emit", XmlPullParser.NO_NAMESPACE, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "tryEmit", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/Object;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface MutableSharedFlow<T> extends d1<T>, FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    /* synthetic */ Object collect(FlowCollector<? super T> r1, Continuation<?> r2);

    @Override // kotlinx.coroutines.flow.FlowCollector
    Object emit(T r1, Continuation<? super Unit> r2);

    @Override // kotlinx.coroutines.flow.d1
    /* synthetic */ List<T> getReplayCache();

    i1<Integer> getSubscriptionCount();

    void resetReplayCache();

    boolean tryEmit(T r1);
}
