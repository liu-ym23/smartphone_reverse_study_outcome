package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SPECIFIC_VALUE", "USER_LIST", "RECORD_CREATE_TIME", "STAGE_FIELD", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefaultValueRuleType extends Enum<DefaultValueRuleType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DefaultValueRuleType[] $VALUES = null;
    public static final a Companion = null;
    public static final DefaultValueRuleType RECORD_CREATE_TIME = null;
    public static final DefaultValueRuleType SPECIFIC_VALUE = null;
    public static final DefaultValueRuleType STAGE_FIELD = null;
    public static final DefaultValueRuleType USER_LIST = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ DefaultValueRuleType[] $values() {
        return new DefaultValueRuleType[]{SPECIFIC_VALUE, USER_LIST, RECORD_CREATE_TIME, STAGE_FIELD};
    }

    public static EnumEntries<DefaultValueRuleType> getEntries() {
        return $ENTRIES;
    }

    static {
        SPECIFIC_VALUE = new DefaultValueRuleType("SPECIFIC_VALUE", 0, "specific_value");
        USER_LIST = new DefaultValueRuleType("USER_LIST", 1, "user_list");
        RECORD_CREATE_TIME = new DefaultValueRuleType("RECORD_CREATE_TIME", 2, "record_created_time");
        STAGE_FIELD = new DefaultValueRuleType("STAGE_FIELD", 3, "stage_field");
        DefaultValueRuleType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static DefaultValueRuleType[] values() {
        return (DefaultValueRuleType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DefaultValueRuleType valueOf(String r100) {
        return (DefaultValueRuleType) r27.a.a(DefaultValueRuleType.class, r100);
    }

    private DefaultValueRuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
