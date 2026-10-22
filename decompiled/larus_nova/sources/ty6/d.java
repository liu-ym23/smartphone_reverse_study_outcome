package ty6;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f547988b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f547987a, r101.f547987a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547988b, r101.f547988b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f547987a.hashCode() * 31) + this.f547988b.hashCode();
    }

    public final String toString() {
        return "PoiPopupSendEvent(sendEventName=" + this.f547987a + ", params=" + this.f547988b + ')';
    }

    public d(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "sendEventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f547987a = r100;
        this.f547988b = r101;
    }
}
