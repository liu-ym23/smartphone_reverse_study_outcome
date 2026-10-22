package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<ScreenshotCallbackIDLStubWrapper>> f384584a = null;

    static {
        f384584a = new LinkedHashMap();
    }

    public static final IScreenshotCallbackIDL.Stub a(final IScreenshotCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<ScreenshotCallbackIDLStubWrapper>> r101 = f384584a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        ScreenshotCallbackIDLStubWrapper r103 = (ScreenshotCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof ScreenshotCallbackIDLStubWrapper) == false) goto L16;
        ScreenshotCallbackIDLStubWrapper r105 = new ScreenshotCallbackIDLStubWrapper(((ScreenshotCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new t4());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IScreenshotCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<ScreenshotCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new s4(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new ScreenshotCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IScreenshotCallbackIDL b(IScreenshotCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ScreenshotCallbackIDLIpcWrapper) == false) goto L7;
        return new ScreenshotCallbackIDLIpcWrapper(((ScreenshotCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new ScreenshotCallbackIDLIpcWrapper(r100, true);
    }
}
