package v74;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m74.b f553480a;

    public c(Context r100, d r101, boolean r102) {
        this.f553480a = new m74.b(r100, new a(r100), r101, r102);
    }

    public final Map<String, String> a(String r100, DTraitRiskType r110, int r111) {
        m74.b r101 = this.f553480a;
        r101.getClass();
        if (n74.a.f518199a == false) goto L76;
        long r102 = System.currentTimeMillis();
        Map<String, m74.b.C6778b> r103 = r101.f512336d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        m74.b.C6778b r105 = (m74.b.C6778b) r104.get(r110.getValue());
        if (r105 == null) goto L11;
        if (r105.a() == false) goto L11;
        return r105.f512343a;
    L11:
        if (r101.f512337e.compareAndSet(false, true) == true) goto L70;
        long r106 = ((long) r111) - (System.currentTimeMillis() - r102);
        if (r106 <= 0) goto L62;
        Object r107 = r101.f512338f;
        monitor-enter(r107);
        r101.f512338f.wait(r106);     // Catch: Throwable -> L51 InterruptedException -> L53
    L54:
        monitor-exit(r107);     // Catch: Throwable -> L51
        Map<String, m74.b.C6778b> r108 = r101.f512336d;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;
        r105 = (m74.b.C6778b) r109.get(r110.getValue());
        if (r105 == null) goto L62;
        if (r105.a() == false) goto L62;
        return r105.f512343a;
    L53:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L62:
        if (r105 == null) goto L65;
        return r105.f512343a;
    L65:
        return new HashMap();
    L70:
        Map<String, m74.b.C6778b> r112 = r101.f512336d;     // Catch: Throwable -> L36
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;     // Catch: Throwable -> L36
        m74.b.C6778b r114 = (m74.b.C6778b) r113.get(r110.getValue());     // Catch: Throwable -> L36
        if (r114 != null) goto L15;
    L25:
        Map<String, String> r115 = r101.a(r100, r110, r111);     // Catch: Throwable -> L36
        if (((HashMap) r115).isEmpty() == true) goto L28;
        Map<String, m74.b.C6778b> r116 = r101.f512336d;     // Catch: Throwable -> L36
        ConcurrentHashMap r117 = (ConcurrentHashMap) r116;     // Catch: Throwable -> L36
        r117.put(r110.getValue(), new m74.b.C6778b(r115));     // Catch: Throwable -> L36
    L28:
        r101.f512337e.set(false);
        Object r118 = r101.f512338f;
        monitor-enter(r118);
        r101.f512338f.notifyAll();     // Catch: Throwable -> L33
        monitor-exit(r118);     // Catch: Throwable -> L33
        return r115;
    L33:
        th = move-exception;
        throw th;
    L15:
        if (r114.a() == false) goto L25;
        Map<String, String> r119 = r114.f512343a;     // Catch: Throwable -> L36
        r101.f512337e.set(false);
        Object r120 = r101.f512338f;
        monitor-enter(r120);
        r101.f512338f.notifyAll();     // Catch: Throwable -> L22
        monitor-exit(r120);     // Catch: Throwable -> L22
        return r119;
    L22:
        th = move-exception;
        throw th;
    L36:
        th = move-exception;
        r101.f512337e.set(false);
        monitor-enter(r101.f512338f);
        r101.f512338f.notifyAll();     // Catch: Throwable -> L42
        throw th;
    L42:
        th = move-exception;
        throw th;
    L76:
        return new HashMap();
    }
}
