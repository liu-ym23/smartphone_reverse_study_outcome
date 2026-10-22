package com.bytedance.bdlocation.continuous;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionJsonUtils;", "", "()V", "finiteDouble", "", "value", "putSafe", "Lorg/json/JSONObject;", "jsonObject", "key", "", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionJsonUtils {
    public static final ByteFusionJsonUtils INSTANCE = null;

    private ByteFusionJsonUtils() {
    }

    static {
        INSTANCE = new ByteFusionJsonUtils();
    }

    private final double finiteDouble(double r100) {
        if (Double.isNaN(r100) == false) goto L5;
    L6:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (Double.isInfinite(r100) == true) goto L6;
        return r100;
    }

    public final JSONObject putSafe(JSONObject r100, String r101, Object r102) {
        if (r102 != null) goto L5;
        r100.put(r101, JSONObject.NULL);
    L11:
        return r100;
    L5:
        if ((r102 instanceof Float) == false) goto L8;
        r100.put(r101, finiteDouble(((Number) r102).floatValue()));
        goto L11
    L8:
        if ((r102 instanceof Double) == false) goto L10;
        r100.put(r101, finiteDouble(((Number) r102).doubleValue()));
        goto L11
    L10:
        r100.put(r101, r102);
        goto L11
    }
}
