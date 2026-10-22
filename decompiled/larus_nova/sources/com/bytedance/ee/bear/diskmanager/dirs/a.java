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
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a implements UniPathProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f217604a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.diskmanager.dirs.a$a, reason: collision with other inner class name */
    public static final class C3099a {
    }

    static {
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        this.f217604a = r100;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f r101 = this.f217604a;
        if (Intrinsics.areEqual(r101, f.f440957d) == false) goto L6;
        Storage.Type r102 = Storage.Type.INNER_FILES;
    L15:
        int r103 = c.f420487a;
        return c.a.a(r100, ChameleonResConstants.CCM_ROOT_DIR, r102, new String[0]);
    L6:
        if (Intrinsics.areEqual(r101, f.f440958e) == false) goto L9;
        r102 = Storage.Type.INNER_CACHE;
        goto L15
    L9:
        if (Intrinsics.areEqual(r101, f.f440960g) == false) goto L12;
        r102 = Storage.Type.FILES;
        goto L15
    L12:
        if (Intrinsics.areEqual(r101, f.f440961h) == false) goto L14;
        r102 = Storage.Type.CACHE;
        goto L15
    L14:
        r102 = Storage.Type.STORAGE_LARK;
        goto L15
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "space");
        return r100.b(this.f217604a, new d(new String[]{ChameleonResConstants.CCM_ROOT_DIR}));
    }
}
