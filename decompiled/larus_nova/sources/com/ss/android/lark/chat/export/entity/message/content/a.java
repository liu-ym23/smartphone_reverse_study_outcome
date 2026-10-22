package com.ss.android.lark.chat.export.entity.message.content;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f415401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f415402d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f415401c, r101.f415401c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f415402d, r101.f415402d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f415401c.hashCode() * 31) + this.f415402d.hashCode();
    }

    public final String toString() {
        return "ActionUrl(localUrl=" + this.f415401c + ", commonUrl=" + this.f415402d + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localUrl");
        Intrinsics.checkNotNullParameter(r101, "commonUrl");
        super(0, true);
        this.f415401c = r100;
        this.f415402d = r101;
    }
}
