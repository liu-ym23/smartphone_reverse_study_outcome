package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f399487c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f399488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f399489b;

    /* JADX INFO: renamed from: com.obric.oui.color.a$a, reason: collision with other inner class name */
    public static final class C4668a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f399488a == r101.f399488a) goto L12;
        return false;
    L12:
        if (this.f399489b == r101.f399489b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f399488a * 31) + this.f399489b;
    }

    static {
        f399487c = new a(0, BlendMode.SRC_OVER);
    }

    public final String toString() {
        return "BlendConfig#" + hashCode() + "(color=" + String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.f399488a)}, 1)) + ", blendMode=" + this.f399489b + ')';
    }

    public a(int r100, BlendMode r101) {
        Intrinsics.checkNotNullParameter(r101, "mode");
        this(r100, BlendMode.mapToLegacyObricBlend(r101));
    }

    public a(int r100, int r101) {
        this.f399488a = r100;
        this.f399489b = r101;
    }
}
