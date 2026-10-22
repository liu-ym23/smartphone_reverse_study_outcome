package com.ss.android.lark.security.compliance.infra.storage;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f440474a = null;

    public d() {
    }

    static {
        f440474a = new com.ss.android.lark.storage.a("security_compliance");
    }

    public static com.ss.android.lark.storage.kv.repo.a a(String r100) {
        Intrinsics.checkNotNullParameter("common", "repoName");
        Intrinsics.checkNotNullParameter(r100, "userId");
        LarkAppContext.Companion.getClass();
        return LarkKVStorage.n(LarkAppContext.access$getInstance$cp().getContext(), r100, f440474a, "common", null);
    }

    public static VFSPath c(f r100) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        Intrinsics.checkNotNullParameter("screen_shot_images", "filename");
        String r101 = "";
        if ("".length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        String r103 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getUserId();
        if (r103 == null) goto L11;
        r101 = r103;
    L11:
        FileStorage r104 = LarkFileStorage.f(r101);
        com.ss.android.lark.storage.a r105 = f440474a;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter("screen_shot_images", "name");
        return r104.b(r100, new com.ss.android.lark.storage.d(r105, "screen_shot_images"));
    L5:
        r102 = false;
        goto L6
    }

    public static com.ss.android.lark.storage.kv.repo.a b(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "common";
    L5:
        Intrinsics.checkNotNullParameter(r100, "repoName");
        return LarkKVStorage.p(f440474a, r100, false);
    }
}
