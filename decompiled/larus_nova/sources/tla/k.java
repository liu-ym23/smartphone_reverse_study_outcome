package tla;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f546711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f546712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f546713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f546714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f546715e;

    public final String toString() {
        String r100 = this.f546715e;
        DecimalFormat r101 = new DecimalFormat("##.##");
        int r102 = 0;
    L4:
        if (r102 >= this.f546714d) goto L6;
        r100 = r100 + "[" + this.f546712b[r102] + " , " + r101.format(this.f546713c[r102]) + "] ";
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public k() {
        this.f546712b = new int[10];
        this.f546713c = new float[10];
    }

    public final float a(float r100) {
        return (float) this.f546711a.b(r100);
    }

    public void c(int r110) {
        int r100 = this.f546714d;
        if (r100 != 0) goto L5;
        return;
    L5:
        int[] r101 = this.f546712b;
        float[] r102 = this.f546713c;
        int[] r103 = new int[r101.length + 10];
        r103[0] = r100 - 1;
        r103[1] = 0;
        int r104 = 2;
    L6:
        if (r104 <= 0) goto L16;
        int r105 = r104 - 1;
        int r106 = r103[r105];
        r104 = r105 - 1;
        int r107 = r103[r104];
        if (r106 >= r107) goto L6;
        int r108 = r101[r107];
        int r111 = r106;
        int r112 = r111;
    L10:
        if (r111 >= r107) goto L15;
        int r113 = r101[r111];
        if (r113 > r108) goto L14;
        int r114 = r101[r112];
        r101[r112] = r113;
        r101[r111] = r114;
        float r115 = r102[r112];
        r102[r112] = r102[r111];
        r102[r111] = r115;
        r112 = r112 + 1;
    L14:
        r111 = r111 + 1;
        goto L10
    L15:
        int r109 = r101[r112];
        r101[r112] = r101[r107];
        r101[r107] = r109;
        float r116 = r102[r112];
        r102[r112] = r102[r107];
        r102[r107] = r116;
        int r117 = r104 + 1;
        r103[r104] = r112 - 1;
        int r118 = r117 + 1;
        r103[r117] = r106;
        int r119 = r118 + 1;
        r103[r118] = r107;
        r104 = r119 + 1;
        r103[r119] = r112 + 1;
        goto L6
    L16:
        int r120 = 1;
        int r121 = 1;
    L18:
        if (r120 >= this.f546714d) goto L23;
        int[] r122 = this.f546712b;
        if (r122[r120 - 1] == r122[r120]) goto L22;
        r121 = r121 + 1;
    L22:
        r120 = r120 + 1;
        goto L18
    L23:
        double[] r123 = new double[r121];
        double[][] r124 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r121, 1});
        int r125 = 0;
        int r126 = 0;
    L25:
        if (r125 >= this.f546714d) goto L32;
        if (r125 <= 0) goto L30;
        int[] r127 = this.f546712b;
        if (r127[r125] != r127[r125 - 1]) goto L30;
    L31:
        r125 = r125 + 1;
    L30:
        r123[r126] = ((double) this.f546712b[r125]) * 0.01d;
        r124[r126][0] = this.f546713c[r125];
        r126 = r126 + 1;
        goto L31
    L32:
        this.f546711a = b.a(r110, r123, r124);
    }

    public void b(int r100, float r101) {
        int[] r102 = this.f546712b;
        if (r102.length >= (this.f546714d + 1)) goto L5;
        this.f546712b = Arrays.copyOf(r102, r102.length * 2);
        float[] r103 = this.f546713c;
        this.f546713c = Arrays.copyOf(r103, r103.length * 2);
    L5:
        int[] r104 = this.f546712b;
        int r105 = this.f546714d;
        r104[r105] = r100;
        this.f546713c[r105] = r101;
        this.f546714d = r105 + 1;
    }
}
