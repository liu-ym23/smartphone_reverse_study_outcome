package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import com.obric.aiagent.ipc.utils.e;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<IBinder, WeakReference<AHMCallbackIDLStubWrapper>> f554565a = null;

    static {
        f554565a = new LinkedHashMap();
    }

    public static final IAHMCallbackIDL.Stub a(final IAHMCallbackIDL.Stub r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<IBinder, WeakReference<AHMCallbackIDLStubWrapper>> r101 = f554565a;
        monitor-enter(r101);
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100.asBinder());     // Catch: Throwable -> L25
        if (r102 == null) goto L11;
        AHMCallbackIDLStubWrapper r103 = (AHMCallbackIDLStubWrapper) r102.get();     // Catch: Throwable -> L25
        if (r103 == null) goto L11;
        r103.log = true;     // Catch: Throwable -> L25
        monitor-exit(r101);
        return r103;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r101);
        if ((r100 instanceof AHMCallbackIDLStubWrapper) == false) goto L16;
        AHMCallbackIDLStubWrapper r105 = new AHMCallbackIDLStubWrapper(((AHMCallbackIDLStubWrapper) r100).origin, true);
    L17:
        monitor-enter(r101);
        CollectionsKt.removeAll(((LinkedHashMap) r101).entrySet(), new b());     // Catch: Throwable -> L22
        int r106 = e.f384738a;     // Catch: Throwable -> L22
        e.a("IAHMCallbackIDL", "Stub.wrap, (" + r105 + ')');     // Catch: Throwable -> L22
        WeakReference<AHMCallbackIDLStubWrapper> r107 = r101.put(r100.asBinder(), new WeakReference(r105));     // Catch: Throwable -> L22
        monitor-exit(r101);
        r105.linkToDeath(new a(r100), 0);
        return r105;
    L22:
        th = move-exception;
        throw th;
    L16:
        r105 = new AHMCallbackIDLStubWrapper(r100, true);
    L25:
        th = move-exception;
        throw th;
    }

    public static final IAHMCallbackIDL b(IAHMCallbackIDL r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AHMCallbackIDLIpcWrapper) == false) goto L7;
        return new AHMCallbackIDLIpcWrapper(((AHMCallbackIDLIpcWrapper) r100).origin, true);
    L7:
        return new AHMCallbackIDLIpcWrapper(r100, true);
    }
}
