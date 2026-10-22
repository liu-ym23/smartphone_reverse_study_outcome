package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/forest/model/ForestEnvType;", "", "(Ljava/lang/String;I)V", "PPE", "BOE", "forest_release"}, k = 1, mv = {1, 1, 16})
public final enum ForestEnvType extends Enum<ForestEnvType> {
    private static final /* synthetic */ ForestEnvType[] $VALUES = null;
    public static final ForestEnvType BOE = null;
    public static final ForestEnvType PPE = null;

    static {
        ForestEnvType r100 = new ForestEnvType("PPE", 0);
        PPE = r100;
        ForestEnvType r101 = new ForestEnvType("BOE", 1);
        BOE = r101;
        $VALUES = new ForestEnvType[]{r100, r101};
    }

    public static ForestEnvType valueOf(String r100) {
        return (ForestEnvType) r27.a.a(ForestEnvType.class, r100);
    }

    public static ForestEnvType[] values() {
        return (ForestEnvType[]) $VALUES.clone();
    }

    private ForestEnvType(String r100, int r101) {
        super(r100, r101);
    }
}
