package xx4;

import java.io.File;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements com.ss.android.lark.jsruntime.vmsdk.a {

    /* JADX INFO: renamed from: xx4.a$a, reason: collision with other inner class name */
    public static final class C8284a {
    }

    static {
    }

    public a() {
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        File r101 = ay4.d.a().G(r100, false);     // Catch: Exception -> L12
        if (r101.exists() == true) goto L6;
    L10:
        tt5.a.d("JSRuntimeFileDelegate", "readFile: error: exists" + r101.exists() + " canRead:" + r101.canRead());     // Catch: Exception -> L12
        return "";
    L6:
        if (r101.canRead() == false) goto L10;
        return FilesKt.readText$default(r101, null, 1, null);
    L12:
        e = move-exception;
        rnb.c.b("JSRuntimeFileDelegate", "readFile error :" + e.getMessage());
        return "";
    }
}
