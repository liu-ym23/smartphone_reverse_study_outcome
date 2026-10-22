package com.bytedance.lark.policy.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, h> f253851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f253852c;

    public h() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f253850a, r101.f253850a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253851b, r101.f253851b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253852c, r101.f253852c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f253850a.hashCode() * 31) + this.f253851b.hashCode()) * 31) + this.f253852c.hashCode();
    }

    public final String toString() {
        return "DeptPolicyNode(deptId=" + this.f253850a + ", children=" + this.f253851b + ", policyMap=" + this.f253852c + ')';
    }

    public /* synthetic */ h(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "-404";
    L5:
        LinkedHashMap r102 = null;
        if ((r101 & 2) == 0) goto L8;
        LinkedHashMap r103 = new LinkedHashMap();
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = new LinkedHashMap();
    L12:
        this(r100, r103, r102);
        return;
    L8:
        r103 = null;
        goto L10
    }

    public h(String r100, Map<String, h> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "deptId");
        Intrinsics.checkNotNullParameter(r101, "children");
        Intrinsics.checkNotNullParameter(r102, "policyMap");
        this.f253850a = r100;
        this.f253851b = r101;
        this.f253852c = r102;
    }
}
