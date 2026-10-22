package i75;

import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;

/* JADX INFO: loaded from: classes16.dex */
public final class l {
    public static long a(VFSPath r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        VFSFile r102 = r100.toFile();
        if (r102 != null) goto L8;
        return 0;
    L8:
        if (r102.exists() == true) goto L11;
        return 0;
    L11:
        if (r102.isDirectory() == false) goto L23;
        VFSFile[] r103 = r102.listFiles();
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L32;
        VFSFile r106 = r103[r105];
        if (r106.isDirectory() == false) goto L19;
        long r107 = a(r106.getVfsPath());
    L17:
        r101 = r101 + r107;
    L21:
        r105 = r105 + 1;
        goto L13
    L19:
        if (r102.getPath().endsWith(".drivedownload") == false) goto L21;
        r107 = r102.length();
        goto L17
    L32:
        return r101;
    L23:
        if (r102.getPath().endsWith(".drivedownload") == true) goto L25;
        return 0;
    L25:
        return r102.length();
    }

    public static long b(VFSPath r100) {
        if (r100 != null) goto L26;
    L25:
        return 0;
    L26:
    L23:
        e = move-exception;
        tt5.a.e("FileUtils", "getDirSize ", e, false);
        goto L25
    L6:
        if (r100.toFile().exists() == false) goto L25;
        if (r100.toFile().isFile() == false) goto L13;
        return r100.toFile().length();
    L13:
        if (r100.toFile().isDirectory() == false) goto L25;
        VFSFile[] r101 = r100.toFile().listFiles();     // Catch: Exception -> L23
        long r102 = 0;
        int r103 = 0;
    L16:
        if (r103 >= r101.length) goto L22;
        if (r101[r103].isDirectory() == false) goto L20;
        long r104 = b(r101[r103].getVfsPath());     // Catch: Exception -> L23
    L21:
        r102 = r102 + r104;
        r103 = r103 + 1;
        goto L16
    L20:
        r104 = r101[r103].length();     // Catch: Exception -> L23
        goto L21
    L22:
        return r102;
    }

    public static void c(String r100) throws Exception {
        VFSFile r101 = ay4.d.a().i(r100);
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.isDirectory() == false) goto L19;
        File[] r102 = r101.listFiles();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        if (r102[r104].isDirectory() == false) goto L11;
        c(r102[r104].getAbsolutePath());
    L12:
        r104 = r104 + 1;
        goto L7
    L11:
        f(r102[r104]);
        goto L12
    L13:
        f(r101);
        return;
    }

    public static void e(VFSFile r100) throws Exception {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        File[] r101 = r100.listFiles();
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        if (r101[r103].isDirectory() == false) goto L11;
        c(r101[r103].getAbsolutePath());
    L13:
        r103 = r103 + 1;
        goto L6
    L11:
        if (r101[r103].isFile() == false) goto L13;
        f(r101[r103]);
        goto L13
    }

    public static boolean f(File r100) throws Exception {
        if (r100 != null) goto L5;
    L12:
        return false;
    L5:
        if (r100.exists() == false) goto L12;
        VFSFile r101 = ay4.d.a().v(r100.getParent(), r100.getName() + "_drive_delete");
        if (r100.renameTo(r101) == true) goto L10;
        tt5.a.d("FileUtils", "rename temp delete file error, target rename file failed, file=" + r101.getName());
        goto L12
    L10:
        return r101.delete();
    }

    public static void d(long r100, VFSPath r101) throws Exception {
        tt5.a.h("FileUtils", "removeDownloadingFiles beforeTimeInMills = " + r100);
        if (r101 != null) goto L5;
        return;
    L5:
        VFSFile r102 = r101.toFile();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.exists() == true) goto L10;
        return;
    L10:
        if (r102.isDirectory() == false) goto L26;
        VFSFile[] r103 = r102.listFiles();
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L27;
        VFSFile r106 = r103[r105];
        if (r106.getPath().endsWith(".drivedownload") == false) goto L19;
        if (r106.lastModified() > r100) goto L19;
        r106.delete();
    L19:
        r105 = r105 + 1;
        goto L13
    L27:
        return;
    }

    public static void g(long r100, VFSPath r101) throws Exception {
        tt5.a.h("FileUtils", "safeRemoveFiles beforeTimeInMills = " + r100);
        if (r101 != null) goto L5;
        return;
    L5:
        VFSFile r102 = r101.toFile();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.exists() == true) goto L11;
        return;
    L11:
        if (r102.isDirectory() == false) goto L16;
        VFSFile[] r103 = r102.listFiles();
        int r104 = r103.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L23;
        g(r100, r103[r105].getVfsPath());
        r105 = r105 + 1;
        goto L13
    L23:
        return;
    L16:
        if (r102.lastModified() > r100) goto L21;
        f(r102);
        return;
    }
}
