package s0;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements s<o0.g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f540004a = null;

    public r() {
    }

    static {
        f540004a = new r();
    }

    @Override // s0.s
    public final o0.g a(JsonReader r110, float r111) throws IOException {
        if (r110.peek() != JsonToken.BEGIN_ARRAY) goto L5;
        r110.beginArray();
    L5:
        r110.beginObject();
        List<PointF> r100 = null;
        List<PointF> r101 = null;
        List<PointF> r102 = null;
        boolean r103 = false;
    L7:
        if (r110.hasNext() == false) goto L42;
        String r104 = r110.nextName();
        r104.getClass();
        int r105 = r104.hashCode();
        if (r105 == 99) goto L30;
        if (r105 == 105) goto L26;
        if (r105 == 111) goto L22;
        if (r105 == 118) goto L18;
    L31:
        byte r106 = -1;
    L33:
        if (r106 != 0) goto L34;
        r103 = r110.nextBoolean();
        goto L7
    L34:
        if (r106 != 1) goto L35;
        r101 = j.c(r110, r111);
        goto L7
    L35:
        if (r106 != 2) goto L36;
        r102 = j.c(r110, r111);
        goto L7
    L36:
        if (r106 != 3) goto L7;
        r100 = j.c(r110, r111);
        goto L7
    L18:
        if (r104.equals(BaseSwitches.V) == false) goto L31;
        r106 = 3;
        goto L33
    L22:
        if (r104.equals("o") == false) goto L31;
        r106 = 2;
        goto L33
    L26:
        if (r104.equals(RXScreenCaptureService.KEY_INDEX) == false) goto L31;
        r106 = 1;
        goto L33
    L30:
        if (r104.equals("c") == false) goto L31;
        r106 = 0;
        goto L33
    L42:
        r110.endObject();
        if (r110.peek() != JsonToken.END_ARRAY) goto L45;
        r110.endArray();
    L45:
        if (r100 == null) goto L59;
        if (r101 == null) goto L59;
        if (r102 == null) goto L59;
        if (r100.isEmpty() == true) goto L75;
        int r112 = r100.size();
        PointF r113 = (PointF) ListProtector.get(r100, 0);
        ArrayList r107 = new ArrayList(r112);
        int r108 = 1;
    L52:
        if (r108 >= r112) goto L54;
        PointF r109 = (PointF) ListProtector.get(r100, r108);
        int r114 = r108 - 1;
        r107.add(new m0.a(u0.e.a((PointF) ListProtector.get(r100, r114), (PointF) ListProtector.get(r102, r114)), u0.e.a(r109, (PointF) ListProtector.get(r101, r108)), r109));
        r108 = r108 + 1;
        goto L52
    L54:
        if (r103 == false) goto L57;
        PointF r115 = (PointF) ListProtector.get(r100, 0);
        int r116 = r112 - 1;
        r107.add(new m0.a(u0.e.a((PointF) ListProtector.get(r100, r116), (PointF) ListProtector.get(r102, r116)), u0.e.a(r115, (PointF) ListProtector.get(r101, 0)), r115));
    L57:
        return new o0.g(r113, r103, r107);
    L75:
        return new o0.g(new PointF(), false, Collections.emptyList());
    L59:
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
