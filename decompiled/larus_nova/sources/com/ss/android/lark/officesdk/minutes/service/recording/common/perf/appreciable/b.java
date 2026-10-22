package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<C5182b> f434677a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b$b, reason: collision with other inner class name */
    public static final class C5182b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingCommonParam f434678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f434679b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5182b) == true) goto L8;
            return false;
        L8:
            C5182b r101 = (C5182b) r100;
            if (Intrinsics.areEqual(this.f434678a, r101.f434678a) == true) goto L12;
            return false;
        L12:
            if (this.f434679b == r101.f434679b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f434678a.hashCode() * 31;
            long r101 = this.f434679b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "StartContext(commonParam=" + this.f434678a + ", startTimeMs=" + this.f434679b + ')';
        }

        public C5182b(MmRecordingCommonParam r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "commonParam");
            this.f434678a = r100;
            this.f434679b = r101;
        }
    }

    static {
    }

    public b() {
        this.f434677a = new AtomicReference(null);
    }
}
