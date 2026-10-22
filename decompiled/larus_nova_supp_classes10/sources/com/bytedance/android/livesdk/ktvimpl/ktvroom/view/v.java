package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v {
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public int g;
    public int h;
    public float i;
    public long j;
    public long k;
    public long l;
    public float m;
    public int n;

    public v() {
        this.a = s1.y();
        this.b = s1.f(15.0f);
        int r0 = s1.f(16.0f);
        int r1 = s1.f(56.0f);
        this.c = r1;
        int r2 = r1 - r0;
        this.d = r2;
        this.e = s1.f(5.0f);
        this.f = r2 + s1.f(5.0f);
        this.g = 58;
        this.h = 90;
        this.j = 1180;
        this.k = 4720;
        this.l = 5900;
        s1.f(7.0f);
    }

    public final int a(float r3, int r4) {
        float r5 = r3 - this.c;
        int r0 = this.h;
        if (r4 < r0) goto L5;
        int r6 = this.e;
    L13:
        return (int) (r6 + r5);
    L5:
        int r1 = this.g;
        if (r4 != r1) goto L9;
        int r7 = this.e;
        int r2 = this.d;
    L8:
        r6 = r7 + r2;
        goto L13
    L9:
        if (r4 >= r1) goto L11;
        r6 = this.f;
        goto L13
    L11:
        r7 = (int) (this.i * (r0 - r4));
        r2 = this.e;
        goto L8
    }
}
