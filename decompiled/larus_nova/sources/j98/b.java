package j98;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f497800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497801b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f497800a, r101.f497800a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f497801b, r101.f497801b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f497800a.hashCode() * 31) + this.f497801b.hashCode();
    }

    public final String toString() {
        return "DiaryFeedbackDraft(selectedReasons=" + this.f497800a + ", inputText=" + this.f497801b + ')';
    }

    public /* synthetic */ b(int r100) {
        this(CollectionsKt.emptyList(), "");
    }

    public b(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "selectedReasons");
        Intrinsics.checkNotNullParameter(r101, "inputText");
        this.f497800a = r100;
        this.f497801b = r101;
    }
}
