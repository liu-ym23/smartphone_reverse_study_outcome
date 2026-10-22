package com.ss.android.lark.storage.kv.repo;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public interface e {

    public static final class a {
        public static void a(e r100, Context r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "spaceName");
            PolarisFileWrapper r103 = new PolarisFileWrapper(r100.a(r101));
            if (r103.exists() == true) goto L5;
            return;
        L5:
            if (r103.isDirectory() == false) goto L20;
            File[] r104 = r103.listFiles();
            if (r104 != null) goto L9;
            r104 = new File[0];
        L9:
            int r105 = r104.length;
            int r106 = 0;
        L10:
            if (r106 >= r105) goto L21;
            File r107 = r104[r106];
            String r108 = r107.getName();
            Intrinsics.checkNotNull(r108);
            if (StringsKt.contains$default(r108, r102 + '.', false, 2, null) == false) goto L15;
            o6c.a.delete(r107);
        L15:
            r106 = r106 + 1;
            goto L10
        L21:
            return;
        }
    }

    String a(Context r100);

    KVRepo b(Context r100, String r101, com.ss.android.lark.storage.a r102, String r103, KVRepoConfig.Mode r104);

    void c(Context r100, String r101);
}
