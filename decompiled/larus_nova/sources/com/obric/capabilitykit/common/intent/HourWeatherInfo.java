package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "Landroid/os/Parcelable;", "time", "", "temp", "", "weatherCode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getTemp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/String;", "getWeatherCode", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HourWeatherInfo implements Parcelable {
    public static final Parcelable.Creator<HourWeatherInfo> CREATOR = null;
    private final Integer temp;
    private final String time;
    private final String weatherCode;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<HourWeatherInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final HourWeatherInfo createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L6:
            HourWeatherInfo r104 = new HourWeatherInfo(r102, r103, r100.readString());
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L7:
            if (r107 > r105) goto L9;
            r107 = r107 + 1;
        L9:
            if (r107 > r101) goto L11;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L9
        L11:
            return r104;
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final HourWeatherInfo[] newArray(int r100) {
            return new HourWeatherInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public HourWeatherInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HourWeatherInfo copy$default(HourWeatherInfo r100, String r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.time;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.temp;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.weatherCode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.time;
    }

    public final Integer component2() {
        return this.temp;
    }

    public final String component3() {
        return this.weatherCode;
    }

    public final HourWeatherInfo copy(String r100, Integer r101, String r102) {
        return new HourWeatherInfo(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HourWeatherInfo) == true) goto L8;
        return false;
    L8:
        HourWeatherInfo r101 = (HourWeatherInfo) r100;
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.temp, r101.temp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.weatherCode, r101.weatherCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.time;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.temp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.weatherCode;
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
        return "HourWeatherInfo(time=" + this.time + ", temp=" + this.temp + ", weatherCode=" + this.weatherCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.time);
        Integer r103 = this.temp;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
        r100.writeString(this.weatherCode);
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public HourWeatherInfo(String r100, Integer r101, String r102) {
        this.time = r100;
        this.temp = r101;
        this.weatherCode = r102;
    }

    public /* synthetic */ HourWeatherInfo(String r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
