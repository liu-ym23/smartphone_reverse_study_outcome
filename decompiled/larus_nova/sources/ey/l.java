package ey;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f474780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f474781b;

    public static final class a extends l {
        public a(f r100, f.d r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            super(r100, r101);
        }
    }

    public static final class b extends l {
        public b(f r100) {
            Intrinsics.checkNotNullParameter(r100, "from");
            super(r100, r100);
        }
    }

    public static final class c extends l {
        public c(f r100, f.C5832f r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            super(r100, r101);
        }
    }

    public static final class d extends l {
        public d(f.C5832f r100, f.C5832f r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            super(r100, r101);
        }
    }

    public static final class e extends l {
        public e(f.d r100, f r101) {
            Intrinsics.checkNotNullParameter(r100, "from");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
            super(r100, r101);
        }
    }

    public l(f r100, f r101) {
        this.f474780a = r100;
        this.f474781b = r101;
    }
}
