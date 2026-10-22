package com.larus.bmhome.taskskill;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f314269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f314270c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r101 = (c2) r100;
        if (Intrinsics.areEqual(this.f314268a, r101.f314268a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314269b, r101.f314269b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314270c, r101.f314270c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f314268a.hashCode() * 31) + this.f314269b.hashCode()) * 31;
        Integer r101 = this.f314270c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SkillMessagePayload(queryPrefix=" + this.f314268a + ", selectedSkillIds=" + this.f314269b + ", runtimeType=" + this.f314270c + ')';
    }

    public c2() {
        this("", CollectionsKt.emptyList(), null);
    }

    public c2(String r100, List<String> r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "queryPrefix");
        Intrinsics.checkNotNullParameter(r101, "selectedSkillIds");
        this.f314268a = r100;
        this.f314269b = r101;
        this.f314270c = r102;
    }
}
