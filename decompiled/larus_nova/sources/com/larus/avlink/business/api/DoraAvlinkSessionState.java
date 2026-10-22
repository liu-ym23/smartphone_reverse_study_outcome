package com.larus.avlink.business.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/business/api/DoraAvlinkSessionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "WAITING", "THINKING", "LISTENING", "SPEAKING", "STOPPED", "CONV_STOPPED", "dora_business_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkSessionState extends Enum<DoraAvlinkSessionState> {
    public static final DoraAvlinkSessionState CONV_STOPPED = null;
    public static final DoraAvlinkSessionState LISTENING = null;
    public static final DoraAvlinkSessionState SPEAKING = null;
    public static final DoraAvlinkSessionState STOPPED = null;
    public static final DoraAvlinkSessionState THINKING = null;
    public static final DoraAvlinkSessionState UNKNOWN = null;
    public static final DoraAvlinkSessionState WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkSessionState[] f291704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291705b = null;

    public static EnumEntries<DoraAvlinkSessionState> getEntries() {
        return f291705b;
    }

    static {
        DoraAvlinkSessionState r100 = new DoraAvlinkSessionState("UNKNOWN", 0);
        UNKNOWN = r100;
        DoraAvlinkSessionState r101 = new DoraAvlinkSessionState("WAITING", 1);
        WAITING = r101;
        DoraAvlinkSessionState r102 = new DoraAvlinkSessionState("THINKING", 2);
        THINKING = r102;
        DoraAvlinkSessionState r103 = new DoraAvlinkSessionState("LISTENING", 3);
        LISTENING = r103;
        DoraAvlinkSessionState r104 = new DoraAvlinkSessionState("SPEAKING", 4);
        SPEAKING = r104;
        DoraAvlinkSessionState r105 = new DoraAvlinkSessionState("STOPPED", 5);
        STOPPED = r105;
        DoraAvlinkSessionState r110 = new DoraAvlinkSessionState("CONV_STOPPED", 6);
        CONV_STOPPED = r110;
        DoraAvlinkSessionState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f291704a = r111;
        f291705b = EnumEntriesKt.enumEntries(r111);
    }

    public static DoraAvlinkSessionState[] values() {
        return (DoraAvlinkSessionState[]) f291704a.clone();
    }

    public static DoraAvlinkSessionState valueOf(String r100) {
        return (DoraAvlinkSessionState) a.a(DoraAvlinkSessionState.class, r100);
    }

    public DoraAvlinkSessionState(String r100, int r101) {
        super(r100, r101);
    }
}
