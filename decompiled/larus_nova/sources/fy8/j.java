package fy8;

import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f479309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pair<Integer, Integer> f479312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f479313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f479314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f479315g;

    public j() {
        this(null, null, 0, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f479309a == r101.f479309a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479310b, r101.f479310b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479311c, r101.f479311c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479312d, r101.f479312d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f479313e, r101.f479313e) == true) goto L24;
        return false;
    L24:
        if (this.f479314f == r101.f479314f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f479315g, r101.f479315g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.f479309a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f479310b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f479311c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Pair<Integer, Integer> r109 = this.f479312d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Function0<Boolean> r112 = this.f479313e;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return ((((r111 + r103) * 31) + this.f479314f) * 31) + this.f479315g.hashCode();
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
        return "EditorInitConfig(isNoImeWhenInit=" + this.f479309a + ", customPrompt=" + this.f479310b + ", hint=" + this.f479311c + ", selection=" + this.f479312d + ", onVoiceTouchBlockCallback=" + this.f479313e + ", canvasType=" + this.f479314f + ", traceMap=" + this.f479315g + ')';
    }

    public j(String r100, String r101, int r102, Map r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        boolean r105 = true;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r104 & 32) == 0) goto L16;
        r102 = -1;
    L16:
        if ((r104 & 64) == 0) goto L18;
        r103 = MapsKt.emptyMap();
    L18:
        Intrinsics.checkNotNullParameter(r103, "traceMap");
        this.f479309a = r105;
        this.f479310b = r100;
        this.f479311c = r101;
        this.f479312d = null;
        this.f479313e = null;
        this.f479314f = r102;
        this.f479315g = r103;
        return;
    L5:
        r105 = false;
        goto L7
    }
}
