package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowAppLogDataObserverIDLStubWrapper>> f384667a = null;

    static {
        f384667a = new LinkedHashMap();
    }

    public static final IFlowAppLogDataObserverIDL.Stub a(final IFlowAppLogDataObserverIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowAppLogDataObserverIDLStubWrapper>> r101 = f384667a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowAppLogDataObserverIDLStubWrapper r103 = (FlowAppLogDataObserverIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowAppLogDataObserverIDLStubWrapper) == false) goto L16;
        FlowAppLogDataObserverIDLStubWrapper r105 = new FlowAppLogDataObserverIDLStubWrapper(((FlowAppLogDataObserverIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new b());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAppLogDataObserverIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAppLogDataObserverIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new a(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowAppLogDataObserverIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogDataObserverIDL b(IFlowAppLogDataObserverIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowAppLogDataObserverIDLIpcWrapper) == false) goto L7;
        return new FlowAppLogDataObserverIDLIpcWrapper(((FlowAppLogDataObserverIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowAppLogDataObserverIDLIpcWrapper(r100, true);
    }
}
