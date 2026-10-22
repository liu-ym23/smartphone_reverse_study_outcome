package fi3;

import com.google.gson.internal.LinkedTreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j0 {
    public static final /* synthetic */ int d = 0;
    public final LinkedTreeMap<String, Object> a;
    public final String b;
    public final LinkedTreeMap<String, Object> c;

    public static final class a {
    }

    static {
    }

    public j0() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j0) == false) goto L12;
        j0 r4 = (j0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LinkedTreeMap<String, Object> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        LinkedTreeMap<String, Object> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpClickShopEntryParam(businessMeta=" + this.a + ", pendantId=" + this.b + ", trackMeta=" + this.c + ")";
    }

    public j0(LinkedTreeMap<String, Object> r1, String r2, LinkedTreeMap<String, Object> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
