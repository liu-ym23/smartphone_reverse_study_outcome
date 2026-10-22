package m33;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f511709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f511711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f511712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f511713e;

    public c(boolean r100, String r101, boolean r102, Map r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = null;
    L11:
        this.f511709a = r100;
        this.f511710b = r101;
        this.f511711c = false;
        this.f511712d = r102;
        this.f511713e = r103;
    }
}
