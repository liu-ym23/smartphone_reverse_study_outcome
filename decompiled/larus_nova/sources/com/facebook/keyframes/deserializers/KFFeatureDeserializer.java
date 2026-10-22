package com.facebook.keyframes.deserializers;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.JsonReader;
import com.facebook.keyframes.model.KFFeature;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeatureDeserializer {
    static final AbstractListDeserializer<KFFeature> LIST_DESERIALIZER = null;

    public KFFeatureDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFFeature readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFFeature.Builder r101 = new KFFeature.Builder();
    L4:
        if (r100.hasNext() == false) goto L75;
        String r102 = r100.nextName();
        r102.getClass();
        byte r103 = -1;
        switch(r102.hashCode()) {
            case -1923169788: goto L57;
            case -1833928446: goto L53;
            case -1806353256: goto L49;
            case -1530780935: goto L45;
            case -1446309207: goto L41;
            case -259686756: goto L37;
            case -247981657: goto L33;
            case -241402625: goto L29;
            case 3373707: goto L25;
            case 94742904: goto L21;
            case 152226438: goto L17;
            case 574151256: goto L13;
            case 725843758: goto L9;
            default: goto L60;
        };
    L60:
        switch(r103) {
            case 0: goto L74;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L70;
            case 5: goto L69;
            case 6: goto L68;
            case 7: goto L67;
            case 8: goto L66;
            case 9: goto L65;
            case 10: goto L64;
            case 11: goto L63;
            case 12: goto L62;
            default: goto L61;
        };
    L62:
        r101.strokeLineCap = Paint.Cap.valueOf(r100.nextString().toUpperCase(Locale.US));
        goto L4
    L63:
        r101.featureAnimations = KFAnimationDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L64:
        r101.keyFrames = KFFeatureFrameDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L65:
        r101.className = r100.nextString();
        goto L4
    L66:
        r101.name = r100.nextString();
        goto L4
    L67:
        r101.strokeWidth = (float) r100.nextDouble();
        goto L4
    L68:
        r101.fillColor = Color.parseColor(r100.nextString());
        goto L4
    L69:
        r101.strokeColor = Color.parseColor(r100.nextString());
        goto L4
    L70:
        r101.toFrame = (float) r100.nextDouble();
        goto L4
    L71:
        r101.timingCurves = CommonDeserializerHelper.read3DFloatArray(r100);
        goto L4
    L72:
        r101.fromFrame = (float) r100.nextDouble();
        goto L4
    L73:
        r101.effect = KFFeatureEffectDeserializer.readObject(r100);
        goto L4
    L74:
        r101.animationGroup = r100.nextInt();
        goto L4
    L61:
        r100.skipValue();
        goto L4
    L9:
        if (r102.equals(KFFeature.STROKE_LINE_CAP_JSON_FIELD) == false) goto L60;
        r103 = 12;
        goto L60
    L13:
        if (r102.equals(KFFeature.FEATURE_ANIMATIONS_JSON_FIELD) == false) goto L60;
        r103 = 11;
        goto L60
    L17:
        if (r102.equals(KFFeature.KEY_FRAMES_JSON_FIELD) == false) goto L60;
        r103 = 10;
        goto L60
    L21:
        if (r102.equals("class") == false) goto L60;
        r103 = 9;
        goto L60
    L25:
        if (r102.equals("name") == false) goto L60;
        r103 = 8;
        goto L60
    L29:
        if (r102.equals(KFFeature.STROKE_WIDTH_JSON_FIELD) == false) goto L60;
        r103 = 7;
        goto L60
    L33:
        if (r102.equals(KFFeature.FILL_COLOR_JSON_FIELD) == false) goto L60;
        r103 = 6;
        goto L60
    L37:
        if (r102.equals(KFFeature.STROKE_COLOR_JSON_FIELD) == false) goto L60;
        r103 = 5;
        goto L60
    L41:
        if (r102.equals(KFFeature.TO_FRAME_JSON_FIELD) == false) goto L60;
        r103 = 4;
        goto L60
    L45:
        if (r102.equals("timing_curves") == false) goto L60;
        r103 = 3;
        goto L60
    L49:
        if (r102.equals(KFFeature.FROM_FRAME_JSON_FIELD) == false) goto L60;
        r103 = 2;
        goto L60
    L53:
        if (r102.equals(KFFeature.EFFECT_JSON_FIELD) == false) goto L60;
        r103 = 1;
        goto L60
    L57:
        if (r102.equals(KFFeature.ANIMATION_GROUP_JSON_FIELD) == false) goto L60;
        r103 = 0;
        goto L60
    L75:
        r100.endObject();
        return r101.build();
    }
}
