package com.larus.im.service.audio;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f350772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ue9.g f350774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f350775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f350776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f350777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f350778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f350779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f350780i;

    public final String toString() {
        return "Frame(content=" + Arrays.toString(this.f350772a) + ", extra=" + this.f350773b + ", type=" + this.f350774c + ", silent=" + this.f350775d + ", muted=" + this.f350776e + ')';
    }

    public final ouc.d0 b() {
        return (ouc.d0) this.f350777f.getValue();
    }

    public final String c() {
        return (String) this.f350779h.getValue();
    }

    public final String d() {
        return (String) this.f350778g.getValue();
    }

    public final int hashCode() {
        int r100 = Arrays.hashCode(this.f350772a) * 31;
        String r101 = this.f350773b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((r100 + r102) * 31) + this.f350774c.hashCode()) * 31;
        int r104 = 1231;
        if (this.f350775d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f350776e == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final ue9.g getType() {
        return this.f350774c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Arrays.equals(this.f350772a, r101.f350772a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350773b, r101.f350773b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350774c, r101.f350774c) == true) goto L18;
        return false;
    L18:
        if (this.f350775d == r101.f350775d) goto L21;
        return false;
    L21:
        if (this.f350776e == r101.f350776e) goto L23;
        return false;
    L23:
        return true;
    }

    public /* synthetic */ l(byte[] r100, String r101, ue9.g r102, boolean r110) {
        this(r100, r101, r102, r110, false);
    }

    public static l a(l r100, byte[] r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r101 = r100.f350772a;
    L5:
        byte[] r104 = r101;
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f350773b;
    L8:
        String r105 = r102;
        if ((r103 & 4) == 0) goto L11;
        ue9.g r106 = r100.f350774c;
    L12:
        ue9.g r107 = r106;
        if ((r103 & 8) == 0) goto L15;
        boolean r108 = r100.f350775d;
    L17:
        if ((r103 & 16) == 0) goto L19;
        boolean r109 = r100.f350776e;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "content");
        Intrinsics.checkNotNullParameter(r107, "type");
        return new l(r104, r105, r107, r108, r109);
    L19:
        r109 = false;
        goto L20
    L15:
        r108 = false;
        goto L17
    L11:
        r106 = null;
        goto L12
    }

    public l(byte[] r100, String r101, ue9.g r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f350772a = r100;
        this.f350773b = r101;
        this.f350774c = r102;
        this.f350775d = r103;
        this.f350776e = r104;
        this.f350777f = LazyKt.lazy(new h(this));
        this.f350778g = LazyKt.lazy(new i(this));
        this.f350779h = LazyKt.lazy(new j(this));
        this.f350780i = LazyKt.lazy(new k(this));
    }
}
