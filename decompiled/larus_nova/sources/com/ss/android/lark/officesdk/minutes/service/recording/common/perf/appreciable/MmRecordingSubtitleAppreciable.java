package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingSubtitleAppreciable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<a> f434664a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<MmRecordingCommonParam> f434665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f434666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f434667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f434668d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f434669e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f434670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f434671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f434672h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f434665a, r101.f434665a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434666b, r101.f434666b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434667c, r101.f434667c) == true) goto L18;
            return false;
        L18:
            if (this.f434668d == r101.f434668d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f434669e, r101.f434669e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f434670f, r101.f434670f) == true) goto L27;
            return false;
        L27:
            if (this.f434671g == r101.f434671g) goto L30;
            return false;
        L30:
            if (this.f434672h == r101.f434672h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f434665a.hashCode() * 31) + this.f434666b.hashCode()) * 31) + this.f434667c.hashCode()) * 31;
            long r101 = this.f434668d;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Long r103 = this.f434669e;
            int r104 = 0;
            if (r103 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r102 + r105) * 31;
            Long r107 = this.f434670f;
            if (r107 == null) goto L10;
            r104 = r107.hashCode();
        L10:
            int r108 = (r106 + r104) * 31;
            int r109 = 1231;
            if (this.f434671g == false) goto L13;
            int r110 = 1231;
        L14:
            int r111 = (r108 + r110) * 31;
            if (this.f434672h == true) goto L19;
            r109 = 1237;
        L19:
            return r111 + r109;
        L13:
            r110 = 1237;
            goto L14
        L5:
            r105 = r103.hashCode();
            goto L6
        }

        public final String toString() {
            return "AsrContext(commonParamProvider=" + this.f434665a + ", conversationId=" + this.f434666b + ", messageId=" + this.f434667c + ", requestStartTimeMs=" + this.f434668d + ", startMeetingLatencyMs=" + this.f434669e + ", subtitleOpenSuccessTimeMs=" + this.f434670f + ", hasTrackedSubtitleOpenSuccess=" + this.f434671g + ", hasTrackedFirstSubtitleOnScreenSuccess=" + this.f434672h + ')';
        }

        public a(Function0 r100, String r101, String r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "commonParamProvider");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            Intrinsics.checkNotNullParameter(r102, "messageId");
            this.f434665a = r100;
            this.f434666b = r101;
            this.f434667c = r102;
            this.f434668d = r103;
            this.f434669e = null;
            this.f434670f = null;
            this.f434671g = false;
            this.f434672h = false;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        a r100 = this.f434664a.get();
        String r101 = null;
        this.f434664a.set(null);
        StringBuilder r102 = new StringBuilder("[clearSubtitleTracking] cleared, traceId=");
        if (r100 == null) goto L9;
        Function0<MmRecordingCommonParam> r103 = r100.f434665a;
        if (r103 == null) goto L9;
        MmRecordingCommonParam r104 = r103.invoke();
        if (r104 == null) goto L9;
        r101 = r104.getRecordingTraceId();
    L9:
        r102.append(r101);
        lvb.a.e("MmRecordingSubtitleMetrics", r102.toString());
    }

    public final void d() {
        a r100 = this.f434664a.get();
        if (r100 != null) goto L7;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] missing subtitle context");
        return;
    L7:
        if (r100.f434671g == false) goto L10;
        lvb.a.h("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] duplicated, traceId=" + r100.f434665a.invoke().getRecordingTraceId());
        return;
    L10:
        r100.f434671g = true;
        r100.f434670f = Long.valueOf(System.currentTimeMillis());
        MmRecordingCommonParam r101 = r100.f434665a.invoke();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r102 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        MmRecordingSource r103 = r101.getSource();
        String r104 = null;
        if (r103 == null) goto L13;
        String r105 = r103.getValue();
    L14:
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        r102.e("source", r105);
        r102.e(MusicAppletPage.KEY_MESSAGE_ID, r100.f434667c);
        r102.e("conversation_id", r100.f434666b);
        r102.e("start_meeting_latency", String.valueOf(r100.f434669e));
        Long r106 = r100.f434670f;
        if (r106 == null) goto L23;
        long r107 = r106.longValue() - r100.f434668d;
        Long r108 = r100.f434669e;
        if (r108 == null) goto L21;
        long r110 = r108.longValue();
    L22:
        String r109 = String.valueOf(RangesKt.coerceAtLeast(r107 - r110, 0));
    L24:
        r102.e("open_subtitle_latency", r109);
        Long r111 = r100.f434670f;
        if (r111 == null) goto L27;
        r104 = String.valueOf(RangesKt.coerceAtLeast(r111.longValue() - r100.f434668d, 0));
    L27:
        r102.e("total_latency", r104);
        lvb.a.e("MmRecordingSubtitleMetrics", "[trackerSubtitleOpenSuccess] traceId=" + r101.getRecordingTraceId() + ", recordId=" + r101.getTrackerRecordId() + ", startMeetingLatencyMs=" + r100.f434669e);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r112 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434673a;
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("subtitle_open_success", r101, r102.a());
        return;
    L21:
        r110 = 0;
        goto L22
    L23:
        r109 = null;
        goto L24
    L13:
        r105 = null;
        goto L14
    }

    public MmRecordingSubtitleAppreciable() {
        this.f434664a = new AtomicReference(null);
    }

    public final void b(Function0<MmRecordingCommonParam> r100) {
        Intrinsics.checkNotNullParameter(r100, "commonParamProvider");
        a r101 = this.f434664a.get();
        if (r101 != null) goto L6;
        lvb.a.h("MmRecordingSubtitleMetrics", "[onStartMeetingSuccess] missing subtitle context");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f434665a = r100;
        MmRecordingCommonParam r102 = r100.invoke();
        r101.f434669e = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - r101.f434668d, 0));
        lvb.a.e("MmRecordingSubtitleMetrics", "[onStartMeetingSuccess] traceId=" + r102.getRecordingTraceId() + ", recordId=" + r102.getTrackerRecordId() + ", latencyMs=" + r101.f434669e);
    }

    public final void c(String r210, MmRecordingSource r211, DoubaoBizInfo r212) {
        Intrinsics.checkNotNullParameter(r210, "recordingTraceId");
        String r110 = null;
        final MmRecordingCommonParam r111 = new MmRecordingCommonParam(null, null, false, null, null, null, r210, r211, null, null, null, 1855, null);
        Function0<MmRecordingCommonParam> r100 = new MmRecordingSubtitleAppreciable$startSubtitleTracking$context$1(r111);
        if (r212 == null) goto L5;
        String r101 = r212.getConversationId();
    L7:
        if (r101 != null) goto L9;
        String r112 = "";
    L10:
        if (r212 == null) goto L12;
        String r102 = r212.getMessageId();
    L13:
        if (r102 != null) goto L15;
        String r213 = "";
    L16:
        a r103 = new a(r100, r112, r213, System.currentTimeMillis());
        this.f434664a.set(r103);
        StringBuilder r104 = new StringBuilder("[startSubtitleTracking] traceId=");
        r104.append(r210);
        r104.append(", source=");
        if (r211 == null) goto L19;
        r110 = r211.getValue();
    L19:
        r104.append(r110);
        r104.append(", conversationId=");
        r104.append(r103.f434666b);
        r104.append(", messageId=");
        r104.append(r103.f434667c);
        lvb.a.e("MmRecordingSubtitleMetrics", r104.toString());
        return;
    L15:
        r213 = r102;
        goto L16
    L12:
        r102 = null;
        goto L13
    L9:
        r112 = r101;
        goto L10
    L5:
        r101 = null;
        goto L7
    }
}
