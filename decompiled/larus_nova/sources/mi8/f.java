package mi8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514119a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f514119a, ((f) r100).f514119a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f514119a.hashCode();
    }

    public final String toString() {
        return "MoaGrantingMessageContext(messageID=" + this.f514119a + ')';
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276353c);
        this.f514119a = r100;
    }
}
