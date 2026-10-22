package com.ss.android.lark.location.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\n¨\u0006!"}, d2 = {"Lcom/ss/android/lark/location/dto/StreetNumberInfo;", "", "Ljava/io/Serializable;", "<init>", "()V", "direction", "", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "distance", "", "getDistance", "()F", "setDistance", "(F)V", "latitude", "", "getLatitude", "()D", "setLatitude", "(D)V", "longitude", "getLongitude", "setLongitude", "number", "getNumber", "setNumber", "street", "getStreet", "setStreet", "Builder", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreetNumberInfo implements Cloneable, Serializable {
    private String direction;
    private float distance;
    private double latitude;
    private double longitude;
    private String number;
    private String street;

    public StreetNumberInfo() {
        this.direction = "";
        this.number = "";
        this.street = "";
    }

    public Object clone() {
        return super.clone();
    }

    public final String getDirection() {
        return this.direction;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getStreet() {
        return this.street;
    }

    public final void setDirection(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.direction = r100;
    }

    public final void setDistance(float r100) {
        this.distance = r100;
    }

    public final void setLatitude(double r100) {
        this.latitude = r100;
    }

    public final void setLongitude(double r100) {
        this.longitude = r100;
    }

    public final void setNumber(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.number = r100;
    }

    public final void setStreet(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.street = r100;
    }
}
