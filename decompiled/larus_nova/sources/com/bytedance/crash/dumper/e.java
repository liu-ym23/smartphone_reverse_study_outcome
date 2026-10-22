package com.bytedance.crash.dumper;

import android.os.SystemClock;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.m0;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.y;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static void b(File r110, CrashType r111, int r112) {
        dh4.f r100 = new dh4.f(r110.getAbsolutePath() + "/custom.json");
        r100.j();
        r100.h("custom");
        r100.j();
        com.bytedance.crash.monitor.a r113 = com.bytedance.crash.monitor.j.f203315a;
        if (r113 == null) goto L25;
        List<AttachUserData> r101 = r113.f203291c.d(r111);
        int r102 = 0;
        boolean r103 = true;
        if (r101 == null) goto L14;
        boolean r104 = true;
        int r114 = 0;
    L9:
        if (r114 >= r101.size()) goto L13;
        AttachUserData r105 = (AttachUserData) ListProtector.get(r101, r114);
        r104 = a(r100, r105.getUserData(r111), r105.getClass().getName(), SystemClock.uptimeMillis(), r104);     // Catch: Throwable -> L30
    L12:
        r114 = r114 + 1;
        goto L9
    L13:
        r103 = r104;
    L14:
        m0 r115 = r113.f203291c;
        ListMap<CrashType, y> r106 = r115.f203248k;
        monitor-enter(r106);
        List<y> r116 = r115.f203248k.getList(r111);     // Catch: Throwable -> L27
        monitor-exit(r106);     // Catch: Throwable -> L27
        if (r116 == null) goto L25;
        com.bytedance.crash.util.j.h(new JSONObject(), "tid", Integer.valueOf(r112));
        boolean r117 = r103;
    L21:
        if (r102 >= r116.size()) goto L25;
        y r118 = (y) ListProtector.get(r116, r102);
        r117 = a(r100, r118.getCrashInfo(), r118.getClass().getName(), SystemClock.uptimeMillis(), r117);     // Catch: Throwable -> L31
    L24:
        r102 = r102 + 1;
    L27:
        th = move-exception;
        throw th;
    L25:
        r100.k();
        r100.k();
        r100.g();
    }

    public static boolean a(dh4.f r100, Map<? extends String, ? extends String> r101, String r102, long r103, boolean r104) {
        if (r101 != null) goto L4;
    L15:
        return r104;
    L4:
        if (r101.size() == 0) goto L15;
        StringBuilder r105 = new StringBuilder("zz_cost_");
        r105.append(r102);
        Iterator<Map.Entry<? extends String, ? extends String>> r106 = r101.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        Map.Entry<? extends String, ? extends String> r107 = r106.next();
        if (r104 == false) goto L12;
        r104 = false;
    L13:
        r100.h(r107.getKey());
        r100.l(r107.getValue());
        r105.append("_");
        r105.append(r107.getKey());
        goto L8
    L12:
        r100.i();
        goto L13
    L14:
        r100.a(',');
        r100.h(r105.toString());
        r100.c(SystemClock.uptimeMillis() - r103);
        goto L15
    }
}
