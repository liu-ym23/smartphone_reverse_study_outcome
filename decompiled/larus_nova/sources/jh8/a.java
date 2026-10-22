package jh8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f499099a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f499099a, ((a) r100).f499099a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Function1<String, Unit> r100 = this.f499099a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "MarkdownAppletConfig(markForceUpdateForMarkdown=" + this.f499099a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super String, Unit> r100) {
        this.f499099a = r100;
    }
}
