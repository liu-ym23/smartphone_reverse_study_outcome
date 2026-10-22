package com.larus.platform.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f365151d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i4) == true) goto L8;
        return false;
    L8:
        i4 r101 = (i4) r100;
        if (Intrinsics.areEqual(this.f365148a, r101.f365148a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365149b, r101.f365149b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365150c, r101.f365150c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365151d, r101.f365151d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f365148a.hashCode() * 31) + this.f365149b.hashCode()) * 31) + this.f365150c.hashCode()) * 31) + this.f365151d.hashCode();
    }

    public final String toString() {
        return "LunaRequestLunaMusicConfig(clientKey=" + this.f365148a + ", scope=" + this.f365149b + ", state=" + this.f365150c + ", traceInfo=" + this.f365151d + ')';
    }

    public i4(String r100, String r101, String r102, HashMap<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        this.f365148a = r100;
        this.f365149b = r101;
        this.f365150c = r102;
        this.f365151d = r103;
    }
}
