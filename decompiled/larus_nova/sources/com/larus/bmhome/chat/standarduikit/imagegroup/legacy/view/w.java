package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309280d;

    public w() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f309277a, r101.f309277a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309278b, r101.f309278b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309279c, r101.f309279c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309280d, r101.f309280d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f309277a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f309278b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f309279c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f309280d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageTraceData(messageId=" + this.f309277a + ", localMessageId=" + this.f309278b + ", conversationId=" + this.f309279c + ", chatType=" + this.f309280d + ')';
    }

    public w(String r100, String r101, String r102, String r103) {
        this.f309277a = r100;
        this.f309278b = r101;
        this.f309279c = r102;
        this.f309280d = r103;
    }
}
