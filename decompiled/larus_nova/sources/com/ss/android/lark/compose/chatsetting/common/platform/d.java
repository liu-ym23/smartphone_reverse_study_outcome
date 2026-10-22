package com.ss.android.lark.compose.chatsetting.common.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417380d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f417377a, r101.f417377a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417378b, r101.f417378b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417379c, r101.f417379c) == true) goto L18;
        return false;
    L18:
        if (this.f417380d == r101.f417380d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f417377a.hashCode() * 31) + this.f417378b.hashCode()) * 31) + this.f417379c.hashCode()) * 31;
        if (this.f417380d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "GroupInfoRouteParams(chatId=" + this.f417377a + ", chatName=" + this.f417378b + ", avatarKey=" + this.f417379c + ", canEdit=" + this.f417380d + ')';
    }

    public d(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "chatName");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.f417377a = r100;
        this.f417378b = r101;
        this.f417379c = r102;
        this.f417380d = r103;
    }
}
