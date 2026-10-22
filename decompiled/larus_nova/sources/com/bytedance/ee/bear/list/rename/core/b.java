package com.bytedance.ee.bear.list.rename.core;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f229352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f229353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oj5.c f229354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f229355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f229356e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f229352a, r101.f229352a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f229353b, r101.f229353b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f229354c, r101.f229354c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f229355d, r101.f229355d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f229356e, r101.f229356e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f229352a.hashCode() * 31) + this.f229353b.hashCode()) * 31) + this.f229354c.hashCode()) * 31) + this.f229355d.hashCode()) * 31) + this.f229356e.hashCode();
    }

    public final String toString() {
        return "OfficeRenameCoreRequest(actionId=" + this.f229352a + ", document=" + this.f229353b + ", moreInfo=" + this.f229354c + ", newName=" + this.f229355d + ", failedTips=" + this.f229356e + ')';
    }

    public b(String r100, Document r101, oj5.c r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        Intrinsics.checkNotNullParameter(r101, "document");
        Intrinsics.checkNotNullParameter(r102, "moreInfo");
        Intrinsics.checkNotNullParameter(r103, "newName");
        Intrinsics.checkNotNullParameter(r104, "failedTips");
        this.f229352a = r100;
        this.f229353b = r101;
        this.f229354c = r102;
        this.f229355d = r103;
        this.f229356e = r104;
    }
}
