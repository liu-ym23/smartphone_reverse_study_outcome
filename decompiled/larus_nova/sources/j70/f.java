package j70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f497555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f497556d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f497557e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497559b;

    public static final class a {
    }

    static {
        f497555c = new f("unknown", "unknown");
        f497556d = new f("parent", "parent");
        f497557e = new f("unset", "unset");
    }

    public final String toString() {
        return this.f497558a;
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "description");
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f497558a = r100;
        this.f497559b = r101;
    }
}
