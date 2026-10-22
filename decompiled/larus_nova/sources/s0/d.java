package s0;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements s<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f539992a = null;

    public d() {
    }

    static {
        f539992a = new d();
    }

    @Override // s0.s
    public final Integer a(JsonReader r110, float r111) throws IOException {
        if (r110.peek() != JsonToken.BEGIN_ARRAY) goto L5;
        boolean r112 = true;
    L6:
        if (r112 == false) goto L8;
        r110.beginArray();
    L8:
        double r100 = r110.nextDouble();
        double r101 = r110.nextDouble();
        double r102 = r110.nextDouble();
        double r103 = r110.nextDouble();
        if (r112 == false) goto L12;
        r110.endArray();
    L12:
        if (r100 > 1.0d) goto L21;
        if (r101 > 1.0d) goto L21;
        if (r102 > 1.0d) goto L21;
        if (r103 > 1.0d) goto L21;
        r100 = r100 * 255.0d;
        r101 = r101 * 255.0d;
        r102 = r102 * 255.0d;
        r103 = r103 * 255.0d;
    L21:
        return Integer.valueOf(Color.argb((int) r103, (int) r100, (int) r101, (int) r102));
    L5:
        r112 = false;
        goto L6
    }
}
