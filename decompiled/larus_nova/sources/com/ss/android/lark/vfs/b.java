package com.ss.android.lark.vfs;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    static {
    }

    public static boolean a(VFSPath r100, VFSPath r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        if (r100.isParentOf(r101) == true) goto L21;
        VFSFiles r102 = VFSFiles.f444819b;
        if (r102.isFile(r100) == true) goto L7;
        VFSFile[] r103 = r102.listFiles(r100);
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L15;
        VFSFile r106 = r103[r105];
        if (r106.isFile() == false) goto L13;
        b(r106.getVfsPath(), r101.subPath(r106.getName()));
    L14:
        r105 = r105 + 1;
        goto L9
    L13:
        a(r106.getVfsPath(), r101.subPath(r106.getName()));
        goto L14
    L15:
        VFSFiles r107 = VFSFiles.f444819b;
        r107.delete(r100);
        if (r107.exists(r100) == false) goto L25;
        Log.e("CopyMoveHelper", "Failed to delete original directory " + r100 + " after copy to " + r101);
        return true;
    L25:
        return true;
    L7:
        return b(r100, r101.subPath(r100.getName()));
    L21:
        throw new IOException("Cannot move directory:" + r100 + " to a subdirectory of itself: " + r101);
    }

    public static boolean b(VFSPath r100, VFSPath r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        if (new PolarisFileWrapper(r101.getAbsolutePath()).exists() == true) goto L19;
        if (new PolarisFileWrapper(r100.getAbsolutePath()).exists() == false) goto L16;
        VFSFiles r102 = VFSFiles.f444819b;
        r102.createNewFile(r100);
        InputStream r103 = r102.l(r100);
        OutputStream r104 = r102.s(r101, false);
        byte[] r105 = new byte[8192];
    L7:
        int r106 = r103.read(r105);
        if (r106 <= 0) goto L20;
        r104.write(r105, 0, r106);
        goto L7
    L20:
        r103.close();     // Catch: IOException -> L12
        r104.close();     // Catch: IOException -> L12
    L14:
        VFSFiles.f444819b.delete(r100);
        return true;
    L12:
        e = move-exception;
        Log.i("CopyMoveHelper", "copy stream failed", e);
        goto L14
    L16:
        Log.i("CopyMoveHelper", "move file ignored, " + r100 + " not exists");
        return false;
    L19:
        throw new IOException(r101 + " exists, cannot move");
    }
}
