package q22;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f531394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f531395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f531398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f531399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f531400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f531401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f531402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f531403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f531404k;

    public a(String r100, boolean r101, k r102, String r103, int r104, long r105, String r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "giftUniqueKey");
        Intrinsics.checkNotNullParameter(r103, "giftDescription");
        Intrinsics.checkNotNullParameter(r106, "giftComboCount");
        this.f531397d = r100;
        this.f531398e = r101;
        this.f531399f = r102;
        this.f531400g = r103;
        this.f531401h = r104;
        this.f531402i = r105;
        this.f531403j = r106;
        this.f531404k = r110;
        this.f531396c = "uniqueKey: " + r100 + ", desc: " + r103 + ", combo: " + r106 + ", big: " + r110;
    }
}
