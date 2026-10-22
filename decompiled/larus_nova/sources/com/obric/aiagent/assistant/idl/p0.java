package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper>> f384562a = null;

    static {
        f384562a = new LinkedHashMap();
    }

    public static final IFlowAssistantActiveStateListenerIDL.Stub a(final IFlowAssistantActiveStateListenerIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper>> r101 = f384562a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowAssistantActiveStateListenerIDLStubWrapper r103 = (FlowAssistantActiveStateListenerIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowAssistantActiveStateListenerIDLStubWrapper) == false) goto L16;
        FlowAssistantActiveStateListenerIDLStubWrapper r105 = new FlowAssistantActiveStateListenerIDLStubWrapper(((FlowAssistantActiveStateListenerIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new o0());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAssistantActiveStateListenerIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new n0(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowAssistantActiveStateListenerIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAssistantActiveStateListenerIDL b(IFlowAssistantActiveStateListenerIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowAssistantActiveStateListenerIDLIpcWrapper) == false) goto L7;
        return new FlowAssistantActiveStateListenerIDLIpcWrapper(((FlowAssistantActiveStateListenerIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowAssistantActiveStateListenerIDLIpcWrapper(r100, true);
    }
}
