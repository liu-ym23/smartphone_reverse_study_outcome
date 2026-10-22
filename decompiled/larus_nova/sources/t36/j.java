package t36;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f544443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f544444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f544445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f544446d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f544443a, ((j) r100).f544443a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f544443a.hashCode();
    }

    public final String toString() {
        return "SchemaModelUnion(schemaData=" + this.f544443a + ')';
    }

    public j(d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        this.f544443a = r100;
    }
}
