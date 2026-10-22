package com.ss.android.ugc.aweme.search.common.monitor.fps;

import android.os.Build;
import android.os.Debug;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECGcTracker;", "", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ECGcTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f451806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f451807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f451808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f451809d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECGcTracker$Companion;", "", "()V", "ART_BYTES_ALLOCATED", "", "ART_BYTES_FREED", "ART_GC_COUNT", "ART_GC_TIME", "KEY_GC_BYTES_ALLOCATED", "KEY_GC_BYTES_FREED", "KEY_GC_COUNT", "KEY_GC_TIME", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public ECGcTracker() {
    }

    public static long a(String r100) {
        if (Build.VERSION.SDK_INT < 23) goto L21;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        String r102 = Debug.getRuntimeStat(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        Long r103 = StringsKt.toLongOrNull(r102);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        long r104 = r103.longValue();     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(Long.valueOf(r104));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = 0L;
    L18:
        return ((Number) r105).longValue();
    L9:
        r104 = 0;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L21:
        return 0;
    }
}
