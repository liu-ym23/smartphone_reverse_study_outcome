package com.obric.memorydata.sdk.screencapture.rule;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "AND", "EXPRESSION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum KeywordsMatchRuleEnum extends Enum<KeywordsMatchRuleEnum> {
    public static final KeywordsMatchRuleEnum AND = null;
    public static final KeywordsMatchRuleEnum EXPRESSION = null;
    public static final KeywordsMatchRuleEnum OR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeywordsMatchRuleEnum[] f397273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397274b = null;

    public static EnumEntries<KeywordsMatchRuleEnum> getEntries() {
        return f397274b;
    }

    static {
        KeywordsMatchRuleEnum r100 = new KeywordsMatchRuleEnum("OR", 0);
        OR = r100;
        KeywordsMatchRuleEnum r101 = new KeywordsMatchRuleEnum("AND", 1);
        AND = r101;
        KeywordsMatchRuleEnum r102 = new KeywordsMatchRuleEnum("EXPRESSION", 2);
        EXPRESSION = r102;
        KeywordsMatchRuleEnum[] r103 = {r100, r101, r102};
        f397273a = r103;
        f397274b = EnumEntriesKt.enumEntries(r103);
    }

    public static KeywordsMatchRuleEnum[] values() {
        return (KeywordsMatchRuleEnum[]) f397273a.clone();
    }

    public static KeywordsMatchRuleEnum valueOf(String r100) {
        return (KeywordsMatchRuleEnum) a.a(KeywordsMatchRuleEnum.class, r100);
    }

    public KeywordsMatchRuleEnum(String r100, int r101) {
        super(r100, r101);
    }
}
