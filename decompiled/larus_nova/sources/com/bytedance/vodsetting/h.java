package com.bytedance.vodsetting;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f272571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsManager f272572b;

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    L3:
        if ((this.f272571a & 8) <= 0) goto L5;
        this.f272572b.a("common");     // Catch: Throwable -> L12
    L5:
        int r100 = 0;
    L6:
        SettingsManager r101 = this.f272572b;     // Catch: Throwable -> L12
        SettingsManager.ModuleItem[] r102 = r101.f272546m;     // Catch: Throwable -> L12
        if (r100 >= r102.length) goto L22;
        int r103 = this.f272571a;     // Catch: Throwable -> L12
        SettingsManager.ModuleItem r104 = r102[r100];     // Catch: Throwable -> L12
        if ((r103 & r104.intValue) <= 0) goto L11;
        r101.a(r104.stringValue);     // Catch: Throwable -> L12
    L11:
        r100 = r100 + 1;
        goto L6
    }

    public h(SettingsManager r100) {
        this.f272572b = r100;
        this.f272571a = 2;
    }
}
