package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f434680a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmRecordingCommonParam f434681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f434682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DoubaoStatisticInfo f434683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f434684d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f434681a, r101.f434681a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434682b, r101.f434682b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434683c, r101.f434683c) == true) goto L18;
            return false;
        L18:
            if (this.f434684d == r101.f434684d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f434681a.hashCode() * 31) + this.f434682b.hashCode()) * 31;
            DoubaoStatisticInfo r101 = this.f434683c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f434684d;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "EndWindowContext(commonParam=" + this.f434681a + ", source=" + this.f434682b + ", doubaoStatisticInfo=" + this.f434683c + ", startTimeMs=" + this.f434684d + ')';
        }

        public b(MmRecordingCommonParam r100, String r101, DoubaoStatisticInfo r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "commonParam");
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f434681a = r100;
            this.f434682b = r101;
            this.f434683c = r102;
            this.f434684d = r103;
        }
    }

    static {
    }

    public c() {
        this.f434680a = new ConcurrentHashMap();
    }
}
