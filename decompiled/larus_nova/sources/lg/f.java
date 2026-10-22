package lg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class f extends lg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509122a;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return this.f509122a;
    }

    public f(String r100, e r101) {
        Intrinsics.checkNotNullParameter("mall_live_room", "page");
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f509122a = r100;
    }
}
