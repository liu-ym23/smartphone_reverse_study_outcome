package com.ss.android.lark.im.sdk.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f426091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f426092c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f426090a, r101.f426090a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426091b, r101.f426091b) == true) goto L15;
        return false;
    L15:
        if (this.f426092c == r101.f426092c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f426090a.hashCode() * 31;
        String r101 = this.f426091b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f426092c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GetUnreadAtMeParam(chatId=" + this.f426090a + ", threadId=" + this.f426091b + ", atAll=" + this.f426092c + ')';
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f426090a = r100;
        this.f426091b = null;
        this.f426092c = false;
    }
}
