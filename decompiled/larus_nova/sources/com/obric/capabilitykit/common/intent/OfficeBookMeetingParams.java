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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#Jn\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\fHÖ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\fHÖ\u0001J\u0012\u00106\u001a\u00020\u00012\b\u00107\u001a\u0004\u0018\u000104H\u0016J\t\u00108\u001a\u00020\u0004HÖ\u0001J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\fHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010&\u0012\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeBookMeetingParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", DyPayConstant.KEY_START_TIME, "", "endTime", "room", "participants", "", "agenda", "participantsId", "version", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)V", "getAgenda", "()Ljava/lang/String;", "setAgenda", "(Ljava/lang/String;)V", "getEndTime", "setEndTime", "getParticipants", "()[Ljava/lang/String;", "setParticipants", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getParticipantsId$annotations", "()V", "getParticipantsId", "setParticipantsId", "getRoom", "setRoom", "getStartTime", "setStartTime", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/OfficeBookMeetingParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeBookMeetingParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeBookMeetingParams> CREATOR = null;
    private String agenda;
    private String endTime;
    private String[] participants;
    String[] participantsId;
    private String room;
    private String startTime;
    Integer version;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<OfficeBookMeetingParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfficeBookMeetingParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            OfficeBookMeetingParams r101 = new OfficeBookMeetingParams(r110.readString(), r110.readString(), r110.readString(), r110.createStringArray(), r110.readString(), null, null, 96, null);
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
        public final OfficeBookMeetingParams[] newArray(int r100) {
            return new OfficeBookMeetingParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public OfficeBookMeetingParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ OfficeBookMeetingParams copy$default(OfficeBookMeetingParams r100, String r101, String r102, String r103, String[] r104, String r110, String[] r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.startTime;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.endTime;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.room;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.participants;
    L14:
        String[] r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.agenda;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.participantsId;
    L20:
        String[] r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.version;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
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
        return this.room;
    }

    public final String[] component4() {
        return this.participants;
    }

    public final String component5() {
        return this.agenda;
    }

    public final String[] component6() {
        return this.participantsId;
    }

    public final Integer component7() {
        return this.version;
    }

    public final OfficeBookMeetingParams copy(String r110, String r111, String r112, String[] r113, String r114, String[] r115, Integer r116) {
        return new OfficeBookMeetingParams(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeBookMeetingParams) == true) goto L8;
        return false;
    L8:
        OfficeBookMeetingParams r101 = (OfficeBookMeetingParams) r100;
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.room, r101.room) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r101.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.agenda, r101.agenda) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.participantsId, r101.participantsId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L29;
        return false;
    L29:
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
        String r107 = this.room;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String[] r110 = this.participants;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.agenda;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String[] r116 = this.participantsId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.version;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = Arrays.hashCode(r116);
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = Arrays.hashCode(r110);
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
        return "OfficeBookMeetingParams(startTime=" + this.startTime + ", endTime=" + this.endTime + ", room=" + this.room + ", participants=" + Arrays.toString(this.participants) + ", agenda=" + this.agenda + ", participantsId=" + Arrays.toString(this.participantsId) + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
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

    public final Integer getVersion() {
        return this.version;
    }

    public IntentParams mergeParams(Object r110) {
        if ((r110 instanceof OfficeBookMeetingParams) == true) goto L5;
        return this;
    L5:
        String r100 = this.startTime;
        if (r100 != null) goto L8;
        r100 = ((OfficeBookMeetingParams) r110).startTime;
    L8:
        String r101 = r100;
        String r102 = this.endTime;
        if (r102 != null) goto L11;
        r102 = ((OfficeBookMeetingParams) r110).endTime;
    L11:
        String r103 = r102;
        String r104 = this.room;
        if (r104 != null) goto L14;
        r104 = ((OfficeBookMeetingParams) r110).room;
    L14:
        String r105 = r104;
        String[] r106 = this.participants;
        if (r106 != null) goto L17;
        r106 = ((OfficeBookMeetingParams) r110).participants;
    L17:
        String[] r107 = r106;
        String r108 = this.agenda;
        if (r108 != null) goto L20;
        r108 = ((OfficeBookMeetingParams) r110).agenda;
    L20:
        String r109 = r108;
        String[] r111 = this.participantsId;
        if (r111 != null) goto L23;
        r111 = ((OfficeBookMeetingParams) r110).participantsId;
    L23:
        String[] r112 = r111;
        Integer r113 = this.version;
        if (r113 != null) goto L26;
        Integer r114 = ((OfficeBookMeetingParams) r110).version;
    L28:
        return new OfficeBookMeetingParams(r101, r103, r105, r107, r109, r112, r114);
    L26:
        r114 = r113;
        goto L28
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

    public final void setVersion(Integer r100) {
        this.version = r100;
    }

    public OfficeBookMeetingParams(String r100, String r101, String r102, String[] r103, String r104, String[] r105, Integer r106) {
        this.startTime = r100;
        this.endTime = r101;
        this.room = r102;
        this.participants = r103;
        this.agenda = r104;
        this.participantsId = r105;
        this.version = r106;
    }

    public /* synthetic */ OfficeBookMeetingParams(String r100, String r101, String r102, String[] r110, String r111, String[] r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String[] r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String[] r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
