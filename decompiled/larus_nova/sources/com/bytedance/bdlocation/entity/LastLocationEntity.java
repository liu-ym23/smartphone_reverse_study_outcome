package com.bytedance.bdlocation.entity;

import android.location.Location;

/* JADX INFO: loaded from: classes10.dex */
public class LastLocationEntity {
    public final boolean coordinateSystemSuccess;
    public final Location gpsLocation;
    public final long gpsLocationDuration;
    public final long gpsLocationGap;
    public final Location networkLocation;
    public final long networkLocationDuration;
    public final long networkLocationGap;
    public final long totalLocationDuration;

    public LastLocationEntity(Location r100, Location r101, long r102, long r103, long r104, long r105, long r110, boolean r111) {
        this.networkLocation = r100;
        this.gpsLocation = r101;
        this.networkLocationDuration = r102;
        this.gpsLocationDuration = r103;
        this.totalLocationDuration = r104;
        this.networkLocationGap = r105;
        this.gpsLocationGap = r110;
        this.coordinateSystemSuccess = r111;
    }
}
