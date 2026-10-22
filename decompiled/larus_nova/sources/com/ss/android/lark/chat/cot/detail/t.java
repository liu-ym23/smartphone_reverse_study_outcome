package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.entity.message.CotStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class t implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CotStatus f415006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f415007b;

    public t() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.f415006a == r101.f415006a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415007b, r101.f415007b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f415006a.hashCode() * 31;
        String r101 = this.f415007b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CotStatusDetailExtra(overallStatus=" + this.f415006a + ", statusText=" + this.f415007b + ')';
    }

    public t(CotStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "overallStatus");
        this.f415006a = r100;
        this.f415007b = r101;
    }

    public /* synthetic */ t(CotStatus r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CotStatus.NONE;
    L5:
        this(r100, null);
    }
}
