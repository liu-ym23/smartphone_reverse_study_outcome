package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueUserItemType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "current_user", "specific_user", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefaultValueUserItemType extends Enum<DefaultValueUserItemType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DefaultValueUserItemType[] $VALUES = null;
    public static final a Companion = null;
    public static final DefaultValueUserItemType current_user = null;
    public static final DefaultValueUserItemType specific_user = null;
    private final String value;

    private static final /* synthetic */ DefaultValueUserItemType[] $values() {
        return new DefaultValueUserItemType[]{current_user, specific_user};
    }

    public static EnumEntries<DefaultValueUserItemType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueUserItemType$a] */
    static {
        current_user = new DefaultValueUserItemType("current_user", 0, "current_user");
        specific_user = new DefaultValueUserItemType("specific_user", 1, "specific_user");
        DefaultValueUserItemType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static DefaultValueUserItemType[] values() {
        return (DefaultValueUserItemType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DefaultValueUserItemType valueOf(String r100) {
        return (DefaultValueUserItemType) r27.a.a(DefaultValueUserItemType.class, r100);
    }

    private DefaultValueUserItemType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
