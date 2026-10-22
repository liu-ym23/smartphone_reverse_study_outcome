package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f253075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f253076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f253077e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f253073a == r101.f253073a) goto L12;
        return false;
    L12:
        if (this.f253074b == r101.f253074b) goto L15;
        return false;
    L15:
        if (this.f253075c == r101.f253075c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253076d, r101.f253076d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253077e, r101.f253077e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f253073a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f253074b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f253075c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        String r106 = this.f253076d;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        String r110 = this.f253077e;
        if (r110 == null) goto L23;
        r107 = r110.hashCode();
    L23:
        return r109 + r107;
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BitableMorePanelPermission(canChangeWorkspace=" + this.f253073a + ", canMoveOutWorkspace=" + this.f253074b + ", canMoveInWorkspace=" + this.f253075c + ", workspaceToken=" + this.f253076d + ", workspaceName=" + this.f253077e + ')';
    }

    public j(boolean r100, boolean r101, boolean r102, String r103, String r104) {
        this.f253073a = r100;
        this.f253074b = r101;
        this.f253075c = r102;
        this.f253076d = r103;
        this.f253077e = r104;
    }
}
