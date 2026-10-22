package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f298920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f298921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f298922c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f298920a, r101.f298920a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f298921b, r101.f298921b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f298922c, r101.f298922c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f298920a.hashCode() * 31) + this.f298921b.hashCode()) * 31) + this.f298922c.hashCode();
    }

    public final String toString() {
        return "MentionPanelTrace(mentionType=" + this.f298920a + ", itemType=" + this.f298921b + ", itemName=" + this.f298922c + ')';
    }

    public h0(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mentionType");
        Intrinsics.checkNotNullParameter(r101, "itemType");
        Intrinsics.checkNotNullParameter(r102, "itemName");
        this.f298920a = r100;
        this.f298921b = r101;
        this.f298922c = r102;
    }
}
