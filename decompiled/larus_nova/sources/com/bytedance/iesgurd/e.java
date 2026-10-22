package com.bytedance.iesgurd;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f250680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IESGurdResFrom f250681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f250682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f250683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputStream f250684e;

    public e() {
        this(null, null, 0, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f250680a, r101.f250680a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250681b, r101.f250681b) == true) goto L10;
        return false;
    L10:
        if (this.f250682c == r101.f250682c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f250683d, r101.f250683d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f250684e, r101.f250684e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f250680a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IESGurdResFrom r104 = this.f250681b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f250682c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f250683d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        InputStream r112 = this.f250684e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdResData(error=" + this.f250680a + ", resFrom=" + this.f250681b + ", id=" + this.f250682c + ", path=" + this.f250683d + ", data=" + this.f250684e + ")";
    }

    public /* synthetic */ e(f r110, IESGurdResFrom r111, long r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        f r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r111 = IESGurdResFrom.NONE;
    L9:
        IESGurdResFrom r101 = r111;
        if ((r114 & 4) == 0) goto L12;
        r112 = 0;
    L12:
        long r102 = r112;
        if ((r114 & 8) == 0) goto L15;
        String r103 = null;
    L16:
        this(r100, r101, r102, r103, null);
        return;
    L15:
        r103 = r113;
        goto L16
    L5:
        r100 = r110;
        goto L7
    }

    public e(f r100, IESGurdResFrom r101, long r102, String r103, InputStream r104) {
        this.f250680a = r100;
        this.f250681b = r101;
        this.f250682c = r102;
        this.f250683d = r103;
        this.f250684e = r104;
    }
}
