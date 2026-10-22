package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/TagRateFreqLimitActionType;", "", "", "value", "I", "getValue", "()I", "TAG_RATE_FREQ_LIMIT_ACTION_TYPE_UNKNOWN", "TAG_RATE_FREQ_LIMIT_ACTION_TYPE_CLOSE", "TAG_RATE_FREQ_LIMIT_ACTION_TYPE_IGNORE", "TAG_RATE_FREQ_LIMIT_ACTION_TYPE_AFTER_IGNORE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum TagRateFreqLimitActionType extends Enum<TagRateFreqLimitActionType> {
    public static final TagRateFreqLimitActionType TAG_RATE_FREQ_LIMIT_ACTION_TYPE_AFTER_IGNORE = null;
    public static final TagRateFreqLimitActionType TAG_RATE_FREQ_LIMIT_ACTION_TYPE_CLOSE = null;
    public static final TagRateFreqLimitActionType TAG_RATE_FREQ_LIMIT_ACTION_TYPE_IGNORE = null;
    public static final TagRateFreqLimitActionType TAG_RATE_FREQ_LIMIT_ACTION_TYPE_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagRateFreqLimitActionType[] f260864a = null;
    private final int value;

    public static TagRateFreqLimitActionType valueOf(String r100) {
        return (TagRateFreqLimitActionType) r27.a.a(TagRateFreqLimitActionType.class, r100);
    }

    public static TagRateFreqLimitActionType[] values() {
        return (TagRateFreqLimitActionType[]) f260864a.clone();
    }

    static {
        TagRateFreqLimitActionType r100 = new TagRateFreqLimitActionType("TAG_RATE_FREQ_LIMIT_ACTION_TYPE_UNKNOWN", 0, 0);
        TAG_RATE_FREQ_LIMIT_ACTION_TYPE_UNKNOWN = r100;
        TagRateFreqLimitActionType r101 = new TagRateFreqLimitActionType("TAG_RATE_FREQ_LIMIT_ACTION_TYPE_CLOSE", 1, 1);
        TAG_RATE_FREQ_LIMIT_ACTION_TYPE_CLOSE = r101;
        TagRateFreqLimitActionType r102 = new TagRateFreqLimitActionType("TAG_RATE_FREQ_LIMIT_ACTION_TYPE_IGNORE", 2, 2);
        TAG_RATE_FREQ_LIMIT_ACTION_TYPE_IGNORE = r102;
        TagRateFreqLimitActionType r103 = new TagRateFreqLimitActionType("TAG_RATE_FREQ_LIMIT_ACTION_TYPE_AFTER_IGNORE", 3, 3);
        TAG_RATE_FREQ_LIMIT_ACTION_TYPE_AFTER_IGNORE = r103;
        f260864a = new TagRateFreqLimitActionType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public TagRateFreqLimitActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
