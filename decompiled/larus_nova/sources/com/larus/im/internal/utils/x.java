package com.larus.im.internal.utils;

import com.larus.im.service.audio.autotest.DataType;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f350563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f350564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f350565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f350566d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y f350567e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f350568f = null;

    public x() {
    }

    static {
        f350563a = new x();
        f350564b = "";
        f350565c = new ReentrantLock();
        f350566d = new y("video");
        f350567e = new y("audio");
        f350568f = new y("screenShare");
    }

    public final byte[] a(int r100, DataType r101) {
        Intrinsics.checkNotNullParameter(r101, "dataType");
        byte[] r102 = new byte[r100];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102[r103] = 0;
        r103 = r103 + 1;
        goto L3
    L5:
        ReentrantLock r104 = f350565c;
        r104.lock();
        DataType r105 = DataType.MIC;     // Catch: Throwable -> L9
        fe9.c.f476624a.f("RtcAutoTestUtil", "[getHookData]: dataType = " + r101 + ", frameSize = " + r100 + ", data is null");     // Catch: Throwable -> L9
        r104.unlock();
        return r102;
    L9:
        th = move-exception;
        r104.unlock();
        throw th;
    }
}
