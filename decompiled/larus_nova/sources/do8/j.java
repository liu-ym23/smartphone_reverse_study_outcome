package do8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f469453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f469455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f469457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Integer> f469458f;

    public j() {
        this(false, false, false, false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f469453a == r101.f469453a) goto L12;
        return false;
    L12:
        if (this.f469454b == r101.f469454b) goto L15;
        return false;
    L15:
        if (this.f469455c == r101.f469455c) goto L18;
        return false;
    L18:
        if (this.f469456d == r101.f469456d) goto L21;
        return false;
    L21:
        if (this.f469457e == r101.f469457e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f469458f, r101.f469458f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f469453a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f469454b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f469455c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f469456d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f469457e == true) goto L22;
        r100 = 1237;
    L22:
        int r109 = (r108 + r100) * 31;
        Function0<Integer> r110 = this.f469458f;
        if (r110 != null) goto L25;
        int r111 = 0;
    L27:
        return r109 + r111;
    L25:
        r111 = r110.hashCode();
        goto L27
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VLMContainerUIConfig(reduceMarginStart=" + this.f469453a + ", useNewHeightPadding=" + this.f469454b + ", isHead=" + this.f469455c + ", isTail=" + this.f469456d + ", isVideoGroup=" + this.f469457e + ", maxWidthProvider=" + this.f469458f + ')';
    }

    public /* synthetic */ j(boolean r110, boolean r111, boolean r112, boolean r113, Function0 r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r115 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r115 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r115 & 32) == 0) goto L21;
        r114 = null;
    L21:
        this(r100, r101, r102, r103, false, r114);
        return;
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public j(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, Function0<Integer> r105) {
        this.f469453a = r100;
        this.f469454b = r101;
        this.f469455c = r102;
        this.f469456d = r103;
        this.f469457e = r104;
        this.f469458f = r105;
    }
}
