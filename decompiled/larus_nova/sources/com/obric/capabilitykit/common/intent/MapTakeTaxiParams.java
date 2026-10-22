package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020&HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010*H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "departName", "", "destName", "slat", "", "slng", "dlat", "dlng", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getDlat", "()Ljava/lang/Double;", "setDlat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDlng", "setDlng", "getSlat", "setSlat", "getSlng", "setSlng", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapTakeTaxiParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MapTakeTaxiParams> CREATOR = null;
    private String departName;
    private String destName;
    private Double dlat;
    private Double dlng;
    private Double slat;
    private Double slng;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MapTakeTaxiParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams createFromParcel(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r101 = r110.readString();
            String r102 = r110.readString();
            if (r110.readInt() != 0) goto L5;
            Double r103 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Double r104 = null;
        L11:
            if (r110.readInt() != 0) goto L13;
            Double r105 = null;
        L15:
            if (r110.readInt() != 0) goto L17;
            Double r106 = null;
        L18:
            MapTakeTaxiParams r107 = new MapTakeTaxiParams(r101, r102, r103, r104, r105, r106);
            int r108 = Math.min(r100, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r111 = 1;
        L19:
            if (r111 > r108) goto L21;
            r111 = r111 + 1;
        L21:
            if (r111 > r100) goto L23;
            joa.a.d(r110, r109);
            r111 = r111 + 1;
            goto L21
        L23:
            return r107;
        L17:
            r106 = Double.valueOf(r110.readDouble());
            goto L18
        L13:
            r105 = Double.valueOf(r110.readDouble());
            goto L15
        L9:
            r104 = Double.valueOf(r110.readDouble());
            goto L11
        L5:
            r103 = Double.valueOf(r110.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams[] newArray(int r100) {
            return new MapTakeTaxiParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MapTakeTaxiParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MapTakeTaxiParams copy$default(MapTakeTaxiParams r100, String r101, String r102, Double r103, Double r104, Double r105, Double r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.departName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.destName;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.slat;
    L11:
        Double r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.slng;
    L14:
        Double r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.dlat;
    L17:
        Double r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.dlng;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.departName;
    }

    public final String component2() {
        return this.destName;
    }

    public final Double component3() {
        return this.slat;
    }

    public final Double component4() {
        return this.slng;
    }

    public final Double component5() {
        return this.dlat;
    }

    public final Double component6() {
        return this.dlng;
    }

    public final MapTakeTaxiParams copy(String r100, String r110, Double r111, Double r112, Double r113, Double r114) {
        return new MapTakeTaxiParams(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MapTakeTaxiParams) == true) goto L8;
        return false;
    L8:
        MapTakeTaxiParams r101 = (MapTakeTaxiParams) r100;
        if (Intrinsics.areEqual(this.departName, r101.departName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.destName, r101.destName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.slat, r101.slat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slng, r101.slng) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dlat, r101.dlat) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dlng, r101.dlng) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.departName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.destName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.slat;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.slng;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.dlat;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.dlng;
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "MapTakeTaxiParams(departName=" + this.departName + ", destName=" + this.destName + ", slat=" + this.slat + ", slng=" + this.slng + ", dlat=" + this.dlat + ", dlng=" + this.dlng + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.departName);
        r100.writeString(this.destName);
        Double r102 = this.slat;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Double r103 = this.slng;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Double r104 = this.dlat;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Double r105 = this.dlng;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeDouble(r105.doubleValue());
        return;
    L13:
        r100.writeInt(1);
        r100.writeDouble(r104.doubleValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeDouble(r103.doubleValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeDouble(r102.doubleValue());
        goto L6
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final String getDestName() {
        return this.destName;
    }

    public final Double getDlat() {
        return this.dlat;
    }

    public final Double getDlng() {
        return this.dlng;
    }

    public final Double getSlat() {
        return this.slat;
    }

    public final Double getSlng() {
        return this.slng;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof MapTakeTaxiParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.departName;
        if (r101 != null) goto L8;
        r101 = ((MapTakeTaxiParams) r100).departName;
    L8:
        String r102 = r101;
        String r103 = this.destName;
        if (r103 != null) goto L11;
        r103 = ((MapTakeTaxiParams) r100).destName;
    L11:
        String r104 = r103;
        Double r105 = this.slat;
        if (r105 != null) goto L14;
        r105 = ((MapTakeTaxiParams) r100).slat;
    L14:
        Double r106 = r105;
        Double r107 = this.slng;
        if (r107 != null) goto L17;
        r107 = ((MapTakeTaxiParams) r100).slng;
    L17:
        Double r108 = r107;
        Double r109 = this.dlat;
        if (r109 != null) goto L20;
        r109 = ((MapTakeTaxiParams) r100).dlat;
    L20:
        Double r110 = r109;
        Double r111 = this.dlng;
        if (r111 != null) goto L23;
        Double r112 = ((MapTakeTaxiParams) r100).dlng;
    L25:
        return new MapTakeTaxiParams(r102, r104, r106, r108, r110, r112);
    L23:
        r112 = r111;
        goto L25
    }

    public final void setDepartName(String r100) {
        this.departName = r100;
    }

    public final void setDestName(String r100) {
        this.destName = r100;
    }

    public final void setDlat(Double r100) {
        this.dlat = r100;
    }

    public final void setDlng(Double r100) {
        this.dlng = r100;
    }

    public final void setSlat(Double r100) {
        this.slat = r100;
    }

    public final void setSlng(Double r100) {
        this.slng = r100;
    }

    public MapTakeTaxiParams(String r100, String r101, Double r102, Double r103, Double r104, Double r105) {
        this.departName = r100;
        this.destName = r101;
        this.slat = r102;
        this.slng = r103;
        this.dlat = r104;
        this.dlng = r105;
    }

    public /* synthetic */ MapTakeTaxiParams(String r100, String r101, Double r102, Double r103, Double r110, Double r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Double r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Double r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Double r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Double r115 = null;
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
