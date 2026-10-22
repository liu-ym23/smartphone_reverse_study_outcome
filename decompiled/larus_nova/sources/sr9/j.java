package sr9;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f543246a = null;

    static {
        f543246a = new j();
    }

    public j() {
    }

    @Override // sr9.d
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return "";
    }

    @Override // sr9.d
    public final Pair<Integer, Integer> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // sr9.d
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return "";
    }

    @Override // sr9.d
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("upload", "contentSource");
    }

    @Override // sr9.d
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("album", "previousPage");
    }

    @Override // sr9.d
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return "";
    }

    @Override // sr9.d
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return false;
    }

    @Override // sr9.d
    public final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return "";
    }
}
