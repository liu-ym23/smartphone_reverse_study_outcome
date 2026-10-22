package e17;

import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f470704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f470705b;

    public a(int r100) {
        this.f470705b = r100;
        this.f470704a = new short[1 << r100];
    }

    public final int a(b r100) throws IOException {
        int r101 = this.f470705b;
        int r102 = 1;
    L3:
        if (r101 == 0) goto L6;
        r102 = r100.a(this.f470704a, r102) + (r102 << 1);
        r101 = r101 - 1;
        goto L3
    L6:
        return r102 - (1 << this.f470705b);
    }
}
