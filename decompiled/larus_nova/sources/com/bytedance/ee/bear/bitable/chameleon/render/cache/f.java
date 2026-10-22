package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f209708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableSubType f209709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f209710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f209711d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f209708a, r101.f209708a) == true) goto L12;
        return false;
    L12:
        if (this.f209709b == r101.f209709b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f209710c, r101.f209710c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f209711d, r101.f209711d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f209708a.hashCode() * 31) + this.f209709b.hashCode()) * 31) + this.f209710c.hashCode()) * 31) + this.f209711d.hashCode();
    }

    public final String toString() {
        return "BitableCacheRequest(userId=" + this.f209708a + ", scene=" + this.f209709b + ", token=" + this.f209710c + ", url=" + this.f209711d + ')';
    }

    public f(String r100, BitableSubType r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f209708a = r100;
        this.f209709b = r101;
        this.f209710c = r102;
        this.f209711d = r103;
    }
}
