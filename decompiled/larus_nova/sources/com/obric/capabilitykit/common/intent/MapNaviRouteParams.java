package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "destName", "", "departName", "transportMode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getTransportMode", "()Ljava/lang/Integer;", "setTransportMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapNaviRouteParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MapNaviRouteParams> CREATOR = null;
    private String departName;
    private String destName;
    private Integer transportMode;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<MapNaviRouteParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MapNaviRouteParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r104 = null;
        L6:
            MapNaviRouteParams r105 = new MapNaviRouteParams(r102, r103, r104);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L7:
            if (r108 > r106) goto L9;
            r108 = r108 + 1;
        L9:
            if (r108 > r101) goto L11;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L9
        L11:
            return r105;
        L5:
            r104 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final MapNaviRouteParams[] newArray(int r100) {
            return new MapNaviRouteParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public MapNaviRouteParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MapNaviRouteParams copy$default(MapNaviRouteParams r100, String r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.destName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.departName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.transportMode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.destName;
    }

    public final String component2() {
        return this.departName;
    }

    public final Integer component3() {
        return this.transportMode;
    }

    public final MapNaviRouteParams copy(String r100, String r101, Integer r102) {
        return new MapNaviRouteParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MapNaviRouteParams) == true) goto L8;
        return false;
    L8:
        MapNaviRouteParams r101 = (MapNaviRouteParams) r100;
        if (Intrinsics.areEqual(this.destName, r101.destName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.departName, r101.departName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transportMode, r101.transportMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.destName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.departName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.transportMode;
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "MapNaviRouteParams(destName=" + this.destName + ", departName=" + this.departName + ", transportMode=" + this.transportMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.destName);
        r100.writeString(this.departName);
        Integer r103 = this.transportMode;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final String getDestName() {
        return this.destName;
    }

    public final Integer getTransportMode() {
        return this.transportMode;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof MapNaviRouteParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.destName;
        if (r101 != null) goto L8;
        r101 = ((MapNaviRouteParams) r100).destName;
    L8:
        String r102 = this.departName;
        if (r102 != null) goto L11;
        r102 = ((MapNaviRouteParams) r100).departName;
    L11:
        Integer r103 = this.transportMode;
        if (r103 != null) goto L15;
        r103 = ((MapNaviRouteParams) r100).transportMode;
    L15:
        return new MapNaviRouteParams(r101, r102, r103);
    }

    public final void setDepartName(String r100) {
        this.departName = r100;
    }

    public final void setDestName(String r100) {
        this.destName = r100;
    }

    public final void setTransportMode(Integer r100) {
        this.transportMode = r100;
    }

    public MapNaviRouteParams(String r100, String r101, Integer r102) {
        this.destName = r100;
        this.departName = r101;
        this.transportMode = r102;
    }

    public /* synthetic */ MapNaviRouteParams(String r100, String r101, Integer r102, int r103, DefaultConstructorMarker r104) {
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
