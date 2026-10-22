package j04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f496792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f496793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f496794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f496795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f496796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f496797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f496798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f496799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f496800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f496801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f496802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f496803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f496804m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f496805n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f496806o;

    public a(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "entranceType");
        this.f496798g = "";
        this.f496798g = r100;
        if (Intrinsics.areEqual(r100, "enter_play") == false) goto L8;
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
    L7:
        this.f496792a = r102;
        this.f496793b = System.currentTimeMillis();
        return;
    L6:
        r102 = 0;
        goto L7
    L8:
        this.f496805n = System.currentTimeMillis();
    }
}
