package oqb;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static double a(String r100) {
        if (r100 != null) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        return CastDoubleProtector.parseDouble(r100);
    L7:
        e = move-exception;
        Log.e("NumberUtils", "failed to parse double, e:" + e);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
