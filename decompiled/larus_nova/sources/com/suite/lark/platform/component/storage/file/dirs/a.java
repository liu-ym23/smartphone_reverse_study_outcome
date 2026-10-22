package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements UniPathProvider {

    /* JADX INFO: renamed from: com.suite.lark.platform.component.storage.file.dirs.a$a, reason: collision with other inner class name */
    public static final class C5528a {
    }

    static {
    }

    public a() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        if (UniPathProvider.SpaceType.USER != UniPathProvider.SpaceType.LARK) goto L6;
        return LarkFileStorage.b();
    L6:
        return LarkFileStorage.c();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.ss.android.lark.diskmanage.storage.d.i(r100) + "/audio/";
        FileUtils.t(r102);
        return r102;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(com.ss.android.lark.storage.f.f440958e, new com.ss.android.lark.storage.d(new String[]{"audio"}));
    }
}
