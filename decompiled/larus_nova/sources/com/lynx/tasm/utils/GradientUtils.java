package com.lynx.tasm.utils;

import android.graphics.PointF;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class GradientUtils {
    public GradientUtils() {
    }

    private static native ReadableMapBuffer nativeGetGradientArray(String r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108);

    private static native float[] nativeGetRadialRadius(int r100, int r101, float r102, float r103, float r104, float r105);

    public static com.lynx.react.bridge.mapbuffer.e a(String r100, float r110, float r111, float r112, float r113, float r114) {
        ReadableMapBuffer r101 = nativeGetGradientArray(r100, r110, 1.0f, 1.0f, r111, r112, 1.0f, r113, r114);
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator<MapBuffer.a> r102 = r101.iterator();
        if (r102.hasNext() == true) goto L8;
        return null;
    L8:
        return new com.lynx.react.bridge.mapbuffer.e(r102.next().f());
    }

    public static PointF b(int r100, int r101, float r102, float r103, float r104, float r105) {
        float[] r106 = nativeGetRadialRadius(r100, r101, r102, r103, r104, r105);
        return new PointF(r106[0], r106[1]);
    }
}
