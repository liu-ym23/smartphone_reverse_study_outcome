package com.obric.sva.sdk.service;

import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/sva/sdk/service/WakeProcessStartupEvidence;", "", "<init>", "()V", "UNSET_TIMESTAMP", "", "asrReadyElapsedRealtimeMs", "Ljava/util/concurrent/atomic/AtomicLong;", BasicTestActionHandler.TEST_ACTION_RESET, "", "markAsrReady", "readSize", "", "attachTo", "bundle", "Landroid/os/Bundle;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeProcessStartupEvidence {
    public static final WakeProcessStartupEvidence INSTANCE = null;
    private static final long UNSET_TIMESTAMP = -1;
    private static final AtomicLong asrReadyElapsedRealtimeMs = null;

    private WakeProcessStartupEvidence() {
    }

    static {
        INSTANCE = new WakeProcessStartupEvidence();
        asrReadyElapsedRealtimeMs = new AtomicLong(-1);
    }

    public final void reset() {
        asrReadyElapsedRealtimeMs.set(-1);
    }

    public final void attachTo(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        if (r100.containsKey("obric_startup_attempt_id") == true) goto L5;
        r100.putString("obric_startup_attempt_id", UUID.randomUUID().toString());
    L5:
        Long r101 = Long.valueOf(asrReadyElapsedRealtimeMs.getAndSet(-1));
        if (r101.longValue() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L15;
        r100.putLong("obric_wake_process_asr_ready_elapsed_ms", r101.longValue());
        return;
    L15:
        return;
    L8:
        r102 = false;
        goto L9
    }

    public final void markAsrReady(int r100) {
        if (r100 <= 0) goto L5;
        asrReadyElapsedRealtimeMs.compareAndSet(-1, SystemClock.elapsedRealtime());
        return;
    }
}
