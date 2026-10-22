package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJÚ\u0001\u0010?\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010@J\t\u0010A\u001a\u00020\bHÖ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\bHÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b.\u0010\u001a¨\u0006M"}, d2 = {"Lcom/obric/capabilitykit/common/intent/WeatherInfo;", "Landroid/os/Parcelable;", "timezone", "", "location", "windDirection", "", "windSpeed", "", "uvLevel", "humidity", "aqi", "temp", "feelTemp", "lowTemp", "highTemp", "weatherCode", "hourlyWeather", "", "Lcom/obric/capabilitykit/common/intent/HourWeatherInfo;", "dailyWeather", "Lcom/obric/capabilitykit/common/intent/DayWeatherInfo;", "minuteRainDesc", "minuteRainShortDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAqi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDailyWeather", "()Ljava/util/List;", "getFeelTemp", "getHighTemp", "getHourlyWeather", "getHumidity", "getLocation", "()Ljava/lang/String;", "getLowTemp", "getMinuteRainDesc", "getMinuteRainShortDesc", "getTemp", "getTimezone", "getUvLevel", "getWeatherCode", "getWindDirection", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getWindSpeed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/WeatherInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WeatherInfo implements Parcelable {
    public static final Parcelable.Creator<WeatherInfo> CREATOR = null;
    private final Integer aqi;
    private final List<DayWeatherInfo> dailyWeather;
    private final Integer feelTemp;
    private final Integer highTemp;
    private final List<HourWeatherInfo> hourlyWeather;
    private final Integer humidity;
    private final String location;
    private final Integer lowTemp;
    private final String minuteRainDesc;
    private final String minuteRainShortDesc;
    private final Integer temp;
    private final String timezone;
    private final String uvLevel;
    private final String weatherCode;
    private final Double windDirection;
    private final Integer windSpeed;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<WeatherInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WeatherInfo createFromParcel(Parcel r210) {
            int r100 = r210.readInt();
            Intrinsics.checkNotNullParameter(r210, "parcel");
            String r101 = r210.readString();
            String r102 = r210.readString();
            if (r210.readInt() != 0) goto L5;
            Double r103 = null;
        L7:
            if (r210.readInt() != 0) goto L9;
            Integer r104 = null;
        L10:
            String r105 = r210.readString();
            if (r210.readInt() != 0) goto L13;
            Integer r106 = null;
        L15:
            if (r210.readInt() != 0) goto L17;
            Integer r110 = null;
        L19:
            if (r210.readInt() != 0) goto L21;
            Integer r111 = null;
        L23:
            if (r210.readInt() != 0) goto L25;
            Integer r112 = null;
        L27:
            if (r210.readInt() != 0) goto L29;
            Integer r113 = null;
        L31:
            if (r210.readInt() != 0) goto L33;
            Integer r114 = null;
        L34:
            String r115 = r210.readString();
            if (r210.readInt() != 0) goto L37;
            ArrayList r107 = null;
        L42:
            if (r210.readInt() != 0) goto L44;
            ArrayList r116 = null;
        L48:
            WeatherInfo r108 = new WeatherInfo(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r116, r210.readString(), r210.readString());
            int r109 = Math.min(r100, 0);
            ClassLoader r117 = a.class.getClassLoader();
            int r118 = 1;
        L49:
            if (r118 > r109) goto L51;
            r118 = r118 + 1;
        L51:
            if (r118 > r100) goto L53;
            joa.a.d(r210, r117);
            r118 = r118 + 1;
            goto L51
        L53:
            return r108;
        L44:
            int r119 = r210.readInt();
            ArrayList r120 = new ArrayList(r119);
            int r121 = 0;
        L45:
            if (r121 == r119) goto L47;
            int r122 = r119;
            r120.add(DayWeatherInfo.CREATOR.createFromParcel(r210));
            r121 = r121 + 1;
            r119 = r122;
            goto L45
        L47:
            r116 = r120;
            goto L48
        L37:
            int r123 = r210.readInt();
            ArrayList r124 = new ArrayList(r123);
            int r125 = 0;
        L38:
            if (r125 == r123) goto L40;
            int r126 = r123;
            r124.add(HourWeatherInfo.CREATOR.createFromParcel(r210));
            r125 = r125 + 1;
            r123 = r126;
            goto L38
        L40:
            r107 = r124;
            goto L42
        L33:
            r114 = Integer.valueOf(r210.readInt());
            goto L34
        L29:
            r113 = Integer.valueOf(r210.readInt());
            goto L31
        L25:
            r112 = Integer.valueOf(r210.readInt());
            goto L27
        L21:
            r111 = Integer.valueOf(r210.readInt());
            goto L23
        L17:
            r110 = Integer.valueOf(r210.readInt());
            goto L19
        L13:
            r106 = Integer.valueOf(r210.readInt());
            goto L15
        L9:
            r104 = Integer.valueOf(r210.readInt());
            goto L10
        L5:
            r103 = Double.valueOf(r210.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final WeatherInfo[] newArray(int r100) {
            return new WeatherInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public WeatherInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WeatherInfo copy$default(WeatherInfo r110, String r111, String r112, Double r210, Integer r211, String r212, Integer r213, Integer r214, Integer r215, Integer r216, Integer r217, Integer r218, String r219, List r310, List r311, String r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.timezone;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.location;
    L11:
        if ((r314 & 4) == 0) goto L13;
        Double r102 = r110.windDirection;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Integer r103 = r110.windSpeed;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.uvLevel;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Integer r105 = r110.humidity;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Integer r106 = r110.aqi;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Integer r107 = r110.temp;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Integer r113 = r110.feelTemp;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Integer r114 = r110.lowTemp;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Integer r115 = r110.highTemp;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.weatherCode;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        List r117 = r110.hourlyWeather;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r118 = r110.dailyWeather;
    L58:
        List r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.minuteRainDesc;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.minuteRainShortDesc;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
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
        return this.timezone;
    }

    public final Integer component10() {
        return this.lowTemp;
    }

    public final Integer component11() {
        return this.highTemp;
    }

    public final String component12() {
        return this.weatherCode;
    }

    public final List<HourWeatherInfo> component13() {
        return this.hourlyWeather;
    }

    public final List<DayWeatherInfo> component14() {
        return this.dailyWeather;
    }

    public final String component15() {
        return this.minuteRainDesc;
    }

    public final String component16() {
        return this.minuteRainShortDesc;
    }

    public final String component2() {
        return this.location;
    }

    public final Double component3() {
        return this.windDirection;
    }

    public final Integer component4() {
        return this.windSpeed;
    }

    public final String component5() {
        return this.uvLevel;
    }

    public final Integer component6() {
        return this.humidity;
    }

    public final Integer component7() {
        return this.aqi;
    }

    public final Integer component8() {
        return this.temp;
    }

    public final Integer component9() {
        return this.feelTemp;
    }

    public final WeatherInfo copy(String r110, String r210, Double r211, Integer r212, String r213, Integer r214, Integer r215, Integer r216, Integer r217, Integer r218, Integer r219, String r310, List<HourWeatherInfo> r311, List<DayWeatherInfo> r312, String r313, String r314) {
        return new WeatherInfo(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WeatherInfo) == true) goto L8;
        return false;
    L8:
        WeatherInfo r101 = (WeatherInfo) r100;
        if (Intrinsics.areEqual(this.timezone, r101.timezone) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.windDirection, r101.windDirection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.windSpeed, r101.windSpeed) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uvLevel, r101.uvLevel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.humidity, r101.humidity) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aqi, r101.aqi) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.temp, r101.temp) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.feelTemp, r101.feelTemp) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lowTemp, r101.lowTemp) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.highTemp, r101.highTemp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.weatherCode, r101.weatherCode) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hourlyWeather, r101.hourlyWeather) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.dailyWeather, r101.dailyWeather) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.minuteRainDesc, r101.minuteRainDesc) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.minuteRainShortDesc, r101.minuteRainShortDesc) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.timezone;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.location;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.windDirection;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.windSpeed;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.uvLevel;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.humidity;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.aqi;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.temp;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.feelTemp;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.lowTemp;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.highTemp;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.weatherCode;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<HourWeatherInfo> r137 = this.hourlyWeather;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<DayWeatherInfo> r140 = this.dailyWeather;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.minuteRainDesc;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.minuteRainShortDesc;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
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

    public String toString() {
        return "WeatherInfo(timezone=" + this.timezone + ", location=" + this.location + ", windDirection=" + this.windDirection + ", windSpeed=" + this.windSpeed + ", uvLevel=" + this.uvLevel + ", humidity=" + this.humidity + ", aqi=" + this.aqi + ", temp=" + this.temp + ", feelTemp=" + this.feelTemp + ", lowTemp=" + this.lowTemp + ", highTemp=" + this.highTemp + ", weatherCode=" + this.weatherCode + ", hourlyWeather=" + this.hourlyWeather + ", dailyWeather=" + this.dailyWeather + ", minuteRainDesc=" + this.minuteRainDesc + ", minuteRainShortDesc=" + this.minuteRainShortDesc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.timezone);
        r100.writeString(this.location);
        Double r102 = this.windDirection;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.windSpeed;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.uvLevel);
        Integer r104 = this.humidity;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Integer r105 = this.aqi;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L18:
        Integer r106 = this.temp;
        if (r106 != null) goto L21;
        r100.writeInt(0);
    L22:
        Integer r107 = this.feelTemp;
        if (r107 != null) goto L25;
        r100.writeInt(0);
    L26:
        Integer r108 = this.lowTemp;
        if (r108 != null) goto L29;
        r100.writeInt(0);
    L30:
        Integer r109 = this.highTemp;
        if (r109 != null) goto L33;
        r100.writeInt(0);
    L34:
        r100.writeString(this.weatherCode);
        List<HourWeatherInfo> r110 = this.hourlyWeather;
        if (r110 != null) goto L37;
        r100.writeInt(0);
    L41:
        List<DayWeatherInfo> r111 = this.dailyWeather;
        if (r111 != null) goto L44;
        r100.writeInt(0);
    L48:
        r100.writeString(this.minuteRainDesc);
        r100.writeString(this.minuteRainShortDesc);
        return;
    L44:
        r100.writeInt(1);
        r100.writeInt(r111.size());
        Iterator<DayWeatherInfo> r112 = r111.iterator();
    L46:
        if (r112.hasNext() == false) goto L48;
        r112.next().writeToParcel(r100, r101);
        goto L46
    L37:
        r100.writeInt(1);
        r100.writeInt(r110.size());
        Iterator<HourWeatherInfo> r113 = r110.iterator();
    L39:
        if (r113.hasNext() == false) goto L41;
        r113.next().writeToParcel(r100, r101);
        goto L39
    L33:
        r100.writeInt(1);
        r100.writeInt(r109.intValue());
        goto L34
    L29:
        r100.writeInt(1);
        r100.writeInt(r108.intValue());
        goto L30
    L25:
        r100.writeInt(1);
        r100.writeInt(r107.intValue());
        goto L26
    L21:
        r100.writeInt(1);
        r100.writeInt(r106.intValue());
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeDouble(r102.doubleValue());
        goto L6
    }

    public final Integer getAqi() {
        return this.aqi;
    }

    public final List<DayWeatherInfo> getDailyWeather() {
        return this.dailyWeather;
    }

    public final Integer getFeelTemp() {
        return this.feelTemp;
    }

    public final Integer getHighTemp() {
        return this.highTemp;
    }

    public final List<HourWeatherInfo> getHourlyWeather() {
        return this.hourlyWeather;
    }

    public final Integer getHumidity() {
        return this.humidity;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Integer getLowTemp() {
        return this.lowTemp;
    }

    public final String getMinuteRainDesc() {
        return this.minuteRainDesc;
    }

    public final String getMinuteRainShortDesc() {
        return this.minuteRainShortDesc;
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final String getUvLevel() {
        return this.uvLevel;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }

    public final Double getWindDirection() {
        return this.windDirection;
    }

    public final Integer getWindSpeed() {
        return this.windSpeed;
    }

    public WeatherInfo(String r100, String r101, Double r102, Integer r103, String r104, Integer r105, Integer r106, Integer r110, Integer r111, Integer r112, Integer r113, String r114, List<HourWeatherInfo> r115, List<DayWeatherInfo> r116, String r117, String r118) {
        this.timezone = r100;
        this.location = r101;
        this.windDirection = r102;
        this.windSpeed = r103;
        this.uvLevel = r104;
        this.humidity = r105;
        this.aqi = r106;
        this.temp = r110;
        this.feelTemp = r111;
        this.lowTemp = r112;
        this.highTemp = r113;
        this.weatherCode = r114;
        this.hourlyWeather = r115;
        this.dailyWeather = r116;
        this.minuteRainDesc = r117;
        this.minuteRainShortDesc = r118;
    }

    public /* synthetic */ WeatherInfo(String r110, String r111, Double r210, Integer r211, String r212, Integer r213, Integer r214, Integer r215, Integer r216, Integer r217, Integer r218, String r219, List r310, List r311, String r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        Double r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Integer r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Integer r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Integer r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        List r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
