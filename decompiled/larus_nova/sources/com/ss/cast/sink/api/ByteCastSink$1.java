package com.ss.cast.sink.api;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.config.IInitListener;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class ByteCastSink$1 implements IInitListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f456420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IInitListener f456421b;

    @Override // com.byted.cast.common.config.IInitListener
    public final void onFail(int r100, String r101, Exception r102) {
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onSuccess() {
        ContextManager.getMonitor(null).sendByteCastAuthEvent("success", -1);
        ContextManager.getMonitor(null).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_RESULT, "true");
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new AnonymousClass1(this)});
        if (this.f456420a == null) goto L5;
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH_TIME, new Map[]{new AnonymousClass2(this)});
        this.f456420a = null;
    L5:
        Dispatcher r100 = Dispatcher.getInstance();
        final IInitListener r101 = this.f456421b;
        r100.runOnMainThread(new e(r101));
    }

    public ByteCastSink$1(IInitListener r100) {
        this.f456421b = r100;
        this.f456420a = Long.valueOf(System.currentTimeMillis());
    }

    @Override // com.byted.cast.common.config.IInitListener
    public final void onError(final int r100, final String r101) {
        ContextManager.getMonitor(null).sendByteCastAuthEvent("fail", r100);
        ContextManager.getMonitor(null).sendSinkEvent(CastMonitor.BYTECAST_BIND_SDK_RESULT, "false");
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new AnonymousClass3(this, r100, r101)});
        Dispatcher r102 = Dispatcher.getInstance();
        final IInitListener r103 = this.f456421b;
        r102.runOnMainThread(new f(r103, r100, r101));
    }
}
