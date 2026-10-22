package com.larus.bmhome.chat.list.cell.prompt;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f305650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f305651b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.f305650a, r101.f305650a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f305651b, r101.f305651b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f305650a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f305651b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PromptSelectedSkillTrace(skillId=" + this.f305650a + ", skillName=" + this.f305651b + ')';
    }

    public j1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "skillName");
        this.f305650a = r100;
        this.f305651b = r101;
    }
}
