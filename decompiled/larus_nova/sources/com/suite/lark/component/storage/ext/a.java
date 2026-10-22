package com.suite.lark.component.storage.ext;

import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    public static /* synthetic */ long b(VFSFile r100) {
        return a(r100, false);
    }

    public static final long a(VFSFile r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSPath r102 = r100.getVfsPath();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        long r103 = 0;
        if (b.b(r102) == true) goto L6;
        return 0;
    L6:
        if (b.c(r102) == false) goto L17;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        VFSFiles.f444819b.getClass();
        VFSFile[] r104 = VFSFiles.a(r102).listFiles(r102);
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L22;
        VFSFile r107 = r104[r106];
        if (r107.isDirectory() == false) goto L13;
        if (r101 == false) goto L15;
        long r108 = a(r107, r101);
    L14:
        r103 = r103 + r108;
    L15:
        r106 = r106 + 1;
        goto L8
    L13:
        r108 = b(r107);
        goto L14
    L22:
        return r103;
    L17:
        return b.e(r102);
    }
}
