package com.bytedance.ee.bear.basesdk.config.strategy.base.bitable;

import com.bytedance.ee.bear.browser.plugin.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f206604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<n.a> f206605b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f206604a, r101.f206604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206605b, r101.f206605b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f206604a.hashCode() * 31) + this.f206605b.hashCode();
    }

    public final String toString() {
        return "BaseAppPluginSpec(effectiveClass=" + this.f206604a + ", createMetadata=" + this.f206605b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Class<?> r100, Function0<? extends n.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "effectiveClass");
        Intrinsics.checkNotNullParameter(r101, "createMetadata");
        this.f206604a = r100;
        this.f206605b = r101;
    }
}
