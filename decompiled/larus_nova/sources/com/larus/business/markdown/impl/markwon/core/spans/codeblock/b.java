package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f320616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ctc.a f320617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ctc.e f320618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f320619d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f320616a == r101.f320616a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f320617b, r101.f320617b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f320618c, r101.f320618c) == true) goto L18;
        return false;
    L18:
        if (this.f320619d == r101.f320619d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f320616a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        ctc.a r103 = this.f320617b;
        if (r103 != null) goto L8;
        int r104 = 0;
    L10:
        return ((((r102 + r104) * 31) + this.f320618c.hashCode()) * 31) + this.f320619d;
    L8:
        r104 = r103.hashCode();
        goto L10
    }

    public final String toString() {
        return "CodeBlockScrollableInfo(enableScroll=" + this.f320616a + ", scrollable=" + this.f320617b + ", scrollBarTheme=" + this.f320618c + ", codeTextColor=" + this.f320619d + ')';
    }

    public b(boolean r100, ctc.a r101, ctc.e r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "scrollBarTheme");
        this.f320616a = r100;
        this.f320617b = r101;
        this.f320618c = r102;
        this.f320619d = r103;
    }
}
