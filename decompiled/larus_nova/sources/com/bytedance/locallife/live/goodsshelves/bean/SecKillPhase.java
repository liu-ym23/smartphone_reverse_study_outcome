package com.bytedance.locallife.live.goodsshelves.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/SecKillPhase;", "", "", "value", "I", "getValue", "()I", "NoFlash", "Warmup", "Flashing", "FlashEnd", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum SecKillPhase extends Enum<SecKillPhase> {
    public static final SecKillPhase FlashEnd = null;
    public static final SecKillPhase Flashing = null;
    public static final SecKillPhase NoFlash = null;
    public static final SecKillPhase Warmup = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SecKillPhase[] f259583a = null;
    private final int value;

    public static SecKillPhase valueOf(String r100) {
        return (SecKillPhase) r27.a.a(SecKillPhase.class, r100);
    }

    public static SecKillPhase[] values() {
        return (SecKillPhase[]) f259583a.clone();
    }

    static {
        SecKillPhase r100 = new SecKillPhase("NoFlash", 0, 0);
        NoFlash = r100;
        SecKillPhase r101 = new SecKillPhase("Warmup", 1, 1);
        Warmup = r101;
        SecKillPhase r102 = new SecKillPhase("Flashing", 2, 2);
        Flashing = r102;
        SecKillPhase r103 = new SecKillPhase("FlashEnd", 3, 3);
        FlashEnd = r103;
        f259583a = new SecKillPhase[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public SecKillPhase(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
