package d63;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f467159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f467160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f467161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f467163e;

    public o() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L16;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f467159a, r101.f467159a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f467160b, r101.f467160b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f467161c, r101.f467161c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467162d, r101.f467162d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f467163e, r101.f467163e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f467159a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f467160b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f467161c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f467162d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f467163e;
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
        return "LogisticItemVO(itemType=" + this.f467159a + ", pic=" + this.f467160b + ", text=" + this.f467161c + ", fontColor=" + this.f467162d + ", fontType=" + this.f467163e + ")";
    }

    public o(Integer r100, ECUrlModel r101, String r102, String r103, Integer r104) {
        this.f467159a = r100;
        this.f467160b = r101;
        this.f467161c = r102;
        this.f467162d = r103;
        this.f467163e = r104;
    }
}
