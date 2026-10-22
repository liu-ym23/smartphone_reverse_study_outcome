package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.y0;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.miniapp.view.CalendarMiniAppActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f397474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f397475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f397476c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f397477d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f397478e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f397479f = null;

    static {
        f397474a = LazyKt.lazy(new g0());
        f397475b = LazyKt.lazy(new h0());
        f397476c = LazyKt.lazy(new i0());
        f397477d = LazyKt.lazy(new j0());
        f397478e = LazyKt.lazy(new k0());
        f397479f = LazyKt.lazy(new l0());
    }

    public static Application b() {
        return AppHost.f326268a.getApplication();
    }

    public static boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "alarm");
        if (r100.f397426k == true) goto L5;
        return false;
    L5:
        String r101 = r100.f397425j.get("alarm_clock_id");
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L18:
        return false;
    L14:
        if (Intrinsics.areEqual(r101, "-1") == true) goto L18;
        Bundle r103 = new Bundle();
        r103.putString("alarm_id", r101);
        b().getContentResolver().call("com.obric.clock.alarm", "method_delete", null, r103);
        return true;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    public static boolean d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "alarm");
        if (r100.f397426k == true) goto L5;
        return false;
    L5:
        Object r101 = r100.f397419d.f397491a;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.time.Instant");
        LocalDateTime r102 = LocalDateTime.ofInstant((Instant) r101, ZoneId.systemDefault());
        String r103 = r100.f397417b;
        if (StringsKt.isBlank(r103) == false) goto L8;
        r103 = "";
    L8:
        String r104 = r102.toLocalDate().format((DateTimeFormatter) f397474a.getValue());
        LinkedHashMap r105 = new LinkedHashMap();
        r105.putAll(r100.f397425j);
        r105.put("activity", (String) f397475b.getValue());
        r105.put("date_alarm", r104);
        String r106 = s.c(r105);
        Bundle r107 = new Bundle();
        r107.putInt("hour", r102.getHour());
        r107.putInt("minute", r102.getMinute());
        r107.putString("date", r104);
        r107.putString("label", r103);
        r107.putString("extra", r106);
        Long r108 = null;
        Bundle r109 = b().getContentResolver().call("com.obric.clock.alarm", "method_set", null, r107);
        if (r109 == null) goto L11;
        r108 = Long.valueOf(r109.getLong("alarm_id", -1));
    L11:
        if (r108 != null) goto L14;
    L16:
        r105.put("alarm_clock_id", String.valueOf(r108));
        Map<String, String> r110 = r100.f397425j;
        r110.clear();
        r110.putAll(r105);
        return true;
    L14:
        if (r108.longValue() != (-1)) goto L16;
        return false;
    }

    public static PendingIntent c(a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r102 = new Intent(r101, CalendarMiniAppActivity.class);
        r102.setData(y0.j("com.flow.calendar"));
        r102.putExtra(IFlowAppIntentIDL.PARAM_APPLET_ID, "com.flow.calendar");
        Iterator<Map.Entry<String, String>> r103 = r100.f397425j.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry<String, String> r104 = r103.next();
        r102.putExtra(r104.getKey(), r104.getValue());
        goto L4
    L7:
        return PendingIntent.getActivity(r101, (int) System.currentTimeMillis(), r102, ((Number) f397479f.getValue()).intValue());
    }
}
