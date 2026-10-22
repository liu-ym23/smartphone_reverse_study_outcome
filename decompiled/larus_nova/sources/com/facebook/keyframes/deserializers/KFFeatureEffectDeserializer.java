package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFFeatureEffect;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeatureEffectDeserializer {
    public KFFeatureEffectDeserializer() {
    }

    public static KFFeatureEffect readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFFeatureEffect.Builder r101 = new KFFeatureEffect.Builder();
    L4:
        if (r100.hasNext() == false) goto L9;
        String r102 = r100.nextName();
        r102.getClass();
        if (r102.equals(KFFeatureEffect.GRADIENT_JSON_FIELD) == false) goto L7;
        r101.gradient = KFGradientDeserializer.readObject(r100);
        goto L4
    L7:
        r100.skipValue();
        goto L4
    L9:
        r100.endObject();
        return r101.build();
    }
}
