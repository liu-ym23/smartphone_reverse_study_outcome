package com.obric.assistant.state.api.v2.core.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ACQUIRED", "RELEASED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricNetworkKeepAliveLockStateType extends Enum<ObricNetworkKeepAliveLockStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricNetworkKeepAliveLockStateType[] $VALUES = null;
    public static final ObricNetworkKeepAliveLockStateType ACQUIRED = null;
    public static final ObricNetworkKeepAliveLockStateType IDLE = null;
    public static final ObricNetworkKeepAliveLockStateType RELEASED = null;

    private static final /* synthetic */ ObricNetworkKeepAliveLockStateType[] $values() {
        return new ObricNetworkKeepAliveLockStateType[]{IDLE, ACQUIRED, RELEASED};
    }

    public static EnumEntries<ObricNetworkKeepAliveLockStateType> getEntries() {
        return $ENTRIES;
    }

    static {
        IDLE = new ObricNetworkKeepAliveLockStateType("IDLE", 0);
        ACQUIRED = new ObricNetworkKeepAliveLockStateType("ACQUIRED", 1);
        RELEASED = new ObricNetworkKeepAliveLockStateType("RELEASED", 2);
        ObricNetworkKeepAliveLockStateType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ObricNetworkKeepAliveLockStateType[] values() {
        return (ObricNetworkKeepAliveLockStateType[]) $VALUES.clone();
    }

    public static ObricNetworkKeepAliveLockStateType valueOf(String r100) {
        return (ObricNetworkKeepAliveLockStateType) a.a(ObricNetworkKeepAliveLockStateType.class, r100);
    }

    private ObricNetworkKeepAliveLockStateType(String r100, int r101) {
        super(r100, r101);
    }
}
