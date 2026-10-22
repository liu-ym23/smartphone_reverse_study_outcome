package xn2;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.t0;
import com.bytedance.android.livesdk.v1;
import com.bytedance.android.livesdkapi.model.LiveHeapOptConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.LiveMemGcStepConfig;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sysoptimizer.allocatorx.HeapGCOptimizerV2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements xn2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveHeapOptConfig f564609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveMemGcStepConfig f564610b;

    /* JADX INFO: renamed from: xn2.a$a, reason: collision with other inner class name */
    public static final class RunnableC8259a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f564612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f564613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f564614d;

        public RunnableC8259a(a r100, Ref.IntRef r101, Ref.IntRef r102, int r103) {
            this.f564611a = r100;
            this.f564612b = r101;
            this.f564613c = r102;
            this.f564614d = r103;
        }

        public final void a() {
            if (this.f564612b.element <= 0) goto L10;
            if (this.f564613c.element < 0) goto L10;
            if (this.f564614d < 0) goto L10;
            HeapGCOptimizerV2.optimize(s1.getContext(), this.f564612b.element, this.f564614d, this.f564613c.element);
        L10:
            if (this.f564611a.f564610b.getNewDiffGcValue() == (-100)) goto L13;
            HeapGCOptimizerV2.setGCStepDiff(s1.getContext(), this.f564611a.f564610b.getNewDiffGcValue());
        L13:
            if (this.f564611a.f564610b.getBaseGcStepValue() >= 0) goto L15;
            return;
        L15:
            if (this.f564611a.f564610b.getMinGcStepValue() < 0) goto L19;
            HeapGCOptimizerV2.optimizeOnGCStep(s1.getContext(), this.f564611a.f564610b.getBaseGcStepValue(), this.f564611a.f564610b.getMinGcStepValue());
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f564615a;

        public b(a r100) {
            this.f564615a = r100;
        }

        public final void a() {
            if (this.f564615a.f564609a.getResetTriggerValue() < 0) goto L6;
            HeapGCOptimizerV2.optimize(s1.getContext(), this.f564615a.f564609a.getResetTriggerValue(), 0, 0);
        L6:
            if (this.f564615a.f564610b.getResetNewGcDiffValue() == (-100)) goto L9;
            HeapGCOptimizerV2.setGCStepDiff(s1.getContext(), this.f564615a.f564610b.getResetNewGcDiffValue());
        L9:
            if (this.f564615a.f564610b.getResetBaseGcStepValue() >= 0) goto L11;
            return;
        L11:
            if (this.f564615a.f564610b.getResetMinGcStepValue() < 0) goto L15;
            HeapGCOptimizerV2.optimizeOnGCStep(s1.getContext(), this.f564615a.f564610b.getResetBaseGcStepValue(), this.f564615a.f564610b.getResetMinGcStepValue());
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // xn2.b
    public final void optimize() {
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        float r101 = 0;
        if (this.f564609a.getTriggerGCPercent() <= r101) goto L6;
        r100.element = (((int) (Runtime.getRuntime().maxMemory() * this.f564609a.getTriggerGCPercent())) / 1024) / 1024;
    L9:
        if (r100.element < 400) goto L11;
        r100.element = 400;
    L11:
        int r102 = this.f564609a.getDiffGCValue();
        Ref.IntRef r103 = new Ref.IntRef();
        r103.element = 0;
        if (this.f564609a.getExpandHeapPercent() <= r101) goto L15;
        r103.element = (int) ((Runtime.getRuntime().maxMemory() / ((long) 1048576)) * this.f564609a.getExpandHeapPercent());
    L17:
        TTExecutors.getNormalExecutor().submit(new RunnableC8259a(this, r100, r103, r102));
        return;
    L15:
        if (this.f564609a.getExpandHeapValue() <= 0) goto L17;
        r103.element = this.f564609a.getExpandHeapValue();
        goto L17
    L6:
        if (this.f564609a.getTriggerGCValue() <= 0) goto L9;
        r100.element = this.f564609a.getTriggerGCValue();
        goto L9
    }

    public a() {
        this.f564609a = t0.f158503a.getValue();
        this.f564610b = v1.f159239a.getValue();
    }

    @Override // xn2.b
    public final void reset() {
        TTExecutors.getNormalExecutor().submit(new b(this));
    }
}
