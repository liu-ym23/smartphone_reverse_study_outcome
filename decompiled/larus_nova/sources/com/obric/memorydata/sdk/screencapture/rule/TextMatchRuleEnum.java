package com.obric.memorydata.sdk.screencapture.rule;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "EQUALS", "CONTAINS", "REGEX", "WILDCARD", "NOT_CONTAINS", "CHANGED", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextMatchRuleEnum extends Enum<TextMatchRuleEnum> {
    public static final TextMatchRuleEnum CHANGED = null;
    public static final TextMatchRuleEnum CONTAINS = null;
    public static final TextMatchRuleEnum EQUALS = null;
    public static final TextMatchRuleEnum NOT_CONTAINS = null;
    public static final TextMatchRuleEnum REGEX = null;
    public static final TextMatchRuleEnum WILDCARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextMatchRuleEnum[] f397291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397292b = null;

    public static EnumEntries<TextMatchRuleEnum> getEntries() {
        return f397292b;
    }

    static {
        TextMatchRuleEnum r100 = new TextMatchRuleEnum("EQUALS", 0);
        EQUALS = r100;
        TextMatchRuleEnum r101 = new TextMatchRuleEnum("CONTAINS", 1);
        CONTAINS = r101;
        TextMatchRuleEnum r102 = new TextMatchRuleEnum("REGEX", 2);
        REGEX = r102;
        TextMatchRuleEnum r103 = new TextMatchRuleEnum("WILDCARD", 3);
        WILDCARD = r103;
        TextMatchRuleEnum r104 = new TextMatchRuleEnum("NOT_CONTAINS", 4);
        NOT_CONTAINS = r104;
        TextMatchRuleEnum r105 = new TextMatchRuleEnum("CHANGED", 5);
        CHANGED = r105;
        TextMatchRuleEnum[] r110 = {r100, r101, r102, r103, r104, r105};
        f397291a = r110;
        f397292b = EnumEntriesKt.enumEntries(r110);
    }

    public static TextMatchRuleEnum[] values() {
        return (TextMatchRuleEnum[]) f397291a.clone();
    }

    public static TextMatchRuleEnum valueOf(String r100) {
        return (TextMatchRuleEnum) a.a(TextMatchRuleEnum.class, r100);
    }

    public TextMatchRuleEnum(String r100, int r101) {
        super(r100, r101);
    }
}
