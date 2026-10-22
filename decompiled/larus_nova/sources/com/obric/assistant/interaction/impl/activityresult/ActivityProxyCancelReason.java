package com.obric.assistant.interaction.impl.activityresult;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "", "<init>", "(Ljava/lang/String;I)V", "START_REPLACED", "TIMEOUT_BEFORE_ON_CREATE", "PROXY_DESTROYED_BEFORE_RESULT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActivityProxyCancelReason extends Enum<ActivityProxyCancelReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ActivityProxyCancelReason[] $VALUES = null;
    public static final ActivityProxyCancelReason PROXY_DESTROYED_BEFORE_RESULT = null;
    public static final ActivityProxyCancelReason START_REPLACED = null;
    public static final ActivityProxyCancelReason TIMEOUT_BEFORE_ON_CREATE = null;

    private static final /* synthetic */ ActivityProxyCancelReason[] $values() {
        return new ActivityProxyCancelReason[]{START_REPLACED, TIMEOUT_BEFORE_ON_CREATE, PROXY_DESTROYED_BEFORE_RESULT};
    }

    public static EnumEntries<ActivityProxyCancelReason> getEntries() {
        return $ENTRIES;
    }

    static {
        START_REPLACED = new ActivityProxyCancelReason("START_REPLACED", 0);
        TIMEOUT_BEFORE_ON_CREATE = new ActivityProxyCancelReason("TIMEOUT_BEFORE_ON_CREATE", 1);
        PROXY_DESTROYED_BEFORE_RESULT = new ActivityProxyCancelReason("PROXY_DESTROYED_BEFORE_RESULT", 2);
        ActivityProxyCancelReason[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ActivityProxyCancelReason[] values() {
        return (ActivityProxyCancelReason[]) $VALUES.clone();
    }

    public static ActivityProxyCancelReason valueOf(String r100) {
        return (ActivityProxyCancelReason) r27.a.a(ActivityProxyCancelReason.class, r100);
    }

    private ActivityProxyCancelReason(String r100, int r101) {
        super(r100, r101);
    }
}
