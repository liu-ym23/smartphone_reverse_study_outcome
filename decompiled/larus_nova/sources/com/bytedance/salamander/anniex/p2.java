package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p2 extends g5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f268285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f268286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f268287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f268288f;

    public p2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appVersion");
        super(1);
        f8<Integer, Integer, Integer> r101 = d.a(r100);
        this.f268285c = r101.f268067a.intValue();
        this.f268286d = r101.f268068b.intValue();
        this.f268287e = r101.f268069c.intValue();
        this.f268288f = (r101.f268069c.intValue() + (r101.f268068b.intValue() * 1000)) + (r101.f268067a.intValue() * 1000000);
    }

    @Override // com.bytedance.salamander.anniex.g5
    public final boolean a(b5 r100) {
        Intrinsics.checkNotNullParameter(r100, "redirectRule");
        String r101 = com.bytedance.anniex.bd.foundation.impl.o.p(r100.f267983d, "targetValue");
        int r102 = com.bytedance.anniex.bd.foundation.impl.o.f(r100.f267983d, com.heytap.mcssdk.constant.b.f276366p, -1);
        if (r102 != (-1)) goto L6;
        return false;
    L6:
        if (r101.length() != 0) goto L9;
        return false;
    L9:
        if (this.f268285c != (-1)) goto L11;
        return false;
    L11:
        if (this.f268286d != (-1)) goto L13;
        return false;
    L13:
        if (this.f268287e == (-1)) goto L59;
        f8<Integer, Integer, Integer> r103 = d.a(r101);
        int r104 = (r103.f268069c.intValue() + (r103.f268068b.intValue() * 1000)) + (r103.f268067a.intValue() * 1000000);
        if (r102 == 0) goto L48;
        if (r102 == 1) goto L44;
        if (r102 == 2) goto L40;
        if (r102 == 3) goto L36;
        if (r102 == 4) goto L32;
        if (r102 == 5) goto L28;
        return false;
    L28:
        if (this.f268288f == r104) goto L51;
        return true;
    L51:
        return false;
    L32:
        if ((this.f268288f - r104) > 0) goto L52;
        return true;
    L52:
        return false;
    L36:
        if ((this.f268288f - r104) < 0) goto L53;
        return true;
    L53:
        return false;
    L40:
        if ((this.f268288f - r104) >= 0) goto L54;
        return true;
    L54:
        return false;
    L44:
        if ((this.f268288f - r104) <= 0) goto L55;
        return true;
    L55:
        return false;
    L48:
        if (this.f268288f != r104) goto L58;
        return true;
    L58:
        return false;
    L59:
        return false;
    }
}
