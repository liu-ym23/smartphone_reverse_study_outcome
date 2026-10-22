package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> f384669a = null;

    static {
        f384669a = new LinkedHashMap();
    }

    public static final IFlowAppLogEventObserverIDL.Stub a(final IFlowAppLogEventObserverIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> r101 = f384669a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowAppLogEventObserverIDLStubWrapper r103 = (FlowAppLogEventObserverIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowAppLogEventObserverIDLStubWrapper) == false) goto L16;
        FlowAppLogEventObserverIDLStubWrapper r105 = new FlowAppLogEventObserverIDLStubWrapper(((FlowAppLogEventObserverIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new e());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAppLogEventObserverIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAppLogEventObserverIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new d(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowAppLogEventObserverIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogEventObserverIDL b(IFlowAppLogEventObserverIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowAppLogEventObserverIDLIpcWrapper) == false) goto L7;
        return new FlowAppLogEventObserverIDLIpcWrapper(((FlowAppLogEventObserverIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowAppLogEventObserverIDLIpcWrapper(r100, true);
    }
}
