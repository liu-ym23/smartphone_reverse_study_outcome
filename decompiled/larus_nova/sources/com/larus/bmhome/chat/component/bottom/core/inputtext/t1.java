package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.platform.model.SlashMentionConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final be8.b f299232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<n1> f299233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<n1> f299234c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t1) == true) goto L8;
        return false;
    L8:
        t1 r101 = (t1) r100;
        if (Intrinsics.areEqual(this.f299232a, r101.f299232a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299233b, r101.f299233b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299234c, r101.f299234c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f299232a.hashCode() * 31) + this.f299233b.hashCode()) * 31) + this.f299234c.hashCode();
    }

    public final String toString() {
        return "SkillSearchMatch(skill=" + this.f299232a + ", titleRanges=" + this.f299233b + ", descriptionRanges=" + this.f299234c + ')';
    }

    public t1(be8.b r100, List<n1> r101, List<n1> r102) {
        Intrinsics.checkNotNullParameter(r100, SlashMentionConfig.SLASH_CONTENT_SKILL);
        Intrinsics.checkNotNullParameter(r101, "titleRanges");
        Intrinsics.checkNotNullParameter(r102, "descriptionRanges");
        this.f299232a = r100;
        this.f299233b = r101;
        this.f299234c = r102;
    }
}
