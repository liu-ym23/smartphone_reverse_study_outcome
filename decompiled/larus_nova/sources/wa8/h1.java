package wa8;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CreationReferenceMediaType> f558872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f558873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f558875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f558876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558877f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.f558872a, r101.f558872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558873b, r101.f558873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558874c, r101.f558874c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558875d, r101.f558875d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558876e, r101.f558876e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558877f, r101.f558877f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558872a.hashCode() * 31;
        Integer r101 = this.f558873b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f558874c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Double r108 = this.f558875d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f558876e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f558877f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationReferenceMixedRule(subTypes=" + this.f558872a + ", maxCount=" + this.f558873b + ", maxCountDisplayText=" + this.f558874c + ", maxTotalDuration=" + this.f558875d + ", maxTotalShowDuration=" + this.f558876e + ", maxTotalDurationDisplayText=" + this.f558877f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h1(List<? extends CreationReferenceMediaType> r100, Integer r101, String r102, Double r103, Integer r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "subTypes");
        this.f558872a = r100;
        this.f558873b = r101;
        this.f558874c = r102;
        this.f558875d = r103;
        this.f558876e = r104;
        this.f558877f = r105;
    }
}
