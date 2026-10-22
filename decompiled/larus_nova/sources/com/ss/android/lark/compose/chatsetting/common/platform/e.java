package com.ss.android.lark.compose.chatsetting.common.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f417384d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f417381a, r101.f417381a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417382b, r101.f417382b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417383c, r101.f417383c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f417384d, r101.f417384d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f417381a.hashCode() * 31) + this.f417382b.hashCode()) * 31) + this.f417383c.hashCode()) * 31) + this.f417384d.hashCode();
    }

    public final String toString() {
        return "GroupQrCodeRouteParams(chatId=" + this.f417381a + ", avatarKey=" + this.f417382b + ", chatName=" + this.f417383c + ", ownerId=" + this.f417384d + ')';
    }

    public e(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        Intrinsics.checkNotNullParameter(r102, "chatName");
        Intrinsics.checkNotNullParameter(r103, "ownerId");
        this.f417381a = r100;
        this.f417382b = r101;
        this.f417383c = r102;
        this.f417384d = r103;
    }
}
