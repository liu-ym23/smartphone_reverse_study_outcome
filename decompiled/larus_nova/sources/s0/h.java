package s0;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class h implements s<o0.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f539995a;

    public h(int r100) {
        this.f539995a = r100;
    }

    @Override // s0.s
    public final o0.c a(JsonReader r210, float r211) throws IOException {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        if (r210.peek() != JsonToken.BEGIN_ARRAY) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r210.beginArray();
    L9:
        if (r210.hasNext() == false) goto L11;
        r100.add(Float.valueOf((float) r210.nextDouble()));
        goto L9
    L11:
        if (r102 == false) goto L14;
        r210.endArray();
    L14:
        if (this.f539995a != (-1)) goto L16;
        this.f539995a = r100.size() / 4;
    L16:
        int r103 = this.f539995a;
        float[] r104 = new float[r103];
        int[] r105 = new int[r103];
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
    L17:
        int r109 = this.f539995a * 4;
        if (r106 >= r109) goto L38;
        int r110 = r106 / 4;
        double r111 = ((Float) ListProtector.get(r100, r106)).floatValue();
        int r112 = r106 % 4;
        if (r112 == 0) goto L30;
        if (r112 == 1) goto L28;
        if (r112 != 2) goto L24;
        r108 = (int) (r111 * 255.0d);
    L37:
        r106 = r106 + 1;
        goto L17
    L24:
        if (r112 != 3) goto L37;
        r105[r110] = Color.argb(255, r107, r108, (int) (r111 * 255.0d));
        goto L37
    L28:
        r107 = (int) (r111 * 255.0d);
        goto L37
    L30:
        if (r0.c.a.f535397a == false) goto L36;
        if (r110 <= 0) goto L35;
        float r113 = (float) r111;
        if (r104[r110 - 1] < r113) goto L35;
        r104[r110] = r113 + 0.01f;
    L35:
        r104[r110] = (float) r111;
        goto L37
    L36:
        r104[r110] = (float) r111;
        goto L37
    L38:
        o0.c r114 = new o0.c(r104, r105);
        if (r100.size() <= r109) goto L59;
        int r115 = (r100.size() - r109) / 2;
        double[] r116 = new double[r115];
        double[] r117 = new double[r115];
        int r118 = 0;
    L43:
        if (r109 >= r100.size()) goto L49;
        if ((r109 % 2) != 0) goto L47;
        r116[r118] = ((Float) ListProtector.get(r100, r109)).floatValue();
    L48:
        r109 = r109 + 1;
        goto L43
    L47:
        r117[r118] = ((Float) ListProtector.get(r100, r109)).floatValue();
        r118 = r118 + 1;
    L49:
        int[] r119 = r114.f521574b;
        if (r101 >= r119.length) goto L59;
        int r120 = r119[r101];
        double r121 = r114.f521573a[r101];
        int r122 = 1;
    L52:
        if (r122 >= r115) goto L57;
        int r123 = r122 - 1;
        double r124 = r116[r123];
        double r125 = r116[r122];
        if (r125 >= r121) goto L55;
        r122 = r122 + 1;
        goto L52
    L55:
        double r126 = r117[r123];
        double r127 = r117[r122];
        u0.e.a r128 = u0.e.f548111a;
        int r129 = (int) ((r126 + (((r121 - r124) / (r125 - r124)) * (r127 - r126))) * 255.0d);
    L58:
        r114.f521574b[r101] = Color.argb(r129, Color.red(r120), Color.green(r120), Color.blue(r120));
        r101 = r101 + 1;
        goto L49
    L57:
        r129 = (int) (r117[r115 - 1] * 255.0d);
    L59:
        return r114;
    L5:
        r102 = false;
        goto L6
    }
}
