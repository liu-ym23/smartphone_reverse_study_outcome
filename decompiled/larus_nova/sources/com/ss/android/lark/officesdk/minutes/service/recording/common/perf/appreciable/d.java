package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f434685a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingCommonParam f434686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f434687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f434688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f434689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f434690e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicLong f434691f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f434686a, r101.f434686a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434687b, r101.f434687b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434688c, r101.f434688c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f434689d, r101.f434689d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f434690e, r101.f434690e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f434691f, r101.f434691f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f434686a.hashCode() * 31) + this.f434687b.hashCode()) * 31) + this.f434688c.hashCode()) * 31) + this.f434689d.hashCode()) * 31) + this.f434690e.hashCode()) * 31) + this.f434691f.hashCode();
        }

        public final String toString() {
            return "UploadContext(commonParam=" + this.f434686a + ", recordingId=" + this.f434687b + ", uploadType=" + this.f434688c + ", totalCount=" + this.f434689d + ", successCount=" + this.f434690e + ", durationMs=" + this.f434691f + ')';
        }

        public b(MmRecordingCommonParam r100, String r101, String r102) {
            AtomicInteger r103 = new AtomicInteger(0);
            AtomicInteger r104 = new AtomicInteger(0);
            AtomicLong r105 = new AtomicLong(0);
            Intrinsics.checkNotNullParameter(r100, "commonParam");
            Intrinsics.checkNotNullParameter(r101, "recordingId");
            Intrinsics.checkNotNullParameter(r102, "uploadType");
            Intrinsics.checkNotNullParameter(r103, "totalCount");
            Intrinsics.checkNotNullParameter(r104, "successCount");
            Intrinsics.checkNotNullParameter(r105, "durationMs");
            this.f434686a = r100;
            this.f434687b = r101;
            this.f434688c = r102;
            this.f434689d = r103;
            this.f434690e = r104;
            this.f434691f = r105;
        }
    }

    static {
    }

    public d() {
        this.f434685a = new ConcurrentHashMap();
    }

    public static void a(d r100, String r101, MmRecordingCommonParam r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "recordingId");
        Intrinsics.checkNotNullParameter(r102, "commonParam");
        Intrinsics.checkNotNullParameter("audio_segment", "uploadType");
        b r103 = new b(r102, r101, "audio_segment");
        b r104 = r100.f434685a.put(r101, r103);
        StringBuilder r105 = new StringBuilder("[trackUploadStart] init context, recordingId=");
        r105.append(r101);
        r105.append(", traceId=");
        r105.append(r102.getRecordingTraceId());
        r105.append(", source=");
        r105.append(r102.getSource());
        r105.append(", uploadType=");
        r105.append("audio_segment");
        r105.append(", hasPrevious=");
        if (r104 == null) goto L5;
        boolean r106 = true;
    L6:
        r105.append(r106);
        lvb.a.e("MmRecordingUploadMetrics", r105.toString());
        return;
    L5:
        r106 = false;
        goto L6
    }
}
