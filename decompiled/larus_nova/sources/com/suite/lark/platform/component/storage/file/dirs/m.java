package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements UniPathProvider {

    public static final class a {
    }

    static {
    }

    public m() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return com.ss.android.lark.diskmanage.storage.d.s(r100);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return com.ss.android.lark.storage.file.a.C5307a.a(r100, new com.ss.android.lark.storage.d(new String[]{"video_cache", ""}));
    }
}
