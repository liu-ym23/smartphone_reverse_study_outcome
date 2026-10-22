package ue9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f549867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f549868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f549869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f549870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f549871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f549872f;

    public final String toString() {
        return "FlowLinkStreamFrame(data=" + Arrays.toString(this.f549867a) + ", type=" + this.f549868b + ", extra=" + Arrays.toString(this.f549869c) + ", timestamp=" + this.f549870d + ", isSilent=" + this.f549871e + ", extraStr=" + this.f549872f + ')';
    }

    public final int hashCode() {
        int r100 = ((Arrays.hashCode(this.f549867a) * 31) + this.f549868b.hashCode()) * 31;
        byte[] r101 = this.f549869c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = Arrays.hashCode(r101);
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f549870d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f549871e == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f549872f;
        if (r110 == null) goto L18;
        r102 = r110.hashCode();
    L18:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final g getType() {
        return this.f549868b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Arrays.equals(this.f549867a, r101.f549867a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549868b, r101.f549868b) == true) goto L14;
        return false;
    L14:
        byte[] r102 = this.f549869c;
        if (r102 == null) goto L23;
        byte[] r103 = r101.f549869c;
        if (r103 != null) goto L20;
        return false;
    L20:
        if (Arrays.equals(r102, r103) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f549870d, r101.f549870d) == true) goto L29;
        return false;
    L29:
        if (this.f549871e == r101.f549871e) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f549872f, r101.f549872f) == true) goto L34;
        return false;
    L34:
        return true;
    L23:
        if (r101.f549869c == null) goto L26;
        return false;
    }

    public f(byte[] r100, g r101, byte[] r102, Long r103, boolean r104, String r105, int r106) {
        if ((r106 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r104 = false;
    L9:
        if ((r106 & 32) == 0) goto L11;
        r105 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f549867a = r100;
        this.f549868b = r101;
        this.f549869c = r102;
        this.f549870d = r103;
        this.f549871e = r104;
        this.f549872f = r105;
    }
}
