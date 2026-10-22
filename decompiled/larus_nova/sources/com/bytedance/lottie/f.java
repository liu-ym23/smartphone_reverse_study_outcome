package com.bytedance.lottie;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements Callable<o<d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f264443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f264444b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public o<d> call() {
        Context r100 = this.f264443a;
        String r101 = this.f264444b;
        Map<String, q<d>> r102 = e.f264439a;
        String r103 = "asset_" + r101;     // Catch: IOException -> L13
        if (r101.endsWith(".zip") == false) goto L20;
        ZipInputStream r104 = new ZipInputStream(r100.getAssets().open(r101));     // Catch: IOException -> L13
        o<d> r105 = e.d(r104, r103);     // Catch: Throwable -> L8
        wz6.h.c(r104);     // Catch: IOException -> L13
        return r105;
    L8:
        th = move-exception;
        wz6.h.c(r104);     // Catch: IOException -> L13
        throw th;     // Catch: IOException -> L13
    L20:
        return e.b(r100.getAssets().open(r101), r103, true);
    L13:
        e = move-exception;
        return new o(e);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ o<d> call() throws Exception {
        return call();
    }

    public f(Context r100, String r101) {
        this.f264443a = r100;
        this.f264444b = r101;
    }
}
