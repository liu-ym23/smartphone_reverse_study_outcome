package android.ss.com.vboost.i;

import android.ss.com.vboost.FrequencyLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f122g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f125c;
    public FrequencyLevel d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f126f;

    static {
        f122g = FrequencyLevel.LEVEL_6.ordinal();
    }

    public d(int r2, int r3, g r4, FrequencyLevel r5) {
        this.e = 1000;
        this.f126f = f122g;
        this.f123a = r2;
        this.f124b = r4;
        this.f125c = r3;
        this.d = r5;
    }

    public boolean a(FrequencyLevel r2, int r3) {
        if ((r3 - this.f125c) > this.e) goto L5;
    L7:
        return false;
    L5:
        if (r2.ordinal() <= this.f126f) goto L7;
        return true;
    }
}
