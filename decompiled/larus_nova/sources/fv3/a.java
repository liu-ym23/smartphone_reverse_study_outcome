package fv3;

import com.bytedance.applet.aibridge.calendar.RemindInfo;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.platform.api.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final a5 a(RemindInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.getId();
        String r101 = r110.getTitle();
        Long r102 = r110.getDtStart();
        Long r103 = r110.getDuration();
        String r104 = r110.getLocation();
        Boolean r105 = r110.getEnableRemind();
        if (r105 == null) goto L5;
        boolean r106 = r105.booleanValue();
    L6:
        Long r107 = r110.getRemindDate();
        if (r107 == null) goto L9;
        long r108 = r107.longValue();
    L11:
        return new a5(r100, r101, r102, r103, r104, r106, r108, r110.getRRule());
    L9:
        r108 = 0;
        goto L11
    L5:
        r106 = false;
        goto L6
    }

    public static final RemindInfo b(LinkedTreeMap<String, Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        RemindInfo r100 = new RemindInfo(null, null, null, null, null, null, null, null, null, 511, null);
        Object r101 = r110.get("id");     // Catch: Exception -> L30
        String r102 = null;
        if ((r101 instanceof String) == false) goto L6;
        String r103 = (String) r101;     // Catch: Exception -> L30
    L7:
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r100.setId(r103);     // Catch: Exception -> L30
        Object r104 = r110.get("rRule");     // Catch: Exception -> L30
        if ((r104 instanceof String) == false) goto L12;
        String r105 = (String) r104;     // Catch: Exception -> L30
    L13:
        r100.setRRule(r105);     // Catch: Exception -> L30
        Object r106 = r110.get("location");     // Catch: Exception -> L30
        if ((r106 instanceof String) == false) goto L16;
        String r107 = (String) r106;     // Catch: Exception -> L30
    L17:
        r100.setLocation(r107);     // Catch: Exception -> L30
        Object r108 = r110.get("title");     // Catch: Exception -> L30
        if ((r108 instanceof String) == false) goto L20;
        String r109 = (String) r108;     // Catch: Exception -> L30
    L21:
        r100.setTitle(r109);     // Catch: Exception -> L30
        Object r111 = r110.get("enableRemind");     // Catch: Exception -> L30
        if ((r111 instanceof Boolean) == false) goto L24;
        Boolean r112 = (Boolean) r111;     // Catch: Exception -> L30
    L25:
        r100.setEnableRemind(r112);     // Catch: Exception -> L30
        r100.setDtStart(c(r110.get("dtStart")));     // Catch: Exception -> L30
        r100.setDuration(c(r110.get("duration")));     // Catch: Exception -> L30
        Object r113 = r110.get("group");     // Catch: Exception -> L30
        if ((r113 instanceof String) == false) goto L28;
        r102 = (String) r113;     // Catch: Exception -> L30
    L28:
        r100.setGroup(r102);     // Catch: Exception -> L30
        r100.setRemindDate(c(r110.get("remindDate")));     // Catch: Exception -> L30
        goto L29
    L24:
        r112 = null;
        goto L25
    L20:
        r109 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    L12:
        r105 = null;
        goto L13
    L6:
        r103 = null;
    L29:
        return r100;
    }

    public static final Long c(Object r100) {
        if ((r100 instanceof Long) == false) goto L6;
        return (Long) r100;
    L6:
        if ((r100 instanceof Number) == true) goto L11;
        return null;
    L11:
        return Long.valueOf(((Number) r100).longValue());
    }
}
