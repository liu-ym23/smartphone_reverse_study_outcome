package es3;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e$b {
    public final String a;
    public long b;
    public int c;
    public int d;
    public final int[] e;
    public final int f;

    public final String toString() {
        return "visibleScene=" + this.a + ", sumFrame=" + this.c + ", sumDroppedFrames=" + this.d + ", sumFrameCost=" + this.b + ", dropLevel=" + Arrays.toString(this.e);
    }

    public e$b(String r2) {
        this.c = 0;
        this.a = r2;
        int r3 = com.bytedance.apm.util.i.b - 1;
        this.f = r3;
        this.e = new int[(r3 - 0) + 1];
    }
}
