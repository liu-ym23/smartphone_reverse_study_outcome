package com.bytedance.reparo.secondary;

import com.bytedance.reparo.core.o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f267470a = -1;

    public static void a(boolean r100, int r101) throws JSONException {
        if (o.c().f267413c == false) goto L20;
        Iterator r102 = ((ConcurrentHashMap) o.c().e()).keySet().iterator();
        JSONArray r103 = new JSONArray();
    L6:
        if (r102.hasNext() == false) goto L8;
        c97.h r104 = (c97.h) r102.next();
        JSONObject r105 = new JSONObject();
        r105.putOpt("better_name", r104.f22890j);
        r105.putOpt("version_code", r104.f22889i);
        r103.put(r105);
        goto L6
    L8:
        JSONObject r106 = new JSONObject();
        long r107 = System.currentTimeMillis();
        r106.putOpt("timestamp", Long.valueOf(r107));
        r106.putOpt("betters", r103);
        if (r100 == false) goto L15;
        if (f267470a != (-1)) goto L13;
        f267470a = r107;
    L13:
        r106.putOpt("last_report_list_time", Long.valueOf(f267470a));
        f267470a = r107;
    L15:
        if (r101 == (-1)) goto L17;
        r106.putOpt("status", Integer.valueOf(r101));
    L17:
        MonitorService.c().monitorCommonLog("bd_better_monitor", r106);
        return;
    }
}
