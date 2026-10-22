package com.ss.android.lark.forseti.chain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STOPPED", "STARTED", "RESUMED", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForsetiChainState extends Enum<ForsetiChainState> {
    public static final ForsetiChainState RESUMED = null;
    public static final ForsetiChainState STARTED = null;
    public static final ForsetiChainState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForsetiChainState[] f424359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424360b = null;
    private final int value;

    public static EnumEntries<ForsetiChainState> getEntries() {
        return f424360b;
    }

    static {
        ForsetiChainState r100 = new ForsetiChainState("STOPPED", 0, 1);
        STOPPED = r100;
        ForsetiChainState r101 = new ForsetiChainState("STARTED", 1, 2);
        STARTED = r101;
        ForsetiChainState r102 = new ForsetiChainState("RESUMED", 2, 3);
        RESUMED = r102;
        ForsetiChainState[] r103 = {r100, r101, r102};
        f424359a = r103;
        f424360b = EnumEntriesKt.enumEntries(r103);
    }

    public static ForsetiChainState[] values() {
        return (ForsetiChainState[]) f424359a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForsetiChainState valueOf(String r100) {
        return (ForsetiChainState) r27.a.a(ForsetiChainState.class, r100);
    }

    public ForsetiChainState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
