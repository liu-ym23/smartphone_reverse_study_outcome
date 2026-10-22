package androidx.camera.camera2.internal;

import androidx.camera.core.Logger;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/internal/VideoUsageControl;", "", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "mVideoUsage", "Ljava/util/concurrent/atomic/AtomicInteger;", "decrementUsage", "", "getUsage", "", "incrementUsage", "reset", "resetDirectly", "camera-camera2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VideoUsageControl {
    private final Executor executor;
    private final AtomicInteger mVideoUsage;

    public static /* synthetic */ void a(VideoUsageControl r0) {
        decrementUsage$lambda$1(r0);
    }

    public static /* synthetic */ void b(VideoUsageControl r0) {
        reset$lambda$2(r0);
    }

    public static /* synthetic */ void c(VideoUsageControl r0) {
        incrementUsage$lambda$0(r0);
    }

    public final void decrementUsage() {
        this.executor.execute(new p3(this));
    }

    public final int getUsage() {
        return this.mVideoUsage.get();
    }

    public final void incrementUsage() {
        this.executor.execute(new n3(this));
    }

    public final void reset() {
        this.executor.execute(new o3(this));
    }

    public final void resetDirectly() {
        this.mVideoUsage.set(0);
        Logger.d("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }

    public VideoUsageControl(Executor r2) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        this.executor = r2;
        this.mVideoUsage = new AtomicInteger(0);
    }

    private static final void decrementUsage$lambda$1(VideoUsageControl r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        int r4 = r3.mVideoUsage.decrementAndGet();
        if (r4 >= 0) goto L5;
        Logger.w("VideoUsageControl", "decrementUsage: mVideoUsage = " + r4 + ", which is less than 0!");
        return;
    L5:
        Logger.d("VideoUsageControl", "decrementUsage: mVideoUsage = " + r4);
    }

    private static final void incrementUsage$lambda$0(VideoUsageControl r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Logger.d("VideoUsageControl", "incrementUsage: mVideoUsage = " + r2.mVideoUsage.incrementAndGet());
    }

    private static final void reset$lambda$2(VideoUsageControl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.resetDirectly();
    }
}
