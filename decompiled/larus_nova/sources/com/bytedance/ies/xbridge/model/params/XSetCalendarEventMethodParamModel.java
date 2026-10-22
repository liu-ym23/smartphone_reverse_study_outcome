package com.bytedance.ies.xbridge.model.params;

import com.alipay.sdk.m.x.d;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b,\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\u0015R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\u0015¨\u0006/"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XSetCalendarEventMethodParamModel;", "Lcom/bytedance/ies/xbridge/model/params/a;", "", "toString", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "", com.heytap.mcssdk.constant.b.f276370t, "Ljava/lang/Long;", "getEndDate", "()Ljava/lang/Long;", "setEndDate", "(Ljava/lang/Long;)V", com.heytap.mcssdk.constant.b.f276369s, "getStartDate", "setStartDate", "eventID", "getEventID", "setEventID", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "notes", "getNotes", "setNotes", "alarmOffsets", "getAlarmOffsets", "setAlarmOffsets", "", "allDay", "Ljava/lang/Boolean;", "getAllDay", "()Ljava/lang/Boolean;", "setAllDay", "(Ljava/lang/Boolean;)V", "location", "getLocation", "setLocation", "url", "getUrl", "setUrl", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final class XSetCalendarEventMethodParamModel extends com.bytedance.ies.xbridge.model.params.a {
    private static final String ACTION_CREATE = "create";
    private static final String ACTION_DELETE = "delete";
    private static final String ACTION_READ = "read";
    private static final String ACTION_UPDATE = "update";
    public static final a Companion = null;
    private final String action;
    private Long alarmOffsets;
    private Boolean allDay;
    private Long endDate;
    private String eventID;
    private String location;
    private String notes;
    private Long startDate;
    private String title;
    private String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        String r100 = XSetCalendarEventMethodParamModel.class.getCanonicalName();
        if (r100 != null) goto L5;
        r100 = "XCalendarMethodParamModel";
    L5:
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.concat("("));
        r101.append("action = " + this.action + " ,");
        r101.append("eventID = " + this.eventID + " , ");
        r101.append("startDate = " + this.startDate + " , ");
        r101.append("endDate = " + this.endDate + " , ");
        r101.append("alarmOffsets = [ " + this.alarmOffsets + ' ');
        r101.append("], ");
        r101.append("allDay = " + this.allDay + " , ");
        r101.append("title = " + this.title + " , ");
        r101.append("notes = " + this.notes + " , ");
        r101.append("location = " + this.location + " , ");
        r101.append("url = " + this.url + ')');
        return r101.toString();
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getAlarmOffsets() {
        return this.alarmOffsets;
    }

    public final Boolean getAllDay() {
        return this.allDay;
    }

    public final Long getEndDate() {
        return this.endDate;
    }

    public final String getEventID() {
        return this.eventID;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final Long getStartDate() {
        return this.startDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public XSetCalendarEventMethodParamModel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.action = r100;
        this.endDate = 0L;
        this.startDate = 0L;
    }

    @JvmStatic
    public static final XSetCalendarEventMethodParamModel convert(XReadableMap r110) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, "params");
        String r100 = s.f(r110, "eventID", "");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        String r101 = ACTION_CREATE;
    L6:
        com.bytedance.ies.xbridge.model.params.a.C3558a r102 = com.bytedance.ies.xbridge.model.params.a.Companion;
        Long r103 = com.bytedance.ies.xbridge.model.params.a.C3558a.b(r102, r110, com.heytap.mcssdk.constant.b.f276369s);
        Long r104 = com.bytedance.ies.xbridge.model.params.a.C3558a.b(r102, r110, com.heytap.mcssdk.constant.b.f276370t);
        String r105 = s.f(r110, "location", "");
        String r106 = s.f(r110, "url", "");
        String r107 = s.f(r110, "title", "");
        String r108 = s.f(r110, "notes", "");
        boolean r111 = false;
        boolean r112 = s.b(r110, "allDay", false);
        Long r113 = Long.valueOf(com.bytedance.ies.xbridge.model.params.a.C3558a.a(r110, "alarmOffset"));
        XSetCalendarEventMethodParamModel r114 = new XSetCalendarEventMethodParamModel(r101);
        r114.setStartDate(r103);
        r114.setEndDate(r104);
        r114.setTitle(r107);
        r114.setEventID(r100);
        r114.setNotes(r108);
        r114.setAlarmOffsets(r113);
        r114.setLocation(r105);
        r114.setUrl(r106);
        r114.setAllDay(Boolean.valueOf(r112));
        String r115 = r114.getAction();
        if (r115 != null) goto L9;
    L12:
        boolean r116 = true;
    L13:
        if (r116 == false) goto L16;
    L72:
        if (r111 == true) goto L75;
        return null;
    L75:
        return r114;
    L16:
        if (ArraysKt.contains(new String[]{ACTION_CREATE, "delete", "update", ACTION_READ}, r114.getAction()) == false) goto L72;
        if (Intrinsics.areEqual(r114.getAction(), ACTION_CREATE) == true) goto L31;
        if (Intrinsics.areEqual(r114.getAction(), "update") == true) goto L31;
        if (Intrinsics.areEqual(r114.getAction(), "delete") == true) goto L28;
        if (Intrinsics.areEqual(r114.getAction(), ACTION_READ) == true) goto L28;
    L71:
        r111 = true;
    L28:
        if (r114.getEventID() != null) goto L71;
    L31:
        if (Intrinsics.areEqual(r114.getAction(), "update") == false) goto L36;
        if (r114.getEventID() == null) goto L72;
    L36:
        if (r114.getStartDate() == null) goto L72;
        if (r114.getEndDate() == null) goto L72;
        Long r117 = r114.getEndDate();
        Intrinsics.checkNotNull(r117);
        long r109 = r117.longValue();
        Long r118 = r114.getStartDate();
        Intrinsics.checkNotNull(r118);
        if (r109 < r118.longValue()) goto L72;
        Long r119 = r114.getEndDate();
        Intrinsics.checkNotNull(r119);
        if (r119.longValue() < 0) goto L72;
        Long r120 = r114.getStartDate();
        Intrinsics.checkNotNull(r120);
        if (r120.longValue() < 0) goto L72;
        if (r114.getAlarmOffsets() == null) goto L72;
        Long r121 = r114.getAlarmOffsets();
        Intrinsics.checkNotNull(r121);
        if (r121.longValue() < 0) goto L72;
        if (r114.getAllDay() == null) goto L72;
        if (r114.getTitle() == null) goto L72;
        if (r114.getNotes() == null) goto L72;
        if (r114.getLocation() == null) goto L72;
        if (r114.getAllDay() == null) goto L72;
        if (r114.getUrl() != null) goto L71;
    L9:
        if (r115.length() == 0) goto L12;
        r116 = false;
        goto L13
    L5:
        r101 = "update";
        goto L6
    }

    public final void setAlarmOffsets(Long r100) {
        this.alarmOffsets = r100;
    }

    public final void setAllDay(Boolean r100) {
        this.allDay = r100;
    }

    public final void setEndDate(Long r100) {
        this.endDate = r100;
    }

    public final void setEventID(String r100) {
        this.eventID = r100;
    }

    public final void setLocation(String r100) {
        this.location = r100;
    }

    public final void setNotes(String r100) {
        this.notes = r100;
    }

    public final void setStartDate(Long r100) {
        this.startDate = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
