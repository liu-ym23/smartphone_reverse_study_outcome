package com.bytedance.locallife.live.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/live/model/CollectSource;", "", "", "value", "I", "getValue", "()I", "ShortTouchBigCard", "ShortTouchSmallCard", "ShortTouchWindowBtn", "AggCard", "ComponentCardBtn", "ComponentCardContent", "ShowingCardBtn", "ShowingCardContent", "AutoCollectByEnterRoom", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CollectSource extends Enum<CollectSource> {
    public static final CollectSource AggCard = null;
    public static final CollectSource AutoCollectByEnterRoom = null;
    public static final CollectSource ComponentCardBtn = null;
    public static final CollectSource ComponentCardContent = null;
    public static final CollectSource ShortTouchBigCard = null;
    public static final CollectSource ShortTouchSmallCard = null;
    public static final CollectSource ShortTouchWindowBtn = null;
    public static final CollectSource ShowingCardBtn = null;
    public static final CollectSource ShowingCardContent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollectSource[] f260619a = null;
    private final int value;

    public static CollectSource valueOf(String r100) {
        return (CollectSource) a.a(CollectSource.class, r100);
    }

    public static CollectSource[] values() {
        return (CollectSource[]) f260619a.clone();
    }

    static {
        CollectSource r100 = new CollectSource("ShortTouchBigCard", 0, 1);
        ShortTouchBigCard = r100;
        CollectSource r101 = new CollectSource("ShortTouchSmallCard", 1, 2);
        ShortTouchSmallCard = r101;
        CollectSource r102 = new CollectSource("ShortTouchWindowBtn", 2, 3);
        ShortTouchWindowBtn = r102;
        CollectSource r103 = new CollectSource("AggCard", 3, 4);
        AggCard = r103;
        CollectSource r104 = new CollectSource("ComponentCardBtn", 4, 5);
        ComponentCardBtn = r104;
        CollectSource r110 = new CollectSource("ComponentCardContent", 5, 6);
        ComponentCardContent = r110;
        CollectSource r111 = new CollectSource("ShowingCardBtn", 6, 7);
        ShowingCardBtn = r111;
        CollectSource r112 = new CollectSource("ShowingCardContent", 7, 8);
        ShowingCardContent = r112;
        CollectSource r113 = new CollectSource("AutoCollectByEnterRoom", 8, 10);
        AutoCollectByEnterRoom = r113;
        f260619a = new CollectSource[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public CollectSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
