package h31;

import com.bytedance.android.livesdk.link.model.aa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa f483710a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f483710a, ((i) r100).f483710a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        aa r100 = this.f483710a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "VoteOpenData(voteSetting=" + this.f483710a + ")";
    }

    public i(aa r100) {
        Intrinsics.checkNotNullParameter(r100, "voteSetting");
        this.f483710a = r100;
    }
}
