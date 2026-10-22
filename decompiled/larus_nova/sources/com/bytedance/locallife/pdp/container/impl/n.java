package com.bytedance.locallife.pdp.container.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f261200b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f261199a, r101.f261199a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f261200b, r101.f261200b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f261199a.hashCode() * 31;
        Map<String, Object> r101 = this.f261200b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PreloadSchemaInfo(schema=" + this.f261199a + ", initData=" + this.f261200b + ')';
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f261199a = r100;
        this.f261200b = null;
    }
}
