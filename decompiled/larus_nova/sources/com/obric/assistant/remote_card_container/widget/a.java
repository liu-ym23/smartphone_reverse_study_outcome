package com.obric.assistant.remote_card_container.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f391306d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f391303a, r101.f391303a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391304b, r101.f391304b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391305c, r101.f391305c) == true) goto L18;
        return false;
    L18:
        if (this.f391306d == r101.f391306d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f391303a.hashCode() * 31) + this.f391304b.hashCode()) * 31;
        String r101 = this.f391305c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f391306d;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MsgCardData(cardUri=" + this.f391303a + ", localMessageId=" + this.f391304b + ')';
    }

    public a(String r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "cardUri");
        Intrinsics.checkNotNullParameter(r101, "localMessageId");
        this.f391303a = r100;
        this.f391304b = r101;
        this.f391305c = r102;
        this.f391306d = r103;
    }
}
