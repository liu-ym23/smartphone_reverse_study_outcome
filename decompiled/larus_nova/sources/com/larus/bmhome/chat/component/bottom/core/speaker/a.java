package com.larus.bmhome.chat.component.bottom.core.speaker;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f299395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f299396b;

    public a() {
        boolean r100 = false;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f299395a == r101.f299395a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299396b, r101.f299396b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f299395a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f299396b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ASRWithExtResult(intercept=" + this.f299395a + ", messageExt=" + this.f299396b + ')';
    }

    public /* synthetic */ a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r101 & 2) == 0) goto L8;
        Map r102 = MapsKt.emptyMap();
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public a(boolean r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "messageExt");
        this.f299395a = r100;
        this.f299396b = r101;
    }
}
