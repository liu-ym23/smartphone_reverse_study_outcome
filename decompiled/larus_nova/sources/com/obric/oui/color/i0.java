package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f399493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f399494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlendMode f399495c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f399493a), Float.valueOf(r101.f399493a)) == true) goto L12;
        return false;
    L12:
        if (this.f399494b == r101.f399494b) goto L15;
        return false;
    L15:
        if (this.f399495c == r101.f399495c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f399493a) * 31) + this.f399494b) * 31) + this.f399495c.hashCode();
    }

    public final String toString() {
        return "StrokeConfig(width=" + this.f399493a + ", color=" + this.f399494b + ", blendMode=" + this.f399495c + ')';
    }

    public final j0 a() {
        return new j0(this.f399493a, this.f399494b, this.f399495c);
    }

    public i0(float r100, int r101, BlendMode r102) {
        Intrinsics.checkNotNullParameter(r102, "blendMode");
        this.f399493a = r100;
        this.f399494b = r101;
        this.f399495c = r102;
    }
}
