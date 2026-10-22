package com.ss.android.lark.appcontext.applifecycle;

import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f408854c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<u, Object> f408855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<v, Object> f408856b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f408857a = null;

        static {
            f408857a = new q();
        }
    }

    static {
        f408854c = new Object();
    }

    public q() {
        this.f408855a = new ConcurrentHashMap();
        this.f408856b = new ConcurrentHashMap();
    }

    public final void a(v r100) {
        if (r100 != null) goto L5;
        Log.w("ConfigurationChangedManager", "registerOnChangedListener listener is null");
        return;
    L5:
        Map<v, Object> r101 = this.f408856b;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, f408854c);
    }

    public final void b(v r100) {
        if (r100 != null) goto L5;
        Log.w("ConfigurationChangedManager", "unregisterOnChangedListener listener is null");
        return;
    L5:
        ((ConcurrentHashMap) this.f408856b).remove(r100);
    }
}
