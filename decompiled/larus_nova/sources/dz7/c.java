package dz7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f470606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f470608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f470610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f470611f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f470612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f470613b;

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f470614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f470615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f470616c;

        public b() {
            this.f470615b = 0;
        }
    }

    public /* synthetic */ c(b r100, String r101, a r110, String r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r111 = "";
    L5:
        this(r100, r101, r110, r111, null, null);
    }

    public c(b r100, String r101, a r102, String r103, Map<String, Long> r104, Map<String, Long> r105) {
        Intrinsics.checkNotNullParameter(r103, "resultMsg");
        this.f470606a = r100;
        this.f470607b = r101;
        this.f470608c = r102;
        this.f470609d = r103;
        this.f470610e = r104;
        this.f470611f = r105;
    }
}
