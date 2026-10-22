package de2;

import am2.x;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static boolean a;
    public static boolean b;
    public static long c;

    public static void b() {
        if (j.i() == false) goto L5;
        return;
    L5:
        if (a == true) goto L7;
        return;
    L7:
        if (b == true) goto L13;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("function_type2", "chorus");
        r0.put("duration", String.valueOf((System.currentTimeMillis() - c) / ((long) 1000)));
        a("livesdk_guest_connection_over", r0);
        b = true;
        a = false;
        c = 0;
        return;
    }

    static {
    }

    public static void a(String r4, Map r5) {
        j0.l().sendLog(r4, r5, new Object[]{IRoom.class, x.class});
    }
}
