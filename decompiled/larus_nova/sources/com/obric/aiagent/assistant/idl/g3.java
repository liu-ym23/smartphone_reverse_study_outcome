package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowSemanticEditCallbackIDLStubWrapper>> f384527a = null;

    static {
        f384527a = new LinkedHashMap();
    }

    public static final IFlowSemanticEditCallbackIDL.Stub a(final IFlowSemanticEditCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowSemanticEditCallbackIDLStubWrapper>> r101 = f384527a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowSemanticEditCallbackIDLStubWrapper r103 = (FlowSemanticEditCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowSemanticEditCallbackIDLStubWrapper) == false) goto L16;
        FlowSemanticEditCallbackIDLStubWrapper r105 = new FlowSemanticEditCallbackIDLStubWrapper(((FlowSemanticEditCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new f3());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowSemanticEditCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowSemanticEditCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new e3(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowSemanticEditCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowSemanticEditCallbackIDL b(IFlowSemanticEditCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowSemanticEditCallbackIDLIpcWrapper) == false) goto L7;
        return new FlowSemanticEditCallbackIDLIpcWrapper(((FlowSemanticEditCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowSemanticEditCallbackIDLIpcWrapper(r100, true);
    }
}
