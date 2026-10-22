package com.larus.network.http;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class f<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncThrowable f360157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f360158e;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Reflection.getOrCreateKotlinClass(this.f360157d.getClass()), this.f360157d.getMessage(), ArraysKt.firstOrNull(this.f360157d.getStackTrace())});
    }

    public final String toString() {
        return "Fail(error=" + this.f360157d + ", value=" + this.f360158e + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == true) goto L5;
        return false;
    L5:
        AsyncThrowable r101 = ((f) r100).f360157d;
        if (this.f360157d.getClass() == r101.getClass()) goto L8;
        return false;
    L8:
        if (this.f360157d.getCode() == r101.getCode()) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f360157d.getMessage(), r101.getMessage()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(ArraysKt.firstOrNull(this.f360157d.getStackTrace()), ArraysKt.firstOrNull(r101.getStackTrace())) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public f(AsyncThrowable r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super(true, r101, null);
        this.f360157d = r100;
        this.f360158e = r101;
    }
}
