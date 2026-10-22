package m9;

import androidx.camera.video.AudioStats;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements c {
    public b() {
    }

    @Override // m9.c
    public final void c1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // m9.c
    public final double getCpuRate() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // m9.c
    public final double getCpuSpeed() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // m9.c
    public final float getTemperature() {
        return 0.0f;
    }

    @Override // m9.c
    public final void h0(String r100, Function2<? super Double, ? super JSONObject, Unit> r101) {
    }
}
