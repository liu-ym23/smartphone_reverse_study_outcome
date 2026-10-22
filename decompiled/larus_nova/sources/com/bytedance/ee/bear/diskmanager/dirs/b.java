package com.bytedance.ee.bear.diskmanager.dirs;

import android.content.Context;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.diskmanage.storage.Storage;
import com.ss.android.lark.diskmanage.storage.c;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements UniPathProvider {

    public static final class a {
    }

    static {
    }

    public b() {
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
        int r101 = c.f420487a;
        return c.a.a(r100, "luban_disk_cache", Storage.Type.INNER_FILES, new String[0]);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(f.f440957d, new d(new String[]{ChameleonResConstants.CCM_ROOT_DIR, "luban_disk_cache"}));
    }
}
