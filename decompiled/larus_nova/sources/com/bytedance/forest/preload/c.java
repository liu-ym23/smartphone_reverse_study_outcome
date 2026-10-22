package com.bytedance.forest.preload;

import com.bytedance.forest.model.RequestParams;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RequestParams f244481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.forest.utils.a f244482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f244483d;

    public final int hashCode() {
        return this.f244482c.hashCode();
    }

    public final String toString() {
        return "PreloadTask@" + hashCode() + "(key=" + this.f244482c + ", params=" + this.f244481b + ", delegate=" + this.f244483d + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(this.f244482c, ((c) r100).f244482c)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.preload.PreloadTask");
    L8:
        r101 = null;
        goto L10
    }

    public c(String r100, RequestParams r101, com.bytedance.forest.utils.a r102, a r103) {
        this.f244480a = r100;
        this.f244481b = r101;
        this.f244482c = r102;
        this.f244483d = r103;
    }
}
