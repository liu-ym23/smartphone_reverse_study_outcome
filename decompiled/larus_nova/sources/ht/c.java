package ht;

import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f487101c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f487102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f487103b;

    public static final class a {
    }

    static {
    }

    public c() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f487102a, r101.f487102a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f487103b, r101.f487103b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f487102a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f487103b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ColListPageState(resultSuccess=" + this.f487102a + ", nextPageData=" + this.f487103b + ")";
    }

    public /* synthetic */ c(Boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public c(Boolean r100, JSONObject r101) {
        this.f487102a = r100;
        this.f487103b = r101;
    }
}
