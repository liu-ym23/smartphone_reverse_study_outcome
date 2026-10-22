package hka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        c.a("startSafeModeProcess", "startSafeModeProcess-" + r100 + '-' + System.currentTimeMillis());
    }
}
