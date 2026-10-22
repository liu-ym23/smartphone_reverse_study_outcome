package com.google.common.cache;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f274876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f274877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f274878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f274879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f274880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f274881f;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f274876a), Long.valueOf(this.f274877b), Long.valueOf(this.f274878c), Long.valueOf(this.f274879d), Long.valueOf(this.f274880e), Long.valueOf(this.f274881f)});
    }

    public final String toString() {
        com.google.common.base.j.a r100 = com.google.common.base.j.b(this);
        r100.a("hitCount", this.f274876a);
        r100.a("missCount", this.f274877b);
        r100.a("loadSuccessCount", this.f274878c);
        r100.a("loadExceptionCount", this.f274879d);
        r100.a("totalLoadTime", this.f274880e);
        r100.a("evictionCount", this.f274881f);
        return r100.toString();
    }

    public final boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f274876a == r101.f274876a) goto L7;
        return false;
    L7:
        if (this.f274877b == r101.f274877b) goto L9;
        return false;
    L9:
        if (this.f274878c == r101.f274878c) goto L11;
        return false;
    L11:
        if (this.f274879d == r101.f274879d) goto L13;
        return false;
    L13:
        if (this.f274880e == r101.f274880e) goto L15;
        return false;
    L15:
        if (this.f274881f != r101.f274881f) goto L24;
        return true;
    L24:
        return false;
    L18:
        return false;
    }

    public e(long r110, long r210, long r211, long r212, long r213, long r214) {
        boolean r111 = true;
        if (r110 < 0) goto L5;
        boolean r112 = true;
    L6:
        com.google.common.base.m.b(r112);
        if (r210 < 0) goto L9;
        boolean r113 = true;
    L10:
        com.google.common.base.m.b(r113);
        if (r211 < 0) goto L13;
        boolean r114 = true;
    L14:
        com.google.common.base.m.b(r114);
        if (r212 < 0) goto L17;
        boolean r115 = true;
    L18:
        com.google.common.base.m.b(r115);
        if (r213 < 0) goto L21;
        boolean r116 = true;
    L22:
        com.google.common.base.m.b(r116);
        if (r214 >= 0) goto L26;
        r111 = false;
    L26:
        com.google.common.base.m.b(r111);
        this.f274876a = r110;
        this.f274877b = r210;
        this.f274878c = r211;
        this.f274879d = r212;
        this.f274880e = r213;
        this.f274881f = r214;
        return;
    L21:
        r116 = false;
        goto L22
    L17:
        r115 = false;
        goto L18
    L13:
        r114 = false;
        goto L14
    L9:
        r113 = false;
        goto L10
    L5:
        r112 = false;
        goto L6
    }
}
