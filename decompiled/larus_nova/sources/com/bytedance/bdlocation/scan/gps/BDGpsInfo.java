package com.bytedance.bdlocation.scan.gps;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BDGpsInfo {

    @SerializedName(LocationMonitorConst.ACCURACY)
    public float accuracy;

    @SerializedName("altitude")
    public double altitude;

    @SerializedName("bearing_accuracy")
    public float bearingAccuracyDegrees;

    @SerializedName("callback_clock")
    public long callbackClock;

    @SerializedName("coordinate_system")
    public String coordinateSystem;

    @SerializedName("elapsed_realtime")
    public long elapsedRealtimeNanos;

    @SerializedName("elapsed_realtime_uncertainty")
    public double elapsedRealtimeUncertaintyNanos;

    @SerializedName("gps_mode")
    public int gpsMode;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("latitude_wgs84")
    public double latitudeWgs84;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("longitude_wgs84")
    public double longitudeWgs84;

    @SerializedName("orientation")
    public float orientation;

    @SerializedName(ShortVideoSegments.KEY_PROP_PROVIDER)
    public String provider;

    @SerializedName("real_timestamp")
    public long realTimestamp;

    @SerializedName("satellite_info")
    public List<BDSatelliteInfo> satelliteInfos;

    @SerializedName("satellite_num")
    public Integer satelliteNum;

    @SerializedName("snr")
    public List<Float> snr;

    @SerializedName("speed")
    public float speed;

    @SerializedName("speed_accuracy")
    public float speedAccuracyMetersPerSecond;

    @SerializedName("sys_extra")
    public String sysExtras;

    @SerializedName("timestamp")
    public long timestamp;

    @SerializedName("altitude_accuracy")
    public float verticalAccuracyMeters;

    public BDGpsInfo() {
    }

    public BDGpsInfo(BDGpsInfo r100, BDGnssInfo r101) {
        this.logId = r100.logId;
        this.longitude = r100.longitude;
        this.latitude = r100.latitude;
        this.accuracy = r100.accuracy;
        this.coordinateSystem = r100.coordinateSystem;
        this.provider = r100.provider;
        this.speed = r100.speed;
        this.orientation = r100.orientation;
        this.altitude = r100.altitude;
        this.timestamp = r100.timestamp;
        this.gpsMode = r100.gpsMode;
        this.realTimestamp = r100.realTimestamp;
        this.elapsedRealtimeNanos = r100.elapsedRealtimeNanos;
        this.elapsedRealtimeUncertaintyNanos = r100.elapsedRealtimeUncertaintyNanos;
        this.verticalAccuracyMeters = r100.verticalAccuracyMeters;
        this.bearingAccuracyDegrees = r100.bearingAccuracyDegrees;
        this.speedAccuracyMetersPerSecond = r100.speedAccuracyMetersPerSecond;
        this.sysExtras = r100.sysExtras;
        this.callbackClock = r100.callbackClock;
        this.latitudeWgs84 = r100.latitudeWgs84;
        this.longitudeWgs84 = r100.longitudeWgs84;
        this.satelliteNum = Integer.valueOf(r101.satelliteNum);
        this.snr = r101.snr;
        this.satelliteInfos = r101.satelliteInfos;
    }
}
