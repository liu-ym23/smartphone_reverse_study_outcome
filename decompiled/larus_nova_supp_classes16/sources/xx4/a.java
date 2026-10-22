package xx4;

import java.io.File;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements com.ss.android.lark.jsruntime.vmsdk.a {

    /* JADX INFO: renamed from: xx4.a$a, reason: collision with other inner class name */
    public static final class C0324a {
    }

    static {
    }

    public a() {
    }

    public final String a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "filePath");
        File r7 = ay4.d.a().G(r6, false);     // Catch: Exception -> L12
        if (r7.exists() == true) goto L6;
    L10:
        tt5.a.d("JSRuntimeFileDelegate", "readFile: error: exists" + r7.exists() + " canRead:" + r7.canRead());     // Catch: Exception -> L12
        return "";
    L6:
        if (r7.canRead() == false) goto L10;
        return FilesKt.readText$default(r7, null, 1, null);
    L12:
        e = move-exception;
        rnb.c.b("JSRuntimeFileDelegate", "readFile error :" + e.getMessage());
        return "";
    }
}
