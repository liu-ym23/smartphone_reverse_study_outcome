package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final class n1 extends IExternalVideoEncoderEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f349968a;

    @Override // com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler
    public final void onActiveVideoLayer(StreamIndex r100, int r101, boolean r102) {
    }

    public n1(m1 r100) {
        this.f349968a = r100;
    }

    @Override // com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler
    public final void onStart(StreamIndex r100) {
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler, onStart index: " + r100);
    }

    @Override // com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler
    public final void onStop(StreamIndex r100) {
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler, onStop index: " + r100);
    }

    @Override // com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler
    public final void onRequestKeyFrame(StreamIndex r100, int r101) {
        Function0<Unit> r102 = this.f349968a.f349951d;
        if (r102 != null) goto L5;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler onRequestKeyFrame ignored: callback unavailable, streamIndex=" + r100 + ", videoIndex=" + r101);
        return;
    L5:
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler onRequestKeyFrame, streamIndex=" + r100 + ", videoIndex=" + r101);
        r102.invoke();
    }

    @Override // com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler
    public final void onRateUpdate(StreamIndex r100, int r110, int r111, int r112) {
        Function1<? super Long, Unit> r101 = this.f349968a.f349952e;
        if (r101 != null) goto L6;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler onRateUpdate ignored: callback unavailable, streamIndex=" + r100 + ", videoIndex=" + r110 + ", bitrateKbps=" + r112);
        return;
    L6:
        if (r112 >= 0) goto L9;
        fe9.a.f476620a.f("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler onRateUpdate ignored: invalid bitrate, streamIndex=" + r100 + ", videoIndex=" + r110 + ", bitrateKbps=" + r112);
        return;
    L9:
        long r102 = ((long) r112) * 1000;
        fe9.a.f476620a.e("FlowRTCVideoServiceImpl", "IExternalVideoEncoderEventHandler onRateUpdate, streamIndex=" + r100 + ", videoIndex=" + r110 + ", fps=" + r111 + ", targetBitrateBps=" + r102);
        r101.invoke(Long.valueOf(r102));
    }
}
