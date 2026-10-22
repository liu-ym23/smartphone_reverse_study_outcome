package com.larus.video.impl.douyin;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f375769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f375770c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f375768a, r101.f375768a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375769b, r101.f375769b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f375770c, r101.f375770c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f375768a.hashCode() * 31) + this.f375769b.hashCode()) * 31) + this.f375770c.hashCode();
    }

    public final String toString() {
        return "EnterDouYinSdkParam(enterItemId=" + this.f375768a + ", enterAids=" + this.f375769b + ", interactiveRecInfoList=" + this.f375770c + ')';
    }

    public w(String r100, List<String> r101, List<Pair<String, String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "enterItemId");
        Intrinsics.checkNotNullParameter(r101, "enterAids");
        Intrinsics.checkNotNullParameter(r102, "interactiveRecInfoList");
        this.f375768a = r100;
        this.f375769b = r101;
        this.f375770c = r102;
    }
}
