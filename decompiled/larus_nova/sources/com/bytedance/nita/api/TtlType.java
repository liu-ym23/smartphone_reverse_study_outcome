package com.bytedance.nita.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/nita/api/TtlType;", "", "", "delay", "J", "getDelay", "()J", "INFINITE", "SHORT", "LONG", "ACTIVITY_DESTORY", "core_release"}, k = 1, mv = {1, 4, 0})
public final enum TtlType extends Enum<TtlType> {
    public static final TtlType ACTIVITY_DESTORY = null;
    public static final TtlType INFINITE = null;
    public static final TtlType LONG = null;
    public static final TtlType SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtlType[] f265993a = null;
    private final long delay;

    static {
        TtlType r100 = new TtlType("INFINITE", 0, 0);
        INFINITE = r100;
        TtlType r101 = new TtlType("SHORT", 1, 15000);
        SHORT = r101;
        TtlType r102 = new TtlType("LONG", 2, 60000);
        LONG = r102;
        TtlType r103 = new TtlType("ACTIVITY_DESTORY", 3, -1);
        ACTIVITY_DESTORY = r103;
        f265993a = new TtlType[]{r100, r101, r102, r103};
    }

    public static TtlType valueOf(String r100) {
        return (TtlType) r27.a.a(TtlType.class, r100);
    }

    public static TtlType[] values() {
        return (TtlType[]) f265993a.clone();
    }

    public final long getDelay() {
        return this.delay;
    }

    public TtlType(String r100, int r101, long r102) {
        super(r100, r101);
        this.delay = r102;
    }
}
