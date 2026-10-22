package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import com.ss.android.ugc.bytex.pthread.base.convergence.executor.ExpandablePool;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IntervalDredgeAbility;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeAbility;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;", "mStrategy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/ExpandablePool;Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;)V", "mBlockFlag", "", "mExpectConsumeCount", "", "dredge", "", VideoThumbInfo.KEY_INTERVAL, "prepare", "onPoolSizeConfigChange", "", "minSize", "maxSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class IntervalDredgeAbility implements IDredgeAbility {
    private final ExpandablePool executor;
    private int mBlockFlag;
    private long mExpectConsumeCount;
    private final IDredgeStrategy mStrategy;

    public IntervalDredgeAbility(ExpandablePool r100, IDredgeStrategy r101) {
        this.executor = r100;
        this.mStrategy = r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public boolean dredge() {
        long r100 = this.executor.getConsumeCount();
        long r101 = this.mExpectConsumeCount;
        if (r100 >= r101) goto L5;
        int r102 = 1;
    L6:
        int r103 = (this.mBlockFlag << 1) + r102;
        this.mBlockFlag = r103;
        long r104 = RangesKt.coerceAtLeast(r101 - r100, 0);
        int r105 = this.executor.getPoolSize();
        int r106 = this.executor.getMaxPoolSize();
        if (r102 == 0) goto L11;
        int r107 = this.mStrategy.expandPoolSize(r105, (int) r104, r106);
        if (r107 <= 0) goto L15;
        ExpandablePool r108 = this.executor;
        int r109 = r107 + r106;
    L14:
        r108.setMaxPoolSize(r109);
    L15:
        this.mExpectConsumeCount = this.executor.getConsumeCount() + ((long) this.executor.getPendingCount());
        return this.mStrategy.isContinueDredge(r103, r105, r106);
    L11:
        int r110 = this.mStrategy.foldPoolSize(r103, r105, r106);
        if (r110 <= 0) goto L15;
        r108 = this.executor;
        r109 = r106 - r110;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public long interval(boolean r100) {
        return this.mStrategy.dredgeInterval(r100, this.executor.getPoolSize(), this.executor.getMaxPoolSize());
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public void onPoolSizeConfigChange(int r100, int r101) {
        int r102 = this.mStrategy.onPoolSizeConfigChange(r100, r101);
        if (r102 <= 0) goto L6;
        this.executor.setMaxPoolSize(r102);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeAbility
    public boolean prepare() {
        int r100 = this.executor.getPendingCount();
        if (r100 != 0) goto L5;
        return false;
    L5:
        if ((this.executor.getPoolSize() + r100) < this.executor.getMaxPoolSize()) goto L11;
        this.mExpectConsumeCount = this.executor.getConsumeCount() + ((long) r100);
        return true;
    L11:
        return false;
    }
}
