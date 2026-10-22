package com.larus.dora.impl.guide.strategy;

import com.larus.dora.impl.util.b0;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f335991b;

    public final Object a() {
        b0.f338123a.getClass();     // Catch: Exception -> L5
        long r100 = b0.j().getLong(this.f335990a, -1);     // Catch: Exception -> L5
    L7:
        boolean r101 = true;
        if (r100 == (-1)) goto L10;
        long r102 = System.currentTimeMillis();
        if ((r102 - r100) >= this.f335991b) goto L15;
        r101 = false;
    L15:
        g49.d.d("FrequencyStrategy", "frequency check: key=" + this.f335990a + ", last=" + r100 + ", now=" + r102 + ", interval=" + this.f335991b + ", passed=" + r101);
        return Boxing.boxBoolean(r101);
    L10:
        return Boxing.boxBoolean(true);
    L5:
        e = move-exception;
        g49.d.c("FrequencyStrategy", "read lastShowTime failed for key=" + this.f335990a + ", error=" + e.getMessage(), e);
        r100 = -1;
        goto L7
    }

    public final void b() {
        long r100 = System.currentTimeMillis();
        b0.f338123a.getClass();     // Catch: Exception -> L5
        b0.j().storeLong(this.f335990a, r100);     // Catch: Exception -> L5
        g49.d.d("FrequencyStrategy", "refresh lastShowTime for key=" + this.f335990a + " at ts=" + r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g49.d.c("FrequencyStrategy", "store refresh lastShowTime failed for key=" + this.f335990a + ", error=" + e.getMessage(), e);
    }

    public c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "kevaKey");
        this.f335990a = r100;
        this.f335991b = r101;
    }
}
