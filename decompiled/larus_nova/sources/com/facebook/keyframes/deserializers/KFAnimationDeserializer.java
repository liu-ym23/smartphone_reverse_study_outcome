package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFAnimation;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class KFAnimationDeserializer {
    static final AbstractListDeserializer<KFAnimation> LIST_DESERIALIZER = null;

    public KFAnimationDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFAnimation readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFAnimation.Builder r101 = new KFAnimation.Builder();
    L4:
        if (r100.hasNext() == false) goto L30;
        String r102 = r100.nextName();
        r102.getClass();
        byte r103 = -1;
        switch(r102.hashCode()) {
            case -1530780935: goto L21;
            case -1413299531: goto L17;
            case -993141291: goto L13;
            case 594928386: goto L9;
            default: goto L24;
        };
    L24:
        switch(r103) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            default: goto L25;
        };
    L26:
        r101.animationFrames = KFAnimationFrameDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L27:
        r101.propertyType = KFAnimation.PropertyType.valueOf(r100.nextString().toUpperCase(Locale.US));
        goto L4
    L28:
        r101.anchor = CommonDeserializerHelper.readFloatArray(r100);
        goto L4
    L29:
        r101.timingCurves = CommonDeserializerHelper.read3DFloatArray(r100);
        goto L4
    L25:
        r100.skipValue();
        goto L4
    L9:
        if (r102.equals("key_values") == false) goto L24;
        r103 = 3;
        goto L24
    L13:
        if (r102.equals(KFAnimation.PROPERTY_TYPE_JSON_FIELD) == false) goto L24;
        r103 = 2;
        goto L24
    L17:
        if (r102.equals("anchor") == false) goto L24;
        r103 = 1;
        goto L24
    L21:
        if (r102.equals("timing_curves") == false) goto L24;
        r103 = 0;
        goto L24
    L30:
        r100.endObject();
        return r101.build();
    }
}
