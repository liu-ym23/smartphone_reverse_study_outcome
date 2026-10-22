package pn0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f529908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f529909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f529910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f529911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f529912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f529913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f529914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Integer> f529915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f529916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f529917j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StringBuilder f529918a;

        public a(StringBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "sb");
            this.f529918a = r100;
        }
    }

    public String toString() {
        return "{uiLayout = " + g() + ", orientation = " + b() + ", isStatusBarVisible = " + i() + ", playMode = " + c() + ", uiFeatures = " + f() + ", isAnchor = " + h() + '}';
    }

    public boolean a() {
        return this.f529914g;
    }

    public int b() {
        return this.f529909b;
    }

    public List<Integer> c() {
        return this.f529911d;
    }

    public Long d() {
        return this.f529916i;
    }

    public a e() {
        return this.f529913f;
    }

    public List<Integer> f() {
        return this.f529915h;
    }

    public int g() {
        return this.f529908a;
    }

    public boolean h() {
        return this.f529912e;
    }

    public boolean i() {
        return this.f529910c;
    }

    public d(int r100, int r101, boolean r102, List r103, boolean r104, a r105, boolean r110, List r111, Long r112, Object r113, int r114) {
        if ((r114 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r114 & 4) == 0) goto L9;
        r102 = true;
    L9:
        if ((r114 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r114 & 16) == 0) goto L15;
        r104 = false;
    L15:
        if ((r114 & 64) == 0) goto L18;
        r105 = new a(new StringBuilder());
    L18:
        if ((r114 & 128) == 0) goto L21;
        r110 = false;
    L21:
        if ((r114 & 256) == 0) goto L24;
        r111 = null;
    L24:
        if ((r114 & 512) == 0) goto L26;
        r112 = null;
    L26:
        Intrinsics.checkNotNullParameter(r105, "traceInfo");
        this.f529908a = r100;
        this.f529909b = r101;
        this.f529910c = r102;
        this.f529911d = r103;
        this.f529912e = r104;
        this.f529913f = r105;
        this.f529914g = r110;
        this.f529915h = r111;
        this.f529916i = r112;
        this.f529917j = r113;
    }
}
