package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricAssistantAliveLockStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ACQUIRED", "RELEASED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAssistantAliveLockStateType extends Enum<ObricAssistantAliveLockStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricAssistantAliveLockStateType[] $VALUES = null;
    public static final ObricAssistantAliveLockStateType ACQUIRED = null;
    public static final ObricAssistantAliveLockStateType IDLE = null;
    public static final ObricAssistantAliveLockStateType RELEASED = null;

    private static final /* synthetic */ ObricAssistantAliveLockStateType[] $values() {
        return new ObricAssistantAliveLockStateType[]{IDLE, ACQUIRED, RELEASED};
    }

    public static EnumEntries<ObricAssistantAliveLockStateType> getEntries() {
        return $ENTRIES;
    }

    static {
        IDLE = new ObricAssistantAliveLockStateType("IDLE", 0);
        ACQUIRED = new ObricAssistantAliveLockStateType("ACQUIRED", 1);
        RELEASED = new ObricAssistantAliveLockStateType("RELEASED", 2);
        ObricAssistantAliveLockStateType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ObricAssistantAliveLockStateType[] values() {
        return (ObricAssistantAliveLockStateType[]) $VALUES.clone();
    }

    public static ObricAssistantAliveLockStateType valueOf(String r100) {
        return (ObricAssistantAliveLockStateType) a.a(ObricAssistantAliveLockStateType.class, r100);
    }

    private ObricAssistantAliveLockStateType(String r100, int r101) {
        super(r100, r101);
    }
}
