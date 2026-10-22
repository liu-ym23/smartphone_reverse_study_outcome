package com.bytedance.flow.search.kmp.impl.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f243667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f243668d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f243665a, r101.f243665a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243666b, r101.f243666b) == true) goto L15;
        return false;
    L15:
        if (this.f243667c == r101.f243667c) goto L18;
        return false;
    L18:
        if (this.f243668d == r101.f243668d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f243665a.hashCode() * 31) + this.f243666b.hashCode()) * 31;
        long r101 = this.f243667c;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f243668d;
    }

    public final String toString() {
        return "RecentTopicConversationInfo(id=" + this.f243665a + ", title=" + this.f243666b + ", updateTime=" + this.f243667c + ", unreadCount=" + this.f243668d + ')';
    }

    public e(String r100, String r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f243665a = r100;
        this.f243666b = r101;
        this.f243667c = r102;
        this.f243668d = r103;
    }
}
