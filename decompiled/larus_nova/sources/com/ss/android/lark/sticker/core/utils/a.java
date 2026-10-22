package com.ss.android.lark.sticker.core.utils;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements UniPathProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440836a;

    /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.utils.a$a, reason: collision with other inner class name */
    public static final class C5302a {
    }

    static {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        this.f440836a = r100;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return l.a(r100) + '/' + this.f440836a + '/';
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(f.f440961h, new d(new String[]{this.f440836a}));
    L5:
        VFSFiles.f444819b.getClass();
        return VFSFiles.b(false).z(a(com.larksuite.framework.utils.b.f285948a));
    }
}
