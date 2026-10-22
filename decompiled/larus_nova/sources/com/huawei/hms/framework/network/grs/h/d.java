package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f277265a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f277266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f277267b;

        public a(long r100, long r101) {
            this.f277266a = r100;
            this.f277267b = r101;
        }

        public boolean a() {
            if ((SystemClock.elapsedRealtime() - this.f277267b) > this.f277266a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f277265a = new ConcurrentHashMap(16);
    }

    public static a a(String r100) {
        StringBuilder r101 = new StringBuilder("map size of get is before: ");
        Map<String, a> r102 = f277265a;
        r101.append(r102.size());
        Logger.v("RequestUtil", r101.toString());
        a r103 = r102.get(r100);
        Logger.v("RequestUtil", "map size of get is after: " + r102.size());
        return r103;
    }

    public static void a(String r100, a r101) {
        StringBuilder r102 = new StringBuilder("map size of put is before: ");
        Map<String, a> r103 = f277265a;
        r102.append(r103.size());
        Logger.v("RequestUtil", r102.toString());
        r103.put(r100, r101);
        Logger.v("RequestUtil", "map size of put is after: " + r103.size());
    }
}
