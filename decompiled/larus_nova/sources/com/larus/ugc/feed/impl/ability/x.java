package com.larus.ugc.feed.impl.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationFeedAbilityImpl f374604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0a.i f374605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0a.g f374606c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f374604a, r101.f374604a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f374605b, r101.f374605b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f374606c, r101.f374606c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f374604a.hashCode() * 31) + this.f374605b.hashCode()) * 31) + this.f374606c.hashCode();
    }

    public final String toString() {
        return "CreationFeedAndroidAbilityBinding(ability=" + this.f374604a + ", initParams=" + this.f374605b + ", initDependency=" + this.f374606c + ')';
    }

    public x(CreationFeedAbilityImpl r100, m0a.i r101, m0a.g r102) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "initParams");
        Intrinsics.checkNotNullParameter(r102, "initDependency");
        this.f374604a = r100;
        this.f374605b = r101;
        this.f374606c = r102;
    }
}
