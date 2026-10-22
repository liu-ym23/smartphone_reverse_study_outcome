package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.locallife.live.goodsshelves.bean.x f474453a;

    public y() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f474453a, ((y) r100).f474453a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        com.bytedance.locallife.live.goodsshelves.bean.x r100 = this.f474453a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShelfProductPoiTipUIData(content=" + this.f474453a + ')';
    }

    public y(com.bytedance.locallife.live.goodsshelves.bean.x r100) {
        this.f474453a = r100;
    }
}
