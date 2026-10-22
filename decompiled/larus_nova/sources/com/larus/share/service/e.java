package com.larus.share.service;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareScene f368904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.b f368905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.h f368906c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f368904a == r101.f368904a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f368905b, r101.f368905b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f368906c, r101.f368906c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f368904a.hashCode() * 31) + this.f368905b.hashCode()) * 31) + this.f368906c.hashCode();
    }

    public final String toString() {
        return "SaasSharePanelContext(shareScene=" + this.f368904a + ", shareContent=" + this.f368905b + ", eventParam=" + this.f368906c + ')';
    }

    public e(ShareScene r100, com.larus.bmhome.share.panel.b r101, com.larus.bmhome.share.panel.h r102) {
        Intrinsics.checkNotNullParameter(r100, "shareScene");
        Intrinsics.checkNotNullParameter(r101, "shareContent");
        Intrinsics.checkNotNullParameter(r102, "eventParam");
        this.f368904a = r100;
        this.f368905b = r101;
        this.f368906c = r102;
    }
}
