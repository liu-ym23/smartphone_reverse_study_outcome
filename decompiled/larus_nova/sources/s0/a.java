package s0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.amap.api.col.s.ce;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static n0.e a(JsonReader r100, LottieComposition r101) throws IOException {
        ArrayList r102 = new ArrayList();
        if (r100.peek() != JsonToken.BEGIN_ARRAY) goto L13;
        r100.beginArray();
    L6:
        if (r100.hasNext() == false) goto L12;
        if (r100.peek() != JsonToken.BEGIN_OBJECT) goto L10;
        boolean r103 = true;
    L11:
        r102.add(new j0.h(r101, k.a(r100, r101, u0.f.d(), o.f540001a, r103)));
        goto L6
    L10:
        r103 = false;
        goto L11
    L12:
        r100.endArray();
        l.b(r102);
    L15:
        return new n0.e(r102);
    L13:
        r102.add(new v0.a(j.b(r100, u0.f.d())));
        goto L15
    }

    public static n0.m<PointF, PointF> b(JsonReader r100, LottieComposition r110) throws IOException {
        r100.beginObject();
        n0.e r101 = null;
        n0.b r102 = null;
        n0.b r103 = null;
        boolean r104 = false;
    L4:
        if (r100.peek() == JsonToken.END_OBJECT) goto L32;
        String r105 = r100.nextName();
        r105.getClass();
        byte r106 = -1;
        switch(r105.hashCode()) {
            case 107: goto L17;
            case 120: goto L13;
            case 121: goto L9;
            default: goto L20;
        };
    L20:
        switch(r106) {
            case 0: goto L31;
            case 1: goto L27;
            case 2: goto L23;
            default: goto L21;
        };
    L23:
        if (r100.peek() == JsonToken.STRING) goto L24;
        r103 = c.a(r100, r110, true);
        goto L4
    L24:
        r100.skipValue();
    L29:
        r104 = true;
        goto L4
    L27:
        if (r100.peek() == JsonToken.STRING) goto L28;
        r102 = c.a(r100, r110, true);
        goto L4
    L28:
        r100.skipValue();
        goto L29
    L31:
        r101 = a(r100, r110);
        goto L4
    L21:
        r100.skipValue();
        goto L4
    L9:
        if (r105.equals("y") == false) goto L20;
        r106 = 2;
        goto L20
    L13:
        if (r105.equals("x") == false) goto L20;
        r106 = 1;
        goto L20
    L17:
        if (r105.equals(ce.f26396k) == false) goto L20;
        r106 = 0;
        goto L20
    L32:
        r100.endObject();
        if (r104 == false) goto L35;
        r110.addWarning("Lottie doesn't support expressions.");
    L35:
        if (r101 == null) goto L38;
        return r101;
    L38:
        return new n0.i(r102, r103);
    }
}
