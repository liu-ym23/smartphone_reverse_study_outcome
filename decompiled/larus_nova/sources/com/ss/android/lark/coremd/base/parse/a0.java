package com.ss.android.lark.coremd.base.parse;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a0 implements com.ss.android.lark.coremd.ext.j, com.ss.android.lark.coremd.ext.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, Object> f419536c;

    public final int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419536c;
    }

    public a0(com.ss.android.lark.coremd.ext.j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f419536c = r100.getValues();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.coremd.base.parse.ThemeExtendData");
        return Intrinsics.areEqual(this.f419536c, ((a0) r100).f419536c);
    L8:
        r102 = null;
        goto L10
    }
}
