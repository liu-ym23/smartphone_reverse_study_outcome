package com.bytedance.lark.lark_biz_feed_android;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeedCardType f253162b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f253161a, r101.f253161a) == true) goto L12;
        return false;
    L12:
        if (this.f253162b == r101.f253162b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253161a.hashCode() * 31;
        FeedCardType r101 = this.f253162b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChannelEntity(channelId=" + this.f253161a + ", feedType=" + this.f253162b + ')';
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        this.f253161a = r100;
        this.f253162b = null;
    }
}
