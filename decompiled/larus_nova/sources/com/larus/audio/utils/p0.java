package com.larus.audio.utils;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p0 {
    static {
        BigInteger r100 = BigInteger.valueOf(1024);
        r100.multiply(r100.multiply(r100.multiply(r100.multiply(r100.multiply(r100)))));
        Charset.forName("UTF-8");
        char r101 = File.separatorChar;
    }

    public static void a(PolarisFileWrapper r110, PolarisFileWrapper r111) throws IOException {
        if (r110 == null) goto L72;
        if (r111 == null) goto L70;
        if (r110.exists() == false) goto L68;
        if (r110.isDirectory() == true) goto L66;
        if (Intrinsics.areEqual(r110.getCanonicalPath(), r111.getCanonicalPath()) == true) goto L64;
        File r100 = r111.getParentFile();
        if (r100 == null) goto L20;
        if (r100.mkdirs() == true) goto L20;
        if (r100.isDirectory() == true) goto L20;
        throw new IOException("Destination '" + r100 + "' directory cannot be created");
    L20:
        if (r111.exists() == false) goto L27;
        if (r111.canWrite() == true) goto L27;
        throw new IOException("Destination '" + r111 + "' exists but is read-only");
    L27:
        if (r111.exists() == true) goto L29;
    L33:
        FileChannel r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L58
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r111);     // Catch: Throwable -> L56
        FileChannel r104 = r102.getChannel();     // Catch: Throwable -> L54
        r101 = r103.getChannel();     // Catch: Throwable -> L52
        long r112 = r104.size();     // Catch: Throwable -> L52
        long r113 = 0;
    L39:
        if (r113 >= r112) goto L46;
        long r105 = r112 - r113;     // Catch: Throwable -> L52
        if (r105 <= 31457280) goto L43;
        long r106 = 31457280;
    L44:
        r113 = r113 + r101.transferFrom(r104, r113, r106);
        goto L39
    L43:
        r106 = r105;
        goto L44
    L46:
        k0.a(r101);
        k0.a(r103);
        k0.a(r104);
        k0.a(r102);
        if (r110.length() != r111.length()) goto L51;
        r111.setLastModified(r110.lastModified());
        return;
    L51:
        throw new IOException("Failed to copy full contents from '" + r110 + "' to '" + r111 + '\'');
    L52:
        th = th;
    L61:
        k0.a(r101);
        k0.a(r103);
        k0.a(r104);
        k0.a(r102);
        throw th;
    L54:
        th = th;
        r104 = null;
    L56:
        th = th;
    L60:
        r103 = null;
        r104 = null;
    L58:
        th = th;
        r102 = null;
        goto L60
    L29:
        if (r111.isDirectory() == false) goto L33;
        throw new IOException("Destination '" + r111 + "' exists but is a directory");
    L64:
        throw new IOException("Source '" + r110 + "' and destination '" + r111 + "' are the same");
    L66:
        throw new IOException("Source '" + r110 + "' exists but is a directory");
    L68:
        throw new FileNotFoundException("Source '" + r110 + "' does not exist");
    L70:
        throw new NullPointerException("Destination must not be null");
    L72:
        throw new NullPointerException("Source must not be null");
    }

    @JvmStatic
    public static final void b(File r100, boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L8;
        if (r101 == false) goto L7;
        return;
    L7:
        throw new IOException("not a readable directory: " + r100);
    L8:
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L20;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L14;
        Intrinsics.checkNotNull(r105);
        b(r105, r101);
    L14:
        if (r105.delete() == true) goto L19;
        if (r101 == true) goto L19;
        throw new IOException("failed to delete file: " + r105);
    L19:
        r104 = r104 + 1;
        goto L9
    }

    @JvmStatic
    public static final boolean c(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        if (r100.renameTo(r101) == false) goto L14;
        return true;
    L14:
        a(r100, r101);     // Catch: Exception -> L11
        r100.delete();     // Catch: Exception -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        int r102 = c68.b.f22600a;     // Catch: Exception -> L11
        c68.b.b("FileUtil", "renameTo delete error " + e);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        int r103 = c68.b.f22600a;
        c68.b.b("FileUtil", "renameTo error " + e);
        return false;
    }
}
