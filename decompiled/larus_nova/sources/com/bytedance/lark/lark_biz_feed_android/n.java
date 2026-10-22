package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.lark.pb.feed.v1.FeedEntityPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f253181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedEntityPreview f253182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f253183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f253184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f253185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f253186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f253187g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f253181a == r101.f253181a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253182b, r101.f253182b) == true) goto L15;
        return false;
    L15:
        if (this.f253183c == r101.f253183c) goto L18;
        return false;
    L18:
        if (this.f253184d == r101.f253184d) goto L21;
        return false;
    L21:
        if (this.f253185e == r101.f253185e) goto L24;
        return false;
    L24:
        if (this.f253186f == r101.f253186f) goto L27;
        return false;
    L27:
        if (this.f253187g == r101.f253187g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253181a * 31;
        FeedEntityPreview r101 = this.f253182b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f253183c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f253184d;
        return ((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f253185e) * 31) + this.f253186f) * 31) + this.f253187g;
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkFeedInfo(badgeCount=" + this.f253181a + ", latestPreview=" + this.f253182b + ", rankTimeMs=" + this.f253183c + ", version=" + this.f253184d + ", badgeCountWithoutDoubao=" + this.f253185e + ", messageOnTopBadgeCount=" + this.f253186f + ", messageWithoutDoubaoOnTopBadgeCount=" + this.f253187g + ')';
    }

    public n(int r100, FeedEntityPreview r101, long r102, long r103, int r104, int r105, int r106) {
        this.f253181a = r100;
        this.f253182b = r101;
        this.f253183c = r102;
        this.f253184d = r103;
        this.f253185e = r104;
        this.f253186f = r105;
        this.f253187g = r106;
    }
}
