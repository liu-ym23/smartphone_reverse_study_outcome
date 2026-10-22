package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f457708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z.b<String, b> f457709b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f457710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f457711d = null;

    public a() {
    }

    static {
        f457711d = new a();
        f457708a = new b();
        f457709b = new z.b(false);
    }

    public final synchronized b a(Effect r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f457710c == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        f457708a.a(r100);     // Catch: Throwable -> L11
        b r101 = f457709b.remove(r100.getEffect_id());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public final synchronized String b(String r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f457710c == false) goto L6;
        String r101 = f457708a.c("None", r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L6:
        monitor-exit(this);
        return "null";
    }

    public final synchronized void c(Effect r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f457710c == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        Logger.INSTANCE.w("JKL", "[EffectBlock][start][" + r100.getName() + "][" + r100.getPanel() + ']');     // Catch: Throwable -> L15
        f457708a.update(r100);     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, b>> r101 = f457709b.entrySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().getValue().update(r100);     // Catch: Throwable -> L15
        goto L10
    L12:
        b r102 = new b();     // Catch: Throwable -> L15
        r102.f457712a.putAll(f457708a.f457712a);     // Catch: Throwable -> L15
        f457709b.put(r100.getEffect_id(), r102);     // Catch: Throwable -> L15
        monitor-exit(this);
    }
}
