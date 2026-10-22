package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f399490c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f399491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f399492b;

    static {
        f399490c = new b(0, BlendMode.SRC_OVER);
    }

    public final String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.f399491a), Integer.valueOf(this.f399492b)});
    }

    public b(int r100, int r101) {
        this.f399491a = r100;
        this.f399492b = r101;
    }

    public b(int r100, BlendMode r101) {
        this(r100, BlendMode.mapToLegacyObricBlend(r101));
    }
}
