package mk1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f514296b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f514297c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514298a;

    public static final class a {
    }

    static {
        f514296b = new c("Default", 0);
        f514297c = new c("RoomAuth", 1000);
    }

    public c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f514298a = r101;
    }
}
