package com.larus.office.card.urlpreview;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f361971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b1> f361972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<r, s> f361973d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l2) == true) goto L8;
        return false;
    L8:
        l2 r101 = (l2) r100;
        if (Intrinsics.areEqual(this.f361970a, r101.f361970a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361971b, r101.f361971b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361972c, r101.f361972c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f361973d, r101.f361973d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f361970a.hashCode() * 31) + this.f361971b.hashCode()) * 31) + this.f361972c.hashCode()) * 31) + this.f361973d.hashCode();
    }

    public final String toString() {
        return "OfficeUrlPreviewSourceSnapshot(sourceKey=" + this.f361970a + ", messageIdentities=" + this.f361971b + ", messages=" + this.f361972c + ", blocks=" + this.f361973d + ')';
    }

    public l2(String r100, Set<String> r101, Map<String, b1> r102, Map<r, s> r103) {
        Intrinsics.checkNotNullParameter(r100, "sourceKey");
        Intrinsics.checkNotNullParameter(r101, "messageIdentities");
        Intrinsics.checkNotNullParameter(r102, "messages");
        Intrinsics.checkNotNullParameter(r103, "blocks");
        this.f361970a = r100;
        this.f361971b = r101;
        this.f361972c = r102;
        this.f361973d = r103;
    }
}
