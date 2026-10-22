package com.bytedance.lark.policy.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f253844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f253845b;

    public a0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f253844a, r101.f253844a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253845b, r101.f253845b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253844a.hashCode() * 31) + this.f253845b.hashCode();
    }

    public final String toString() {
        return "UserPolicyData(userID=" + this.f253844a + ", policyMap=" + this.f253845b + ')';
    }

    public a0(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter("-404", "userID");
        Intrinsics.checkNotNullParameter(r101, "policyMap");
        this.f253844a = "-404";
        this.f253845b = r101;
    }
}
