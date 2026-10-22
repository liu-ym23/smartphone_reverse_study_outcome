package com.larus.music;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f359478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f359480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Object> f359481d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f359478a, r101.f359478a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359479b, r101.f359479b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359480c, r101.f359480c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359481d, r101.f359481d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f359478a.hashCode() * 31) + this.f359479b.hashCode()) * 31) + this.f359480c.hashCode()) * 31) + this.f359481d.hashCode();
    }

    public final String toString() {
        return "LunaRequestLunaMusicConfig(clientKey=" + this.f359478a + ", scope=" + this.f359479b + ", state=" + this.f359480c + ", traceInfo=" + this.f359481d + ')';
    }

    public l(String r100, String r101, String r102, HashMap<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "traceInfo");
        this.f359478a = r100;
        this.f359479b = r101;
        this.f359480c = r102;
        this.f359481d = r103;
    }
}
