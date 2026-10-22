package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFFeatureFrame;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFFeatureFrameDeserializer {
    static final AbstractListDeserializer<KFFeatureFrame> LIST_DESERIALIZER = null;

    public KFFeatureFrameDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFFeatureFrame readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFFeatureFrame.Builder r101 = new KFFeatureFrame.Builder();
    L4:
        if (r100.hasNext() == false) goto L12;
        String r102 = r100.nextName();
        r102.getClass();
        if (r102.equals("start_frame") == false) goto L8;
        r101.startFrame = r100.nextInt();
        goto L4
    L8:
        if (r102.equals("data") == false) goto L9;
        r101.data = CommonDeserializerHelper.STRING_LIST_DESERIALIZER.readList(r100);
        goto L4
    L9:
        r100.skipValue();
        goto L4
    L12:
        r100.endObject();
        return r101.build();
    }
}
