package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;
    public volatile String _state;
    public volatile Thread lastObservedThread;

    public final List<StackTraceElement> a() {
        WeakReference<CoroutineStackFrame> r100 = this._lastObservedFrame;
        if (r100 == null) goto L5;
        CoroutineStackFrame r101 = r100.get();
    L6:
        if (r101 == null) goto L8;
        ArrayList r102 = new ArrayList();
    L10:
        if (r101 == null) goto L15;
        StackTraceElement r103 = r101.getStackTraceElement();
        if (r103 == null) goto L14;
        r102.add(r103);
    L14:
        r101 = r101.getCallerFrame();
        goto L10
    L15:
        return r102;
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    public final String toString() {
        return "DebugCoroutineInfo(state=" + this._state + ",context=" + getContext() + ')';
    }

    public final CoroutineContext getContext() {
        throw null;
    }
}
