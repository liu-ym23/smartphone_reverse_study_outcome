package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387260c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f387258a, r101.f387258a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387259b, r101.f387259b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387260c, r101.f387260c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f387258a.hashCode() * 31;
        String r101 = this.f387259b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f387260c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CardTemplateTitle(text=" + this.f387258a + ", subtitle=" + this.f387259b + ", timeLabel=" + this.f387260c + ')';
    }

    public e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r102, "timeLabel");
        this.f387258a = r100;
        this.f387259b = r101;
        this.f387260c = r102;
    }
}
