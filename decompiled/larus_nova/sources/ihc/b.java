package ihc;

import com.ss.android.ugc.route_monitor.utils.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f489931b;

    public final int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f489931b)});
    }

    @Override // ihc.c
    public final String toString() {
        return this.f489932a + ":{minPageCount = " + this.f489931b + '}';
    }

    public b(int r100) {
        super("AtLeastPageCountMonitorMode");
        if (r100 > 0) goto L5;
        Logger.f454747c.e();
        r100 = 1;
    L5:
        this.f489931b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) r100).f489931b != this.f489931b) goto L7;
        return true;
    }
}
