package com.larus.bmhome.chat.map;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/map/PoiItem;", "", "podId", "", "poiName", "lon", "lat", "address", "distance", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getPodId", "()Ljava/lang/String;", "getPoiName", "getLon", "getLat", "getAddress", "getDistance", "getScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/larus/bmhome/chat/map/PoiItem;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PoiItem {

    @SerializedName("address")
    private final String address;

    @SerializedName("distance")
    private final String distance;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("latitude")
    private final String lat;

    @SerializedName("longitude")
    private final String lon;

    @SerializedName("poi_id")
    private final String podId;

    @SerializedName("poi_name")
    private final String poiName;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final Float score;

    public PoiItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ PoiItem copy$default(PoiItem r100, String r110, String r111, String r112, String r113, String r114, String r115, Float r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.podId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.poiName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.lon;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.lat;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.address;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.distance;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Float r107 = r100.score;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.icon;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.podId;
    }

    public final String component2() {
        return this.poiName;
    }

    public final String component3() {
        return this.lon;
    }

    public final String component4() {
        return this.lat;
    }

    public final String component5() {
        return this.address;
    }

    public final String component6() {
        return this.distance;
    }

    public final Float component7() {
        return this.score;
    }

    public final String component8() {
        return this.icon;
    }

    public final PoiItem copy(String r110, String r111, String r112, String r113, String r114, String r115, Float r116, String r117) {
        return new PoiItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiItem) == true) goto L8;
        return false;
    L8:
        PoiItem r101 = (PoiItem) r100;
        if (Intrinsics.areEqual(this.podId, r101.podId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poiName, r101.poiName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lon, r101.lon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lat, r101.lat) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.address, r101.address) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.distance, r101.distance) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.score, r101.score) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.podId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.poiName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.lat;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.address;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.distance;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.score;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.icon;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "PoiItem(podId=" + this.podId + ", poiName=" + this.poiName + ", lon=" + this.lon + ", lat=" + this.lat + ", address=" + this.address + ", distance=" + this.distance + ", score=" + this.score + ", icon=" + this.icon + ')';
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLat() {
        return this.lat;
    }

    public final String getLon() {
        return this.lon;
    }

    public final String getPodId() {
        return this.podId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final Float getScore() {
        return this.score;
    }

    public PoiItem(String r100, String r101, String r102, String r103, String r104, String r105, Float r106, String r107) {
        this.podId = r100;
        this.poiName = r101;
        this.lon = r102;
        this.lat = r103;
        this.address = r104;
        this.distance = r105;
        this.score = r106;
        this.icon = r107;
    }

    public /* synthetic */ PoiItem(String r110, String r111, String r112, String r113, String r114, String r115, Float r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Float r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
