package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<OpenRealTimeCallCallbackIDLStubWrapper>> f384545a = null;

    static {
        f384545a = new LinkedHashMap();
    }

    public static final IOpenRealTimeCallCallbackIDL.Stub a(final IOpenRealTimeCallCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<OpenRealTimeCallCallbackIDLStubWrapper>> r101 = f384545a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        OpenRealTimeCallCallbackIDLStubWrapper r103 = (OpenRealTimeCallCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof OpenRealTimeCallCallbackIDLStubWrapper) == false) goto L16;
        OpenRealTimeCallCallbackIDLStubWrapper r105 = new OpenRealTimeCallCallbackIDLStubWrapper(((OpenRealTimeCallCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new j4());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IOpenRealTimeCallCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<OpenRealTimeCallCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new i4(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new OpenRealTimeCallCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IOpenRealTimeCallCallbackIDL b(IOpenRealTimeCallCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof OpenRealTimeCallCallbackIDLIpcWrapper) == false) goto L7;
        return new OpenRealTimeCallCallbackIDLIpcWrapper(((OpenRealTimeCallCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new OpenRealTimeCallCallbackIDLIpcWrapper(r100, true);
    }
}
