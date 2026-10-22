package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502573a;

    public t() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L9;
        return false;
    L9:
        if (this.f502573a == ((t) r100).f502573a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f502573a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "DiaryImageBlockConfig(doraDiaryStyleV2=" + this.f502573a + ')';
    }

    public t(boolean r100) {
        this.f502573a = r100;
    }
}
