package oe2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f522954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public py.k f522955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f522956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f522957e;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f522953a, r101.f522953a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f522954b, r101.f522954b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f522955c, r101.f522955c) == true) goto L12;
        return false;
    L12:
        if (this.f522956d == r101.f522956d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f522957e, r101.f522957e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        String r100 = this.f522953a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522954b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        py.k r107 = this.f522955c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f522956d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f522957e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
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
        return "KtvStageUIState(singerName=" + this.f522953a + ", singSongName=" + this.f522954b + ", singerImageModel=" + this.f522955c + ", avatarAnimShow=" + this.f522956d + ", singEndFeedBackVisible=" + this.f522957e + ")";
    }

    public /* synthetic */ f(int r100) {
        this(null, null, null, false, null);
    }

    public f(String r100, String r101, py.k r102, boolean r103, Boolean r104) {
        this.f522953a = r100;
        this.f522954b = r101;
        this.f522955c = r102;
        this.f522956d = r103;
        this.f522957e = r104;
    }

    public static f a(f r100, String r101, String r102, py.k r103, boolean r110, Boolean r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f522953a;
    L5:
        String r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f522954b;
    L8:
        String r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f522955c;
    L11:
        py.k r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f522956d;
    L14:
        boolean r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f522957e;
    L17:
        r100.getClass();
        return new f(r104, r105, r106, r107, r111);
    }
}
