package com.ss.android.lark.storage.file.migration;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440985a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "srcPath");
        this.f440985a = r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath a(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        d(r100);
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        d(r100);
        return r100;
    }

    @Override // com.ss.android.lark.storage.file.migration.f
    public final VFSPath c(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getRealPath());
        if (new PolarisFileWrapper(this.f440985a).exists() == true) goto L5;
        return r100;
    L5:
        if (r101.exists() == false) goto L9;
        if (r101.isDirectory() == true) goto L9;
        return r100;
    L9:
        return VFSFiles.f444819b.z(this.f440985a);
    }

    public final void d(VFSPath r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f440985a);
        if (new PolarisFileWrapper(r100.getRealPath()).exists() == false) goto L5;
        return;
    L5:
        if (r101.exists() == true) goto L7;
        return;
    L7:
        if (r101.renameTo(new PolarisFileWrapper(r100.getRealPath())) == true) goto L9;
        VFSFiles.f444819b.getClass();
        Log.e(VFSFiles.f444820c, "Failed to rename file " + r101.getAbsolutePath() + " to " + r100.getRealPath());
        return;
    L9:
        VFSFiles.f444819b.getClass();
        Log.i(VFSFiles.f444820c, "auto transfer file: " + r101.getAbsolutePath() + " -> " + r100.getRealPath());
    }
}
