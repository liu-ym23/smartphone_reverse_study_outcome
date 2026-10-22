package com.bytedance.bdp.appbase.ui.toast;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, WeakReference<com.bytedance.bdp.appbase.ui.toast.a>> f201081a;

    public static final class a {
    }

    static {
        new b();
    }

    public b() {
        this.f201081a = new ConcurrentHashMap();
    }

    public static final void a(b r100) {
        ConcurrentHashMap<Integer, WeakReference<com.bytedance.bdp.appbase.ui.toast.a>> r101 = r100.f201081a;
        monitor-enter(r101);
        Iterator<WeakReference<com.bytedance.bdp.appbase.ui.toast.a>> r102 = r100.f201081a.values().iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        if (r102.next().get() == null) goto L6;
        throw null;     // Catch: Throwable -> L15
    L12:
        r100.f201081a.clear();     // Catch: Throwable -> L15
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
