package de2;

import am2.x;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f468051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f468052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f468053c;

    public static void b() {
        if (j.i() == false) goto L5;
        return;
    L5:
        if (f468051a == true) goto L7;
        return;
    L7:
        if (f468052b == true) goto L13;
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("function_type2", "chorus");
        r100.put("duration", String.valueOf((System.currentTimeMillis() - f468053c) / ((long) 1000)));
        a("livesdk_guest_connection_over", r100);
        f468052b = true;
        f468051a = false;
        f468053c = 0;
        return;
    }

    static {
    }

    public static void a(String r100, Map r101) {
        j0.l().sendLog(r100, r101, new Object[]{IRoom.class, x.class});
    }
}
