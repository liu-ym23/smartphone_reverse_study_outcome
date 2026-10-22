package ey;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f474771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f474774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f474777g;

    public static final class a extends f {
        public a(long r110, int r111) {
            Intrinsics.checkNotNullParameter("", "linkMicId");
            Intrinsics.checkNotNullParameter("", "rtcInfo");
            super(r110, r111, 3, 3, "", "", "Applying");
        }
    }

    public static final class b extends f {
        public b(long r110, int r111, int r112, String r113, String r114) {
            Intrinsics.checkNotNullParameter(r113, "linkMicId");
            Intrinsics.checkNotNullParameter(r114, "rtcInfo");
            super(r110, r111, r112, 2, r113, r114, "BeInviting");
        }
    }

    public static final class c {
    }

    public static final class d extends f {
        public d() {
            this(0);
        }

        public d(int r110) {
            Intrinsics.checkNotNullParameter("", "linkMicId");
            Intrinsics.checkNotNullParameter("", "rtcInfo");
            super(0, 0, 0, 0, "", "", "Disable");
        }
    }

    public static final class e extends f {
        public e(long r110, int r111, int r112, String r113, String r114) {
            Intrinsics.checkNotNullParameter(r113, "linkMicId");
            Intrinsics.checkNotNullParameter(r114, "rtcInfo");
            super(r110, r111, r112, 1, r113, r114, "Inviting");
        }
    }

    /* JADX INFO: renamed from: ey.f$f, reason: collision with other inner class name */
    public static final class C5832f extends f {
        public C5832f(long r110, int r111, int r112, String r113, String r114) {
            Intrinsics.checkNotNullParameter(r113, "linkMicId");
            Intrinsics.checkNotNullParameter(r114, "rtcInfo");
            super(r110, r111, r112, 4, r113, r114, "Linking");
        }
    }

    static {
    }

    public final String toString() {
        return this.f474777g + "(channelId=" + this.f474771a + ", scene=" + this.f474772b + ", bizType=" + this.f474773c + ", state=" + this.f474774d + ", linkMicId='" + this.f474775e + "', name='" + this.f474777g + "')";
    }

    public f(long r100, int r101, int r102, int r103, String r104, String r105, String r106) {
        this.f474771a = r100;
        this.f474772b = r101;
        this.f474773c = r102;
        this.f474774d = r103;
        this.f474775e = r104;
        this.f474776f = r105;
        this.f474777g = r106;
    }
}
