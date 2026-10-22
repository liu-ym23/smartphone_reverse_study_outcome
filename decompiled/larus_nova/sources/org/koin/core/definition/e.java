package org.koin.core.definition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f526142a;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f526142a, ((e) r100).f526142a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f526142a.hashCode();
    }

    public final String toString() {
        return "Properties(data=" + this.f526142a + ')';
    }

    public e(Object r100) {
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f526142a = r101;
    }
}
