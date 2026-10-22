package com.ss.android.lark.search.dto.info;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\bM\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÛ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010I\u001a\u00020\u0004H\u0016J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010O\u001a\u00020\nHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\t\u0010R\u001a\u00020\fHÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010V\u001a\u00020\u0013HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010[\u001a\u00020\nHÆ\u0003J\t\u0010\\\u001a\u00020\nHÆ\u0003JÝ\u0001\u0010]\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nHÆ\u0001J\u0006\u0010^\u001a\u00020\fJ\u0013\u0010_\u001a\u00020\u00132\b\u0010`\u001a\u0004\u0018\u00010aHÖ\u0003J\t\u0010b\u001a\u00020\fHÖ\u0001J\u0016\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\fR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR \u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001e\u0010\u000e\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001d\"\u0004\b9\u0010\u001fR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010:\"\u0004\b;\u0010<R \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001fR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u0010\u001fR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010\u001fR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010)\"\u0004\bF\u0010+R\u001e\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010)\"\u0004\bH\u0010+¨\u0006h"}, d2 = {"Lcom/ss/android/lark/search/dto/info/CalendarResult;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "appLink", "", "attendee", "calendarId", "chatName", "creator", "crossDayEndTime", "", "crossDayNo", "", "crossDayStartTime", "crossDaySum", "endTime", "description", "eventServerId", "isAllDay", "", "key", "organizer", "summary", "resource", "originalTime", DyPayConstant.KEY_START_TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJIJLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getAppLink", "()Ljava/lang/String;", "setAppLink", "(Ljava/lang/String;)V", "getAttendee", "setAttendee", "getCalendarId", "setCalendarId", "getChatName", "setChatName", "getCreator", "setCreator", "getCrossDayEndTime", "()J", "setCrossDayEndTime", "(J)V", "getCrossDayNo", "()I", "setCrossDayNo", "(I)V", "getCrossDayStartTime", "setCrossDayStartTime", "getCrossDaySum", "setCrossDaySum", "getEndTime", "setEndTime", "getDescription", "setDescription", "getEventServerId", "setEventServerId", "()Z", "setAllDay", "(Z)V", "getKey", "setKey", "getOrganizer", "setOrganizer", "getSummary", "setSummary", "getResource", "setResource", "getOriginalTime", "setOriginalTime", "getStartTime", "setStartTime", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "describeContents", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarResult implements Serializable, Parcelable {
    public static final Parcelable.Creator<CalendarResult> CREATOR = null;

    @SerializedName("appLink")
    private String appLink;

    @SerializedName("attendee")
    private String attendee;

    @SerializedName("calendarId")
    private String calendarId;

    @SerializedName("chatName")
    private String chatName;

    @SerializedName("creator")
    private String creator;

    @SerializedName("crossDayEndTime")
    private long crossDayEndTime;

    @SerializedName("crossDayNo")
    private int crossDayNo;

    @SerializedName("crossDayStartTime")
    private long crossDayStartTime;

    @SerializedName("crossDaySum")
    private int crossDaySum;

    @SerializedName("description")
    private String description;

    @SerializedName("endTime")
    private long endTime;

    @SerializedName("eventServerId")
    private String eventServerId;

    @SerializedName("isAllDay")
    private boolean isAllDay;

    @SerializedName("key")
    private String key;

    @SerializedName("organizer")
    private String organizer;

    @SerializedName("originalTime")
    private long originalTime;

    @SerializedName("resource")
    private String resource;

    @SerializedName(DyPayConstant.KEY_START_TIME)
    private long startTime;

    @SerializedName("summary")
    private String summary;

    public static final class a implements Parcelable.Creator<CalendarResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarResult createFromParcel(Parcel r210) {
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r100 = r210.readString();
            String r101 = r210.readString();
            String r102 = r210.readString();
            String r103 = r210.readString();
            String r104 = r210.readString();
            long r105 = r210.readLong();
            int r110 = r210.readInt();
            long r111 = r210.readLong();
            int r112 = r210.readInt();
            long r113 = r210.readLong();
            String r114 = r210.readString();
            String r115 = r210.readString();
            if (r210.readInt() == 0) goto L5;
            boolean r116 = true;
        L7:
            return new CalendarResult(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.readLong(), r210.readLong());
        L5:
            r116 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarResult[] newArray(int r100) {
            return new CalendarResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CalendarResult() {
        this(null, null, null, null, null, 0, 0, 0, 0, 0, null, null, false, null, null, null, null, 0, 0, 524287, null);
    }

    public static /* synthetic */ CalendarResult copy$default(CalendarResult r110, String r111, String r112, String r210, String r211, String r212, long r213, int r214, long r215, int r216, long r217, String r310, String r311, boolean r312, String r313, String r314, String r315, String r316, long r317, long r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        String r100 = r110.appLink;
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r101 = r110.attendee;
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r102 = r110.calendarId;
    L15:
        if ((r411 & 8) == 0) goto L17;
        String r103 = r110.chatName;
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r104 = r110.creator;
    L23:
        if ((r411 & 32) == 0) goto L25;
        long r105 = r110.crossDayEndTime;
    L27:
        if ((r411 & 64) == 0) goto L29;
        int r106 = r110.crossDayNo;
    L31:
        if ((r411 & 128) == 0) goto L33;
        long r113 = r110.crossDayStartTime;
    L35:
        if ((r411 & 256) == 0) goto L37;
        int r114 = r110.crossDaySum;
    L39:
        if ((r411 & 512) == 0) goto L41;
        long r115 = r110.endTime;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        String r116 = r110.description;
    L46:
        String r318 = r116;
        if ((r411 & 2048) == 0) goto L49;
        String r117 = r110.eventServerId;
    L50:
        String r319 = r117;
        if ((r411 & 4096) == 0) goto L53;
        boolean r118 = r110.isAllDay;
    L54:
        boolean r320 = r118;
        if ((r411 & 8192) == 0) goto L57;
        String r119 = r110.key;
    L58:
        String r321 = r119;
        if ((r411 & 16384) == 0) goto L61;
        String r120 = r110.organizer;
    L62:
        String r322 = r120;
        if ((r411 & 32768) == 0) goto L65;
        String r121 = r110.summary;
    L66:
        String r323 = r121;
        if ((r411 & 65536) == 0) goto L69;
        String r122 = r110.resource;
    L70:
        long r218 = r115;
        if ((r411 & 131072) == 0) goto L73;
        long r123 = r110.originalTime;
    L74:
        long r324 = r123;
        if ((r411 & 262144) == 0) goto L77;
        long r124 = r110.startTime;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r218, r318, r319, r320, r321, r322, r323, r122, r324, r124);
    L77:
        r124 = r410;
        goto L79
    L73:
        r123 = r317;
        goto L74
    L69:
        r122 = r316;
        goto L70
    L65:
        r121 = r315;
        goto L66
    L61:
        r120 = r314;
        goto L62
    L57:
        r119 = r313;
        goto L58
    L53:
        r118 = r312;
        goto L54
    L49:
        r117 = r311;
        goto L50
    L45:
        r116 = r310;
        goto L46
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.appLink;
    }

    public final long component10() {
        return this.endTime;
    }

    public final String component11() {
        return this.description;
    }

    public final String component12() {
        return this.eventServerId;
    }

    public final boolean component13() {
        return this.isAllDay;
    }

    public final String component14() {
        return this.key;
    }

    public final String component15() {
        return this.organizer;
    }

    public final String component16() {
        return this.summary;
    }

    public final String component17() {
        return this.resource;
    }

    public final long component18() {
        return this.originalTime;
    }

    public final long component19() {
        return this.startTime;
    }

    public final String component2() {
        return this.attendee;
    }

    public final String component3() {
        return this.calendarId;
    }

    public final String component4() {
        return this.chatName;
    }

    public final String component5() {
        return this.creator;
    }

    public final long component6() {
        return this.crossDayEndTime;
    }

    public final int component7() {
        return this.crossDayNo;
    }

    public final long component8() {
        return this.crossDayStartTime;
    }

    public final int component9() {
        return this.crossDaySum;
    }

    public final CalendarResult copy(String r210, String r211, String r212, String r310, String r311, long r312, int r313, long r314, int r315, long r316, String r410, String r411, boolean r412, String r413, String r414, String r415, String r416, long r417, long r418) {
        return new CalendarResult(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarResult) == true) goto L8;
        return false;
    L8:
        CalendarResult r101 = (CalendarResult) r100;
        if (Intrinsics.areEqual(this.appLink, r101.appLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attendee, r101.attendee) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.calendarId, r101.calendarId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatName, r101.chatName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.creator, r101.creator) == true) goto L24;
        return false;
    L24:
        if (this.crossDayEndTime == r101.crossDayEndTime) goto L27;
        return false;
    L27:
        if (this.crossDayNo == r101.crossDayNo) goto L30;
        return false;
    L30:
        if (this.crossDayStartTime == r101.crossDayStartTime) goto L33;
        return false;
    L33:
        if (this.crossDaySum == r101.crossDaySum) goto L36;
        return false;
    L36:
        if (this.endTime == r101.endTime) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.eventServerId, r101.eventServerId) == true) goto L45;
        return false;
    L45:
        if (this.isAllDay == r101.isAllDay) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.organizer, r101.organizer) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.summary, r101.summary) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.resource, r101.resource) == true) goto L60;
        return false;
    L60:
        if (this.originalTime == r101.originalTime) goto L63;
        return false;
    L63:
        if (this.startTime == r101.startTime) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        String r100 = this.appLink;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.attendee;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.calendarId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.chatName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.creator;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.crossDayEndTime;
        int r117 = (((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.crossDayNo) * 31;
        long r118 = this.crossDayStartTime;
        int r119 = (((r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.crossDaySum) * 31;
        long r120 = this.endTime;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        String r122 = this.description;
        if (r122 != null) goto L25;
        int r123 = 0;
    L26:
        int r124 = (r121 + r123) * 31;
        String r125 = this.eventServerId;
        if (r125 != null) goto L29;
        int r126 = 0;
    L30:
        int r127 = (r124 + r126) * 31;
        if (this.isAllDay == false) goto L33;
        int r128 = 1231;
    L34:
        int r129 = (r127 + r128) * 31;
        String r130 = this.key;
        if (r130 != null) goto L37;
        int r131 = 0;
    L38:
        int r132 = (r129 + r131) * 31;
        String r133 = this.organizer;
        if (r133 != null) goto L41;
        int r134 = 0;
    L42:
        int r135 = (r132 + r134) * 31;
        String r136 = this.summary;
        if (r136 != null) goto L45;
        int r137 = 0;
    L46:
        int r138 = (r135 + r137) * 31;
        String r139 = this.resource;
        if (r139 == null) goto L50;
        r101 = r139.hashCode();
    L50:
        int r140 = (r138 + r101) * 31;
        long r141 = this.originalTime;
        int r142 = (r140 + ((int) (r141 ^ (r141 >>> 32)))) * 31;
        long r143 = this.startTime;
        return r142 + ((int) (r143 ^ (r143 >>> 32)));
    L45:
        r137 = r136.hashCode();
        goto L46
    L41:
        r134 = r133.hashCode();
        goto L42
    L37:
        r131 = r130.hashCode();
        goto L38
    L33:
        r128 = 1237;
        goto L34
    L29:
        r126 = r125.hashCode();
        goto L30
    L25:
        r123 = r122.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.appLink);
        r100.writeString(this.attendee);
        r100.writeString(this.calendarId);
        r100.writeString(this.chatName);
        r100.writeString(this.creator);
        r100.writeLong(this.crossDayEndTime);
        r100.writeInt(this.crossDayNo);
        r100.writeLong(this.crossDayStartTime);
        r100.writeInt(this.crossDaySum);
        r100.writeLong(this.endTime);
        r100.writeString(this.description);
        r100.writeString(this.eventServerId);
        r100.writeInt(this.isAllDay ? 1 : 0);
        r100.writeString(this.key);
        r100.writeString(this.organizer);
        r100.writeString(this.summary);
        r100.writeString(this.resource);
        r100.writeLong(this.originalTime);
        r100.writeLong(this.startTime);
    }

    public String toString() {
        return "CalendarResult(attendee=" + this.attendee + ", calendarId=" + this.calendarId + ", creator=" + this.creator + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", eventServerId=" + this.eventServerId + ", resource=" + this.resource + ", originalTime=" + this.originalTime + ')';
    }

    public final String getAppLink() {
        return this.appLink;
    }

    public final String getAttendee() {
        return this.attendee;
    }

    public final String getCalendarId() {
        return this.calendarId;
    }

    public final String getChatName() {
        return this.chatName;
    }

    public final String getCreator() {
        return this.creator;
    }

    public final long getCrossDayEndTime() {
        return this.crossDayEndTime;
    }

    public final int getCrossDayNo() {
        return this.crossDayNo;
    }

    public final long getCrossDayStartTime() {
        return this.crossDayStartTime;
    }

    public final int getCrossDaySum() {
        return this.crossDaySum;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getEventServerId() {
        return this.eventServerId;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getOrganizer() {
        return this.organizer;
    }

    public final long getOriginalTime() {
        return this.originalTime;
    }

    public final String getResource() {
        return this.resource;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final boolean isAllDay() {
        return this.isAllDay;
    }

    public final void setAllDay(boolean r100) {
        this.isAllDay = r100;
    }

    public final void setAppLink(String r100) {
        this.appLink = r100;
    }

    public final void setAttendee(String r100) {
        this.attendee = r100;
    }

    public final void setCalendarId(String r100) {
        this.calendarId = r100;
    }

    public final void setChatName(String r100) {
        this.chatName = r100;
    }

    public final void setCreator(String r100) {
        this.creator = r100;
    }

    public final void setCrossDayEndTime(long r100) {
        this.crossDayEndTime = r100;
    }

    public final void setCrossDayNo(int r100) {
        this.crossDayNo = r100;
    }

    public final void setCrossDayStartTime(long r100) {
        this.crossDayStartTime = r100;
    }

    public final void setCrossDaySum(int r100) {
        this.crossDaySum = r100;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setEventServerId(String r100) {
        this.eventServerId = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setOrganizer(String r100) {
        this.organizer = r100;
    }

    public final void setOriginalTime(long r100) {
        this.originalTime = r100;
    }

    public final void setResource(String r100) {
        this.resource = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setSummary(String r100) {
        this.summary = r100;
    }

    public CalendarResult(String r100, String r101, String r102, String r103, String r104, long r105, int r110, long r111, int r112, long r113, String r114, String r115, boolean r116, String r210, String r211, String r212, String r213, long r214, long r215) {
        this.appLink = r100;
        this.attendee = r101;
        this.calendarId = r102;
        this.chatName = r103;
        this.creator = r104;
        this.crossDayEndTime = r105;
        this.crossDayNo = r110;
        this.crossDayStartTime = r111;
        this.crossDaySum = r112;
        this.endTime = r113;
        this.description = r114;
        this.eventServerId = r115;
        this.isAllDay = r116;
        this.key = r210;
        this.organizer = r211;
        this.summary = r212;
        this.resource = r213;
        this.originalTime = r214;
        this.startTime = r215;
    }

    public /* synthetic */ CalendarResult(String r210, String r211, String r212, String r213, String r310, long r311, int r312, long r313, int r314, long r315, String r316, String r410, boolean r411, String r412, String r413, String r414, String r415, long r416, long r417, int r510, DefaultConstructorMarker r511) {
        if ((r510 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r510 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r510 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r510 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r510 & 32) == 0) goto L25;
        long r110 = 0;
    L27:
        if ((r510 & 64) == 0) goto L29;
        int r105 = 0;
    L31:
        if ((r510 & 128) == 0) goto L33;
        long r111 = 0;
    L35:
        if ((r510 & 256) == 0) goto L37;
        int r112 = 0;
    L39:
        if ((r510 & 512) == 0) goto L41;
        long r106 = 0;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        String r113 = "";
    L47:
        if ((r510 & 2048) == 0) goto L49;
        String r107 = "";
    L50:
        String r114 = r107;
        if ((r510 & 4096) == 0) goto L53;
        boolean r108 = false;
    L54:
        boolean r115 = r108;
        if ((r510 & 8192) == 0) goto L57;
        String r109 = "";
    L58:
        String r116 = r109;
        if ((r510 & 16384) == 0) goto L61;
        String r117 = "";
    L63:
        if ((r510 & 32768) == 0) goto L65;
        String r118 = "";
    L67:
        if ((r510 & 65536) == 0) goto L69;
        String r214 = "";
    L71:
        if ((r510 & 131072) == 0) goto L73;
        long r215 = 0;
    L75:
        if ((r510 & 262144) == 0) goto L77;
        long r216 = 0;
    L78:
        this(r100, r101, r102, r103, r104, r110, r105, r111, r112, r106, r113, r114, r115, r116, r117, r118, r214, r215, r216);
        return;
    L77:
        r216 = r417;
        goto L78
    L73:
        r215 = r416;
        goto L75
    L69:
        r214 = r415;
        goto L71
    L65:
        r118 = r414;
        goto L67
    L61:
        r117 = r413;
        goto L63
    L57:
        r109 = r412;
        goto L58
    L53:
        r108 = r411;
        goto L54
    L49:
        r107 = r410;
        goto L50
    L45:
        r113 = r316;
        goto L47
    L41:
        r106 = r315;
        goto L43
    L37:
        r112 = r314;
        goto L39
    L33:
        r111 = r313;
        goto L35
    L29:
        r105 = r312;
        goto L31
    L25:
        r110 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
