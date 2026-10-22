package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyGenerator;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CommonKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Model$EventType.values().length];
            r0[Model$EventType.V3.ordinal()] = 1;
            r0[Model$EventType.V1.ordinal()] = 2;
            r0[Model$EventType.LogData.ordinal()] = 3;
            r0[Model$EventType.Launch.ordinal()] = 4;
            r0[Model$EventType.Terminate.ordinal()] = 5;
            a = r0;
        }
    }

    public static final void b(SQLiteDatabase r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isOpen() == true) goto L6;
        return;
    L6:
        if (r1.inTransaction() == false) goto L14;
        r1.endTransaction();     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static final void d(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "packJson");
        r4.put("magic_tag", "ss_app_log");
        r4.put("local_time", System.currentTimeMillis() / ((long) ECDraweeView.SQUARE));
        r4.put("_gen_time", System.currentTimeMillis());
    }

    public static final int g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        int r2 = 0;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0;
    L8:
        int r1 = 0;
    L10:
        if (r2 >= r5.length()) goto L22;
        char r3 = r5.charAt(r2);
        if (r3 > 127) goto L15;
        r1 = r1 + 1;
    L21:
        r2 = r2 + 1;
        goto L10
    L15:
        if (r3 > 2047) goto L18;
        r1 = r1 + 2;
        goto L21
    L18:
        if (Character.isHighSurrogate(r3) == false) goto L20;
        r1 = r1 + 4;
        r2 = r2 + 1;
        goto L21
    L20:
        r1 = r1 + 3;
        goto L21
    L22:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static final long i(List<Long> r8) {
        Intrinsics.checkNotNullParameter(r8, "intervals");
        int r0 = r8.size();
        if (r0 != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (r0 == 1) goto L14;
        long r1 = ((Number) ListProtector.get(r8, 0)).longValue();
        long r4 = i(r8.subList(1, r8.size()));
        long r2 = RangesKt.coerceAtLeast(1, r1);
        long r3 = RangesKt.coerceAtLeast(1, r4);
    L8:
        if (r3 == 0) goto L15;
        long r5 = r2 % r3;
        r2 = r3;
        r3 = r5;
        goto L8
    L15:
        return r2;
    L14:
        return RangesKt.coerceAtLeast(1, ((Number) ListProtector.get(r8, 0)).longValue());
    }

    public static final void e(JSONObject r1, PriorityCallback r2) {
        Intrinsics.checkNotNullParameter(r1, "options");
        Intrinsics.checkNotNullParameter(r2, "callback");
        Object r3 = r2.getOpaquePayloadJson();
        if (r3 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r3, JSONObject.NULL) == true) goto L12;
        r1.put("opaque_payload", r3);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static final Pair<String, String> f(JSONObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "packJson");
        boolean r1 = true;
        r5.put("uid_enable", 1);
        if (r6 == true) goto L23;
        return null;
    L23:
        KeyGenerator r7 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L17
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L17
        r7.init(128, r2);     // Catch: Throwable -> L17
        String r8 = e.a(r7.generateKey().getEncoded());     // Catch: Throwable -> L17
        byte[] r3 = new byte[8];     // Catch: Throwable -> L17
        r2.nextBytes(r3);     // Catch: Throwable -> L17
        String r4 = e.a(r3);     // Catch: Throwable -> L17
        if (r8 == null) goto L13;
        if (r4 == null) goto L13;
        if (r8.length() != 32) goto L13;
        if (r4.length() != 16) goto L13;
    L14:
        if (r1 == false) goto L18;
        Pair r9 = TuplesKt.to(r8, r4);     // Catch: Throwable -> L17
    L19:
        if (r9 != null) goto L21;
        return null;
    L21:
        String r0 = (String) r9.component1();
        String r10 = (String) r9.component2();
        r5.put("key", r0);
        r5.put("iv", r10);
        return TuplesKt.to(r0, r10);
    L13:
        r1 = false;
    L18:
        r9 = null;
        goto L19
    }

    public static final void h(JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "targetJson");
        Intrinsics.checkNotNullParameter(r4, "sourceJson");
        if (r4.length() > 0) goto L5;
        return;
    L5:
        Iterator<String> r0 = r4.keys();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();
        r3.put(r1, r4.get(r1));
        goto L7
    }

    public static final JSONObject n(PriorityCallback r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "priorityCallback");
        String r0 = r4.getHeaderJson();
        if (r0 != null) goto L5;
    L12:
        if (r5 <= 0) goto L15;
        Thread.sleep(300);
        return n(r4, r5 - 1);
    L15:
        return null;
    L5:
        if (r0.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        return new JSONObject(r0);
    L7:
        r2 = false;
        goto L8
    }

    public static final String a(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reportHost");
        Intrinsics.checkNotNullParameter(r3, "reportPath");
        return r2 + r3 + "?app_log_priority=" + r1;
    }

    public static final void c(JSONObject r8, Map<j, ? extends JSONObject> r9, com.bytedance.applog.log.a r10) {
        Intrinsics.checkNotNullParameter(r8, "packJson");
        Intrinsics.checkNotNullParameter(r9, "events");
        Intrinsics.checkNotNullParameter(r10, "logger");
        final JSONArray r2 = new JSONArray();
        final JSONArray r3 = new JSONArray();
        final JSONArray r4 = new JSONArray();
        final JSONArray r5 = new JSONArray();
        final JSONArray r6 = new JSONArray();
        Iterator<Map.Entry<j, ? extends JSONObject>> r11 = r9.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        Map.Entry<j, ? extends JSONObject> r0 = r11.next();
        j r1 = r0.getKey();
        JSONObject r7 = r0.getValue();
        Model$EventType r12 = r1.d;
        int r13 = a.a[r12.ordinal()];
        if (r13 != 1) goto L8;
        r2.put(r7);
        goto L4
    L8:
        if (r13 != 2) goto L10;
        r3.put(r7);
        goto L4
    L10:
        if (r13 != 3) goto L12;
        r4.put(r7);
        goto L4
    L12:
        if (r13 != 4) goto L14;
        r5.put(r7);
        goto L4
    L14:
        if (r13 != 5) goto L4;
        r6.put(r7);
        goto L4
    L22:
        if (r2.length() <= 0) goto L25;
        r8.put("event_v3", r2);
    L25:
        if (r3.length() <= 0) goto L28;
        r8.put("event", r3);
    L28:
        if (r4.length() <= 0) goto L31;
        r8.put("log_data", r4);
    L31:
        if (r5.length() <= 0) goto L34;
        r8.put("launch", r5);
    L34:
        if (r6.length() <= 0) goto L36;
        r8.put("terminate", r6);
    L36:
        r10.a("fillEventToPackJson", new CommonKt$fillEventToPackJson$1(r2, r3, r4, r5, r6));
    }

    public static final void j(PriorityCallback r5, int r6, Map<j, ? extends JSONObject> r7) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r7, "events");
        Iterator<j> r8 = r7.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        j r0 = r8.next();
        long r1 = (System.currentTimeMillis() / ((long) ECDraweeView.SQUARE)) - r0.c;
        r5.monitorLatency(r6, r0.d.getType(), (int) r1);
        goto L4
    }

    public static final void m(PriorityCallback r8, String r9, Map<j, ? extends JSONObject> r10, Model$PriorityName r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "stage");
        Intrinsics.checkNotNullParameter(r10, "events");
        Intrinsics.checkNotNullParameter(r11, "priorityName");
        if (r8.isStageEnabled() == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<j, ? extends JSONObject>> r13 = r10.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        Map.Entry<j, ? extends JSONObject> r0 = r13.next();
        j r1 = r0.getKey();
        JSONObject r5 = r0.getValue();
        l(r8, r9, r1.d.getType(), r5, r11, r12);
        goto L7
    }

    public static final void k(PriorityCallback r6, String r7, int r8, Lazy<? extends JSONObject> r9, Model$PriorityName r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "stage");
        Intrinsics.checkNotNullParameter(r9, "json");
        Intrinsics.checkNotNullParameter(r10, "priorityName");
        if (r6.isStageEnabled() == true) goto L5;
        return;
    L5:
        l(r6, r7, r8, (JSONObject) r9.getValue(), r10, r11);
    }

    public static final void l(PriorityCallback r11, String r12, int r13, JSONObject r14, Model$PriorityName r15, int r16) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "stage");
        Intrinsics.checkNotNullParameter(r14, "json");
        Intrinsics.checkNotNullParameter(r15, "priorityName");
        if (r11.isStageEnabled() == true) goto L6;
        return;
    L6:
        if (r14.optInt("event_stained") > 0) goto L8;
        return;
    L8:
        String r4 = r15.name();
        Intrinsics.checkNotNullParameter(r14, "json");
        Model$EventType.Companion.getClass();
        Model$EventType r1 = Model$EventType.a.a(r13);
        int r5 = a.a[r1.ordinal()];
        if (r5 != 1) goto L11;
        String r2 = r14.optString("event");
    L18:
        r11.monitorStage(r12, r4, r16, r13, r2, r14.optString("monitor_id"), r14.optLong("local_time_ms", System.currentTimeMillis()));
        return;
    L11:
        if (r5 != 2) goto L13;
        r2 = r14.optString("tag");
        goto L18
    L13:
        if (r5 == 3) goto L15;
        r2 = r1.getAlias();
        goto L18
    L15:
        r2 = r14.optString("log_type");
        goto L18
    }
}
