package fy8;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f479316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pair<Integer, Integer> f479319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f479320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f479321f;

    public k() {
        this(true, null, null, null, null, MapsKt.emptyMap());
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f479316a == r101.f479316a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479317b, r101.f479317b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479318c, r101.f479318c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479319d, r101.f479319d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479320e, r101.f479320e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f479321f, r101.f479321f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f479316a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f479317b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f479318c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Pair<Integer, Integer> r109 = this.f479319d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Function0<Boolean> r112 = this.f479320e;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return ((r111 + r103) * 31) + this.f479321f.hashCode();
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputInitConfig(isNoImeWhenInit=" + this.f479316a + ", customPrompt=" + this.f479317b + ", hint=" + this.f479318c + ", selection=" + this.f479319d + ", onVoiceTouchBlockCallback=" + this.f479320e + ", traceMap=" + this.f479321f + ')';
    }

    public k(boolean r100, String r101, String r102, Pair<Integer, Integer> r103, Function0<Boolean> r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r105, "traceMap");
        this.f479316a = r100;
        this.f479317b = r101;
        this.f479318c = r102;
        this.f479319d = r103;
        this.f479320e = r104;
        this.f479321f = r105;
    }
}
