package com.bytedance.applog.monitor.v3.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import ex3.b;
import ex3.g;
import ex3.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements Handler.Callback {
    public static final List<String> h = null;
    public final Map<String, a> a;
    public boolean b;
    public Handler c;
    public SharedPreferences d;
    public final b e;
    public boolean f;
    public final AtomicBoolean g;

    static {
        h = Collections.singletonList("SentryMonitor");
    }

    public final boolean d() {
        if (this.f == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e.o == true) goto L8;
        return false;
    }

    public final void f() {
        if (this.d != null) goto L5;
        return;
    L5:
        int r4 = 0;
        n.w().k(8, h, "start load cache map from sp...", new Object[0]);
        long r2 = this.d.getLong("uptime", 0);
        if (r2 > 0) goto L8;
    L11:
        Map<String, ?> r0 = this.d.getAll();
        if (r0.isEmpty() == false) goto L14;
        return;
    L14:
        int r5 = 2;
        HashMap r3 = new HashMap(r0.size() * 2);
        Iterator<Map.Entry<String, ?>> r1 = r0.entrySet().iterator();
    L16:
        if (r1.hasNext() == false) goto L76;
        Map.Entry<String, ?> r6 = r1.next();
        String r7 = r6.getKey();
        if (TextUtils.isEmpty(r7) == true) goto L16;
        if ("uptime".equals(r7) == true) goto L16;
        String r8 = (String) r6.getValue();
        List r9 = a.e;
        String r10 = null;
        if (TextUtils.isEmpty(r8) == true) goto L72;
        AtomicLong r11 = g.a;
        if (r8 != null) goto L28;
    L38:
        ArrayList r12 = new ArrayList();
    L39:
        ArrayList r13 = r12;
        if (r13.isEmpty() == true) goto L72;
        int r14 = -1;
        if (((String) ListProtector.get(r13, r4)).equals("v4") == false) goto L54;
        r14 = CastIntegerProtector.parseInt((String) ListProtector.get(r13, r5));     // Catch: Throwable -> L45
    L46:
        EventStage r15 = EventStage.fromName((String) ListProtector.get(r13, 3));
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r13, 1)) == true) goto L50;
        r10 = (String) ListProtector.get(r13, 1);
    L50:
        String r16 = new a(r15, new i(r10, r14, (String) ListProtector.get(r13, 4), r7, CastLongProtector.parseLong((String) ListProtector.get(r13, 5)), StageEventType.parse((String) ListProtector.get(r13, 6))));
        r16.a(new JSONObject((String) ListProtector.get(r13, 7)));     // Catch: Throwable -> L93
    L67:
        r10 = r16;
        goto L72
    L54:
        if (((String) ListProtector.get(r13, r4)).equals("v3") == false) goto L65;
        r14 = CastIntegerProtector.parseInt((String) ListProtector.get(r13, 2));     // Catch: Throwable -> L58
    L59:
        EventStage r17 = EventStage.fromName((String) ListProtector.get(r13, 3));
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r13, 1)) == true) goto L63;
        r10 = (String) ListProtector.get(r13, 1);
    L63:
        r16 = new a(r17, new i(r10, r14, (String) ListProtector.get(r13, 4), r7, CastLongProtector.parseLong((String) ListProtector.get(r13, 5)), StageEventType.parse((String) ListProtector.get(r13, 6))));
        goto L67
    L65:
        if (r13.size() != 4) goto L69;
        r16 = new a(EventStage.fromName((String) ListProtector.get(r13, 0)), new i((String) ListProtector.get(r13, 1), r7, CastLongProtector.parseLong((String) ListProtector.get(r13, 2)), StageEventType.V3_EVENT));
        goto L67
    L69:
        if (r13.size() != 5) goto L72;
        r10 = new a(EventStage.fromName((String) ListProtector.get(r13, 0)), new i((String) ListProtector.get(r13, 1), r7, CastLongProtector.parseLong((String) ListProtector.get(r13, 2)), StageEventType.parse((String) ListProtector.get(r13, 3))));
        goto L72
    L28:
        if (r8.isEmpty() == true) goto L38;
        r12 = new ArrayList();
        int r18 = r8.length();
        int r19 = 0;
        int r110 = 0;
    L31:
        if (r19 >= r18) goto L36;
        if (r8.charAt(r19) != '|') goto L35;
        r12.add(r8.substring(r110, r19));
        r110 = r19 + 1;
    L35:
        r19 = r19 + 1;
        goto L31
    L36:
        if (r110 > r18) goto L39;
        r12.add(r8.substring(r110));
    L72:
        if (r10 == null) goto L75;
        ((a) r10).c = true;
        r3.put(r7, r10);
    L75:
        r4 = 0;
        r5 = 2;
        goto L16
    L76:
        Map<String, a> r20 = this.a;
        monitor-enter(r20);
        Iterator r21 = r3.entrySet().iterator();     // Catch: Throwable -> L90
    L80:
        if (r21.hasNext() == false) goto L88;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L90
        String r23 = (String) r22.getKey();     // Catch: Throwable -> L90
        a r24 = (a) r22.getValue();     // Catch: Throwable -> L90
        if (this.a.containsKey(r22.getKey()) == false) goto L87;
        a r25 = this.a.get(r22.getKey());     // Catch: Throwable -> L90
        if (r25 == null) goto L87;
        r24.c = false;     // Catch: Throwable -> L90
        r24.a.a(r25.a);     // Catch: Throwable -> L90
    L87:
        this.a.put(r23, r24);     // Catch: Throwable -> L90
        goto L80
    L88:
        monitor-exit(r20);     // Catch: Throwable -> L90
        return;
    L90:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r2) <= TimeUnit.DAYS.toMillis(this.e.i)) goto L11;
        this.d.edit().clear().apply();
    }

    public d(b r3) {
        this.a = Collections.synchronizedMap(new LinkedHashMap());
        this.b = true;
        this.f = true;
        this.g = new AtomicBoolean(false);
        this.e = r3;
    }

    public final void a(a r7) {
        n.w().k(8, h, "start handle stage ({})", new Object[]{r7});
        Map<String, a> r0 = this.a;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (e(r7.a.a) == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        a r1 = this.a.get(r7.a.b);     // Catch: Throwable -> L20
        if (r1 != null) goto L11;
        this.a.put(r7.a.b, r7);     // Catch: Throwable -> L20
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L20
        Handler r8 = this.c;
        if (r8 == null) goto L24;
        r8.removeMessages(4);
        this.c.sendEmptyMessageDelayed(4, 500);
        return;
    L24:
        return;
    L11:
        r1.c = false;     // Catch: Throwable -> L20
        r1.a.a(r7.a);     // Catch: Throwable -> L20
        if (r7.b.ordinal() <= r1.b.ordinal()) goto L14;
        r1.b = r7.b;     // Catch: Throwable -> L20
    L14:
        r1.a(r7.d);     // Catch: Throwable -> L20
        goto L15
    }

    public final Pair<Map<String, a>, Long> c(long r7) {
        if (this.a.isEmpty() == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, a> r1 = this.a;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r2 = this.a.entrySet().iterator();     // Catch: Throwable -> L20
    L10:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<String, a> r3 = r2.next();     // Catch: Throwable -> L20
        a r4 = r3.getValue();     // Catch: Throwable -> L20
        r0.put(r3.getKey(), r4);     // Catch: Throwable -> L20
        i r5 = r4.a;     // Catch: Throwable -> L20
        if (r5 == null) goto L14;
        int r6 = r5.a.length();     // Catch: Throwable -> L20
    L15:
        r7 = r7 - ((long) (r6 + 223));     // Catch: Throwable -> L20
        if (r7 >= 0) goto L10;
    L14:
        r6 = 0;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L20
        return new Pair(r0, Long.valueOf(r7));
    L20:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r7));
    }

    public final boolean e(String r2) {
        if (d() == false) goto L6;
        return true;
    L6:
        Map<String, Integer> r0 = this.e.m;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.containsKey(r2);
    }

    public final void g(Map<String, a> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L34;
        SharedPreferences r0 = this.d;
        if (r0 == null) goto L9;
        SharedPreferences.Editor r1 = r0.edit();
    L10:
        Map<String, a> r2 = this.a;
        monitor-enter(r2);
        Iterator<String> r6 = r5.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r6.hasNext() == false) goto L18;
        String r3 = r6.next();     // Catch: Throwable -> L22
        this.a.remove(r3);     // Catch: Throwable -> L22
        if (r1 == null) goto L14;
        r1.remove(r3);     // Catch: Throwable -> L22
        goto L14
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L22
        if (r1 == null) goto L33;
        r1.apply();
        return;
    L33:
        return;
    L22:
        th = move-exception;
        throw th;
    L9:
        r1 = null;
        goto L10
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r0 = r8.what;
        if (r0 == 4) goto L10;
        if (r0 != 8) goto L6;
        a((a) r8.obj);
    L22:
        return false;
    L6:
        if (r0 != 12) goto L22;
        f();
        goto L22
    L10:
        n.w().k(8, h, "start flush cache map (size={}) to sp...", new Object[]{Integer.valueOf(this.a.size())});
        SharedPreferences.Editor r9 = this.d.edit();
        Map<String, a> r1 = this.a;
        monitor-enter(r1);
        Iterator<Map.Entry<String, a>> r2 = this.a.entrySet().iterator();     // Catch: Throwable -> L23
    L14:
        if (r2.hasNext() == false) goto L20;
        a r3 = r2.next().getValue();     // Catch: Throwable -> L23
        if (r3.c == true) goto L14;
        if (e(r3.a.a) == false) goto L14;
        r9.putString(r3.a.b, r3.b());     // Catch: Throwable -> L23
        r3.c = true;     // Catch: Throwable -> L23
        goto L14
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L23
        r9.putLong("uptime", System.currentTimeMillis());
        r9.apply();
    L23:
        th = move-exception;
        throw th;
    }

    public static void b(Map r10, JSONArray r11) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        Iterator r12 = r10.values().iterator();
    L7:
        if (r12.hasNext() == false) goto L31;
        a r1 = (a) r12.next();
        JSONArray r4 = (JSONArray) r0.get(r1.b);
        if (r4 != null) goto L11;
        r4 = new JSONArray();
        r0.put(r1.b, r4);
    L11:
        JSONObject r5 = new JSONObject();
        r5.put("monitor_id", r1.a.b);     // Catch: Throwable -> L39
        StageEventType r6 = r1.a.d;     // Catch: Throwable -> L39
        if (r6 == null) goto L16;
        r5.put("event_type", r6.getLabel());     // Catch: Throwable -> L39
    L16:
        if (TextUtils.isEmpty(r1.a.a) == true) goto L18;
        r5.put("event", r1.a.a);     // Catch: Throwable -> L39
    L18:
        long r7 = r1.a.c;     // Catch: Throwable -> L39
        if (r7 <= 0) goto L22;
        r5.put("local_time_ms", r7);     // Catch: Throwable -> L39
    L22:
        if (TextUtils.isEmpty(r1.a.e) == true) goto L24;
        r5.put("event_priority", r1.a.e);     // Catch: Throwable -> L39
    L24:
        int r2 = r1.a.f;     // Catch: Throwable -> L39
        if (r2 < 0) goto L28;
        r5.put("global_priority", r2);     // Catch: Throwable -> L39
    L28:
        if (r1.d.length() <= 0) goto L30;
        r5.put("stage_ms", r1.d);     // Catch: Throwable -> L39
    L30:
        r4.put(r5);
        goto L7
    L31:
        JSONObject r13 = new JSONObject();
        r13.put("event", "sdk_stage");     // Catch: Throwable -> L40
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L40
        Iterator r8 = r0.entrySet().iterator();     // Catch: Throwable -> L40
    L34:
        if (r8.hasNext() == false) goto L36;
        Map.Entry r9 = (Map.Entry) r8.next();     // Catch: Throwable -> L40
        r3.put(((EventStage) r9.getKey()).toString(), r9.getValue());     // Catch: Throwable -> L40
        goto L34
    L36:
        r13.put("params", r3);     // Catch: Throwable -> L40
        r13.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L40
        r13.put("event_id", g.b.incrementAndGet());     // Catch: Throwable -> L40
        r13.put("datetime", g.a());     // Catch: Throwable -> L40
    L37:
        r11.put(r13);
    }
}
