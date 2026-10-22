package t7c;

import com.larksuite.arch.jack.j;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f544998a;

    public b() {
        this(true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f544998a == ((b) r100).f544998a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f544998a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "CreateState(isShow=" + this.f544998a + ')';
    }

    public b(boolean r100) {
        this.f544998a = r100;
    }
}
