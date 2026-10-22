package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f320613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f320615c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f320613a, r101.f320613a) == true) goto L12;
        return false;
    L12:
        if (this.f320614b == r101.f320614b) goto L15;
        return false;
    L15:
        if (this.f320615c == r101.f320615c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f320613a.hashCode() * 31) + this.f320614b) * 31) + this.f320615c;
    }

    public final String toString() {
        return "CodeBlockLineNumberInfo(startToLineNumber=" + this.f320613a + ", maxLine=" + this.f320614b + ", lineNumberColor=" + this.f320615c + ')';
    }

    public a(Map<Integer, Integer> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "startToLineNumber");
        this.f320613a = r100;
        this.f320614b = r101;
        this.f320615c = r102;
    }
}
