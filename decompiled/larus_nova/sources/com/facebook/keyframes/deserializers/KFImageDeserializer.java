package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes23.dex */
public class KFImageDeserializer {
    public KFImageDeserializer() {
    }

    public static KFImage deserialize(InputStream r100) throws IOException {
        return readObject(new JsonReader(new InputStreamReader(r100)));
    }

    public static KFImage readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFImage.Builder r101 = new KFImage.Builder();
    L4:
        if (r100.hasNext() == false) goto L40;
        String r102 = r100.nextName();
        r102.getClass();
        byte r103 = -1;
        switch(r102.hashCode()) {
            case -1872643448: goto L29;
            case -290659267: goto L25;
            case -270583694: goto L21;
            case 106079: goto L17;
            case 511278831: goto L13;
            case 1301359490: goto L9;
            default: goto L32;
        };
    L32:
        switch(r103) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            default: goto L33;
        };
    L34:
        r101.frameCount = r100.nextInt();
        goto L4
    L35:
        r101.animationGroups = KFAnimationGroupDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L36:
        r101.key = r100.nextInt();
        goto L4
    L37:
        r101.frameRate = r100.nextInt();
        goto L4
    L38:
        r101.features = KFFeatureDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L39:
        r101.canvasSize = CommonDeserializerHelper.readFloatArray(r100);
        goto L4
    L33:
        r100.skipValue();
        goto L4
    L9:
        if (r102.equals(KFImage.FRAME_COUNT_JSON_FIELD) == false) goto L32;
        r103 = 5;
        goto L32
    L13:
        if (r102.equals(KFImage.ANIMATION_GROUPS_JSON_FIELD) == false) goto L32;
        r103 = 4;
        goto L32
    L17:
        if (r102.equals("key") == false) goto L32;
        r103 = 3;
        goto L32
    L21:
        if (r102.equals(KFImage.FRAME_RATE_JSON_FIELD) == false) goto L32;
        r103 = 2;
        goto L32
    L25:
        if (r102.equals(KFImage.FEATURES_JSON_FIELD) == false) goto L32;
        r103 = 1;
        goto L32
    L29:
        if (r102.equals(KFImage.CANVAS_SIZE_JSON_FIELD) == false) goto L32;
        r103 = 0;
        goto L32
    L40:
        r100.endObject();
        return r101.build();
    }
}
