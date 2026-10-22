package com.larus.livetutor.impl.rtc.handler;

import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.larus.livetutor.impl.rtc.api.RTCAction;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.engine.data.AudioPropertiesInfo;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.data.RemoteAudioPropertiesInfo;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.type.ConnectionState;
import com.ss.bytertc.engine.utils.LogUtil;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class x extends IRTCEngineEventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorRTCServiceImpl f356377a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f356378a = null;

        static {
            int[] r100 = new int[LogUtil.LogLevel.values().length];
            r100[LogUtil.LogLevel.LOG_LEVEL_DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LogUtil.LogLevel.LOG_LEVEL_INFO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LogUtil.LogLevel.LOG_LEVEL_WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LogUtil.LogLevel.LOG_LEVEL_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f356378a = r100;
        }
    }

    static {
    }

    public x(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        this.f356377a = r100;
    }

    @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
    public final void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] r100) {
        super.onLocalAudioPropertiesReport(r100);
        if (r100 == null) goto L23;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L13;
        LocalAudioPropertiesInfo r103 = r100[r102];
        if (r103.streamIndex != StreamIndex.STREAM_INDEX_MAIN) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L14;
        r102 = r102 + 1;
    L14:
        if (r103 == null) goto L24;
        AudioPropertiesInfo r105 = r103.audioPropertiesInfo;
        if (r105 == null) goto L25;
        int r106 = r105.linearVolume;
        w r107 = this.f356377a.i();
        r107.f356374f.tryEmit(Integer.valueOf(r106));
        Function1<? super Integer, Unit> r108 = r107.f356375g;
        if (r108 == null) goto L26;
        r108.invoke(Integer.valueOf(r106));
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r104 = false;
        goto L10
    L13:
        r103 = null;
        goto L14
    }

    @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
    public final void onConnectionStateChanged(int r100, int r101) {
        super.onConnectionStateChanged(r100, r101);
        m r102 = this.f356377a.e();
        String r103 = "onConnectionStateChanged: " + ConnectionState.fromId(r100) + ", " + r101;
        int r104 = m.f356343c;
        r102.b("TutorRTCEngineEventHandler", r103, false);
        if (r100 != ConnectionState.CONNECTION_STATE_DISCONNECTED.getValue()) goto L6;
        this.f356377a.e().a("TutorRTCEngineEventHandler", "断连重试中... reason: " + r101);
        return;
    L6:
        if (r100 != ConnectionState.CONNECTION_STATE_LOST.getValue()) goto L8;
    L9:
        this.f356377a.e().a("TutorRTCEngineEventHandler", "连接失败 reason: " + r101);
        RTCMonitor r105 = this.f356377a.f();
        RTCMonitor.Companion.ErrorType r106 = RTCMonitor.Companion.ErrorType.RTC_DISCONNECT;
        String r107 = "rtc断开 reason:" + r101;
        r105.getClass();
        JSONObject r108 = new JSONObject();
        r105.a(r108);
        if (r106 == null) goto L12;
        String r109 = r106.getValue();
    L13:
        r108.put("error_type", r109);
        r108.put("error_msg", r107);
        com.larus.platform.service.o.f365780a.reportEvent("tutor_rtc_break", r108);
        this.f356377a.h().b(new RTCAction.ConnectBreak(RTCMonitor.Companion.BusinessErrorType.RTC_USER_ERROR.getValue(), r101));
        return;
    L12:
        r109 = null;
        goto L13
    L8:
        if (r100 == ConnectionState.CONNECTION_STATE_FAILED.getValue()) goto L9;
    }

    @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
    public final void onRemoteAudioPropertiesReport(RemoteAudioPropertiesInfo[] r100, int r101) {
        this.f356377a.i().f356373e.tryEmit(Integer.valueOf(r101));
    }

    @Override // com.ss.bytertc.engine.handler.IRTCEngineEventHandler
    public final void onLoggerMessage(LogUtil.LogLevel r100, String r101, Throwable r102) {
        super.onLoggerMessage(r100, r101, r102);
        if (r100 != null) goto L5;
        int r103 = -1;
    L7:
        if (r103 != 1) goto L9;
        FLogger.f375446a.d("RTC_Engine", r101 + ' ' + r102);
        return;
    L9:
        if (r103 != 2) goto L11;
        FLogger.f375446a.i("RTC_Engine", r101 + ' ' + r102);
        return;
    L11:
        if (r103 != 3) goto L13;
        FLogger.f375446a.w("RTC_Engine", r101 + ' ' + r102);
        return;
    L13:
        if (r103 == 4) goto L15;
        FLogger.f375446a.i("RTC_Engine", r101 + ' ' + r102);
        return;
    L15:
        FLogger.f375446a.e("RTC_Engine", r101 + ' ' + r102);
        return;
    L5:
        r103 = b.f356378a[r100.ordinal()];
        goto L7
    }
}
