package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jz\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\rHÖ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\rHÖ\u0001J\u0012\u0010:\u001a\u00020\u00012\b\u0010;\u001a\u0004\u0018\u000108H\u0016J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\rHÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R(\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010)\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006B"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", DyPayConstant.KEY_START_TIME, "", "endTime", "timeType", "room", "participants", "", "agenda", "participantsId", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)V", "getAgenda", "()Ljava/lang/String;", "setAgenda", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getParticipants", "()[Ljava/lang/String;", "setParticipants", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getParticipantsId$annotations", "()V", "getParticipantsId", "setParticipantsId", "getRoom", "setRoom", "getStartTime", "setStartTime", "getTimeType", "setTimeType", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeSearchMeetingParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSearchMeetingParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeSearchMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    private String timeType;
    Integer version;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<OfficeSearchMeetingParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            OfficeSearchMeetingParams r101 = new OfficeSearchMeetingParams(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.createStringArray(), r110.readString(), null, null, 192, null);
            int r102 = Math.min(r100, 2);
            ClassLoader r103 = a.class.getClassLoader();
            int r104 = 1;
        L3:
            if (r104 > r102) goto L13;
            if (r104 != 1) goto L8;
            Object r105 = joa.a.c(r110, r103);
            if (r105 == null) goto L12;
            r101.participantsId = (String[]) r105;
        L12:
            r104 = r104 + 1;
            goto L3
        L8:
            if (r104 != 2) goto L12;
            Object r106 = joa.a.c(r110, r103);
            if (r106 == null) goto L12;
            r101.version = (Integer) r106;
        L13:
            if (r104 > r100) goto L15;
            joa.a.d(r110, r103);
            r104 = r104 + 1;
            goto L13
        L15:
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeSearchMeetingParams[] newArray(int r100) {
            return new OfficeSearchMeetingParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OfficeSearchMeetingParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ OfficeSearchMeetingParams copy$default(OfficeSearchMeetingParams r100, String r110, String r111, String r112, String r113, String[] r114, String r115, String[] r116, Integer r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.startTime;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.endTime;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.timeType;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.room;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String[] r105 = r100.participants;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.agenda;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String[] r107 = r100.participantsId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Integer r108 = r100.version;
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

    public static /* synthetic */ void getParticipantsId$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.startTime;
    }

    public final String component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.timeType;
    }

    public final String component4() {
        return this.room;
    }

    public final String[] component5() {
        return this.participants;
    }

    public final String component6() {
        return this.agenda;
    }

    public final String[] component7() {
        return this.participantsId;
    }

    public final Integer component8() {
        return this.version;
    }

    public final OfficeSearchMeetingParams copy(String r110, String r111, String r112, String r113, String[] r114, String r115, String[] r116, Integer r117) {
        return new OfficeSearchMeetingParams(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSearchMeetingParams) == true) goto L8;
        return false;
    L8:
        OfficeSearchMeetingParams r101 = (OfficeSearchMeetingParams) r100;
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeType, r101.timeType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.room, r101.room) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.participants, r101.participants) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.agenda, r101.agenda) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.participantsId, r101.participantsId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.startTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.endTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.timeType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.room;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String[] r113 = this.participants;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.agenda;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String[] r119 = this.participantsId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.version;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = Arrays.hashCode(r119);
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = Arrays.hashCode(r113);
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "OfficeSearchMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", timeType=" + this.timeType + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
        r100.writeString(this.timeType);
        r100.writeString(this.room);
        r100.writeStringArray(this.participants);
        r100.writeString(this.agenda);
        r100.writeValue(this.participantsId);
        r100.writeValue(this.version);
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String[] getParticipants() {
        return this.participants;
    }

    public final String[] getParticipantsId() {
        return this.participantsId;
    }

    public final String getRoom() {
        return this.room;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getTimeType() {
        return this.timeType;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof OfficeSearchMeetingParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.startTime;
        if (r100 != null) goto L8;
        r100 = ((OfficeSearchMeetingParams) r110).startTime;
    L8:
        String r101 = r100;
        String r102 = this.endTime;
        if (r102 != null) goto L11;
        r102 = ((OfficeSearchMeetingParams) r110).endTime;
    L11:
        String r103 = r102;
        String r104 = this.timeType;
        if (r104 != null) goto L14;
        r104 = ((OfficeSearchMeetingParams) r110).timeType;
    L14:
        String r105 = r104;
        String r106 = this.room;
        if (r106 != null) goto L17;
        r106 = ((OfficeSearchMeetingParams) r110).room;
    L17:
        String r107 = r106;
        String[] r108 = this.participants;
        if (r108 != null) goto L20;
        r108 = ((OfficeSearchMeetingParams) r110).participants;
    L20:
        String[] r109 = r108;
        String r111 = this.agenda;
        if (r111 != null) goto L23;
        r111 = ((OfficeSearchMeetingParams) r110).agenda;
    L23:
        String r112 = r111;
        String[] r113 = this.participantsId;
        if (r113 != null) goto L26;
        r113 = ((OfficeSearchMeetingParams) r110).participantsId;
    L26:
        String[] r114 = r113;
        Integer r115 = this.version;
        if (r115 != null) goto L29;
        Integer r116 = ((OfficeSearchMeetingParams) r110).version;
    L31:
        return new OfficeSearchMeetingParams(r101, r103, r105, r107, r109, r112, r114, r116);
    L29:
        r116 = r115;
        goto L31
    }

    public final void setAgenda(String r100) {
        this.agenda = r100;
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setParticipants(String[] r100) {
        this.participants = r100;
    }

    public final void setParticipantsId(String[] r100) {
        this.participantsId = r100;
    }

    public final void setRoom(String r100) {
        this.room = r100;
    }

    public final void setStartTime(String r100) {
        this.startTime = r100;
    }

    public final void setTimeType(String r100) {
        this.timeType = r100;
    }

    public final void setVersion(Integer r100) {
        this.version = r100;
    }

    public OfficeSearchMeetingParams(String r100, String r101, String r102, String r103, String[] r104, String r105, String[] r106, Integer r107) {
        this.startTime = r100;
        this.endTime = r101;
        this.timeType = r102;
        this.room = r103;
        this.participants = r104;
        this.agenda = r105;
        this.participantsId = r106;
        this.version = r107;
    }

    public /* synthetic */ OfficeSearchMeetingParams(String r110, String r111, String r112, String r113, String[] r114, String r115, String[] r116, Integer r117, int r118, DefaultConstructorMarker r119) {
        Integer r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String[] r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String[] r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
}
