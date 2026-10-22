package com.ss.android.ugc.route_monitor.utils;

import android.app.ActivityThread;

/* JADX INFO: loaded from: classes40.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f454782a;

    public static String a() {
        return ActivityThread.currentProcessName();
    L4:
        th = move-exception;
        Logger.f454747c.d(th);
        return null;
    }

    static {
    }
}
