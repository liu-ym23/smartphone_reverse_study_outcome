package i75;

import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public static long a(VFSPath r8) {
        long r0 = 0;
        if (r8 != null) goto L5;
        return 0;
    L5:
        VFSFile r9 = r8.toFile();
        if (r9 != null) goto L8;
        return 0;
    L8:
        if (r9.exists() == true) goto L11;
        return 0;
    L11:
        if (r9.isDirectory() == false) goto L23;
        File[] r2 = r9.listFiles();
        int r4 = r2.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L32;
        File r6 = r2[r5];
        if (r6.isDirectory() == false) goto L19;
        long r7 = a(r6.getVfsPath());
    L17:
        r0 = r0 + r7;
    L21:
        r5 = r5 + 1;
        goto L13
    L19:
        if (r9.getPath().endsWith(".drivedownload") == false) goto L21;
        r7 = r9.length();
        goto L17
    L32:
        return r0;
    L23:
        if (r9.getPath().endsWith(".drivedownload") == true) goto L25;
        return 0;
    L25:
        return r9.length();
    }

    public static long b(VFSPath r8) {
        if (r8 != null) goto L26;
    L25:
        return 0;
    L26:
    L23:
        e = move-exception;
        tt5.a.e("FileUtils", "getDirSize ", e, false);
        goto L25
    L6:
        if (r8.toFile().exists() == false) goto L25;
        if (r8.toFile().isFile() == false) goto L13;
        return r8.toFile().length();
    L13:
        if (r8.toFile().isDirectory() == false) goto L25;
        VFSFile[] r9 = r8.toFile().listFiles();     // Catch: Exception -> L23
        long r4 = 0;
        int r3 = 0;
    L16:
        if (r3 >= r9.length) goto L22;
        if (r9[r3].isDirectory() == false) goto L20;
        long r6 = b(r9[r3].getVfsPath());     // Catch: Exception -> L23
    L21:
        r4 = r4 + r6;
        r3 = r3 + 1;
        goto L16
    L20:
        r6 = r9[r3].length();     // Catch: Exception -> L23
        goto L21
    L22:
        return r4;
    }

    public static void c(String r4) throws Exception {
        VFSFile r5 = ay4.d.a().i(r4);
        if (r5.exists() == true) goto L5;
        return;
    L5:
        if (r5.isDirectory() == false) goto L19;
        File[] r0 = r5.listFiles();
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r0[r2].isDirectory() == false) goto L11;
        c(r0[r2].getAbsolutePath());
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        f(r0[r2]);
        goto L12
    L13:
        f(r5);
        return;
    }

    public static void e(VFSFile r3) throws Exception {
        if (r3.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r3.listFiles();
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        if (r4[r1].isDirectory() == false) goto L11;
        c(r4[r1].getAbsolutePath());
    L13:
        r1 = r1 + 1;
        goto L6
    L11:
        if (r4[r1].isFile() == false) goto L13;
        f(r4[r1]);
        goto L13
    }

    public static boolean f(File r5) throws Exception {
        if (r5 != null) goto L5;
    L12:
        return false;
    L5:
        if (r5.exists() == false) goto L12;
        VFSFile r1 = ay4.d.a().v(r5.getParent(), r5.getName() + "_drive_delete");
        if (r5.renameTo(r1) == true) goto L10;
        tt5.a.d("FileUtils", "rename temp delete file error, target rename file failed, file=" + r1.getName());
        goto L12
    L10:
        return r1.delete();
    }

    public static void d(long r6, VFSPath r8) throws Exception {
        tt5.a.h("FileUtils", "removeDownloadingFiles beforeTimeInMills = " + r6);
        if (r8 != null) goto L5;
        return;
    L5:
        VFSFile r9 = r8.toFile();
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.exists() == true) goto L10;
        return;
    L10:
        if (r9.isDirectory() == false) goto L26;
        File[] r10 = r9.listFiles();
        int r0 = r10.length;
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L27;
        File r2 = r10[r1];
        if (r2.getPath().endsWith(".drivedownload") == false) goto L19;
        if (r2.lastModified() > r6) goto L19;
        r2.delete();
    L19:
        r1 = r1 + 1;
        goto L13
    L27:
        return;
    }

    public static void g(long r3, VFSPath r5) throws Exception {
        tt5.a.h("FileUtils", "safeRemoveFiles beforeTimeInMills = " + r3);
        if (r5 != null) goto L5;
        return;
    L5:
        VFSFile r6 = r5.toFile();
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.exists() == true) goto L11;
        return;
    L11:
        if (r6.isDirectory() == false) goto L16;
        VFSFile[] r7 = r6.listFiles();
        int r0 = r7.length;
        int r1 = 0;
    L13:
        if (r1 >= r0) goto L23;
        g(r3, r7[r1].getVfsPath());
        r1 = r1 + 1;
        goto L13
    L23:
        return;
    L16:
        if (r6.lastModified() > r3) goto L21;
        f(r6);
        return;
    }
}
