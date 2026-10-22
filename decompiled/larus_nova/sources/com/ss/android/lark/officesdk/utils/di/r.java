package com.ss.android.lark.officesdk.utils.di;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.vfs.VFSFile;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f437233a = 0;

    public static final class a {
        @JvmStatic
        public static ntb.v a() {
            DependencyContainer r100 = DependencyContainer.f433166a;
            ntb.v r101 = (ntb.v) DependencyContainer.a(ntb.v.class, null);
            if (r101 == null) goto L6;
            return r101;
        L6:
            throw new IllegalStateException("IStorageDependency must be initialized before using StorageUtil");
        }

        @JvmStatic
        public static File b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            VFSFile r101 = a().i(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            return new PolarisFileWrapper(r100);
        }

        public static void c(ZipInputStream r100, String r101) throws Exception {
            Intrinsics.checkNotNullParameter(r100, "inZip");
        L3:
            ZipEntry r102 = r100.getNextEntry();
            if (r102 == null) goto L34;
            Intrinsics.checkNotNull(r102);
            String r103 = r102.getName();
            BufferedOutputStream r104 = null;
            if (StringsKt.contains$default(r103, "../", false, 2, null) == true) goto L3;
            if (r102.isDirectory() == true) goto L10;
            PolarisFileWrapper r105 = new PolarisFileWrapper(r101 + File.separator + r103);
            if (r105.exists() == true) goto L35;
            r105.getParentFile().mkdirs();
            r105.createNewFile();
        L35:
            BufferedOutputStream r106 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105));     // Catch: Throwable -> L26 IOException -> L28
            byte[] r107 = new byte[1024];     // Catch: Throwable -> L22 IOException -> L24
        L17:
            int r108 = r100.read(r107);     // Catch: Throwable -> L22 IOException -> L24
            if (r108 == (-1)) goto L20;
            r106.write(r107, 0, r108);     // Catch: Throwable -> L22 IOException -> L24
            r106.flush();     // Catch: Throwable -> L22 IOException -> L24
            goto L17
        L20:
            r106.close();     // Catch: Throwable -> L22 IOException -> L24
            swb.d.a(new Closeable[]{r106});
        L24:
            e = e;
            r104 = r106;
        L29:
            e.printStackTrace();     // Catch: Throwable -> L26
            swb.d.a(new Closeable[]{r104});
        L22:
            th = th;
        L32:
            swb.d.a(new Closeable[]{r106});
            throw th;
        L26:
            th = th;
            r106 = r104;
        L28:
            e = e;
            goto L29
        L10:
            new PolarisFileWrapper(r101 + File.separator + StringsKt.dropLast(r103, 1)).mkdirs();
            goto L3
        }
    }

    static {
    }
}
