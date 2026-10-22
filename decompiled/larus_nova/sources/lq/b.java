package lq;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f510283b;

    public final String toString() {
        return "SlcUIAction(type=" + getType() + ", fields=" + this.f510283b + ")";
    }

    public final int hashCode() {
        String r100 = getType();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f510283b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // lq.a
    public String getType() {
        return this.f510282a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(getType(), r101.getType()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f510283b, r101.f510283b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public b(String r100, Map<String, ? extends Object> r101) {
        this.f510282a = r100;
        this.f510283b = r101;
    }
}
