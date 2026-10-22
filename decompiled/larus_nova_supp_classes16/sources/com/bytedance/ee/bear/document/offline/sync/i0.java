package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.ss.android.lark.log.Log;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i0<T> implements Comparator {
    public static final i0<T> a = null;

    static {
        a = new i0();
    }

    public i0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r4, Object r5) {
        OfflineDoc r6 = (OfflineDoc) r4;
        OfflineDoc r7 = (OfflineDoc) r5;
        Intrinsics.checkNotNullParameter(r6, "o1");
        Intrinsics.checkNotNullParameter(r7, "o2");
        if (r6.getPreload_priority() == r7.getPreload_priority()) goto L6;
        return r6.getPreload_priority() - r7.getPreload_priority();
    L6:
        if (t25.d.b != null) goto L11;
        Boolean r0 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).a(t25.b.class.getName());
        if (r0 != null) goto L10;
        r0 = Boolean.FALSE;
    L10:
        t25.d.b = r0;
        Log.i("PreloadTaskOptConfig", "isEnableFILO: " + r0);
    L11:
        Boolean r1 = t25.d.b;
        if (r1 == null) goto L14;
        boolean r2 = r1.booleanValue();
    L15:
        if (r2 == true) goto L20;
        return 0;
    L20:
        return (int) (r7.getPreloadManagerEnqueueTime() - r6.getPreloadManagerEnqueueTime());
    L14:
        r2 = false;
        goto L15
    }
}
