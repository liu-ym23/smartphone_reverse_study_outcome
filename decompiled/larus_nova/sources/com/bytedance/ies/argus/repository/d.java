package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.bean.AspectConfigItem;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.bytedance.ies.argus.bean.n, AspectConfigItem> f246113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t06.d f246114b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f246113a, r101.f246113a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246114b, r101.f246114b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246113a.hashCode() * 31;
        t06.d r101 = this.f246114b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ContainerConfigFormatModel(aspectConfig=" + this.f246113a + ", strategyConfig=" + this.f246114b + ')';
    }

    public d() {
        this(MapsKt.emptyMap(), null);
    }

    public d(Map<com.bytedance.ies.argus.bean.n, AspectConfigItem> r100, t06.d r101) {
        Intrinsics.checkNotNullParameter(r100, "aspectConfig");
        this.f246113a = r100;
        this.f246114b = r101;
    }
}
