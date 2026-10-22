package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
public interface l<T> extends Flow<T> {

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Flow a(l r100, CoroutineDispatcher r101, int r102, BufferOverflow r103, int r104) {
            CoroutineContext r105 = r101;
            if ((r104 & 1) == 0) goto L6;
            r105 = EmptyCoroutineContext.INSTANCE;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = -3;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = BufferOverflow.SUSPEND;
        L12:
            return r100.a(r105, r102, r103);
        }
    }

    Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102);
}
