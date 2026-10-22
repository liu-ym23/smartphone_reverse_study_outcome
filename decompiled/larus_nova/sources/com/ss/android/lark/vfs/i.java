package com.ss.android.lark.vfs;

import android.net.Uri;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends a {
    @Override // com.ss.android.lark.vfs.h
    public final boolean C() {
        return true;
    }

    public i() {
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath q(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        FileSystemManager.f444805a.getClass();
        Intrinsics.checkNotNullParameter(r100, "uri");
        return FileSystemManager.b(r100).resolvePath(r100);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File x(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        a(r100, true);
        return r100.getFileSystem().afterWriteCompat(new VFSFile(r100));
    }

    @Override // com.ss.android.lark.vfs.h
    public final VFSPath z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        FileSystemManager.f444805a.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        Uri r101 = j.a(r100);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return FileSystemManager.b(r101).resolvePath(r101);
    }

    @Override // com.ss.android.lark.vfs.h
    public final File r(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (a(r100, false) == true) goto L5;
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).r(r100, r101);
    L5:
        File r102 = r100.getFileSystem().getReadFile(r100);
        if (r101 == false) goto L15;
        VFSFiles.f444819b.getClass();
        VFSFiles.a r103 = VFSFiles.f444821d;
        if (r103 == null) goto L16;
        File r104 = r103.b(r102);
        if (r104 != null) goto L13;
        return r102;
    L13:
        return r104;
    L16:
        return r102;
    L15:
        return r102;
    }
}
