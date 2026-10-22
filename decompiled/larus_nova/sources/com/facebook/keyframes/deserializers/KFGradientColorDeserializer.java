package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFGradientColor;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFGradientColorDeserializer {
    public KFGradientColorDeserializer() {
    }

    public static KFGradientColor readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFGradientColor.Builder r101 = new KFGradientColor.Builder();
    L4:
        if (r100.hasNext() == false) goto L12;
        String r102 = r100.nextName();
        r102.getClass();
        if (r102.equals("timing_curves") == false) goto L8;
        r101.timingCurves = CommonDeserializerHelper.read3DFloatArray(r100);
        goto L4
    L8:
        if (r102.equals("key_values") == false) goto L9;
        r101.keyValues = KFColorFrameDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L9:
        r100.skipValue();
        goto L4
    L12:
        r100.endObject();
        return r101.build();
    }
}
