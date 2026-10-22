package com.ss.android.lark.chat.entity.chat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f415174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f415175b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f415174a, r101.f415174a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415175b, r101.f415175b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f415174a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f415175b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatChatterKickInfo(chatId=" + this.f415174a + ", reason=" + this.f415175b + ')';
    }

    public b(String r100, String r101) {
        this.f415174a = r100;
        this.f415175b = r101;
    }
}
