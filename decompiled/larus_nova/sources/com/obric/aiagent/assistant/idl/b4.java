package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<ImageXUploadCallbackIDLStubWrapper>> f384496a = null;

    static {
        f384496a = new LinkedHashMap();
    }

    public static final IImageXUploadCallbackIDL.Stub a(final IImageXUploadCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<ImageXUploadCallbackIDLStubWrapper>> r101 = f384496a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        ImageXUploadCallbackIDLStubWrapper r103 = (ImageXUploadCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof ImageXUploadCallbackIDLStubWrapper) == false) goto L16;
        ImageXUploadCallbackIDLStubWrapper r105 = new ImageXUploadCallbackIDLStubWrapper(((ImageXUploadCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new a4());     // Catch: Throwable -> L22
        int r106 = com.obric.aiagent.ipc.utils.e.f384738a;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.e.a("IImageXUploadCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<ImageXUploadCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new z3(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new ImageXUploadCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IImageXUploadCallbackIDL b(IImageXUploadCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ImageXUploadCallbackIDLIpcWrapper) == false) goto L7;
        return new ImageXUploadCallbackIDLIpcWrapper(((ImageXUploadCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new ImageXUploadCallbackIDLIpcWrapper(r100, true);
    }
}
