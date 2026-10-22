package dt;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements com.bytedance.ies.sve_core.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f469994a;

    public i() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f469994a, ((i) r100).f469994a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f469994a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StructureState(structure=" + this.f469994a + ")";
    }

    public i(JSONObject r100) {
        this.f469994a = r100;
    }
}
