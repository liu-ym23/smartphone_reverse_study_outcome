package com.larus.im.internal.audio.session.omni;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AndroidOmniAudioEngine f347297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f347298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f347299c;

    public h(AndroidOmniAudioEngine r100, String r101, Function1 r102) {
        this.f347297a = r100;
        this.f347298b = r101;
        this.f347299c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        fe9.a.f476620a.e(this.f347297a.f347205d, "dispatchAudioPerformanceReport, params: " + this.f347298b);     // Catch: Throwable -> L4
        this.f347299c.invoke(this.f347298b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
