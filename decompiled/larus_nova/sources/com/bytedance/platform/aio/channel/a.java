package com.bytedance.platform.aio.channel;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f266575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f266576c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f266574a, r101.f266574a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f266575b, r101.f266575b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f266576c, r101.f266576c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f266574a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f266575b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f266576c;
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
        return "Error(category=" + this.f266574a + ", message=" + this.f266575b + ", extra=" + this.f266576c + ")";
    }

    public a(String r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f266574a = r100;
        this.f266575b = r101;
        this.f266576c = r102;
    }
}
