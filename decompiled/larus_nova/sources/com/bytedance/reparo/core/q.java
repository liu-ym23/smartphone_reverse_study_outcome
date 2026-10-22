package com.bytedance.reparo.core;

import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WandTrick f267424a;

    public final void a() {
        WandTrick r100 = this.f267424a;
        boolean r101 = r100.f267321e;
        if (r101 == true) goto L28;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.f267319c.getCacheDir(), "oat_primary");
        if (r102.exists() == false) goto L26;
        File[] r103 = r102.listFiles();
        if (r103 == null) goto L26;
        int r104 = r103.length;
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L26;
        File[] r106 = r103[r105].listFiles();
        if (r106 == null) goto L25;
        int r107 = r106.length;
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L25;
        File r109 = r106[r108];
        if (r109.getName().endsWith(Dex2OatHelper.ART_SUFFIX) == true) goto L24;
        if (r109.getName().endsWith(DefaultDiskStorage.FileType.TEMP) == true) goto L24;
        r108 = r108 + 1;
    L24:
        r101 = true;
    L27:
        r100.f267321e = r101;
    L25:
        r105 = r105 + 1;
    L26:
        r101 = false;
    L28:
        if (r101 == false) goto L31;
        r100.markImageGenerateFinished();
        return;
    L31:
        if (r100.f267322f != (-1)) goto L53;
        Object r110 = r100.f267323g;
        monitor-enter(r110);
    L42:
        th = move-exception;
        throw th;
    L35:
        if (r100.f267322f == (-1)) goto L37;
    L40:
        monitor-exit(r110);     // Catch: Throwable -> L42
        return;
    L37:
        if (r100.nativeHasAppImageFor(r100.f267319c.getPackageName()) == false) goto L39;
        r100.markImageGenerateFinished();     // Catch: Throwable -> L42
        r100.f267322f = 1;     // Catch: Throwable -> L42
        goto L40
    L39:
        r100.f267322f = 0;     // Catch: Throwable -> L42
        goto L40
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(WandTrick r100) {
        this.f267424a = r100;
    }
}
