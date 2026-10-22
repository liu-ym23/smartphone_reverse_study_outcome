package com.bytedance.locallife.live.goodsshelves.manager;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/manager/RetryMode;", "", "", "times", "J", "getTimes", "()J", EffectConstants.NORMAL, "FUSE", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum RetryMode extends Enum<RetryMode> {
    public static final RetryMode FUSE = null;
    public static final RetryMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetryMode[] f259678a = null;
    private final long times;

    public static RetryMode valueOf(String r100) {
        return (RetryMode) r27.a.a(RetryMode.class, r100);
    }

    public static RetryMode[] values() {
        return (RetryMode[]) f259678a.clone();
    }

    static {
        RetryMode r100 = new RetryMode(EffectConstants.NORMAL, 0, 2);
        NORMAL = r100;
        RetryMode r101 = new RetryMode("FUSE", 1, 0);
        FUSE = r101;
        f259678a = new RetryMode[]{r100, r101};
    }

    public final long getTimes() {
        return this.times;
    }

    public RetryMode(String r100, int r101, long r102) {
        super(r100, r101);
        this.times = r102;
    }
}
