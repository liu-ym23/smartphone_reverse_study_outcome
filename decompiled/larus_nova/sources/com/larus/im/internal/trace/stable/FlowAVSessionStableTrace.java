package com.larus.im.internal.trace.stable;

import android.os.SystemClock;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.internal.audio.v;
import com.larus.im.internal.rtcsdk.MessageSendErrorCode;
import com.larus.im.internal.rtcsdk.impl.trace.FlowRTCAVPlayerTracer;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import com.larus.im.internal.trace.manager.definition.AVConditionType;
import com.larus.im.internal.trace.manager.definition.AVMediaDeviceError;
import com.larus.im.internal.trace.manager.definition.AVSessionState;
import com.larus.im.internal.trace.manager.definition.AVTraceModalType;
import com.larus.im.internal.trace.model.FlowAVConnectionPeriod;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.cmd.TargetVideoSourceType;
import com.larus.im.service.audio.z0;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import ouc.d0;
import pf9.a0;
import pf9.c0;
import pf9.e0;
import pf9.f0;
import pf9.z;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowAVSessionStableTrace implements rf9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kf9.a f350165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kf9.e f350166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerTraceMediaSessionListener f350167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f350168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f350169e;

    public final class InnerTraceMediaSessionListener extends a1 implements kd9.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f350170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlowRTCAVPlayerTracer f350171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final kf9.b f350172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FlowAVSessionStableTrace f350173d;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f350170a;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.im.internal.trace.stable.o] */
        /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.im.internal.trace.stable.p] */
        public InnerTraceMediaSessionListener(final FlowAVSessionStableTrace r100) {
            this.f350173d = r100;
            this.f350170a = "FlowAVSessionStableTrace";
            this.f350171b = new FlowRTCAVPlayerTracer(new o(r100));
            this.f350172c = new kf9.b(SetsKt.setOf(new AVConditionType[]{AVConditionType.ReplyEndEvent, AVConditionType.PlayerStop}), new p(r100, this));
            fe9.a r101 = fe9.a.f476620a;
            r101.e("FlowAVSessionStableTrace", "init start");
            kf9.e r102 = r100.f350166b;
            r102.f503273i = new q(this);
            r102.f503274j = new r(this);
            r101.e("FlowAVSessionStableTrace", "init start");
        }

        @Override // kd9.s
        public final void b(d0 r100) {
            FlowRTCAVPlayerTracer r101 = this.f350171b;
            String r102 = "";
            if (r100 == null) goto L5;
            String r103 = sf9.a.c(r100, "end_type", "");
        L6:
            if (r103 == null) goto L9;
            r102 = r103;
        L9:
            r101.a(r102);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // kd9.s
        public final void c(com.larus.im.internal.rtcsdk.impl.trace.b r110) {
            boolean r100 = false;
            if (r110 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L24;
            int r102 = com.larus.im.internal.trace.stable.a.f350183a;
            kf9.e r103 = this.f350173d.f350166b;
            Intrinsics.checkNotNullParameter(r110, "trace");
            Intrinsics.checkNotNullParameter(r103, "traceContext");
            Long r104 = Long.valueOf(r110.f());
            if (r104.longValue() <= 0) goto L12;
            boolean r105 = true;
        L13:
            if (r105 == true) goto L16;
            r104 = null;
        L16:
            if (r104 == null) goto L18;
            long r106 = r104.longValue();
        L19:
            r103.f503269e.B = r110.getReceiveTime();
            kf9.d r107 = r103.f503269e;
            r107.C = r106;
            r107.D = r110.c();
            r103.f503269e.G = kf9.f.a(r110.getReceiveTime(), r106, "audio_first_process_duration");
            kf9.d r108 = r103.f503269e;
            if (r108.f503244f != (-1)) goto L23;
            r108.f503244f = kf9.f.a(r108.f503262x, r108.B, "first_audio_link_trans_duration");
        L23:
            com.larus.im.internal.trace.stable.a.a(r103);
            r103.f503269e.H = true;
            AVEventReporter r109 = AVEventReporter.f350163a;
            kf9.e r111 = this.f350173d.f350166b;
            Intrinsics.checkNotNullParameter(r111, "traceContext");
            r109.e(r111);
            r109.f(this.f350173d.f350166b);
            goto L24
        L18:
            r106 = r110.c();
            goto L19
        L12:
            r105 = false;
        L24:
            FlowRTCAVPlayerTracer r112 = this.f350171b;
            if (r110 == null) goto L29;
            r112.getClass();
            if (r110.d() != true) goto L29;
            boolean r113 = true;
        L30:
            if (r113 == false) goto L34;
            FlowRTCAVPlayerTracer.c r114 = r112.f349996b;
            if (r114 == null) goto L34;
            r114.f350005d = true;
            r114.f350006e = kf9.f.a(r110.getReceiveTime(), r110.c(), "first_frame_delay");
            r114.f350007f = r110.c();
            r114.f350010i = r110.g();
            r114.f350008g = r110.b() - r110.getReceiveTime();
            r114.f350009h = (int) (r110.a() - r110.b());
        L34:
            FlowRTCAVPlayerTracer.c r115 = r112.f349996b;
            if (r115 == null) goto L46;
            if (r110 != null) goto L38;
        L40:
            if (r100 == true) goto L42;
        L44:
            r115.f350012k += 10;
            return;
        L42:
            if (r115.f350013l >= 0) goto L44;
            r115.f350013l = r115.f350012k;
            goto L44
        L38:
            if (r110.e() != true) goto L40;
            r100 = true;
            goto L40
        L46:
            return;
        L29:
            r113 = false;
            goto L30
        L5:
            if (r110.d() != true) goto L7;
            r101 = true;
            goto L8
        }

        @Override // kd9.s
        public final void d(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "traceInfo");
            FlowRTCAVPlayerTracer r101 = this.f350171b;
            String r102 = sf9.a.c(r100, BdpAppEventConstant.PARAMS_UNIQUEID, "");
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter("query_round", "key");
            long r103 = 0;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
            ouc.i r105 = (ouc.i) r100.get("query_round");     // Catch: Throwable -> L13
            if (r105 == null) goto L10;
            String r106 = ouc.k.o(r105).a();     // Catch: Throwable -> L13
            if (r106 == null) goto L10;
            Long r107 = StringsKt.toLongOrNull(r106);     // Catch: Throwable -> L13
            if (r107 == null) goto L10;
            long r108 = r107.longValue();     // Catch: Throwable -> L13
        L11:
            Object r109 = Result.m9449constructorimpl(Long.valueOf(r108));     // Catch: Throwable -> L13
        L15:
            String r110 = null;
            if (Result.m9455isFailureimpl(r109) == false) goto L18;
            r109 = null;
        L18:
            Long r111 = (Long) r109;
            if (r111 == null) goto L21;
            r103 = r111.longValue();
        L21:
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "uniqueId");
            FlowRTCAVPlayerTracer.c r112 = r101.f349996b;
            if (r112 == null) goto L25;
            r110 = r112.f350002a;
        L25:
            if (Intrinsics.areEqual(r110, r102) == true) goto L27;
            r101.a("others");
            r101.f349996b = new FlowRTCAVPlayerTracer.c(r102, r103);
            return;
        L27:
            fe9.a.f476620a.a("FlowRTCAVPlayerTracer", "prepareTraceRound: duplicate call, ignored");
            return;
        L10:
            r108 = 0;
        L13:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // kd9.s
        public final void e(Integer r100) {
            FlowRTCAVPlayerTracer r101 = this.f350171b;
            r101.getClass();
            if (r100 == null) goto L8;
            r100.intValue();
            FlowRTCAVPlayerTracer.c r102 = r101.f349996b;
            if (r102 == null) goto L9;
            r102.f350011j += r100.intValue();
            return;
        L9:
            return;
        }

        @Override // kd9.s
        public final void f(d0 r100) {
            String r101 = "";
            if (r100 == null) goto L5;
            String r102 = sf9.a.c(r100, "end_type", "");
        L6:
            if (r102 == null) goto L10;
            r101 = r102;
        L10:
            switch(r101.hashCode()) {
                case -1244579820: goto L24;
                case -1117994381: goto L21;
                case 401718566: goto L17;
                case 1825905391: goto L13;
                default: goto L32;
            };
        L32:
            AVCommonError r103 = null;
        L28:
            if (r103 == null) goto L30;
            this.f350173d.f350166b.f503272h = r103;
        L30:
            CoroutineScope r104 = FlowAVTraceTimer.f350182a;
            FlowAVTraceTimer.a(new FlowAVSessionStableTrace$InnerTraceMediaSessionListener$onRealStop$1(this, r103, null));
            this.f350171b.a(r101);
            return;
        L13:
            if (r101.equals("client_interrupt") == false) goto L33;
            r103 = AVCommonError.Client_Interrupt;
            goto L28
        L33:
            r103 = null;
            goto L28
        L17:
            if (r101.equals("scene_switched") == false) goto L34;
            r103 = AVCommonError.Scene_Switched;
            goto L28
        L34:
            r103 = null;
            goto L28
        L21:
            if (r101.equals("image_triggered") == true) goto L26;
            r103 = null;
        L26:
            r103 = AVCommonError.Image_Triggered;
            goto L28
        L24:
            if (r101.equals("trigger_image") == true) goto L26;
            r103 = null;
            goto L28
        L5:
            r102 = null;
            goto L6
        }

        @Override // kd9.s
        public final void h(boolean r100) {
            FlowRTCAVPlayerTracer.c r101 = this.f350171b.f349996b;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.f350005d == false) goto L18;
            r101.f350004c++;
            FlowRTCAVPlayerTracer.b r102 = r101.f350016o;
            if (r102 != null) goto L10;
        L11:
            r102 = new FlowRTCAVPlayerTracer.b(r101.f350012k, 6);
            r101.f350016o = r102;
            if (r100 == false) goto L14;
            r102.f349999c = 1;
        L14:
            ((ArrayList) r101.f350014m).add(r102);
        L15:
            r102.f349998b++;
            return;
        L10:
            if (r102.f349997a == r101.f350012k) goto L15;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            AVSessionState.Companion.getClass();
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof pf9.o) == false) goto L6;
            AVSessionState r101 = AVSessionState.Connected;
        L25:
            if (r101 == AVSessionState.QueryBegin) goto L27;
        L30:
            int r102 = com.larus.im.internal.trace.stable.a.f350183a;
            com.larus.im.internal.trace.stable.a.b(r100, this.f350173d.f350166b);
            if (r101 != null) goto L34;
            return;
        L34:
            if (r101 != AVSessionState.ReplyEnd) goto L37;
            kf9.b.a(this.f350172c, AVConditionType.ReplyEndEvent, false, 6);
            return;
        L37:
            r(r101);
            return;
        L27:
            if (this.f350173d.f350166b.f503279o.isInterruptible() == false) goto L30;
            AVEventReporter r103 = AVEventReporter.f350163a;
            kf9.e r104 = this.f350173d.f350166b;
            r103.d(r104.f503279o, r104, AVCommonError.Interrupt);
            int r105 = com.larus.im.internal.trace.stable.a.f350183a;
            com.larus.im.internal.trace.stable.a.b(r100, this.f350173d.f350166b);
            r103.c(r101, this.f350173d.f350166b, null);
            this.f350173d.f350166b.a(r101);
            return;
        L6:
            if ((r100 instanceof z) == false) goto L9;
            r101 = AVSessionState.QueryBegin;
            goto L25
        L9:
            if ((r100 instanceof c0) == false) goto L12;
            r101 = AVSessionState.QueryUpdate;
            goto L25
        L12:
            if ((r100 instanceof a0) == false) goto L15;
            r101 = AVSessionState.QueryEnd;
            goto L25
        L15:
            if ((r100 instanceof pf9.d0) == false) goto L18;
            r101 = AVSessionState.ReplyBegin;
            goto L25
        L18:
            if ((r100 instanceof f0) == false) goto L21;
            r101 = AVSessionState.ReplyUpdate;
            goto L25
        L21:
            if ((r100 instanceof e0) == false) goto L23;
            r101 = AVSessionState.ReplyEnd;
            goto L25
        L23:
            r101 = null;
            goto L25
        }

        public final void r(AVSessionState r100) {
            AVSessionState r101 = this.f350173d.f350166b.f503279o;
            AVSessionState r102 = null;
            if (r101.allowedNextStates().contains(r100) == false) goto L11;
            kf9.e r103 = this.f350173d.f350166b;
            AVCommonError r104 = r103.f503272h;
            if (r104 == null) goto L7;
            r103.f503272h = null;
            AVSessionState r105 = AVEventReporter.f350163a.d(r101, r103, r104);
        L8:
            if (r105 == null) goto L10;
            if (r105 != r100) goto L10;
        L30:
            this.f350173d.f350166b.a(r100);
            return;
        L10:
            AVEventReporter.f350163a.c(r100, this.f350173d.f350166b, null);
            goto L30
        L7:
            r105 = null;
            goto L8
        L11:
            AVSessionState.Companion.getClass();
            Intrinsics.checkNotNullParameter(r101, "fromState");
            Intrinsics.checkNotNullParameter(r100, "toState");
            if (r101 != AVSessionState.QueryBegin) goto L16;
            if (r100 != AVSessionState.QueryEnd) goto L16;
        L19:
            boolean r106 = true;
        L21:
            if (r106 == false) goto L24;
            AVEventReporter.f350163a.c(r100, this.f350173d.f350166b, AVCommonError.No_Content);
            goto L30
        L24:
            if (r101 == AVSessionState.Timeout) goto L30;
            kf9.e r107 = this.f350173d.f350166b;
            AVCommonError r108 = r107.f503272h;
            if (r108 == null) goto L28;
            r107.f503272h = null;
            r102 = AVEventReporter.f350163a.d(r101, r107, r108);
        L28:
            if (r102 == null) goto L30;
            AVEventReporter.f350163a.c(r100, this.f350173d.f350166b, AVCommonError.Unexpected_Stage);
        L16:
            if (r101 == AVSessionState.ReplyBegin) goto L18;
        L20:
            r106 = false;
            goto L21
        L18:
            if (r100 != AVSessionState.ReplyEnd) goto L20;
            goto L19
        }

        @Override // kd9.s
        public final void a(long r100, long r101) {
            kf9.e r102 = this.f350173d.f350166b;
            kf9.d r103 = r102.f503269e;
            r103.E = r100;
            r103.F = r101;
            AVEventReporter.f350163a.f(r102);
        }

        @Override // com.larus.im.service.audio.a1
        public final void q(String r110, Object r111) {
            Intrinsics.checkNotNullParameter(r110, "event");
            AVCommonError r100 = null;
            if (Intrinsics.areEqual(r110, "OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L9;
            kf9.a r101 = this.f350173d.f350165a;
            if ((r111 instanceof String) == false) goto L7;
            String r102 = (String) r111;
        L8:
            r101.f503198b = r102;
            goto L9
        L7:
            r102 = null;
        L9:
            int r103 = com.larus.im.internal.trace.stable.a.f350183a;
            kf9.e r104 = this.f350173d.f350166b;
            Intrinsics.checkNotNullParameter(r110, "event");
            Intrinsics.checkNotNullParameter(r104, "traceContext");
            if (Intrinsics.areEqual(r110, "OTHER_EVENT_RTC_AUDIO_DEVICE_RENDER_ERROR") == false) goto L79;
            if ((r111 instanceof String) == false) goto L14;
            String r112 = (String) r111;
        L15:
            d0 r113 = sf9.a.f(r112);
            Integer r114 = Integer.valueOf(sf9.a.b(r113, "device_error", 0));
            if (r114 != null) goto L19;
        L21:
            if (r114 != null) goto L24;
        L26:
            if (r114 != null) goto L29;
        L31:
            if (r114 != null) goto L34;
        L36:
            if (r114 != null) goto L39;
        L41:
            if (r114 != null) goto L44;
        L46:
            if (r114 != null) goto L49;
        L51:
            AVMediaDeviceError r115 = null;
        L52:
            boolean r105 = sf9.a.a(r113, "is_video", false);
            boolean r106 = sf9.a.a(r113, "is_audio", false);
            Integer r116 = Integer.valueOf(sf9.a.b(r113, "device_type", 0));
            if (r116 == null) goto L75;
            if (r106 == true) goto L57;
            if (r105 == false) goto L75;
            if (r116.intValue() != 0) goto L70;
            r100 = AVCommonError.Video_Render_Error;
            goto L75
        L70:
            if (r116.intValue() != 1) goto L73;
            r100 = AVCommonError.Video_Capture_Error;
            goto L75
        L73:
            if (r116.intValue() != 2) goto L75;
            r100 = AVCommonError.Video_Screen_Capture_Error;
            goto L75
        L57:
            if (r116.intValue() != 0) goto L60;
            r100 = AVCommonError.Audio_Render_Error;
            goto L75
        L60:
            if (r116.intValue() != 1) goto L63;
            r100 = AVCommonError.Audio_Capture_Error;
            goto L75
        L63:
            if (r116.intValue() != 2) goto L75;
            r100 = AVCommonError.Audio_Screen_Capture_Error;
        L75:
            if (r100 == null) goto L86;
            if (r115 == null) goto L87;
            kf9.a r117 = r104.f503267c;
            r117.f503209m = r100;
            r117.f503210n = r115;
            r117.f503208l++;
            return;
        L87:
            return;
        L86:
            return;
        L49:
            if (r114.intValue() != 7) goto L51;
            r115 = AVMediaDeviceError.UNSUPPORTFORMAT;
            goto L52
        L44:
            if (r114.intValue() != 6) goto L46;
            r115 = AVMediaDeviceError.DEVICENOCALLBACK;
            goto L52
        L39:
            if (r114.intValue() != 5) goto L41;
            r115 = AVMediaDeviceError.DEVICEDISCONNECTED;
            goto L52
        L34:
            if (r114.intValue() != 4) goto L36;
            r115 = AVMediaDeviceError.DEVICENOTFOUND;
            goto L52
        L29:
            if (r114.intValue() != 3) goto L31;
            r115 = AVMediaDeviceError.DEVICEFAILURE;
            goto L52
        L24:
            if (r114.intValue() != 2) goto L26;
            r115 = AVMediaDeviceError.DEVICEBUSY;
            goto L52
        L19:
            if (r114.intValue() != 1) goto L21;
            r115 = AVMediaDeviceError.NOPERMISSION;
            goto L52
        L14:
            r112 = null;
            goto L15
        L79:
            if (Intrinsics.areEqual(r110, "OTHER_EVENT_RTC_AUDIO_PUBLISH_FAILED") == true) goto L81;
            return;
        L81:
            if ((r111 instanceof String) == false) goto L83;
            String r118 = (String) r111;
        L84:
            d0 r119 = sf9.a.f(r118);
            AVEventReporter r120 = AVEventReporter.f350163a;
            final Integer r121 = Integer.valueOf(sf9.a.b(r119, "error_code", 0));
            Intrinsics.checkNotNullParameter(r104, "traceContext");
            Intrinsics.checkNotNullParameter("audio_publish", "name");
            Map r122 = AVEventReporter.a(r120, r104, null, null, new com.larus.im.internal.trace.stable.d(r121), 3);
            CoroutineScope r123 = FlowAVTraceTimer.f350182a;
            FlowAVTraceTimer.a(new AVEventReporter$reportErrorEvent$1(r122, null));
            return;
        L83:
            r118 = null;
            goto L84
        }
    }

    public static final class a {
    }

    public final class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowAVSessionStableTrace f350174a;

        @Override // com.larus.im.internal.audio.v
        public final int L2() {
            return 100;
        }

        @Override // com.larus.im.service.audio.v
        public final String getName() {
            return "FlowAVSessionStableTrace";
        }

        public b(FlowAVSessionStableTrace r100) {
            this.f350174a = r100;
        }

        @Override // com.larus.im.service.audio.v
        public final void O1(jd9.c r110, jd9.c r111) {
            Intrinsics.checkNotNullParameter(r110, "oldState");
            Intrinsics.checkNotNullParameter(r111, "newState");
            FlowAVSessionStableTrace r100 = this.f350174a;
            r100.getClass();
            String r101 = null;
            if ((r111 instanceof jd9.c.d) == false) goto L5;
            jd9.c.d r112 = (jd9.c.d) r111;
        L6:
            if (r112 != null) goto L9;
            return;
        L9:
            if ((r110 instanceof jd9.c.a) == false) goto L11;
            jd9.c.a r113 = (jd9.c.a) r110;
        L12:
            boolean r102 = false;
            if (r113 != null) goto L15;
        L17:
            boolean r114 = false;
        L19:
            if (r100.f350166b.f503279o == AVSessionState.Start) goto L21;
            boolean r103 = true;
        L22:
            if (r114 == true) goto L26;
            if (r103 == true) goto L26;
            boolean r115 = false;
        L27:
            if (r115 == false) goto L69;
            kf9.a r116 = r100.f350165a;
            AVCommonError r104 = AVCommonError.Disconnected;
            Integer r105 = Integer.valueOf(r112.f498756c);
            if (r105.intValue() == 0) goto L32;
            boolean r106 = true;
        L33:
            if (r106 == true) goto L36;
            r105 = null;
        L36:
            if (r105 == null) goto L38;
            int r107 = r105.intValue();
        L39:
            int r108 = r107;
            String r109 = r112.f498758e;
            if ((!StringsKt.isBlank(r109)) == true) goto L43;
            r109 = null;
        L43:
            if (r109 != null) goto L45;
            r109 = r104.getMsg();
        L45:
            String r117 = r109;
            Integer r118 = r112.f498760g;
            if (r118 != null) goto L48;
        L56:
            Integer r119 = r104.getSubCode();
        L57:
            String r120 = r112.f498759f;
            if ((!StringsKt.isBlank(r120)) == false) goto L60;
            r101 = r120;
        L60:
            if (r101 != null) goto L62;
            String r121 = r104.getSubMsg();
        L63:
            lf9.a r122 = new lf9.a(r108, r117, r119, r121, FlowAVConnectionPeriod.Calling);
            r116.getClass();
            Intrinsics.checkNotNullParameter(r122, "error");
            if (r116.f503211o != null) goto L67;
            r116.f503211o = r122;
            return;
        L67:
            return;
        L62:
            r121 = r101;
            goto L63
        L48:
            if (r118.intValue() == 0) goto L50;
            r102 = true;
        L50:
            if (r102 == true) goto L53;
            r118 = null;
        L53:
            if (r118 == null) goto L56;
            r119 = r118;
            goto L57
        L38:
            r107 = r104.getCode();
            goto L39
        L32:
            r106 = false;
            goto L33
        L69:
            return;
        L26:
            r115 = true;
            goto L27
        L21:
            r103 = false;
            goto L22
        L15:
            if (r113.f498754c == true) goto L17;
            r114 = true;
            goto L19
        L11:
            r113 = null;
            goto L12
        L5:
            r112 = null;
            goto L6
        }
    }

    public final class c extends ue9.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f350175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<cf9.d, d> f350176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlowAVSessionStableTrace f350177c;

        public c(FlowAVSessionStableTrace r100) {
            this.f350177c = r100;
            this.f350175a = new ReentrantReadWriteLock();
            this.f350176b = new LinkedHashMap();
        }

        @Override // ue9.d
        public final void c(ff9.i.u r110) {
            Intrinsics.checkNotNullParameter(r110, "result");
            ReentrantReadWriteLock.WriteLock r100 = this.f350175a.writeLock();
            r100.lock();
            d r101 = this.f350176b.remove(r110.f476750a);     // Catch: Throwable -> L38
            r100.unlock();
            if (r101 != null) goto L7;
            fe9.a.f476620a.f("FlowAVSessionStableTrace", "onMessageSendResult ticket not found");
        L7:
            Integer r102 = null;
            if (r110.f476751b != 0) goto L23;
            AVEventReporter r103 = AVEventReporter.f350163a;
            kf9.e r104 = this.f350177c.f350166b;
            long r105 = r110.f476750a.f23550a;
            if (r101 == null) goto L12;
            boolean r111 = r101.f350180c;
        L13:
            if (r101 == null) goto L15;
            int r112 = r101.f350179b;
        L16:
            if (r101 == null) goto L18;
            r102 = r101.f350181d;
        L18:
            Integer r113 = r102;
            if (r101 == null) goto L21;
            int r114 = (int) (SystemClock.elapsedRealtime() - r101.f350178a);
        L22:
            AVEventReporter.b(r104, r105, r112, r111, r113, r114, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
            return;
        L21:
            r114 = -1;
            goto L22
        L15:
            r112 = 0;
            goto L16
        L12:
            r111 = false;
            goto L13
        L23:
            AVEventReporter r106 = AVEventReporter.f350163a;
            kf9.e r107 = this.f350177c.f350166b;
            long r108 = r110.f476750a.f23550a;
            if (r101 == null) goto L26;
            int r115 = r101.f350179b;
        L27:
            if (r101 == null) goto L29;
            boolean r116 = r101.f350180c;
        L30:
            if (r101 == null) goto L32;
            r102 = r101.f350181d;
        L32:
            Integer r117 = r102;
            AVCommonError r118 = AVCommonError.Send_Result_Error;
            if (r101 == null) goto L35;
            int r119 = (int) (SystemClock.elapsedRealtime() - r101.f350178a);
        L36:
            AVEventReporter.b(r107, r108, r115, r116, r117, r119, r118, Integer.valueOf(r110.f476751b), 256);
            return;
        L35:
            r119 = -1;
            goto L36
        L29:
            r116 = false;
            goto L30
        L26:
            r115 = 0;
        L38:
            th = move-exception;
            r100.unlock();
            throw th;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f350178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f350179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f350180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f350181d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f350178a == r101.f350178a) goto L12;
            return false;
        L12:
            if (this.f350179b == r101.f350179b) goto L15;
            return false;
        L15:
            if (this.f350180c == r101.f350180c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f350181d, r101.f350181d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f350178a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f350179b) * 31;
            if (this.f350180c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r101 + r102) * 31;
            Integer r104 = this.f350181d;
            if (r104 != null) goto L9;
            int r105 = 0;
        L11:
            return r103 + r105;
        L9:
            r105 = r104.hashCode();
            goto L11
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "SendTicketTrace(sendTime=" + this.f350178a + ", cmd=" + this.f350179b + ", isReplay=" + this.f350180c + ", event=" + this.f350181d + ')';
        }

        public d(long r100, int r101, boolean r102, Integer r103) {
            this.f350178a = r100;
            this.f350179b = r101;
            this.f350180c = r102;
            this.f350181d = r103;
        }
    }

    static {
    }

    @Override // rf9.a
    public final void g() {
        InnerTraceMediaSessionListener r100 = this.f350167c;
        ouc.e0 r101 = new ouc.e0();
        ouc.j.c(r101, "end_type", "normal");
        r100.f(r101.a());
    }

    @Override // rf9.a
    public final void onInterrupt() {
        AVEventReporter r100 = AVEventReporter.f350163a;
        kf9.e r101 = this.f350166b;
        r100.d(r101.f503279o, r101, AVCommonError.Client_Interrupt);
    }

    @Override // rf9.a
    public final void b() {
        long r110 = com.larus.im.internal.network.stragery.a.b();
        this.f350167c.c(new com.larus.im.internal.rtcsdk.impl.trace.a(r110, 0, 0, r110, true, r110, 214));
    }

    @Override // rf9.a
    public final void a(id9.d r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        fe9.a r101 = fe9.a.f476620a;
        r101.e("FlowAVSessionStableTrace", "attach start");
        r100.q(this.f350167c);
        r100.w(this.f350168d);
        String r102 = null;
        if ((r100 instanceof qf9.e) == false) goto L5;
        qf9.e r103 = (qf9.e) r100;
    L6:
        if (r103 == null) goto L9;
        r103.j(this.f350169e);
        this.f350165a.f503197a = r103.i();
        r103.g(this.f350165a);
    L13:
        if ((r100 instanceof qf9.j) == false) goto L15;
        qf9.j r104 = (qf9.j) r100;
    L16:
        if (r104 == null) goto L18;
        r102 = r104.getTraceId();
    L18:
        if (r102 == null) goto L20;
        this.f350165a.f503198b = r102;
    L20:
        this.f350166b.f503266b.f350205b = r100;
        r101.e("FlowAVSessionStableTrace", "attach end");
        return;
    L15:
        r104 = null;
        goto L16
    L9:
        if ((r100 instanceof qf9.j) == false) goto L11;
        this.f350165a.f503197a = ((qf9.j) r100).getTraceId();
        goto L13
    L11:
        this.f350165a.f503197a = com.flow.kmp.common.util.i.a();
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // rf9.a
    public final void c(com.larus.im.service.audio.q r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        com.larus.im.service.audio.r r101 = r100.f();
        if ((r101 instanceof kd9.r) == false) goto L5;
        kd9.r r102 = (kd9.r) r101;
    L6:
        if (r102 == null) goto L9;
        r102.j(this.f350167c);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // rf9.a
    public final void d(id9.d r110) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        InnerTraceMediaSessionListener r100 = this.f350167c;
        if (r100.f350173d.f350166b.f503276l.a() == false) goto L5;
        AVEventReporter r101 = AVEventReporter.f350163a;
        kf9.e r102 = r100.f350173d.f350166b;
        r101.d(r102.f503279o, r102, AVCommonError.Session_End);
        final kf9.e r103 = r100.f350173d.f350166b;
        Intrinsics.checkNotNullParameter(r103, "traceContext");
        Map r104 = AVEventReporter.a(r101, r103, null, null, new j(r103), 3);
        CoroutineScope r105 = FlowAVTraceTimer.f350182a;
        FlowAVTraceTimer.a(new AVEventReporter$reportSessionExitInner$1(r103, r104, null));
    L5:
        r110.b(this.f350168d);
        r110.n(this.f350167c);
        if ((r110 instanceof qf9.e) == false) goto L8;
        qf9.e r111 = (qf9.e) r110;
    L9:
        if (r111 == null) goto L11;
        r111.z(this.f350169e);
    L11:
        n r112 = this.f350166b.f503266b;
        r112.f350205b = null;
        Job r113 = r112.f350206c;
        if (r113 == null) goto L14;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L14:
        Job r114 = this.f350166b.f503275k;
        if (r114 == null) goto L18;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
        return;
    L18:
        return;
    L8:
        r111 = null;
        goto L9
    }

    @Override // rf9.a
    public final void h(com.larus.im.service.audio.q r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        com.larus.im.service.audio.r r101 = r100.f();
        if ((r101 instanceof kd9.r) == false) goto L5;
        kd9.r r102 = (kd9.r) r101;
    L6:
        if (r102 == null) goto L9;
        r102.s(this.f350167c);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // rf9.a
    public final void e(ModalType r100, TargetVideoSourceType r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "sourceType");
        if (r100 == ModalType.VIDEO) goto L5;
        kf9.a r102 = this.f350165a;
        r102.f503203g = AVTraceModalType.AUDIO.getValue();
        return;
    L5:
        if (r101 != TargetVideoSourceType.VIDEO_SOURCE_SCREEN) goto L7;
        kf9.a r103 = this.f350165a;
        r103.f503203g = AVTraceModalType.SCREEN_SHARE.getValue();
        return;
    L7:
        kf9.a r104 = this.f350165a;
        r104.f503203g = AVTraceModalType.VIDEO.getValue();
    }

    public final void i(String r100, Map<String, Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, "metric");
        AVEventReporter r101 = AVEventReporter.f350163a;
        kf9.e r102 = this.f350166b;
        Intrinsics.checkNotNullParameter(r102, "traceContext");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, "metric");
        Map r111 = AVEventReporter.a(r101, r102, null, r110, null, 5);
        CoroutineScope r103 = FlowAVTraceTimer.f350182a;
        FlowAVTraceTimer.a(new AVEventReporter$reportAudioEngineMetric$1(r100, r111, null));
    }

    @Override // rf9.a
    public final void f(cf9.d r110, int r111, boolean r112, Integer r113) {
        Intrinsics.checkNotNullParameter(r110, "ticket");
        if (r110.f23550a != MessageSendErrorCode.PSEUDO_CONNECTED.getCode()) goto L6;
        fe9.a.f476620a.e("FlowAVSessionStableTrace", "onMessageSent pseudo connected, cmd: " + r111 + ", eventType: " + r113);
        return;
    L6:
        c r100 = this.f350169e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "ticket");
        if (cf9.e.a(r110) == false) goto L14;
        ReentrantReadWriteLock.WriteLock r101 = r100.f350175a.writeLock();
        r101.lock();
        r100.f350176b.put(r110, new d(SystemClock.elapsedRealtime(), r111, r112, r113));     // Catch: Throwable -> L11
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r101.unlock();
        return;
    L11:
        th = move-exception;
        r101.unlock();
        throw th;
    L14:
        AVEventReporter r102 = AVEventReporter.f350163a;
        AVEventReporter.b(r100.f350177c.f350166b, r110.f23550a, r111, r112, r113, 0, AVCommonError.Send_Invalid, null, 384);
    }

    public FlowAVSessionStableTrace(String r100, String r101, int r102, int r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r104, "botId");
        Intrinsics.checkNotNullParameter(r105, "abVids");
        kf9.a r107 = new kf9.a();
        r107.f503199c = r100;
        r107.f503202f = r101;
        if (r102 != ModalType.VIDEO.ordinal()) goto L5;
        int r108 = AVTraceModalType.VIDEO.getValue();
    L6:
        r107.f503203g = r108;
        r107.f503204h = Integer.valueOf(r103);
        r107.f503205i = r104;
        r107.f503200d = r105;
        r107.b(r106);
        this.f350165a = r107;
        this.f350166b = new kf9.e(r107, 4091);
        this.f350167c = new InnerTraceMediaSessionListener(this);
        this.f350168d = new b(this);
        this.f350169e = new c(this);
        return;
    L5:
        r108 = AVTraceModalType.AUDIO.getValue();
        goto L6
    }
}
