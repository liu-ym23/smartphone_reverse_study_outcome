package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f218003a = 0;

    static {
    }

    public static VFSFile b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = ay4.c.f16749a;
        VFSFile r102 = ay4.c.a.f(Biz.DYNAMIC, null, true, false, 10).subPath("gecko").toFile();
        if (r102.exists() == false) goto L5;
    L7:
        tt5.a.b("GeckoResConfig", "getGeckoRootPath: " + r102.getAbsolutePath());
        return r102;
    L5:
        if (r102.mkdirs() == true) goto L7;
        tt5.a.k("GeckoResConfig", "mkdir gecko Dir failed");
        goto L7
    }

    public static String a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == false) goto L7;
        return "ded3766bfe7bbc722fb5eb534ad4b11e";
    L7:
        if (eu5.c.b(r100) == false) goto L9;
        return "2f8feb7db4d71d6ddf02e76668896c41";
    L9:
        return "170fde123c7a011616dd5e6856ec443b";
    }
}
