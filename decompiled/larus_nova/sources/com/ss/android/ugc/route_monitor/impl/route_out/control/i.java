package com.ss.android.ugc.route_monitor.impl.route_out.control;

import com.ss.android.ugc.route_monitor.utils.Logger;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454634a = 0;

    static {
    }

    public static void a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        Logger.f454747c.e();
        return;
    L9:
        mhc.b r102 = j.f454635a;
        c r103 = new c(r100, true, 4);
        Logger r104 = Logger.f454747c;
        r103.toString();
        r104.b();
        e r105 = j.f454637c;
        monitor-enter(r105);
        r105.f454621a.add(r103);     // Catch: Throwable -> L15
        monitor-exit(r105);
        a.t(r103);
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        r101 = false;
        goto L6
    }
}
