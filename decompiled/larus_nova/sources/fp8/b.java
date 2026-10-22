package fp8;

import kotlin.jvm.internal.Intrinsics;
import m1a.d;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f478296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478298c;

    public b() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f478296a == r101.f478296a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478297b, r101.f478297b) == true) goto L15;
        return false;
    L15:
        if (this.f478298c == r101.f478298c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f478296a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f478297b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((r101 + r103) * 31) + this.f478298c;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatParamCoreData(useSubscribedColor=" + this.f478296a + ", actionBarScene=" + this.f478297b + ", bottomTabHeight=" + this.f478298c + ')';
    }

    public /* synthetic */ b(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100, null, 0);
    }

    public b(boolean r100, String r101, int r102) {
        this.f478296a = r100;
        this.f478297b = r101;
        this.f478298c = r102;
    }

    public static b a(b r100, String r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        boolean r104 = r100.f478296a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f478297b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f478298c;
    L12:
        r100.getClass();
        return new b(r104, r101, r102);
    L5:
        r104 = false;
        goto L7
    }
}
