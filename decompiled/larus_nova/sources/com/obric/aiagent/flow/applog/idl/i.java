package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FlowAppLogIDLStubWrapper>> f384671a = null;

    static {
        f384671a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IFlowAppLogIDL.Stub a(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final FlowAppLogIDLStub r101 = new FlowAppLogIDLStub();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<IBinder, WeakReference<FlowAppLogIDLStubWrapper>> r102 = f384671a;
        monitor-enter(r102);
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r101.asBinder());     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        FlowAppLogIDLStubWrapper r104 = (FlowAppLogIDLStubWrapper) r103.get();     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
        r104.log = true;     // Catch: Throwable -> L25
        monitor-exit(r102);
    L21:
        return r104;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r102);
        if ((r101 instanceof FlowAppLogIDLStubWrapper) == false) goto L16;
        r104 = new FlowAppLogIDLStubWrapper(((FlowAppLogIDLStubWrapper) r101).origin, true);
    L17:
        monitor-enter(r102);
        CollectionsKt.removeAll(((LinkedHashMap) r102).entrySet(), new h());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IFlowAppLogIDL", "Stub.wrap, (" + r104 + ')');     // Catch: Throwable -> L22
        WeakReference<FlowAppLogIDLStubWrapper> r107 = r102.put(r101.asBinder(), new WeakReference(r104));     // Catch: Throwable -> L22
        monitor-exit(r102);
        r104.linkToDeath(new g(r101), 0);
    L22:
        th = move-exception;
        throw th;
    L16:
        r104 = new FlowAppLogIDLStubWrapper(r101, true);
    L25:
        th = move-exception;
        throw th;
    }
}
