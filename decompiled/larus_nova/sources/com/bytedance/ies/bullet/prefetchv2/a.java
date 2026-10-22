package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f247510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f247511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h> f247512c = null;

    public a() {
    }

    static {
        f247510a = new a();
        f247511b = new ConcurrentHashMap();
        f247512c = new ConcurrentHashMap();
    }

    public static h b(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        h r101 = f247512c.get(r100);
        int r102 = j.f247548a;
        j.a("Get config cache by identifier: " + r100 + ", config: " + r101);
        return r101;
    }

    public final h a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        String r101 = c(this, r100);
        h r102 = f247511b.get(r101);
        int r103 = j.f247548a;
        j.a("Get config cache by schema uri: " + r100 + ", configKey: " + r101 + ", config: " + r102);
        return r102;
    }

    public static String c(a r100, Uri r101) {
        r100.getClass();
        String r102 = a36.b.a(r101, "default_bid");
        String r103 = a36.b.e(r101, "prefetch_channel");
        String r104 = a36.b.e(r101, "prefetch_bundle");
        boolean r105 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == true) goto L15;
        if (r104 != null) goto L12;
    L13:
        r105 = true;
    L14:
        if (r105 == true) goto L15;
    L16:
        String r107 = a36.b.e(r101, "prefetch_ak");
        StringBuilder r108 = new StringBuilder();
        String r109 = null;
        if (r102 == null) goto L19;
        String r110 = c.b(r102, "prefetch.json");
    L20:
        r108.append(r110);
        r108.append('_');
        r108.append(r103);
        r108.append('_');
        if (r104 == null) goto L23;
        r109 = c.a(r104, "prefetch.json");
    L23:
        r108.append(r109);
        r108.append('_');
        r108.append(r107);
        return r108.toString();
    L19:
        r110 = null;
        goto L20
    L12:
        if (r104.length() != 0) goto L14;
    L15:
        r103 = a36.b.e(r101, "channel");
        r104 = a36.b.e(r101, "bundle");
        goto L16
    L5:
        if (r103.length() == 0) goto L8;
        r106 = false;
        goto L9
    }
}
