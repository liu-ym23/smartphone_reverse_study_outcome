package hz5;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f487684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f487685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f487686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<e> f487687d;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f487684a, r101.f487684a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f487685b, r101.f487685b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f487686c, r101.f487686c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487687d, r101.f487687d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f487684a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f487685b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<String> r107 = this.f487686c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Set<e> r110 = this.f487687d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EngineLog(inputFactors=" + this.f487684a + ", usedBaseFactors=" + this.f487685b + ", hitStrategies=" + this.f487686c + ", hitRules=" + this.f487687d + ")";
    }

    public d(Object r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        LinkedHashSet r103 = new LinkedHashSet();
        LinkedHashSet r104 = new LinkedHashSet();
        this.f487684a = r101;
        this.f487685b = r102;
        this.f487686c = r103;
        this.f487687d = r104;
    }
}
