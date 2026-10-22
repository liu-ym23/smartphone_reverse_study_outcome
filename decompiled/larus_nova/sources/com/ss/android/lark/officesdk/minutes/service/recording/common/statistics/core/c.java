package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.bytedance.crash.general.HardwareInfo;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.statistics.Statistics;
import iub.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f435421n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<kub.d> f435422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f435423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f435424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f435425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f435426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f435427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f435428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f435429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f435430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f435431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f435432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f435433l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f435434m;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5193a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f435435a = null;

            static {
                int[] r100 = new int[RecordingSessionType.values().length];
                r100[RecordingSessionType.HARDWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[RecordingSessionType.HARDWARE_LIVE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[RecordingSessionType.SOFTWARE_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[RecordingSessionType.HISTORY_RECORDING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[RecordingSessionType.PRE_MEETING_NATIVE_RECORDING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f435435a = r100;
            }
        }

        public static void b(JSONObject r100) {
            Intrinsics.checkNotNullParameter("minutes_recording_dev", "eventName");
            d r101 = new d();
            r101.f(r100);
            JSONObject r102 = r101.a();
            lvb.a.a("MmRecordingBusinessTracker", "[sendGlobalEvent] eventName=minutes_recording_dev, params=" + r102);
            Statistics.sendEvent("minutes_recording_dev", r102);
        }

        public static String a(RecordingSessionType r100, k r101) {
            Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
            switch(C5193a.f435435a[r100.ordinal()]) {
                case 1: goto L30;
                case 2: goto L30;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L32;
                case 6: goto L32;
                default: goto L5;
            };
        L6:
            if (r101 == null) goto L33;
            MmRecordingSource r102 = r101.f495846a;
            if (r102 == MmRecordingSource.FEISHU) goto L16;
            boolean r103 = false;
            if (r102 != null) goto L12;
        L14:
            boolean r104 = false;
        L15:
            if (r104 == true) goto L16;
        L17:
            if (r103 == true) goto L20;
            r101 = null;
        L20:
            if (r101 == null) goto L34;
            Object r105 = r101.f495847b.get("from_source");
            if (r105 == null) goto L24;
            String r106 = r105.toString();
        L25:
            if (r106 != null) goto L28;
            r106 = "";
        L28:
            if ((!StringsKt.isBlank(r106)) == true) goto L36;
            return null;
        L36:
            return r106;
        L24:
            r106 = null;
            goto L25
        L34:
            return null;
        L12:
            if (r102.isStandaloneAIInterpretationSource() != true) goto L14;
            r104 = true;
        L16:
            r103 = true;
            goto L17
        L33:
            return null;
        L30:
            return HardwareInfo.KEY_HW_CPU_HARDWARE;
        L32:
            return null;
        L5:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public c() {
        this(null, 3);
    }

    public final g a() {
        return (g) this.f435432k.getValue();
    }

    public final MmRecordingCommonParam b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r101 = c(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f435416b;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        return this.f435423b.getContext(r100);
    }

    public final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        MmRecordingCommonParam r101 = b(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isValid() != true) goto L7;
        return true;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        b r101 = this.f435423b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        r101.b(r100, null, Boolean.TRUE, "markEndWindowClosed");
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        b r101 = this.f435423b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        r101.b(r100, Boolean.TRUE, null, "markSessionEnded");
    }

    public c(Function0 r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = MmRecordingBusinessTracker$1.INSTANCE;
    L6:
        if ((r101 & 2) == 0) goto L8;
        b r102 = new b();
    L9:
        Intrinsics.checkNotNullParameter(r100, "hostTrackerProvider");
        Intrinsics.checkNotNullParameter(r102, "contextStore");
        this.f435422a = r100;
        this.f435423b = r102;
        this.f435424c = LazyKt.lazy(new MmRecordingBusinessTracker$recordingPageTracker$2(this));
        this.f435425d = LazyKt.lazy(new MmRecordingBusinessTracker$recordFloatWindowTracker$2(this));
        this.f435426e = LazyKt.lazy(new MmRecordingBusinessTracker$backgroundRunTracker$2(this));
        this.f435427f = LazyKt.lazy(new MmRecordingBusinessTracker$aiInterpretationTracker$2(this));
        this.f435428g = LazyKt.lazy(new MmRecordingBusinessTracker$doubaoBusinessTracker$2(this));
        this.f435429h = LazyKt.lazy(new MmRecordingBusinessTracker$voicePrintTracker$2(this));
        this.f435430i = LazyKt.lazy(new MmRecordingBusinessTracker$subtitleTracker$2(this));
        this.f435431j = LazyKt.lazy(new MmRecordingBusinessTracker$quotaCtaTracker$2(this));
        this.f435432k = LazyKt.lazy(new MmRecordingBusinessTracker$aiNoteTracker$2(this));
        this.f435433l = LazyKt.lazy(new MmRecordingBusinessTracker$diagnosisTracker$2(this));
        new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.d(this);
        this.f435434m = LazyKt.lazy(new MmRecordingBusinessTracker$standaloneAIInterpretationTracker$2(this));
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static void h(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        d r102 = new d();
        r102.f(r101);
        JSONObject r103 = r102.a();
        lvb.a.a("MmRecordingBusinessTracker", "[sendEvent] eventName=" + r100 + ", params=" + r103);
        Statistics.sendEvent(r100, r103);
    }

    public final void k(MmRecordingSession r110, MmRecordingCommonParam r111) {
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r111, "commonParam");
        b r100 = this.f435423b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r111, "commonParam");
        String r101 = r110.e();
        if (StringsKt.isBlank(r101) == false) goto L5;
        lvb.a.h("MmRecordingBusinessTrackContextStore", "[updateContext] skip: sessionId is blank");
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r102 = r100.f435420a.get(r101);
        k r112 = r110.f434102f;
        if (r112 == null) goto L8;
        DoubaoStatisticInfo r113 = r112.a();
    L9:
        DoubaoStatisticInfo r103 = r113;
        boolean r114 = false;
        if (r102 == null) goto L12;
        boolean r104 = r102.f435418d;
    L13:
        if (r102 == null) goto L15;
        boolean r105 = r102.f435419e;
    L16:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r115 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a(r101, r111, r103, r104, r105);
        r100.f435420a.put(r101, r115);
        StringBuilder r116 = new StringBuilder("[updateContext] sessionId=");
        r116.append(r101);
        r116.append(", hasDoubaoInfo=");
        if (r115.f435417c == null) goto L19;
        r114 = true;
    L19:
        r116.append(r114);
        lvb.a.e("MmRecordingBusinessTrackContextStore", r116.toString());
        r100.a(r101);
        return;
    L15:
        r105 = false;
        goto L16
    L12:
        r104 = false;
        goto L13
    L8:
        r113 = null;
        goto L9
    }

    public static void j(MmRecordingCommonParam r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "commonParam");
        Intrinsics.checkNotNullParameter(r101, "fromSource");
        Intrinsics.checkNotNullParameter(r102, "scene");
        d r103 = r100.asTrackerParams();
        r103.e("from_source", r101);
        r103.e("scene", r102);
        h("vc_record_upload_minutes_create_status", r103.a());
    }

    public final void g(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r103 = c(r100);
        if (r103 != null) goto L6;
        lvb.a.h("MmRecordingBusinessTracker", "[sendEvent] skip: context missing, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L6:
        d r104 = new d();
        r104.f(r102);
        r104.f(r103.f435416b.asTrackerParams().a());
        JSONObject r105 = r104.a();
        lvb.a.a("MmRecordingBusinessTracker", "[sendEvent] eventName=" + r101 + ", sessionId=" + r100 + ", params=" + r105);
        Statistics.sendEvent(r101, r105);
    }

    public final void i(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "eventParams");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.a r103 = c(r100);
        if (r103 != null) goto L7;
        lvb.a.h("MmRecordingBusinessTracker", "[sendWebEvent] skip: context missing, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L7:
        if (r103.f435416b.isValid() == true) goto L10;
        lvb.a.h("MmRecordingBusinessTracker", "[sendWebEvent] skip: commonParam invalid, eventName=" + r101 + ", sessionId=" + r100);
        return;
    L10:
        r103.f435416b.putCommonParamsTo(r102, "webview");
        g(r100, r101, r102);
    }
}
