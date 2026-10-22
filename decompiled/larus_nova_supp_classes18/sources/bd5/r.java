package bd5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r {
    public final int a;
    public final int b;
    public int c;
    public int d;

    public final float a(int r3) {
        int r0 = this.b;
        if (r3 > r0) goto L15;
        int r4 = this.c;
        if (r4 > 0) goto L17;
        float r5 = (r4 + r0) / r0;
        if (r5 <= 1.0f) goto L11;
        return 1.0f;
    L11:
        if (r5 >= 0.1f) goto L14;
        return 0.0f;
    L14:
        return r5;
    L17:
        return 1.0f;
    L15:
        return 1.0f;
    }

    public r(int r2, int r3) {
        this.c = 0;
        this.b = r2;
        this.a = r3;
    }

    public final int b(int r4, int r5) {
        int r6 = r4 - r5;
        int r0 = this.b;
        if (r6 >= r0) goto L6;
        this.c += r6 - r0;
    L5:
        r6 = r0;
    L12:
        int r7 = this.c;
        if (r7 >= (-r0)) goto L15;
        this.c = -r0;
    L17:
        return r6;
    L15:
        if (r7 <= 0) goto L17;
        this.c = 0;
        goto L17
    L6:
        int r2 = this.a;
        if (r6 <= r2) goto L9;
        this.c = 0;
        r6 = r2;
        goto L12
    L9:
        int r3 = this.c;
        if (r3 >= 0) goto L12;
        this.c = r3 - r5;
        goto L5
    }

    public r(int r2, int r3, int r4) {
        this.c = 0;
        this.b = r2;
        this.a = r3;
        this.d = r4;
    }
}
