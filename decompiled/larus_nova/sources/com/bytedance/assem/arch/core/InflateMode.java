package com.bytedance.assem.arch.core;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/arch/core/InflateMode;", "", BridgeSyncType.SYNC, BridgeSyncType.ASYNC, "X2C", "ASYNC_X2C", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum InflateMode extends Enum<InflateMode> {
    public static final InflateMode ASYNC = null;
    public static final InflateMode ASYNC_X2C = null;
    public static final InflateMode SYNC = null;
    public static final InflateMode X2C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InflateMode[] f192882a = null;

    static {
        InflateMode r100 = new InflateMode(BridgeSyncType.SYNC, 0);
        SYNC = r100;
        InflateMode r101 = new InflateMode(BridgeSyncType.ASYNC, 1);
        ASYNC = r101;
        InflateMode r102 = new InflateMode("X2C", 2);
        X2C = r102;
        InflateMode r103 = new InflateMode("ASYNC_X2C", 3);
        ASYNC_X2C = r103;
        f192882a = new InflateMode[]{r100, r101, r102, r103};
    }

    public static InflateMode valueOf(String r100) {
        return (InflateMode) r27.a.a(InflateMode.class, r100);
    }

    public static InflateMode[] values() {
        return (InflateMode[]) f192882a.clone();
    }

    public InflateMode(String r100, int r101) {
        super(r100, r101);
    }
}
