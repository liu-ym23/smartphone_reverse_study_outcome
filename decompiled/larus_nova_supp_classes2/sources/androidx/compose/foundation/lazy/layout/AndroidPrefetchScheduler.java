package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.ui.precompose.PausableSubPreComposeController;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002&'B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "Landroid/view/View$OnAttachStateChangeListener;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "view", "Landroid/view/View;", "pausableSubPreComposeController", "Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/precompose/PausableSubPreComposeController;)V", "prefetchRequests", "Ljava/util/PriorityQueue;", "Landroidx/compose/foundation/lazy/layout/PriorityTask;", "prefetchScheduled", "", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "scope", "Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "isActive", "frameStartTimeNanos", "", "run", "", "runRequest", "doFrame", "frameTimeNanos", "startExecution", "scheduleLowPriorityPrefetch", "prefetchRequest", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "scheduleHighPriorityPrefetch", "onViewAttachedToWindow", "v", "onViewDetachedFromWindow", "PrefetchRequestScopeImpl", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidPrefetchScheduler implements PrefetchScheduler, PriorityPrefetchScheduler, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static long frameIntervalNs;
    private final Choreographer choreographer;
    private long frameStartTimeNanos;
    private boolean isActive;
    private final PausableSubPreComposeController pausableSubPreComposeController;
    private final PriorityQueue<PriorityTask> prefetchRequests;
    private boolean prefetchScheduled;
    private final PrefetchRequestScopeImpl scope;
    private final View view;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$Companion;", "", "<init>", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final void calculateFrameIntervalIfNeeded(View r6) {
            if (AndroidPrefetchScheduler.access$getFrameIntervalNs$cp() != 0) goto L13;
            Display r0 = r6.getDisplay();
            if (r6.isInEditMode() == true) goto L10;
            if (r0 == null) goto L10;
            float r7 = r0.getRefreshRate();
            if (r7 < 30.0f) goto L10;
        L11:
            AndroidPrefetchScheduler.access$setFrameIntervalNs$cp((long) (1000000000 / r7));
            return;
        L10:
            r7 = 60.0f;
            goto L11
        }

        public static final /* synthetic */ void access$calculateFrameIntervalIfNeeded(Companion r0, View r1) {
            r0.calculateFrameIntervalIfNeeded(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AndroidPrefetchScheduler$PrefetchRequestScopeImpl;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "<init>", "()V", "isFrameIdle", "", "()Z", "setFrameIdle", "(Z)V", "nextFrameTimeNs", "", "getNextFrameTimeNs", "()J", "setNextFrameTimeNs", "(J)V", "availableTimeNanos", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        public static final int $stable = 8;
        private boolean isFrameIdle;
        private long nextFrameTimeNs;

        public PrefetchRequestScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long availableTimeNanos() {
            if (this.isFrameIdle == false) goto L6;
            return Long.MAX_VALUE;
        L6:
            return Math.max(0, this.nextFrameTimeNs - System.nanoTime());
        }

        public final long getNextFrameTimeNs() {
            return this.nextFrameTimeNs;
        }

        public final boolean isFrameIdle() {
            return this.isFrameIdle;
        }

        public final void setFrameIdle(boolean r1) {
            this.isFrameIdle = r1;
        }

        public final void setNextFrameTimeNs(long r1) {
            this.nextFrameTimeNs = r1;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ int a(PriorityTask r0, PriorityTask r1) {
        return prefetchRequests$lambda$0(r0, r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_compose_foundation_lazy_layout_AndroidPrefetchScheduler_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler, androidx.compose.foundation.lazy.layout.PriorityPrefetchScheduler
    public final /* synthetic */ void schedulePrefetch(PrefetchRequest r1) {
        PriorityPrefetchScheduler.CC.$default$schedulePrefetch(this, r1);
    }

    private final boolean runRequest() {
        long r0 = this.scope.availableTimeNanos();
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", r0);
        boolean r4 = true;
        if (r0 <= 0) goto L9;
        PriorityTask r1 = this.prefetchRequests.peek();
        Intrinsics.checkNotNull(r1);
        if (r1.getRequest().execute(this.scope) == true) goto L8;
        this.prefetchRequests.poll();
        r4 = false;
    L8:
        this.scope.setFrameIdle(false);
    L9:
        return r4;
    }

    private final void startExecution() {
        if (this.prefetchScheduled == true) goto L9;
        this.prefetchScheduled = true;
        if (this.view.isAttachedToWindow() == false) goto L7;
        this.view.post(this);
        return;
    L7:
        this.view.getHandler().post(this);
        return;
    }

    public void androidx_compose_foundation_lazy_layout_AndroidPrefetchScheduler__run$___twin___() {
        if (this.isActive == true) goto L5;
    L6:
        PausableSubPreComposeController r0 = this.pausableSubPreComposeController;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L14;
    L13:
        boolean r2 = true;
    L16:
        if (this.prefetchRequests.isEmpty() == false) goto L18;
    L50:
        this.prefetchScheduled = false;
        return;
    L18:
        if (this.prefetchScheduled == false) goto L50;
        if (r2 == false) goto L50;
        long r3 = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime());
        PrefetchRequestScopeImpl r4 = this.scope;
        PausableSubPreComposeController r5 = this.pausableSubPreComposeController;
        if (r5 != null) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L30;
    L28:
        boolean r7 = false;
    L32:
        r4.setFrameIdle(r7);
        this.scope.setNextFrameTimeNs(Math.max(this.frameStartTimeNanos, r3) + frameIntervalNs);
        boolean r8 = false;
    L34:
        if ((!this.prefetchRequests.isEmpty()) == false) goto L45;
        if (r8 == true) goto L45;
        if (this.scope.isFrameIdle() == true) goto L38;
        r8 = runRequest();
        goto L34
    L38:
        Trace.beginSection("compose:lazy:prefetch:idle_frame");
        r8 = runRequest();     // Catch: Throwable -> L41
        Trace.endSection();
    L41:
        th = move-exception;
        Trace.endSection();
        throw th;
    L45:
        if (r8 == false) goto L47;
        this.choreographer.postFrameCallback(this);
    L48:
        AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", 0);
        return;
    L47:
        this.prefetchScheduled = false;
        goto L48
    L30:
        if (System.nanoTime() <= ((((long) 2) * frameIntervalNs) + r3)) goto L28;
        r7 = true;
        goto L32
    L24:
        if (r5.getInPausablePreCompose() != true) goto L26;
        r6 = true;
        goto L27
    L14:
        r2 = false;
        goto L16
    L9:
        if (r0.getInPausablePreCompose() != true) goto L11;
        r1 = true;
        goto L12
    L5:
        if (this.view.getWindowVisibility() == 0) goto L13;
        goto L6
    }

    public static final /* synthetic */ long access$getFrameIntervalNs$cp() {
        return frameIntervalNs;
    }

    public static final /* synthetic */ void access$setFrameIntervalNs$cp(long r0) {
        frameIntervalNs = r0;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_compose_foundation_lazy_layout_AndroidPrefetchScheduler_com_larus_apm_impl_protector_RunnableLancet_run(AndroidPrefetchScheduler r1) {
        r1.androidx_compose_foundation_lazy_layout_AndroidPrefetchScheduler__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r4) {
        if (this.isActive == true) goto L10;
        PausableSubPreComposeController r0 = this.pausableSubPreComposeController;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L10;
        return;
    L7:
        if (r0.getInPausablePreCompose() != true) goto L9;
        r1 = true;
    L10:
        this.frameStartTimeNanos = r4;
        if (this.view.isAttachedToWindow() == false) goto L13;
        this.view.post(this);
        return;
    L13:
        this.view.getHandler().post(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r1) {
        this.isActive = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r1) {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.foundation.lazy.layout.PriorityPrefetchScheduler
    public void scheduleHighPriorityPrefetch(PrefetchRequest r4) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.Companion.getHigh(), r4));
        startExecution();
    }

    @Override // androidx.compose.foundation.lazy.layout.PriorityPrefetchScheduler
    public void scheduleLowPriorityPrefetch(PrefetchRequest r4) {
        this.prefetchRequests.add(new PriorityTask(PriorityTask.Companion.getLow(), r4));
        startExecution();
    }

    public AndroidPrefetchScheduler(View r3, PausableSubPreComposeController r4) {
        this.view = r3;
        this.pausableSubPreComposeController = r4;
        this.prefetchRequests = new PriorityQueue(11, new a());
        this.choreographer = Choreographer.getInstance();
        this.scope = new PrefetchRequestScopeImpl();
        Companion.access$calculateFrameIntervalIfNeeded(Companion, r3);
        r3.addOnAttachStateChangeListener(this);
        if (r3.isAttachedToWindow() == false) goto L6;
        onViewAttachedToWindow(r3);
        return;
    }

    private static final int prefetchRequests$lambda$0(PriorityTask r0, PriorityTask r1) {
        return Intrinsics.compare(r1.getPriority(), r0.getPriority());
    }
}
