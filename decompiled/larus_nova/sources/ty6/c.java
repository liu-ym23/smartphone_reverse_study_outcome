package ty6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547986a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f547986a, ((c) r100).f547986a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f547986a.hashCode();
    }

    public final String toString() {
        return "PoiPopupRegisterEvent(configName=" + this.f547986a + ')';
    }

    public c() {
        Intrinsics.checkNotNullParameter("poi_moreview_collect_popup", "configName");
        this.f547986a = "poi_moreview_collect_popup";
    }
}
