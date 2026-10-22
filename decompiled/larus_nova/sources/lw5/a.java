package lw5;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Double> f511019a;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f511019a, ((a) r100).f511019a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f511019a.hashCode();
    }

    public final String toString() {
        return "FlowVoiceInputMeters(meters=" + this.f511019a + ')';
    }

    public a(List<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "meters");
        this.f511019a = r100;
    }

    public /* synthetic */ a(int r100) {
        this(CollectionsKt.emptyList());
    }
}
