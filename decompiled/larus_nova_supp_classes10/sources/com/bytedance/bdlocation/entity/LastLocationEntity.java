package com.bytedance.bdlocation.entity;

import android.location.Location;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LastLocationEntity {
    public final boolean coordinateSystemSuccess;
    public final Location gpsLocation;
    public final long gpsLocationDuration;
    public final long gpsLocationGap;
    public final Location networkLocation;
    public final long networkLocationDuration;
    public final long networkLocationGap;
    public final long totalLocationDuration;

    public LastLocationEntity(Location r1, Location r2, long r3, long r5, long r7, long r9, long r11, boolean r13) {
        this.networkLocation = r1;
        this.gpsLocation = r2;
        this.networkLocationDuration = r3;
        this.gpsLocationDuration = r5;
        this.totalLocationDuration = r7;
        this.networkLocationGap = r9;
        this.gpsLocationGap = r11;
        this.coordinateSystemSuccess = r13;
    }
}
