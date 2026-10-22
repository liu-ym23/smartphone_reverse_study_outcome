package com.ss.android.ainote;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f406694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f406695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f406696c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f406694a, r101.f406694a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f406695b, r101.f406695b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f406696c, r101.f406696c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f406694a.hashCode() * 31) + this.f406695b.hashCode()) * 31) + this.f406696c.hashCode();
    }

    public final String toString() {
        return "AINoteBizIds(bizId=" + this.f406694a + ", meetingId=" + this.f406695b + ", uniqueId=" + this.f406696c + ')';
    }

    public d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        Intrinsics.checkNotNullParameter(r102, "uniqueId");
        this.f406694a = r100;
        this.f406695b = r101;
        this.f406696c = r102;
        if ((!StringsKt.isBlank(r100)) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("bizId is required".toString());
    }

    public /* synthetic */ d(String r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r102 & 4) != 0) goto L9;
        r103 = null;
    L9:
        this(r100, r101, r103);
    }
}
