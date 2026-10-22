package vz6;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f557728a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f557728a = r100;
            r100[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f557728a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f557728a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static int a(JsonReader r100) throws IOException {
        r100.beginArray();
        int r101 = (int) (r100.nextDouble() * 255.0d);
        int r102 = (int) (r100.nextDouble() * 255.0d);
        int r103 = (int) (r100.nextDouble() * 255.0d);
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.skipValue();
        goto L4
    L6:
        r100.endArray();
        return Color.argb(255, r101, r102, r103);
    }

    public static float d(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = a.f557728a[r101.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 != 2) goto L13;
        r100.beginArray();
        float r103 = (float) r100.nextDouble();
    L8:
        if (r100.hasNext() == false) goto L10;
        r100.skipValue();
        goto L8
    L10:
        r100.endArray();
        return r103;
    L13:
        throw new IllegalArgumentException("Unknown value for token of type " + r101);
    L15:
        return (float) r100.nextDouble();
    }

    public static PointF b(JsonReader r100, float r101) throws IOException {
        int r102 = a.f557728a[r100.peek().ordinal()];
        if (r102 != 1) goto L5;
        float r103 = (float) r100.nextDouble();
        float r104 = (float) r100.nextDouble();
    L30:
        if (r100.hasNext() == false) goto L33;
        r100.skipValue();
        goto L30
    L33:
        return new PointF(r103 * r101, r104 * r101);
    L5:
        if (r102 != 2) goto L7;
        r100.beginArray();
        float r105 = (float) r100.nextDouble();
        float r106 = (float) r100.nextDouble();
    L24:
        if (r100.peek() == JsonToken.END_ARRAY) goto L26;
        r100.skipValue();
        goto L24
    L26:
        r100.endArray();
        return new PointF(r105 * r101, r106 * r101);
    L7:
        if (r102 != 3) goto L21;
        r100.beginObject();
        float r107 = 0.0f;
        float r108 = 0.0f;
    L10:
        if (r100.hasNext() == false) goto L18;
        String r109 = r100.nextName();
        r109.getClass();
        if (r109.equals("x") == false) goto L14;
        r107 = d(r100);
        goto L10
    L14:
        if (r109.equals("y") == false) goto L15;
        r108 = d(r100);
        goto L10
    L15:
        r100.skipValue();
        goto L10
    L18:
        r100.endObject();
        return new PointF(r107 * r101, r108 * r101);
    L21:
        throw new IllegalArgumentException("Unknown point starts with " + r100.peek());
    }

    public static List<PointF> c(JsonReader r100, float r101) throws IOException {
        ArrayList r102 = new ArrayList();
        r100.beginArray();
    L4:
        if (r100.peek() != JsonToken.BEGIN_ARRAY) goto L6;
        r100.beginArray();
        r102.add(b(r100, r101));
        r100.endArray();
        goto L4
    L6:
        r100.endArray();
        return r102;
    }
}
