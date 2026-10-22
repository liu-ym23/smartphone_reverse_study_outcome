package hg3;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f485004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> f485005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.b f485006c;

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "logModel");
        WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> r101 = this.f485005b;
        if (r101 == null) goto L6;
        com.bytedance.android.shopping.orderlist.common.monitor.error.b r102 = r101.get();
        if (r102 == null) goto L6;
    L7:
        if (r102 == null) goto L10;
        r102.b("ies_ecommerce_fe_custom_log", MapsKt.plus(r100.f485003a, this.f485004a));
        return;
    L10:
        return;
    L6:
        r102 = this.f485006c;
        goto L7
    }

    public b(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> r100, com.bytedance.android.shopping.orderlist.common.monitor.error.b r101) {
        this.f485005b = r100;
        this.f485006c = r101;
        this.f485004a = new LinkedHashMap();
    }
}
