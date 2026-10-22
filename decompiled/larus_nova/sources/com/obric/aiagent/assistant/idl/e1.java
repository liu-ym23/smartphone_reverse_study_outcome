package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> f384519a = null;

    static {
        f384519a = new LinkedHashMap();
    }

    public static final IFlowDeleteMessageCallbackIDL.Stub a(final IFlowDeleteMessageCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> r101 = f384519a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowDeleteMessageCallbackIDLStubWrapper r103 = (FlowDeleteMessageCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowDeleteMessageCallbackIDLStubWrapper) == false) goto L16;
        FlowDeleteMessageCallbackIDLStubWrapper r105 = new FlowDeleteMessageCallbackIDLStubWrapper(((FlowDeleteMessageCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new d1());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowDeleteMessageCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowDeleteMessageCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new c1(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowDeleteMessageCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowDeleteMessageCallbackIDL b(IFlowDeleteMessageCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowDeleteMessageCallbackIDLIpcWrapper) == false) goto L7;
        return new FlowDeleteMessageCallbackIDLIpcWrapper(((FlowDeleteMessageCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowDeleteMessageCallbackIDLIpcWrapper(r100, true);
    }
}
