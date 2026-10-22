package vz6;

import android.util.JsonReader;
import android.util.JsonToken;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class l {
    public static void b(List<? extends xz6.a<?>> r100) {
        ArrayList r101 = (ArrayList) r100;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        int r104 = r102 - 1;
        if (r103 >= r104) goto L6;
        xz6.a r105 = (xz6.a) ListProtector.get(r100, r103);
        r103 = r103 + 1;
        r105.f565531f = Float.valueOf(((xz6.a) ListProtector.get(r100, r103)).f565530e);
        goto L3
    L6:
        xz6.a r106 = (xz6.a) ListProtector.get(r100, r104);
        if (r106.f565527b != 0) goto L11;
        r101.remove(r106);
        return;
    }

    public static <T> List<xz6.a<T>> a(JsonReader r100, com.bytedance.lottie.d r101, float r102, s<T> r103) throws IOException {
        ArrayList r104 = new ArrayList();
        if (r100.peek() != JsonToken.STRING) goto L6;
        r101.a("Lottie doesn't support expressions.");
        return r104;
    L6:
        r100.beginObject();
    L8:
        if (r100.hasNext() == false) goto L22;
        String r105 = r100.nextName();
        r105.getClass();
        if (r105.equals(ce.f26396k) == false) goto L11;
        if (r100.peek() == JsonToken.BEGIN_ARRAY) goto L14;
        r104.add(k.a(r100, r101, r102, r103, false));
        goto L8
    L14:
        r100.beginArray();
        if (r100.peek() != JsonToken.NUMBER) goto L18;
        r104.add(k.a(r100, r101, r102, r103, false));
    L20:
        r100.endArray();
    L18:
        if (r100.hasNext() == false) goto L20;
        r104.add(k.a(r100, r101, r102, r103, true));
        goto L18
    L11:
        r100.skipValue();
        goto L8
    L22:
        r100.endObject();
        b(r104);
        return r104;
    }
}
