package com.obric.memorydata.sdk.screencapture.rule;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINS", "NOT_CONTAINS", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RectMatchRuleEnum extends Enum<RectMatchRuleEnum> {
    public static final RectMatchRuleEnum CONTAINS = null;
    public static final RectMatchRuleEnum NOT_CONTAINS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RectMatchRuleEnum[] f397275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397276b = null;

    public static EnumEntries<RectMatchRuleEnum> getEntries() {
        return f397276b;
    }

    static {
        RectMatchRuleEnum r100 = new RectMatchRuleEnum("CONTAINS", 0);
        CONTAINS = r100;
        RectMatchRuleEnum r101 = new RectMatchRuleEnum("NOT_CONTAINS", 1);
        NOT_CONTAINS = r101;
        RectMatchRuleEnum[] r102 = {r100, r101};
        f397275a = r102;
        f397276b = EnumEntriesKt.enumEntries(r102);
    }

    public static RectMatchRuleEnum[] values() {
        return (RectMatchRuleEnum[]) f397275a.clone();
    }

    public static RectMatchRuleEnum valueOf(String r100) {
        return (RectMatchRuleEnum) a.a(RectMatchRuleEnum.class, r100);
    }

    public RectMatchRuleEnum(String r100, int r101) {
        super(r100, r101);
    }
}
