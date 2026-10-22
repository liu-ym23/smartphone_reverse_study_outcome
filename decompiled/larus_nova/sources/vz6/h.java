package vz6;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements s<sz6.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f557726a;

    public h(int r100) {
        this.f557726a = r100;
    }

    @Override // vz6.s
    public final sz6.c a(JsonReader r210, float r211) throws IOException {
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
        if (this.f557726a != (-1)) goto L16;
        this.f557726a = r100.size() / 4;
    L16:
        int r103 = this.f557726a;
        float[] r104 = new float[r103];
        int[] r105 = new int[r103];
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
    L17:
        int r109 = this.f557726a * 4;
        if (r106 >= r109) goto L31;
        int r110 = r106 / 4;
        double r111 = ((Float) ListProtector.get(r100, r106)).floatValue();
        int r112 = r106 % 4;
        if (r112 == 0) goto L29;
        if (r112 == 1) goto L28;
        if (r112 != 2) goto L24;
        r108 = (int) (r111 * 255.0d);
    L30:
        r106 = r106 + 1;
        goto L17
    L24:
        if (r112 != 3) goto L30;
        r105[r110] = Color.argb(255, r107, r108, (int) (r111 * 255.0d));
        goto L30
    L28:
        r107 = (int) (r111 * 255.0d);
        goto L30
    L29:
        r104[r110] = (float) r111;
        goto L30
    L31:
        sz6.c r113 = new sz6.c(r104, r105);
        if (r100.size() <= r109) goto L52;
        int r114 = (r100.size() - r109) / 2;
        double[] r115 = new double[r114];
        double[] r116 = new double[r114];
        int r117 = 0;
    L36:
        if (r109 >= r100.size()) goto L42;
        if ((r109 % 2) != 0) goto L40;
        r115[r117] = ((Float) ListProtector.get(r100, r109)).floatValue();
    L41:
        r109 = r109 + 1;
        goto L36
    L40:
        r116[r117] = ((Float) ListProtector.get(r100, r109)).floatValue();
        r117 = r117 + 1;
    L42:
        int[] r118 = r113.f543953b;
        if (r101 >= r118.length) goto L52;
        int r119 = r118[r101];
        double r120 = r113.f543952a[r101];
        int r121 = 1;
    L45:
        if (r121 >= r114) goto L50;
        int r122 = r121 - 1;
        double r123 = r115[r122];
        double r124 = r115[r121];
        if (r124 >= r120) goto L48;
        r121 = r121 + 1;
        goto L45
    L48:
        double r125 = r116[r122];
        int r126 = (int) ((r125 + (((r120 - r123) / (r124 - r123)) * (r116[r121] - r125))) * 255.0d);
    L51:
        r113.f543953b[r101] = Color.argb(r126, Color.red(r119), Color.green(r119), Color.blue(r119));
        r101 = r101 + 1;
        goto L42
    L50:
        r126 = (int) (r116[r114 - 1] * 255.0d);
    L52:
        return r113;
    L5:
        r102 = false;
        goto L6
    }
}
