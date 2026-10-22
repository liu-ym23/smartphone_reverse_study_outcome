package com.bytedance.locallife.model.poi.resp;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateCommonTagType;", "", "", "value", "I", "getValue", "()I", "IMAGE", CardAdapter.TEXT, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum RateCommonTagType extends Enum<RateCommonTagType> {
    public static final RateCommonTagType IMAGE = null;
    public static final RateCommonTagType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RateCommonTagType[] f260859a = null;
    private final int value;

    public static RateCommonTagType valueOf(String r100) {
        return (RateCommonTagType) r27.a.a(RateCommonTagType.class, r100);
    }

    public static RateCommonTagType[] values() {
        return (RateCommonTagType[]) f260859a.clone();
    }

    static {
        RateCommonTagType r100 = new RateCommonTagType("IMAGE", 0, 1);
        IMAGE = r100;
        RateCommonTagType r101 = new RateCommonTagType(CardAdapter.TEXT, 1, 2);
        TEXT = r101;
        f260859a = new RateCommonTagType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public RateCommonTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
