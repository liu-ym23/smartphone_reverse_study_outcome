package com.ss.android.lark.chat.cot.detail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f415015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f415016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.c f415017c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f415015a, r101.f415015a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415016b, r101.f415016b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f415017c, r101.f415017c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f415015a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f415016b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        com.ss.android.lark.chat.cot.c r107 = this.f415017c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CotToolCallResultAreaListItem(text=" + this.f415015a + ", link=" + this.f415016b + ", iconSpec=" + this.f415017c + ')';
    }

    public w(String r100, String r101, com.ss.android.lark.chat.cot.c r102) {
        this.f415015a = r100;
        this.f415016b = r101;
        this.f415017c = r102;
    }
}
