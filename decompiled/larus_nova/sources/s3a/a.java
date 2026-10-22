package s3a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tf9.b f540504a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f540504a, ((a) r100).f540504a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f540504a.hashCode();
    }

    public final String toString() {
        return "CameraPushFrameFinishEvent(frame=" + this.f540504a + ')';
    }

    public a(tf9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.f540504a = r100;
    }
}
