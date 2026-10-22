package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper>> f384586a = null;

    static {
        f384586a = new LinkedHashMap();
    }

    public static final IFlowAssistantTTSStateListenerIDL.Stub a(final IFlowAssistantTTSStateListenerIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper>> r101 = f384586a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowAssistantTTSStateListenerIDLStubWrapper r103 = (FlowAssistantTTSStateListenerIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowAssistantTTSStateListenerIDLStubWrapper) == false) goto L16;
        FlowAssistantTTSStateListenerIDLStubWrapper r105 = new FlowAssistantTTSStateListenerIDLStubWrapper(((FlowAssistantTTSStateListenerIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new u0());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAssistantTTSStateListenerIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new t0(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowAssistantTTSStateListenerIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowAssistantTTSStateListenerIDL b(IFlowAssistantTTSStateListenerIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowAssistantTTSStateListenerIDLIpcWrapper) == false) goto L7;
        return new FlowAssistantTTSStateListenerIDLIpcWrapper(((FlowAssistantTTSStateListenerIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowAssistantTTSStateListenerIDLIpcWrapper(r100, true);
    }
}
