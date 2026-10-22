package com.bytedance.iesgurd;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.UpdatePackage;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f250704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpdatePackage f250705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f250706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f250707d;

    public i(j r100, UpdatePackage r101, long r102, long r103) {
        this.f250704a = r100;
        this.f250705b = r101;
        this.f250706c = r102;
        this.f250707d = r103;
    }

    public final void a() {
        Function1<k, Unit> r100 = this.f250704a.f250720m;
        if (r100 == null) goto L5;
        r100.invoke(new k(this.f250705b.getAccessKey(), this.f250705b.getChannel(), this.f250706c, this.f250707d));
    L5:
        GeckoUpdateListener r101 = this.f250704a.f250710c;
        if (r101 == null) goto L14;
        r101.onDownloadProgress(this.f250705b, this.f250706c, this.f250707d);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        GeckoLogger.w("onDownloadProgress exception: " + th.getMessage());
        return;
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
}
