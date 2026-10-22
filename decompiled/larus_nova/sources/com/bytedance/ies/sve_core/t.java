package com.bytedance.ies.sve_core;

import com.bytedance.ies.sve_core.a;
import com.bytedance.ies.sve_core.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class t<S extends s, A extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f248699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<S, A, S> f248700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m<s> f248701c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f248699a, r101.f248699a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f248700b, r101.f248700b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f248701c, r101.f248701c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f248699a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function2<S, A, S> r104 = this.f248700b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        m<s> r107 = this.f248701c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreModule(name=" + this.f248699a + ", reducer=" + this.f248700b + ", state=" + this.f248701c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(String r100, Function2<? super S, ? super A, ? extends S> r101, m<s> r102) {
        this.f248699a = r100;
        this.f248700b = r101;
        this.f248701c = r102;
    }
}
