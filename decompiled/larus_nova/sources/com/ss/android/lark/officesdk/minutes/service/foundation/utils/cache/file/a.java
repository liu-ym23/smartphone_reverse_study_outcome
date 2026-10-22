package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f434038a = null;

    static {
        VFSFiles.f444819b.getClass();
        f434038a = VFSFiles.b(true);
    }

    public static VFSFile c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        return f434038a.i(r100);
    }

    public static VFSFile a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "childPath");
        h r102 = f434038a;
        f r103 = f.f440960g;
        return r102.D(LarkFileStorage.f(r100).b(r103, new d(new String[]{DocumentType.MINUTES_NAME})).toFile(), r101);
    }

    public static VFSFile b(File r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "childPath");
        return f434038a.D(r100, r101);
    }
}
