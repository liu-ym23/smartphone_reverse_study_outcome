package com.obric.oui.texteffects.runtime;

import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f403337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f403338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f403339c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f403337a == r101.f403337a) goto L12;
        return false;
    L12:
        if (this.f403338b == r101.f403338b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f403339c, r101.f403339c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f403337a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f403338b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f403339c.hashCode();
    }

    public final String toString() {
        return "TextEffectFrame(playTimeMs=" + this.f403337a + ", normalizedPlayTimeMs=" + this.f403338b + ", layers=" + this.f403339c + ')';
    }

    public e(long r100, long r101, List<d> r102) {
        Intrinsics.checkNotNullParameter(r102, GXTemplateKey.GAIAX_LAYERS);
        this.f403337a = r100;
        this.f403338b = r101;
        this.f403339c = r102;
    }
}
