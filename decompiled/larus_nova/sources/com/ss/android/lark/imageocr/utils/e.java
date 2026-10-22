package com.ss.android.lark.imageocr.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.vesdk.algorithm.VEBachSceneRecognitionResult;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ llb.b f426579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VEBachSceneRecognitionResult f426580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f426581c;

    public e(llb.b r100, VEBachSceneRecognitionResult r101, float r102) {
        this.f426579a = r100;
        this.f426580b = r101;
        this.f426581c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f426579a.a(true, false, this.f426580b.getProb(), this.f426581c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
