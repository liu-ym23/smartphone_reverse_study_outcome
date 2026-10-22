package com.bytedance.applog.priority.original;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public final boolean a;
    public final t b;
    public final int c;
    public int d;
    public final AtomicInteger e;
    public final AtomicInteger f;
    public long g;
    public long h;
    public final int i;
    public final int j;

    public final Model$GroupFrequencyAllow a() {
        long r0 = System.currentTimeMillis() / ((long) ECDraweeView.SQUARE);
        this.h = r0;
        if (this.a == true) goto L5;
        int r2 = this.e.get();
        boolean r3 = true;
        if (r2 != 0) goto L23;
        if ((r0 - this.g) < 60) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == false) goto L29;
        this.f.set(0);
        this.g = this.h;
    L30:
        boolean r4 = true;
    L32:
        if (r4 == false) goto L34;
        int r5 = this.c;
        if (r5 != 0) goto L38;
    L44:
        if (r3 == true) goto L48;
        return Model$GroupFrequencyAllow.BlockByBackoff;
    L48:
        return Model$GroupFrequencyAllow.Allow;
    L38:
        if (r5 == this.i) goto L44;
        if (new SecureRandom().nextInt(this.i) > this.c) goto L44;
        this.f.incrementAndGet();
        r3 = false;
        goto L44
    L34:
        return Model$GroupFrequencyAllow.BlockByFrequency;
    L29:
        if (this.f.get() < this.d) goto L30;
        r4 = false;
        goto L32
    L19:
        r1 = false;
        goto L20
    L23:
        if ((r0 - this.g) < (((long) 60) * ((long) Math.pow(2.0d, r2)))) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == false) goto L29;
        this.f.set(0);
        this.g = this.h;
        goto L30
    L25:
        r6 = false;
        goto L26
    L5:
        if (this.e.get() <= 0) goto L13;
        long r7 = this.h;
        if ((r7 - this.g) <= 5) goto L11;
        this.g = r7;
        return Model$GroupFrequencyAllow.Allow;
    L11:
        return Model$GroupFrequencyAllow.BlockByFrequency;
    L13:
        return Model$GroupFrequencyAllow.Allow;
    }

    public m(boolean r2, t r3, int r4, int r5, AtomicInteger r6, AtomicInteger r7) {
        Intrinsics.checkNotNullParameter(r3, "version");
        Intrinsics.checkNotNullParameter(r6, "level");
        Intrinsics.checkNotNullParameter(r7, "levelSuccessCnt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = 0;
        this.h = 0;
        this.i = 10000;
        this.j = 5;
    }
}
