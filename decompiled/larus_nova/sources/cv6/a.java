package cv6;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f465497a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f465497a, ((a) r100).f465497a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f465497a.hashCode();
    }

    public final String toString() {
        return "LiveLifeJsBroadCastEvent(params=" + this.f465497a + ')';
    }

    public a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f465497a = r100;
    }
}
