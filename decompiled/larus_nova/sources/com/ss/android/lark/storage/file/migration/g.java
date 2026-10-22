package com.ss.android.lark.storage.file.migration;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441004a;

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "srcPath");
        this.f441004a = r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return VFSFiles.f444819b.z(this.f441004a);
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return VFSFiles.f444819b.z(this.f441004a);
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath c(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return VFSFiles.f444819b.z(this.f441004a);
    }
}
