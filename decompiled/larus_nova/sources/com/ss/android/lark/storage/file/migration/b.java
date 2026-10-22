package com.ss.android.lark.storage.file.migration;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440986a;

    public final void d() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f440986a);
        if (r100.exists() == false) goto L6;
        FilesKt.deleteRecursively(r100);
        return;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "srcPath");
        this.f440986a = r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        d();
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        d();
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath c(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        d();
        return r100;
    }
}
