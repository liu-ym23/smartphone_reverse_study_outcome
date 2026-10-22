package vw7;

import android.content.Context;
import android.os.Handler;
import com.hihonor.mcs.system.diagnosis.core.BinderCallbackWrapper;
import com.hihonor.mcs.system.diagnosis.core.f;
import com.hihonor.mcs.system.diagnosis.core.pressure.PressureCallback;
import com.hihonor.mcs.system.diagnosis.core.pressure.Resource;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f557445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<PressureCallback, WeakReference<BinderCallbackWrapper>> f557446c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f557447d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f557448a;

    static {
        f557446c = new WeakHashMap();
    }

    public b() {
        this.f557448a = null;
    }

    public static b a(Context r100) {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f557445b != null) goto L7;
        f557445b = new b();     // Catch: Throwable -> L10
    L7:
        f557447d = new Handler(r100.getMainLooper());     // Catch: Throwable -> L10
        b r101 = f557445b;     // Catch: Throwable -> L10
        r101.f557448a = f.f(r100);     // Catch: Throwable -> L10
        b r102 = f557445b;     // Catch: Throwable -> L10
        monitor-exit(b.class);     // Catch: Throwable -> L10
        return r102;
    }

    public final void b(Resource r100, PressureCallback r101, com.douyin.janna.platform.a.c r102) {
        Objects.requireNonNull(r101, "pressureCallback must not be null.");
        Handler r103 = r102;
        if (r102 != null) goto L6;
        r103 = f557447d;
    L6:
        com.hihonor.mcs.system.diagnosis.core.a r104 = new com.hihonor.mcs.system.diagnosis.core.a(r103);
        WeakHashMap<PressureCallback, WeakReference<BinderCallbackWrapper>> r105 = f557446c;
        monitor-enter(r105);
        WeakReference<BinderCallbackWrapper> r106 = r105.get(r101);     // Catch: Throwable -> L17
        if (r106 == null) goto L11;
        BinderCallbackWrapper r107 = r106.get();     // Catch: Throwable -> L17
    L12:
        if (r107 != null) goto L14;
        r107 = new BinderCallbackWrapper(r101);     // Catch: Throwable -> L17
        r105.put(r101, new WeakReference(r107));     // Catch: Throwable -> L17
    L14:
        monitor-exit(r105);     // Catch: Throwable -> L17
        r107.setExecutor(r104);
        this.f557448a.k(r100, r107, r104);
        return;
    L11:
        r107 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final void c(PressureCallback r100) {
        Objects.requireNonNull(r100, "pressureCallback must not be null.");
        WeakHashMap<PressureCallback, WeakReference<BinderCallbackWrapper>> r101 = f557446c;
        monitor-enter(r101);
        WeakReference<BinderCallbackWrapper> r102 = r101.get(r100);     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        BinderCallbackWrapper r103 = r102.get();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r103 != null) goto L12;
        r100.toString();
        return;
    L12:
        this.f557448a.o(r103);
        return;
    L7:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }
}
