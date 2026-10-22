package znc;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f573064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f573065b = null;

    static {
        f573064a = Charset.forName("US-ASCII");
        f573065b = Charset.forName("UTF-8");
    }

    @JvmStatic
    public static final void a(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    @JvmStatic
    public static final void b(File r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        Intrinsics.checkNotNull(r104);
        b(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r104);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r100);
    }

    public static void c(PolarisFileWrapper r100, PolarisFileWrapper r101) throws IOException {
        if (r100.exists() == false) goto L30;
        if (r100.isDirectory() == false) goto L28;
        if (r101.exists() == true) goto L26;
        File r102 = r101.getParentFile();
        if (r102 == null) goto L14;
        if (r102.exists() == true) goto L14;
        r102.mkdirs();
    L14:
        if (r100.renameTo(r101) == false) goto L16;
        return;
    L16:
        if (StringsKt.startsWith$default(r101.getCanonicalPath(), r100.getCanonicalPath() + File.separator, false, 2, null) == true) goto L23;
        if (FilesKt.copyRecursively$default(r100, r101, false, null, 4, null) == false) goto L21;
        return;
    L21:
        throw new IOException("rename directory failed: " + r100 + "->" + r101);
    L23:
        throw new IOException("Cannot move directory: " + r100 + "->" + r101);
    L26:
        throw new IOException("Destination '" + r101 + "' already exists");
    L28:
        throw new IOException("Source '" + r100 + "' is not a directory");
    L30:
        throw new FileNotFoundException("Source '" + r100 + "' does not exist");
    }
}
