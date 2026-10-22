package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFGradient;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFGradientDeserializer {
    static final AbstractListDeserializer<KFGradient> LIST_DESERIALIZER = null;

    public KFGradientDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFGradient readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFGradient.Builder r101 = new KFGradient.Builder();
    L4:
        if (r100.hasNext() == false) goto L12;
        String r102 = r100.nextName();
        r102.getClass();
        if (r102.equals(KFGradient.COLOR_START_JSON_FIELD) == false) goto L8;
        r101.colorStart = KFGradientColorDeserializer.readObject(r100);
        goto L4
    L8:
        if (r102.equals(KFGradient.COLOR_END_JSON_FIELD) == false) goto L9;
        r101.colorEnd = KFGradientColorDeserializer.readObject(r100);
        goto L4
    L9:
        r100.skipValue();
        goto L4
    L12:
        r100.endObject();
        return r101.build();
    }
}
