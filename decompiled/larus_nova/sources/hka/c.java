package hka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f485612a = 0;

    static {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileNamePrefix");
        int r101 = com.obric.matrix.platform.sdk.ones.safecushion.a.f397009a;     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.safecushion.a.C4652a.a();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        gka.b.b("SafeCushionFileUtils", "getSafeCushion: error");
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fileNamePrefix");
        Intrinsics.checkNotNullParameter(r101, "updateFileName");
        gka.b.c("SafeCushionFileUtils", "createOrUpdateSafeCushionFile fileNamePrefix:" + r100 + ",updateFileName:" + r101);     // Catch: Exception -> L5
        b(r100);     // Catch: Exception -> L5
        int r102 = com.obric.matrix.platform.sdk.ones.safecushion.a.f397009a;     // Catch: Exception -> L5
        com.obric.matrix.platform.sdk.ones.safecushion.a.C4652a.a();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        gka.b.b("SafeCushionFileUtils", "createOrUpdateSafeCushionFile: error");
    }
}
