package com.ss.android.lark.location.dto;

import com.alipay.sdk.m.x.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\nR\u001a\u0010,\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\n¨\u00060"}, d2 = {"Lcom/ss/android/lark/location/dto/PoiItemInfo;", "", "Ljava/io/Serializable;", "<init>", "()V", "poiId", "", "getPoiId", "()Ljava/lang/String;", "setPoiId", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "typeCode", "getTypeCode", "setTypeCode", "typeDes", "getTypeDes", "setTypeDes", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", "snippet", "getSnippet", "setSnippet", "tel", "getTel", "setTel", "distance", "", "getDistance", "()I", "setDistance", "(I)V", "parkingType", "getParkingType", "setParkingType", "businessArea", "getBusinessArea", "setBusinessArea", "Builder", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PoiItemInfo implements Cloneable, Serializable {
    private String businessArea;
    private int distance;
    private double latitude;
    private double longitude;
    private String parkingType;
    private String poiId;
    private String snippet;
    private String tel;
    private String title;
    private String typeCode;
    private String typeDes;

    public PoiItemInfo() {
        this.poiId = "";
        this.title = "";
        this.typeCode = "";
        this.typeDes = "";
        this.snippet = "";
        this.tel = "";
        this.parkingType = "";
        this.businessArea = "";
    }

    public Object clone() {
        return super.clone();
    }

    public final String getBusinessArea() {
        return this.businessArea;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getParkingType() {
        return this.parkingType;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final String getTel() {
        return this.tel;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTypeCode() {
        return this.typeCode;
    }

    public final String getTypeDes() {
        return this.typeDes;
    }

    public final void setBusinessArea(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.businessArea = r100;
    }

    public final void setDistance(int r100) {
        this.distance = r100;
    }

    public final void setLatitude(double r100) {
        this.latitude = r100;
    }

    public final void setLongitude(double r100) {
        this.longitude = r100;
    }

    public final void setParkingType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.parkingType = r100;
    }

    public final void setPoiId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiId = r100;
    }

    public final void setSnippet(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.snippet = r100;
    }

    public final void setTel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tel = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setTypeCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.typeCode = r100;
    }

    public final void setTypeDes(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.typeDes = r100;
    }
}
