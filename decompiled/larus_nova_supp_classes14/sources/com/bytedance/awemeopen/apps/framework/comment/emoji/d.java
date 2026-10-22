package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final d a = null;
    public static final String b = null;
    public static final int c = 0;

    public d() {
    }

    static {
        a = new d();
        b = ("/data/data/" + y54.a.a().getPackageName() + '/') + "small_emoji_res/";
        Resources r2 = Resources.getSystem();
        c = (int) (((double) 0.5f) + (32.0d * ((double) WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density)));
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        return b + r2 + File.separator;
    }

    public static void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "path");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isDirectory() == false) goto L25;
        File[] r6 = r0.listFiles();
        if (r6 != null) goto L12;
        return;
    L12:
        int r1 = r6.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L19;
        File r3 = r6[r2];
        if (r3.isDirectory() == false) goto L17;
        c(r3.getPath());
    L18:
        r2 = r2 + 1;
        goto L13
    L17:
        r3.delete();
        goto L18
    L19:
        r0.delete();
        return;
    }

    public final synchronized void a(final String... r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "whiteMd5");     // Catch: Throwable -> L21
        PolarisFileWrapper r0 = new PolarisFileWrapper(b);     // Catch: Throwable -> L21
        if (r0.exists() == true) goto L6;
    L19:
        monitor-exit(this);
        return;
    L6:
        if (r0.isDirectory() == false) goto L19;
        File[] r6 = r0.listFiles(new b(r5));     // Catch: Throwable -> L21
        if (r6 == null) goto L17;
        int r1 = r6.length;     // Catch: Throwable -> L21
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L17;
        File r3 = r6[r2];     // Catch: Throwable -> L21
        if (r3.isDirectory() == false) goto L15;
        c(r3.getAbsolutePath());     // Catch: Throwable -> L21
    L16:
        r2 = r2 + 1;
        goto L11
    L15:
        r3.delete();     // Catch: Throwable -> L21
    L17:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
