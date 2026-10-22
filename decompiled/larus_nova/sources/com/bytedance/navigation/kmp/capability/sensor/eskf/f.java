package com.bytedance.navigation.kmp.capability.sensor.eskf;

import androidx.camera.video.AudioStats;
import bv5.l;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f265823a = 0;

    static {
    }

    public static bv5.f a(String r910) {
        Intrinsics.checkNotNullParameter(r910, "json");
        JSONObject r100 = new JSONObject(r910);
        JSONObject r101 = r100.optJSONObject("replay");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        JSONObject r102 = r100.optJSONObject("imuNoise");
        if (r102 != null) goto L8;
        r102 = new JSONObject();
    L8:
        JSONObject r103 = r100.optJSONObject("init");
        if (r103 != null) goto L11;
        r103 = new JSONObject();
    L11:
        JSONObject r104 = r100.optJSONObject("gnss");
        if (r104 != null) goto L14;
        r104 = new JSONObject();
    L14:
        JSONObject r105 = r100.optJSONObject("gpsHeadingUpdate");
        if (r105 != null) goto L17;
        r105 = new JSONObject();
    L17:
        JSONObject r106 = r100.optJSONObject("gpsVelocityUpdate");
        if (r106 != null) goto L20;
        r106 = new JSONObject();
    L20:
        JSONObject r107 = r100.optJSONObject("magHeadingUpdate");
        if (r107 != null) goto L23;
        r107 = new JSONObject();
    L23:
        JSONObject r108 = r100.optJSONObject("walk");
        if (r108 != null) goto L26;
        r108 = new JSONObject();
    L26:
        JSONObject r109 = r100.optJSONObject("displayFilter");
        if (r109 != null) goto L29;
        r109 = new JSONObject();
    L29:
        JSONObject r110 = r100.optJSONObject("zupt");
        if (r110 != null) goto L32;
        r110 = new JSONObject();
    L32:
        JSONObject r810 = r102;
        JSONObject r811 = r103;
        bv5.i r111 = new bv5.i(r109.optLong("uiIntervalMs", 100), r109.optDouble("alpha", 0.2d), r109.optDouble("deadZoneDeg", 1.0d));
        l r112 = new l(r110.optBoolean("enabled", true), r110.optBoolean("angleUpdateEnabled", false), r110.optDouble("windowS", 1.0d), r110.optDouble("minIntervalS", 1.0d), r110.optBoolean("useBiasCompensation", true), r110.optBoolean("recordDebug", true), Math.toRadians(r110.optDouble("gyroRmsThreshDegS", 30.0d)), r110.optDouble("accMeanNormThreshMps2", 0.1d), r110.optDouble("accStdNormThreshMps2", 0.3d), c(r110.opt("velMeasStdMps"), new double[]{0.05d, 0.05d, 0.05d}), Math.toRadians(r110.optDouble("rollMeasStdDeg", 2.0d)), Math.toRadians(r110.optDouble("pitchMeasStdDeg", 2.0d)), Math.toRadians(r110.optDouble("maxTiltAbsDeg", 80.0d)), Math.toRadians(r110.optDouble("angleInnovGateDeg", 45.0d)));
        return new bv5.f(r101.optDouble("maxDtS", 0.1d), r101.optDouble("dtDefaultS", 0.02d), r101.optDouble("magDeclinationDeg", -6.0d), StringsKt.trim(r104.optString(ShortVideoSegments.KEY_PROP_PROVIDER, GeocodeSearch.GPS)).toString().toLowerCase(Locale.US), r104.optDouble("accuracyStartThreshM", 30.0d), r104.optDouble("posStdMinM", 0.5d), r104.optDouble("zStdScale", 2.0d), r105.optBoolean("enabled", true), r105.optDouble("minSpeedMps", 0.5d), r105.optDouble("innovGateDeg", 80.0d), r105.optDouble("headingDiffGateDeg", 10.0d), r105.optInt("usePoints", 2), r105.optInt("speedConsecutiveCount", 3), r105.optDouble("rollGateDeg", 15.0d), r105.optDouble("pitchGateDegLow", -30.0d), r105.optDouble("pitchGateDegHigh", 70.0d), r105.optDouble("headingStdAccLowM", 3.0d), r105.optDouble("headingStdAtLowDeg", 30.0d), r105.optDouble("headingStdAccHighM", 10.0d), r105.optDouble("headingStdAtHighDeg", 50.0d), r106.optBoolean("enabled", false), r106.optDouble("minSpeedMps", 0.5d), r106.optDouble("velStdScale", 0.5d), r106.optDouble("velStdMinMps", 0.5d), r107.optBoolean("enabled", true), r107.optDouble("yawStdDeg", 60.0d), r107.optDouble("updatePeriodS", 1.0d), r107.optDouble("silentAfterGpsS", 0.5d), r107.optDouble("innovGateDeg", 40.0d), r107.optDouble("maxTiltDeg", 60.0d), b(r810.opt("arwDegSqrtHr"), 0.3d), b(r810.opt("vrwMpsSqrtHr"), 0.07d), b(r810.opt("gbStdDegHr"), 10.0d), b(r810.opt("abStdMGal"), 36.0d), b(r810.opt("sigmaGyroBiasRwRadSqrtS"), 5.0E-4d), b(r810.opt("sigmaAccBiasRwMps2SqrtS"), 0.05d), c(r811.opt("attStdDeg"), new double[]{15.0d, 15.0d, 30.0d}), r811.optDouble("initVelStdMps", 0.5d), r811.optDouble("gravityMps2", 9.81d), r112, r111, r108.optLong("stepWindowMs", 3000), r108.optInt("minStepsInWindow", 3), r108.optLong("stopTimeoutMs", 3000));
    }

    public static double b(Object r100, double r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L7;
        return r101;
    L7:
        if ((r100 instanceof JSONArray) == false) goto L17;
        JSONArray r102 = (JSONArray) r100;
        if (r102.length() == 0) goto L25;
        Iterator<Integer> r103 = RangesKt.until(0, r102.length()).iterator();
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L13:
        if (r103.hasNext() == false) goto L22;
        r104 = r104 + JSONArrayProtectorUtils.getDouble(r102, ((IntIterator) r103).nextInt());
        goto L13
    L22:
        return r104 / ((double) r102.length());
    L25:
        return r101;
    L17:
        if ((r100 instanceof Number) == true) goto L19;
        return r101;
    L19:
        return ((Number) r100).doubleValue();
    }

    public static double[] c(Object r100, double[] r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == true) goto L24;
        int r102 = 0;
        if ((r100 instanceof JSONArray) == false) goto L16;
        double[] r103 = new double[3];
    L9:
        if (r102 >= 3) goto L25;
        JSONArray r104 = (JSONArray) r100;
        if (r102 >= r104.length()) goto L13;
        double r105 = JSONArrayProtectorUtils.getDouble(r104, r102);
    L14:
        r103[r102] = r105;
        r102 = r102 + 1;
        goto L9
    L13:
        r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L14
    L25:
        return r103;
    L16:
        if ((r100 instanceof Number) == false) goto L23;
        Number r106 = (Number) r100;
        return new double[]{r106.doubleValue(), r106.doubleValue(), r106.doubleValue()};
    L23:
        return r101;
    L24:
        return r101;
    }
}
