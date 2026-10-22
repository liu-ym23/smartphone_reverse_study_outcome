package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class CommonDeserializerHelper {
    private static final AbstractListDeserializer<List<Float>> FLOAT_LIST_2D_DESERIALIZER = null;
    private static final AbstractListDeserializer<List<List<Float>>> FLOAT_LIST_3D_DESERIALIZER = null;
    private static final AbstractListDeserializer<Float> FLOAT_LIST_DESERIALIZER = null;
    public static final AbstractListDeserializer<String> STRING_LIST_DESERIALIZER = null;

    public CommonDeserializerHelper() {
    }

    static {
        STRING_LIST_DESERIALIZER = new AnonymousClass1();
        FLOAT_LIST_DESERIALIZER = new AnonymousClass2();
        FLOAT_LIST_2D_DESERIALIZER = new AnonymousClass3();
        FLOAT_LIST_3D_DESERIALIZER = new AnonymousClass4();
    }

    public static /* synthetic */ AbstractListDeserializer access$000() {
        return FLOAT_LIST_DESERIALIZER;
    }

    public static /* synthetic */ AbstractListDeserializer access$100() {
        return FLOAT_LIST_2D_DESERIALIZER;
    }

    private static float[][][] convert3DListToPrimitiveArray(List<List<List<Float>>> r100) {
        float[][][] r101 = new float[r100.size()][][];
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int r104 = r100.get(0).size();
        float[][] r105 = new float[r104][];
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L7;
        r105[r106] = convertListToPrimitiveArray(r100.get(r103).get(r106));
        r106 = r106 + 1;
        goto L5
    L7:
        r101[r103] = r105;
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    private static float[] convertListToPrimitiveArray(List<Float> r100) {
        float[] r101 = new float[r100.size()];
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103] = r100.get(r103).floatValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static float[][][] read3DFloatArray(JsonReader r100) throws IOException {
        return convert3DListToPrimitiveArray(FLOAT_LIST_3D_DESERIALIZER.readList(r100));
    }

    public static float[] readFloatArray(JsonReader r100) throws IOException {
        return convertListToPrimitiveArray(FLOAT_LIST_DESERIALIZER.readList(r100));
    }
}
