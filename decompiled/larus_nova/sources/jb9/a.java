package jb9;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f498040c;

    /* JADX INFO: renamed from: jb9.a$a, reason: collision with other inner class name */
    public static final class C6412a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f498038a == r101.f498038a) goto L12;
        return false;
    L12:
        if (this.f498039b == r101.f498039b) goto L15;
        return false;
    L15:
        if (this.f498040c == r101.f498040c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f498038a * 31) + this.f498039b) * 31;
        if (this.f498040c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ConversationGroupConfig(groupPolicy=" + this.f498038a + ", sortPolicy=" + this.f498039b + ", socialIndependentGroup=" + this.f498040c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(1, 0, true);
    }

    public a(int r100, int r101, boolean r102) {
        this.f498038a = r100;
        this.f498039b = r101;
        this.f498040c = r102;
    }
}
