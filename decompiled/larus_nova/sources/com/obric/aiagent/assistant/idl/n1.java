package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowFindMessagesCallbackIDLStubWrapper>> f384556a = null;

    static {
        f384556a = new LinkedHashMap();
    }

    public static final IFlowFindMessagesCallbackIDL.Stub a(final IFlowFindMessagesCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<FlowFindMessagesCallbackIDLStubWrapper>> r101 = f384556a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        FlowFindMessagesCallbackIDLStubWrapper r103 = (FlowFindMessagesCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof FlowFindMessagesCallbackIDLStubWrapper) == false) goto L16;
        FlowFindMessagesCallbackIDLStubWrapper r105 = new FlowFindMessagesCallbackIDLStubWrapper(((FlowFindMessagesCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new m1());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowFindMessagesCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowFindMessagesCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new l1(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new FlowFindMessagesCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IFlowFindMessagesCallbackIDL b(IFlowFindMessagesCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FlowFindMessagesCallbackIDLIpcWrapper) == false) goto L7;
        return new FlowFindMessagesCallbackIDLIpcWrapper(((FlowFindMessagesCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new FlowFindMessagesCallbackIDLIpcWrapper(r100, true);
    }
}
