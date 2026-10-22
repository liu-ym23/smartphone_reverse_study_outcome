package com.larus.video.impl.sdk.prefetch;

import com.larus.platform.api.w4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, w4> f375856a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375856a, ((f) r100).f375856a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375856a.hashCode();
    }

    public final String toString() {
        return "CachedPreloadErrorReasonDataMapWrapper(cachedUserPreloadErrorReasonDataMap=" + this.f375856a + ')';
    }

    public f(ConcurrentHashMap<String, w4> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedUserPreloadErrorReasonDataMap");
        this.f375856a = r100;
    }

    public /* synthetic */ f(int r100) {
        this(new ConcurrentHashMap());
    }
}
