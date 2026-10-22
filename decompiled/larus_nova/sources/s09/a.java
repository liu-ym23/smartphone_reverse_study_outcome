package s09;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f540030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f540031b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f540030a, r101.f540030a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f540031b, r101.f540031b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f540030a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f540031b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PollingConfig(value=" + this.f540030a + ", serverTimeStamp=" + this.f540031b + ')';
    }

    public a(Map<String, String> r100, Long r101) {
        this.f540030a = r100;
        this.f540031b = r101;
    }
}
