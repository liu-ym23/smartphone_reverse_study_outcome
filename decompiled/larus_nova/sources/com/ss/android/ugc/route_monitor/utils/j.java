package com.ss.android.ugc.route_monitor.utils;

import com.ss.android.ugc.route_monitor.utils.j.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class j<T extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f454776a;

    public interface a<T extends b> {
        void call(T r100);
    }

    public interface b {
    }

    public j() {
        this.f454776a = new ArrayList();
    }

    public final void a(T r100) {
        monitor-enter(this);
        Iterator r101 = ((ArrayList) this.f454776a).iterator();     // Catch: Throwable -> L15
    L5:
        if (r101.hasNext() == false) goto L9;
        b r102 = (b) r101.next();     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r100, r102) == false) goto L5;
    L10:
        if (r102 != null) goto L12;
        ((ArrayList) this.f454776a).add(r100);     // Catch: Throwable -> L15
    L12:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L9:
        r102 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final void b(a<T> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList(this.f454776a);     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.call((b) r103.next());
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void c(T r100) {
        monitor-enter(this);
        ((ArrayList) this.f454776a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
