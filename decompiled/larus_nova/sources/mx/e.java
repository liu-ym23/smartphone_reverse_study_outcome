package mx;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f516139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f516140c;

    public e() {
        this(0.0f, 7);
    }

    public e(float r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        int r102 = R.color.ttlive_white_10;
    L7:
        if ((r101 & 2) == 0) goto L9;
        float r103 = 0.5f;
    L11:
        if ((r101 & 4) == 0) goto L13;
        r100 = 0.0f;
    L13:
        this.f516138a = r102;
        this.f516139b = r103;
        this.f516140c = r100;
        return;
    L9:
        r103 = 0.0f;
        goto L11
    L5:
        r102 = 0;
        goto L7
    }
}
