package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateTagClickEventType;", "", "", "value", "I", "getValue", "()I", "TOAST", "ROUTER", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum RateTagClickEventType extends Enum<RateTagClickEventType> {
    public static final RateTagClickEventType ROUTER = null;
    public static final RateTagClickEventType TOAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RateTagClickEventType[] f260861a = null;
    private final int value;

    public static RateTagClickEventType valueOf(String r100) {
        return (RateTagClickEventType) r27.a.a(RateTagClickEventType.class, r100);
    }

    public static RateTagClickEventType[] values() {
        return (RateTagClickEventType[]) f260861a.clone();
    }

    static {
        RateTagClickEventType r100 = new RateTagClickEventType("TOAST", 0, 1);
        TOAST = r100;
        RateTagClickEventType r101 = new RateTagClickEventType("ROUTER", 1, 2);
        ROUTER = r101;
        f260861a = new RateTagClickEventType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public RateTagClickEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
