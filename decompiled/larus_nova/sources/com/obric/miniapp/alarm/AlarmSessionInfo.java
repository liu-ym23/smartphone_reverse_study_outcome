package com.obric.miniapp.alarm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jh\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006+"}, d2 = {"Lcom/obric/miniapp/alarm/AlarmSessionInfo;", "", "left_btn", "Lcom/obric/miniapp/alarm/LeftBtn;", "location", "", "calendarType", "timestamp", "", "timestamp_end", "title", "type", "time", "<init>", "(Lcom/obric/miniapp/alarm/LeftBtn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeft_btn", "()Lcom/obric/miniapp/alarm/LeftBtn;", "getLocation", "()Ljava/lang/String;", "getCalendarType", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp_end", "getTitle", "getType", "getTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/obric/miniapp/alarm/LeftBtn;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/miniapp/alarm/AlarmSessionInfo;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmSessionInfo {
    private final String calendarType;
    private final LeftBtn left_btn;
    private final String location;
    private final String time;
    private final Long timestamp;
    private final Long timestamp_end;
    private final String title;
    private final String type;

    public static /* synthetic */ AlarmSessionInfo copy$default(AlarmSessionInfo r100, LeftBtn r110, String r111, String r112, Long r113, Long r114, String r115, String r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        LeftBtn r101 = r100.left_btn;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.location;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.calendarType;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Long r104 = r100.timestamp;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Long r105 = r100.timestamp_end;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.title;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.type;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.time;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final LeftBtn component1() {
        return this.left_btn;
    }

    public final String component2() {
        return this.location;
    }

    public final String component3() {
        return this.calendarType;
    }

    public final Long component4() {
        return this.timestamp;
    }

    public final Long component5() {
        return this.timestamp_end;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.time;
    }

    public final AlarmSessionInfo copy(LeftBtn r110, String r111, String r112, Long r113, Long r114, String r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "left_btn");
        Intrinsics.checkNotNullParameter(r115, "title");
        Intrinsics.checkNotNullParameter(r116, "type");
        return new AlarmSessionInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlarmSessionInfo) == true) goto L8;
        return false;
    L8:
        AlarmSessionInfo r101 = (AlarmSessionInfo) r100;
        if (Intrinsics.areEqual(this.left_btn, r101.left_btn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.calendarType, r101.calendarType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.timestamp_end, r101.timestamp_end) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.left_btn.hashCode() * 31;
        String r101 = this.location;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.calendarType;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.timestamp;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.timestamp_end;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((((r110 + r112) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r114 = this.time;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AlarmSessionInfo(left_btn=" + this.left_btn + ", location=" + this.location + ", calendarType=" + this.calendarType + ", timestamp=" + this.timestamp + ", timestamp_end=" + this.timestamp_end + ", title=" + this.title + ", type=" + this.type + ", time=" + this.time + ')';
    }

    public final String getCalendarType() {
        return this.calendarType;
    }

    public final LeftBtn getLeft_btn() {
        return this.left_btn;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getTime() {
        return this.time;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Long getTimestamp_end() {
        return this.timestamp_end;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public AlarmSessionInfo(LeftBtn r100, String r101, String r102, Long r103, Long r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "left_btn");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r106, "type");
        this.left_btn = r100;
        this.location = r101;
        this.calendarType = r102;
        this.timestamp = r103;
        this.timestamp_end = r104;
        this.title = r105;
        this.type = r106;
        this.time = r107;
    }

    public /* synthetic */ AlarmSessionInfo(LeftBtn r110, String r111, String r112, Long r113, Long r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 128) == 0) goto L5;
        String r100 = null;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        r100 = r117;
        goto L6
    }
}
