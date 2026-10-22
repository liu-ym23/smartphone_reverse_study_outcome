package uf5;

import com.bytedance.ee.bear.domain.BearUrl;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f549926l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f549929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f549930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f549931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f549932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f549933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BearUrl f549934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f549935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f549936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f549937k;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f549927a, r101.f549927a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549928b, r101.f549928b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549929c, r101.f549929c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f549930d, r101.f549930d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f549931e, r101.f549931e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f549932f, r101.f549932f) == true) goto L27;
        return false;
    L27:
        if (this.f549933g == r101.f549933g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f549934h, r101.f549934h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f549935i, r101.f549935i) == true) goto L36;
        return false;
    L36:
        if (this.f549936j == r101.f549936j) goto L39;
        return false;
    L39:
        if (this.f549937k == r101.f549937k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((this.f549927a.hashCode() * 31) + this.f549928b.hashCode()) * 31) + this.f549929c.hashCode()) * 31) + this.f549930d.hashCode()) * 31) + this.f549931e.hashCode()) * 31) + this.f549932f.hashCode()) * 31) + this.f549933g) * 31) + this.f549934h.hashCode()) * 31) + this.f549935i.hashCode()) * 31;
        int r101 = 1231;
        if (this.f549936j == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f549937k == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeedInfo(objToken=" + this.f549927a + ", fileType=" + this.f549928b + ", fileId=" + this.f549929c + ", feedId=" + this.f549930d + ", feedType=" + this.f549931e + ", feedOpenFrom=" + this.f549932f + ", unreadBadgeCount=" + this.f549933g + ", bearUrl=" + this.f549934h + ", extra=" + this.f549935i + ", isLarkFeed=" + this.f549936j + ", isFeedAutoShow=" + this.f549937k + ')';
    }

    public r(String r100, String r101, String r102, String r103, String r104, String r105, int r106, BearUrl r107, Map<String, String> r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r101, "fileType");
        Intrinsics.checkNotNullParameter(r102, "fileId");
        Intrinsics.checkNotNullParameter(r103, "feedId");
        Intrinsics.checkNotNullParameter(r104, "feedType");
        Intrinsics.checkNotNullParameter(r105, "feedOpenFrom");
        Intrinsics.checkNotNullParameter(r107, "bearUrl");
        Intrinsics.checkNotNullParameter(r110, "extra");
        this.f549927a = r100;
        this.f549928b = r101;
        this.f549929c = r102;
        this.f549930d = r103;
        this.f549931e = r104;
        this.f549932f = r105;
        this.f549933g = r106;
        this.f549934h = r107;
        this.f549935i = r110;
        this.f549936j = r111;
        this.f549937k = r112;
    }
}
