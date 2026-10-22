package fv3;

import com.bytedance.applet.aibridge.calendar.RemindInfo;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.platform.api.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a5 a(RemindInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r2 = r11.getId();
        String r3 = r11.getTitle();
        Long r4 = r11.getDtStart();
        Long r5 = r11.getDuration();
        String r6 = r11.getLocation();
        Boolean r1 = r11.getEnableRemind();
        if (r1 == null) goto L5;
        boolean r7 = r1.booleanValue();
    L6:
        Long r8 = r11.getRemindDate();
        if (r8 == null) goto L9;
        long r9 = r8.longValue();
    L11:
        return new a5(r2, r3, r4, r5, r6, r7, r9, r11.getRRule());
    L9:
        r9 = 0;
        goto L11
    L5:
        r7 = false;
        goto L6
    }

    public static final RemindInfo b(LinkedTreeMap<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        RemindInfo r0 = new RemindInfo(null, null, null, null, null, null, null, null, null, 511, null);
        Object r1 = r13.get("id");     // Catch: Exception -> L30
        String r3 = null;
        if ((r1 instanceof String) == false) goto L6;
        String r2 = (String) r1;     // Catch: Exception -> L30
    L7:
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r0.setId(r2);     // Catch: Exception -> L30
        Object r4 = r13.get("rRule");     // Catch: Exception -> L30
        if ((r4 instanceof String) == false) goto L12;
        String r5 = (String) r4;     // Catch: Exception -> L30
    L13:
        r0.setRRule(r5);     // Catch: Exception -> L30
        Object r6 = r13.get("location");     // Catch: Exception -> L30
        if ((r6 instanceof String) == false) goto L16;
        String r7 = (String) r6;     // Catch: Exception -> L30
    L17:
        r0.setLocation(r7);     // Catch: Exception -> L30
        Object r8 = r13.get("title");     // Catch: Exception -> L30
        if ((r8 instanceof String) == false) goto L20;
        String r9 = (String) r8;     // Catch: Exception -> L30
    L21:
        r0.setTitle(r9);     // Catch: Exception -> L30
        Object r10 = r13.get("enableRemind");     // Catch: Exception -> L30
        if ((r10 instanceof Boolean) == false) goto L24;
        Boolean r11 = (Boolean) r10;     // Catch: Exception -> L30
    L25:
        r0.setEnableRemind(r11);     // Catch: Exception -> L30
        r0.setDtStart(c(r13.get("dtStart")));     // Catch: Exception -> L30
        r0.setDuration(c(r13.get("duration")));     // Catch: Exception -> L30
        Object r12 = r13.get("group");     // Catch: Exception -> L30
        if ((r12 instanceof String) == false) goto L28;
        r3 = (String) r12;     // Catch: Exception -> L30
    L28:
        r0.setGroup(r3);     // Catch: Exception -> L30
        r0.setRemindDate(c(r13.get("remindDate")));     // Catch: Exception -> L30
        goto L29
    L24:
        r11 = null;
        goto L25
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L6:
        r2 = null;
    L29:
        return r0;
    }

    public static final Long c(Object r2) {
        if ((r2 instanceof Long) == false) goto L6;
        return (Long) r2;
    L6:
        if ((r2 instanceof Number) == true) goto L11;
        return null;
    L11:
        return Long.valueOf(((Number) r2).longValue());
    }
}
