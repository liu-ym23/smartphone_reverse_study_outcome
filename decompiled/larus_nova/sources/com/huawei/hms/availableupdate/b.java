package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f276991b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f276992c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Activity> f276993a;

    static {
        f276991b = new b();
        f276992c = new Object();
    }

    public b() {
        this.f276993a = new ArrayList(1);
    }

    public void a(Activity r100) {
        Object r101 = f276992c;
        monitor-enter(r101);
        Iterator<Activity> r102 = this.f276993a.iterator();     // Catch: Throwable -> L16
    L6:
        if (r102.hasNext() == false) goto L13;
        Activity r103 = r102.next();     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        if (r103 == r100) goto L6;
        if (r103.isFinishing() == true) goto L6;
        r103.finish();     // Catch: Throwable -> L16
        goto L6
    L13:
        this.f276993a.add(r100);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void b(Activity r100) {
        Object r101 = f276992c;
        monitor-enter(r101);
        this.f276993a.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
