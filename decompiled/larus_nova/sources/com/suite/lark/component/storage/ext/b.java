package com.suite.lark.component.storage.ext;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b {
    public static final void a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        VFSFiles.a(r100).createNewFile(r100);
    }

    public static final boolean b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).exists(r100);
    }

    public static final boolean c(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).isDirectory(r100);
    }

    public static final boolean d(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).mkdirs(r100);
    }

    public static final boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).delete(r100);
    }

    public static final long e(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFiles.f444819b.getClass();
        return VFSFiles.a(r100).size(r100);
    }
}
