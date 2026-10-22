package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "Landroid/os/Parcelable;", "startHour", "", "endHour", "maxShowCountPerDay", "maxShowCountTotal", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getStartHour", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndHour", "getMaxShowCountPerDay", "getMaxShowCountTotal", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/chat/bean/PopWindowFrequencyConf;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopWindowFrequencyConf implements Parcelable {
    public static final Parcelable.Creator<PopWindowFrequencyConf> CREATOR = null;

    @SerializedName("end_hour")
    private final Long endHour;

    @SerializedName("max_show_count_per_day")
    private final Long maxShowCountPerDay;

    @SerializedName("max_show_count_total")
    private final Long maxShowCountTotal;

    @SerializedName("start_hour")
    private final Long startHour;

    public static final class a implements Parcelable.Creator<PopWindowFrequencyConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowFrequencyConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Long r101 = null;
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Long r103 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            Long r104 = null;
        L15:
            if (r100.readInt() == 0) goto L19;
            r101 = Long.valueOf(r100.readLong());
        L19:
            return new PopWindowFrequencyConf(r102, r103, r104, r101);
        L13:
            r104 = Long.valueOf(r100.readLong());
            goto L15
        L9:
            r103 = Long.valueOf(r100.readLong());
            goto L11
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowFrequencyConf[] newArray(int r100) {
            return new PopWindowFrequencyConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowFrequencyConf() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PopWindowFrequencyConf copy$default(PopWindowFrequencyConf r100, Long r101, Long r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.startHour;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.endHour;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.maxShowCountPerDay;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxShowCountTotal;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.startHour;
    }

    public final Long component2() {
        return this.endHour;
    }

    public final Long component3() {
        return this.maxShowCountPerDay;
    }

    public final Long component4() {
        return this.maxShowCountTotal;
    }

    public final PopWindowFrequencyConf copy(Long r100, Long r101, Long r102, Long r103) {
        return new PopWindowFrequencyConf(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PopWindowFrequencyConf) == true) goto L8;
        return false;
    L8:
        PopWindowFrequencyConf r101 = (PopWindowFrequencyConf) r100;
        if (Intrinsics.areEqual(this.startHour, r101.startHour) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endHour, r101.endHour) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxShowCountPerDay, r101.maxShowCountPerDay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxShowCountTotal, r101.maxShowCountTotal) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r100 = this.startHour;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.endHour;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.maxShowCountPerDay;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.maxShowCountTotal;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public String toString() {
        return "PopWindowFrequencyConf(startHour=" + this.startHour + ", endHour=" + this.endHour + ", maxShowCountPerDay=" + this.maxShowCountPerDay + ", maxShowCountTotal=" + this.maxShowCountTotal + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.startHour;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.endHour;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Long r104 = this.maxShowCountPerDay;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Long r105 = this.maxShowCountTotal;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeLong(r105.longValue());
        return;
    L13:
        r100.writeInt(1);
        r100.writeLong(r104.longValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final Long getEndHour() {
        return this.endHour;
    }

    public final Long getMaxShowCountPerDay() {
        return this.maxShowCountPerDay;
    }

    public final Long getMaxShowCountTotal() {
        return this.maxShowCountTotal;
    }

    public final Long getStartHour() {
        return this.startHour;
    }

    public PopWindowFrequencyConf(Long r100, Long r101, Long r102, Long r103) {
        this.startHour = r100;
        this.endHour = r101;
        this.maxShowCountPerDay = r102;
        this.maxShowCountTotal = r103;
    }

    public /* synthetic */ PopWindowFrequencyConf(Long r100, Long r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
