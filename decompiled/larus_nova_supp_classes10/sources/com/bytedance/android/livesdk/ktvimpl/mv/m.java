package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public Integer a;
    public Long b;
    public Long c;
    public String d;
    public Integer e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof m) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f, ((m) r2).f) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.f;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "MvReportEvent(vId=" + this.f + ")";
    }

    public m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vId");
        this.f = r2;
    }
}
