package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements UniPathProvider {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460652a = null;

        static {
            int[] r100 = new int[UniPathProvider.SpaceType.values().length];
            r100[UniPathProvider.SpaceType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[UniPathProvider.SpaceType.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f460652a = r100;
        }
    }

    static {
    }

    public l() {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        UniPathProvider.SpaceType r100 = UniPathProvider.SpaceType.USER;
        int r101 = b.f460652a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return LarkFileStorage.e();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return LarkFileStorage.b();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return com.ss.android.lark.diskmanage.storage.d.q(r100);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return com.ss.android.lark.storage.file.a.C5307a.a(r100, new com.ss.android.lark.storage.d(new String[]{"share_temp", ""}));
    }
}
