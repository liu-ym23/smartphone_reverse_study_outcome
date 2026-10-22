package com.larus.livetutor.impl.rtc.handler;

import com.larus.livetutor.impl.rtc.LogEntity;
import com.larus.livetutor.impl.rtc.LogStatus;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f356343c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorRTCServiceImpl f356344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<LogEntity> f356345b;

    public static final class a {
    }

    static {
    }

    public m(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        this.f356344a = r100;
        this.f356345b = SharedFlowKt.MutableSharedFlow(50, 100, BufferOverflow.DROP_OLDEST);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.e("RTCClientLog", "[" + r100 + "][" + this.f356344a.f356258w + "] " + r101);
        if (this.f356344a.f356237b == false) goto L6;
        this.f356345b.tryEmit(new LogEntity(r100, r101, LogStatus.Error));
        return;
    }

    public final void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        FLogger.f375446a.i("RTCClientLog", "[" + r100 + "][" + this.f356344a.f356258w + "] " + r101);
        if (this.f356344a.f356237b == false) goto L10;
        MutableSharedFlow<LogEntity> r103 = this.f356345b;
        if (r102 == false) goto L7;
        LogStatus r104 = LogStatus.Success;
    L8:
        r103.tryEmit(new LogEntity(r100, r101, r104));
        return;
    L7:
        r104 = LogStatus.Normal;
        goto L8
    }
}
