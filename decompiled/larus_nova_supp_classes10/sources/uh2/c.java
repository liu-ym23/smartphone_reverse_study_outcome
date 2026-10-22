package uh2;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroUpdateType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final List<a> a;
    public final IntroUpdateType b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<a> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IntroUpdateType r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroData(introVO=" + this.a + ", type=" + this.b + ")";
    }

    public final IntroUpdateType getType() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends a> r2, IntroUpdateType r3) {
        Intrinsics.checkNotNullParameter(r2, "introVO");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TYPE);
        this.a = r2;
        this.b = r3;
    }
}
