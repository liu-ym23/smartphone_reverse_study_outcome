package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.bean.OSkill;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<OSkill> f392770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f392771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f392772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f392773d;

    public s0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f392770a, r101.f392770a) == true) goto L12;
        return false;
    L12:
        if (this.f392771b == r101.f392771b) goto L15;
        return false;
    L15:
        if (this.f392772c == r101.f392772c) goto L18;
        return false;
    L18:
        if (this.f392773d == r101.f392773d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f392770a.hashCode() * 31;
        int r101 = 1231;
        if (this.f392771b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f392772c == true) goto L10;
        r101 = 1237;
    L10:
        long r104 = this.f392773d;
        return ((r103 + r101) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SkillCacheSnapshot(skills=" + this.f392770a + ", hasLoaded=" + this.f392771b + ", lastLoadSucceeded=" + this.f392772c + ", version=" + this.f392773d + ')';
    }

    public /* synthetic */ s0(int r100) {
        this(CollectionsKt.emptyList(), false, false, 0);
    }

    public s0(List<OSkill> r100, boolean r101, boolean r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "skills");
        this.f392770a = r100;
        this.f392771b = r101;
        this.f392772c = r102;
        this.f392773d = r103;
    }
}
