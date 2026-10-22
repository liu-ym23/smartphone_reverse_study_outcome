package h31;

import com.bytedance.android.livesdk.link.model.d4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d4 f483679a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f483679a, ((c) r100).f483679a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        d4 r100 = this.f483679a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CustomPKData(customConfig=" + this.f483679a + ")";
    }

    public c(d4 r100) {
        Intrinsics.checkNotNullParameter(r100, "customConfig");
        this.f483679a = r100;
    }
}
