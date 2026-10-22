package com.obric.assistant.wakeup.co_wakeup.dora.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "NOT_CONNECTED", "CONNECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraConnectState extends Enum<DoraConnectState> {
    public static final DoraConnectState CONNECTED = null;
    public static final DoraConnectState NA = null;
    public static final DoraConnectState NOT_CONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraConnectState[] f394444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394445b = null;

    public static EnumEntries<DoraConnectState> getEntries() {
        return f394445b;
    }

    static {
        DoraConnectState r100 = new DoraConnectState("NA", 0);
        NA = r100;
        DoraConnectState r101 = new DoraConnectState("NOT_CONNECTED", 1);
        NOT_CONNECTED = r101;
        DoraConnectState r102 = new DoraConnectState("CONNECTED", 2);
        CONNECTED = r102;
        DoraConnectState[] r103 = {r100, r101, r102};
        f394444a = r103;
        f394445b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraConnectState[] values() {
        return (DoraConnectState[]) f394444a.clone();
    }

    public static DoraConnectState valueOf(String r100) {
        return (DoraConnectState) a.a(DoraConnectState.class, r100);
    }

    public DoraConnectState(String r100, int r101) {
        super(r100, r101);
    }
}
