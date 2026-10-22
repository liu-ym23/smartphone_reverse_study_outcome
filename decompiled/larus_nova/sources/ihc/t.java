package ihc;

import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public final class t extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f489959b;

    public final int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f489959b)});
    }

    @Override // ihc.c
    public final String toString() {
        return this.f489932a + ":{pageCount = " + this.f489959b + '}';
    }

    public t(int r100) {
        super("SpecificPageCountMonitorMode");
        if (r100 > 0) goto L5;
        Logger.f454747c.e();
        r100 = 1;
    L5:
        this.f489959b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof t) == true) goto L5;
    L7:
        return false;
    L5:
        if (((t) r100).f489959b != this.f489959b) goto L7;
        return true;
    }
}
