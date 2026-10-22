package com.larus.ugc.feed.impl.detail.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationDetailBottomToolsAbilityImpl f374757a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f374757a, ((d) r100).f374757a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f374757a.hashCode();
    }

    public final String toString() {
        return "CreationDetailBottomToolsAndroidAbilityBinding(ability=" + this.f374757a + ')';
    }

    public d(CreationDetailBottomToolsAbilityImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f374757a = r100;
    }
}
