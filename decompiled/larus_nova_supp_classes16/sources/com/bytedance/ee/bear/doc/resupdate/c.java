package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static VFSFile b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r5 = ay4.c.a;
        VFSFile r6 = ay4.c.a.f(Biz.DYNAMIC, null, true, false, 10).subPath("gecko").toFile();
        if (r6.exists() == false) goto L5;
    L7:
        tt5.a.b("GeckoResConfig", "getGeckoRootPath: " + r6.getAbsolutePath());
        return r6;
    L5:
        if (r6.mkdirs() == true) goto L7;
        tt5.a.k("GeckoResConfig", "mkdir gecko Dir failed");
        goto L7
    }

    public static String a(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 == false) goto L7;
        return "ded3766bfe7bbc722fb5eb534ad4b11e";
    L7:
        if (eu5.c.b(r1) == false) goto L9;
        return "2f8feb7db4d71d6ddf02e76668896c41";
    L9:
        return "170fde123c7a011616dd5e6856ec443b";
    }
}
