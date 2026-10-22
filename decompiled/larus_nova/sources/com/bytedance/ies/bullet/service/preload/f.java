package com.bytedance.ies.bullet.service.preload;

import android.content.Context;
import android.net.Uri;
import android.os.MessageQueue;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebPreloadBridge f248098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f248099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f248100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f248101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ IBridgeMethod.a f248102e;

    public f(WebPreloadBridge r100, Context r101, Uri r102, long r103, IBridgeMethod.a r104) {
        this.f248098a = r100;
        this.f248099b = r101;
        this.f248100c = r102;
        this.f248101d = r103;
        this.f248102e = r104;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f248098a.e(this.f248099b, this.f248100c, this.f248101d, this.f248102e);
        return false;
    }
}
