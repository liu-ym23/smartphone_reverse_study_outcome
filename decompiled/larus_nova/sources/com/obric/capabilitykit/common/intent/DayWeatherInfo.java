package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "Landroid/os/Parcelable;", "date", "", "lowTemp", "", "highTemp", "weatherCode", "sunRise", "sunSet", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getHighTemp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLowTemp", "getSunRise", "getSunSet", "getWeatherCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DayWeatherInfo implements Parcelable {
    public static final Parcelable.Creator<DayWeatherInfo> CREATOR = null;
    private final String date;
    private final Integer highTemp;
    private final Integer lowTemp;
    private final String sunRise;
    private final String sunSet;
    private final String weatherCode;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<DayWeatherInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DayWeatherInfo createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Integer r103 = null;
        L10:
            DayWeatherInfo r104 = new DayWeatherInfo(r101, r102, r103, r110.readString(), r110.readString(), r110.readString());
            int r105 = Math.min(r100, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L11:
            if (r107 > r105) goto L13;
            r107 = r107 + 1;
        L13:
            if (r107 > r100) goto L15;
            joa.a.d(r110, r106);
            r107 = r107 + 1;
            goto L13
        L15:
            return r104;
        L9:
            r103 = Integer.valueOf(r110.readInt());
            goto L10
        L5:
            r102 = Integer.valueOf(r110.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DayWeatherInfo[] newArray(int r100) {
            return new DayWeatherInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public DayWeatherInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DayWeatherInfo copy$default(DayWeatherInfo r100, String r101, Integer r102, Integer r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.date;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.lowTemp;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.highTemp;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.weatherCode;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.sunRise;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.sunSet;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.date;
    }

    public final Integer component2() {
        return this.lowTemp;
    }

    public final Integer component3() {
        return this.highTemp;
    }

    public final String component4() {
        return this.weatherCode;
    }

    public final String component5() {
        return this.sunRise;
    }

    public final String component6() {
        return this.sunSet;
    }

    public final DayWeatherInfo copy(String r100, Integer r110, Integer r111, String r112, String r113, String r114) {
        return new DayWeatherInfo(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DayWeatherInfo) == true) goto L8;
        return false;
    L8:
        DayWeatherInfo r101 = (DayWeatherInfo) r100;
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lowTemp, r101.lowTemp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.highTemp, r101.highTemp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.weatherCode, r101.weatherCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sunRise, r101.sunRise) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sunSet, r101.sunSet) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.date;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.lowTemp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.highTemp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.weatherCode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sunRise;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.sunSet;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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

    public String toString() {
        return "DayWeatherInfo(date=" + this.date + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", weatherCode=" + this.weatherCode + ", sunRise=" + this.sunRise + ", sunSet=" + this.sunSet + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.date);
        Integer r103 = this.lowTemp;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r104 = this.highTemp;
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r102 = r104.intValue();
    L10:
        r100.writeInt(r102);
        r100.writeString(this.weatherCode);
        r100.writeString(this.sunRise);
        r100.writeString(this.sunSet);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L6
    }

    public final String getDate() {
        return this.date;
    }

    public final Integer getHighTemp() {
        return this.highTemp;
    }

    public final Integer getLowTemp() {
        return this.lowTemp;
    }

    public final String getSunRise() {
        return this.sunRise;
    }

    public final String getSunSet() {
        return this.sunSet;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public DayWeatherInfo(String r100, Integer r101, Integer r102, String r103, String r104, String r105) {
        this.date = r100;
        this.lowTemp = r101;
        this.highTemp = r102;
        this.weatherCode = r103;
        this.sunRise = r104;
        this.sunSet = r105;
    }

    public /* synthetic */ DayWeatherInfo(String r100, Integer r101, Integer r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
