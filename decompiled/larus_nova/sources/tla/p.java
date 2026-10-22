package tla;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes34.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f546740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f546741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f546742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[][] f546743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f546744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f546745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f546746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f546747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f546748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f546749j;

    public final String toString() {
        String r100 = this.f546745f;
        DecimalFormat r101 = new DecimalFormat("##.##");
        int r102 = 0;
    L4:
        if (r102 >= this.f546744e) goto L6;
        r100 = r100 + "[" + this.f546742c[r102] + " , " + r101.format(this.f546743d[r102]) + "] ";
        r102 = r102 + 1;
        goto L4
    L6:
        return r100;
    }

    public p() {
        this.f546741b = 0;
        this.f546742c = new int[10];
        Class r100 = Float.TYPE;
        this.f546743d = (float[][]) Array.newInstance(r100, new int[]{10, 3});
        this.f546746g = new float[3];
        this.f546747h = false;
        this.f546749j = Float.NaN;
    }

    public final float a(float r100) {
        switch(this.f546741b) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r101 = 1.0f - Math.abs(((r100 * 4.0f) % 4.0f) - 2.0f);
        float r102 = r101 * r101;
    L8:
        return 1.0f - r102;
    L11:
        r102 = ((r100 * 2.0f) + 1.0f) % 2.0f;
        goto L8
    L14:
        r102 = Math.abs(r100);
        goto L8
    L5:
        return (float) Math.sin(r100 * 6.2831855f);
    L10:
        return (float) Math.cos(r100 * 6.2831855f);
    L13:
        return (((r100 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L16:
        return Math.signum(r100 * 6.2831855f);
    }

    public void c(int r110) {
        int r100 = this.f546744e;
        if (r100 != 0) goto L6;
        System.err.println("Error no points added to " + this.f546745f);
        return;
    L6:
        int[] r101 = this.f546742c;
        float[][] r102 = this.f546743d;
        int[] r103 = new int[r101.length + 10];
        r103[0] = r100 - 1;
        r103[1] = 0;
        int r104 = 2;
    L7:
        if (r104 <= 0) goto L17;
        int r105 = r104 - 1;
        int r106 = r103[r105];
        r104 = r105 - 1;
        int r107 = r103[r104];
        if (r106 >= r107) goto L7;
        int r108 = r101[r107];
        int r111 = r106;
        int r112 = r111;
    L11:
        if (r111 >= r107) goto L16;
        int r113 = r101[r111];
        if (r113 > r108) goto L15;
        int r114 = r101[r112];
        r101[r112] = r113;
        r101[r111] = r114;
        float[] r115 = r102[r112];
        r102[r112] = r102[r111];
        r102[r111] = r115;
        r112 = r112 + 1;
    L15:
        r111 = r111 + 1;
        goto L11
    L16:
        int r109 = r101[r112];
        r101[r112] = r101[r107];
        r101[r107] = r109;
        float[] r116 = r102[r112];
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
        goto L7
    L17:
        int r120 = 1;
        int r121 = 0;
    L18:
        int[] r122 = this.f546742c;
        if (r120 >= r122.length) goto L24;
        if (r122[r120] == r122[r120 - 1]) goto L23;
        r121 = r121 + 1;
    L23:
        r120 = r120 + 1;
        goto L18
    L24:
        if (r121 != 0) goto L26;
        r121 = 1;
    L26:
        double[] r123 = new double[r121];
        double[][] r124 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r121, 3});
        int r125 = 0;
        int r126 = 0;
    L28:
        if (r125 >= this.f546744e) goto L35;
        if (r125 <= 0) goto L33;
        int[] r127 = this.f546742c;
        if (r127[r125] != r127[r125 - 1]) goto L33;
    L34:
        r125 = r125 + 1;
    L33:
        r123[r126] = ((double) this.f546742c[r125]) * 0.01d;
        double[] r128 = r124[r126];
        float[] r129 = this.f546743d[r125];
        r128[0] = r129[0];
        r128[1] = r129[1];
        r128[2] = r129[2];
        r126 = r126 + 1;
        goto L34
    L35:
        this.f546740a = b.a(r110, r123, r124);
    }

    public void b(int r100, float r101, float r102, int r103, float r104) {
        int[] r105 = this.f546742c;
        int r106 = this.f546744e;
        r105[r106] = r100;
        float[] r107 = this.f546743d[r106];
        r107[0] = r101;
        r107[1] = r102;
        r107[2] = r104;
        this.f546741b = Math.max(this.f546741b, r103);
        this.f546744e++;
    }
}
