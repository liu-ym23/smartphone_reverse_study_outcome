package uv6;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f551861b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f551860a, r101.f551860a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f551861b, r101.f551861b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f551860a.hashCode() * 31) + this.f551861b.hashCode();
    }

    public final String toString() {
        return "PoiScrollReceiveEvent(receiveEventName=" + this.f551860a + ", data=" + this.f551861b + ')';
    }

    public a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "receiveEventName");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f551860a = r100;
        this.f551861b = r101;
    }
}
