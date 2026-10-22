package com.bytedance.ee.bear.bitable.app.chameleon;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {
    public static final d a(Object r100) {
        if ((r100 instanceof d) == true) goto L23;
        d r101 = null;
        if (r100 == null) goto L17;
        f r102 = f.f206915a;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);     // Catch: Throwable -> L18
        WeakHashMap<Object, WeakReference<d>> r103 = f.f206916b;     // Catch: Throwable -> L18
        WeakReference<d> r104 = r103.get(r100);     // Catch: Throwable -> L18
        if (r104 == null) goto L13;
        r101 = r104.get();     // Catch: Throwable -> L18
    L13:
        if (r101 != null) goto L15;
        r103.remove(r100);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r102);
    L18:
        th = move-exception;
        throw th;
    L17:
        return r101;
    L23:
        return (d) r100;
    }
}
