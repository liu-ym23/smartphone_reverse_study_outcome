package androidx.camera.video.internal.workaround;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CorrectNegativeLatLongForMediaMuxer {
    private static double adjustInternal(double r4) {
        if (r4 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return r4;
    L6:
        return ((r4 * 10000.0d) - 1.0d) / 10000.0d;
    }

    private CorrectNegativeLatLongForMediaMuxer() {
    }

    public static Pair<Double, Double> adjustGeoLocation(double r1, double r3) {
        if (DeviceQuirks.get(NegativeLatLongSavesIncorrectlyQuirk.class) == null) goto L6;
        r1 = adjustInternal(r1);
        r3 = adjustInternal(r3);
    L6:
        return Pair.create(Double.valueOf(r1), Double.valueOf(r3));
    }
}
