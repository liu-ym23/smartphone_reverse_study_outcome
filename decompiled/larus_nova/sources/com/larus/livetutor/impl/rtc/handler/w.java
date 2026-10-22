package com.larus.livetutor.impl.rtc.handler;

import com.larus.livetutor.api.idl.SubtitleMsg;
import com.larus.livetutor.api.idl.UploadDataMsg;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.livetutor.impl.rtc.interfaces.RTCNetworkQuality;
import com.larus.livetutor.impl.rtc.interfaces.SubtitleStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes30.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableSharedFlow<String> f356369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<UploadDataMsg> f356370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<SubtitleMsg> f356371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<SubtitleStream> f356372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f356373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f356374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Integer, Unit> f356375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableSharedFlow<RTCNetworkQuality> f356376h;

    public w(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        BufferOverflow r101 = BufferOverflow.DROP_OLDEST;
        this.f356369a = SharedFlowKt.MutableSharedFlow(20, 50, r101);
        this.f356370b = SharedFlowKt.MutableSharedFlow(20, 50, r101);
        this.f356371c = SharedFlowKt.MutableSharedFlow(20, 50, r101);
        this.f356372d = SharedFlowKt.MutableSharedFlow(20, 50, r101);
        this.f356373e = SharedFlowKt.MutableSharedFlow(20, 50, r101);
        this.f356374f = SharedFlowKt.MutableSharedFlow(1, 0, r101);
        this.f356376h = SharedFlowKt.MutableSharedFlow(20, 50, r101);
    }
}
