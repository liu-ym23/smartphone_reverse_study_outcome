package jqb;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
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
        return new PolarisFileWrapper(r100.getExternalCacheDir(), "/lark/location/map").getAbsolutePath();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(f.f440958e, new d(new String[]{"CORE", "location/map"}));
    L5:
        VFSFiles.f444819b.getClass();
        return VFSFiles.b(false).z(a(com.larksuite.framework.utils.b.f285948a));
    }
}
