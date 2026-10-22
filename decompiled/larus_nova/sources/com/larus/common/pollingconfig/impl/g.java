package com.larus.common.pollingconfig.impl;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f326459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f326460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f326461c;

    static {
    }

    public static Long a() {
        long r100 = f326459a;
        if (r100 <= 0) goto L12;
        long r101 = SystemClock.elapsedRealtime() + r100;
        if (f326460b <= 0) goto L11;
        if (r101 >= f326460b) goto L11;
        FLogger.f375446a.i("TimeManager", "[getCurrentTimeStamp] now invalid. now:" + r101 + ", lastServerTime:" + f326460b);
        return null;
    L11:
        return Long.valueOf(r101);
    L12:
        FLogger.f375446a.i("TimeManager", "[getCurrentTimeStamp] timeInterval invalid. timeInterval:" + r100);
        return null;
    }
}
