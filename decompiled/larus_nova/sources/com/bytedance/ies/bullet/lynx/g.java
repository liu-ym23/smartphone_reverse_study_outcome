package com.bytedance.ies.bullet.lynx;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f247256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f247258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f247259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f247260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Transformer f247261f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f247256a, r101.f247256a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247257b, r101.f247257b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f247258c, r101.f247258c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f247259d, r101.f247259d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f247260e, r101.f247260e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f247261f, r101.f247261f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f247256a.hashCode() * 31;
        String r101 = this.f247257b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f247258c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((((r104 + r106) * 31) + Float.floatToIntBits(this.f247259d)) * 31) + Float.floatToIntBits(this.f247260e)) * 31;
        Transformer r108 = this.f247261f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxImageInfo(context=" + this.f247256a + ", cacheKey=" + this.f247257b + ", src=" + this.f247258c + ", width=" + this.f247259d + ", height=" + this.f247260e + ", transformer=" + this.f247261f + ')';
    }

    public final Context getContext() {
        return this.f247256a;
    }

    public g(Context r100, String r101, String r102, float r103, float r104, Transformer r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f247256a = r100;
        this.f247257b = r101;
        this.f247258c = r102;
        this.f247259d = r103;
        this.f247260e = r104;
        this.f247261f = r105;
    }
}
