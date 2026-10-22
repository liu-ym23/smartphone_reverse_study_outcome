package com.bytedance.lark.view_flow_wrapper;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes20.dex */
public final class l<Key> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f254443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<?> f254444b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f254443a, r101.f254443a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254444b, r101.f254444b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f254443a.hashCode() * 31;
        KClass<?> r101 = this.f254444b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MappedKey(actualKey=" + this.f254443a + ", clazz=" + this.f254444b + ')';
    }

    public l(Key r100, KClass<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "actualKey");
        this.f254443a = r100;
        this.f254444b = r101;
    }
}
