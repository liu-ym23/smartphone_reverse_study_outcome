package gw5;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f483029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f483030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f483031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f483032d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f483029a, r101.f483029a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483030b, r101.f483030b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483031c, r101.f483031c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f483032d, r101.f483032d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f483029a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f483030b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f483031c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Boolean> r110 = this.f483032d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAsrCompressConfig(enableCompress=" + this.f483029a + ", compressBitRate=" + this.f483030b + ", enablePoorNetwork=" + this.f483031c + ", isWeakNetwork=" + this.f483032d + ')';
    }

    public /* synthetic */ a(int r100) {
        Boolean r101 = Boolean.FALSE;
        this(r101, Float.valueOf(1.0f), r101, null);
    }

    public a(Boolean r100, Float r101, Boolean r102, Function0<Boolean> r103) {
        this.f483029a = r100;
        this.f483030b = r101;
        this.f483031c = r102;
        this.f483032d = r103;
    }
}
