package com.obric.assistant.settings.memory;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySwitchGroup;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.MAIN, "CHILD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricReferenceMemorySwitchGroup extends Enum<ObricReferenceMemorySwitchGroup> {
    public static final ObricReferenceMemorySwitchGroup CHILD = null;
    public static final ObricReferenceMemorySwitchGroup MAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricReferenceMemorySwitchGroup[] f392180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392181b = null;

    public static EnumEntries<ObricReferenceMemorySwitchGroup> getEntries() {
        return f392181b;
    }

    static {
        ObricReferenceMemorySwitchGroup r100 = new ObricReferenceMemorySwitchGroup(AccountType.MAIN, 0);
        MAIN = r100;
        ObricReferenceMemorySwitchGroup r101 = new ObricReferenceMemorySwitchGroup("CHILD", 1);
        CHILD = r101;
        ObricReferenceMemorySwitchGroup[] r102 = {r100, r101};
        f392180a = r102;
        f392181b = EnumEntriesKt.enumEntries(r102);
    }

    public static ObricReferenceMemorySwitchGroup[] values() {
        return (ObricReferenceMemorySwitchGroup[]) f392180a.clone();
    }

    public static ObricReferenceMemorySwitchGroup valueOf(String r100) {
        return (ObricReferenceMemorySwitchGroup) r27.a.a(ObricReferenceMemorySwitchGroup.class, r100);
    }

    public ObricReferenceMemorySwitchGroup(String r100, int r101) {
        super(r100, r101);
    }
}
