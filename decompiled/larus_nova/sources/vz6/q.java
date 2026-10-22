package vz6;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements s<xz6.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f557733a = null;

    static {
        f557733a = new q();
    }

    public q() {
    }

    @Override // vz6.s
    public final xz6.d a(JsonReader r100, float r101) throws IOException {
        if (r100.peek() != JsonToken.BEGIN_ARRAY) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100.beginArray();
    L8:
        float r103 = (float) r100.nextDouble();
        float r104 = (float) r100.nextDouble();
    L10:
        if (r100.hasNext() == false) goto L12;
        r100.skipValue();
        goto L10
    L12:
        if (r102 == false) goto L15;
        r100.endArray();
    L15:
        return new xz6.d((r103 / 100.0f) * r101, (r104 / 100.0f) * r101);
    L5:
        r102 = false;
        goto L6
    }
}
