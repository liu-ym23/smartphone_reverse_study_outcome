package sf0;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f541700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Integer> f541701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f541702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f541703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f541704e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f541700a, r101.f541700a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541701b, r101.f541701b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f541702c, r101.f541702c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f541703d, r101.f541703d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f541704e, r101.f541704e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f541700a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.f541701b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.f541702c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f541703d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<d> r113 = this.f541704e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "DynamicFrameInfo(uiLayout=" + this.f541700a + ", uiFeatureList=" + this.f541701b + ", seatFrame=" + this.f541702c + ", seatList=" + this.f541704e + ')';
    }

    public b(Integer r100, List<Integer> r101, c r102, c r103, List<d> r104) {
        Intrinsics.checkNotNullParameter(r101, "uiFeatureList");
        Intrinsics.checkNotNullParameter(r102, "seatFrame");
        Intrinsics.checkNotNullParameter(r104, "seatList");
        this.f541700a = r100;
        this.f541701b = r101;
        this.f541702c = r102;
        this.f541703d = r103;
        this.f541704e = r104;
    }

    public /* synthetic */ b(Integer r100, c r110, c r111, List r112, int r113) {
        List r101 = null;
        if ((r113 & 1) == 0) goto L5;
        Integer r102 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        this(r102, r101, r110, r111, r112);
        return;
    L5:
        r102 = r100;
        goto L7
    }
}
