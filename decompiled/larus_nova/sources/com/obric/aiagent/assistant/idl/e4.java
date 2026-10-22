package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> f384521a = null;

    static {
        f384521a = new LinkedHashMap();
    }

    public static final IMusicStateListenerIDL.Stub a(final IMusicStateListenerIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> r101 = f384521a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        MusicStateListenerIDLStubWrapper r103 = (MusicStateListenerIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof MusicStateListenerIDLStubWrapper) == false) goto L16;
        MusicStateListenerIDLStubWrapper r105 = new MusicStateListenerIDLStubWrapper(((MusicStateListenerIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new d4());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IMusicStateListenerIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<MusicStateListenerIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new c4(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new MusicStateListenerIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IMusicStateListenerIDL b(IMusicStateListenerIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof MusicStateListenerIDLIpcWrapper) == false) goto L7;
        return new MusicStateListenerIDLIpcWrapper(((MusicStateListenerIDLIpcWrapper) r100).origin, true);
    L7:
        return new MusicStateListenerIDLIpcWrapper(r100, true);
    }
}
