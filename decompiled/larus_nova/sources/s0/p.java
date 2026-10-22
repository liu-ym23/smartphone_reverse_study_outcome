package s0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes28.dex */
public final class p implements s<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f540002a = null;

    public p() {
    }

    static {
        f540002a = new p();
    }

    @Override // s0.s
    public final PointF a(JsonReader r100, float r101) throws IOException {
        JsonToken r102 = r100.peek();
        if (r102 != JsonToken.BEGIN_ARRAY) goto L6;
        return j.b(r100, r101);
    L6:
        if (r102 != JsonToken.BEGIN_OBJECT) goto L9;
        return j.b(r100, r101);
    L9:
        if (r102 != JsonToken.NUMBER) goto L17;
        PointF r103 = new PointF(((float) r100.nextDouble()) * r101, ((float) r100.nextDouble()) * r101);
    L12:
        if (r100.hasNext() == false) goto L15;
        r100.skipValue();
        goto L12
    L15:
        return r103;
    L17:
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + r102);
    }
}
