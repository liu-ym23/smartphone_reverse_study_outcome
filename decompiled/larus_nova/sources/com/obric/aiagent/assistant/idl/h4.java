package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<ObricActionResultCallbackIDLStubWrapper>> f384532a = null;

    static {
        f384532a = new LinkedHashMap();
    }

    public static final IObricActionResultCallbackIDL.Stub a(final IObricActionResultCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<ObricActionResultCallbackIDLStubWrapper>> r101 = f384532a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        ObricActionResultCallbackIDLStubWrapper r103 = (ObricActionResultCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof ObricActionResultCallbackIDLStubWrapper) == false) goto L16;
        ObricActionResultCallbackIDLStubWrapper r105 = new ObricActionResultCallbackIDLStubWrapper(((ObricActionResultCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new g4());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IObricActionResultCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<ObricActionResultCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new f4(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new ObricActionResultCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IObricActionResultCallbackIDL b(IObricActionResultCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ObricActionResultCallbackIDLIpcWrapper) == false) goto L7;
        return new ObricActionResultCallbackIDLIpcWrapper(((ObricActionResultCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new ObricActionResultCallbackIDLIpcWrapper(r100, true);
    }
}
