package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/BidSource;", "", "", "value", "I", "getValue", "()I", "Config", "Schema", "Custom", "Default", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum BidSource extends Enum<BidSource> {
    public static final BidSource Config = null;
    public static final BidSource Custom = null;
    public static final BidSource Default = null;
    public static final BidSource Schema = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BidSource[] f267869a = null;
    private final int value;

    public static BidSource valueOf(String r100) {
        return (BidSource) r27.a.a(BidSource.class, r100);
    }

    public static BidSource[] values() {
        return (BidSource[]) f267869a.clone();
    }

    static {
        BidSource r100 = new BidSource("Config", 0, 0);
        Config = r100;
        BidSource r101 = new BidSource("Schema", 1, 1);
        Schema = r101;
        BidSource r102 = new BidSource("Custom", 2, 2);
        Custom = r102;
        BidSource r103 = new BidSource("Default", 3, 3);
        Default = r103;
        f267869a = new BidSource[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public BidSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
