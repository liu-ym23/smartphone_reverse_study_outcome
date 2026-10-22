package com.bytedance.forest.model;

import com.bytedance.forest.chain.fetchers.ResourceFetcher;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FetcherType {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FetcherType f244228c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FetcherType f244229d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final FetcherType f244230e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FetcherType f244231f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final FetcherType f244232g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Request, ResourceFetcher> f244234b;

    public static final class a {
    }

    public final String toString() {
        return "FetcherType(name=" + this.f244233a + ", creator=" + this.f244234b + ")";
    }

    static {
        f244228c = new FetcherType("PRELOAD_CONSUME", FetcherType$Companion$PRELOAD_CONSUME$1.INSTANCE);
        f244229d = new FetcherType("GECKO", FetcherType$Companion$GECKO$1.INSTANCE);
        f244230e = new FetcherType("BUILTIN", FetcherType$Companion$BUILTIN$1.INSTANCE);
        f244231f = new FetcherType("CDN", FetcherType$Companion$CDN$1.INSTANCE);
        f244232g = new FetcherType("MEMORY", FetcherType$Companion$MEMORY$1.INSTANCE);
    }

    public final int hashCode() {
        return this.f244233a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((true ^ Intrinsics.areEqual(FetcherType.class, r101)) == false) goto L13;
        return false;
    L13:
        if (r100 == null) goto L17;
        return Intrinsics.areEqual(this.f244233a, ((FetcherType) r100).f244233a);
    L17:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.model.FetcherType");
    L8:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetcherType(String r100, Function1<? super Request, ? extends ResourceFetcher> r101) {
        this.f244233a = r100;
        this.f244234b = r101;
    }
}
