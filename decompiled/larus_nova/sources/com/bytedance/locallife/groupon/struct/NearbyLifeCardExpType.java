package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardExpType;", "", "", "type", "I", "getType", "()I", "LIFECARD_EXP_RELATED_AWEME", "LIFECARD_EXP_FORCE_INSERT", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyLifeCardExpType extends Enum<NearbyLifeCardExpType> {
    public static final NearbyLifeCardExpType LIFECARD_EXP_FORCE_INSERT = null;
    public static final NearbyLifeCardExpType LIFECARD_EXP_RELATED_AWEME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyLifeCardExpType[] f258830a = null;
    private final int type;

    public static NearbyLifeCardExpType valueOf(String r100) {
        return (NearbyLifeCardExpType) r27.a.a(NearbyLifeCardExpType.class, r100);
    }

    public static NearbyLifeCardExpType[] values() {
        return (NearbyLifeCardExpType[]) f258830a.clone();
    }

    static {
        NearbyLifeCardExpType r100 = new NearbyLifeCardExpType("LIFECARD_EXP_RELATED_AWEME", 0, 0);
        LIFECARD_EXP_RELATED_AWEME = r100;
        NearbyLifeCardExpType r101 = new NearbyLifeCardExpType("LIFECARD_EXP_FORCE_INSERT", 1, 1);
        LIFECARD_EXP_FORCE_INSERT = r101;
        f258830a = new NearbyLifeCardExpType[]{r100, r101};
    }

    public final int getType() {
        return this.type;
    }

    public NearbyLifeCardExpType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
