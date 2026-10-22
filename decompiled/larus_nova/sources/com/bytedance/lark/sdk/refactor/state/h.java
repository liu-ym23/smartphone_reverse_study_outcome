package com.bytedance.lark.sdk.refactor.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f254310d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f254311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f254312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f254313c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f254311a == r101.f254311a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254312b, r101.f254312b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f254313c, r101.f254313c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f254311a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Long r102 = this.f254312b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.f254313c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "RustOperation(success=" + this.f254311a + ", destinationContainerId=" + this.f254312b + ", userContainerId=" + this.f254313c + ')';
    }

    public h(boolean r100, Long r101, Long r102) {
        this.f254311a = r100;
        this.f254312b = r101;
        this.f254313c = r102;
    }
}
