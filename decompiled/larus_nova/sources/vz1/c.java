package vz1;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f557646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f557647c;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f557645a, r101.f557645a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f557646b, r101.f557646b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f557647c, r101.f557647c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f557645a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f557646b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f557647c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CounterH5Entrance(schema=" + this.f557645a + ", entranceText=" + this.f557646b + ", entranceIcon=" + this.f557647c + ")";
    }

    public final String a() {
        return this.f557645a;
    }

    public /* synthetic */ c(int r100) {
        this("", null, null);
    }

    public c(String r100, String r101, k r102) {
        this.f557645a = r100;
        this.f557646b = r101;
        this.f557647c = r102;
    }
}
