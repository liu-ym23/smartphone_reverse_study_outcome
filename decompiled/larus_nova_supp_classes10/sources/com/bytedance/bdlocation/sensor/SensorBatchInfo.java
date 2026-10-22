package com.bytedance.bdlocation.sensor;

import com.bytedance.bdlocation.satellite.BDGnssGroupInfo;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class SensorBatchInfo {

    @SerializedName("accelerometer")
    public AccelerometerGroupInfo accelerometer;

    @SerializedName("barometer")
    public BarometerGroupInfo barometer;

    @SerializedName("dop")
    public DopInfo dop;

    @SerializedName("gyroscope")
    public GyroscopeGroupInfo gyroscope;

    @SerializedName("light")
    public LightGroupInfo light;

    @SerializedName("magnetometer")
    public MagnetometerGroupInfo magnetometer;

    @SerializedName("satellite_info")
    public BDGnssGroupInfo satelliteInfo;

    @SerializedName("window_end_timestamp_ms")
    public long windowEndTimestampMs;

    @SerializedName("window_start_timestamp_ms")
    public long windowStartTimestampMs;

    public SensorBatchInfo() {
    }
}
