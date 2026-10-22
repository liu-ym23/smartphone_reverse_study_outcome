package com.facebook.keyframes.deserializers;

import android.graphics.Color;
import android.util.JsonReader;
import com.facebook.keyframes.model.KFColorFrame;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFColorFrameDeserializer {
    static final AbstractListDeserializer<KFColorFrame> LIST_DESERIALIZER = null;

    public KFColorFrameDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFColorFrame readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFColorFrame.Builder r101 = new KFColorFrame.Builder();
    L4:
        if (r100.hasNext() == false) goto L12;
        String r102 = r100.nextName();
        r102.getClass();
        if (r102.equals("start_frame") == false) goto L8;
        r101.startFrame = r100.nextInt();
        goto L4
    L8:
        if (r102.equals("data") == false) goto L9;
        r101.color = Color.parseColor(r100.nextString());
        goto L4
    L9:
        r100.skipValue();
        goto L4
    L12:
        r100.endObject();
        return r101.build();
    }
}
