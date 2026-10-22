package zp0;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShelfCardInfo f573180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573181b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f573180a, r101.f573180a) == true) goto L8;
        return false;
    L8:
        if (this.f573181b == r101.f573181b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ShelfCardInfo r100 = this.f573180a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f573181b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "EditSellingPointEvent(shelfCardInfo=" + this.f573180a + ", position=" + this.f573181b + ")";
    }

    public c(ShelfCardInfo r100, int r101) {
        this.f573180a = r100;
        this.f573181b = r101;
    }
}
