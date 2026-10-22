package com.bytedance.locallife.live.anchor;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, j> f259155a;

    public k() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f259155a, ((k) r100).f259155a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f259155a.hashCode();
    }

    public final String toString() {
        return "LocalLifeAtmosphereInfo(iconMap=" + this.f259155a + ')';
    }

    public k(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "iconMap");
        this.f259155a = r101;
    }
}
