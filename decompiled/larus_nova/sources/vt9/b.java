package vt9;

import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public b() {
    }

    public static HashMap a() {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("micFrameSize", 160), TuplesKt.to("enableStereoDetection", Boolean.TRUE), TuplesKt.to("nearMicCalculateDuration", 80), TuplesKt.to("preWarmUpDuration", 200), TuplesKt.to("maxCalculateDuration", 3000), TuplesKt.to("nearWarmUpDuration", 50), TuplesKt.to("echoWarmUpDuration", 100), TuplesKt.to("echoMinCalculateDuration", 50), TuplesKt.to("stereoDetectionBadRate", Double.valueOf(0.9d)), TuplesKt.to("expiredTimeInMicDuration", 4000), TuplesKt.to("ratioGate1", Double.valueOf(1.9952623149688795d)), TuplesKt.to("ratioGate2", Double.valueOf(1.2589254117941673d)), TuplesKt.to("stereoDetectionZeroRate", Double.valueOf(0.98d))});
    }
}
