package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowNetworkIDLStubWrapper>> f384572a = null;

    static {
        f384572a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IFlowNetworkIDL.Stub a(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final FlowNetworkIDLStub r101 = new FlowNetworkIDLStub();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<IBinder, WeakReference<FlowNetworkIDLStubWrapper>> r102 = f384572a;
        monitor-enter(r102);
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r101.asBinder());     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        FlowNetworkIDLStubWrapper r104 = (FlowNetworkIDLStubWrapper) r103.get();     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
        r104.log = true;     // Catch: Throwable -> L25
        monitor-exit(r102);
    L21:
        return r104;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r102);
        if ((r101 instanceof FlowNetworkIDLStubWrapper) == false) goto L16;
        r104 = new FlowNetworkIDLStubWrapper(((FlowNetworkIDLStubWrapper) r101).origin, true);
    L17:
        monitor-enter(r102);
        CollectionsKt.removeAll(((LinkedHashMap) r102).entrySet(), new q2());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowNetworkIDL", "Stub.wrap, (" + r104 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowNetworkIDLStubWrapper> r107 = r102.put(r101.asBinder(), new WeakReference(r104));     // Catch: Throwable -> L22
        monitor-exit(r102);
        r104.linkToDeath(new p2(r101), 0);
    L22:
        th = move-exception;
        throw th;
    L16:
        r104 = new FlowNetworkIDLStubWrapper(r101, true);
    L25:
        th = move-exception;
        throw th;
    }
}
