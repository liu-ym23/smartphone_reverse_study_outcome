package com.bytedance.salamander.anniex;

import android.os.Debug;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6 f268352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f268353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewType f268354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f268355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f268356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f268357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f268358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f268359h;

    public r6() {
        this.f268352a = new t6();
        this.f268354c = ViewType.Card;
        int r100 = com.bytedance.rts.foundation.c.f267576a;
        int r101 = com.bytedance.rts.foundation.b.f267575a;
        this.f268356e = System.currentTimeMillis();
    }

    public final void a() {
        long r100 = Debug.getPss() * ((long) 1024);
    L6:
        if (r100 <= 0) goto L18;
        Long r101 = this.f268358g;
        if (r101 == null) goto L19;
        Intrinsics.checkNotNull(r101);
        if (r101.longValue() <= 0) goto L21;
        Long r102 = this.f268358g;
        Intrinsics.checkNotNull(r102);
        long r103 = r100 - r102.longValue();
        if (r103 <= this.f268357f) goto L20;
        this.f268357f = r103;
        return;
    L20:
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L4:
        r100 = -1;
        goto L6
    }
}
