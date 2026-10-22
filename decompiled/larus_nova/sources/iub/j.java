package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495845a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f495845a, ((j) r100).f495845a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f495845a.hashCode();
    }

    public final String toString() {
        return "MmRecordingCallbackResult(recordingId=" + this.f495845a + ')';
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        this.f495845a = r100;
    }
}
