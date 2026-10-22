package com.larus.dora.impl.frameassembler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/frameassembler/DoraIncompleteReason;", "", "<init>", "(Ljava/lang/String;I)V", "TIMEOUT", "TOTAL_SEQ_MISMATCH", "RESOURCE_LIMIT", "EXPLICIT_CLOSE", "SEQ_MISMATCH", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraIncompleteReason extends Enum<DoraIncompleteReason> {
    public static final DoraIncompleteReason EXPLICIT_CLOSE = null;
    public static final DoraIncompleteReason RESOURCE_LIMIT = null;
    public static final DoraIncompleteReason SEQ_MISMATCH = null;
    public static final DoraIncompleteReason TIMEOUT = null;
    public static final DoraIncompleteReason TOTAL_SEQ_MISMATCH = null;
    public static final DoraIncompleteReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraIncompleteReason[] f335780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335781b = null;

    public static EnumEntries<DoraIncompleteReason> getEntries() {
        return f335781b;
    }

    static {
        DoraIncompleteReason r100 = new DoraIncompleteReason("TIMEOUT", 0);
        TIMEOUT = r100;
        DoraIncompleteReason r101 = new DoraIncompleteReason("TOTAL_SEQ_MISMATCH", 1);
        TOTAL_SEQ_MISMATCH = r101;
        DoraIncompleteReason r102 = new DoraIncompleteReason("RESOURCE_LIMIT", 2);
        RESOURCE_LIMIT = r102;
        DoraIncompleteReason r103 = new DoraIncompleteReason("EXPLICIT_CLOSE", 3);
        EXPLICIT_CLOSE = r103;
        DoraIncompleteReason r104 = new DoraIncompleteReason("SEQ_MISMATCH", 4);
        SEQ_MISMATCH = r104;
        DoraIncompleteReason r105 = new DoraIncompleteReason("UNKNOWN", 5);
        UNKNOWN = r105;
        DoraIncompleteReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f335780a = r110;
        f335781b = EnumEntriesKt.enumEntries(r110);
    }

    public static DoraIncompleteReason[] values() {
        return (DoraIncompleteReason[]) f335780a.clone();
    }

    public static DoraIncompleteReason valueOf(String r100) {
        return (DoraIncompleteReason) r27.a.a(DoraIncompleteReason.class, r100);
    }

    public DoraIncompleteReason(String r100, int r101) {
        super(r100, r101);
    }
}
