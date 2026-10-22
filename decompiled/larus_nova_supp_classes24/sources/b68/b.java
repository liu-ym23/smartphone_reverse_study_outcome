package b68;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final b a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((File) r3).lastModified()), Long.valueOf(((File) r4).lastModified()));
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    public final synchronized boolean a(String r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "filePath");     // Catch: Throwable -> L22
        boolean r0 = false;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4);     // Catch: Throwable -> L11 Exception -> L13
        if (r1.exists() == false) goto L8;
        r0 = r1.delete();     // Catch: Throwable -> L11 Exception -> L13
    L8:
        int r5 = c68.b.a;     // Catch: Throwable -> L22
        String r6 = "FileStreamHelper";
    L17:
        c68.b.a(r6, "#deleteFile finish");     // Catch: Throwable -> L22
        monitor-exit(this);
        return r0;
    L13:
        e = move-exception;
        e(this, e, null, 2);     // Catch: Throwable -> L11
        int r7 = c68.b.a;     // Catch: Throwable -> L22
        r6 = "FileStreamHelper";
        goto L17
    L11:
        th = move-exception;
        c68.b.a("FileStreamHelper", "#deleteFile finish");     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void b(File r3, long r4) {
        File[] r5 = r3.listFiles();
        if (r5 == null) goto L16;
        List r6 = ArraysKt.sortedWith(r5, new a());
        if (r6 == null) goto L25;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L26;
        File r0 = (File) r7.next();
        if (r0.isFile() == false) goto L9;
        if (r0.delete() == false) goto L9;
        r4 = r4 - r0.length();
        if (r4 > 0) goto L9;
        return;
    L26:
        return;
    L25:
        return;
    }

    public static String c(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "basePath");
        Intrinsics.checkNotNullParameter(r5, "fileNameWithPCM");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        if (StringsKt.endsWith$default(r5, ".pcm", false, 2, null) == true) goto L9;
        r5 = r5 + ".pcm";
    L9:
        StringBuilder r0 = new StringBuilder();
        m58.b r2 = h.k;
        if (r2 == null) goto L14;
        Application r3 = r2.getApplication();
        if (r3 == null) goto L14;
        File r6 = r3.getFilesDir();
    L15:
        r0.append(r6);
        r0.append(r4);
        String r7 = r0.toString();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r7);
        if (r1.exists() == true) goto L22;
        if (r1.mkdirs() == true) goto L22;
        c68.b.b("FileStreamHelper", "Directory creation failed");
        return null;
    L22:
        return r7 + r5;
    L14:
        r6 = null;
        goto L15
    }

    public static void d(Exception r2, String r3) {
        int r0 = c68.b.a;
        StringBuilder r1 = new StringBuilder("File error: ");
        if (r2 == null) goto L6;
        String r4 = r2.getMessage();
        if (r4 == null) goto L6;
    L7:
        r1.append(r4);
        r1.append(" | ");
        r1.append(r3);
        c68.b.b("FileStreamHelper", r1.toString());
        return;
    L6:
        r4 = "unknown error";
        goto L7
    }

    public final boolean f(String r9, long r10) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r9);
        if (r0.isDirectory() == true) goto L6;
        e(this, null, "Provided path is not a directory", 1);
        return false;
    L6:
        Iterator r1 = SequencesKt.filter(FilesKt.walkTopDown(r0), new b68.a()).iterator();
        long r4 = 0;
    L8:
        if (r1.hasNext() == false) goto L10;
        r4 = r4 + ((File) r1.next()).length();
        goto L8
    L10:
        int r2 = c68.b.a;
        c68.b.b("FileStreamHelper", "#isFolderSizeExceedLimit folderPath：" + r9 + ",totalSize:" + r4 + ",maxSizeInBytes:" + r10);
        if (r4 <= r10) goto L15;
        return true;
    L15:
        return false;
    }

    public final void g(PolarisFileWrapper r7, long r8) {
        long r0 = r7.length() - r8;
        if (r0 > 0) goto L5;
        return;
    L5:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r7.getParent(), "temp_" + r7.getName());
        PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(r7);
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r2);     // Catch: Throwable -> L20
        r3.skip(r0);     // Catch: Throwable -> L15
        ByteStreamsKt.copyTo(r3, r4, (int) r8);     // Catch: Throwable -> L15
    L9:
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r3, null);
        if (r7.delete() == false) goto L13;
        r2.renameTo(r7);
        return;
    L13:
        e(this, null, "Failed to delete the original file for truncation", 1);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public static String h(b r7, String r8, ByteArrayOutputStream r9) {
        monitor-enter(r7);
        Intrinsics.checkNotNullParameter(r8, "filePath");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r9, "data");     // Catch: Throwable -> L28
        if (r9.size() > 0) goto L8;
        e(r7, null, "Data is empty, write to file failed", 1);     // Catch: Throwable -> L28
        monitor-exit(r7);
        return "FAILED";
    L8:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8);     // Catch: Throwable -> L28
        File r1 = r0.getParentFile();     // Catch: Throwable -> L28
        if (r1 != null) goto L14;
        monitor-exit(r7);
        return "FAILED";
    L14:
        if (r7.f(r1.getPath(), 10737418240L) == false) goto L31;
        b(r1, r9.size());     // Catch: Throwable -> L28
    L31:
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r8);     // Catch: IOException -> L20 Throwable -> L28
        r9.writeTo(r2);     // Catch: IOException -> L20 Throwable -> L28
        r2.close();     // Catch: IOException -> L20 Throwable -> L28
        if (r0.length() <= 10737418240L) goto L22;
        r7.g(r0, 10737418240L);     // Catch: IOException -> L20 Throwable -> L28
    L22:
        c68.b.a("FileStreamHelper", "#writeByteArrayToFile finish");     // Catch: Throwable -> L28
        monitor-exit(r7);
        return "SUCCESS";
    L20:
        e = move-exception;
        d(e, "Write to file failed");     // Catch: Throwable -> L28
        return "FAILED";
    L28:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void e(b r2, Exception r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        r2.getClass();
        d(r3, r4);
    }
}
