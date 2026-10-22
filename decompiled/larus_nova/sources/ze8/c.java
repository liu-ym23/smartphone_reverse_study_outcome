package ze8;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f571561d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f571558a == r101.f571558a) goto L12;
        return false;
    L12:
        if (this.f571559b == r101.f571559b) goto L15;
        return false;
    L15:
        if (this.f571560c == r101.f571560c) goto L18;
        return false;
    L18:
        if (this.f571561d == r101.f571561d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f571558a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f571559b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f571560c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f571561d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
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
        return "InputActionVisibilitySpec(actionEntranceVisible=" + this.f571558a + ", actionSpeakVisible=" + this.f571559b + ", actionSendVisible=" + this.f571560c + ", actionMenuEntranceVisible=" + this.f571561d + ')';
    }

    public c(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f571558a = r100;
        this.f571559b = r101;
        this.f571560c = r102;
        this.f571561d = r103;
    }
}
