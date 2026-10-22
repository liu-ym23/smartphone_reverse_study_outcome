package com.bytedance.assem.arch.extensions;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f192925a;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Reflection.getOrCreateKotlinClass(this.f192925a.getClass()), this.f192925a.getMessage(), this.f192925a.getStackTrace()[0]});
    }

    public final String toString() {
        return "Fail(error=" + this.f192925a + ")";
    }

    public e(Throwable r100) {
        this.f192925a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == true) goto L5;
        return false;
    L5:
        Throwable r101 = ((e) r100).f192925a;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(this.f192925a.getClass()), Reflection.getOrCreateKotlinClass(r101.getClass())) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f192925a.getMessage(), r101.getMessage()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f192925a.getStackTrace()[0], r101.getStackTrace()[0]) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
