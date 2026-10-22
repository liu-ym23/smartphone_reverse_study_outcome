package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f194160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f194161b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f194162c = 0;

    public d() {
    }

    static {
        f194160a = new d();
        f194161b = ("/data/data/" + y54.a.a().getPackageName() + '/') + "small_emoji_res/";
        Resources r100 = Resources.getSystem();
        f194162c = (int) (((double) 0.5f) + (32.0d * ((double) WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density)));
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        return f194161b + r100 + File.separator;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return;
    L8:
        if (r101.isDirectory() == false) goto L25;
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L12;
        return;
    L12:
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L19;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L17;
        c(r105.getPath());
    L18:
        r104 = r104 + 1;
        goto L13
    L17:
        r105.delete();
        goto L18
    L19:
        r101.delete();
        return;
    }

    public final synchronized void a(final String... r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "whiteMd5");     // Catch: Throwable -> L21
        PolarisFileWrapper r101 = new PolarisFileWrapper(f194161b);     // Catch: Throwable -> L21
        if (r101.exists() == true) goto L6;
    L19:
        monitor-exit(this);
        return;
    L6:
        if (r101.isDirectory() == false) goto L19;
        File[] r102 = r101.listFiles(new b(r100));     // Catch: Throwable -> L21
        if (r102 == null) goto L17;
        int r103 = r102.length;     // Catch: Throwable -> L21
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L17;
        File r105 = r102[r104];     // Catch: Throwable -> L21
        if (r105.isDirectory() == false) goto L15;
        c(r105.getAbsolutePath());     // Catch: Throwable -> L21
    L16:
        r104 = r104 + 1;
        goto L11
    L15:
        r105.delete();     // Catch: Throwable -> L21
    L17:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
