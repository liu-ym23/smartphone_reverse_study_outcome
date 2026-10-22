package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/FusingStrategy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", VideoThumbInfo.KEY_INTERVAL, "", "fusingInterval", "fusingSize", "", "expectedSize", "detectCycle", "(JJIII)V", "lastBlockTime", "period", "dredgeInterval", "prepare", "", "currentPoolSize", "maxPoolSize", "expandPoolSize", "blockSize", "foldPoolSize", "blockFlag", "isBlockedInPeriod", "isContinueDredge", "onPoolSizeConfigChange", "minSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class FusingStrategy implements IDredgeStrategy {
    private final int expectedSize;
    private final long fusingInterval;
    private int fusingSize;
    private final long interval;
    private long lastBlockTime;
    private final int period;

    public FusingStrategy(long r100, long r101, int r102, int r103, int r104) {
        this.interval = r100;
        this.fusingInterval = r101;
        this.fusingSize = r102;
        this.expectedSize = r103;
        this.period = ~(Integer.MAX_VALUE << r104);
    }

    public /* synthetic */ FusingStrategy(long r110, long r111, int r112, int r113, int r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 16) == 0) goto L5;
        int r100 = 30;
    L6:
        this(r110, r111, r112, r113, r100);
        return;
    L5:
        r100 = r114;
        goto L6
    }

    private final boolean isBlockedInPeriod(int r100) {
        if ((r100 & this.period) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public long dredgeInterval(boolean r100, int r101, int r102) {
        long r103 = this.lastBlockTime;
        if (r103 <= 0) goto L7;
        return RangesKt.coerceAtLeast((r103 + this.fusingInterval) - System.currentTimeMillis(), 0);
    L7:
        return this.interval;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int expandPoolSize(int r100, int r101, int r110) {
        int r102 = RangesKt.coerceAtMost((r101 / r100) + 1, 5) + r100;
        if (r102 > r110) goto L6;
        return 0;
    L6:
        if (r102 < this.fusingSize) goto L16;
        long r103 = this.lastBlockTime;
        long r104 = System.currentTimeMillis();
        if (r103 != 0) goto L11;
        this.lastBlockTime = r104;
    L14:
        r102 = this.fusingSize;
        goto L16
    L11:
        if ((r104 - this.lastBlockTime) < this.fusingInterval) goto L14;
        this.lastBlockTime = 0;
        return r101;
    L16:
        return RangesKt.coerceAtLeast(r102 - r110, 0);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int foldPoolSize(int r100, int r101, int r102) {
        this.lastBlockTime = 0;
        if (isBlockedInPeriod(r100) == false) goto L6;
        return 0;
    L6:
        if (r102 <= this.expectedSize) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public boolean isContinueDredge(int r100, int r101, int r102) {
        if (isBlockedInPeriod(r100) == false) goto L6;
        return true;
    L6:
        if (r102 > this.fusingSize) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int onPoolSizeConfigChange(int r100, int r101) {
        this.fusingSize = r101;
        return r100;
    }
}
