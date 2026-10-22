package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements UniPathProvider {
    public g() {
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
        String r102 = com.ss.android.lark.diskmanage.storage.d.b(r100);
    L6:
        FileUtils.t(r102);
        return r102;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102 = com.ss.android.lark.diskmanage.storage.d.l(r100) + "download" + File.separator;
        FileUtils.t(r102);
        goto L6
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(com.ss.android.lark.storage.f.f440962i, new com.ss.android.lark.storage.d(new String[]{"download"}));
    }
}
