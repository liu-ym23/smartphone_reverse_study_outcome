package com.bytedance.locallife.live.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/live/model/CollectScene;", "", "", "value", "I", "getValue", "()I", "Coupon", "AutoCollect", "Play", "PopWindow", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CollectScene extends Enum<CollectScene> {
    public static final CollectScene AutoCollect = null;
    public static final CollectScene Coupon = null;
    public static final CollectScene Play = null;
    public static final CollectScene PopWindow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectScene[] f260618a = null;
    private final int value;

    public static CollectScene valueOf(String r100) {
        return (CollectScene) a.a(CollectScene.class, r100);
    }

    public static CollectScene[] values() {
        return (CollectScene[]) f260618a.clone();
    }

    static {
        CollectScene r100 = new CollectScene("Coupon", 0, 1);
        Coupon = r100;
        CollectScene r101 = new CollectScene("AutoCollect", 1, 2);
        AutoCollect = r101;
        CollectScene r102 = new CollectScene("Play", 2, 3);
        Play = r102;
        CollectScene r103 = new CollectScene("PopWindow", 3, 4);
        PopWindow = r103;
        f260618a = new CollectScene[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public CollectScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
