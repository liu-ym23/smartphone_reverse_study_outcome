package s0;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static <T> void b(List<? extends v0.a<T>> r100) {
        ArrayList r101 = (ArrayList) r100;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        int r104 = r102 - 1;
        if (r103 >= r104) goto L12;
        v0.a r105 = (v0.a) ListProtector.get(r100, r103);
        r103 = r103 + 1;
        v0.a r106 = (v0.a) ListProtector.get(r100, r103);
        r105.f552279f = Float.valueOf(r106.f552278e);
        if (r105.f552276c != null) goto L3;
        T r107 = r106.f552275b;
        if (r107 == null) goto L3;
        r105.f552276c = r107;
        if ((r105 instanceof j0.h) == false) goto L3;
        ((j0.h) r105).d();
        goto L3
    L12:
        v0.a r108 = (v0.a) ListProtector.get(r100, r104);
        if (r108.f552275b == null) goto L17;
        if (r108.f552276c == null) goto L17;
        return;
    L17:
        if (r101.size() <= 1) goto L30;
        r101.remove(r108);
        return;
    }

    public static <T> List<v0.a<T>> a(JsonReader r100, LottieComposition r101, float r102, s<T> r103) throws IOException {
        ArrayList r104 = new ArrayList();
        if (r100.peek() != JsonToken.STRING) goto L6;
        r101.addWarning("Lottie doesn't support expressions.");
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
