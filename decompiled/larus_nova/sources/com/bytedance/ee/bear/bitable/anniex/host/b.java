package com.bytedance.ee.bear.bitable.anniex.host;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f206743b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f206742a, r101.f206742a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206743b, r101.f206743b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f206742a.hashCode() * 31) + this.f206743b.hashCode();
    }

    public final String toString() {
        return "BitableLynxMonitorEvent(name=" + this.f206742a + ", params=" + this.f206743b + ')';
    }

    public b(Map r100) {
        Intrinsics.checkNotNullParameter("bitable_mutil_platform_container_res_dev", "name");
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f206742a = "bitable_mutil_platform_container_res_dev";
        this.f206743b = r100;
    }
}
