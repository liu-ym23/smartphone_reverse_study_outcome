package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<j> f525808d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f525809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f525810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f525811c;

    static {
        f525808d = new ArrayList();
    }

    public j(Object r100, o r101) {
        this.f525809a = r100;
        this.f525810b = r101;
    }

    public static j a(o r100, Object r101) {
        List<j> r102 = f525808d;
        monitor-enter(r102);
        int r103 = ((ArrayList) r102).size();     // Catch: Throwable -> L14
        if (r103 <= 0) goto L9;
        j r104 = (j) ((ArrayList) r102).remove(r103 - 1);     // Catch: Throwable -> L14
        r104.f525809a = r101;     // Catch: Throwable -> L14
        r104.f525810b = r100;     // Catch: Throwable -> L14
        r104.f525811c = null;     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return r104;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return new j(r101, r100);
    L14:
        th = move-exception;
        throw th;
    }
}
