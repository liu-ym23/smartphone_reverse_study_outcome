package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;", "Landroid/os/Parcelable;", "buildingId", "", "calendarId", SocialConstants.PARAM_APP_DESC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuildingId", "()Ljava/lang/String;", "getCalendarId", "getDesc", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarRoomDetail implements Parcelable {
    public static final Parcelable.Creator<CalendarRoomDetail> CREATOR = null;
    private final String buildingId;
    private final String calendarId;
    private final String desc;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarRoomDetail> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarRoomDetail createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CalendarRoomDetail(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarRoomDetail createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarRoomDetail[] newArray(int r100) {
            return new CalendarRoomDetail[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarRoomDetail[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ CalendarRoomDetail copy$default(CalendarRoomDetail r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.buildingId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.calendarId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.desc;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.buildingId;
    }

    public final String component2() {
        return this.calendarId;
    }

    public final String component3() {
        return this.desc;
    }

    public final CalendarRoomDetail copy(String r100, String r101, String r102) {
        return new CalendarRoomDetail(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarRoomDetail) == true) goto L8;
        return false;
    L8:
        CalendarRoomDetail r101 = (CalendarRoomDetail) r100;
        if (Intrinsics.areEqual(this.buildingId, r101.buildingId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.calendarId, r101.calendarId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.buildingId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.calendarId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.desc;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CalendarRoomDetail(buildingId=" + this.buildingId + ", calendarId=" + this.calendarId + ", desc=" + this.desc + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.buildingId);
        r100.writeString(this.calendarId);
        r100.writeString(this.desc);
    }

    public final String getBuildingId() {
        return this.buildingId;
    }

    public final String getCalendarId() {
        return this.calendarId;
    }

    public final String getDesc() {
        return this.desc;
    }

    public CalendarRoomDetail(String r100, String r101, String r102) {
        this.buildingId = r100;
        this.calendarId = r101;
        this.desc = r102;
    }
}
