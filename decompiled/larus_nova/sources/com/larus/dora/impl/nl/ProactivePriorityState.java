package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/nl/ProactivePriorityState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISABLED", "ENABLED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactivePriorityState extends Enum<ProactivePriorityState> {
    public static final a Companion = null;
    public static final ProactivePriorityState DISABLED = null;
    public static final ProactivePriorityState ENABLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactivePriorityState[] f336238a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336239b = null;
    private final String value;

    public static EnumEntries<ProactivePriorityState> getEntries() {
        return f336239b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.nl.ProactivePriorityState$a] */
    static {
        ProactivePriorityState r100 = new ProactivePriorityState("DISABLED", 0, "0");
        DISABLED = r100;
        ProactivePriorityState r101 = new ProactivePriorityState("ENABLED", 1, "1");
        ENABLED = r101;
        ProactivePriorityState[] r102 = {r100, r101};
        f336238a = r102;
        f336239b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ProactivePriorityState[] values() {
        return (ProactivePriorityState[]) f336238a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProactivePriorityState valueOf(String r100) {
        return (ProactivePriorityState) r27.a.a(ProactivePriorityState.class, r100);
    }

    public ProactivePriorityState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
