package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateTagSplitType;", "", "", "type", "I", "getType", "()I", "TYPE_WHITE_SPACE", "TYPE_VERTICAL_LINE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum RateTagSplitType extends Enum<RateTagSplitType> {
    public static final RateTagSplitType TYPE_VERTICAL_LINE = null;
    public static final RateTagSplitType TYPE_WHITE_SPACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RateTagSplitType[] f260862a = null;
    private final int type;

    public static RateTagSplitType valueOf(String r100) {
        return (RateTagSplitType) r27.a.a(RateTagSplitType.class, r100);
    }

    public static RateTagSplitType[] values() {
        return (RateTagSplitType[]) f260862a.clone();
    }

    static {
        RateTagSplitType r100 = new RateTagSplitType("TYPE_WHITE_SPACE", 0, 0);
        TYPE_WHITE_SPACE = r100;
        RateTagSplitType r101 = new RateTagSplitType("TYPE_VERTICAL_LINE", 1, 1);
        TYPE_VERTICAL_LINE = r101;
        f260862a = new RateTagSplitType[]{r100, r101};
    }

    public final int getType() {
        return this.type;
    }

    public RateTagSplitType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
