package lf9;

import com.larus.im.internal.trace.model.FlowAVConnectionPeriod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f509092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f509094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f509095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowAVConnectionPeriod f509096e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f509092a == r101.f509092a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509093b, r101.f509093b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f509094c, r101.f509094c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f509095d, r101.f509095d) == true) goto L21;
        return false;
    L21:
        if (this.f509096e == r101.f509096e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f509092a * 31;
        String r101 = this.f509093b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f509094c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f509095d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.f509096e.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAVConnectionError(errorCode=" + this.f509092a + ", errorMessage=" + this.f509093b + ", subErrorCode=" + this.f509094c + ", subErrorMessage=" + this.f509095d + ", period=" + this.f509096e + ')';
    }

    public a(int r100, String r101, Integer r102, String r103, FlowAVConnectionPeriod r104) {
        Intrinsics.checkNotNullParameter(r104, "period");
        this.f509092a = r100;
        this.f509093b = r101;
        this.f509094c = r102;
        this.f509095d = r103;
        this.f509096e = r104;
    }
}
