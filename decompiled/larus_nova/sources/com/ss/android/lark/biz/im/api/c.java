package com.ss.android.lark.biz.im.api;

import com.bytedance.lark.pb.feed.v1.AppFeedCard;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppFeedCardType f410059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteString f410061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppFeedCard.ExtraData.BizFields f410062d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f410059a == r101.f410059a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410060b, r101.f410060b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410061c, r101.f410061c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410062d, r101.f410062d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f410059a.hashCode() * 31) + this.f410060b.hashCode()) * 31) + this.f410061c.hashCode()) * 31;
        AppFeedCard.ExtraData.BizFields r101 = this.f410062d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppFeedData(bizType=" + this.f410059a + ", bizId=" + this.f410060b + ", bizExtra=" + this.f410061c + ", bizFields=" + this.f410062d + ')';
    }

    public c() {
        this(AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE, "", ByteString.EMPTY, null);
    }

    public c(AppFeedCardType r100, String r101, ByteString r102, AppFeedCard.ExtraData.BizFields r103) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "bizId");
        Intrinsics.checkNotNullParameter(r102, "bizExtra");
        this.f410059a = r100;
        this.f410060b = r101;
        this.f410061c = r102;
        this.f410062d = r103;
    }
}
