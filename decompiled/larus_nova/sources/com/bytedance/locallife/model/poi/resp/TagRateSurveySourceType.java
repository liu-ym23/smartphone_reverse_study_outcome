package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/TagRateSurveySourceType;", "", "", "value", "I", "getValue", "()I", "TAG_RATE_SURVEY_SOURCE_TYPE_UNKNOW", "TAG_RATE_SURVEY_SOURCE_TYPE_ORDER_DETAIL", "TAG_RATE_SURVEY_SOURCE_TYPE_COMMENT_LIST", "TAG_RATE_SURVEY_SOURCE_TYPE_COI_SECOND_LAYER", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum TagRateSurveySourceType extends Enum<TagRateSurveySourceType> {
    public static final TagRateSurveySourceType TAG_RATE_SURVEY_SOURCE_TYPE_COI_SECOND_LAYER = null;
    public static final TagRateSurveySourceType TAG_RATE_SURVEY_SOURCE_TYPE_COMMENT_LIST = null;
    public static final TagRateSurveySourceType TAG_RATE_SURVEY_SOURCE_TYPE_ORDER_DETAIL = null;
    public static final TagRateSurveySourceType TAG_RATE_SURVEY_SOURCE_TYPE_UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagRateSurveySourceType[] f260865a = null;
    private final int value;

    public static TagRateSurveySourceType valueOf(String r100) {
        return (TagRateSurveySourceType) r27.a.a(TagRateSurveySourceType.class, r100);
    }

    public static TagRateSurveySourceType[] values() {
        return (TagRateSurveySourceType[]) f260865a.clone();
    }

    static {
        TagRateSurveySourceType r100 = new TagRateSurveySourceType("TAG_RATE_SURVEY_SOURCE_TYPE_UNKNOW", 0, 0);
        TAG_RATE_SURVEY_SOURCE_TYPE_UNKNOW = r100;
        TagRateSurveySourceType r101 = new TagRateSurveySourceType("TAG_RATE_SURVEY_SOURCE_TYPE_ORDER_DETAIL", 1, 1);
        TAG_RATE_SURVEY_SOURCE_TYPE_ORDER_DETAIL = r101;
        TagRateSurveySourceType r102 = new TagRateSurveySourceType("TAG_RATE_SURVEY_SOURCE_TYPE_COMMENT_LIST", 2, 20);
        TAG_RATE_SURVEY_SOURCE_TYPE_COMMENT_LIST = r102;
        TagRateSurveySourceType r103 = new TagRateSurveySourceType("TAG_RATE_SURVEY_SOURCE_TYPE_COI_SECOND_LAYER", 3, 21);
        TAG_RATE_SURVEY_SOURCE_TYPE_COI_SECOND_LAYER = r103;
        f260865a = new TagRateSurveySourceType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public TagRateSurveySourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
