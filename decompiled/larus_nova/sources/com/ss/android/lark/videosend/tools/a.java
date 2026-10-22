package com.ss.android.lark.videosend.tools;

import android.content.Context;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements UniPathProvider {

    /* JADX INFO: renamed from: com.ss.android.lark.videosend.tools.a$a, reason: collision with other inner class name */
    public static final class C5381a {
    }

    static {
    }

    public a() {
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
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.ss.android.lark.diskmanage.storage.d.i(r100) + "/video_compress/";
        FileUtils.t(r102);
        return r102;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(com.ss.android.lark.storage.f.f440958e, new com.ss.android.lark.storage.d(new String[]{"im", "video_compress"}));
    }
}
