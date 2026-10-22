package com.bytedance.gamecenter.base.order.preres;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GResType;", "", "", "type", "I", "getType", "()I", "RES_TYPE_UNKNOWN", "RES_TYPE_TENCENT", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum GResType extends Enum<GResType> {
    public static final GResType RES_TYPE_TENCENT = null;
    public static final GResType RES_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GResType[] f245044a = null;
    private final int type;

    static {
        GResType r100 = new GResType("RES_TYPE_UNKNOWN", 0, 0);
        RES_TYPE_UNKNOWN = r100;
        GResType r101 = new GResType("RES_TYPE_TENCENT", 1, 1);
        RES_TYPE_TENCENT = r101;
        f245044a = new GResType[]{r100, r101};
    }

    public static GResType valueOf(String r100) {
        return (GResType) a.a(GResType.class, r100);
    }

    public static GResType[] values() {
        return (GResType[]) f245044a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public GResType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
