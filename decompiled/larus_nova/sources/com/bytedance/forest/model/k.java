package com.bytedance.forest.model;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements Closeable {
    public com.bytedance.forest.utils.e context;
    private final HashSet<Function0<Unit>> fulfillListeners;

    public abstract boolean isCacheClear$forest_release();

    public abstract boolean isCacheProvided$forest_release();

    public abstract boolean isCacheReady$forest_release();

    public abstract byte[] provideBytes();

    public abstract InputStream provideInputStream(Response r100);

    public abstract int size();

    public abstract boolean supportReuse();

    public abstract void tryLoadToMemory$forest_release(Response r100) throws Throwable;

    public com.bytedance.forest.utils.e getContext$forest_release() {
        com.bytedance.forest.utils.e r100 = this.context;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final void onFulFilled() {
        HashSet<Function0<Unit>> r100 = this.fulfillListeners;
        monitor-enter(r100);
        Iterator<T> r101 = this.fulfillListeners.iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        ((Function0) r101.next()).invoke();     // Catch: Throwable -> L11
        goto L6
    L8:
        this.fulfillListeners.clear();     // Catch: Throwable -> L11
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public k() {
        this.fulfillListeners = new HashSet();
    }

    public void fulfillListener$forest_release(Function0<Unit> r100) {
        HashSet<Function0<Unit>> r101 = this.fulfillListeners;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isCacheReady$forest_release() == false) goto L7;
        r100.invoke();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
        return;
    L7:
        this.fulfillListeners.add(r100);     // Catch: Throwable -> L10
        goto L8
    }

    public void setContext$forest_release(com.bytedance.forest.utils.e r100) {
        this.context = r100;
    }
}
