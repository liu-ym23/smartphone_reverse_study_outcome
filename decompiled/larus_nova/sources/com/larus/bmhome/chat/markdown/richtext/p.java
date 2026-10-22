package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f307229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f307230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f307231c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f307229a, r101.f307229a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f307230b, r101.f307230b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f307231c, r101.f307231c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f307229a.hashCode() * 31) + this.f307230b.hashCode()) * 31) + this.f307231c.hashCode();
    }

    public final String toString() {
        return "MessageMentionAvatar(type=" + this.f307229a + ", key=" + this.f307230b + ", entityId=" + this.f307231c + ')';
    }

    public final String getType() {
        return this.f307229a;
    }

    public p(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "entityId");
        this.f307229a = r100;
        this.f307230b = r101;
        this.f307231c = r102;
    }
}
