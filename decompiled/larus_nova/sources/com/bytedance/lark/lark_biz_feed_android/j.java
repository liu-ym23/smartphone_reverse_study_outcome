package com.bytedance.lark.lark_biz_feed_android;

import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FeedCardEntity;

/* JADX INFO: loaded from: classes8.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedCardType f253170b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f253169a, r101.f253169a) == true) goto L12;
        return false;
    L12:
        if (this.f253170b == r101.f253170b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253169a.hashCode() * 31) + this.f253170b.hashCode();
    }

    public final String toString() {
        return "FeedCardEntity(feedId=" + this.f253169a + ", feedType=" + this.f253170b + ')';
    }

    public final FeedCardEntity a() {
        return new FeedCardEntity(this.f253169a, this.f253170b.into());
    }

    public j(String r100, FeedCardType r101) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        Intrinsics.checkNotNullParameter(r101, "feedType");
        this.f253169a = r100;
        this.f253170b = r101;
    }
}
