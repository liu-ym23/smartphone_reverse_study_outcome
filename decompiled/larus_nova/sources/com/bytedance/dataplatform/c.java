package com.bytedance.dataplatform;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f204289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f204291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Set f204292d;

    @Override // java.lang.Runnable
    public final void run() {
        g.c(this.f204289a, this.f204290b).edit().putStringSet(this.f204291c, this.f204292d).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(Context r100, String r101, Set r102) {
        this.f204289a = r100;
        this.f204290b = "SP_EXPERIMENT_CACHE";
        this.f204291c = r101;
        this.f204292d = r102;
    }
}
