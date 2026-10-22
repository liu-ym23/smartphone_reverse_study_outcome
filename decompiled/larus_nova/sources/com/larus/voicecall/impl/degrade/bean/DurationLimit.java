package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\""}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/DurationLimit;", "Landroid/os/Parcelable;", "dayAvailableSecs", "", "dayLimitToast", "", "monthAvailableSecs", "monthLimitToast", "<init>", "(JLjava/lang/String;JLjava/lang/String;)V", "getDayAvailableSecs", "()J", "getDayLimitToast", "()Ljava/lang/String;", "getMonthAvailableSecs", "getMonthLimitToast", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DurationLimit implements Parcelable {
    public static final Parcelable.Creator<DurationLimit> CREATOR = null;

    @SerializedName("day_available_secs")
    private final long dayAvailableSecs;

    @SerializedName("day_limit_toast")
    private final String dayLimitToast;

    @SerializedName("month_available_secs")
    private final long monthAvailableSecs;

    @SerializedName("month_limit_toast")
    private final String monthLimitToast;

    public static final class a implements Parcelable.Creator<DurationLimit> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DurationLimit createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new DurationLimit(r100.readLong(), r100.readString(), r100.readLong(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DurationLimit[] newArray(int r100) {
            return new DurationLimit[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DurationLimit() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ DurationLimit copy$default(DurationLimit r100, long r101, String r110, long r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.dayAvailableSecs;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.dayLimitToast;
    L8:
        String r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.monthAvailableSecs;
    L11:
        long r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.monthLimitToast;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.dayAvailableSecs;
    }

    public final String component2() {
        return this.dayLimitToast;
    }

    public final long component3() {
        return this.monthAvailableSecs;
    }

    public final String component4() {
        return this.monthLimitToast;
    }

    public final DurationLimit copy(long r100, String r110, long r111, String r112) {
        return new DurationLimit(r100, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DurationLimit) == true) goto L8;
        return false;
    L8:
        DurationLimit r101 = (DurationLimit) r100;
        if (this.dayAvailableSecs == r101.dayAvailableSecs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dayLimitToast, r101.dayLimitToast) == true) goto L15;
        return false;
    L15:
        if (this.monthAvailableSecs == r101.monthAvailableSecs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.monthLimitToast, r101.monthLimitToast) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.dayAvailableSecs;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.dayLimitToast;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.monthAvailableSecs;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.monthLimitToast;
        if (r107 == null) goto L11;
        r103 = r107.hashCode();
    L11:
        return r106 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "DurationLimit(dayAvailableSecs=" + this.dayAvailableSecs + ", dayLimitToast=" + this.dayLimitToast + ", monthAvailableSecs=" + this.monthAvailableSecs + ", monthLimitToast=" + this.monthLimitToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.dayAvailableSecs);
        r100.writeString(this.dayLimitToast);
        r100.writeLong(this.monthAvailableSecs);
        r100.writeString(this.monthLimitToast);
    }

    public final long getDayAvailableSecs() {
        return this.dayAvailableSecs;
    }

    public final String getDayLimitToast() {
        return this.dayLimitToast;
    }

    public final long getMonthAvailableSecs() {
        return this.monthAvailableSecs;
    }

    public final String getMonthLimitToast() {
        return this.monthLimitToast;
    }

    public DurationLimit(long r100, String r101, long r102, String r103) {
        this.dayAvailableSecs = r100;
        this.dayLimitToast = r101;
        this.monthAvailableSecs = r102;
        this.monthLimitToast = r103;
    }

    public /* synthetic */ DurationLimit(long r100, String r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
        long r103 = -1;
        if ((r111 & 1) == 0) goto L5;
        long r104 = -1;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r113 = null;
    L11:
        if ((r111 & 4) != 0) goto L15;
        r103 = r102;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r114 = null;
    L18:
        this(r104, r113, r103, r114);
        return;
    L17:
        r114 = r110;
        goto L18
    L9:
        r113 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
