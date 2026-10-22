package vw7;

import android.content.Context;
import android.os.Handler;
import com.douyin.janna.platform.HONORProcessor;
import com.hihonor.mcs.system.diagnosis.core.ShareMemoryCallbackWrapper;
import com.hihonor.mcs.system.diagnosis.core.f;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermal;
import com.hihonor.mcs.system.diagnosis.core.stability.Stability;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f557440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f557441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WeakHashMap<uw7.a, WeakReference<ShareMemoryCallbackWrapper>> f557442d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final WeakHashMap<tw7.a, WeakReference<ShareMemoryCallbackWrapper>> f557443e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f557444a;

    static {
        f557442d = new WeakHashMap();
        new WeakHashMap();
        f557443e = new WeakHashMap();
    }

    public a() {
        this.f557444a = null;
    }

    public static a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f557440b != null) goto L7;
        f557440b = new a();     // Catch: Throwable -> L10
    L7:
        f557441c = new Handler(r100.getMainLooper());     // Catch: Throwable -> L10
        a r101 = f557440b;     // Catch: Throwable -> L10
        r101.f557444a = f.f(r100);     // Catch: Throwable -> L10
        a r102 = f557440b;     // Catch: Throwable -> L10
        monitor-exit(a.class);     // Catch: Throwable -> L10
        return r102;
    }

    public final void b(PowerThermal r100, tw7.a r101, Handler r102) {
        Objects.requireNonNull(r101, "powerThermalCallback must not be null.");
        if (r102 != null) goto L6;
        r102 = f557441c;
    L6:
        com.hihonor.mcs.system.diagnosis.core.a r103 = new com.hihonor.mcs.system.diagnosis.core.a(r102);
        WeakHashMap<tw7.a, WeakReference<ShareMemoryCallbackWrapper>> r104 = f557443e;
        monitor-enter(r104);
        WeakReference<ShareMemoryCallbackWrapper> r105 = r104.get(r101);     // Catch: Throwable -> L17
        if (r105 == null) goto L11;
        ShareMemoryCallbackWrapper r106 = r105.get();     // Catch: Throwable -> L17
    L12:
        if (r106 != null) goto L14;
        r106 = new ShareMemoryCallbackWrapper(r101);     // Catch: Throwable -> L17
        r104.put(r101, new WeakReference(r106));     // Catch: Throwable -> L17
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L17
        r106.setExecutor(r103);
        this.f557444a.j(r100, r106, r103);
        return;
    L11:
        r106 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final void c(Stability r100, HONORProcessor.StabilityCallbackImpl r101, com.douyin.janna.platform.a.c r102) {
        if (r102 != null) goto L5;
        Handler r103 = f557441c;
    L5:
        com.hihonor.mcs.system.diagnosis.core.a r104 = new com.hihonor.mcs.system.diagnosis.core.a(r103);
        WeakHashMap<uw7.a, WeakReference<ShareMemoryCallbackWrapper>> r105 = f557442d;
        monitor-enter(r105);
        WeakReference<ShareMemoryCallbackWrapper> r106 = r105.get(r101);     // Catch: Throwable -> L16
        if (r106 == null) goto L10;
        ShareMemoryCallbackWrapper r107 = r106.get();     // Catch: Throwable -> L16
    L11:
        if (r107 != null) goto L13;
        r107 = new ShareMemoryCallbackWrapper(r101);     // Catch: Throwable -> L16
        r105.put(r101, new WeakReference(r107));     // Catch: Throwable -> L16
    L13:
        monitor-exit(r105);     // Catch: Throwable -> L16
        r107.setExecutor(r104);
        this.f557444a.l(r100, r107, r104);
        return;
    L10:
        r107 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final void d(HONORProcessor.PowerCallbackImpl r100) {
        WeakHashMap<tw7.a, WeakReference<ShareMemoryCallbackWrapper>> r101 = f557443e;
        monitor-enter(r101);
        WeakReference<ShareMemoryCallbackWrapper> r102 = r101.get(r100);     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        ShareMemoryCallbackWrapper r103 = r102.get();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        this.f557444a.n(r103);
        return;
    L11:
        return;
    L7:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final void e(HONORProcessor.StabilityCallbackImpl r100) {
        WeakHashMap<uw7.a, WeakReference<ShareMemoryCallbackWrapper>> r101 = f557442d;
        monitor-enter(r101);
        WeakReference<ShareMemoryCallbackWrapper> r102 = r101.get(r100);     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        ShareMemoryCallbackWrapper r103 = r102.get();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L14
        if (r103 == null) goto L11;
        this.f557444a.p(r103);
        return;
    L11:
        return;
    L7:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }
}
