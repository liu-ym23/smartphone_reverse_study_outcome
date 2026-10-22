package com.ss.android.ugc.route_monitor.impl.route_in;

import android.text.TextUtils;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, u> f454558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f454559b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.ss.android.ugc.route_monitor.utils.j<jhc.j> f454560c;

    static {
        f454558a = new ConcurrentHashMap();
        f454559b = new LinkedHashSet();
    }

    public static List c() {
        ConcurrentHashMap<String, u> r100 = f454558a;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, u>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getValue());
        goto L4
    L6:
        return r101;
    }

    public static void a(u r100) {
        Logger r101 = Logger.f454747c;
        String r102 = r100.f454585y;
        r101.b();
        String r103 = r100.f454585y;
        f454558a.remove(r103);
        RouteMonitorManager r104 = RouteMonitorManager.f454384g;
        r104.getClass();
        i r105 = (i) RouteMonitorManager.f454382e.getValue(r104, RouteMonitorManager.f454378a[2]);
        if (r105 == null) goto L5;
        r105.c(new com.ss.android.ugc.route_monitor.b(r103));
    L5:
        f454559b.add(r103);
        q r106 = q.f454556c;
        String r107 = r100.f454585y;
        r106.getClass();
        if (TextUtils.isEmpty(r107) == true) goto L10;
        Throwable r108 = new Throwable();
        r106.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.g(r106, r107, r108));
        return;
    }

    public static u b(String r100) {
        u r101 = f454558a.get(r100);
        Logger r102 = Logger.f454747c;
        if (r101 == null) goto L5;
        com.ss.android.ugc.route_monitor.impl.launch_info.f r103 = r101.f454586z;
    L6:
        Objects.toString(r103);
        Objects.toString(r101);
        r102.b();
        return r101;
    L5:
        r103 = null;
        goto L6
    }
}
