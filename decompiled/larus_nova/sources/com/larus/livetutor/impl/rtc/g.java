package com.larus.livetutor.impl.rtc;

import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.impl.utils.ApiCallConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TutorRTCServiceImpl f356299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f356300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f356301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StartCallRequest f356302d;

    public /* synthetic */ g(TutorRTCServiceImpl r100, CoroutineScope r101, k0 r102, StartCallRequest r103) {
        this.f356299a = r100;
        this.f356300b = r101;
        this.f356301c = r102;
        this.f356302d = r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        TutorRTCServiceImpl r101 = this.f356299a;
        CoroutineScope r102 = this.f356300b;
        Function1 r103 = this.f356301c;
        StartCallRequest r104 = this.f356302d;
        ApiCallConfig r105 = (ApiCallConfig) r100;
        Intrinsics.checkNotNullParameter(r105, "$this$withApiCall");
        TutorRTCServiceImpl$connect2RTCService$1$1 r106 = new TutorRTCServiceImpl$connect2RTCService$1$1(r101, r102, r103, r104, null);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "apiCall");
        r105.f356637a = r106;
        TutorRTCServiceImpl$connect2RTCService$1$2 r107 = new TutorRTCServiceImpl$connect2RTCService$1$2(r101, null);
        Intrinsics.checkNotNullParameter(r107, "failureCallback");
        r105.f356638b = r107;
        return Unit.INSTANCE;
    }
}
