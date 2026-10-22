package t3;

import android.hardware.SensorEvent;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.JsonObject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class b extends c {
    @Override // t3.c
    public final JsonObject c(SensorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float[] r101 = r100.values;
        JsonObject r102 = new JsonObject();
        Intrinsics.checkNotNull(r101);
        Float r103 = ArraysKt.getOrNull(r101, 0);
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r103 == null) goto L5;
        double r105 = r103.floatValue();
    L6:
        r102.addProperty("x", Double.valueOf(r105));
        Float r106 = ArraysKt.getOrNull(r101, 1);
        if (r106 == null) goto L9;
        double r107 = r106.floatValue();
    L10:
        r102.addProperty("y", Double.valueOf(r107));
        Float r108 = ArraysKt.getOrNull(r101, 2);
        if (r108 == null) goto L13;
        r104 = r108.floatValue();
    L13:
        r102.addProperty(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, Double.valueOf(r104));
        r102.addProperty("timestamp", Long.valueOf(r100.timestamp));
        return r102;
    L9:
        r107 = 0.0d;
        goto L10
    L5:
        r105 = 0.0d;
        goto L6
    }

    public b(e3.d r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "changeEventName");
        Intrinsics.checkNotNullParameter(r103, "unavailableMessage");
        super(r100, r101, r102, r103);
    }
}
