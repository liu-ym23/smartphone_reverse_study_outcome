package com.larus.platform.creation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/creation/CreationMultiReferenceProtocolState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEGACY", "AVAILABLE", "UNAVAILABLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationMultiReferenceProtocolState extends Enum<CreationMultiReferenceProtocolState> {
    public static final CreationMultiReferenceProtocolState AVAILABLE = null;
    public static final CreationMultiReferenceProtocolState LEGACY = null;
    public static final CreationMultiReferenceProtocolState UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationMultiReferenceProtocolState[] f365336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365337b = null;
    private final String value;

    public static EnumEntries<CreationMultiReferenceProtocolState> getEntries() {
        return f365337b;
    }

    static {
        CreationMultiReferenceProtocolState r100 = new CreationMultiReferenceProtocolState("LEGACY", 0, "legacy");
        LEGACY = r100;
        CreationMultiReferenceProtocolState r101 = new CreationMultiReferenceProtocolState("AVAILABLE", 1, "available");
        AVAILABLE = r101;
        CreationMultiReferenceProtocolState r102 = new CreationMultiReferenceProtocolState("UNAVAILABLE", 2, "unavailable");
        UNAVAILABLE = r102;
        CreationMultiReferenceProtocolState[] r103 = {r100, r101, r102};
        f365336a = r103;
        f365337b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationMultiReferenceProtocolState[] values() {
        return (CreationMultiReferenceProtocolState[]) f365336a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationMultiReferenceProtocolState valueOf(String r100) {
        return (CreationMultiReferenceProtocolState) a.a(CreationMultiReferenceProtocolState.class, r100);
    }

    public CreationMultiReferenceProtocolState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
