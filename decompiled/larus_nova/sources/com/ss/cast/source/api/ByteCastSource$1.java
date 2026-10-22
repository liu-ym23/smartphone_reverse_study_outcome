package com.ss.cast.source.api;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.config.IInitListener;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class ByteCastSource$1 implements IInitListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f456542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IInitListener f456543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f456544c;

    @Override // com.byted.cast.common.config.IInitListener
    public final void onFail(int r100, String r101, Exception r102) {
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onSuccess() {
        this.f456544c.f456563c.sendByteCastAuthEvent("success", -1);
        this.f456544c.f456564d.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new AnonymousClass1(this)});
        if (this.f456542a == null) goto L5;
        this.f456544c.f456564d.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH_TIME, new Map[]{new AnonymousClass2(this)});
        this.f456542a = null;
    L5:
        this.f456544c.f456563c.sendSourceEvent(CastMonitor.BYTECAST_BIND_SDK_RESULT, "true");
        Dispatcher r100 = Dispatcher.getInstance();
        final IInitListener r101 = this.f456543b;
        r100.runOnMainThread(new d(r101));
    }

    public ByteCastSource$1(i r100, IInitListener r101) {
        this.f456544c = r100;
        this.f456543b = r101;
        this.f456542a = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onError(final int r100, final String r101) {
        this.f456544c.f456563c.sendByteCastAuthEvent("fail", r100);
        this.f456544c.f456564d.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new AnonymousClass3(this, r100, r101)});
        this.f456544c.f456563c.sendSourceEvent(CastMonitor.BYTECAST_BIND_SDK_RESULT, "false");
        Dispatcher r102 = Dispatcher.getInstance();
        final IInitListener r103 = this.f456543b;
        r102.runOnMainThread(new e(r103, r100, r101));
    }
}
