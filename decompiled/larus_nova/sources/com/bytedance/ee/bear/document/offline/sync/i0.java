package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.ss.android.lark.log.Log;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i0<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0<T> f220606a = null;

    static {
        f220606a = new i0();
    }

    public i0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        OfflineDoc r102 = (OfflineDoc) r100;
        OfflineDoc r103 = (OfflineDoc) r101;
        Intrinsics.checkNotNullParameter(r102, DevicePlans.DEVICE_PLAN_OPPO1);
        Intrinsics.checkNotNullParameter(r103, DevicePlans.DEVICE_PLAN_OPPO2);
        if (r102.getPreload_priority() == r103.getPreload_priority()) goto L6;
        return r102.getPreload_priority() - r103.getPreload_priority();
    L6:
        if (t25.d.f544232b != null) goto L11;
        Boolean r104 = ((xm4.a.InterfaceC8255a) org.koin.java.a.c(xm4.a.InterfaceC8255a.class, null, null, 6)).a(t25.b.class.getName());
        if (r104 != null) goto L10;
        r104 = Boolean.FALSE;
    L10:
        t25.d.f544232b = r104;
        Log.i("PreloadTaskOptConfig", "isEnableFILO: " + r104);
    L11:
        Boolean r105 = t25.d.f544232b;
        if (r105 == null) goto L14;
        boolean r106 = r105.booleanValue();
    L15:
        if (r106 == true) goto L20;
        return 0;
    L20:
        return (int) (r103.getPreloadManagerEnqueueTime() - r102.getPreloadManagerEnqueueTime());
    L14:
        r106 = false;
        goto L15
    }
}
