package com.larus.im.internal.tracking.network;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkTrackTransport f350440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f350441c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f350439a, r101.f350439a) == true) goto L12;
        return false;
    L12:
        if (this.f350440b == r101.f350440b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350441c, r101.f350441c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f350439a.hashCode() * 31) + this.f350440b.hashCode()) * 31;
        Long r101 = this.f350441c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "NetworkTrackRequest(url=" + this.f350439a + ", transport=" + this.f350440b + ", netConnected=" + this.f350441c + ')';
    }

    public w(String r100, NetworkTrackTransport r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_TRANSPORT);
        this.f350439a = r100;
        this.f350440b = r101;
        this.f350441c = null;
    }
}
