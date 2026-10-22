package ty6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547985b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f547984a, r101.f547984a) == true) goto L12;
        return false;
    L12:
        if (this.f547985b == r101.f547985b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f547984a.hashCode() * 31;
        if (this.f547985b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PoiPopupReceiveEvent(receiveEventName=" + this.f547984a + ", hasPopup=" + this.f547985b + ')';
    }

    public b() {
        Intrinsics.checkNotNullParameter("poi_moreview_collect_popup_receive", "receiveEventName");
        this.f547984a = "poi_moreview_collect_popup_receive";
        this.f547985b = false;
    }
}
