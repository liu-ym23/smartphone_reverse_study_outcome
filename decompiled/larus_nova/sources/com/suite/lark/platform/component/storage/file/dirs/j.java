package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import android.os.Environment;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements UniPathProvider {
    public j() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.LARK;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StoragePermissionUtils.e(r100) == true) goto L5;
        String r102 = com.ss.android.lark.diskmanage.storage.d.e(r100);
    L13:
        FileUtils.t(r102);
        return r102;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r103 = new StringBuilder();
        File r104 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (r104 != null) goto L9;
        String r105 = "";
    L12:
        r103.append(r105);
        r103.append("/Lark/");
        r102 = r103.toString();
        FileUtils.t(r102);
        goto L13
    L9:
        if (r104.exists() == true) goto L11;
        r104.mkdir();
    L11:
        r105 = r104.getAbsolutePath();
        goto L12
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        VFSPath r101 = r100.b(com.ss.android.lark.storage.f.f440963j, null);
        FileUtils.t(r101.getRealPath());
        return r101;
    }
}
