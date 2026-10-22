package com.larus.livetutor.impl.rtc.handler;

import android.os.Handler;
import android.os.Looper;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import com.larus.livetutor.impl.rtc.api.RTCServiceStatus;
import com.larus.livetutor.impl.utils.UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorRTCServiceImpl f356362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RTCServiceStatus f356363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f356364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<RTCAction> f356365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f356366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.livetutor.impl.rtc.api.a f356367f;

    public static final class a extends RTCServiceStatus.Connected {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ij9.a f356368a;

        @Override // com.larus.livetutor.impl.rtc.api.RTCServiceStatus.Connected
        public final ij9.a getBusinessState() {
            return this.f356368a;
        }

        public a(ij9.a r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f356368a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public final b1 a() {
        return kotlinx.coroutines.flow.e.b(this.f356364c);
    }

    public v(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        this.f356362a = r100;
        RTCServiceStatus.Initial r101 = RTCServiceStatus.Initial.INSTANCE;
        this.f356363b = r101;
        this.f356364c = j1.a(r101);
        this.f356365d = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.f356366e = new Handler(Looper.getMainLooper());
        this.f356367f = new com.larus.livetutor.impl.rtc.adpter.a();
    }

    public static String d(RTCServiceStatus r100) {
        if ((r100 instanceof RTCServiceStatus.Connected) == false) goto L6;
        return UtilsKt.t(((RTCServiceStatus.Connected) r100).getBusinessState());
    L6:
        return UtilsKt.t(r100);
    }

    public final void b(final RTCAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f356366e.post(new u(this, r100));
    }

    public final void c(com.larus.livetutor.impl.rtc.adpter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f356367f = r100;
    }
}
