package com.larus.voicecall.impl.degrade.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006$"}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/TimeConfig;", "Landroid/os/Parcelable;", "totalDuration", "", "totalToast", "", "onceDuration", "onceToast", "<init>", "(JLjava/lang/String;JLjava/lang/String;)V", "getTotalDuration", "()J", "getTotalToast", "()Ljava/lang/String;", "getOnceDuration", "getOnceToast", "isTotalTimeLimitValid", "", "isOnceTimeLimitValid", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeConfig implements Parcelable {
    public static final Parcelable.Creator<TimeConfig> CREATOR = null;

    @SerializedName("once_duration")
    private final long onceDuration;

    @SerializedName("once_toast")
    private final String onceToast;

    @SerializedName("total_duration")
    private final long totalDuration;

    @SerializedName("total_toast")
    private final String totalToast;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<TimeConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TimeConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TimeConfig(r100.readLong(), r100.readString(), r100.readLong(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeConfig[] newArray(int r100) {
            return new TimeConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimeConfig() {
        this(0, null, 0, null, 15, null);
    }

    public static /* synthetic */ TimeConfig copy$default(TimeConfig r100, long r101, String r110, long r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.totalDuration;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.totalToast;
    L8:
        String r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.onceDuration;
    L11:
        long r104 = r111;
        if ((r113 & 8) == 0) goto L15;
        r112 = r100.onceToast;
    L15:
        return r100.copy(r102, r103, r104, r112);
    }

    public final long component1() {
        return this.totalDuration;
    }

    public final String component2() {
        return this.totalToast;
    }

    public final long component3() {
        return this.onceDuration;
    }

    public final String component4() {
        return this.onceToast;
    }

    public final TimeConfig copy(long r100, String r110, long r111, String r112) {
        return new TimeConfig(r100, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeConfig) == true) goto L8;
        return false;
    L8:
        TimeConfig r101 = (TimeConfig) r100;
        if (this.totalDuration == r101.totalDuration) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.totalToast, r101.totalToast) == true) goto L15;
        return false;
    L15:
        if (this.onceDuration == r101.onceDuration) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.onceToast, r101.onceToast) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.totalDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.totalToast;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.onceDuration;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.onceToast;
        if (r107 == null) goto L11;
        r103 = r107.hashCode();
    L11:
        return r106 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "TimeConfig(totalDuration=" + this.totalDuration + ", totalToast=" + this.totalToast + ", onceDuration=" + this.onceDuration + ", onceToast=" + this.onceToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.totalDuration);
        r100.writeString(this.totalToast);
        r100.writeLong(this.onceDuration);
        r100.writeString(this.onceToast);
    }

    public final boolean isOnceTimeLimitValid() {
        if (this.onceDuration < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTotalTimeLimitValid() {
        if (this.totalDuration < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getOnceDuration() {
        return this.onceDuration;
    }

    public final String getOnceToast() {
        return this.onceToast;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final String getTotalToast() {
        return this.totalToast;
    }

    public TimeConfig(long r100, String r101, long r102, String r103) {
        this.totalDuration = r100;
        this.totalToast = r101;
        this.onceDuration = r102;
        this.onceToast = r103;
    }

    public /* synthetic */ TimeConfig(long r100, String r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
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
