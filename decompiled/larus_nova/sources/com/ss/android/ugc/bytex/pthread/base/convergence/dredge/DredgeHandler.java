package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import android.os.Handler;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeHandler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeHandler;", "mHandler", "Landroid/os/Handler;", "mDredgeAbility", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeAbility;", "(Landroid/os/Handler;Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeAbility;)V", "mDredgeState", "Ljava/util/concurrent/atomic/AtomicInteger;", "mDredgeWorker", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeHandler$DredgeWorker;", "postDredgeWork", "", "prepare", "", "requestDredge", "updateAdaptiveRange", "minSize", "", "maxSize", "Companion", "DredgeWorker", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class DredgeHandler implements IDredgeHandler {
    public static final Companion Companion = null;
    public static final int STATE_IDLE = 0;
    public static final int STATE_POLLING = 1;
    public static final int STATE_PREPARE = 2;
    private final IDredgeAbility mDredgeAbility;
    private final AtomicInteger mDredgeState;
    private volatile DredgeWorker mDredgeWorker;
    private final Handler mHandler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeHandler$Companion;", "", "()V", "STATE_IDLE", "", "STATE_POLLING", "STATE_PREPARE", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeHandler$DredgeWorker;", "Ljava/lang/Runnable;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/DredgeHandler;)V", "run", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public final class DredgeWorker implements Runnable {
        final /* synthetic */ DredgeHandler this$0;

        public DredgeWorker(DredgeHandler r100) {
            this.this$0 = r100;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DredgeHandler.access$getMDredgeState$p(this.this$0).compareAndSet(2, 1) == false) goto L9;
            if (DredgeHandler.access$getMDredgeAbility$p(this.this$0).prepare() == false) goto L7;
        L6:
            DredgeHandler.postDredgeWork$default(this.this$0, false, 1, null);
            return;
        L7:
            DredgeHandler.access$getMDredgeState$p(this.this$0).set(0);
            return;
        L9:
            if (DredgeHandler.access$getMDredgeState$p(this.this$0).get() != 1) goto L15;
            if (DredgeHandler.access$getMDredgeAbility$p(this.this$0).dredge() == false) goto L7;
        L15:
            throw new RuntimeException("undesired state: " + DredgeHandler.access$getMDredgeState$p(this.this$0));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DredgeHandler(Handler r100, IDredgeAbility r101) {
        this.mHandler = r100;
        this.mDredgeAbility = r101;
        this.mDredgeWorker = new DredgeWorker(this);
        this.mDredgeState = new AtomicInteger();
    }

    public static final /* synthetic */ IDredgeAbility access$getMDredgeAbility$p(DredgeHandler r100) {
        return r100.mDredgeAbility;
    }

    public static final /* synthetic */ AtomicInteger access$getMDredgeState$p(DredgeHandler r100) {
        return r100.mDredgeState;
    }

    private final void postDredgeWork(boolean r100) {
        this.mHandler.postDelayed(this.mDredgeWorker, this.mDredgeAbility.interval(r100));
    }

    public static /* synthetic */ void postDredgeWork$default(DredgeHandler r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.postDredgeWork(r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeHandler
    public void requestDredge() {
        if (this.mDredgeState.compareAndSet(0, 2) == false) goto L6;
        postDredgeWork(true);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeHandler
    public void updateAdaptiveRange(final int r100, final int r101) {
        this.mHandler.post(new AnonymousClass1(this, r100, r101));
    }
}
