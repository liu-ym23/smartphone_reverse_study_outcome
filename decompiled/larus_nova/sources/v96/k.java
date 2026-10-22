package v96;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553805b;

    public final String toString() {
        return this.f553804a + ": " + this.f553805b;
    }

    public k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f553804a = r100;
        this.f553805b = r101;
    }
}
