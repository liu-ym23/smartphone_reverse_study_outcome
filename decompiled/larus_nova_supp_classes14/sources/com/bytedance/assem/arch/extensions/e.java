package com.bytedance.assem.arch.extensions;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> extends c<T> {
    public final Throwable a;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Reflection.getOrCreateKotlinClass(this.a.getClass()), this.a.getMessage(), this.a.getStackTrace()[0]});
    }

    public final String toString() {
        return "Fail(error=" + this.a + ")";
    }

    public e(Throwable r1) {
        this.a = r1;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof e) == true) goto L5;
        return false;
    L5:
        Throwable r5 = ((e) r4).a;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(this.a.getClass()), Reflection.getOrCreateKotlinClass(r5.getClass())) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.a.getMessage(), r5.getMessage()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.a.getStackTrace()[0], r5.getStackTrace()[0]) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
