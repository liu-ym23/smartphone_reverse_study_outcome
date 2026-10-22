package com.ss.android.ugc.bytex.pthread.base.convergence.dredge;

import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0082\bJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/LooseStrategy;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeStrategy;", "expandFactor", "", "decreaseFold", "", "expectCount", VideoThumbInfo.KEY_INTERVAL, "", "expectMaxFoldCycle", "detectCycle", "(FIIJII)V", "foldCycle", "period", "dredgeInterval", "prepare", "", "currentPoolSize", "maxPoolSize", "expandPoolSize", "blockSize", "foldPoolSize", "blockFlag", "isContinueDredge", "onBlockedInPeriod", "", "callback", "Lkotlin/Function0;", "onPoolSizeConfigChange", "minSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class LooseStrategy implements IDredgeStrategy {
    private final int decreaseFold;
    private final float expandFactor;
    private int expectCount;
    private final int expectMaxFoldCycle;
    private int foldCycle;
    private final long interval;
    private final int period;

    public LooseStrategy(float r100, int r101, int r102, long r103, int r104, int r105) {
        this.expandFactor = r100;
        this.decreaseFold = r101;
        this.expectCount = r102;
        this.interval = r103;
        this.expectMaxFoldCycle = r104;
        this.period = ~(Integer.MAX_VALUE << r105);
    }

    public /* synthetic */ LooseStrategy(float r110, int r111, int r112, long r113, int r114, int r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 32) == 0) goto L5;
        int r100 = 30;
    L6:
        this(r110, r111, r112, r113, r114, r100);
        return;
    L5:
        r100 = r115;
        goto L6
    }

    public static final /* synthetic */ int access$getPeriod$p(LooseStrategy r100) {
        return r100.period;
    }

    private final void onBlockedInPeriod(int r100, Function0<Unit> r101) {
        if ((r100 & access$getPeriod$p(this)) == 0) goto L6;
        r101.invoke();
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public long dredgeInterval(boolean r100, int r101, int r102) {
        return this.interval;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int expandPoolSize(int r100, int r101, int r102) {
        return RangesKt.coerceAtLeast((MathKt.roundToInt(r101 * this.expandFactor) + r100) - r102, 0);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int foldPoolSize(int r100, int r101, int r102) {
        if ((r100 & access$getPeriod$p(this)) == 0) goto L6;
        return 0;
    L6:
        if (r101 > this.expectCount) goto L8;
        return 0;
    L8:
        return this.decreaseFold;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public boolean isContinueDredge(int r100, int r101, int r102) {
        if ((r100 & access$getPeriod$p(this)) == 0) goto L6;
        return true;
    L6:
        if (r102 > this.expectCount) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        this.foldCycle++;
    L14:
        return r103;
    L13:
        this.foldCycle = 0;
        goto L14
    L8:
        if (this.foldCycle >= this.expectMaxFoldCycle) goto L10;
        r103 = true;
        goto L11
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeStrategy
    public int onPoolSizeConfigChange(int r100, int r101) {
        this.expectCount = r100;
        return 0;
    }
}
