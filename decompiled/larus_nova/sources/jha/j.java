package jha;

import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public interface j {

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public static c a(j r100) {
            ExecutorCoroutineDispatcher r101 = f.f499127a;
            String r102 = r100.getClass().getName();
            Intrinsics.checkNotNullParameter(r102, "orderingDomain");
            return new c(TaskFlowDispatchStrategy.SHARED_SERIALIZED, r102);
        }
    }
}
