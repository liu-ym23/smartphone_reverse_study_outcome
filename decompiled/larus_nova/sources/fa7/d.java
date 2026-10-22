package fa7;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f476034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ruler.base.models.b f476037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f476038e;

    public final String toString() {
        return "[code = " + this.f476035b + ", msg = " + this.f476036c + ", strategyNames = " + this.f476038e + ", performance = " + this.f476037d + ", useFFF = " + this.f476034a + ']';
    }

    public d(int r100, String r101, List r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        com.bytedance.ruler.base.models.b r104 = new com.bytedance.ruler.base.models.b(0);
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        this.f476035b = r100;
        this.f476036c = r101;
        this.f476037d = r104;
        this.f476038e = r102;
        return;
    L11:
        r104 = null;
        goto L13
    }
}
