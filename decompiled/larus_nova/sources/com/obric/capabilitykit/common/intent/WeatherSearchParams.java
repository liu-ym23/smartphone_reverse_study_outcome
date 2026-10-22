package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/WeatherSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "location", "", "time", DyPayConstant.KEY_START_TIME, "endTime", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getLocation", "setLocation", "getStartTime", "setStartTime", "getTime", "setTime", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WeatherSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<WeatherSearchParams> CREATOR = null;
    private String endTime;
    private String location;
    private String startTime;
    private String time;
    private String type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<WeatherSearchParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WeatherSearchParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            WeatherSearchParams r102 = new WeatherSearchParams(r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final WeatherSearchParams[] newArray(int r100) {
            return new WeatherSearchParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public WeatherSearchParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ WeatherSearchParams copy$default(WeatherSearchParams r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.location;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.time;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.startTime;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.endTime;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.type;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.location;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.startTime;
    }

    public final String component4() {
        return this.endTime;
    }

    public final String component5() {
        return this.type;
    }

    public final WeatherSearchParams copy(String r100, String r101, String r110, String r111, String r112) {
        return new WeatherSearchParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WeatherSearchParams) == true) goto L8;
        return false;
    L8:
        WeatherSearchParams r101 = (WeatherSearchParams) r100;
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.location;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.time;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.startTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.endTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.type;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "WeatherSearchParams(location=" + this.location + ", time=" + this.time + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.location);
        r100.writeString(this.time);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
        r100.writeString(this.type);
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof WeatherSearchParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.location;
        if (r101 != null) goto L8;
        r101 = ((WeatherSearchParams) r100).location;
    L8:
        String r102 = r101;
        String r103 = this.time;
        if (r103 != null) goto L11;
        r103 = ((WeatherSearchParams) r100).time;
    L11:
        String r104 = r103;
        String r105 = this.startTime;
        if (r105 != null) goto L14;
        r105 = ((WeatherSearchParams) r100).startTime;
    L14:
        String r106 = r105;
        String r107 = this.endTime;
        if (r107 != null) goto L17;
        r107 = ((WeatherSearchParams) r100).endTime;
    L17:
        String r108 = r107;
        String r109 = this.type;
        if (r109 != null) goto L20;
        String r110 = ((WeatherSearchParams) r100).type;
    L22:
        return new WeatherSearchParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setLocation(String r100) {
        this.location = r100;
    }

    public final void setStartTime(String r100) {
        this.startTime = r100;
    }

    public final void setTime(String r100) {
        this.time = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public WeatherSearchParams(String r100, String r101, String r102, String r103, String r104) {
        this.location = r100;
        this.time = r101;
        this.startTime = r102;
        this.endTime = r103;
        this.type = r104;
    }

    public /* synthetic */ WeatherSearchParams(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
