package com.obric.memorydata.sdk.memory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/memory/State;", "", "<init>", "(Ljava/lang/String;I)V", "BEGIN", "SUCCESS_NEW", "SUCCESS_UPDATE", "FAILURE_ERROR", "TIMEOUT", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum State extends Enum<State> {
    public static final State BEGIN = null;
    public static final a Companion = null;
    public static final State FAILURE_ERROR = null;
    public static final State SUCCESS_NEW = null;
    public static final State SUCCESS_UPDATE = null;
    public static final State TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ State[] f397146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397147b = null;

    public static EnumEntries<State> getEntries() {
        return f397147b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.memory.State$a] */
    static {
        State r100 = new State("BEGIN", 0);
        BEGIN = r100;
        State r101 = new State("SUCCESS_NEW", 1);
        SUCCESS_NEW = r101;
        State r102 = new State("SUCCESS_UPDATE", 2);
        SUCCESS_UPDATE = r102;
        State r103 = new State("FAILURE_ERROR", 3);
        FAILURE_ERROR = r103;
        State r104 = new State("TIMEOUT", 4);
        TIMEOUT = r104;
        State[] r105 = {r100, r101, r102, r103, r104};
        f397146a = r105;
        f397147b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static State[] values() {
        return (State[]) f397146a.clone();
    }

    public static State valueOf(String r100) {
        return (State) r27.a.a(State.class, r100);
    }

    public State(String r100, int r101) {
        super(r100, r101);
    }
}
