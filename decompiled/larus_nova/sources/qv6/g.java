package qv6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f534910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f534911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f534912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f534913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f534914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f534915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f534916h;

    public static final class a {
    }

    static {
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f534909a = r100;
    }

    public static void a(g r100, boolean r101, boolean r102, boolean r103) {
        if (r101 == true) goto L4;
        r100.f534914f = 1;
        return;
    L4:
        if (r102 == true) goto L6;
        r100.f534914f = 2;
        return;
    L6:
        if (r103 == false) goto L11;
        r100.f534914f = 4;
        return;
    }
}
