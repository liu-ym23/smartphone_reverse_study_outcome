package fh8;

import io.noties.markwon.core.spans.CustomLinkSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomLinkSpan f477124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw8.k f477125b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f477124a, r101.f477124a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477125b, r101.f477125b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f477124a.hashCode() * 31) + this.f477125b.hashCode();
    }

    public final String toString() {
        return "MarkdownLinkSpanRecord(span=" + this.f477124a + ", linkInfo=" + this.f477125b + ')';
    }

    public k(CustomLinkSpan r100, lw8.k r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "linkInfo");
        this.f477124a = r100;
        this.f477125b = r101;
    }
}
