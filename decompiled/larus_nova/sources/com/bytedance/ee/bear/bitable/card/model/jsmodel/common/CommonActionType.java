package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/CommonActionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COLOR_LIST", "BUTTON_COLOR_LIST", "GET_NEW_OPTION_ID", "GET_RANDOM_COLOR", "GET_FIELD_CONFIG_META", "GET_NEW_FIELD_ID", "GET_CURRENT_TABLE_LIST", "GET_FIELD_LIST", "GET_NEW_CONDITION_IDS", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonActionType extends Enum<CommonActionType> {
    public static final CommonActionType BUTTON_COLOR_LIST = null;
    public static final CommonActionType COLOR_LIST = null;
    public static final CommonActionType GET_CURRENT_TABLE_LIST = null;
    public static final CommonActionType GET_FIELD_CONFIG_META = null;
    public static final CommonActionType GET_FIELD_LIST = null;
    public static final CommonActionType GET_NEW_CONDITION_IDS = null;
    public static final CommonActionType GET_NEW_FIELD_ID = null;
    public static final CommonActionType GET_NEW_OPTION_ID = null;
    public static final CommonActionType GET_RANDOM_COLOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonActionType[] f207118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207119b = null;
    private final String value;

    public static EnumEntries<CommonActionType> getEntries() {
        return f207119b;
    }

    static {
        CommonActionType r100 = new CommonActionType("COLOR_LIST", 0, "ColorList");
        COLOR_LIST = r100;
        CommonActionType r101 = new CommonActionType("BUTTON_COLOR_LIST", 1, "ButtonColorList");
        BUTTON_COLOR_LIST = r101;
        CommonActionType r102 = new CommonActionType("GET_NEW_OPTION_ID", 2, "getNewOptionId");
        GET_NEW_OPTION_ID = r102;
        CommonActionType r103 = new CommonActionType("GET_RANDOM_COLOR", 3, "getRandomColor");
        GET_RANDOM_COLOR = r103;
        CommonActionType r104 = new CommonActionType("GET_FIELD_CONFIG_META", 4, "getFieldConfigMeta");
        GET_FIELD_CONFIG_META = r104;
        CommonActionType r105 = new CommonActionType("GET_NEW_FIELD_ID", 5, "getNewFieldId");
        GET_NEW_FIELD_ID = r105;
        CommonActionType r110 = new CommonActionType("GET_CURRENT_TABLE_LIST", 6, "getTableNames");
        GET_CURRENT_TABLE_LIST = r110;
        CommonActionType r111 = new CommonActionType("GET_FIELD_LIST", 7, "getFieldList");
        GET_FIELD_LIST = r111;
        CommonActionType r112 = new CommonActionType("GET_NEW_CONDITION_IDS", 8, "getNewConditionIds");
        GET_NEW_CONDITION_IDS = r112;
        CommonActionType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f207118a = r113;
        f207119b = EnumEntriesKt.enumEntries(r113);
    }

    public static CommonActionType[] values() {
        return (CommonActionType[]) f207118a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static CommonActionType valueOf(String r100) {
        return (CommonActionType) a.a(CommonActionType.class, r100);
    }

    public CommonActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
