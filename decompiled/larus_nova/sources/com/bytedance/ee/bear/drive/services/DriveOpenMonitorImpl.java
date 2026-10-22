package com.bytedance.ee.bear.drive.services;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveOpenMonitorImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f224600a = null;

    static {
        f224600a = LazyKt.lazy(DriveOpenMonitorImpl$driveOpenMonitors$2.INSTANCE);
    }

    public static void a() {
        Iterator r100 = ((List) f224600a.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        d0 r101 = (d0) ((WeakReference) r100.next()).get();
        if (r101 == null) goto L4;
        r101.k();
        goto L4
    }
}
