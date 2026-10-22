package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f412497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f412498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f412499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f412500d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f412497a, r101.f412497a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f412498b, r101.f412498b) == true) goto L15;
        return false;
    L15:
        if (this.f412499c == r101.f412499c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f412500d, r101.f412500d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f412497a.hashCode() * 31) + this.f412498b.hashCode()) * 31;
        if (this.f412499c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        b r103 = this.f412500d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallbackScope(page=" + this.f412497a + ", messageId=" + this.f412498b + ", translated=" + this.f412499c + ", selectionOwner=" + this.f412500d + ')';
    }

    public a(b r100, String r101, boolean r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        this.f412497a = r100;
        this.f412498b = r101;
        this.f412499c = r102;
        this.f412500d = r103;
    }
}
