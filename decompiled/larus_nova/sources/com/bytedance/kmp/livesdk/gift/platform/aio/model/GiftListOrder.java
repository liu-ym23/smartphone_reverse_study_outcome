package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftListOrder;", "", "DEFAULT", "ASCENDING", "DESCENDING", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GiftListOrder extends Enum<GiftListOrder> {
    public static final GiftListOrder ASCENDING = null;
    public static final GiftListOrder DEFAULT = null;
    public static final GiftListOrder DESCENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftListOrder[] f252241a = null;

    static {
        GiftListOrder r100 = new GiftListOrder("DEFAULT", 0);
        DEFAULT = r100;
        GiftListOrder r101 = new GiftListOrder("ASCENDING", 1);
        ASCENDING = r101;
        GiftListOrder r102 = new GiftListOrder("DESCENDING", 2);
        DESCENDING = r102;
        f252241a = new GiftListOrder[]{r100, r101, r102};
    }

    public static GiftListOrder valueOf(String r100) {
        return (GiftListOrder) a.a(GiftListOrder.class, r100);
    }

    public static GiftListOrder[] values() {
        return (GiftListOrder[]) f252241a.clone();
    }

    public GiftListOrder(String r100, int r101) {
        super(r100, r101);
    }
}
