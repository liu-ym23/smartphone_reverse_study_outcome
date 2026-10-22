package u22;

import com.bytedance.android.livesdk.message.model.ac;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ac f548429a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f548429a, ((l) r100).f548429a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ac r100 = this.f548429a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TopAggregateMsgClickSpanEvent(msg=" + this.f548429a + ")";
    }

    public l(ac r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f548429a = r100;
    }
}
