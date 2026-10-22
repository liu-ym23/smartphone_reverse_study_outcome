package com.bytedance.kmp.ec.yata.common.biz.callback;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.store.node.c f251370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f251372c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f251370a, r101.f251370a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251371b, r101.f251371b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f251372c, r101.f251372c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        com.bytedance.kmp.ec.yata.store.node.c r100 = this.f251370a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f251371b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f251372c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FetchCallbackModel(node=" + this.f251370a + ", triggerType=" + this.f251371b + ", operatorType=" + this.f251372c + ')';
    }

    public a(com.bytedance.kmp.ec.yata.store.node.c r100, String r101, String r102) {
        this.f251370a = r100;
        this.f251371b = r101;
        this.f251372c = r102;
    }
}
