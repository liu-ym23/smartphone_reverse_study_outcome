package com.ss.android.lark.api.bean.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ForsetiMarginType f408680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f408681b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f408680a == r101.f408680a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f408681b, r101.f408681b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f408680a.hashCode() * 31;
        Integer r101 = this.f408681b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ForsetiMarginSetting(type=" + this.f408680a + ", value=" + this.f408681b + ')';
    }

    public final ForsetiMarginType getType() {
        return this.f408680a;
    }

    public /* synthetic */ c(int r100) {
        this(ForsetiMarginType.DEFAULT, null);
    }

    public c(ForsetiMarginType r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f408680a = r100;
        this.f408681b = r101;
    }
}
