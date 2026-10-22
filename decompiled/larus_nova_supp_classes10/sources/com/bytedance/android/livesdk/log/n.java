package com.bytedance.android.livesdk.log;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.v3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n {
    public static Map<String, String> a;
    public static long b;
    public static Map<String, String> c;
    public static boolean d;
    public static long e;
    public static HashMap<String, String> f;

    public static Map b() {
        if (f != null) goto L32;
        long r0 = e;
        boolean r2 = false;
        if (r0 != 0) goto L7;
    L13:
        boolean r1 = false;
    L15:
        if (b != 0) goto L17;
    L19:
        if (r1 == true) goto L21;
        if (r2 == false) goto L32;
    L21:
        HashMap<String, String> r3 = new HashMap();
        if (r1 == false) goto L26;
        Map<String, String> r4 = c;
        if (r4 == null) goto L26;
        r3.putAll(r4);
    L26:
        if (r2 == false) goto L30;
        Map<String, String> r5 = a;
        if (r5 == null) goto L30;
        r3.putAll(r5);
    L30:
        f = r3;
        goto L32
    L17:
        if (a == null) goto L19;
        r2 = true;
        goto L19
    L7:
        if (c == null) goto L13;
        if (d == false) goto L11;
    L12:
        r1 = true;
        goto L15
    L11:
        if (b != r0) goto L13;
    L32:
        return f;
    }

    static {
    }

    public static long c(Bundle r2) {
        if (r2 == null) goto L4;
        Object r3 = r2.get("live.intent.extra.ROOM_ID");
    L6:
        if ((r3 instanceof Number) == false) goto L9;
        return ((Number) r3).longValue();
    L9:
        if ((r3 instanceof String) == true) goto L14;
        return 0;
    L14:
        return d5.c((String) r3);
    L4:
        r3 = null;
        goto L6
    }

    public static void d(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Object r0 = r3.get("item_log_pb");
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        a = (Map) r0;
        b = c(r3);
        f = null;
    }

    public static void a(Bundle r4, FeedItem r5) {
        Intrinsics.checkNotNullParameter(r4, "bundle");
        Intrinsics.checkNotNullParameter(r5, "feedItem");
        String r6 = r5.itemLogPb;
        int r0 = v3.a;
        JSONObject r1 = null;
        if (r6 != null) goto L24;
    L7:
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.length() != 0) goto L12;
        return;
    L12:
        HashMap r7 = new HashMap();
        Iterator<String> r2 = r1.keys();
    L14:
        if (r2.hasNext() == false) goto L21;
        String r3 = r2.next();
        Object r8 = r1.opt(r3);
        if (r8 == null) goto L19;
        String r9 = r8.toString();
        if (r9 == null) goto L19;
    L20:
        r7.put(r3, r9);
    L19:
        r9 = "";
        goto L20
    L21:
        r4.putSerializable("item_log_pb", r7);
        return;
    L24:
        r1 = new JSONObject(r6);     // Catch: Throwable -> L23
        goto L7
    }
}
