package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import com.obric.aiagent.ipc.utils.e;
import com.obric.aiagent.ipc.utils.g;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<FileIDLStubWrapper>> f384706a = null;

    static {
        f384706a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IFileIDL.Stub a(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final FileIDLStub r101 = new FileIDLStub();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<IBinder, WeakReference<FileIDLStubWrapper>> r102 = f384706a;
        monitor-enter(r102);
        WeakReference r103 = (WeakReference) ((LinkedHashMap) r102).get(r101.asBinder());     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        FileIDLStubWrapper r104 = (FileIDLStubWrapper) r103.get();     // Catch: Throwable -> L25
        if (r104 == null) goto L11;
        r104.log = true;     // Catch: Throwable -> L25
        monitor-exit(r102);
    L21:
        return r104;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r102);
        if ((r101 instanceof FileIDLStubWrapper) == false) goto L16;
        r104 = new FileIDLStubWrapper(((FileIDLStubWrapper) r101).origin, true);
    L17:
        monitor-enter(r102);
        CollectionsKt.removeAll(((LinkedHashMap) r102).entrySet(), new b());     // Catch: Throwable -> L22
        int r106 = e.f384738a;     // Catch: Throwable -> L22
        e.a("IFileIDL", "Stub.wrap, (" + r104 + ')');     // Catch: Throwable -> L22
        WeakReference<FileIDLStubWrapper> r107 = r102.put(r101.asBinder(), new WeakReference(r104));     // Catch: Throwable -> L22
        monitor-exit(r102);
        r104.linkToDeath(new a(r101), 0);
    L22:
        th = move-exception;
        throw th;
    L16:
        r104 = new FileIDLStubWrapper(r101, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static IFileIDL b(IFileIDL r100) {
        if (r100 != null) goto L4;
        e.b("IFileIDL", "registerAsIPC failed, IPC is null", null);
        return null;
    L4:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof FileIDLIpcWrapper) == false) goto L7;
        FileIDLIpcWrapper r101 = new FileIDLIpcWrapper(((FileIDLIpcWrapper) r100).origin, true);
    L8:
        FileIDLIpcWrapper r102 = r101;
        g.f384740a.getClass();
        g.d(IFileIDL.class, r102);
        return r102;
    L7:
        r101 = new FileIDLIpcWrapper(r100, true);
        goto L8
    }
}
