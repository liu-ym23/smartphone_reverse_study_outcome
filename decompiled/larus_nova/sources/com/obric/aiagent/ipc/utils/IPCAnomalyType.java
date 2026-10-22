package com.obric.aiagent.ipc.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyType;", "", "eventValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "FAILURE", "SLOW", "FREQUENT", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IPCAnomalyType extends Enum<IPCAnomalyType> {
    public static final IPCAnomalyType FAILURE = null;
    public static final IPCAnomalyType FREQUENT = null;
    public static final IPCAnomalyType SLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPCAnomalyType[] f384717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384718b = null;
    private final String eventValue;

    public static EnumEntries<IPCAnomalyType> getEntries() {
        return f384718b;
    }

    static {
        IPCAnomalyType r100 = new IPCAnomalyType("FAILURE", 0, "failure");
        FAILURE = r100;
        IPCAnomalyType r101 = new IPCAnomalyType("SLOW", 1, "slow");
        SLOW = r101;
        IPCAnomalyType r102 = new IPCAnomalyType("FREQUENT", 2, "frequent");
        FREQUENT = r102;
        IPCAnomalyType[] r103 = {r100, r101, r102};
        f384717a = r103;
        f384718b = EnumEntriesKt.enumEntries(r103);
    }

    public static IPCAnomalyType[] values() {
        return (IPCAnomalyType[]) f384717a.clone();
    }

    public final String getEventValue() {
        return this.eventValue;
    }

    public static IPCAnomalyType valueOf(String r100) {
        return (IPCAnomalyType) r27.a.a(IPCAnomalyType.class, r100);
    }

    public IPCAnomalyType(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventValue = r102;
    }
}
