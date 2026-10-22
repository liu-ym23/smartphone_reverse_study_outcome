package com.bytedance.ee.bear.drive.services;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveOpenMonitorImpl {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(DriveOpenMonitorImpl$driveOpenMonitors$2.INSTANCE);
    }

    public static void a() {
        Iterator r0 = ((List) a.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        d0 r1 = (d0) ((WeakReference) r0.next()).get();
        if (r1 == null) goto L4;
        r1.k();
        goto L4
    }
}
