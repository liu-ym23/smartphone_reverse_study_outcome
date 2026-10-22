package k0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserCreation f501278a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f501278a, ((d) r100).f501278a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f501278a.hashCode();
    }

    public final String toString() {
        return "Success(creation=" + this.f501278a + ')';
    }

    public d(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "creation");
        this.f501278a = r100;
    }
}
